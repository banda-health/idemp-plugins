package org.bandahealth.idempiere.base.factory;

import java.sql.ResultSet;

import org.adempiere.base.IModelFactory;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.compiere.model.MBPartner;
import org.compiere.model.PO;
import org.compiere.util.Env;

public class BHModelFactory implements IModelFactory {

	@Override
	public Class<?> getClass(String tableName) {

		if (tableName.equalsIgnoreCase(MBPartner.Table_Name)) {
			return MBPartner_BH.class;
		}

		return null;
	}

	@Override
	public PO getPO(String tableName, int Record_ID, String trxName) {

		if (tableName.equalsIgnoreCase(MBPartner.Table_Name)) {
			return new MBPartner_BH(Env.getCtx(), Record_ID, trxName);
		}

		return null;
	}

	@Override
	public PO getPO(String tableName, ResultSet rs, String trxName) {

		if (tableName.equalsIgnoreCase(MBPartner.Table_Name)) {
			return new MBPartner_BH(Env.getCtx(), rs, trxName);
		}

		return null;
	}
}
