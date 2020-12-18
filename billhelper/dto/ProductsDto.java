package com.onebill.billhelper.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProductsDto implements Serializable {

	private static final long serialVersionUID = -5720691410702639419L;

	private int productId;
	
	private String productName;
	
	private String productType;
	

}
