package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.List;

import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.rest.model.Vendor;
import org.bandahealth.idempiere.rest.utils.DateUtil;

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

	@Override
	protected Vendor createInstance(MBPartner_BH bpartner) {
		try {
			return new Vendor(bpartner.getAD_Client_ID(), bpartner.getAD_Org_ID(), bpartner.getC_BPartner_UU(),
					bpartner.isActive(), DateUtil.parse(bpartner.getCreated()), bpartner.getCreatedBy(),
					bpartner.getDescription(), bpartner.getName(), bpartner.getTotalOpenBalance());
		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}
}