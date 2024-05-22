package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHPayerInfoFldValSug extends X_BH_Payer_Info_Fld_Val_Sug {
	public MBHPayerInfoFldValSug(Properties ctx, int BH_Payer_Info_Fld_Val_Sug_ID, String trxName) {
		super(ctx, BH_Payer_Info_Fld_Val_Sug_ID, trxName);
	}

	public MBHPayerInfoFldValSug(Properties ctx, int BH_Payer_Info_Fld_Val_Sug_ID, String trxName,
			String... virtualColumns) {
		super(ctx, BH_Payer_Info_Fld_Val_Sug_ID, trxName, virtualColumns);
	}

	public MBHPayerInfoFldValSug(Properties ctx, String BH_Payer_Info_Fld_Val_Sug_UU, String trxName) {
		super(ctx, BH_Payer_Info_Fld_Val_Sug_UU, trxName);
	}

	public MBHPayerInfoFldValSug(Properties ctx, String BH_Payer_Info_Fld_Val_Sug_UU, String trxName,
			String... virtualColumns) {
		super(ctx, BH_Payer_Info_Fld_Val_Sug_UU, trxName, virtualColumns);
	}

	public MBHPayerInfoFldValSug(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
