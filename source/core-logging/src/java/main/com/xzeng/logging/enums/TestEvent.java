package com.xzeng.logging.enums;

import org.apache.commons.lang3.StringUtils;

public enum TestEvent implements AppEvent {
	UNKNOW_EXCEPTION(100000,"unknow exception :{},data:{}");

	private int id;

    private String message;

    private int messageParamsNumber;	// 参数个数
    
    private TestEvent(int id, String message){
    	this.id = id;
        this.message = message;
        this.messageParamsNumber = StringUtils.countMatches(message, "{}");
    }
    
	@Override
	public int getId() {
		return id;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public int getMessageParamsNumber() {
		return messageParamsNumber;
	}

}
