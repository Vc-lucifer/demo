package com.idea.cms.entity;


import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.util.Date;


/**
 * @author Time
 */
@Entity
@Table(name="user")
public class User implements Serializable {
	private static final long serialVersionUID = -5809782578272943999L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="user_id")
	public int userId;
	public String userName;
	public String password;
	public String email;
	public String lastLoginIp;
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	public Date   lastLoginTime;
	public String lastLoginAddress;
	public int deleteflag;
	public int status;
	public int logs;
	public Date createTime;
	public String createBy;
	public Date updateTime;
	public String updateBy;
	
	public User(){
		
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
