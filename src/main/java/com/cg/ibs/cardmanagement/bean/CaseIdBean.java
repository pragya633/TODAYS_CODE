package com.cg.ibs.cardmanagement.bean;

import java.math.BigInteger;
import java.time.LocalDateTime;

public class CaseIdBean {

	public CaseIdBean() {

	}

	@Override
	public String toString() {
		return "CaseIdBean [caseIdTotal=" + caseIdTotal + ", caseTimeStamp=" + caseTimeStamp + ", statusOfQuery="
				+ statusOfQuery + ", accountNumber=" + accountNumber + ", UCI=" + UCI + ", defineQuery=" + defineQuery
				+ ", cardNumber=" + cardNumber + ", customerReferenceId=" + customerReferenceId + "]";
	}

	private String caseIdTotal;
	private LocalDateTime caseTimeStamp;
	private String statusOfQuery;
	private BigInteger accountNumber;
	private BigInteger UCI;
	private String defineQuery;
	private BigInteger cardNumber;
	private String customerReferenceId;

	public String getCustomerReferenceId() {
		return customerReferenceId;
	}

	public void setCustomerReferenceId(String customerReferenceId) {
		this.customerReferenceId = customerReferenceId;
	}

	public BigInteger getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(BigInteger cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getDefineQuery() {
		return defineQuery;
	}

	public void setDefineQuery(String defineQuery) {
		this.defineQuery = defineQuery;
	}

	public BigInteger getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(BigInteger bigInteger) {
		this.accountNumber = bigInteger;
	}

	public BigInteger getUCI() {
		return UCI;
	}

	public void setUCI(BigInteger UCI) {
		UCI = UCI;
	}

	public String getCaseIdTotal() {
		return caseIdTotal;
	}

	public void setCaseIdTotal(String caseIdTotal) {
		this.caseIdTotal = caseIdTotal;
	}

	public LocalDateTime getCaseTimeStamp() {
		return caseTimeStamp;
	}

	public void setCaseTimeStamp(LocalDateTime timestamp) {
		this.caseTimeStamp = timestamp;
	}

	public String getStatusOfQuery() {
		return statusOfQuery;
	}

	public void setStatusOfQuery(String statusOfQuery) {
		this.statusOfQuery = statusOfQuery;
	}

	
}
