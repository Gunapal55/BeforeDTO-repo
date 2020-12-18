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
@Table(name = "bundle_info")
public class Bundle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bndl_id")
	private int bundleId;

	@Column(name = "bndl_desc")
	private String bundleDescription;

	@Column(name = "bndl_type")
	private String bundleType;

	@Column(name = "bndl_dura")
	private String bundleDuration;

	@Column(name = "bndl_amout")
	private double bundleAmount;

	@ManyToOne
	@JoinColumn(name = "prd_id")
	private Products products;

	@OneToMany(mappedBy = "bundle")
	private List<BundleDetails> details;

	@OneToMany(mappedBy = "bundle")
	private List<OverDue> due;

}
