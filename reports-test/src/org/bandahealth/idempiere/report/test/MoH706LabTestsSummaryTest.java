package org.bandahealth.idempiere.report.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.StreamSupport;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bandahealth.idempiere.base.model.MBHConcept;
import org.bandahealth.idempiere.base.model.MBHEncounter;
import org.bandahealth.idempiere.base.model.MBHEncounterDiagnostic;
import org.bandahealth.idempiere.report.test.utils.TimestampUtils;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.hamcrest.Matchers;

import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;

public class MoH706LabTestsSummaryTest extends ChuBoePopulateFactoryVO {
	private static final String reportUU = "83378587-d80f-4c79-874b-5cdc64893b77";

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
		Timestamp startOfMonth = TimestampUtils.startOfMonth();
		Timestamp endOfMonth = TimestampUtils.endOfMonth();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(reportUU);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				Arrays.asList(new ProcessInfoParameter("Begin Date", startOfMonth, null, null, null),
						new ProcessInfoParameter("End Date", endOfMonth, null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			//
			Optional<Row> titleRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("Laboratory Test Summary")))
					.findFirst();
			assertTrue(titleRow.isPresent(), "title is present");
		}
	}

	@IPopulateAnnotation.CanRun
	public void urineTableCountsAreCorrect() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		int initialCountOfGlucoseVisits = 0;

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create a visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		MBHConcept diagnostic = null;

		valueObject.setStepName("Create glucose concept if it doesn't exist");

		diagnostic = new Query(valueObject.getContext(), MBHConcept.Table_Name,
				MBHConcept.COLUMNNAME_BH_OclID + "=?", valueObject.getTransactionName())
				.setParameters("159734").first();
		if (diagnostic == null) {
			diagnostic = new MBHConcept(valueObject.getContext(), 0, valueObject.getTransactionName());
			diagnostic.setBH_Display_Name(String.valueOf(valueObject.getRandomNumber()));
			diagnostic.setIsActive(true);
			diagnostic.setBH_ExternalID("159734AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
			diagnostic.setBH_OclID("159734");
			diagnostic.setBH_Owner("CIEL");
			diagnostic.setBH_Source("CIEL");
			diagnostic.saveEx();
		}
		commitEx();

		valueObject.setStepName("Create diagnostics");
		MBHEncounter encounter = new MBHEncounter(valueObject.getContext(), 0, valueObject.getTransactionName());
		encounter.setBH_Encounter_Type(MBHEncounter.BH_ENCOUNTER_TYPE_ClinicalDetails);
		encounter.setBH_Visit_ID(valueObject.getVisit().get_ID());
		encounter.setBH_Encounter_Date(TimestampUtils.today());
		encounter.saveEx();

		String diagnosticValue = "positive";
		MBHEncounterDiagnostic encounterDiagnostic = new MBHEncounterDiagnostic(valueObject.getContext(), 0,
				valueObject.getTransactionName());
		encounterDiagnostic.setBH_Encounter_ID(encounter.getBH_Encounter_ID());
		encounterDiagnostic.setBH_Concept_ID(diagnostic.get_ID());
		encounterDiagnostic.setBH_Value(diagnosticValue);
		encounterDiagnostic.setLineNo(10);
		encounterDiagnostic.setGroup1(String.valueOf(valueObject.getRandomNumber()));
		encounterDiagnostic.saveEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(reportUU);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				Arrays.asList(new ProcessInfoParameter("Begin Date", TimestampUtils.startOfMonth(), null, null, null),
						new ProcessInfoParameter("End Date", TimestampUtils.endOfMonth(), null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			//
			Optional<Row> urineAnalysisRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("1. URINE ANALYSIS")))
					.findFirst();
			assertTrue(urineAnalysisRow.isPresent(), "urine analysis is present");

			Optional<Row> urineChemistryRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("1.1 Urine Chemistry")))
					.findFirst();
			assertTrue(urineChemistryRow.isPresent(), "urine chemistry row is present");
			//
			// get number of whatever
			Optional<Row> glucoseRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("1.2 Glucose")))
					.findFirst();
			assertTrue(glucoseRow.isPresent(), "glucose row is present");
			Optional<Cell> glucoseCount = StreamSupport.stream(glucoseRow.get().spliterator(), false).filter(
					cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC) &&
							cell.getNumericCellValue() == initialCountOfGlucoseVisits + 1)
					.findFirst();
			assertEquals(glucoseCount, initialCountOfGlucoseVisits);
		}
	}
	@IPopulateAnnotation.CanRun
	public void bloodChemistryTableCountAreCorrect () throws SQLException, IOException{
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		int initialCountOfBloodChemistryVisits = 0;

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create a visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		MBHConcept diagnostic = null;

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(reportUU);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				Arrays.asList(new ProcessInfoParameter("Begin Date", TimestampUtils.startOfMonth(), null, null, null),
						new ProcessInfoParameter("End Date", TimestampUtils.endOfMonth(), null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			//
			Optional<Row> urineAnalysisRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("1. URINE ANALYSIS")))
					.findFirst();
			assertTrue(urineAnalysisRow.isPresent(), "urine analysis is present");

			Optional<Row> urineChemistryRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("1.1 Urine Chemistry")))
					.findFirst();
			assertTrue(urineChemistryRow.isPresent(), "urine chemistry row is present");
		}
		

	}
	
	@IPopulateAnnotation.CanRun
	public void parisitologyTableCountsAreCorrect() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		int initialCountOfMalariaVisits = 0;

		valueObject.setStepName("Create a minor patient");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		valueObject.getBusinessPartner().setBH_Birthday(TimestampUtils.lastMonth());
		valueObject.getBusinessPartner().saveEx();
		commitEx();

		valueObject.setStepName("Create a visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		MBHConcept diagnostic = null;

		valueObject.setStepName("Create malaria smear concept if it doesn't exist");

		diagnostic = new Query(valueObject.getContext(), MBHConcept.Table_Name,
				MBHConcept.COLUMNNAME_BH_OclID + "=?", valueObject.getTransactionName())
				.setParameters("159734").first();
		if (diagnostic == null) {
			diagnostic = new MBHConcept(valueObject.getContext(), 0, valueObject.getTransactionName());
			diagnostic.setBH_Display_Name(String.valueOf(valueObject.getRandomNumber()));
			diagnostic.setIsActive(true);
			diagnostic.setBH_ExternalID("32AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
			diagnostic.setBH_OclID("32");
			diagnostic.setBH_Owner("CIEL");
			diagnostic.setBH_Source("CIEL");
			diagnostic.saveEx();
		}
		commitEx();

		valueObject.setStepName("Create diagnostics");
		MBHEncounter encounter = new MBHEncounter(valueObject.getContext(), 0, valueObject.getTransactionName());
		encounter.setBH_Encounter_Type(MBHEncounter.BH_ENCOUNTER_TYPE_ClinicalDetails);
		encounter.setBH_Visit_ID(valueObject.getVisit().get_ID());
		encounter.setBH_Encounter_Date(TimestampUtils.today());
		encounter.saveEx();

		String diagnosticValue = "positive";
		MBHEncounterDiagnostic encounterDiagnostic = new MBHEncounterDiagnostic(valueObject.getContext(), 0,
				valueObject.getTransactionName());
		encounterDiagnostic.setBH_Encounter_ID(encounter.getBH_Encounter_ID());
		encounterDiagnostic.setBH_Concept_ID(diagnostic.get_ID());
		encounterDiagnostic.setBH_Value(diagnosticValue);
		encounterDiagnostic.setLineNo(10);
		encounterDiagnostic.setGroup1(String.valueOf(valueObject.getRandomNumber()));
		encounterDiagnostic.saveEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(reportUU);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				Arrays.asList(new ProcessInfoParameter("Begin Date", TimestampUtils.startOfMonth(), null, null, null),
						new ProcessInfoParameter("End Date", TimestampUtils.endOfMonth(), null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			//
			Optional<Row> parisitologyRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("3. PARISITOLOGY")))
					.findFirst();
			assertTrue(parisitologyRow.isPresent(), "parisitology analysis is present");

			Optional<Row> parisitologyMalariaRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("Malaria Test")))
					.findFirst();
			assertTrue(parisitologyMalariaRow.isPresent(), "malaria test row is present");
			//
			// get number of whatever
			Optional<Row> malariaRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("3.1 Malaria BS (Under five years)")))
					.findFirst();
			assertTrue(malariaRow.isPresent(), "malaria row is present");
			Optional<Cell> glucoseCount = StreamSupport.stream(malariaRow.get().spliterator(), false).filter(
					cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC) &&
							cell.getNumericCellValue() == initialCountOfMalariaVisits + 1)
					.findFirst();
			assertEquals(glucoseCount, initialCountOfMalariaVisits);
		}
	}
	
	@IPopulateAnnotation.CanRun
	public void haematologyTableCountsAreCorrect() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		int initialCountOfWBCVisits = 0;

		valueObject.setStepName("Create a patient");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create a visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		MBHConcept diagnostic = null;

		valueObject.setStepName("Create wbc concept if it doesn't exist");

		diagnostic = new Query(valueObject.getContext(), MBHConcept.Table_Name,
				MBHConcept.COLUMNNAME_BH_OclID + "=?", valueObject.getTransactionName())
				.setParameters("678").first();
		if (diagnostic == null) {
			diagnostic = new MBHConcept(valueObject.getContext(), 0, valueObject.getTransactionName());
			diagnostic.setBH_Display_Name(String.valueOf(valueObject.getRandomNumber()));
			diagnostic.setIsActive(true);
			diagnostic.setBH_ExternalID("678AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
			diagnostic.setBH_OclID("678");
			diagnostic.setBH_Owner("CIEL");
			diagnostic.setBH_Source("CIEL");
			diagnostic.saveEx();
		}
		commitEx();

		valueObject.setStepName("Create diagnostics");
		MBHEncounter encounter = new MBHEncounter(valueObject.getContext(), 0, valueObject.getTransactionName());
		encounter.setBH_Encounter_Type(MBHEncounter.BH_ENCOUNTER_TYPE_ClinicalDetails);
		encounter.setBH_Visit_ID(valueObject.getVisit().get_ID());
		encounter.setBH_Encounter_Date(TimestampUtils.today());
		encounter.saveEx();

		String diagnosticValue = "5";
		MBHEncounterDiagnostic encounterDiagnostic = new MBHEncounterDiagnostic(valueObject.getContext(), 0,
				valueObject.getTransactionName());
		encounterDiagnostic.setBH_Encounter_ID(encounter.getBH_Encounter_ID());
		encounterDiagnostic.setBH_Concept_ID(diagnostic.get_ID());
		encounterDiagnostic.setBH_Value(diagnosticValue);
		encounterDiagnostic.setLineNo(10);
		encounterDiagnostic.setGroup1(String.valueOf(valueObject.getRandomNumber()));
		encounterDiagnostic.saveEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(reportUU);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				Arrays.asList(new ProcessInfoParameter("Begin Date", TimestampUtils.startOfMonth(), null, null, null),
						new ProcessInfoParameter("End Date", TimestampUtils.endOfMonth(), null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			//
			Optional<Row> haematologyRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("4. HAEMATOLOGY")))
					.findFirst();
			assertTrue(haematologyRow.isPresent(), "haematology analysis is present");

			Optional<Row> haematologyTestsRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("Haematology tests")))
					.findFirst();
			assertTrue(haematologyTestsRow.isPresent(), "haematology test row is present");
			//
			// get number of whatever
			Optional<Row> fullBloodCountRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("4.1 Full blood count")))
					.findFirst();
			assertTrue(fullBloodCountRow.isPresent(), "full blood count row is present");
			Optional<Cell> wbcCount = StreamSupport.stream(fullBloodCountRow.get().spliterator(), false).filter(
					cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC) &&
							cell.getNumericCellValue() == initialCountOfWBCVisits + 1)
					.findFirst();
			assertEquals(wbcCount, initialCountOfWBCVisits);
		}
	}
	
	@IPopulateAnnotation.CanRun
	public void bacteriologyTableCountsAreCorrect() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		int initialCountOfTbSmearVisits = 0;

		valueObject.setStepName("Create a patient");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create a visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		MBHConcept diagnostic = null;

		valueObject.setStepName("Create tb smear if it doesn't exist");

		diagnostic = new Query(valueObject.getContext(), MBHConcept.Table_Name,
				MBHConcept.COLUMNNAME_BH_OclID + "=?", valueObject.getTransactionName())
				.setParameters("307").first();
		if (diagnostic == null) {
			diagnostic = new MBHConcept(valueObject.getContext(), 0, valueObject.getTransactionName());
			diagnostic.setBH_Display_Name(String.valueOf(valueObject.getRandomNumber()));
			diagnostic.setIsActive(true);
			diagnostic.setBH_ExternalID("307AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
			diagnostic.setBH_OclID("307");
			diagnostic.setBH_Owner("CIEL");
			diagnostic.setBH_Source("CIEL");
			diagnostic.saveEx();
		}
		commitEx();

		valueObject.setStepName("Create diagnostics");
		MBHEncounter encounter = new MBHEncounter(valueObject.getContext(), 0, valueObject.getTransactionName());
		encounter.setBH_Encounter_Type(MBHEncounter.BH_ENCOUNTER_TYPE_ClinicalDetails);
		encounter.setBH_Visit_ID(valueObject.getVisit().get_ID());
		encounter.setBH_Encounter_Date(TimestampUtils.today());
		encounter.saveEx();

		String diagnosticValue = "Positive";
		MBHEncounterDiagnostic encounterDiagnostic = new MBHEncounterDiagnostic(valueObject.getContext(), 0,
				valueObject.getTransactionName());
		encounterDiagnostic.setBH_Encounter_ID(encounter.getBH_Encounter_ID());
		encounterDiagnostic.setBH_Concept_ID(diagnostic.get_ID());
		encounterDiagnostic.setBH_Value(diagnosticValue);
		encounterDiagnostic.setLineNo(10);
		encounterDiagnostic.setGroup1(String.valueOf(valueObject.getRandomNumber()));
		encounterDiagnostic.saveEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(reportUU);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				Arrays.asList(new ProcessInfoParameter("Begin Date", TimestampUtils.startOfMonth(), null, null, null),
						new ProcessInfoParameter("End Date", TimestampUtils.endOfMonth(), null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			//
			Optional<Row> bacteriologyRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("5. BACTERIOLOGY")))
					.findFirst();
			assertTrue(bacteriologyRow.isPresent(), "bacteriology analysis is present");

			Optional<Row> sputumRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("Sputum")))
					.findFirst();
			assertTrue(sputumRow.isPresent(), "sputum row is present");
			//
			// get number of whatever
			Optional<Row> tbSmearCountRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("5.29 Total TB smears")))
					.findFirst();
			assertTrue(tbSmearCountRow.isPresent(), "TB smear count row is present");
			Optional<Cell> tbSmearCount = StreamSupport.stream(tbSmearCountRow.get().spliterator(), false).filter(
					cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC) &&
							cell.getNumericCellValue() == initialCountOfTbSmearVisits + 1)
					.findFirst();
			assertEquals(tbSmearCount, initialCountOfTbSmearVisits);
		}
	}
	
	@IPopulateAnnotation.CanRun
	public void serologyTableCountsAreCorrect() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		int initialCountOfVdrlVisits = 0;

		valueObject.setStepName("Create a patient");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create a visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		MBHConcept diagnostic = null;

		valueObject.setStepName("Create vdrl if it doesn't exist");

		diagnostic = new Query(valueObject.getContext(), MBHConcept.Table_Name,
				MBHConcept.COLUMNNAME_BH_OclID + "=?", valueObject.getTransactionName())
				.setParameters("299").first();
		if (diagnostic == null) {
			diagnostic = new MBHConcept(valueObject.getContext(), 0, valueObject.getTransactionName());
			diagnostic.setBH_Display_Name(String.valueOf(valueObject.getRandomNumber()));
			diagnostic.setIsActive(true);
			diagnostic.setBH_ExternalID("299AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
			diagnostic.setBH_OclID("299");
			diagnostic.setBH_Owner("CIEL");
			diagnostic.setBH_Source("CIEL");
			diagnostic.saveEx();
		}
		commitEx();

		valueObject.setStepName("Create diagnostics");
		MBHEncounter encounter = new MBHEncounter(valueObject.getContext(), 0, valueObject.getTransactionName());
		encounter.setBH_Encounter_Type(MBHEncounter.BH_ENCOUNTER_TYPE_ClinicalDetails);
		encounter.setBH_Visit_ID(valueObject.getVisit().get_ID());
		encounter.setBH_Encounter_Date(TimestampUtils.today());
		encounter.saveEx();

		String diagnosticValue = "Reactive";
		MBHEncounterDiagnostic encounterDiagnostic = new MBHEncounterDiagnostic(valueObject.getContext(), 0,
				valueObject.getTransactionName());
		encounterDiagnostic.setBH_Encounter_ID(encounter.getBH_Encounter_ID());
		encounterDiagnostic.setBH_Concept_ID(diagnostic.get_ID());
		encounterDiagnostic.setBH_Value(diagnosticValue);
		encounterDiagnostic.setLineNo(10);
		encounterDiagnostic.setGroup1(String.valueOf(valueObject.getRandomNumber()));
		encounterDiagnostic.saveEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(reportUU);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				Arrays.asList(new ProcessInfoParameter("Begin Date", TimestampUtils.startOfMonth(), null, null, null),
						new ProcessInfoParameter("End Date", TimestampUtils.endOfMonth(), null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			//
			Optional<Row> serologyRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("7. SEROLOGY")))
					.findFirst();
			assertTrue(serologyRow.isPresent(), "serology analysis is present");

			Optional<Row> serologicalTestRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("Serological test")))
					.findFirst();
			assertTrue(serologicalTestRow.isPresent(), "serological test row is present");
			//
			// get number of whatever
			Optional<Row> vdrlCountRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("7.1 VDRL")))
					.findFirst();
			assertTrue(vdrlCountRow.isPresent(), "VDRL count row is present");
			Optional<Cell> vdrlCount = StreamSupport.stream(vdrlCountRow.get().spliterator(), false).filter(
					cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC) &&
							cell.getNumericCellValue() == initialCountOfVdrlVisits + 1)
					.findFirst();
			assertEquals(vdrlCount, initialCountOfVdrlVisits);
		}
	}
	
	@IPopulateAnnotation.CanRun
	public void specimenReferralToHigherLevelsTableCountsAreCorrect() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create a patient");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create a visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		MBHConcept diagnostic = null;

		valueObject.setStepName("Create vdrl if it doesn't exist");

		diagnostic = new Query(valueObject.getContext(), MBHConcept.Table_Name,
				MBHConcept.COLUMNNAME_BH_OclID + "=?", valueObject.getTransactionName())
				.setParameters("299").first();
		if (diagnostic == null) {
			diagnostic = new MBHConcept(valueObject.getContext(), 0, valueObject.getTransactionName());
			diagnostic.setBH_Display_Name(String.valueOf(valueObject.getRandomNumber()));
			diagnostic.setIsActive(true);
			diagnostic.setBH_ExternalID("299AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
			diagnostic.setBH_OclID("299");
			diagnostic.setBH_Owner("CIEL");
			diagnostic.setBH_Source("CIEL");
			diagnostic.saveEx();
		}
		commitEx();

		valueObject.setStepName("Create diagnostics");
		MBHEncounter encounter = new MBHEncounter(valueObject.getContext(), 0, valueObject.getTransactionName());
		encounter.setBH_Encounter_Type(MBHEncounter.BH_ENCOUNTER_TYPE_ClinicalDetails);
		encounter.setBH_Visit_ID(valueObject.getVisit().get_ID());
		encounter.setBH_Encounter_Date(TimestampUtils.today());
		encounter.saveEx();

		String diagnosticValue = "Reactive";
		MBHEncounterDiagnostic encounterDiagnostic = new MBHEncounterDiagnostic(valueObject.getContext(), 0,
				valueObject.getTransactionName());
		encounterDiagnostic.setBH_Encounter_ID(encounter.getBH_Encounter_ID());
		encounterDiagnostic.setBH_Concept_ID(diagnostic.get_ID());
		encounterDiagnostic.setBH_Value(diagnosticValue);
		encounterDiagnostic.setLineNo(10);
		encounterDiagnostic.setGroup1(String.valueOf(valueObject.getRandomNumber()));
		encounterDiagnostic.saveEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(reportUU);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				Arrays.asList(new ProcessInfoParameter("Begin Date", TimestampUtils.startOfMonth(), null, null, null),
						new ProcessInfoParameter("End Date", TimestampUtils.endOfMonth(), null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			//
			Optional<Row> specifmenReferralRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("7. SPECIMEN REFERRAL TO HIGHER LEVELS")))
					.findFirst();
			assertTrue(specifmenReferralRow.isPresent(), "specimen referral analysis is present");

			Optional<Row> specimenReferralTestRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("Specimen referral")))
					.findFirst();
			assertTrue(specimenReferralTestRow.isPresent(), "Specimen referral test row is present");
			//
			// get number of whatever
			Optional<Row> cd4CountRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains("8.1 CD4")))
					.findFirst();
			assertTrue(cd4CountRow.isPresent(), "CD4 count row is present");
		}
	}
}




































