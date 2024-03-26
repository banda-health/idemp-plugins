package org.bandahealth.idempiere.base.model;

import org.compiere.model.MCurrency;

import java.sql.ResultSet;
import java.util.Properties;

// TODO: Remove this class when the "CurrencyName" iDempiere column/property added by iDempiere to their model
public class MCurrency_BH extends MCurrency {

	/**
	 * Column name CurrencyName
	 */
	public static final String COLUMNNAME_CurrencyName = "CurrencyName";

	public MCurrency_BH(Properties ctx, String C_Currency_UU, String trxName) {
		super(ctx, C_Currency_UU, trxName);
	}

	public MCurrency_BH(Properties ctx, int C_Currency_ID, String trxName) {
		super(ctx, C_Currency_ID, trxName);
	}

	public MCurrency_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public MCurrency_BH(Properties ctx, String ISO_Code, String Description, String CurSymbol, int StdPrecision,
			int CostingPrecision, String trxName) {
		super(ctx, ISO_Code, Description, CurSymbol, StdPrecision, CostingPrecision, trxName);
	}

	public MCurrency_BH(MCurrency copy) {
		super(copy);
	}

	public MCurrency_BH(Properties ctx, MCurrency copy) {
		super(ctx, copy);
	}

	public MCurrency_BH(Properties ctx, MCurrency copy, String trxName) {
		super(ctx, copy, trxName);
	}

	/**
	 * Set Currency Name.
	 *
	 * @param CurrencyName The name of the currency
	 */
	public void setCurrencyName(String CurrencyName) {
		set_Value(COLUMNNAME_CurrencyName, CurrencyName);
	}

	/**
	 * Get Currency Name.
	 *
	 * @return The name of the currency
	 */
	public String getCurrencyName() {
		return (String) get_Value(COLUMNNAME_CurrencyName);
	}
}
