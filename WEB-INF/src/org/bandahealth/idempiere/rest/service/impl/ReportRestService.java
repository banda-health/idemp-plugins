package org.bandahealth.idempiere.rest.service.impl;

import java.io.File;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.bandahealth.idempiere.rest.IRestConfigs;
import org.bandahealth.idempiere.rest.service.db.ReportDBService;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MScheduler;
import org.compiere.util.CLogger;

/**
 * Report Generator REST Service
 * 
 * @author andrew
 *
 */
@Path(IRestConfigs.REPORTS_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReportRestService {

	private CLogger log = CLogger.getCLogger(ReportRestService.class);

	private ReportDBService dbService;

	public ReportRestService() {
	}

	/**
	 * Provides a generic way to generate reports given a name
	 * 
	 * @param name
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	@POST
	@Path(IRestConfigs.GENERATE_PATH)
	@Produces(IRestConfigs.APPLICATION_PDF)
	public Response generateReport(@QueryParam("formatType") String formatType, @QueryParam("name") String name,
			@QueryParam("beginDate") String beginDate, @QueryParam("endDate") String endDate,
			@QueryParam("paymentMode") String paymentMode, @QueryParam("patientType") String patientType,
			@QueryParam("uuid") String uuid) {
		// retrieve report full name
		String reportName = ReportDBService.reportNameMapping.get(name);

		// validate report output type
		if (!StringUtil.isNotNullAndEmpty(formatType)) {
			formatType = MScheduler.REPORTOUTPUTTYPE_PDF;
		}

		dbService = new ReportDBService(formatType);

		if (reportName == null) {
			log.severe("Report '" + name + "' does not exist!");
			return null;
		}

		File report = null;

		switch (reportName) {
		case ReportDBService.INCOME_EXPENSE_REPORT:
			report = dbService.generateIncomeExpenseReport(DateUtil.parseDate(beginDate), DateUtil.parseDate(endDate));
			break;
		case ReportDBService.PATIENT_TRANSACTIONS_REPORT:
			report = dbService.generatePatientTransactionsReport(DateUtil.parseDate(beginDate),
					DateUtil.parseDate(endDate), paymentMode, patientType);
			break;
		case ReportDBService.STOCK_REORDER_REPORT:
			report = dbService.generateStockReorderReport();
			break;
		case ReportDBService.PRODUCT_AND_PRICES_REPORT:
			report = dbService.generateProductAndPriceReport();
			break;
		case ReportDBService.VALUE_OPENING_CLOSING_STOCK_REPORT:
			report = dbService.generateValueOfOpeningAndClosingStockReport(DateUtil.parseDate(beginDate),
					DateUtil.parseDate(endDate));
			break;
		case ReportDBService.MOH705A_PATIENT_VISITS_REFERRALS_REPORT:
			report = dbService.generateMoH705APatientVisitsReferralTotalsReport(DateUtil.parseDate(beginDate),
					DateUtil.parseDate(endDate));
			break;
		case ReportDBService.MOH705A_OUTPATIENT_UNDER_5_SUMMARY_REPORT:
			report = dbService.generateMoH705AOutPatientUnder5SummaryReport(DateUtil.parseDate(beginDate),
					DateUtil.parseDate(endDate));
			break;
		case ReportDBService.MOH717_NEW_REVISIT_PATIENT_COUNT_REPORT:
			report = dbService.generateMoH717NewRevisitPatientCountReport(DateUtil.parseDate(beginDate),
					DateUtil.parseDate(endDate));
			break;
		case ReportDBService.MOH705B_OUTPATIENT_OVER5_SUMMARY_REPORT:
			report = dbService.generateMoH705BOutpatientOver5SummaryReport(DateUtil.parseDate(beginDate),
					DateUtil.parseDate(endDate));
			break;
		case ReportDBService.INVENTORY_SOLD_REPORT:
			report = dbService.generateInventorySoldReport(DateUtil.parseDate(beginDate), DateUtil.parseDate(endDate));
			break;

		case ReportDBService.STOCK_DISCREPANCY_REPORT:
			report = dbService.generateStockDiscrepancyReport(DateUtil.parseDate(beginDate),
					DateUtil.parseDate(endDate));
			break;
		case ReportDBService.DONOR_FUND_REPORT:
			report = dbService.generateDonorFundReport(DateUtil.parseDate(beginDate), DateUtil.parseDate(endDate));
			break;
		case ReportDBService.DEBT_PAYMENT_RECEIPT:
			report = dbService.generateDebtPaymentReport(uuid);
			break;
		default:
			break;
		}

		if (report == null) {
			log.severe("Error Generating report " + reportName);
			return null;
		}

		return buildResponse(report, reportName, formatType);
	}

	/**
	 * Builds response object
	 * 
	 * @param report
	 * @param name
	 * @return
	 */
	private Response buildResponse(File report, String name, String format) {
		ResponseBuilder response = Response.ok((Object) report);
		response.header("Content-Disposition", "attachment; filename=\"" + name + "\"." + format.toLowerCase() + "\"");
		return response.build();
	}
}
