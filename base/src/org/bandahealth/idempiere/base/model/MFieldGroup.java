package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.X_AD_FieldGroup;

public class MFieldGroup extends X_AD_FieldGroup {

	public MFieldGroup(Properties ctx, int AD_FieldGroup_ID, String trxName) {
		super(ctx, AD_FieldGroup_ID, trxName);
	}

	public MFieldGroup(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
