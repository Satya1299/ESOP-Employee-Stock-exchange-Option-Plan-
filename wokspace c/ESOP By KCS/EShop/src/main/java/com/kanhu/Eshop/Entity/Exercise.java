package com.kanhu.Eshop.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.kanhu.Eshop.Constant.EsopConstant;

@Entity
@Table(name = EsopConstant.EXERCISE_TABLE)
public class Exercise implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4449531976716943845L;
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "id")
	private Long id;

	@Column(name = "grant_id")
	private Long grantId;

	@Column(name = "vesting_option")
	private Double vestingOption;

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

	public Double getVestingOption() {
		return vestingOption;
	}

	public void setVestingOption(Double vestingOption) {
		this.vestingOption = vestingOption;
	}

	@Override
	public String toString() {
		return "Exercise [id=" + id + ", grantId=" + grantId + ", vestingOption=" + vestingOption + "]";
	}

}
