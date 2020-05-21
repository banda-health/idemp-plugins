package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MBHPaymentRef extends X_BH_PaymentRef {
	public MBHPaymentRef(Properties ctx, int BH_PaymentRef_ID, String trxName) {
		super(ctx, BH_PaymentRef_ID, trxName);
	}

	public MBHPaymentRef(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
