package com.robin.constant;

public enum Message {
	
	SUCCESS(200, "success"),
	ERROR(500, "error");
	
	private int code;
	private String message;
	
	private Message(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public int getCode() {
		return this.code;
	}
	public String getMessage() {
		return this.message;
	}

	@Override
	public String toString() {
		return "Enum value:["+ this.code + "," + this.message+"]";
	}
	
}
