package com.app.dto;

public class AddressDetails {

	private String addressLine1;

	private String addressLine2;

	private String pincode;

	private String stCode;

	private String countryCode;

	public AddressDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddressDetails(String addressLine1, String addressLine2, String pincode, String stCode, String countryCode) {
		super();
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.pincode = pincode;
		this.stCode = stCode;
		this.countryCode = countryCode;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getStCode() {
		return stCode;
	}

	public void setStCode(String stCode) {
		this.stCode = stCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

}
