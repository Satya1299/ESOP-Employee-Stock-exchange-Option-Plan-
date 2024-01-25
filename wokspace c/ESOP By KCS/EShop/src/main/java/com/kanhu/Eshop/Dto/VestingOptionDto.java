package com.kanhu.Eshop.Dto;

import java.io.Serializable;

import lombok.Data;

public class VestingOptionDto implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = -7270513231625508937L;
	private Double VestingFactor;
	private Long planId;
	public Double getVestingFactor() {
		return VestingFactor;
	}
	public void setVestingFactor(Double vestingFactor) {
		VestingFactor = vestingFactor;
	}
	public Long getPlanId() {
		return planId;
	}
	public void setPlanId(Long planId) {
		this.planId = planId;
	}
	@Override
	public String toString() {
		return "VestingOptionDto [VestingFactor=" + VestingFactor + ", planId=" + planId + "]";
	}
	
	
}
