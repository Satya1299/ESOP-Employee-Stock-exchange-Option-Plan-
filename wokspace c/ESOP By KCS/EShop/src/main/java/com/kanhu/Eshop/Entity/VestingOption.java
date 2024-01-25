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
@Table(name = EsopConstant.VESTED_OPTION_TABLE)
public class VestingOption implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7153834399267851972L;

	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "id")
	private Long id;

	@Column(name = "grant_Id")
	private String grantId;

	@Column(name = "vested_factor")
	private Double VestedFactor;

	@Column(name = "created_date")
	private Date createdDate;

	@Column(name = "motified_date")
	private Date motifiedDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGrantId() {
		return grantId;
	}

	public void setGrantId(String grantId) {
		this.grantId = grantId;
	}

	public Double getVestedFactor() {
		return VestedFactor;
	}

	public void setVestedFactor(Double vestedFactor) {
		VestedFactor = vestedFactor;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getMotifiedDate() {
		return motifiedDate;
	}

	public void setMotifiedDate(Date motifiedDate) {
		this.motifiedDate = motifiedDate;
	}

	@Override
	public String toString() {
		return "VestingOption [id=" + id + ", grantId=" + grantId + ", VestedFactor=" + VestedFactor + ", createdDate="
				+ createdDate + ", motifiedDate=" + motifiedDate + "]";
	}
	
}
