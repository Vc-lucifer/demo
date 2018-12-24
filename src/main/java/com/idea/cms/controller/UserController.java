package com.idea.cms.controller;

import com.idea.cms.entity.User;
import com.idea.cms.services.UserService;
import com.idea.cms.transport.exception.BeileException;
import com.idea.cms.transport.InvokerResult;
import com.idea.cms.utils.Base64Utils;
import com.idea.cms.utils.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @author Time
 */
@RestController
@RequestMapping(value = Path.USER)
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Resource
    private RedisUtil redisUtil;




    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @RequestMapping(value = Path.LOGIN, method = RequestMethod.POST)
    public InvokerResult managerLogin(@RequestParam(value = "username") String username,
                                      @RequestParam(value = "password") String password) {
        InvokerResult result = new InvokerResult();
        try {
            User manager = userService.login(username, Base64Utils.encodeBase64(password));
            result.setResultData(manager);

        } catch (BeileException e) {
            result = e.toInvokerResult();
        }
        return result;

    }

    /**
     *
     * 用户编辑/注册
     * @param user 用户
     * @return
     */
    @RequestMapping(value = "addUser",method = RequestMethod.POST)
    public InvokerResult addUser(@RequestBody User user){
        InvokerResult result = new InvokerResult();
        try {
            User save = userService.addUser(user);
            result.setResultData(save);
        }catch (BeileException e){
            result = e.toInvokerResult();
        }catch (Exception ex){
            result.setResultContent(ex.toString());
        }
        return result;
    }


    /**
     * set redis
     * RedisTemplate
     * @param user
     * @return
     */
/*    @RequestMapping(value = "addRedis",method = RequestMethod.POST)
    public InvokerResult addRedis(@RequestBody User user){
        InvokerResult result = new InvokerResult();
        ValueOperations valueOperations = redisTemplate.opsForValue();
        try {
            valueOperations.set(user.userName, user);
        }catch (BeileException e){
            result = e.toInvokerResult();
        }catch (Exception ex){
            result.setResultContent(ex.toString());
        }
        return result;
    }*/

    /**
     * get redis value by key
     * RedisTemplate
     * @param user
     * @return
     */
    /*
    @RequestMapping(value = "getRedis",method = RequestMethod.POST)
    public InvokerResult getRedis(@RequestBody User user){
        InvokerResult result = new InvokerResult();
        ValueOperations valueOperations = redisTemplate.opsForValue();
        try {
            Object s = valueOperations.get(user.userName);
            result.setResultData(s);
        }catch (BeileException e){
            result = e.toInvokerResult();
        }catch (Exception ex){
            result.setResultContent(ex.toString());
        }
        return result;
    }*/

    @RequestMapping(value = "addRedis",method = RequestMethod.POST)
    public InvokerResult addRedis(@RequestBody User user){
        InvokerResult result = new InvokerResult();
        try {
            redisUtil.setexObj("001",100000,user);
            User redis = redisUtil.getObj("001", User.class);
            result.setResultData(redis);
//            redisUtil.set("8080","这是redis基础存储测试");
//            System.out.println(redisUtil.get("8080"));
        }catch (BeileException e){
            result = e.toInvokerResult();
        }catch (Exception ex){
            result.setResultContent(ex.toString());
        }
        return result;
    }

}
