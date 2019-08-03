package com.app.dto;

public class BillDetails {

	private Long id;

	private String description;

	private String note;

	private Double amount;

	public BillDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BillDetails(Long id, String description, String note, Double amount) {
		super();
		this.id = id;
		this.description = description;
		this.note = note;
		this.amount = amount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "BillDetails [id=" + id + ", description=" + description + ", note=" + note + ", amount=" + amount + "]";
	}

	
}
