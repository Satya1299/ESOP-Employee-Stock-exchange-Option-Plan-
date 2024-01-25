package com.kanhu.Eshop.Dto;

import java.io.Serializable;

import lombok.Data;

public class OptionDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4805976268750039577L;

	private Long plan_Id;

	private Long grantId;

	private Double sumOfAllocatedAllocation;

	public Long getPlan_Id() {
		return plan_Id;
	}

	public void setPlan_Id(Long plan_Id) {
		this.plan_Id = plan_Id;
	}

	public Long getGrantId() {
		return grantId;
	}

	public void setGrantId(Long grantId) {
		this.grantId = grantId;
	}

	public Double getSumOfAllocatedAllocation() {
		return sumOfAllocatedAllocation;
	}

	public void setSumOfAllocatedAllocation(Double sumOfAllocatedAllocation) {
		this.sumOfAllocatedAllocation = sumOfAllocatedAllocation;
	}

	@Override
	public String toString() {
		return "OptionDto [plan_Id=" + plan_Id + ", grantId=" + grantId + ", sumOfAllocatedAllocation="
				+ sumOfAllocatedAllocation + "]";
	}
	
	

}
