package com.kanhu.Eshop.Entity;

import java.io.Serializable;
import java.time.LocalDate;
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
@Table(name = EsopConstant.ALLOCATION_TABLE)
public class Allocation implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -255890761877657392L;
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "id")
	private Long id;
	private Long grantId;
	private Long numberOfAllocation;
	private LocalDate plannedAllocaionDate;
	private Date actualAllocationDate;
	private String alocationYear;
	private String allocationStatus;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getGrantId() {
		return grantId;
	}
	public void setGrantId(Long grantId) {
		this.grantId = grantId;
	}
	public Long getNumberOfAllocation() {
		return numberOfAllocation;
	}
	public void setNumberOfAllocation(Long numberOfAllocation) {
		this.numberOfAllocation = numberOfAllocation;
	}
	public LocalDate getPlannedAllocaionDate() {
		return plannedAllocaionDate;
	}
	public void setPlannedAllocaionDate(LocalDate plannedAllocaionDate) {
		this.plannedAllocaionDate = plannedAllocaionDate;
	}
	public Date getActualAllocationDate() {
		return actualAllocationDate;
	}
	public void setActualAllocationDate(Date actualAllocationDate) {
		this.actualAllocationDate = actualAllocationDate;
	}
	public String getAlocationYear() {
		return alocationYear;
	}
	public void setAlocationYear(String alocationYear) {
		this.alocationYear = alocationYear;
	}
	public String getAllocationStatus() {
		return allocationStatus;
	}
	public void setAllocationStatus(String allocationStatus) {
		this.allocationStatus = allocationStatus;
	}
	@Override
	public String toString() {
		return "Allocation [id=" + id + ", grantId=" + grantId + ", numberOfAllocation=" + numberOfAllocation
				+ ", plannedAllocaionDate=" + plannedAllocaionDate + ", actualAllocationDate=" + actualAllocationDate
				+ ", alocationYear=" + alocationYear + ", allocationStatus=" + allocationStatus + "]";
	}
	
}
