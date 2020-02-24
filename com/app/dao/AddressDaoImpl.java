package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.AddressDetails;
import com.app.pojos.Agent;
import com.app.pojos.PolicyHolder;

@Repository
@Transactional
public class AddressDaoImpl implements IAddressDao {


	@Autowired
	private SessionFactory sf;
	
//add address details	
	@Override
	//trial
	public AddressDetails addAddressDetails(Integer custId,AddressDetails address) {
		
		int cId = custId;
		PolicyHolder ph = sf.getCurrentSession().get(PolicyHolder.class, cId);
		address.setPolicyHolderFor(ph);;
		sf.getCurrentSession().persist(address);

		return address;
	}

	//main
//	public AddressDetails addAddressDetails(AddressDetails address) {
//		
//		sf.getCurrentSession().persist(address);
//		return address;
//	}

}
