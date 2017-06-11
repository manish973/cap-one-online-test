package com.manish.sample;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class Events {
	
	@JsonProperty("sensitive-token-expiration-time")
	private Date sensitiveTokenExpirationTime;
	
	@JsonProperty("insensitive-token-expiration-time")
	private Date insensitiveTokenExpirationTime;
	public Date getSensitiveTokenExpirationTime() {
		return sensitiveTokenExpirationTime;
	}
	public void setSensitiveTokenExpirationTime(Date sensitiveTokenExpirationTime) {
		this.sensitiveTokenExpirationTime = sensitiveTokenExpirationTime;
	}
	public Date getInsensitiveTokenExpirationTime() {
		return insensitiveTokenExpirationTime;
	}
	public void setInsensitiveTokenExpirationTime(Date insensitiveTokenExpirationTime) {
		this.insensitiveTokenExpirationTime = insensitiveTokenExpirationTime;
	}
	
	

}
