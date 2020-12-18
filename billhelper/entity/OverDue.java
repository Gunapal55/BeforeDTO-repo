package com.onebill.billhelper.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "overdue_info")
public class OverDue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ovr_id")
	private int overDueId;

	@Column(name = "charge_type")
	private String chargetype;

	@Column(name = "charg_amt")
	private int chargeAmount;

	@ManyToOne
	@JoinColumn(name = "bundl_id")
	private Bundle bundle;

}
