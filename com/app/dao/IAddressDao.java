package com.app.dao;

import com.app.pojos.AddressDetails;
import com.app.pojos.HealthDetails;

public interface IAddressDao {

	AddressDetails addAddressDetails(Integer custId, AddressDetails address);
	//AddressDetails addAddressDetails(AddressDetails address);

}
