package org.bandahealth.idempiere.rest.service.db;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.process.ProcessInfoParameter;

/**
 * Generates iDempiere reports
 * 
 * @author andrew
 *
 */
public class ReportDBService extends BaseReportDBProcess {

	// report names
	public static final String INCOME_EXPENSE_REPORT = "Income & Expenses";
	public static final String INCOME_EXPENSE_REPORT_VALUE = "incomeexpensereport"; 
	public static final String THERMAL_RECEIPT_REPORT = "BH Thermal Receipt";
	public static final String PATIENT_TRANSACTIONS_REPORT = "Patient Transactions";
	public static final String PATIENT_TRANSACTIONS_REPORT_VALUE = "patienttransactionreport";
	public static final String STOCK_REORDER_REPORT = "Stock to be Ordered";
	public static final String STOCK_REORDER_REPORT_VALUE = "stockreorderreport";
	public static final String PRODUCT_AND_PRICES_REPORT = "Products and Prices";
	public static final String PRODUCT_AND_PRICES_REPORT_VALUE = "productandpricereport";
	public static final String VALUE_OPENING_CLOSING_STOCK_REPORT = "Value of Opening and Closing Stock";
	public static final String VALUE_OPENING_CLOSING_STOCK_REPORT_VALUE = "valueofopeningandclosingstockreport";
	public static final String MOH705A_PATIENT_VISITS_REFERRALS_REPORT = "MoH705A Patient Visits and Referrals";
	public static final String MOH705A_PATIENT_VISITS_REFERRALS_REPORT_VALUE = "mohpatientvisitsreferralreport";
	public static final String MOH705A_OUTPATIENT_UNDER_5_SUMMARY_REPORT = "MoH705A Out Patient Under 5yr Summary";
	public static final String MOH705A_OUTPATIENT_UNDER_5_SUMMARY_REPORT_VALUE = "mohoutpatientunder5summaryreport";
	public static final String MOH717_NEW_REVISIT_PATIENT_COUNT_REPORT = "MoH717 New and Revisit Patient Count";
	public static final String MOH717_NEW_REVISIT_PATIENT_COUNT_REPORT_VALUE = "mohnewrevisitpatientcountreport";
	public static final String MOH705B_OUTPATIENT_OVER5_SUMMARY_REPORT = "MoH705B Out Patient Over 5yr Summary";
	public static final String MOH705B_OUTPATIENT_OVER5_SUMMARY_REPORT_VALUE = "mohoutpatientover5summaryreport";
	public static final String INVENTORY_SOLD_REPORT = "Inventory Sold Report";
	public static final String INVENTORY_SOLD_REPORT_VALUE = "inventorysoldreport";
	public static final String STOCK_DISCREPANCY_REPORT = "Stock Discrepancy Report";
	public static final String STOCK_DISCREPANCY_REPORT_VALUE = "stockdiscrepancyreport";
	public static final String DONOR_FUND_REPORT = "Donor Fund Report";
	public static final String DONOR_FUND_REPORT_VALUE = "donorfundreport";
	public static final String DEBT_PAYMENT_RECEIPT = "Debt Payment Receipt";
	public static final String DEBT_PAYMENT_RECEIPT_VALUE = "debtpaymentreceipt";
	public static final String PAYMENT_TRAIL_REPORT = "Payment Trail report";
	public static final String PAYMENT_TRAIL_REPORT_VALUE = "paymenttrailreport";
	public static final String DIAGNOSIS_REPORT = "Diagnosis Report";
	public static final String DIAGNOSIS_REPORT_VALUE = "diagnosisreport";

	public static final Map<String, String> reportNameMapping = new HashMap<String, String>() {
		{
			put(INCOME_EXPENSE_REPORT_VALUE, INCOME_EXPENSE_REPORT);
			put(PATIENT_TRANSACTIONS_REPORT_VALUE, PATIENT_TRANSACTIONS_REPORT);
			put(STOCK_REORDER_REPORT_VALUE, STOCK_REORDER_REPORT);
			put(PRODUCT_AND_PRICES_REPORT_VALUE, PRODUCT_AND_PRICES_REPORT);
			put(VALUE_OPENING_CLOSING_STOCK_REPORT_VALUE, VALUE_OPENING_CLOSING_STOCK_REPORT);
			put(MOH705A_PATIENT_VISITS_REFERRALS_REPORT_VALUE, MOH705A_PATIENT_VISITS_REFERRALS_REPORT);
			put(MOH705A_OUTPATIENT_UNDER_5_SUMMARY_REPORT_VALUE, MOH705A_OUTPATIENT_UNDER_5_SUMMARY_REPORT);
			put(MOH717_NEW_REVISIT_PATIENT_COUNT_REPORT_VALUE, MOH717_NEW_REVISIT_PATIENT_COUNT_REPORT);
			put(MOH705B_OUTPATIENT_OVER5_SUMMARY_REPORT_VALUE, MOH705B_OUTPATIENT_OVER5_SUMMARY_REPORT);
			put(INVENTORY_SOLD_REPORT_VALUE, INVENTORY_SOLD_REPORT);
			put(STOCK_DISCREPANCY_REPORT_VALUE, STOCK_DISCREPANCY_REPORT);
			put(DONOR_FUND_REPORT_VALUE, DONOR_FUND_REPORT);
			put(DEBT_PAYMENT_RECEIPT_VALUE, DEBT_PAYMENT_RECEIPT);
			put(PAYMENT_TRAIL_REPORT_VALUE, PAYMENT_TRAIL_REPORT);
			put(DIAGNOSIS_REPORT_VALUE, DIAGNOSIS_REPORT);
		}
	};

	// parameters
	private final String BILL_ID = "billId";
	private final String BEGIN_DATE = "Begin Date";
	private final String END_DATE = "End Date";
	private final String PAYMENT_MODE = "Payment Mode";
	private final String PATIENT_TYPE = "Patient Type";
	private final String DEBT_PAYMENT_ID = "debtPaymentID";
	private final String C_BPARTNER_UU = "c_bpartner_uu";
	private final String DIAGNOSIS = "Diagnosis";

	private String reportOutputType;

	public ReportDBService(String reportOutputType) {
		this.reportOutputType = reportOutputType;
	}

	/**
	 * Generates thermal receipt for given bill id
	 * 
	 * @param reportName
	 * @param tableId
	 * @param recordId
	 */
	public File generateThermalReceipt(BigDecimal billId) {
		return generateReport(THERMAL_RECEIPT_REPORT, reportOutputType,
				new ProcessInfoParameter[] { new ProcessInfoParameter(BILL_ID, billId, null, null, null) });
	}

	/**
	 * Generates Income & Expense Report
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public File generateIncomeExpenseReport(Date beginDate, Date endDate) {
		return generateReport(INCOME_EXPENSE_REPORT, reportOutputType,
				new ProcessInfoParameter[] { new ProcessInfoParameter(BEGIN_DATE, beginDate, null, null, null),
						new ProcessInfoParameter(END_DATE, endDate, null, null, null) });
	}

	/**
	 * Generates Patient Transactions Report
	 * 
	 * @param beginDate
	 * @param endDate
	 * @param paymentMode
	 * @param patientType
	 * @return
	 */
	public File generatePatientTransactionsReport(Date beginDate, Date endDate, String paymentMode,
			String patientType) {
		List<ProcessInfoParameter> parameters = new ArrayList<>();
		parameters.add(new ProcessInfoParameter(BEGIN_DATE, beginDate, null, null, null));
		parameters.add(new ProcessInfoParameter(END_DATE, endDate, null, null, null));

		// check payment mode
		if (StringUtil.isNotNullAndEmpty(paymentMode)) {
			parameters.add(new ProcessInfoParameter(PAYMENT_MODE, paymentMode, null, null, null));
		}

		// check patient type
		if (StringUtil.isNotNullAndEmpty(patientType)) {
			parameters.add(new ProcessInfoParameter(PATIENT_TYPE, patientType, null, null, null));
		}

		return generateReport(PATIENT_TRANSACTIONS_REPORT, reportOutputType,
				parameters.stream().toArray(ProcessInfoParameter[]::new));
	}

	/**
	 * Generates Stock Reorder Report
	 * 
	 * @return
	 */
	public File generateStockReorderReport() {
		return generateReport(STOCK_REORDER_REPORT, reportOutputType, null);
	}

	/**
	 * Generates Products and Prices Report
	 * 
	 * @return
	 */
	public File generateProductAndPriceReport() {
		return generateReport(PRODUCT_AND_PRICES_REPORT, reportOutputType, null);
	}

	/**
	 * Generates Value of opening and closing stock report
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public File generateValueOfOpeningAndClosingStockReport(Date beginDate, Date endDate) {
		return generateReport(VALUE_OPENING_CLOSING_STOCK_REPORT, reportOutputType,
				new ProcessInfoParameter[] { new ProcessInfoParameter(BEGIN_DATE, beginDate, null, null, null),
						new ProcessInfoParameter(END_DATE, endDate, null, null, null) });
	}

	/**
	 * Generates MoH705A Patient Visits and Referral Totals report
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public File generateMoH705APatientVisitsReferralTotalsReport(Date beginDate, Date endDate) {
		return generateReport(MOH705A_PATIENT_VISITS_REFERRALS_REPORT, reportOutputType,
				new ProcessInfoParameter[] { new ProcessInfoParameter(BEGIN_DATE, beginDate, null, null, null),
						new ProcessInfoParameter(END_DATE, endDate, null, null, null) });
	}

	/**
	 * Generates MoH705A Out Patient Under 5yr Summary report
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public File generateMoH705AOutPatientUnder5SummaryReport(Date beginDate, Date endDate) {
		return generateReport(MOH705A_OUTPATIENT_UNDER_5_SUMMARY_REPORT, reportOutputType,
				new ProcessInfoParameter[] { new ProcessInfoParameter(BEGIN_DATE, beginDate, null, null, null),
						new ProcessInfoParameter(END_DATE, endDate, null, null, null) });
	}

	/**
	 * Generates MoH717 New and Revisit Patient Count report
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public File generateMoH717NewRevisitPatientCountReport(Date beginDate, Date endDate) {
		return generateReport(MOH717_NEW_REVISIT_PATIENT_COUNT_REPORT, reportOutputType,
				new ProcessInfoParameter[] { new ProcessInfoParameter(BEGIN_DATE, beginDate, null, null, null),
						new ProcessInfoParameter(END_DATE, endDate, null, null, null) });
	}

	/**
	 * Generates MoH705B Out Patient Over 5yr Summary report
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public File generateMoH705BOutpatientOver5SummaryReport(Date beginDate, Date endDate) {
		return generateReport(MOH705B_OUTPATIENT_OVER5_SUMMARY_REPORT, reportOutputType,
				new ProcessInfoParameter[] { new ProcessInfoParameter(BEGIN_DATE, beginDate, null, null, null),
						new ProcessInfoParameter(END_DATE, endDate, null, null, null) });
	}

	/**
	 * Generates Inventory Sold Report
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public File generateInventorySoldReport(Date beginDate, Date endDate) {
		return generateReport(INVENTORY_SOLD_REPORT, reportOutputType,
				new ProcessInfoParameter[] { new ProcessInfoParameter(BEGIN_DATE, beginDate, null, null, null),
						new ProcessInfoParameter(END_DATE, endDate, null, null, null) });
	}

	/**
	 * Generates Stock Discrepancy Report
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public File generateStockDiscrepancyReport(Date beginDate, Date endDate) {
		return generateReport(STOCK_DISCREPANCY_REPORT, reportOutputType,
				new ProcessInfoParameter[] { new ProcessInfoParameter(BEGIN_DATE, beginDate, null, null, null),
						new ProcessInfoParameter(END_DATE, endDate, null, null, null) });
	}

	/**
	 * Generates Donor Fund Report
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public File generateDonorFundReport(Date beginDate, Date endDate) {
		return generateReport(DONOR_FUND_REPORT, reportOutputType,
				new ProcessInfoParameter[] { new ProcessInfoParameter(BEGIN_DATE, beginDate, null, null, null),
						new ProcessInfoParameter(END_DATE, endDate, null, null, null) });
	}

	/**
	 * Generates Debt Payment Report
	 * 
	 * @param uuid
	 * @return
	 */
	public File generateDebtPaymentReport(String uuid) {
		if (uuid == null || uuid.isEmpty()) {
			return null;
		}

		// retrieve payment from DB
		MPayment_BH payment = new PaymentDBService().getEntityByUuidFromDB(uuid);
		if (payment == null) {
			return null;
		}
		
		return generateReport(DEBT_PAYMENT_RECEIPT, reportOutputType, new ProcessInfoParameter[] {
				new ProcessInfoParameter(DEBT_PAYMENT_ID, BigDecimal.valueOf(payment.get_ID()), null, null, null) });
	}
	
	/**
	 * Generates Payment Trail Report
	 * 
	 * @param patientUuid
	 * @param beginDate
	 * @param endDate
	 * @return generated File
	 */
	public File generatePaymentTrailReport(String patientUuid) {
		return generateReport(PAYMENT_TRAIL_REPORT, reportOutputType,
				new ProcessInfoParameter[] { new ProcessInfoParameter(C_BPARTNER_UU, patientUuid, null, null, null)});
	}
	
	public File generateDiagnosisReport(Date beginDate, Date endDate, String diagnosis) {
		return generateReport(DIAGNOSIS_REPORT, reportOutputType,
				new ProcessInfoParameter[] { 
						new ProcessInfoParameter(BEGIN_DATE, beginDate, null, null, null),
						new ProcessInfoParameter(END_DATE, endDate, null, null, null),
						new ProcessInfoParameter(DIAGNOSIS, diagnosis, null, null, null)});
	}
}
