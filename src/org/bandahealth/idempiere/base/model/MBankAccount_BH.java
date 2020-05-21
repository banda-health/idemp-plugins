package org.bandahealth.idempiere.base.model;

import org.compiere.model.MBankAccount;

import java.sql.ResultSet;
import java.util.Properties;

public class MBankAccount_BH extends MBankAccount {
	/** BankAccountType AD_Reference_ID=216 */
	/** Mobile = M */
	public static final String BANKACCOUNTTYPE_Mobile = "M";

	public MBankAccount_BH(Properties ctx, int C_BankAccount_ID, String trxName) {
		super(ctx, C_BankAccount_ID, trxName);
	}

	public MBankAccount_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
