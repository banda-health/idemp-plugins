package org.bandahealth.idempiere.base.model;

import org.bandahealth.idempiere.base.payroll.PayeBand;
import org.bandahealth.idempiere.base.payroll.PayrollComponent;
import org.compiere.model.Query;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

public class MBHPayrollComponent extends X_BH_Payroll_Component {

	public MBHPayrollComponent(Properties ctx, int BH_Payroll_Component_ID, String trxName) {
		super(ctx, BH_Payroll_Component_ID, trxName);
	}

	public MBHPayrollComponent(Properties ctx, int BH_Payroll_Component_ID, String trxName, String... virtualColumns) {
		super(ctx, BH_Payroll_Component_ID, trxName, virtualColumns);
	}

	public MBHPayrollComponent(Properties ctx, String BH_Payroll_Component_UU, String trxName) {
		super(ctx, BH_Payroll_Component_UU, trxName);
	}

	public MBHPayrollComponent(Properties ctx, String BH_Payroll_Component_UU, String trxName, String... virtualColumns) {
		super(ctx, BH_Payroll_Component_UU, trxName, virtualColumns);
	}

	public MBHPayrollComponent(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	/**
	 * The catalogue in force for a clinic at a point in time, resolved per code (Value):
	 * the clinic row beats the System row, and among a code's candidates the latest
	 * ValidFrom &lt;= asOf wins. Resolution runs BEFORE the IsActive filter so a clinic
	 * can suppress an inherited component by overriding it with an IsActive='N' row.
	 */
	public static List<MBHPayrollComponent> getEffectiveAll(Properties ctx, int clientId, Timestamp asOf,
			String trxName) {
		List<MBHPayrollComponent> candidates = new Query(ctx, Table_Name,
				COLUMNNAME_AD_Client_ID + " IN (0,?) AND " + COLUMNNAME_ValidFrom + "<=?", trxName)
				.setParameters(clientId, asOf)
				// per code: clinic rows beat System rows, then the latest regime wins
				.setOrderBy(COLUMNNAME_Value + ", " + COLUMNNAME_AD_Client_ID + " DESC, " + COLUMNNAME_ValidFrom
						+ " DESC")
				.list();
		Map<String, MBHPayrollComponent> byCode = new LinkedHashMap<>();
		for (MBHPayrollComponent candidate : candidates) {
			byCode.putIfAbsent(candidate.getValue(), candidate); // first row per code = winner (order above)
		}
		return byCode.values().stream().filter(MBHPayrollComponent::isActive).collect(Collectors.toList());
	}

	/**
	 * This row as the calculator's value object; for the BANDS method, loads the ordered
	 * BH_PAYE_Band children. Nullable numerics are read raw so NULL survives (the PO
	 * getters coerce NULL to ZERO, which would turn the open-ended top band into a cap).
	 */
	public PayrollComponent toSpec(String trxName) {
		List<PayeBand> bands = null;
		if (PayrollComponent.METHOD_BANDS.equals(getBH_CalcMethod())) {
			bands = new Query(getCtx(), MBHPAYEBand.Table_Name,
					MBHPAYEBand.COLUMNNAME_BH_Payroll_Component_ID + "=?", trxName)
					.setParameters(getBH_Payroll_Component_ID())
					.setOnlyActiveRecords(true)
					.setOrderBy(MBHPAYEBand.COLUMNNAME_SeqNo)
					.<MBHPAYEBand>list().stream()
					.map(band -> new PayeBand((BigDecimal) band.get_Value(MBHPAYEBand.COLUMNNAME_BH_UpperLimit),
							band.getBH_Rate()))
					.collect(Collectors.toList());
		}
		return new PayrollComponent(getValue(), getName(), getBH_Category(), getBH_CalcMethod(),
				decimalOrNull(COLUMNNAME_BH_Rate), decimalOrNull(COLUMNNAME_BH_Floor), decimalOrNull(COLUMNNAME_BH_Cap),
				decimalOrNull(COLUMNNAME_BH_Tier1_Limit), decimalOrNull(COLUMNNAME_BH_Tier2_Limit),
				decimalOrNull(COLUMNNAME_BH_EmployerRate), isBH_IsTaxDeductible(),
				decimalOrNull(COLUMNNAME_BH_TaxDeductibleCap), getSeqNo(), bands);
	}

	private BigDecimal decimalOrNull(String columnName) {
		return (BigDecimal) get_Value(columnName);
	}
}
