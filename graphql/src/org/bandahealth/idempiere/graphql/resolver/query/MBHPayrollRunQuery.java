package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHEmployeeComponent;
import org.bandahealth.idempiere.base.model.MBHPayrollComponent;
import org.bandahealth.idempiere.base.model.MHREmployee_BH;
import org.bandahealth.idempiere.base.model.PayrollAssignment;
import org.bandahealth.idempiere.base.model.PayrollBreakdown;
import org.bandahealth.idempiere.base.model.PayrollCalculator;
import org.bandahealth.idempiere.base.model.PayrollComponent;
import org.bandahealth.idempiere.base.model.PayrollEarnings;
import org.bandahealth.idempiere.base.model.PayrollLineItem;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.model.PayrollPreviewItem;
import org.bandahealth.idempiere.graphql.model.PayrollPreviewResult;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.util.Env;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class MBHPayrollRunQuery extends X_BH_Payroll_RunQuery {

	/**
	 * Stateless net-pay preview computed from the resolved catalogue as of today. No rows written,
	 * no audit. Employee-specific assignments are included only when an employee UUID is supplied.
	 */
	public PayrollPreviewResult BH_PayrollPreview(BigDecimal BH_BasicSalary, BigDecimal BH_HouseAllowance,
			BigDecimal BH_TransportAllowance, String HR_Employee_UU, DataFetchingEnvironment environment) {
		Properties ctx = BandaGraphQLContext.getCtx(environment);
		int clientId = Env.getAD_Client_ID(ctx);
		Timestamp asOf = new Timestamp(System.currentTimeMillis());

		List<MBHPayrollComponent> catalogue = MBHPayrollComponent.getEffectiveAll(ctx, clientId, asOf, null);
		List<PayrollComponent> specs = catalogue.stream().map(component -> component.toSpec(null))
				.collect(Collectors.toList());

		List<PayrollAssignment> assignments = Collections.emptyList();
		if (HR_Employee_UU != null && !HR_Employee_UU.isEmpty()) {
			MHREmployee_BH employee = Repository.getByUuid(ctx, MHREmployee_BH.Table_Name, null, HR_Employee_UU);
			if (employee != null) {
				assignments = MBHEmployeeComponent.resolveAssignments(ctx, employee.get_ID(), catalogue, asOf, asOf,
						null);
			}
		}

		PayrollEarnings earnings = new PayrollEarnings(BH_BasicSalary, BH_HouseAllowance, BH_TransportAllowance);
		PayrollBreakdown breakdown = PayrollCalculator.calculate(earnings, specs, assignments);

		PayrollPreviewResult result = new PayrollPreviewResult();
		result.setBH_GrossPay(breakdown.grossPay);
		result.setBH_TaxablePay(breakdown.taxablePay);
		result.setBH_PAYE_Amount(breakdown.payeAmount);
		result.setBH_TotalDeductions(breakdown.totalDeductions);
		result.setBH_NetPay(breakdown.netPay);
		result.setBH_CostToEmployer(breakdown.costToEmployer);

		List<PayrollPreviewItem> items = new ArrayList<>();
		for (PayrollLineItem lineItem : breakdown.items) {
			PayrollPreviewItem item = new PayrollPreviewItem();
			item.setValue(lineItem.code);
			item.setName(lineItem.name);
			item.setBH_Category(lineItem.category);
			item.setBH_EmployeeAmount(lineItem.employeeAmount);
			item.setBH_EmployerAmount(lineItem.employerAmount);
			items.add(item);
		}
		result.setItems(items);
		return result;
	}
}
