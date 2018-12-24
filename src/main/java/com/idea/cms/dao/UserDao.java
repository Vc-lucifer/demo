package com.idea.cms.dao;


import com.idea.cms.entity.User;
import org.springframework.data.repository.CrudRepository;


/**
 * @author Time
 */
public interface UserDao extends CrudRepository<User, Integer> {
	/**
	 * 根据用户名和密码
	 *
	 * @param userName 用户名称
	 * @param password 用户密码
	 * @return User
	 */
	User findByUserNameAndPassword(String userName,String password);
}

