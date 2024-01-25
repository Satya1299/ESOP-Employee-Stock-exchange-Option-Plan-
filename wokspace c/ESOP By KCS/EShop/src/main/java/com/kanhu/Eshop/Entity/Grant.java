package com.kanhu.Eshop.Entity;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import com.kanhu.Eshop.Constant.EsopConstant;

import lombok.Data;

@Entity
@Table(name = EsopConstant.GRANT_TABLE)

public class Grant implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -36727973388002255L;
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "id")
	private Long id;

	@Column(name = "employee_number")
	private String employeeNumber;

	@Column(name = "number_of_grants")
	private Long numberOfGrants;

	@Column(name = "band")
	private Long band;

	@Column(name = "grant_price")
	private Double grantPrice;

	@Column(name = "grant_status")
	private String grantStatus;

	@Column(name = "accepted")
	private boolean accepted;

	@Column(name = "accepted_date")
	private Date acceptedDate;

	@Column(name = "lock_in_status")
	private String lockInStatus;

	@Column(name = "frequency")
	private Long frequency;

	@Column(name = " vesting_tenure")
	private Long vestingTenure;

	@Column(name = "allocation_status")
	private String allocationStatus;

	@Column(name = " plan_id")
	private Long planId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public Long getNumberOfGrants() {
		return numberOfGrants;
	}

	public void setNumberOfGrants(Long numberOfGrants) {
		this.numberOfGrants = numberOfGrants;
	}

	public Long getBand() {
		return band;
	}

	public void setBand(Long band) {
		this.band = band;
	}

	public Double getGrantPrice() {
		return grantPrice;
	}

	public void setGrantPrice(Double grantPrice) {
		this.grantPrice = grantPrice;
	}

	public String getGrantStatus() {
		return grantStatus;
	}

	public void setGrantStatus(String grantStatus) {
		this.grantStatus = grantStatus;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	public Date getAcceptedDate() {
		return acceptedDate;
	}

	public void setAcceptedDate(Date acceptedDate) {
		this.acceptedDate = acceptedDate;
	}

	public String getLockInStatus() {
		return lockInStatus;
	}

	public void setLockInStatus(String lockInStatus) {
		this.lockInStatus = lockInStatus;
	}

	public Long getFrequency() {
		return frequency;
	}

	public void setFrequency(Long frequency) {
		this.frequency = frequency;
	}

	public Long getVestingTenure() {
		return vestingTenure;
	}

	public void setVestingTenure(Long vestingTenure) {
		this.vestingTenure = vestingTenure;
	}

	public String getAllocationStatus() {
		return allocationStatus;
	}

	public void setAllocationStatus(String allocationStatus) {
		this.allocationStatus = allocationStatus;
	}

	public Long getPlanId() {
		return planId;
	}

	public void setPlanId(Long planId) {
		this.planId = planId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Grant [id=" + id + ", employeeNumber=" + employeeNumber + ", numberOfGrants=" + numberOfGrants
				+ ", band=" + band + ", grantPrice=" + grantPrice + ", grantStatus=" + grantStatus + ", accepted="
				+ accepted + ", acceptedDate=" + acceptedDate + ", lockInStatus=" + lockInStatus + ", frequency="
				+ frequency + ", vestingTenure=" + vestingTenure + ", allocationStatus=" + allocationStatus
				+ ", planId=" + planId + "]";
	}
	
}
