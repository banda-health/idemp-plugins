package org.bandahealth.idempiere.base.modelfactory;

import java.sql.ResultSet;

import org.adempiere.base.IModelFactory;
import org.compiere.model.PO;

public class BHModelFactory implements IModelFactory {

	@Override
	public Class<?> getClass(String tableName) {
		return null;
	}

	@Override
	public PO getPO(String tableName, int Record_ID, String trxName) {
		return null;
	}

	@Override
	public PO getPO(String tableName, ResultSet rs, String trxName) {
		return null;
	}
}
