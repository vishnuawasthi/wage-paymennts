package com.app.dto;

public class MemberData {

	private String firstname;
	private String lastname;

	private String email;

	private String addressLine1;

	private String addressLine2;

	private String pincode;

	private String stcode;

	private String countryCd;

	private PaymentDetails paymentDetails;

	public PaymentDetails getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(PaymentDetails paymentDetails) {
		this.paymentDetails = paymentDetails;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getStcode() {
		return stcode;
	}

	public void setStcode(String stcode) {
		this.stcode = stcode;
	}

	public String getCountryCd() {
		return countryCd;
	}

	public void setCountryCd(String countryCd) {
		this.countryCd = countryCd;
	}

	public MemberData(String firstname, String lastname, String email, String addressLine1, String addressLine2,
			String pincode, String stcode, String countryCd) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.pincode = pincode;
		this.stcode = stcode;
		this.countryCd = countryCd;
	}

	public MemberData() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "MemberData [firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", addressLine1="
				+ addressLine1 + ", addressLine2=" + addressLine2 + ", pincode=" + pincode + ", stcode=" + stcode
				+ ", countryCd=" + countryCd + "[" + paymentDetails + "]" + "]";
	}

}
