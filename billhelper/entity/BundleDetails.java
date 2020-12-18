package com.onebill.billhelper.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "bndl_details")
public class BundleDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bndl_dtl_id")
	private int bundleDetailId;
	
	@Column(name = "bdnle_type")
	private String bundleType;

	@Column(name = "bndl_details")
	private String bundleDetails;
	
	@ManyToOne
	@JoinColumn(name="bundle_id")
	private Bundle bundle;
		
	@OneToMany(mappedBy="bundleDetailFK")
	private List<AddtionalCharges> addCharges;
	
}
