package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHFieldRule extends X_BH_Field_Rule {

	public MBHFieldRule(Properties ctx, int BH_Field_Rule_ID, String trxName) {
		super(ctx, BH_Field_Rule_ID, trxName);
	}

	public MBHFieldRule(Properties ctx, int BH_Field_Rule_ID, String trxName, String... virtualColumns) {
		super(ctx, BH_Field_Rule_ID, trxName, virtualColumns);
	}

	public MBHFieldRule(Properties ctx, String BH_Field_Rule_UU, String trxName) {
		super(ctx, BH_Field_Rule_UU, trxName);
	}

	public MBHFieldRule(Properties ctx, String BH_Field_Rule_UU, String trxName, String... virtualColumns) {
		super(ctx, BH_Field_Rule_UU, trxName, virtualColumns);
	}

	public MBHFieldRule(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
