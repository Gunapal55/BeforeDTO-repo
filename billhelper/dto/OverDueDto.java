package com.onebill.billhelper.dto;

import java.io.Serializable;

import com.onebill.billhelper.entity.Bundle;

import lombok.Data;

@Data
public class OverDueDto implements Serializable{
	
	private static final long serialVersionUID = 7185082734382131590L;

	private int overDueId;

	private String chargetype;
	
	private int chargeAmount;
	
	private Bundle bundle;
}
