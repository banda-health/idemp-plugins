package org.bandahealth.idempiere.base.model;

import org.compiere.util.Env;
import org.eevolution.model.X_HR_Employee;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * Banda extension of core HR_Employee (GO-3624 hybrid): Kenya-specific payroll fields are
 * BH_ columns added by migration, so accessors live here — core's generated X_HR_Employee
 * predates them. Identity mapping: person = C_BPartner (shared with any AD_User login),
 * national ID = NationalCode, NSSF number = SSCode, deactivation = EndDate + IsActive.
 */
public class MHREmployee_BH extends X_HR_Employee {

	public static final String COLUMNNAME_BH_KRA_PIN = "BH_KRA_PIN";
	public static final String COLUMNNAME_BH_SHIF_Number = "BH_SHIF_Number";
	public static final String COLUMNNAME_BH_BankName = "BH_BankName";
	public static final String COLUMNNAME_BH_BankBranch = "BH_BankBranch";
	public static final String COLUMNNAME_BH_BankAccount = "BH_BankAccount";
	public static final String COLUMNNAME_BH_BasicSalary = "BH_BasicSalary";
	public static final String COLUMNNAME_BH_HouseAllowance = "BH_HouseAllowance";
	public static final String COLUMNNAME_BH_TransportAllowance = "BH_TransportAllowance";

	public MHREmployee_BH(Properties ctx, int HR_Employee_ID, String trxName) {
		super(ctx, HR_Employee_ID, trxName);
	}

	public MHREmployee_BH(Properties ctx, int HR_Employee_ID, String trxName, String... virtualColumns) {
		super(ctx, HR_Employee_ID, trxName, virtualColumns);
	}

	public MHREmployee_BH(Properties ctx, String HR_Employee_UU, String trxName) {
		super(ctx, HR_Employee_UU, trxName);
	}

	public MHREmployee_BH(Properties ctx, String HR_Employee_UU, String trxName, String... virtualColumns) {
		super(ctx, HR_Employee_UU, trxName, virtualColumns);
	}

	public MHREmployee_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public void setBH_KRA_PIN(String BH_KRA_PIN) {
		set_Value(COLUMNNAME_BH_KRA_PIN, BH_KRA_PIN);
	}

	public String getBH_KRA_PIN() {
		return (String) get_Value(COLUMNNAME_BH_KRA_PIN);
	}

	public void setBH_SHIF_Number(String BH_SHIF_Number) {
		set_Value(COLUMNNAME_BH_SHIF_Number, BH_SHIF_Number);
	}

	public String getBH_SHIF_Number() {
		return (String) get_Value(COLUMNNAME_BH_SHIF_Number);
	}

	public void setBH_BankName(String BH_BankName) {
		set_Value(COLUMNNAME_BH_BankName, BH_BankName);
	}

	public String getBH_BankName() {
		return (String) get_Value(COLUMNNAME_BH_BankName);
	}

	public void setBH_BankBranch(String BH_BankBranch) {
		set_Value(COLUMNNAME_BH_BankBranch, BH_BankBranch);
	}

	public String getBH_BankBranch() {
		return (String) get_Value(COLUMNNAME_BH_BankBranch);
	}

	public void setBH_BankAccount(String BH_BankAccount) {
		set_Value(COLUMNNAME_BH_BankAccount, BH_BankAccount);
	}

	public String getBH_BankAccount() {
		return (String) get_Value(COLUMNNAME_BH_BankAccount);
	}

	public void setBH_BasicSalary(BigDecimal BH_BasicSalary) {
		set_Value(COLUMNNAME_BH_BasicSalary, BH_BasicSalary);
	}

	public BigDecimal getBH_BasicSalary() {
		BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_BH_BasicSalary);
		return bd == null ? Env.ZERO : bd;
	}

	public void setBH_HouseAllowance(BigDecimal BH_HouseAllowance) {
		set_Value(COLUMNNAME_BH_HouseAllowance, BH_HouseAllowance);
	}

	public BigDecimal getBH_HouseAllowance() {
		BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_BH_HouseAllowance);
		return bd == null ? Env.ZERO : bd;
	}

	public void setBH_TransportAllowance(BigDecimal BH_TransportAllowance) {
		set_Value(COLUMNNAME_BH_TransportAllowance, BH_TransportAllowance);
	}

	public BigDecimal getBH_TransportAllowance() {
		BigDecimal bd = (BigDecimal) get_Value(COLUMNNAME_BH_TransportAllowance);
		return bd == null ? Env.ZERO : bd;
	}
}
