package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHAllergy extends X_BH_Allergy {
	public MBHAllergy(Properties ctx, int BH_Allergy_ID, String trxName) {
		super(ctx, BH_Allergy_ID, trxName);
	}

	public MBHAllergy(Properties ctx, int BH_Allergy_ID, String trxName, String... virtualColumns) {
		super(ctx, BH_Allergy_ID, trxName, virtualColumns);
	}

	public MBHAllergy(Properties ctx, String BH_Allergy_UU, String trxName) {
		super(ctx, BH_Allergy_UU, trxName);
	}

	public MBHAllergy(Properties ctx, String BH_Allergy_UU, String trxName, String... virtualColumns) {
		super(ctx, BH_Allergy_UU, trxName, virtualColumns);
	}

	public MBHAllergy(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
