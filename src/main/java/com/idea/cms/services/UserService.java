package com.idea.cms.services;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.idea.cms.dao.UserDao;
import com.idea.cms.entity.User;
import com.idea.cms.transport.exception.CMSException;
import com.idea.cms.utils.Base64Utils;
import com.idea.cms.utils.redis.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static com.idea.cms.transport.exception.CMSException.ErrorBaseEnum.ERR_BASE_FAIL_INSERT;
import static com.idea.cms.transport.exception.CMSException.ErrorBaseEnum.ERR_BASE_LOGIN;
import static com.idea.cms.transport.exception.CMSException.ErrorBaseEnum.ERR_BASE_NOT_LOGIN;

/**
 * @author Time
 */
@SuppressWarnings("ALL")
@Service
public class UserService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserDao userDao;

    @Resource
    private RedisUtil redisUtil;

    @Value("${app.loginTimeoutSecs:10800}")
    private int loginTimeoutSecs;

    private Cache<String, User> loginUsers;

    @PostConstruct
    public void init() {
        loginUsers = CacheBuilder.newBuilder().maximumSize(1000).expireAfterAccess(loginTimeoutSecs, TimeUnit.SECONDS).build();
    }

    /**
     * @param token
     * @return BestManager 管理员实体信息
     * 根据token获取cache中的管理员实体信息
     */
    public User getLoginUser(String token) {

        User account = loginUsers.getIfPresent(token);

        if (account == null) {
            CMSException exception = new CMSException(ERR_BASE_NOT_LOGIN);
            logger.error(exception.getResultContent());
            throw exception;
        }

        return account;
    }

    /**
     * 管理员登录
     *
     * @param phone（username）
     * @param password
     * @return map{token,manager,permission}
     */
    public User login(String phone, String password){
        //根据用户名和密码找到Manager
        User manager = userDao.findByUserNameAndPassword(phone, password);
        if (manager == null) {
            CMSException exception = new CMSException(ERR_BASE_LOGIN);
            logger.warn(exception.getResultContent());
            throw exception;
        }
        //更新登录时间
        manager.lastLoginTime = new Date();
        userDao.save(manager);
        //用户放入缓存
        loginUsers.put(manager.userName, manager);
        logger.info("用户{}登录成功",manager.userName);
        return manager;
    }

    public void getRedis(){
        redisUtil.setEx("admin","user",18000);
        if (redisUtil==null){
            this.logger.error("redis未注入");
        }
        while (StringUtils.isEmpty(logger)){
            logger.info("");
        }
    }

    /**
     *
     * 注册/编辑用户
     * @param user
     * @return user
     */
    public User addUser(User user){
        if (StringUtils.isEmpty(user.userName)){
            CMSException exception = new CMSException(ERR_BASE_FAIL_INSERT);
            logger.info(exception.getResultContent());
            throw exception;
        }
        if (StringUtils.isEmpty(user.password)){
            throw new CMSException(ERR_BASE_FAIL_INSERT);
        }
        user.password = Base64Utils.encodeBase64(user.password);
        User save = userDao.save(user);
        return save;
    }

}
