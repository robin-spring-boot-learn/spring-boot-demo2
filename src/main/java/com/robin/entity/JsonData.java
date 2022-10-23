package com.robin.entity;

import java.io.Serializable;

import com.robin.constant.Message;

public class JsonData implements Serializable {

	private static final long serialVersionUID = 1L;

	// 状态码
	private int code;
	
	// 消息
	private String msg;
	
	// 结果
	private Object data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public JsonData(Message msg, Object data) {
		super();
		this.code = msg.getCode();
		this.msg = msg.getMessage();
		this.data = data;
	}
}
