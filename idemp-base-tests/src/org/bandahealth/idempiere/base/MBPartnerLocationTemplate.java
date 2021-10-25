package org.bandahealth.idempiere.base;

import java.util.Properties;

import org.compiere.model.MBPartnerLocation;
import org.compiere.model.Query;

public class MBPartnerLocationTemplate extends BaseModelTemplate<MBPartnerLocation> {

	private int bpartnerId;
	private int locationId;
	private int orgId;

	public MBPartnerLocationTemplate(String transactionName, Properties context, int bpartnerId, int locationId,
			int orgId) {
		super(transactionName, context);

		this.bpartnerId = bpartnerId;
		this.locationId = locationId;
		this.orgId = orgId;
	}

	@Override
	protected MBPartnerLocation createInstance() {
		MBPartnerLocation location = new MBPartnerLocation(getContext(), 0, getTransactionName());
		location.setName("Test Shipping Address");
		location.setC_BPartner_ID(bpartnerId);
		location.setC_Location_ID(locationId);
		location.setAD_Org_ID(orgId);
		location.saveEx();

		commit();

		return location;
	}

	@Override
	protected MBPartnerLocation findInstance() {
		return new Query(getContext(), MBPartnerLocation.Table_Name, "name = 'Test Shipping Address'",
				getTransactionName()).first();

	}

	@Override
	protected void setFields(MBPartnerLocation instance) {
		// TODO Auto-generated method stub

	}

}