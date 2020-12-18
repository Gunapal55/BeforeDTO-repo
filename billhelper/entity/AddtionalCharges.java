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
@Table(name="extra_charges")
@Data
public class AddtionalCharges {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int chargeId;
	
	@Column(name = "charg_for")
	private String ChargeType;
	
	
	@Column(name = "charg_amt")
	private int chargeAmount;
	
	
	@Column(name = "req_docs")
	private String requiredDocuments;
	
	@ManyToOne
	@JoinColumn(name = "bndl_dtl_id")
	private BundleDetails bundleDetailFK;

}
