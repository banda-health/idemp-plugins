package org.bandahealth.idempiere.base.model;

import org.bandahealth.idempiere.base.payroll.PayrollAssignment;
import org.compiere.model.Query;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

public class MBHEmployeeComponent extends X_BH_Employee_Component {

	public MBHEmployeeComponent(Properties ctx, int BH_Employee_Component_ID, String trxName) {
		super(ctx, BH_Employee_Component_ID, trxName);
	}

	public MBHEmployeeComponent(Properties ctx, int BH_Employee_Component_ID, String trxName, String... virtualColumns) {
		super(ctx, BH_Employee_Component_ID, trxName, virtualColumns);
	}

	public MBHEmployeeComponent(Properties ctx, String BH_Employee_Component_UU, String trxName) {
		super(ctx, BH_Employee_Component_UU, trxName);
	}

	public MBHEmployeeComponent(Properties ctx, String BH_Employee_Component_UU, String trxName, String... virtualColumns) {
		super(ctx, BH_Employee_Component_UU, trxName, virtualColumns);
	}

	public MBHEmployeeComponent(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	/**
	 * The employee's assignments in force during [periodStart, periodEnd], resolved BY CODE:
	 * the stored component FK may point at a superseded row (overrides and regime rows mint
	 * new rows); its Value is looked up in the resolved catalogue and the EFFECTIVE component's
	 * code is used. A code absent from the catalogue (disabled for this clinic) is skipped.
	 */
	public static List<PayrollAssignment> resolveAssignments(Properties ctx, int hrEmployeeId,
			List<MBHPayrollComponent> effectiveCatalogue, Timestamp periodStart, Timestamp periodEnd,
			String trxName) {
		Set<String> effectiveCodes = effectiveCatalogue.stream().map(MBHPayrollComponent::getValue)
				.collect(Collectors.toSet());
		List<MBHEmployeeComponent> assignments = new Query(ctx, Table_Name,
				COLUMNNAME_HR_Employee_ID + "=? AND " + COLUMNNAME_ValidFrom + "<=? AND ("
						+ COLUMNNAME_ValidTo + " IS NULL OR " + COLUMNNAME_ValidTo + ">=?)", trxName)
				.setParameters(hrEmployeeId, periodEnd, periodStart)
				.setOnlyActiveRecords(true)
				.list();
		List<PayrollAssignment> resolved = new ArrayList<>();
		for (MBHEmployeeComponent assignment : assignments) {
			MBHPayrollComponent storedRow = new MBHPayrollComponent(ctx,
					assignment.getBH_Payroll_Component_ID(), trxName);
			if (effectiveCodes.contains(storedRow.getValue())) {
				resolved.add(new PayrollAssignment(storedRow.getValue(), assignment.getBH_Amount()));
			}
		}
		return resolved;
	}
}
