package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.List;

import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.rest.model.Vendor;

public class VendorDBService extends BusinessPartnerDBService<Vendor> {

	private String WHERE_CLAUSE = MBPartner_BH.COLUMNNAME_IsVendor + "=?";
	private List<Object> parameters = new ArrayList<>();

	public VendorDBService() {
		parameters.add("Y");
		setQueryConditions(WHERE_CLAUSE, parameters);
	}

	@Override
	protected Vendor getInstance() {
		return new Vendor();
	}
}