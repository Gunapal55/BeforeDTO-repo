package com.onebill.billhelper.dto;

import java.io.Serializable;

import com.onebill.billhelper.entity.Bundle;

import lombok.Data;

@Data
public class BundleDetailsDto implements Serializable{

	private static final long serialVersionUID = -5668589930484540636L;

	private int bundleDetailId;
	
	private String bundleType;
	
	private String bundleDetails;
	
	private Bundle bundle;
}
