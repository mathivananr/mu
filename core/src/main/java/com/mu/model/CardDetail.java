package com.mu.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.search.annotations.DocumentId;

@Entity
@Table(name = "mu_advise")
public class CardDetail extends BaseObject implements Serializable {

	private static final long serialVersionUID = 3832626162173359411L;

	private Long id;
	private String email;
	private String banknName;
	private String cardHolderName;
	private String cardNumber;
	private String expiryMonth;
	private String expiryYear;
	private Calendar createdOn;
	private Calendar updatedOn;
	private String createdIpAddress;
	private String createdMacAddress;
	private String updatedIpAddress;
	private String updatedMacAddress;
	private String secretKey;

	public CardDetail() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@DocumentId
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "bankn_name")
	public String getBanknName() {
		return banknName;
	}

	public void setBanknName(String banknName) {
		this.banknName = banknName;
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
		if (!(o instanceof CardDetail)) {
			return false;
		}
		final CardDetail cardDetail = (CardDetail) o;
		return !(id != null ? !id.equals(cardDetail.getId()) : cardDetail
				.getId() != null);
	}

	/**
	 * {@inheritDoc}
	 */
	public int hashCode() {
		return (id != null ? id.hashCode() : 0);
	}

	/**
	 * {@inheritDoc}
	 */
	public String toString() {
		ToStringBuilder sb = new ToStringBuilder(this,
				ToStringStyle.DEFAULT_STYLE).append("id", this.id);
		return sb.toString();
	}
}
