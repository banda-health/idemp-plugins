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
import org.bandahealth.idempiere.base.model.MBHEncounter;
import org.bandahealth.idempiere.base.model.MBHEncounterDiagnosis;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.report.test.utils.PDFUtils;
import org.bandahealth.idempiere.report.test.utils.TableUtils;
import org.bandahealth.idempiere.report.test.utils.TimestampUtils;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfoParameter;
import org.hamcrest.Matchers;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DiagnosisReportTest extends ChuBoePopulateFactoryVO {
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

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		String patientNameSuffix = String.valueOf(valueObject.getRandomNumber());
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create coded diagnosis");
		valueObject.setRandom();
		MBHConcept codedDiagnosis =
				new MBHConcept(valueObject.getContext(), 0, valueObject.getTransactionName());
		codedDiagnosis.setBH_Display_Name(String.valueOf(valueObject.getRandomNumber()));
		String diagnosisName = codedDiagnosis.getBH_Display_Name();
		codedDiagnosis.saveEx();
		commitEx();

		valueObject.setStepName("Create visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		String nonCodedDiagnosis = "The Diagnosis of the Century";
		commitEx();

		valueObject.setStepName("Create diagnoses");
		MBHEncounter encounter = new MBHEncounter(valueObject.getContext(), 0, valueObject.getTransactionName());
		encounter.setBH_Encounter_Type(MBHEncounter.BH_ENCOUNTER_TYPE_ClinicalDetails);
		encounter.setBH_Visit_ID(valueObject.getVisit().get_ID());
		encounter.setBH_Encounter_Date(TimestampUtils.today());
		encounter.saveEx();
		MBHEncounterDiagnosis encounterDiagnosis =
				new MBHEncounterDiagnosis(valueObject.getContext(), 0, valueObject.getTransactionName());
		encounterDiagnosis.setBH_Encounter_ID(encounter.getBH_Encounter_ID());
		encounterDiagnosis.setBH_Uncoded_Diagnosis(nonCodedDiagnosis);
		encounterDiagnosis.setBH_Concept_ID(codedDiagnosis.get_ID());
		encounterDiagnosis.setLineNo(10);
		encounterDiagnosis.saveEx();

		valueObject.setStepName("Create sales order");
		valueObject.setRandom();
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("7c29028a-8dd3-4025-a5af-87701748d81f");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.yesterday(), null, null, null),
				new ProcessInfoParameter("End Date", TimestampUtils.tomorrow(), null, null, null)
		));
		ChuBoeCreateEntity.runReport(valueObject);
		commitEx();

		String reportContent = PDFUtils.readPdfContent(valueObject.getReport(), true);
		assertThat("The patient's name is on the report", reportContent, containsString(patientNameSuffix));
		assertThat("The coded diagnosis is on the report", reportContent, containsString(diagnosisName));
		assertThat("The non-coded diagnosis is on the report", reportContent, containsString(nonCodedDiagnosis));
	}

	@IPopulateAnnotation.CanRun
	public void dateTimeFiltersWork() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		String patientNameSuffix = String.valueOf(valueObject.getRandomNumber());
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create purchase order");
		valueObject.setQuantity(BigDecimal.TEN);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create coded diagnosis");
		valueObject.setRandom();
		MBHConcept codedDiagnosis =
				new MBHConcept(valueObject.getContext(), 0, valueObject.getTransactionName());
		codedDiagnosis.setBH_Display_Name(String.valueOf(valueObject.getRandomNumber()));
		codedDiagnosis.saveEx();
		commitEx();

		Timestamp earlyDate = TimestampUtils.startOfYesterday();
		Timestamp beginDate = TimestampUtils.add(earlyDate, Calendar.HOUR, 2);
		Timestamp endDate = TimestampUtils.addToNow(Calendar.DAY_OF_YEAR, 2);

		valueObject.setStepName("Create visit");
		valueObject.setDate(earlyDate);
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create diagnoses");
		MBHEncounter encounter = new MBHEncounter(valueObject.getContext(), 0, valueObject.getTransactionName());
		encounter.setBH_Encounter_Type(MBHEncounter.BH_ENCOUNTER_TYPE_ClinicalDetails);
		encounter.setBH_Visit_ID(valueObject.getVisit().get_ID());
		encounter.setBH_Encounter_Date(TimestampUtils.today());
		encounter.saveEx();
		MBHEncounterDiagnosis encounterDiagnosis =
				new MBHEncounterDiagnosis(valueObject.getContext(), 0, valueObject.getTransactionName());
		encounterDiagnosis.setBH_Encounter_ID(encounter.getBH_Encounter_ID());
		encounterDiagnosis.setBH_Uncoded_Diagnosis("Something wacky");
		encounterDiagnosis.setBH_Concept_ID(codedDiagnosis.get_ID());
		encounterDiagnosis.setLineNo(10);
		encounterDiagnosis.saveEx();

		valueObject.setStepName("Create sales order");
		valueObject.setQuantity(BigDecimal.ONE);
		valueObject.setRandom();
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create second coded diagnosis");
		valueObject.setRandom();
		codedDiagnosis = new MBHConcept(valueObject.getContext(), 0, valueObject.getTransactionName());
		codedDiagnosis.setBH_Display_Name(String.valueOf(valueObject.getRandomNumber()));
		String diagnosisName = codedDiagnosis.getBH_Display_Name();
		codedDiagnosis.saveEx();
		commitEx();

		valueObject.setStepName("Create second visit");
		valueObject.setDateOffset(1);
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
		String nonCodedDiagnosis = "The Diagnosis of the Century";
		encounterDiagnosis.setBH_Uncoded_Diagnosis(nonCodedDiagnosis);
		encounterDiagnosis.setBH_Concept_ID(codedDiagnosis.get_ID());
		encounterDiagnosis.setLineNo(10);
		encounterDiagnosis.saveEx();

		valueObject.setStepName("Create second sales order");
		valueObject.setQuantity(BigDecimal.ONE);
		valueObject.setRandom();
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("7c29028a-8dd3-4025-a5af-87701748d81f");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				Arrays.asList(new ProcessInfoParameter("Begin Date", beginDate, null, null, null),
						new ProcessInfoParameter("End Date", endDate, null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);
		commitEx();

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Visit Date");
			int nameColumnIndex = TableUtils.getColumnIndex(headerRow, "Name");
			int primaryCodedDiagnosisIndex = TableUtils.getColumnIndexContaining(headerRow, "Primary Coded ");
			int primaryNonCodedDiagnosisIndex = TableUtils.getColumnIndexContaining(headerRow, "Primary Non-coded " +
					"Diagnosis");

			List<Row> visitRows = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getCell(nameColumnIndex) != null &&
							row.getCell(nameColumnIndex).getCellType().equals(CellType.STRING) &&
							row.getCell(nameColumnIndex).getStringCellValue()
									.contains(valueObject.getBusinessPartner().getName().substring(0, 20))).collect(Collectors.toList());
			assertEquals(1, visitRows.size(), "Only the second visit shows on the report");

			Row visitRow = visitRows.get(0);
			assertEquals(diagnosisName, visitRow.getCell(primaryCodedDiagnosisIndex).getStringCellValue(),
					"Primary coded diagnosis is correct");
			assertEquals(nonCodedDiagnosis, visitRow.getCell(primaryNonCodedDiagnosisIndex).getStringCellValue(),
					"Primary non-coded diagnosis is correct");
		}
	}

	@IPopulateAnnotation.CanRun
	public void draftedAndVoidedVisitsDontShowUp() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		String patientNameSuffix = String.valueOf(valueObject.getRandomNumber());
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create purchase order");
		valueObject.setQuantity(BigDecimal.TEN);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create first coded diagnosis");
		valueObject.setRandom();
		MBHConcept codedDiagnosis =
				new MBHConcept(valueObject.getContext(), 0, valueObject.getTransactionName());
		codedDiagnosis.setBH_Display_Name(String.valueOf(valueObject.getRandomNumber()));
		codedDiagnosis.saveEx();
		commitEx();

		valueObject.setStepName("Create first visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create first visit diagnoses");
		MBHEncounter encounter = new MBHEncounter(valueObject.getContext(), 0, valueObject.getTransactionName());
		encounter.setBH_Encounter_Type(MBHEncounter.BH_ENCOUNTER_TYPE_ClinicalDetails);
		encounter.setBH_Visit_ID(valueObject.getVisit().get_ID());
		encounter.setBH_Encounter_Date(TimestampUtils.today());
		encounter.saveEx();
		MBHEncounterDiagnosis firstEncounterDiagnosis =
				new MBHEncounterDiagnosis(valueObject.getContext(), 0, valueObject.getTransactionName());
		firstEncounterDiagnosis.setBH_Encounter_ID(encounter.getBH_Encounter_ID());
		firstEncounterDiagnosis.setBH_Concept_ID(codedDiagnosis.get_ID());
		firstEncounterDiagnosis.setLineNo(10);
		firstEncounterDiagnosis.saveEx();

		valueObject.setStepName("Create drafted sales order");
		valueObject.setQuantity(BigDecimal.ONE);
		valueObject.setRandom();
		valueObject.setDocumentAction(DocumentEngine.ACTION_Prepare);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create another coded diagnosis");
		valueObject.setRandom();
		codedDiagnosis = new MBHConcept(valueObject.getContext(), 0, valueObject.getTransactionName());
		codedDiagnosis.setBH_Display_Name(String.valueOf(valueObject.getRandomNumber()));
		codedDiagnosis.saveEx();
		commitEx();

		valueObject.setStepName("Create second visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create second visit diagnosis");
		encounter = new MBHEncounter(valueObject.getContext(), 0, valueObject.getTransactionName());
		encounter.setBH_Encounter_Type(MBHEncounter.BH_ENCOUNTER_TYPE_ClinicalDetails);
		encounter.setBH_Visit_ID(valueObject.getVisit().get_ID());
		encounter.setBH_Encounter_Date(TimestampUtils.today());
		encounter.saveEx();
		MBHEncounterDiagnosis secondEncounterDiagnosis =
				new MBHEncounterDiagnosis(valueObject.getContext(), 0, valueObject.getTransactionName());
		secondEncounterDiagnosis.setBH_Encounter_ID(encounter.getBH_Encounter_ID());
		secondEncounterDiagnosis.setBH_Uncoded_Diagnosis("The Diagnosis of the Century");
		secondEncounterDiagnosis.setBH_Concept_ID(codedDiagnosis.get_ID());
		secondEncounterDiagnosis.setLineNo(10);
		secondEncounterDiagnosis.saveEx();

		valueObject.setStepName("Create voided sales order");
		valueObject.setQuantity(BigDecimal.ONE);
		valueObject.setRandom();
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.getOrder().setDocAction(DocumentEngine.ACTION_Void);
		assertTrue(valueObject.getOrder().processIt(DocumentEngine.ACTION_Void), "order was voided");
		valueObject.getOrder().saveEx();
		commitEx();

		valueObject.setStepName("Create final coded diagnosis");
		valueObject.setRandom();
		codedDiagnosis = new MBHConcept(valueObject.getContext(), 0, valueObject.getTransactionName());
		codedDiagnosis.setBH_Display_Name(String.valueOf(valueObject.getRandomNumber()));
		codedDiagnosis.saveEx();
		commitEx();

		valueObject.setStepName("Create third visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create third visit diagnosis");
		encounter = new MBHEncounter(valueObject.getContext(), 0, valueObject.getTransactionName());
		encounter.setBH_Encounter_Type(MBHEncounter.BH_ENCOUNTER_TYPE_ClinicalDetails);
		encounter.setBH_Visit_ID(valueObject.getVisit().get_ID());
		encounter.setBH_Encounter_Date(TimestampUtils.today());
		encounter.saveEx();
		MBHEncounterDiagnosis thirdEncounterDiagnosis =
				new MBHEncounterDiagnosis(valueObject.getContext(), 0, valueObject.getTransactionName());
		thirdEncounterDiagnosis.setBH_Encounter_ID(encounter.getBH_Encounter_ID());
		thirdEncounterDiagnosis.setBH_Uncoded_Diagnosis("This is getting out of control!");
		thirdEncounterDiagnosis.setBH_Concept_ID(codedDiagnosis.get_ID());
		thirdEncounterDiagnosis.setLineNo(10);
		thirdEncounterDiagnosis.saveEx();

		valueObject.setStepName("Create completed sales order");
		valueObject.setQuantity(BigDecimal.ONE);
		valueObject.setRandom();
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("7c29028a-8dd3-4025-a5af-87701748d81f");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				Arrays.asList(new ProcessInfoParameter("Begin Date", TimestampUtils.yesterday(), null, null, null),
						new ProcessInfoParameter("End Date", TimestampUtils.tomorrow(), null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);
		commitEx();

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Visit Date");
			int nameColumnIndex = TableUtils.getColumnIndex(headerRow, "Name");
			int primaryCodedDiagnosisIndex = TableUtils.getColumnIndexContaining(headerRow, "Primary Coded ");
			int primaryNonCodedDiagnosisIndex = TableUtils.getColumnIndexContaining(headerRow, "Primary Non-coded " +
					"Diagnosis");

			List<Row> visitRows = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getCell(nameColumnIndex) != null &&
							row.getCell(nameColumnIndex).getCellType().equals(CellType.STRING) &&
							row.getCell(nameColumnIndex).getStringCellValue()
									.contains(valueObject.getBusinessPartner().getName().substring(0, 20))).collect(Collectors.toList());
			assertEquals(1, visitRows.size(), "Only the completed visit shows on the report");

			Row visitRow = visitRows.get(0);
			assertEquals(codedDiagnosis.getBH_Display_Name(), visitRow.getCell(primaryCodedDiagnosisIndex).getStringCellValue(),
					"Primary coded diagnosis is correct");
			assertEquals(thirdEncounterDiagnosis.getBH_Uncoded_Diagnosis(),
					visitRow.getCell(primaryNonCodedDiagnosisIndex).getStringCellValue(),
					"Primary non-coded diagnosis is correct");
		}
	}
}
