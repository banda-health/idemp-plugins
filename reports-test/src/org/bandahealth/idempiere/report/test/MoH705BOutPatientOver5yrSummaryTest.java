package org.bandahealth.idempiere.report.test;

import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bandahealth.idempiere.base.model.MBHConcept;
import org.bandahealth.idempiere.base.model.MBHConceptExtra;
import org.bandahealth.idempiere.base.model.MBHEncounter;
import org.bandahealth.idempiere.base.model.MBHEncounterDiagnosis;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.report.test.utils.TableUtils;
import org.bandahealth.idempiere.report.test.utils.TimestampUtils;
import org.compiere.model.Query;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.util.Env;
import org.hamcrest.Matchers;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoH705BOutPatientOver5yrSummaryTest extends ChuBoePopulateFactoryVO {
	private static final String reportUuid = "432eeb61-1a87-4880-bded-91927139341c";
	private static final String MOH705BGREATERTHAN5 = "MOH-705B-GREATERTHAN5";

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

		String diagnosisToSearchFor = "Measles";

		int currentClientId = Env.getAD_Client_ID(Env.getCtx());
		MBHConcept codedDiagnosis = null;
		try {
			Env.setContext(valueObject.getContext(), Env.AD_CLIENT_ID, 0);
			codedDiagnosis = new Query(valueObject.getContext(), MBHConcept.Table_Name,
					MBHConcept.COLUMNNAME_BH_Display_Name + "=?", valueObject.getTransactionName())
					.setParameters(diagnosisToSearchFor).first();
			if (codedDiagnosis == null) {
				valueObject.setStepName("Create the burns coded diagnosis");
				codedDiagnosis = new MBHConcept(valueObject.getContext(), 0, valueObject.getTransactionName());
				codedDiagnosis.setBH_Display_Name(diagnosisToSearchFor);
				codedDiagnosis.setOcl_Uuid(diagnosisToSearchFor);
				codedDiagnosis.saveEx();
				commitEx();
			}
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
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		double numberOfDiagnoses = getDiagnosesCountForDate(valueObject, TimestampUtils.today(), diagnosisToSearchFor);

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
		valueObject.getVisit().saveEx();
		commitEx();

		valueObject.setStepName("Create diagnoses");
		MBHEncounter encounter = new MBHEncounter(valueObject.getContext(), 0, valueObject.getTransactionName());
		encounter.setBH_Encounter_Type(MBHEncounter.BH_ENCOUNTER_TYPE_ClinicalDetails);
		encounter.setBH_Visit_ID(valueObject.getVisit().get_ID());
		encounter.setBH_Encounter_Date(TimestampUtils.today());
		encounter.saveEx();
		MBHEncounterDiagnosis encounterDiagnosis = new MBHEncounterDiagnosis(valueObject.getContext(), 0,
				valueObject.getTransactionName());
		encounterDiagnosis.setBH_Encounter_ID(encounter.getBH_Encounter_ID());
		encounterDiagnosis.setBH_Concept_ID(codedDiagnosis.get_ID());
		encounterDiagnosis.setLineNo(10);
		encounterDiagnosis.saveEx();

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
		commitEx();

		valueObject.setStepName("Create diagnoses");
		encounter = new MBHEncounter(valueObject.getContext(), 0, valueObject.getTransactionName());
		encounter.setBH_Encounter_Type(MBHEncounter.BH_ENCOUNTER_TYPE_ClinicalDetails);
		encounter.setBH_Visit_ID(valueObject.getVisit().get_ID());
		encounter.setBH_Encounter_Date(TimestampUtils.today());
		encounter.saveEx();
		encounterDiagnosis = new MBHEncounterDiagnosis(valueObject.getContext(), 0, valueObject.getTransactionName());
		encounterDiagnosis.setBH_Encounter_ID(encounter.getBH_Encounter_ID());
		encounterDiagnosis.setBH_Concept_ID(codedDiagnosis.get_ID());
		encounterDiagnosis.setLineNo(10);
		encounterDiagnosis.saveEx();

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
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		double newNumberOfDiagnoses = getDiagnosesCountForDate(valueObject, TimestampUtils.today(), diagnosisToSearchFor);

		assertThat("Number of diagnoses correctly counted", newNumberOfDiagnoses, is(numberOfDiagnoses + 1));
	}

	@IPopulateAnnotation.CanRun
	public void draftedAndVoidedVisitsDontShowUp() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		String diagnosisToSearchFor = "Burns";

		int currentClientId = Env.getAD_Client_ID(Env.getCtx());
		MBHConcept codedDiagnosis = null;
		try {
			Env.setContext(valueObject.getContext(), Env.AD_CLIENT_ID, 0);
			codedDiagnosis = new Query(valueObject.getContext(), MBHConcept.Table_Name,
					MBHConcept.COLUMNNAME_BH_Display_Name + "=?", valueObject.getTransactionName())
					.setParameters(diagnosisToSearchFor).first();
			if (codedDiagnosis == null) {
				valueObject.setStepName("Create the burns coded diagnosis");
				codedDiagnosis = new MBHConcept(valueObject.getContext(), 0, valueObject.getTransactionName());
				codedDiagnosis.setBH_Display_Name(diagnosisToSearchFor);
				codedDiagnosis.setOcl_Uuid(diagnosisToSearchFor);
			}
			codedDiagnosis.saveEx();

			MBHConceptExtra extra = new Query(valueObject.getContext(), MBHConceptExtra.Table_Name,
					MBHConceptExtra.COLUMNNAME_BH_Value + "=? AND " + MBHConceptExtra.COLUMNNAME_BH_Concept_ID + "=? AND "
							+ MBHConceptExtra.COLUMNNAME_BH_Key + "=?",
					valueObject.getTransactionName())
					.setParameters(diagnosisToSearchFor, codedDiagnosis.getBH_Concept_ID(), MOH705BGREATERTHAN5).first();
			if (extra == null) {
				extra = new MBHConceptExtra(valueObject.getContext(), 0, valueObject.getTransactionName());
				extra.setBH_Key(MOH705BGREATERTHAN5);
				extra.setBH_Value(diagnosisToSearchFor);
				extra.setBH_Concept_ID(codedDiagnosis.getBH_Concept_ID());
				extra.saveEx();
			}
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
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		double numberOfDiagnoses = getDiagnosesCountForDate(valueObject, TimestampUtils.today(), diagnosisToSearchFor);

		Calendar calendar = GregorianCalendar.getInstance();
		calendar.add(Calendar.YEAR, -6);
		Timestamp sixYearsAgo = new Timestamp(calendar.getTimeInMillis());

		valueObject.setStepName("Create an older patient");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		valueObject.getBusinessPartner().setBH_Birthday(sixYearsAgo);
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
		valueObject.getVisit().saveEx();
		commitEx();

		valueObject.setStepName("Create diagnoses");
		MBHEncounter encounter = new MBHEncounter(valueObject.getContext(), 0, valueObject.getTransactionName());
		encounter.setBH_Encounter_Type(MBHEncounter.BH_ENCOUNTER_TYPE_ClinicalDetails);
		encounter.setBH_Visit_ID(valueObject.getVisit().get_ID());
		encounter.setBH_Encounter_Date(TimestampUtils.today());
		encounter.saveEx();
		MBHEncounterDiagnosis encounterDiagnosis = new MBHEncounterDiagnosis(valueObject.getContext(), 0,
				valueObject.getTransactionName());
		encounterDiagnosis.setBH_Encounter_ID(encounter.getBH_Encounter_ID());
		encounterDiagnosis.setBH_Concept_ID(codedDiagnosis.get_ID());
		encounterDiagnosis.setLineNo(10);
		encounterDiagnosis.saveEx();

		valueObject.setStepName("Create sales order");
		valueObject.setRandom();
		valueObject.setDocumentAction(DocumentEngine.ACTION_Prepare);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true,
				false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create another older patient");
		valueObject.setBusinessPartner(null);
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		valueObject.getBusinessPartner().setBH_Birthday(sixYearsAgo);
		valueObject.getBusinessPartner().saveEx();
		commitEx();

		valueObject.setStepName("Create visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create diagnoses");
		encounter = new MBHEncounter(valueObject.getContext(), 0, valueObject.getTransactionName());
		encounter.setBH_Encounter_Type(MBHEncounter.BH_ENCOUNTER_TYPE_ClinicalDetails);
		encounter.setBH_Visit_ID(valueObject.getVisit().get_ID());
		encounter.setBH_Encounter_Date(TimestampUtils.today());
		encounter.saveEx();
		encounterDiagnosis = new MBHEncounterDiagnosis(valueObject.getContext(), 0, valueObject.getTransactionName());
		encounterDiagnosis.setBH_Encounter_ID(encounter.getBH_Encounter_ID());
		encounterDiagnosis.setBH_Concept_ID(codedDiagnosis.get_ID());
		encounterDiagnosis.setLineNo(10);
		encounterDiagnosis.saveEx();

		valueObject.setStepName("Create order");
		valueObject.setRandom();
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true,
				false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Void order");
		valueObject.getOrder().setDocAction(DocumentEngine.ACTION_Void);
		assertTrue(valueObject.getOrder().processIt(DocumentEngine.ACTION_Void), "order was voided");
		valueObject.getOrder().saveEx();
		commitEx();

		valueObject.setStepName("Create final older patient");
		valueObject.setBusinessPartner(null);
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		valueObject.getBusinessPartner().setBH_Birthday(sixYearsAgo);
		valueObject.getBusinessPartner().saveEx();
		commitEx();

		valueObject.setStepName("Create visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create diagnoses");
		encounter = new MBHEncounter(valueObject.getContext(), 0, valueObject.getTransactionName());
		encounter.setBH_Encounter_Type(MBHEncounter.BH_ENCOUNTER_TYPE_ClinicalDetails);
		encounter.setBH_Visit_ID(valueObject.getVisit().get_ID());
		encounter.setBH_Encounter_Date(TimestampUtils.today());
		encounter.saveEx();
		encounterDiagnosis = new MBHEncounterDiagnosis(valueObject.getContext(), 0, valueObject.getTransactionName());
		encounterDiagnosis.setBH_Encounter_ID(encounter.getBH_Encounter_ID());
		encounterDiagnosis.setBH_Concept_ID(codedDiagnosis.get_ID());
		encounterDiagnosis.setLineNo(10);
		encounterDiagnosis.saveEx();

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
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		double newNumberOfDiagnoses = getDiagnosesCountForDate(valueObject, TimestampUtils.today(), diagnosisToSearchFor);

		assertThat("Number of diagnoses correctly counted", newNumberOfDiagnoses, is(numberOfDiagnoses + 1));
	}

	private double getDiagnosesCountForDate(ChuBoePopulateVO valueObject, Timestamp dateWantingDataFor,
			String diagnosisName)
			throws IOException {
		// Get the index of the first data point
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTimeInMillis(dateWantingDataFor.getTime());
		int dayOfMonthWantingDataFor = calendar.get(Calendar.DAY_OF_MONTH);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "DISEASES (New Cases Only)");
			int countCellIndex = TableUtils.getColumnIndex(headerRow, dayOfMonthWantingDataFor);

			Optional<Row> diagnosisRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals(diagnosisName))).findFirst();
			assertTrue(diagnosisRow.isPresent(), "Found row for diagnoses " + diagnosisName);
			return diagnosisRow.get().getCell(countCellIndex).getNumericCellValue();
		}
	}
}
