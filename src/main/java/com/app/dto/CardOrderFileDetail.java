package com.app.dto;

public class CardOrderFileDetail {

	private Long id;

	private String cardNumber;

	private String proxyNumber;

	private String firstname;
	private String lastname;

	private String initialName;
	private String middleName;

	private Long clientId;

	private Long employeeId;

	private String valididyFrom;

	private String validityTo;

	private String status;

	private String errorReason;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getProxyNumber() {
		return proxyNumber;
	}

	public void setProxyNumber(String proxyNumber) {
		this.proxyNumber = proxyNumber;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getInitialName() {
		return initialName;
	}

	public void setInitialName(String initialName) {
		this.initialName = initialName;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getValididyFrom() {
		return valididyFrom;
	}

	public void setValididyFrom(String valididyFrom) {
		this.valididyFrom = valididyFrom;
	}

	public String getValidityTo() {
		return validityTo;
	}

	public void setValidityTo(String validityTo) {
		this.validityTo = validityTo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorReason() {
		return errorReason;
	}

	public void setErrorReason(String errorReason) {
		this.errorReason = errorReason;
	}
	
	

	
	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Override
	public String toString() {
		return "CardOrderFileDetail [id=" + id + ", cardNumber=" + cardNumber + ", proxyNumber=" + proxyNumber
				+ ", firstname=" + firstname + ", lastname=" + lastname + ", initialName=" + initialName + ", clientId="
				+ clientId + ", employeeId=" + employeeId + ", valididyFrom=" + valididyFrom + ", validityTo="
				+ validityTo + ", status=" + status + ", errorReason=" + errorReason + "]";
	}

}
