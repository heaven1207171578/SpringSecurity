/**
 * 
 */
package com.bucom.boot.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * @author zhailiang
 *
 */
@Data
@Entity
@ToString
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "主键" )
	private  String id;
	@ApiModelProperty(value = "用户名" )
	private String userName;
	@ApiModelProperty(value = "密码" )
	private String password;
	@ApiModelProperty(value = "生日" )
	private Long birthday;
	@ApiModelProperty(value = "权限" )
	private String role;
	@ApiModelProperty(value = "令牌" )
	private String token;






}