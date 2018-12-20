/**
 * 
 */
package com.bucom.boot.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * @author zhailiang
 *
 */
@Data

public class UserOn {


	private String userName;
	private String password;






}