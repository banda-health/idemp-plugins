package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.rest.model.BusinessPartner;
import org.compiere.model.Query;
import org.compiere.util.Env;

public abstract class BusinessPartnerDBService<T extends BusinessPartner> extends BaseDBService<T, MBPartner_BH> {

	public BusinessPartnerDBService() {
	}

	/*
	 * Retrieve bpartner by uuid
	 */
	protected MBPartner_BH getBPartner(String uuid) {
		MBPartner_BH entity = new Query(Env.getCtx(), MBPartner_BH.Table_Name,
				MBPartner_BH.COLUMNNAME_C_BPartner_UU + "=?", null).setParameters(uuid).first();

		return entity;
	}

	@Override
	protected MBPartner_BH getModelInstance() {
		return new MBPartner_BH(Env.getCtx());
	}

}
