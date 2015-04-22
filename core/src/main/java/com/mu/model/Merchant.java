package com.mu.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Indexed;

@Entity
@Table(name = "mu_merchant")
@Indexed
@XmlRootElement
public class Merchant extends BaseObject implements Serializable {

	private static final long serialVersionUID = 3832626162173359411L;

	private Long id;
	private String merchantName;
	private String description;
	private MerchantType merchantType;
	private String logoPath;
	private String targetLink;
	private boolean topMerchant;
	private boolean enabled;
	private Calendar createdOn;
	private Calendar updatedOn;

	public Merchant() {
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

	@Column(name = "merchant_name")
	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "merchant_type_id")
	public MerchantType getMerchantType() {
		return merchantType;
	}

	public void setMerchantType(MerchantType merchantType) {
		this.merchantType = merchantType;
	}

	@Column(name = "logo_path")
	public String getLogoPath() {
		return logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

	@Column(name = "target_link")
	public String getTargetLink() {
		return targetLink;
	}

	public void setTargetLink(String targetLink) {
		this.targetLink = targetLink;
	}

	@Column(name = "is_top_merchant")
	public boolean isTopMerchant() {
		return topMerchant;
	}

	public void setTopMerchant(boolean topMerchant) {
		this.topMerchant = topMerchant;
	}

	@Column(name = "is_enabled", columnDefinition = "boolean default true", nullable = false)
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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

	/**
	 * {@inheritDoc}
	 */
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Merchant)) {
			return false;
		}

		final Merchant merchant = (Merchant) o;

		return !(id != null ? !id.equals(merchant.getId())
				: merchant.getId() != null);

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
