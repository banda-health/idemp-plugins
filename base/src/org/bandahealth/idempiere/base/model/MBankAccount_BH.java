package org.bandahealth.idempiere.base.model;

import org.compiere.model.MBankAccount;
import org.compiere.model.MTable;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Collectors;

public class MBankAccount_BH extends MBankAccount {
	/** BankAccountType AD_Reference_ID=216 */
	/**
	 * Mobile = M
	 */
	public static final String BANKACCOUNTTYPE_Mobile = "M";

	public MBankAccount_BH(Properties ctx, int C_BankAccount_ID, String trxName) {
		super(ctx, C_BankAccount_ID, trxName);
	}

	public MBankAccount_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	/**
	 * Gets a bank account mapped to a reference list value, if it exists
	 *
	 * @param ctx
	 * @param trxName
	 * @param referenceId  The AD_Reference_ID of the list to look up
	 * @param refListValue The AD_Ref_List_Value to find a mapping for
	 * @return Either a BankAccount, or null
	 */
	public static MBankAccount getBankAccountMappedToRefListValue(
			Properties ctx, String trxName, int referenceId, String refListValue) {
		MBHPaymentRef paymentRef = new Query(
				ctx,
				MBHPaymentRef.Table_Name,
				MBHPaymentRef.COLUMNNAME_AD_Reference_ID + "=? AND " + MBHPaymentRef.COLUMNNAME_AD_Org_ID + "=?",
				trxName
		)
				.setParameters(referenceId, Env.getAD_Org_ID(ctx))
				.first();
		if (paymentRef != null) {
			Map<String, List<MBHPaymentRefBankAccount>> paymentRefBankAccountMap =
					paymentRef.getBH_PaymentRef_BankAccounts().stream()
							.collect(Collectors.groupingBy(MBHPaymentRefBankAccount::getBH_PaymentRefList_Value));
			if (paymentRefBankAccountMap.containsKey(refListValue)) {
				// Make sure the bank account exists and is active
				MBankAccount mappedBankAccount = (MBankAccount) MTable.get(ctx, MBankAccount.Table_Name)
						.getPO(paymentRefBankAccountMap.get(refListValue).get(0).getC_BankAccount_ID(), trxName);
				if (mappedBankAccount != null && mappedBankAccount.isActive()) {
					return mappedBankAccount;
				}
			}
		}
		return null;
	}
}
