package org.bandahealth.idempiere.report.test;

import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.bandahealth.idempiere.base.model.MBHCodedDiagnosis;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.test.BandaCreateEntity;
import org.bandahealth.idempiere.base.test.BandaValueObjectWrapper;
import org.bandahealth.idempiere.report.test.utils.PDFUtils;
import org.bandahealth.idempiere.report.test.utils.TimestampUtils;
import org.compiere.model.Query;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.util.Env;

import java.io.IOException;
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

public class MoH705BOutPatientOver5yrSummaryTest extends ChuBoePopulateFactoryVO {
	private static final String reportUuid = "432eeb61-1a87-4880-bded-91927139341c";

	@IPopulateAnnotation.CanRun
	public void canRunReport() throws SQLException, IOException {
		BandaValueObjectWrapper valueObject = new BandaValueObjectWrapper();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMsg(), is(nullValue()));

		String diagnosisToSearchFor = "Burns";
		String diagnosisAfterDiagnosisToSearchForOnReport = "Snakebites";

		int currentClientId = Env.getAD_Client_ID(Env.getCtx());
		MBHCodedDiagnosis codedDiagnosis = null;
		try {
			Env.setContext(valueObject.getCtx(), Env.AD_CLIENT_ID, 0);
			codedDiagnosis =
					new Query(valueObject.getCtx(), MBHCodedDiagnosis.Table_Name, MBHCodedDiagnosis.COLUMNNAME_BH_CielName +
							"=?", valueObject.get_trxName()).setParameters(diagnosisToSearchFor).first();
			if (codedDiagnosis == null) {
				valueObject.setStepName("Create the burns coded diagnosis");
				codedDiagnosis = new MBHCodedDiagnosis(valueObject.getCtx(), 0, valueObject.get_trxName());
				codedDiagnosis.setBH_CielName(diagnosisToSearchFor);
			}
			codedDiagnosis.setBH_MoH705BGreaterThan5("Burns");
			codedDiagnosis.saveEx();
			commitEx();
		} finally {
			Env.setContext(valueObject.getCtx(), Env.AD_CLIENT_ID, currentClientId);
		}

		valueObject.setStepName("Generate the report to get initial data");
		valueObject.setProcess_UU(reportUuid);
		valueObject.setProcessRecord_ID(0);
		valueObject.setProcessTable_ID(0);
		Timestamp startOfMonth = TimestampUtils.startOfMonth();
		Timestamp endOfMonth = TimestampUtils.endOfMonth();
		valueObject.setProcessInfoParams(Arrays.asList(
				new ProcessInfoParameter("Begin Date", startOfMonth, null, null, null),
				new ProcessInfoParameter("End Date", endOfMonth, null, null, null)
		));
		BandaCreateEntity.runReport(valueObject);
		String reportContent = PDFUtils.readPdfContent(valueObject.getReport(), true);
		List<String> diagnosisData =
				getDataBetweenDiagnoses(reportContent, diagnosisToSearchFor, diagnosisAfterDiagnosisToSearchForOnReport);
		int numberOfDiagnoses = getDiagnosesCountForDate(startOfMonth, TimestampUtils.today(), diagnosisData);

		Calendar calendar = GregorianCalendar.getInstance();
		calendar.add(Calendar.YEAR, -3);
		Timestamp threeYearsAgo = new Timestamp(calendar.getTimeInMillis());
		calendar.add(Calendar.YEAR, -3);
		Timestamp sixYearsAgo = new Timestamp(calendar.getTimeInMillis());

		valueObject.setStepName("Create a young patient");
		BandaCreateEntity.createBusinessPartner(valueObject);
		valueObject.getBusinessPartnerBH().setBH_Birthday(threeYearsAgo);
		valueObject.getBusinessPartnerBH().saveEx();
		commitEx();

		valueObject.setStepName("Create product");
		BandaCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create order");
		valueObject.setRandom();
		valueObject.setDocAction(DocumentEngine.ACTION_Prepare);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true,
				false, false);
		BandaCreateEntity.createOrder(valueObject);
		MOrder_BH order = valueObject.getOrderBH();
		order.setBH_PrimaryCodedDiagnosisID(codedDiagnosis.get_ID());
		order.setDocAction(MOrder_BH.ACTION_Complete);
		order.processIt(MOrder_BH.ACTION_Complete);
		commitEx();

		valueObject.setStepName("Create an older patient");
		valueObject.setBP(null);
		BandaCreateEntity.createBusinessPartner(valueObject);
		valueObject.getBusinessPartnerBH().setBH_Birthday(sixYearsAgo);
		valueObject.getBusinessPartnerBH().saveEx();
		commitEx();

		valueObject.setStepName("Create order");
		valueObject.setRandom();
		valueObject.setDocAction(DocumentEngine.ACTION_Prepare);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true,
				false, false);
		BandaCreateEntity.createOrder(valueObject);
		order = valueObject.getOrderBH();
		order.setBH_PrimaryCodedDiagnosisID(codedDiagnosis.get_ID());
		order.setDocAction(MOrder_BH.ACTION_Complete);
		order.processIt(MOrder_BH.ACTION_Complete);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcess_UU(reportUuid);
		valueObject.setProcessRecord_ID(0);
		valueObject.setProcessTable_ID(0);
		valueObject.setProcessInfoParams(Arrays.asList(
				new ProcessInfoParameter("Begin Date", startOfMonth, null, null, null),
				new ProcessInfoParameter("End Date", endOfMonth, null, null, null)
		));
		BandaCreateEntity.runReport(valueObject);

		reportContent = PDFUtils.readPdfContent(valueObject.getReport(), true);
		diagnosisData =
				getDataBetweenDiagnoses(reportContent, diagnosisToSearchFor, diagnosisAfterDiagnosisToSearchForOnReport);
		int newNumberOfDiagnoses = getDiagnosesCountForDate(startOfMonth, TimestampUtils.today(), diagnosisData);

		assertThat("Number of diagnoses correctly counted", newNumberOfDiagnoses, is(numberOfDiagnoses + 1));
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
