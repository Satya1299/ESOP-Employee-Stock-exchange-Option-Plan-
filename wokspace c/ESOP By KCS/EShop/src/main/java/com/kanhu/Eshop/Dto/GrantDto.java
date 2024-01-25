package com.kanhu.Eshop.Dto;

import java.io.Serializable;

import lombok.Data;


public class GrantDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2829813433571452190L;

	private String employeeNumber;

	private Long numberOfGrants;

	private Long band;

	private Double grantPrice;

	private String lockInStatus;

	private Long frequency;

	private Long vestingTenure;

	private Long planId;

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

	public Long getPlanId() {
		return planId;
	}

	public void setPlanId(Long planId) {
		this.planId = planId;
	}

	@Override
	public String toString() {
		return "GrantDto [employeeNumber=" + employeeNumber + ", numberOfGrants=" + numberOfGrants + ", band=" + band
				+ ", grantPrice=" + grantPrice + ", lockInStatus=" + lockInStatus + ", frequency=" + frequency
				+ ", vestingTenure=" + vestingTenure + ", planId=" + planId + "]";
	}
	
	
}
