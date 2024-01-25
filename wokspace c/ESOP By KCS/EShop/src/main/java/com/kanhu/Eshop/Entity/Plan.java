package com.kanhu.Eshop.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.kanhu.Eshop.Constant.EsopConstant;

import lombok.Data;

@Entity
@Table(name = EsopConstant.PLAN_TABLE)
public class Plan implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3877786204212480314L;
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "id")
	private Long id;

	@Column(name = "plan_year")
	private String planYear;

	@Column(name = "plan_start_date")
	private Date planStratDate;

	@Column(name = "plan_end_date")
	private Date planEndDate;

	@Column(name = "is_current_plan")
	private boolean isCurrentPlan;

	@Column(name = "vesting_factor")
	private Double vestingFactor;

	@Column(name = "vested_date")
	private Date vestedDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlanYear() {
		return planYear;
	}

	public void setPlanYear(String planYear) {
		this.planYear = planYear;
	}

	public Date getPlanStratDate() {
		return planStratDate;
	}

	public void setPlanStratDate(Date planStratDate) {
		this.planStratDate = planStratDate;
	}

	public Date getPlanEndDate() {
		return planEndDate;
	}

	public void setPlanEndDate(Date planEndDate) {
		this.planEndDate = planEndDate;
	}

	public boolean isCurrentPlan() {
		return isCurrentPlan;
	}

	public void setCurrentPlan(boolean isCurrentPlan) {
		this.isCurrentPlan = isCurrentPlan;
	}

	public Double getVestingFactor() {
		return vestingFactor;
	}

	public void setVestingFactor(Double vestingFactor) {
		this.vestingFactor = vestingFactor;
	}

	public Date getVestedDate() {
		return vestedDate;
	}

	public void setVestedDate(Date vestedDate) {
		this.vestedDate = vestedDate;
	}

	@Override
	public String toString() {
		return "Plan [id=" + id + ", planYear=" + planYear + ", planStratDate=" + planStratDate + ", planEndDate="
				+ planEndDate + ", isCurrentPlan=" + isCurrentPlan + ", vestingFactor=" + vestingFactor
				+ ", vestedDate=" + vestedDate + "]";
	}
	
}
