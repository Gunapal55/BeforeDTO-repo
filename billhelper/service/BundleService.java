package com.onebill.billhelper.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onebill.billhelper.dto.AddtionalChargesDto;
import com.onebill.billhelper.dto.BundleDetailsDto;
import com.onebill.billhelper.dto.BundleDto;
import com.onebill.billhelper.dto.OverDueDto;
import com.onebill.billhelper.entity.AddtionalCharges;
import com.onebill.billhelper.entity.Bundle;
import com.onebill.billhelper.entity.BundleDetails;
import com.onebill.billhelper.entity.OverDue;

@Service
public interface BundleService {


	public BundleDto createBundle(BundleDto bundle);

	public BundleDto updateBundle(BundleDto bundle);

	public BundleDto removeBundle(BundleDto bundle);

	public List<BundleDto> getAllBundle();

	public Bundle getBundleById(int BundleId);

	public BundleDetailsDto addBundleDetails(BundleDetailsDto bundleDetail);

	public BundleDetailsDto updateBundleDetails(BundleDetailsDto bundleDetail);

	public BundleDetailsDto removeDetails(BundleDetailsDto bundleDetail);

	public List<BundleDetailsDto> getAllBundleDetails();

	public BundleDetails getBundleDetailById(int bundleDetailId);

	public OverDueDto addOverDue(OverDueDto overDue);

	public OverDueDto updateOverDue(OverDueDto overDue);

	public OverDueDto deleteOverDue(OverDueDto overDue);

	public OverDue getOverDueById(int overDueId);

	public AddtionalChargesDto addAddtionalCharges(AddtionalChargesDto addtional);

	public AddtionalChargesDto updateAddtionalCharges(AddtionalChargesDto addtional);

	public AddtionalChargesDto deleteAddtionalCharges(AddtionalChargesDto addtional);

	public AddtionalCharges getAddtionalChargesById(int addtionalId);

}
