package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.List;

import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.model.Vendor;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.util.Env;

public class VendorDBService extends BaseDBService<Vendor, MBPartner_BH> {

	public BaseListResponse<Vendor> getAll(Paging pagingInfo, String sortColumn, String sortOrder) {
		List<Object> parameters = new ArrayList<>();
		parameters.add("Y");

		return super.getAll(MBPartner_BH.COLUMNNAME_IsVendor + "=?", parameters, pagingInfo, sortColumn, sortOrder);
	}

	@Override
	public Vendor saveEntity(Vendor entity) {
		MBPartner_BH vendor = getEntityFromDB(entity.getUuid());
		if (vendor == null) {
			vendor = new MBPartner_BH(Env.getCtx(), 0, null);
			vendor.setBH_IsPatient(false);
			vendor.setIsVendor(true);
		}

		if (StringUtil.isNotNullAndEmpty(entity.getName())) {
			vendor.setName(entity.getName());
		}

		if (StringUtil.isNotNullAndEmpty(entity.getDescription())) {
			vendor.setDescription(entity.getDescription());
		}
		if (StringUtil.isNotNullAndEmpty(entity.getPhoneNumber())) {
			vendor.setBH_Phone((entity.getPhoneNumber()));
		}
		if (StringUtil.isNotNullAndEmpty(entity.getEmailAddress())) {
			vendor.setBH_EMail((entity.getEmailAddress()));
		}

		vendor.setIsActive(entity.isIsActive());

		vendor.saveEx();

		return createInstanceWithAllFields(getEntityFromDB(vendor.getC_BPartner_UU()));
	}

	@Override
	protected Vendor createInstanceWithDefaultFields(MBPartner_BH bpartner) {
		try {
			return new Vendor(bpartner.getAD_Client_ID(), bpartner.getAD_Org_ID(), bpartner.getC_BPartner_UU(),
					bpartner.isActive(), DateUtil.parse(bpartner.getCreated()), bpartner.getCreatedBy(),
					bpartner.getDescription(), bpartner.getName(), bpartner.getBH_EMail(), bpartner.getBH_Phone(),
					bpartner.getTotalOpenBalance());
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
					bpartner.getDescription(), bpartner.getName(), bpartner.getBH_EMail(), bpartner.getBH_Phone(),
					bpartner.getTotalOpenBalance());
		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}

	@Override
	protected MBPartner_BH getModelInstance() {
		return new MBPartner_BH(Env.getCtx(), 0, null);
	}
}