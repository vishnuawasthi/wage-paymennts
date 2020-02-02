package com.app.dto;

public class PaymentDetails {

	private String type;

	private String description;

	private Double amount;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public PaymentDetails(String type, String description, Double amount) {
		super();
		this.type = type;
		this.description = description;
		this.amount = amount;
	}

}
