package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.AddressDetails;
import com.app.pojos.Agent;
import com.app.pojos.PolicyHolder;
import com.fasterxml.jackson.core.JsonParser;

@Repository
@Transactional
public class PolicyHolderDaoImpl implements IPolicyHolder {
	
	@Autowired
	private SessionFactory sf;
	
	@Autowired
	private IAgentDao agentDao;
	
//list policyHolders	
	@Override
	public List<PolicyHolder> policyHoldersList() {
		System.out.println("inside daoImpl of policyHolder");
		String jpql = "select p from PolicyHolder p";
		return sf.getCurrentSession().createQuery(jpql, PolicyHolder.class).getResultList();
	}

//select policyHolder by id method	
	@Override
	public PolicyHolder getPolicyHolderById(int policyHolderId) {
		return sf.getCurrentSession().get(PolicyHolder.class, policyHolderId);

	}

//add policyHolder	
//public PolicyHolder addPolicyHolder(PolicyHolder pHolder)
	@Override
	
	public PolicyHolder addPolicyHolder(Integer agentId , PolicyHolder pHolder) {
		
		
		
		int aId = agentId;
		agentDao.updateCountOfCustomers(aId);
		Agent a = sf.getCurrentSession().get(Agent.class, aId);
		pHolder.setAgentId(a);
		sf.getCurrentSession().persist(pHolder);

		return pHolder;
	}

//delete policy holder	
	@Override
	public void deletePolicyHolder(PolicyHolder pHolder) {
		sf.getCurrentSession().delete(pHolder);
	}

//edit policyHolder	(ONLY phnNumber and address details)
	@Override
	public void updatePolicyHOlder(int policyHolderId, PolicyHolder policyHolder) {
		PolicyHolder oldPolicyHolder= sf.getCurrentSession().get(PolicyHolder.class,policyHolderId);
		System.out.println("ad" + oldPolicyHolder.toString());
	//address and phNumber	
		System.out.println("pId"+policyHolderId);

//		AddressDetails addr = sf.getCurrentSession().get(AddressDetails.class,policyHolderId);
//		addr.setAddressLine1("shivaji park");
//		addr.setAddressLine2("CBS");
//		addr.setCity("kolhapur");
//		addr.setDistrict("kolhapur");
//		addr.setState("maharashtra");addr.setAddressLine1("shivaji park");
//		addr.setAddressLine2("CBS");
//		addr.setCity("kolhapur");
//		addr.setDistrict("kolhapur");
//		addr.setState("maharashtra");
		oldPolicyHolder.setPhNumber(policyHolder.getPhNumber());
		
//		oldPolicyHolder.getAddressDetails().setAddressLine2(policyHolder.getAddressDetails().getAddressLine2());
//		oldPolicyHolder.getAddressDetails().setCity(policyHolder.getAddressDetails().getCity());
//		oldPolicyHolder.getAddressDetails().setState(policyHolder.getAddressDetails().getState());
//		oldPolicyHolder.getAddressDetails().setDistrict(policyHolder.getAddressDetails().getDistrict());
//		oldPolicyHolder.getAddressDetails().setZipCode(policyHolder.getAddressDetails().getZipCode());
		sf.getCurrentSession().flush();
	//	sf.getCurrentSession().update(policyHolder);
	
	}

//increment count of policies	
	@Override
	public void updateCountOfPolicies(int custId) {
		PolicyHolder oldCount = sf.getCurrentSession().byId(PolicyHolder.class).load(custId);
		oldCount.setNoOfPolicies(oldCount.getNoOfPolicies()+1);
		sf.getCurrentSession().flush();
	}

//login	
	@Override
	public PolicyHolder login(int custId, String phNumber) {
		System.out.println("inside cust login");
		String jpql = "select c from PolicyHolder c where c.custId=:custId and c.phNumber=:phNumber";
		PolicyHolder policyHolder= sf.getCurrentSession().createQuery(jpql,PolicyHolder.class).setParameter("custId",custId).setParameter("phNumber", phNumber).getSingleResult();
		 
		if(policyHolder != null)
			return policyHolder;
		return null;
	}

	@Override
	public List<PolicyHolder> policyHoldersByAgentId(int agentId) {
		String jpql = "select c from PolicyHolder c where c.agentId=:agentId";
		return sf.getCurrentSession().createQuery(jpql,PolicyHolder.class).setParameter("agentId",agentId).getResultList();
		
	}
	

}
