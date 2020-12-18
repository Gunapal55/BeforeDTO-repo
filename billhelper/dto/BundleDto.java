package com.onebill.billhelper.dto;

import java.io.Serializable;

import com.onebill.billhelper.entity.Products;

import lombok.Data;

@Data
public class BundleDto implements Serializable {

	private static final long serialVersionUID = -9212158082875616550L;

	private int bundleId;
	
	private String bundleDescription;
	
	private String bundleType;
	
	private String bundleDuration;
	
	private double bundleAmount;
	
	private Products products;
}
