package com.bucom.boot.config;

import java.util.Map;

/**
 * Controller通用返回Json
 * 
 * @author ruihua.qin
 *
 */
public class JSONData {
	public static final String TRUE 	= "true";
	public static final String FALSE	= "false";

	private String success;			//成功标志
	private String errCode;			//错误码
	private String errMsg;			//错误信息
	private int		size;			//个数
	private Map<String, ?> body;	//Body

	public JSONData() {
		setSuccess(TRUE);
	}
	
	public JSONData(String success, Map<String, ?> body){
		
		this.success = success;
		this.body = body;
	}
	
	public JSONData(String success, String errCode, String errMsg){
		
		this.success = success;
		this.errCode = errCode;
		this.errMsg = errMsg;
	}
	
	public JSONData(String success, String errCode, String errMsg, Map<String, ?> body){
		this.success = success;
		this.errCode = errCode;
		this.errMsg = errMsg;
		this.body = body;
	}
	
	public String getErrCode() {
		return errCode;
	}
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public Map<String, ?> getBody() {
		return body;
	}
	public void setBody(Map<String, ?> body) {
		this.body = body;
	}
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
}
