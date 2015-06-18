package com.mu.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@Entity
public class Payment extends BaseObject implements Serializable {

	private static final long serialVersionUID = 3832626162173359411L;

	private String paymentType;
	private String bankName;
	private String cardHolderName;
	private String cardNumber;
	private String expiryMonth;
	private String expiryYear;
	private String cvvNumber;
	private Calendar createdOn;
	private Calendar updatedOn;
	private String createdIpAddress;
	private String createdMacAddress;
	private String updatedIpAddress;
	private String updatedMacAddress;
	private String secretKey;

	public Payment() {
		super();
	}

	@Column(name = "bank_name")
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Column(name = "card_holder_name")
	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	@Column(name = "card_number")
	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getCvvNumber() {
		return cvvNumber;
	}

	public void setCvvNumber(String cvvNumber) {
		this.cvvNumber = cvvNumber;
	}

	@Column(name = "expiry_month")
	public String getExpiryMonth() {
		return expiryMonth;
	}

	public void setExpiryMonth(String expiryMonth) {
		this.expiryMonth = expiryMonth;
	}

	@Column(name = "expiry_year")
	public String getExpiryYear() {
		return expiryYear;
	}

	public void setExpiryYear(String expiryYear) {
		this.expiryYear = expiryYear;
	}

	@Column(name = "created_on")
	public Calendar getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Calendar createdOn) {
		this.createdOn = createdOn;
	}

	@Column(name = "updated_on")
	public Calendar getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Calendar updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Column(name = "secret_key")
	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	@Column(name = "created_ip_address")
	public String getCreatedIpAddress() {
		return createdIpAddress;
	}

	public void setCreatedIpAddress(String createdIpAddress) {
		this.createdIpAddress = createdIpAddress;
	}

	@Column(name = "created_mac_address")
	public String getCreatedMacAddress() {
		return createdMacAddress;
	}

	public void setCreatedMacAddress(String createdMacAddress) {
		this.createdMacAddress = createdMacAddress;
	}

	@Column(name = "updated_ip_address")
	public String getUpdatedIpAddress() {
		return updatedIpAddress;
	}

	public void setUpdatedIpAddress(String updatedIpAddress) {
		this.updatedIpAddress = updatedIpAddress;
	}

	@Column(name = "updated_mac_address")
	public String getUpdatedMacAddress() {
		return updatedMacAddress;
	}

	public void setUpdatedMacAddress(String updatedMacAddress) {
		this.updatedMacAddress = updatedMacAddress;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Payment)) {
			return false;
		}
		final Payment cardDetail = (Payment) o;
		return !(cardNumber != null ? !cardNumber.equals(cardDetail
				.getCardNumber()) : cardDetail.getCardNumber() != null);
	}

	/**
	 * {@inheritDoc}
	 */
	public int hashCode() {
		return (cardNumber != null ? cardNumber.hashCode() : 0);
	}

	/**
	 * {@inheritDoc}
	 */
	public String toString() {
		ToStringBuilder sb = new ToStringBuilder(this,
				ToStringStyle.DEFAULT_STYLE).append("cardNumber",
				this.cardNumber);
		return sb.toString();
	}
}
