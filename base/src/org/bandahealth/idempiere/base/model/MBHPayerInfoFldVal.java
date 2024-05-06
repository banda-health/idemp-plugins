package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHPayerInfoFldVal extends X_BH_Payer_Info_Fld_Val {
	public MBHPayerInfoFldVal(Properties ctx, int BH_Payer_Info_Fld_Val_ID, String trxName) {
		super(ctx, BH_Payer_Info_Fld_Val_ID, trxName);
	}

	public MBHPayerInfoFldVal(Properties ctx, int BH_Payer_Info_Fld_Val_ID, String trxName, String... virtualColumns) {
		super(ctx, BH_Payer_Info_Fld_Val_ID, trxName, virtualColumns);
	}

	public MBHPayerInfoFldVal(Properties ctx, String BH_Payer_Info_Fld_Val_UU, String trxName) {
		super(ctx, BH_Payer_Info_Fld_Val_UU, trxName);
	}

	public MBHPayerInfoFldVal(Properties ctx, String BH_Payer_Info_Fld_Val_UU, String trxName,
			String... virtualColumns) {
		super(ctx, BH_Payer_Info_Fld_Val_UU, trxName, virtualColumns);
	}

	public MBHPayerInfoFldVal(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
