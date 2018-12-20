package com.bucom.boot.controller;
import java.util.HashMap;
import java.util.Map;
import com.bucom.boot.config.JSONData;
import com.bucom.boot.model.User;
import com.bucom.boot.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;

@RestController

public class UserController {
	private Logger log=LoggerFactory.getLogger(getClass());
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@ApiOperation(value="获取用户",notes="获取用户")
	@RequestMapping(value="/query",method=RequestMethod.POST)
	public JSONData quertUser(@RequestBody User user) {
		//System.out.println("用户名"+user.getUserName());
		JSONData jsonData=new JSONData();
		User u = userServiceImpl.queryLogin(user.getUserName());
//    	System.out.println(u.toString());
		Map<String,Object>map=new HashMap<>();
		if (null!=u){
				map.put("user",user);
				jsonData.setBody(map);
				jsonData.setSuccess(JSONData.TRUE);
				return jsonData;
		}
		jsonData.setSuccess(JSONData.FALSE);
		jsonData.setErrMsg("没有查询到用户");
		return jsonData;
	}

	/**
	 *
	 * @param mapUser 前台是个单个参数 并且后台无法拼成一个对象时,
	 *                使用@RequestBody Map<String,Object>mapUser来接收payload方式(contentType:"application/json;charset=UTF-8")的ajax发送的data的json字符串;
	 *                前台是的json中的所有key可以对应后台的一个对象的部分属性(前台的JSON串中的key可以不用全部都对应后台的对象,但是必须Key要对应对象中的属性名),
	 *                使用@RequestBody Object obj来接收;
	 *
	 * @return
	 */
	@ApiOperation(value="获取用户",notes="获取用户")
	@RequestMapping(value="/queryParamer",method=RequestMethod.POST)//@RequestBody String userName,String pwd, HttpServletRequest request
	public JSONData quertParamer(@RequestBody Map<String,Object>mapUser) {
		//String s = request.getParameter("userName");
		String userName = (String) mapUser.get("userName");
		String pwd = (String) mapUser.get("pwd");
		JSONData jsonData=new JSONData();
		Map<String,Object>map=new HashMap<>();
		System.out.println("后台获取名字:"+userName);
		if (null!=userName){
				map.put("user",userName);
				jsonData.setBody(map);
				jsonData.setSuccess(JSONData.TRUE);
				return jsonData;
		}
		jsonData.setSuccess(JSONData.FALSE);
		jsonData.setErrMsg("没有查询到用户");
		return jsonData;
	}
}
