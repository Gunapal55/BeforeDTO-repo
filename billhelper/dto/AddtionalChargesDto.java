package com.onebill.billhelper.dto;

import java.io.Serializable;

import com.onebill.billhelper.entity.BundleDetails;

import lombok.Data;

@Data
public class AddtionalChargesDto implements Serializable{

	
	private static final long serialVersionUID = -2074134551807630841L;

	private int chargeId;
	
	private String ChargeType;
	
	private int chargeAmount;
	
	private String requiredDocuments;
	
	private BundleDetails bundleDetailFK;
}
