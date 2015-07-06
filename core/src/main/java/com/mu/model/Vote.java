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
@Table(name = "mu_vote")
public class Vote extends BaseObject implements Serializable {

	private static final long serialVersionUID = 3832626162173359411L;
	private Long id;
	private String email;
	private boolean wantOrganicFood;
	private boolean likeToDoAgri;
	private boolean supportFinancially;
	private boolean supportByLand;
	private boolean supportTechnically;
	private boolean partTimeSupport;
	private boolean monthlySalariedAgri;
	private Calendar createdOn;
	private String createdIpAddress;

	public Vote() {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "want_organic_food", columnDefinition = "boolean default false", nullable = false)
	public boolean isWantOrganicFood() {
		return wantOrganicFood;
	}

	public void setWantOrganicFood(boolean wantOrganicFood) {
		this.wantOrganicFood = wantOrganicFood;
	}

	@Column(name = "like_to_do_agri", columnDefinition = "boolean default false", nullable = false)
	public boolean isLikeToDoAgri() {
		return likeToDoAgri;
	}

	public void setLikeToDoAgri(boolean likeToDoAgri) {
		this.likeToDoAgri = likeToDoAgri;
	}

	@Column(name = "support_financially", columnDefinition = "boolean default false", nullable = false)
	public boolean isSupportFinancially() {
		return supportFinancially;
	}

	public void setSupportFinancially(boolean supportFinancially) {
		this.supportFinancially = supportFinancially;
	}

	@Column(name = "support_by_land", columnDefinition = "boolean default false", nullable = false)
	public boolean isSupportByLand() {
		return supportByLand;
	}

	public void setSupportByLand(boolean supportByLand) {
		this.supportByLand = supportByLand;
	}

	@Column(name = "support_technically", columnDefinition = "boolean default false", nullable = false)
	public boolean isSupportTechnically() {
		return supportTechnically;
	}

	public void setSupportTechnically(boolean supportTechnically) {
		this.supportTechnically = supportTechnically;
	}

	@Column(name = "part_time_support", columnDefinition = "boolean default false", nullable = false)
	public boolean isPartTimeSupport() {
		return partTimeSupport;
	}

	public void setPartTimeSupport(boolean partTimeSupport) {
		this.partTimeSupport = partTimeSupport;
	}

	@Column(name = "monthly_salaried_agri", columnDefinition = "boolean default false", nullable = false)
	public boolean isMonthlySalariedAgri() {
		return monthlySalariedAgri;
	}

	public void setMonthlySalariedAgri(boolean monthlySalariedAgri) {
		this.monthlySalariedAgri = monthlySalariedAgri;
	}

	@Column(name = "created_on")
	public Calendar getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Calendar createdOn) {
		this.createdOn = createdOn;
	}

	@Column(name = "created_ip_address")
	public String getCreatedIpAddress() {
		return createdIpAddress;
	}

	public void setCreatedIpAddress(String createdIpAddress) {
		this.createdIpAddress = createdIpAddress;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Advise)) {
			return false;
		}
		final Advise advise = (Advise) o;
		return !(id != null ? !id.equals(advise.getId())
				: advise.getId() != null);
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
