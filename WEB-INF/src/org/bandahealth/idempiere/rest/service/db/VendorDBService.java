package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.List;

import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.rest.model.Vendor;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.compiere.model.MLocation;
import org.compiere.util.Env;

import com.fasterxml.jackson.databind.deser.std.NumberDeserializers.BigDecimalDeserializer;

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
	protected Vendor createInstanceWithDefaultFields(MBPartner_BH bpartner) {
		try {
			return new Vendor(bpartner.getAD_Client_ID(), bpartner.getAD_Org_ID(), bpartner.getC_BPartner_UU(),
					bpartner.isActive(), DateUtil.parse(bpartner.getCreated()), bpartner.getCreatedBy(),
					bpartner.getDescription(), bpartner.getName(), bpartner.getTotalOpenBalance());
		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}

	@Override
	protected Vendor createInstanceWithAllFields(MBPartner_BH bpartner) {
		try {
			return new Vendor(bpartner.getAD_Client_ID(), bpartner.getAD_Org_ID(), bpartner.getC_BPartner_UU(),
					bpartner.isActive(), DateUtil.parse(bpartner.getCreated()), bpartner.getCreatedBy(),
					bpartner.getDescription(), bpartner.getName(), bpartner.getTotalOpenBalance());
		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}

	public Vendor saveEntity(Vendor entity) {
		MBPartner_BH vendor;
		MBPartner_BH exists = getBPartner(entity.getUuid());
		if (exists != null) {
			vendor = exists;
		} else {
			vendor = new MBPartner_BH(Env.getCtx(), 0, null);
			vendor.setBH_IsPatient(false);
			vendor.setIsVendor(true); //
		}

		if (entity.getName() != null && !entity.getName().isEmpty()) {
			vendor.setName(entity.getName());
		}
		
		if (entity.getDescription() != null && !entity.getDescription().isEmpty()) {
			vendor.setDescription(entity.getDescription());
		}

		if (entity.getTotalOpenBalance() != null && !entity.getTotalOpenBalance().equals(0)) {
			vendor.setTotalOpenBalance(entity.getTotalOpenBalance());
		}

		vendor.setIsActive(entity.isIsActive());

		vendor.saveEx();

		return createInstanceWithAllFields(getBPartner(vendor.getC_BPartner_UU()));
	}
}