package org.bandahealth.idempiere.report.test;

import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.bandahealth.idempiere.base.model.MBHCodedDiagnosis;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.report.test.utils.PDFUtils;
import org.bandahealth.idempiere.report.test.utils.TimestampUtils;
import org.compiere.model.Query;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.util.Env;
import org.hamcrest.Matchers;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoH705AOutPatientUnder5yrSummaryTest extends ChuBoePopulateFactoryVO {
	private static final String reportUuid = "c9f91d23-48ea-4990-af5d-f3e7f0db77de";

	@IPopulateAnnotation.CanRunBeforeClass
	public void prepareIt() throws Exception {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), Matchers.is(Matchers.nullValue()));

		valueObject.setStepName("Open needed periods");
		ChuBoeCreateEntity.createAndOpenAllFiscalYears(valueObject);
		commitEx();
	}

	@IPopulateAnnotation.CanRun
	public void canRunReport() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		String diagnosisToSearchFor = "Burns";
		String diagnosisAfterDiagnosisToSearchForOnReport = "Snakebites";

		int currentClientId = Env.getAD_Client_ID(Env.getCtx());
		MBHCodedDiagnosis codedDiagnosis = null;
		try {
			Env.setContext(valueObject.getContext(), Env.AD_CLIENT_ID, 0);
			codedDiagnosis = new Query(valueObject.getContext(), MBHCodedDiagnosis.Table_Name,
					MBHCodedDiagnosis.COLUMNNAME_bh_cielname + "=?", valueObject.getTransactionName())
							.setParameters(diagnosisToSearchFor).first();
			if (codedDiagnosis == null) {
				valueObject.setStepName("Create the burns coded diagnosis");
				codedDiagnosis = new MBHCodedDiagnosis(valueObject.getContext(), 0, valueObject.getTransactionName());
				codedDiagnosis.setbh_cielname(diagnosisToSearchFor);
			}
			codedDiagnosis.setbh_moh705a_lessthan5("Burns");
			codedDiagnosis.saveEx();
			commitEx();
		} finally {
			Env.setContext(valueObject.getContext(), Env.AD_CLIENT_ID, currentClientId);
		}

		valueObject.setStepName("Generate the report to get initial data");
		valueObject.setProcessUuid(reportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		Timestamp startOfMonth = TimestampUtils.startOfMonth();
		Timestamp endOfMonth = TimestampUtils.endOfMonth();
		valueObject.setProcessInformationParameters(
				Arrays.asList(new ProcessInfoParameter("Begin Date", startOfMonth, null, null, null),
						new ProcessInfoParameter("End Date", endOfMonth, null, null, null)));
		ChuBoeCreateEntity.runReport(valueObject);
		String reportContent = PDFUtils.readPdfContent(valueObject.getReport(), true);
		List<String> diagnosisData = getDataBetweenDiagnoses(reportContent, diagnosisToSearchFor,
				diagnosisAfterDiagnosisToSearchForOnReport);
		int numberOfDiagnoses = getDiagnosesCountForDate(startOfMonth, TimestampUtils.today(), diagnosisData);

		Calendar calendar = GregorianCalendar.getInstance();
		calendar.add(Calendar.YEAR, -3);
		Timestamp threeYearsAgo = new Timestamp(calendar.getTimeInMillis());
		calendar.add(Calendar.YEAR, -3);
		Timestamp sixYearsAgo = new Timestamp(calendar.getTimeInMillis());

		valueObject.setStepName("Create a young patient");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		valueObject.getBusinessPartner().setBH_Birthday(threeYearsAgo);
		valueObject.getBusinessPartner().saveEx();
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(100));
		ChuBoeCreateEntity.createOrder(valueObject);
		valueObject.setQuantity(null);
		commitEx();

		valueObject.setStepName("Create visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		valueObject.getVisit().setBH_PrimaryCodedDiagnosis_ID(codedDiagnosis.get_ID());
		valueObject.getVisit().saveEx();
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setRandom();
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true,
				false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create an older patient");
		valueObject.setBusinessPartner(null);
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		valueObject.getBusinessPartner().setBH_Birthday(sixYearsAgo);
		valueObject.getBusinessPartner().saveEx();
		commitEx();

		valueObject.setStepName("Create visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		valueObject.getVisit().setBH_PrimaryCodedDiagnosis_ID(codedDiagnosis.get_ID());
		valueObject.getVisit().saveEx();
		commitEx();

		valueObject.setStepName("Create order");
		valueObject.setRandom();
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true,
				false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(reportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				Arrays.asList(new ProcessInfoParameter("Begin Date", startOfMonth, null, null, null),
						new ProcessInfoParameter("End Date", endOfMonth, null, null, null)));
		ChuBoeCreateEntity.runReport(valueObject);

		reportContent = PDFUtils.readPdfContent(valueObject.getReport(), true);
		diagnosisData = getDataBetweenDiagnoses(reportContent, diagnosisToSearchFor,
				diagnosisAfterDiagnosisToSearchForOnReport);
		int newNumberOfDiagnoses = getDiagnosesCountForDate(startOfMonth, TimestampUtils.today(), diagnosisData);

		assertThat("Number of diagnoses correctly counted", newNumberOfDiagnoses, is(numberOfDiagnoses + 1));
	}

	@IPopulateAnnotation.CanRun
	public void removeWellChildVisitsFromReport() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		String diagnosisToSearchFor = "Asthma";
		String diagnosisAfterDiagnosisToSearchForOnReport = "Suspected Malaria";

		int currentClientId = Env.getAD_Client_ID(Env.getCtx());
		MBHCodedDiagnosis codedDiagnosis = null;
		try {
			Env.setContext(valueObject.getContext(), Env.AD_CLIENT_ID, 0);
			codedDiagnosis = new Query(valueObject.getContext(), MBHCodedDiagnosis.Table_Name,
					MBHCodedDiagnosis.COLUMNNAME_bh_cielname + "=?", valueObject.getTransactionName())
							.setParameters(diagnosisToSearchFor).first();
			if (codedDiagnosis == null) {
				valueObject.setStepName("Create asthma coded diagnosis");
				codedDiagnosis = new MBHCodedDiagnosis(valueObject.getContext(), 0, valueObject.getTransactionName());
				codedDiagnosis.setbh_cielname(diagnosisToSearchFor);
			}
			codedDiagnosis.setbh_moh705a_lessthan5("Asthma");
			codedDiagnosis.saveEx();
			commitEx();
		} finally {
			Env.setContext(valueObject.getContext(), Env.AD_CLIENT_ID, currentClientId);
		}
		
		valueObject.setStepName("Generate the report to get initial data");
		valueObject.setProcessUuid(reportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.add(Calendar.YEAR, -3);
		Timestamp threeYearsAgo = new Timestamp(calendar.getTimeInMillis());
		calendar.add(Calendar.YEAR, -3);
		Timestamp startOfMonth = TimestampUtils.startOfMonth();
		Timestamp endOfMonth = TimestampUtils.endOfMonth();
		valueObject.setProcessInformationParameters(
				Arrays.asList(new ProcessInfoParameter("Begin Date", startOfMonth, null, null, null),
						new ProcessInfoParameter("End Date", endOfMonth, null, null, null)));
		ChuBoeCreateEntity.runReport(valueObject);
		String reportContent = PDFUtils.readPdfContent(valueObject.getReport(), true);
		List<String> diagnosisData = getDataBetweenDiagnoses(reportContent, diagnosisToSearchFor,
				diagnosisAfterDiagnosisToSearchForOnReport);
		int numberOfDiagnoses = getDiagnosesCountForDate(startOfMonth, TimestampUtils.today(), diagnosisData);

		valueObject.setStepName("Create a minor patient");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		valueObject.getBusinessPartner().setBH_Birthday(threeYearsAgo);
		valueObject.getBusinessPartner().saveEx();
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(100));
		ChuBoeCreateEntity.createOrder(valueObject);
		valueObject.setQuantity(null);
		commitEx();

		valueObject.setStepName("Create visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		valueObject.getVisit().setBH_PatientType("Im");
		valueObject.getVisit().setBH_PrimaryCodedDiagnosis_ID(codedDiagnosis.get_ID());
		valueObject.getVisit().saveEx();
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setRandom();
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true,
				false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create another minor patient");
		valueObject.setBusinessPartner(null);
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		valueObject.getBusinessPartner().setBH_Birthday(threeYearsAgo);
		valueObject.getBusinessPartner().saveEx();
		commitEx();

		valueObject.setStepName("Create visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		valueObject.getVisit().setBH_PatientType("I");
		valueObject.getVisit().setBH_PrimaryCodedDiagnosis_ID(codedDiagnosis.get_ID());
		valueObject.getVisit().saveEx();
		commitEx();

		valueObject.setStepName("Create order");
		valueObject.setRandom();
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true,
				false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(reportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				Arrays.asList(new ProcessInfoParameter("Begin Date", startOfMonth, null, null, null),
						new ProcessInfoParameter("End Date", endOfMonth, null, null, null)));
		ChuBoeCreateEntity.runReport(valueObject);

		reportContent = PDFUtils.readPdfContent(valueObject.getReport(), true);

		diagnosisData = getDataBetweenDiagnoses(reportContent, diagnosisToSearchFor,
				diagnosisAfterDiagnosisToSearchForOnReport);
		int newNumberOfDiagnoses = getDiagnosesCountForDate(startOfMonth, TimestampUtils.today(), diagnosisData);

		assertThat("Should only pick 1 diagnosis", newNumberOfDiagnoses, is(numberOfDiagnoses + 1));
	}

	private int getDiagnosesCountForDate(Timestamp reportDataBeginDate, Timestamp dateWantingDataFor,
			List<String> diagnosisData) {
		// Get the index of the first data point
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTimeInMillis(reportDataBeginDate.getTime());
		int dayOfMonthOrReportBeginDate = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.setTimeInMillis(dateWantingDataFor.getTime());
		int dayOfMonthWantingDataFor = calendar.get(Calendar.DAY_OF_MONTH);
		assertTrue(dayOfMonthOrReportBeginDate <= dayOfMonthWantingDataFor,
				"Report was run with start date before date wanting data for");
		int indexOfStartDateData = 0;
		for (String data : diagnosisData) {
			try {
				// If we can get an integer value out of this, call it the starting data point
				Integer.parseInt(data);
				break;
			} catch (Throwable ignored) {
				indexOfStartDateData++;
			}
		}
		return Integer.parseInt(
				diagnosisData.get(indexOfStartDateData + dayOfMonthWantingDataFor - dayOfMonthOrReportBeginDate));
	}

	private List<String> getDataBetweenDiagnoses(String reportContent, String diagnosis1, String diagnosis2) {
		return Arrays.asList(reportContent.substring(reportContent.toLowerCase().indexOf(diagnosis1.toLowerCase()),
				reportContent.toLowerCase().indexOf(diagnosis2.toLowerCase())).split(" "));
	}
}
