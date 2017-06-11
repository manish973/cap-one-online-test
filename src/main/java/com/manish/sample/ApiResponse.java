package com.manish.sample;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse {
	
	private String error;
	private Events events;
	
	private List<Transaction> transactions;
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public Events getEvents() {
		return events;
	}
	public void setEvents(Events events) {
		this.events = events;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	
	

}
