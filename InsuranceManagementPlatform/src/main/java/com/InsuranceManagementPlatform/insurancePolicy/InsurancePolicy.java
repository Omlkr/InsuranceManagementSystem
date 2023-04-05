package com.InsuranceManagementPlatform.insurancePolicy;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

import com.InsuranceManagementPlatform.client.Client;

@Entity
public class InsurancePolicy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Name cannot be null")
	private String policyNumber;

	@NotNull(message = "type cannot be null")
	private String type;

	@NotNull(message = "coverageAmount cannot be null")
	@DecimalMin(value = "0.01")
	private Double coverageAmount;

	@NotNull(message = "premium cannot be null")
	@DecimalMin(value = "0.01")
	private Double premium;

	@NotNull(message = "startDate cannot be null")
	@FutureOrPresent(message = "startDate must be in the futureOrPresent")
	private LocalDate startDate;

	@NotNull(message = "startDate cannot be null")
	@Future(message = "startDate must be in the future")
	private LocalDate endDate;

	@ManyToOne
	@JoinColumn(name = "client_id")
	@NotNull
	private Client client;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getCoverageAmount() {
		return coverageAmount;
	}

	public void setCoverageAmount(Double coverageAmount) {
		this.coverageAmount = coverageAmount;
	}

	public Double getPremium() {
		return premium;
	}

	public void setPremium(Double premium) {
		this.premium = premium;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
