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
@Table(name = EsopConstant.EMPLOYEE_TABLE)
public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6734171558334679458L;
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "id")
	private Long id;
	@Column(name = "emplyoee_number")
	private String emplyoeeNumber;
	@Column(name = "band")
	private String band;
	@Column(name = "designation")
	private String designation;
	@Column(name = "employee_start_date")
	private Date employeeStartDate;
	@Column(name = "is_activte")
	private boolean isActivte;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmplyoeeNumber() {
		return emplyoeeNumber;
	}
	public void setEmplyoeeNumber(String emplyoeeNumber) {
		this.emplyoeeNumber = emplyoeeNumber;
	}
	public String getBand() {
		return band;
	}
	public void setBand(String band) {
		this.band = band;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Date getEmployeeStartDate() {
		return employeeStartDate;
	}
	public void setEmployeeStartDate(Date employeeStartDate) {
		this.employeeStartDate = employeeStartDate;
	}
	public boolean isActivte() {
		return isActivte;
	}
	public void setActivte(boolean isActivte) {
		this.isActivte = isActivte;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", emplyoeeNumber=" + emplyoeeNumber + ", band=" + band + ", designation="
				+ designation + ", employeeStartDate=" + employeeStartDate + ", isActivte=" + isActivte + "]";
	}
	
}
