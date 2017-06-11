package com.manish.sample;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Transaction implements Comparable<Transaction>{
	
	
	/**
	 * {"amount":-34300,"original-amount":-34300,
	 * "original-merchant":"7-Eleven 23853",
	 * "is-pending":false,"paycheck-id":0,"aggregation-time":1412686740000,
	 * "transaction-time-string-read-only":"2014-10-07T12:59:00Z","user-json-data":"{}","account-id":"nonce:comfy-cc/hdhehe",
	 * "target-is-goal":false,"clear-date":1412790480000,"is-transfer":false,"transaction-id":"1412790480000",
	 * "raw-merchant":"7-ELEVEN 23853","target-fund-id":1,"categorization":"Unknown","merchant":"7-Eleven 23853",
	 * "transaction-time":"2014-10-07T12:59:00.000Z","original-transaction-time":1412686740000
	 * }
	 */
	
	@JsonProperty("amount")
	private Double amount;
	
	@JsonIgnore
	private Double originalAmount;
	
	@JsonIgnore
	private String originalMerchant;
	@JsonIgnore
	private Boolean isPending;
	@JsonIgnore
	private int paycheckId;
	@JsonIgnore
	private Date aggregationTime;
	@JsonIgnore
	private String transactionTimeString;
	@JsonIgnore
	private Boolean isTransfer;
	
	@JsonProperty("clear-date")
	private Timestamp clearDate;
	@JsonProperty("transcation-id")
	private BigInteger transactionId;
	@JsonIgnore
	private String rawMerchant;
	
	@JsonProperty("merchant")
	private String merchant;
	@JsonProperty("account-id")
	private String accountId;
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount/10000;
	}
	public Double getOriginalAmount() {
		return originalAmount;
	}
	public void setOriginalAmount(Double originalAmount) {
		this.originalAmount = originalAmount;
	}
	public String getOriginalMerchant() {
		return originalMerchant;
	}
	public void setOriginalMerchant(String originalMerchant) {
		this.originalMerchant = originalMerchant;
	}
	public Boolean getIsPending() {
		return isPending;
	}
	public void setIsPending(Boolean isPending) {
		this.isPending = isPending;
	}
	public int getPaycheckId() {
		return paycheckId;
	}
	public void setPaycheckId(int paycheckId) {
		this.paycheckId = paycheckId;
	}
	public Date getAggregationTime() {
		return aggregationTime;
	}
	public void setAggregationTime(Date aggregationTime) {
		this.aggregationTime = aggregationTime;
	}
	public String getTransactionTimeString() {
		return transactionTimeString;
	}
	public void setTransactionTimeString(String transactionTimeString) {
		this.transactionTimeString = transactionTimeString;
	}
	public Boolean getIsTransfer() {
		return isTransfer;
	}
	public void setIsTransfer(Boolean isTransfer) {
		this.isTransfer = isTransfer;
	}

	
	
	public Timestamp getClearDate() {
		return clearDate;
	}
	public void setClearDate(Timestamp clearDate) {
		this.clearDate = clearDate;
	}
	public BigInteger getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(BigInteger transactionId) {
		this.transactionId = transactionId;
	}
	public String getRawMerchant() {
		return rawMerchant;
	}
	public void setRawMerchant(String rawMerchant) {
		this.rawMerchant = rawMerchant;
	}
	public String getMerchant() {
		return merchant;
	}
	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	
	public int compareTo(Transaction o1) {
		Transaction o2 = this;
		if(o1 != null && o2 != null){
			if(o1.getClearDate() != null && o2.getClearDate() != null){
				return o1.getClearDate().compareTo(o2.getClearDate());
			}
		}
		return 0;
	}
	
	
	
	

}
