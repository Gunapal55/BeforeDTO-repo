package com.onebill.billhelper.dao;

import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.onebill.billhelper.dto.AddtionalChargesDto;
import com.onebill.billhelper.dto.BundleDetailsDto;
import com.onebill.billhelper.dto.BundleDto;
import com.onebill.billhelper.dto.OverDueDto;
import com.onebill.billhelper.entity.AddtionalCharges;
import com.onebill.billhelper.entity.Bundle;
import com.onebill.billhelper.entity.BundleDetails;
import com.onebill.billhelper.entity.OverDue;

@Repository
public class BundleDaoImplementation implements BundleDao {

	@PersistenceUnit
	EntityManagerFactory factory;

	@Override
	public BundleDto createBundle(BundleDto bundle) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transcation = manager.getTransaction();
		transcation.begin();
		Bundle bundle1 = new Bundle();
		BeanUtils.copyProperties(bundle, bundle1);
		manager.persist(bundle1);
		BundleDto dto = new BundleDto();
		BeanUtils.copyProperties(bundle1, dto);
		manager.getTransaction().commit();
		manager.close();
		return dto;

	}

	@Override
	public BundleDto updateBundle(BundleDto updateBundle) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Bundle updatedBundle = manager.find(Bundle.class, updateBundle.getBundleId());
		BeanUtils.copyProperties(updateBundle, updatedBundle);
		BundleDto dto = new BundleDto();
		BeanUtils.copyProperties(updatedBundle, dto);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		return dto;

	}

	@Override
	public BundleDto removeBundle(BundleDto bundle) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Bundle deletedBundle = manager.find(Bundle.class, bundle.getBundleId());
		if (deletedBundle != null) {
			manager.remove(deletedBundle);
			manager.getTransaction().commit();
			manager.close();
			return bundle;
		} else {
			manager.close();
			factory.close();
			return null;
		}
	}

	@Override
	public List<BundleDto> getAllBundle() {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Bundle> query = manager.createQuery("FROM Bundle", Bundle.class);
		List<Bundle> bundle = query.getResultList();
		ModelMapper mapper = new ModelMapper();
		Type listType = new TypeToken<List<BundleDto>>() {
		}.getType();
		List<BundleDto> dto = mapper.map(bundle, listType);
		return dto;

	}

	@Override
	public BundleDetailsDto addBundleDetails(BundleDetailsDto bundleDetail) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transcation = manager.getTransaction();
		transcation.begin();
		BundleDetails bundleDetails1 = new BundleDetails();
		BeanUtils.copyProperties(bundleDetail, bundleDetails1);
		BundleDetailsDto dto = new BundleDetailsDto();
		BeanUtils.copyProperties(bundleDetails1, dto);
		manager.persist(bundleDetail);
		manager.getTransaction().commit();
		manager.close();
		return dto;

	}

	@Override
	public BundleDetailsDto updateBundleDetails(BundleDetailsDto bundleDetail) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		BundleDetails updatedBundleDetail = manager.find(BundleDetails.class, bundleDetail.getBundleDetailId());
		BeanUtils.copyProperties(bundleDetail, updatedBundleDetail);
		BundleDetailsDto dto = new BundleDetailsDto();
		BeanUtils.copyProperties(updatedBundleDetail, dto);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		return dto;
	}

	@Override
	public BundleDetailsDto removeDetails(BundleDetailsDto bundleDetail) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		BundleDetails deletedBundleDetail = manager.find(BundleDetails.class, bundleDetail.getBundleDetailId());
		if (deletedBundleDetail != null) {
			manager.remove(deletedBundleDetail);
			manager.getTransaction().commit();
			manager.close();
			return bundleDetail;
		} else {
			manager.close();
			factory.close();
			return null;
		}
	}

	@Override
	public List<BundleDetailsDto> getAllBundleDetails() {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<BundleDetails> query = manager.createQuery("FROM BundleDetails", BundleDetails.class);
		List<BundleDetails> bundleDetials = query.getResultList();
		ModelMapper mapper = new ModelMapper();
		Type listType = new TypeToken<List<BundleDetailsDto>>() {
		}.getType();
		List<BundleDetailsDto> dto = mapper.map(bundleDetials, listType);
		return dto;

	}

	@Override
	public Bundle getBundleById(int BundleId) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Bundle bundle = manager.find(Bundle.class, BundleId);
		return bundle;
	}

	@Override
	public BundleDetails getBundleDetailById(int bundleDetailId) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		BundleDetails bundleDetail = manager.find(BundleDetails.class, bundleDetailId);
		return bundleDetail;

	}

	@Override
	public OverDueDto addOverDue(OverDueDto overDue) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transcation = manager.getTransaction();
		transcation.begin();
		OverDue overDue1 = new OverDue();
		BeanUtils.copyProperties(overDue, overDue1);
		manager.persist(overDue1);
		OverDueDto dto = new OverDueDto();
		BeanUtils.copyProperties(overDue1, dto);
		manager.getTransaction().commit();
		manager.close();
		return dto;

	}

	@Override
	public OverDueDto updateOverDue(OverDueDto overDue) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		OverDue updatedOverDue = manager.find(OverDue.class, overDue.getOverDueId());
		BeanUtils.copyProperties(overDue, updatedOverDue);
		OverDueDto dto = new OverDueDto();
		BeanUtils.copyProperties(updatedOverDue, dto);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		return dto;
	}

	@Override
	public OverDueDto deleteOverDue(OverDueDto due) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		OverDue deletedOverDue = manager.find(OverDue.class, due.getOverDueId());
		if (deletedOverDue != null) {
			manager.remove(deletedOverDue);
			manager.getTransaction().commit();
			manager.close();
			return due;
		} else {
			manager.close();
			factory.close();
			return null;
		}
	}

	@Override
	public OverDue getOverDueById(int overDueId) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		OverDue due = manager.find(OverDue.class, overDueId);
		return due;
	}

	@Override
	public AddtionalChargesDto addAddtionalCharges(AddtionalChargesDto addtional) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transcation = manager.getTransaction();
		transcation.begin();
		AddtionalCharges addCharge = new AddtionalCharges();
		BeanUtils.copyProperties(addtional, addCharge);
		manager.persist(addCharge);
		AddtionalChargesDto dto = new AddtionalChargesDto();
		BeanUtils.copyProperties(addCharge, dto);
		manager.getTransaction().commit();
		manager.close();
		return dto;

	}

	@Override
	public AddtionalChargesDto updateAddtionalCharges(AddtionalChargesDto addtional) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		AddtionalCharges addtional2 = manager.find(AddtionalCharges.class, addtional.getChargeId());
		BeanUtils.copyProperties(addtional, addtional2);
		AddtionalChargesDto dto = new AddtionalChargesDto();
		BeanUtils.copyProperties(addtional2, dto);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		return dto;
	}

	@Override
	public AddtionalChargesDto deleteAddtionalCharges(AddtionalChargesDto addtional) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		AddtionalCharges delete = manager.find(AddtionalCharges.class, addtional.getChargeId());
		if (delete != null) {
			manager.remove(delete);
			manager.getTransaction().commit();
			manager.close();
			return addtional;
		} else {
			manager.close();
			factory.close();
			return null;
		}
	}

	@Override
	public AddtionalCharges getAddtionalChargesById(int addtionalId) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		AddtionalCharges addtional = manager.find(AddtionalCharges.class, addtionalId);
		return addtional;
	}

}
