package org.bandahealth.idempiere.report.test;

import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;
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

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.StreamSupport;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class MoH706LabTestsSummaryTest extends ChuBoePopulateFactoryVO {
	private static final String reportUU = "83378587-d80f-4c79-874b-5cdc64893b77";

	private Map<String, Map<String, Double>> getTableInformation(Sheet sheet, String tableText,
			String lowerTableHeaderText) {
		int startingTableRow = -1;
		int startingTableColumn = -1;
		int lowerTableStartRow = sheet.getLastRowNum();
		int rightTableStartColumn = sheet.getRow(sheet.getFirstRowNum()).getLastCellNum();
		boolean found = false;
		boolean foundRightTable = false;
		boolean foundBelowTable = false;
		for (int i = sheet.getFirstRowNum(); i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
				Cell cell = row.getCell(j);
				if (cell == null) {
					continue;
				} else if (lowerTableHeaderText != null && cell.getCellType().equals(CellType.STRING) &&
						cell.getStringCellValue().contains(lowerTableHeaderText)) {
					lowerTableStartRow = i;
					foundBelowTable = true;
					break;
				}
				if (cell.getCellType().equals(CellType.STRING) && cell.getStringCellValue().contains(tableText)) {
					startingTableRow = i;
					startingTableColumn = j;
					found = true;
				} else if (found && !foundRightTable && cell.getCellType().equals(CellType.STRING) &&
						!cell.getStringCellValue().isEmpty()) {
					rightTableStartColumn = j;
					foundRightTable = true;
					break;
				}
			}
			// If we found the table, then we will have found the right table start (i.e. the end of the sheet)
			if (found) {
				foundRightTable = true;
			}
			if (foundBelowTable) {
				break;
			}
		}
		if (!found) {
			fail("Could not find table with label " + tableText);
		}
		// Go to the next row for the "header" information
		startingTableRow++;
		Map<String, Map<String, Double>> tableInformation = new HashMap<>();
		Map<Integer, String> headerCells = new HashMap<>();
		for (int i = startingTableRow; i < lowerTableStartRow; i++) {
			Row row = sheet.getRow(i);
			boolean isSubHeaderRow = false;
			boolean isRowEmpty = true;
			boolean doesRowHaveNumbers = false;
			for (int j = startingTableColumn; j < rightTableStartColumn; j++) {
				Cell cell = row.getCell(j);
				// If every cell is empty, we'll skip it
				if (cell != null && (!cell.getCellType().equals(CellType.STRING) || !cell.getStringCellValue().isEmpty())) {
					isRowEmpty = false;
				}
				// If all cells beyond the first are strings, we'll consider this a sub-header
				if (j > startingTableColumn && cell != null && cell.getCellType().equals(CellType.STRING) &&
						!cell.getStringCellValue().isEmpty()) {
					isSubHeaderRow = true;
				}
				if (j > startingTableColumn && cell != null && cell.getCellType().equals(CellType.NUMERIC)) {
					doesRowHaveNumbers = true;
				}
			}
			if (isRowEmpty) {
				continue;
			}
			if (isSubHeaderRow && !doesRowHaveNumbers) {
				headerCells = new HashMap<>();
				for (int j = startingTableColumn + 1; j < rightTableStartColumn; j++) {
					Cell cell = row.getCell(j);
					if (cell != null && cell.getCellType().equals(CellType.STRING) && !cell.getStringCellValue().isEmpty()) {
						headerCells.put(j, cell.getStringCellValue());
					}
				}
				continue;
			}
			// Get the values
			tableInformation.put(row.getCell(startingTableColumn).getStringCellValue(), new HashMap<>());
			int finalStartingTableColumn = startingTableColumn;
			headerCells.forEach((key, value) -> {
				// Value cell
				Cell cell = row.getCell(key);
				tableInformation.get(row.getCell(finalStartingTableColumn).getStringCellValue()).put(value,
						cell != null && cell.getCellType().equals(CellType.NUMERIC) ? cell.getNumericCellValue() : null);
			});
		}
		return tableInformation;
	}

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
			Optional<Row> titleRow = StreamSupport
					.stream(sheet.spliterator(), false).filter(
							row -> StreamSupport.stream(row.spliterator(), false)
									.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING)
											&& cell.getStringCellValue().contains("Laboratory Test Summary")))
					.findFirst();
			assertTrue(titleRow.isPresent(), "title is present");
		}
	}

	@IPopulateAnnotation.CanRun
	public void urineTableCountsAreCorrect() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

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
		double originalGlucoseCount = 0;
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Map<String, Map<String, Double>> urineAnalysisTableInformation =
					getTableInformation(sheet, "1. URINE ANALYSIS", "2. BLOOD CHEMISTRY");
			originalGlucoseCount = urineAnalysisTableInformation.get("1.2 Glucose").get("Number Positive");
		}

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create a visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create glucose concept if it doesn't exist");
		MBHConcept diagnostic =
				new Query(valueObject.getContext(), MBHConcept.Table_Name, MBHConcept.COLUMNNAME_BH_OclID + "=?",
						valueObject.getTransactionName()).setParameters("159734").first();
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
		encounter.setBH_Encounter_Type(MBHEncounter.BH_ENCOUNTER_TYPE_LabDiagnostics);
		encounter.setBH_Visit_ID(valueObject.getVisit().get_ID());
		encounter.setBH_Encounter_Date(TimestampUtils.today());
		encounter.saveEx();
		commitEx();

		String diagnosticValue = "Positive";
		MBHEncounterDiagnostic encounterDiagnostic = new MBHEncounterDiagnostic(valueObject.getContext(), 0,
				valueObject.getTransactionName());
		encounterDiagnostic.setBH_Encounter_ID(encounter.getBH_Encounter_ID());
		encounterDiagnostic.setBH_Concept_ID(diagnostic.get_ID());
		encounterDiagnostic.setBH_Value(diagnosticValue);
		encounterDiagnostic.setLineNo(10);
		encounterDiagnostic.setGroup1(String.valueOf(valueObject.getRandomNumber()));
		encounterDiagnostic.saveEx();
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(reportUU);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				Arrays.asList(new ProcessInfoParameter("Begin Date", TimestampUtils.startOfMonth(), null, null, null),
						new ProcessInfoParameter("End Date", TimestampUtils.endOfMonth(), null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Map<String, Map<String, Double>> urineAnalysisTableInformation =
					getTableInformation(sheet, "1. URINE ANALYSIS", "2. BLOOD CHEMISTRY");
			assertEquals(originalGlucoseCount + 1, urineAnalysisTableInformation.get("1.2 Glucose").get("Number Positive"),
					"glucose count correct");
		}
	}

	@IPopulateAnnotation.CanRun
	public void bloodChemistryTableCountAreCorrect() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

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
		Map<String, Double> originalOgttData = new HashMap<>();
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Map<String, Map<String, Double>> bloodChemistryInformation =
					getTableInformation(sheet, "2. BLOOD CHEMISTRY", "9. Drug Susceptibility Testing");
			originalOgttData = bloodChemistryInformation.get("2.2 OGTT");
		}

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create a visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create ogtt concept if it doesn't exist");
		MBHConcept diagnostic =
				new Query(valueObject.getContext(), MBHConcept.Table_Name, MBHConcept.COLUMNNAME_BH_OclID + "=?",
						valueObject.getTransactionName()).setParameters("163594").first();
		if (diagnostic == null) {
			diagnostic = new MBHConcept(valueObject.getContext(), 0, valueObject.getTransactionName());
			diagnostic.setBH_Display_Name(String.valueOf(valueObject.getRandomNumber()));
			diagnostic.setIsActive(true);
			diagnostic.setBH_ExternalID("163594AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
			diagnostic.setBH_OclID("163594");
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
		commitEx();

		String diagnosticValue = "3";
		MBHEncounterDiagnostic encounterDiagnostic = new MBHEncounterDiagnostic(valueObject.getContext(), 0,
				valueObject.getTransactionName());
		encounterDiagnostic.setBH_Encounter_ID(encounter.getBH_Encounter_ID());
		encounterDiagnostic.setBH_Concept_ID(diagnostic.get_ID());
		encounterDiagnostic.setBH_Value(diagnosticValue);
		encounterDiagnostic.setLineNo(10);
		encounterDiagnostic.setGroup1(String.valueOf(valueObject.getRandomNumber()));
		encounterDiagnostic.saveEx();
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(reportUU);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				Arrays.asList(new ProcessInfoParameter("Begin Date", TimestampUtils.startOfMonth(), null, null, null),
						new ProcessInfoParameter("End Date", TimestampUtils.endOfMonth(), null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Map<String, Double> ogttData =
					getTableInformation(sheet, "2. BLOOD CHEMISTRY", "9. Drug Susceptibility Testing").get("2.2 OGTT");
			assertEquals(originalOgttData.get("Total Exam") + 1, ogttData.get("Total Exam"), "OGTT total is correct");
			assertEquals(originalOgttData.get("Low") + 1, ogttData.get("Low"), "OGTT Low is correct");
			assertEquals(originalOgttData.get("High"), ogttData.get("High"), "OGTT high is correct");
		}
	}

	@IPopulateAnnotation.CanRun
	public void parasitologyTableCountsAreCorrect() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

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
		Map<String, Map<String, Double>> originalMalariaData = new HashMap<>();
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			originalMalariaData = getTableInformation(sheet, "3. PARASITOLOGY", "4. HAEMATOLOGY");
		}

		valueObject.setStepName("Create a minor patient");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		valueObject.getBusinessPartner().setBH_Birthday(TimestampUtils.lastMonth());
		valueObject.getBusinessPartner().saveEx();
		commitEx();

		valueObject.setStepName("Create a visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create malaria smear concept if it doesn't exist");
		MBHConcept diagnostic = new Query(valueObject.getContext(), MBHConcept.Table_Name,
				MBHConcept.COLUMNNAME_BH_OclID + "=? AND " + MBHConcept.COLUMNNAME_BH_Source + " =?",
				valueObject.getTransactionName()).setParameters("32", "CIEL").first();
		if (diagnostic == null) {
			diagnostic = new MBHConcept(valueObject.getContext(), 0, valueObject.getTransactionName());
			diagnostic.setBH_Display_Name(String.valueOf(valueObject.getRandomNumber()));
			diagnostic.setIsActive(true);
			diagnostic.setBH_ExternalID("32AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
			diagnostic.setBH_OclID("32");
			diagnostic.setBH_Owner("CIEL");
			diagnostic.setOcl_Uuid(UUID.randomUUID().toString());
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
		commitEx();

		String diagnosticValue = "Positive";
		MBHEncounterDiagnostic encounterDiagnostic = new MBHEncounterDiagnostic(valueObject.getContext(), 0,
				valueObject.getTransactionName());
		encounterDiagnostic.setBH_Encounter_ID(encounter.getBH_Encounter_ID());
		encounterDiagnostic.setBH_Concept_ID(diagnostic.get_ID());
		encounterDiagnostic.setBH_Value(diagnosticValue);
		encounterDiagnostic.setLineNo(10);
		encounterDiagnostic.setGroup1(String.valueOf(valueObject.getRandomNumber()));
		encounterDiagnostic.saveEx();
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(reportUU);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				Arrays.asList(new ProcessInfoParameter("Begin Date", TimestampUtils.startOfMonth(), null, null, null),
						new ProcessInfoParameter("End Date", TimestampUtils.endOfMonth(), null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Map<String, Map<String, Double>> malariaData = getTableInformation(sheet, "3. PARASITOLOGY", "4. HAEMATOLOGY");
			//
			// Under 5
			Map<String, Double> original31MalariaData = originalMalariaData.get("3.1 Malaria BS (Under five years)");
			Map<String, Double> current31MalariaData = malariaData.get("3.1 Malaria BS (Under five years)");
			assertEquals(original31MalariaData.get("Total Exam") + 1, current31MalariaData.get("Total Exam"),
					"3.1 Malaria total exams correct");
			assertEquals(original31MalariaData.get("Number Positive") + 1, current31MalariaData.get("Total Exam"),
					"3.1 Malaria total exams correct");
			//
			// Over 5
			Map<String, Double> original32MalariaData = originalMalariaData.get("3.2 Malaria BS (5 years and above)");
			Map<String, Double> current32MalariaData = malariaData.get("3.2 Malaria BS (5 years and above)");
			assertEquals(original32MalariaData.get("Total Exam"), current32MalariaData.get("Total Exam"),
					"3.2 Malaria total exams correct");
			assertEquals(original32MalariaData.get("Number Positive"), current32MalariaData.get("Total Exam"),
					"3.2 Malaria total exams correct");
		}
	}

	@IPopulateAnnotation.CanRun
	public void haematologyTableCountsAreCorrect() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

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
		Map<String, Map<String, Double>> originalHaematologyData = new HashMap<>();
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			originalHaematologyData = getTableInformation(sheet, "4. HAEMATOLOGY", "9. Drug Susceptibility Testing");
		}

		valueObject.setStepName("Create a patient");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create a visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create CBC concept if it doesn't exist");
		MBHConcept cbcConcept = new Query(valueObject.getContext(), MBHConcept.Table_Name,
				MBHConcept.COLUMNNAME_BH_OclID + "=? AND " + MBHConcept.COLUMNNAME_BH_Source + " =?",
				valueObject.getTransactionName()).setParameters("1019", "CIEL").first();
		if (cbcConcept == null) {
			cbcConcept = new MBHConcept(valueObject.getContext(), 0, valueObject.getTransactionName());
			cbcConcept.setBH_Display_Name("Complete blood count");
			cbcConcept.setIsActive(true);
			cbcConcept.setBH_ExternalID("1019AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
			cbcConcept.setBH_OclID("1019");
			cbcConcept.setBH_Owner("CIEL");
			cbcConcept.setBH_Source("CIEL");
			cbcConcept.saveEx();
		}
		commitEx();

		valueObject.setStepName("Create WBC concept if it doesn't exist");
		MBHConcept wbcConcept = new Query(valueObject.getContext(), MBHConcept.Table_Name,
				MBHConcept.COLUMNNAME_BH_OclID + "=? AND " + MBHConcept.COLUMNNAME_BH_Source + " =?",
				valueObject.getTransactionName()).setParameters("678", "CIEL").first();
		if (wbcConcept == null) {
			wbcConcept = new MBHConcept(valueObject.getContext(), 0, valueObject.getTransactionName());
			wbcConcept.setBH_Display_Name("White blood cells");
			wbcConcept.setIsActive(true);
			wbcConcept.setBH_ExternalID("678AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
			wbcConcept.setBH_OclID("678");
			wbcConcept.setBH_Owner("CIEL");
			wbcConcept.setBH_Source("CIEL");
			wbcConcept.saveEx();
		}
		commitEx();

		valueObject.setStepName("Create PLT concept if it doesn't exist");
		MBHConcept plateletsConcept = new Query(valueObject.getContext(), MBHConcept.Table_Name,
				MBHConcept.COLUMNNAME_BH_OclID + "=? AND " + MBHConcept.COLUMNNAME_BH_Source + " =?",
				valueObject.getTransactionName()).setParameters("729", "CIEL").first();
		if (plateletsConcept == null) {
			plateletsConcept = new MBHConcept(valueObject.getContext(), 0, valueObject.getTransactionName());
			plateletsConcept.setBH_Display_Name("Platelets");
			plateletsConcept.setIsActive(true);
			plateletsConcept.setBH_ExternalID("729AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
			plateletsConcept.setBH_OclID("729");
			plateletsConcept.setBH_Owner("CIEL");
			plateletsConcept.setBH_Source("CIEL");
			plateletsConcept.saveEx();
		}
		commitEx();

		valueObject.setStepName("Create HB concept if it doesn't exist");
		MBHConcept hbConcept = new Query(valueObject.getContext(), MBHConcept.Table_Name,
				MBHConcept.COLUMNNAME_BH_OclID + "=? AND " + MBHConcept.COLUMNNAME_BH_Source + " =?",
				valueObject.getTransactionName()).setParameters("21", "CIEL").first();
		if (hbConcept == null) {
			hbConcept = new MBHConcept(valueObject.getContext(), 0, valueObject.getTransactionName());
			hbConcept.setBH_Display_Name("Haemoglobin");
			hbConcept.setIsActive(true);
			hbConcept.setBH_ExternalID("21AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
			hbConcept.setBH_OclID("21");
			hbConcept.setBH_Owner("CIEL");
			hbConcept.setBH_Source("CIEL");
			hbConcept.saveEx();
		}
		commitEx();

		valueObject.setStepName("Create diagnostics");
		MBHEncounter encounter = new MBHEncounter(valueObject.getContext(), 0, valueObject.getTransactionName());
		encounter.setBH_Encounter_Type(MBHEncounter.BH_ENCOUNTER_TYPE_ClinicalDetails);
		encounter.setBH_Visit_ID(valueObject.getVisit().get_ID());
		encounter.setBH_Encounter_Date(TimestampUtils.today());
		encounter.saveEx();
		commitEx();

		// Handle 4.1
		// First add WBC as part of CBC panel
		MBHEncounterDiagnostic encounterDiagnostic = new MBHEncounterDiagnostic(valueObject.getContext(), 0,
				valueObject.getTransactionName());
		encounterDiagnostic.setBH_Encounter_ID(encounter.getBH_Encounter_ID());
		encounterDiagnostic.setBH_Concept_ID(wbcConcept.get_ID());
		encounterDiagnostic.setBH_Value("5");
		encounterDiagnostic.setLineNo(10);
		encounterDiagnostic.setGroup1(String.valueOf(valueObject.getRandomNumber()));
		encounterDiagnostic.setSelected_Panel_ID(cbcConcept.get_ID());
		encounterDiagnostic.saveEx();
		commitEx();
		// Add PLT as part of CBC panel
		encounterDiagnostic = new MBHEncounterDiagnostic(valueObject.getContext(), 0, valueObject.getTransactionName());
		encounterDiagnostic.setBH_Encounter_ID(encounter.getBH_Encounter_ID());
		encounterDiagnostic.setBH_Concept_ID(plateletsConcept.get_ID());
		encounterDiagnostic.setBH_Value("150");
		encounterDiagnostic.setLineNo(20);
		encounterDiagnostic.setGroup1(String.valueOf(valueObject.getRandomNumber()));
		encounterDiagnostic.setSelected_Panel_ID(cbcConcept.get_ID());
		encounterDiagnostic.saveEx();
		commitEx();
		// Finally add HB
		encounterDiagnostic = new MBHEncounterDiagnostic(valueObject.getContext(), 0, valueObject.getTransactionName());
		encounterDiagnostic.setBH_Encounter_ID(encounter.getBH_Encounter_ID());
		encounterDiagnostic.setBH_Concept_ID(hbConcept.get_ID());
		encounterDiagnostic.setBH_Value("5");
		encounterDiagnostic.setLineNo(30);
		encounterDiagnostic.setGroup1(String.valueOf(valueObject.getRandomNumber()));
		encounterDiagnostic.setSelected_Panel_ID(cbcConcept.get_ID());
		encounterDiagnostic.saveEx();
		commitEx();

		// Add another visit for 4.1 check
		valueObject.setStepName("Create a visit");
		valueObject.setRandom();
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create diagnostics");
		encounter = new MBHEncounter(valueObject.getContext(), 0, valueObject.getTransactionName());
		encounter.setBH_Encounter_Type(MBHEncounter.BH_ENCOUNTER_TYPE_ClinicalDetails);
		encounter.setBH_Visit_ID(valueObject.getVisit().get_ID());
		encounter.setBH_Encounter_Date(TimestampUtils.today());
		encounter.saveEx();
		commitEx();
		//
		// First add WBC as part of CBC panel
		encounterDiagnostic = new MBHEncounterDiagnostic(valueObject.getContext(), 0,
				valueObject.getTransactionName());
		encounterDiagnostic.setBH_Encounter_ID(encounter.getBH_Encounter_ID());
		encounterDiagnostic.setBH_Concept_ID(wbcConcept.get_ID());
		encounterDiagnostic.setBH_Value("5");
		encounterDiagnostic.setLineNo(10);
		encounterDiagnostic.setGroup1(String.valueOf(valueObject.getRandomNumber()));
		encounterDiagnostic.setSelected_Panel_ID(cbcConcept.get_ID());
		encounterDiagnostic.saveEx();
		commitEx();
		// DON'T ADD PLT, just add HB as part of CBC panel
		encounterDiagnostic = new MBHEncounterDiagnostic(valueObject.getContext(), 0, valueObject.getTransactionName());
		encounterDiagnostic.setBH_Encounter_ID(encounter.getBH_Encounter_ID());
		encounterDiagnostic.setBH_Concept_ID(hbConcept.get_ID());
		encounterDiagnostic.setBH_Value("5");
		encounterDiagnostic.setLineNo(20);
		encounterDiagnostic.setGroup1(String.valueOf(valueObject.getRandomNumber()));
		encounterDiagnostic.setSelected_Panel_ID(cbcConcept.get_ID());
		encounterDiagnostic.saveEx();
		commitEx();

		// Add another visit for 4.2 check
		valueObject.setStepName("Create a visit");
		valueObject.setRandom();
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create diagnostics");
		encounter = new MBHEncounter(valueObject.getContext(), 0, valueObject.getTransactionName());
		encounter.setBH_Encounter_Type(MBHEncounter.BH_ENCOUNTER_TYPE_ClinicalDetails);
		encounter.setBH_Visit_ID(valueObject.getVisit().get_ID());
		encounter.setBH_Encounter_Date(TimestampUtils.today());
		encounter.saveEx();
		commitEx();
		//
		// DON'T ADD PLT OR WBC, just add HB as part of CBC panel
		encounterDiagnostic = new MBHEncounterDiagnostic(valueObject.getContext(), 0, valueObject.getTransactionName());
		encounterDiagnostic.setBH_Encounter_ID(encounter.getBH_Encounter_ID());
		encounterDiagnostic.setBH_Concept_ID(hbConcept.get_ID());
		encounterDiagnostic.setBH_Value("5");
		encounterDiagnostic.setLineNo(20);
		encounterDiagnostic.setGroup1(String.valueOf(valueObject.getRandomNumber()));
		encounterDiagnostic.setSelected_Panel_ID(cbcConcept.get_ID());
		encounterDiagnostic.saveEx();
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(reportUU);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				Arrays.asList(new ProcessInfoParameter("Begin Date", TimestampUtils.startOfMonth(), null, null, null),
						new ProcessInfoParameter("End Date", TimestampUtils.endOfMonth(), null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Map<String, Map<String, Double>> HaematologyData =
					getTableInformation(sheet, "4. HAEMATOLOGY", "9. Drug Susceptibility Testing");
			//
			// FBC
			Map<String, Double> originalFullBloodCount = originalHaematologyData.get("4.1 Full blood count");
			Map<String, Double> fullBloodCount = HaematologyData.get("4.1 Full blood count");
			assertEquals(originalFullBloodCount.get("Total Exam") + 1, fullBloodCount.get("Total Exam"),
					"4.1 total count is correct");
			assertEquals(originalFullBloodCount.get("HB <5 g/dl"), fullBloodCount.get("HB <5 g/dl"),
					"4.1 HB <5 count is correct");
			assertEquals(originalFullBloodCount.get("HB between 5 and 10 g/dl") + 1,
					fullBloodCount.get("HB between 5 and 10 g/dl"), "4.1 HB 5<x<10 count is correct");
			//
			// HB estimations
			Map<String, Double> originalHBEstimationCount =
					originalHaematologyData.get("4.2 HB estimation tests (other techniques)");
			Map<String, Double> hbEstimationCount = HaematologyData.get("4.2 HB estimation tests (other techniques)");
			assertEquals(originalHBEstimationCount.get("Total Exam") + 2, hbEstimationCount.get("Total Exam"),
					"4.1 total count is correct");
			assertEquals(originalHBEstimationCount.get("HB <5 g/dl"), hbEstimationCount.get("HB <5 g/dl"),
					"4.1 HB <5 count is correct");
			assertEquals(originalHBEstimationCount.get("HB between 5 and 10 g/dl") + 2,
					hbEstimationCount.get("HB between 5 and 10 g/dl"), "4.1 HB 5<x<10 count is correct");
		}
	}

	/**
	 * Enable test once the table has been implemented.
	 *
	 * @throws SQLException
	 * @throws IOException
	 */
	@IPopulateAnnotation.CanRun
	public void bacteriologyTableCountsAreCorrect() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

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
		Map<String, Map<String, Double>> originalBacteriologyData = new HashMap<>();
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			originalBacteriologyData = getTableInformation(sheet, "5. BACTERIOLOGY", "l. Cefoxitin/oxacillin");
		}

		valueObject.setStepName("Create a patient");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create a visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create tb smear if it doesn't exist");
		MBHConcept diagnostic = new Query(valueObject.getContext(), MBHConcept.Table_Name,
				MBHConcept.COLUMNNAME_BH_OclID + "=? AND " + MBHConcept.COLUMNNAME_BH_Source + " =?",
				valueObject.getTransactionName()).setParameters("307", "CIEL").first();
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
		commitEx();

		MBHEncounterDiagnostic encounterDiagnostic = new MBHEncounterDiagnostic(valueObject.getContext(), 0,
				valueObject.getTransactionName());
		encounterDiagnostic.setBH_Encounter_ID(encounter.getBH_Encounter_ID());
		encounterDiagnostic.setBH_Concept_ID(diagnostic.get_ID());
		encounterDiagnostic.setBH_Value("Positive");
		encounterDiagnostic.setLineNo(10);
		encounterDiagnostic.setGroup1(String.valueOf(valueObject.getRandomNumber()));
		encounterDiagnostic.saveEx();
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(reportUU);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				Arrays.asList(new ProcessInfoParameter("Begin Date", TimestampUtils.startOfMonth(), null, null, null),
						new ProcessInfoParameter("End Date", TimestampUtils.endOfMonth(), null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Map<String, Map<String, Double>> bacteriologyData =
					getTableInformation(sheet, "5. BACTERIOLOGY", "l. Cefoxitin/oxacillin");
			assertEquals(originalBacteriologyData.get("5.29 Total TB smears").get("Total exam") + 1,
					bacteriologyData.get("5.29 Total TB smears").get("Total exam"), "5.29 total counts correct");
			assertEquals(originalBacteriologyData.get("5.29 Total TB smears").get("Number Positive") + 1,
					bacteriologyData.get("5.29 Total TB smears").get("Number Positive"), "5.29 positive counts correct");
		}
	}

	@IPopulateAnnotation.CanRun
	public void serologyTableCountsAreCorrect() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

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
		Map<String, Map<String, Double>> originalSerologyData = new HashMap<>();
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			originalSerologyData = getTableInformation(sheet, "7. SEROLOGY", "l. Cefoxitin/oxacillin");
		}

		valueObject.setStepName("Create a patient");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create a visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create vdrl if it doesn't exist");
		MBHConcept diagnostic = new Query(valueObject.getContext(), MBHConcept.Table_Name,
				MBHConcept.COLUMNNAME_BH_OclID + "=? AND " + MBHConcept.COLUMNNAME_BH_Source + " =?",
				valueObject.getTransactionName()).setParameters("299", "CIEL").first();
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
		commitEx();

		MBHEncounterDiagnostic encounterDiagnostic = new MBHEncounterDiagnostic(valueObject.getContext(), 0,
				valueObject.getTransactionName());
		encounterDiagnostic.setBH_Encounter_ID(encounter.getBH_Encounter_ID());
		encounterDiagnostic.setBH_Concept_ID(diagnostic.get_ID());
		encounterDiagnostic.setBH_Value("Reactive");
		encounterDiagnostic.setLineNo(10);
		encounterDiagnostic.setGroup1(String.valueOf(valueObject.getRandomNumber()));
		encounterDiagnostic.saveEx();
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(reportUU);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				Arrays.asList(new ProcessInfoParameter("Begin Date", TimestampUtils.startOfMonth(), null, null, null),
						new ProcessInfoParameter("End Date", TimestampUtils.endOfMonth(), null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Map<String, Map<String, Double>> serologyData =
					getTableInformation(sheet, "7. SEROLOGY", "l. Cefoxitin/oxacillin");
			assertEquals(originalSerologyData.get("7.1 VDRL").get("Total Exam") + 1,
					serologyData.get("7.1 VDRL").get("Total Exam"), "7.1 total counts correct");
			assertEquals(originalSerologyData.get("7.1 VDRL").get("Number Positive") + 1,
					serologyData.get("7.1 VDRL").get("Number Positive"), "7.1 positive counts correct");
		}
	}
}
