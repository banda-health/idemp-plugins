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
import org.bandahealth.idempiere.base.model.MBHConceptMapping;
import org.bandahealth.idempiere.base.model.MBHEncounter;
import org.bandahealth.idempiere.base.model.MBHEncounterDiagnostic;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.utils.StringUtil;
import org.bandahealth.idempiere.report.test.utils.TimestampUtils;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.hamcrest.Matchers;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static java.util.UUID.randomUUID;
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
		double originalGlucoseCount;
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
		MBHConcept diagnostic = getOrCreateConcept(valueObject, "CIEL", "159734", "CIEL");

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
		Map<String, Map<String, Double>> originalBloodChemistryData;
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			originalBloodChemistryData =
					getTableInformation(sheet, "2. BLOOD CHEMISTRY", "9. Drug Susceptibility Testing");
		}

		valueObject.setStepName("Create ogtt concept if it doesn't exist");
		MBHConcept diagnostic = getOrCreateConcept(valueObject, "CIEL", "163594", "CIEL");
		createNVisitsForThisDiagnosticWithValue(valueObject, 1, diagnostic, "3");

		valueObject.setStepName("Create creatinine concept if it doesn't exist");
		diagnostic = getOrCreateConcept(valueObject, "CIEL", "790", "CIEL");
		Timestamp newbornBirthday = TimestampUtils.addToNow(Calendar.DATE, -15);
		int numberCreatinineNewbornLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberCreatinineNewbornLow, null,
				newbornBirthday, diagnostic, "26");
		int numberCreatinineNewbornNormalLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberCreatinineNewbornNormalLow, null,
				newbornBirthday, diagnostic, "27");
		int numberCreatinineNewbornNormalHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberCreatinineNewbornNormalHigh, null,
				newbornBirthday, diagnostic, "106");
		int numberCreatinineNewbornHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberCreatinineNewbornHigh, null,
				newbornBirthday, diagnostic, "107");
		//
		Timestamp babyBirthday = TimestampUtils.addToNow(Calendar.MONTH, -6);
		int numberCreatinineBabyLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberCreatinineBabyLow, null, babyBirthday,
				diagnostic, "17");
		int numberCreatinineBabyNormalLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberCreatinineBabyNormalLow, null,
				babyBirthday, diagnostic, "18");
		int numberCreatinineBabyNormalHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberCreatinineBabyNormalHigh, null,
				babyBirthday, diagnostic, "35");
		int numberCreatinineBabyHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberCreatinineBabyHigh, null, babyBirthday,
				diagnostic, "36");
		//
		Timestamp childBirthday = TimestampUtils.addToNow(Calendar.YEAR, -6);
		int numberCreatinineChildLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberCreatinineChildLow, null, childBirthday,
				diagnostic, "26");
		int numberCreatinineChildNormalLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberCreatinineChildNormalLow, null,
				childBirthday, diagnostic, "27");
		int numberCreatinineChildNormalHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberCreatinineChildNormalHigh, null,
				childBirthday, diagnostic, "62");
		int numberCreatinineChildHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberCreatinineChildHigh, null,
				childBirthday,
				diagnostic, "63");
		//
		Timestamp teenagerBirthday = TimestampUtils.addToNow(Calendar.YEAR, -15);
		int numberCreatinineTeenagerBoyLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberCreatinineTeenagerBoyLow,
				MBPartner_BH.BH_GENDER_Male, teenagerBirthday, diagnostic, "52");
		int numberCreatinineTeenagerBoyNormalLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberCreatinineTeenagerBoyNormalLow,
				MBPartner_BH.BH_GENDER_Male, teenagerBirthday, diagnostic, "53");
		int numberCreatinineTeenagerBoyNormalHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberCreatinineTeenagerBoyNormalHigh,
				MBPartner_BH.BH_GENDER_Male, teenagerBirthday, diagnostic, "106");
		int numberCreatinineTeenagerBoyHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberCreatinineTeenagerBoyHigh,
				MBPartner_BH.BH_GENDER_Male, teenagerBirthday, diagnostic, "107");
		int numberCreatinineTeenagerGirlLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberCreatinineTeenagerGirlLow,
				MBPartner_BH.BH_GENDER_Female, teenagerBirthday, diagnostic, "43");
		int numberCreatinineTeenagerGirlNormalLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberCreatinineTeenagerGirlNormalLow,
				MBPartner_BH.BH_GENDER_Female, teenagerBirthday, diagnostic, "44");
		int numberCreatinineTeenagerGirlNormalHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberCreatinineTeenagerGirlNormalHigh,
				MBPartner_BH.BH_GENDER_Female, teenagerBirthday, diagnostic, "88");
		int numberCreatinineTeenagerGirlHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberCreatinineTeenagerGirlHigh,
				MBPartner_BH.BH_GENDER_Female, teenagerBirthday, diagnostic, "89");
		//
		Timestamp adultBirthday = TimestampUtils.addToNow(Calendar.YEAR, -30);
		int numberCreatinineAdultBoyLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberCreatinineAdultBoyLow,
				MBPartner_BH.BH_GENDER_Male, adultBirthday, diagnostic, "59");
		int numberCreatinineAdultBoyNormalLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberCreatinineAdultBoyNormalLow,
				MBPartner_BH.BH_GENDER_Male, adultBirthday, diagnostic, "60");
		int numberCreatinineAdultBoyNormalHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberCreatinineAdultBoyNormalHigh,
				MBPartner_BH.BH_GENDER_Male, adultBirthday, diagnostic, "110");
		int numberCreatinineAdultBoyHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberCreatinineAdultBoyHigh,
				MBPartner_BH.BH_GENDER_Male, adultBirthday, diagnostic, "111");
		int numberCreatinineAdultGirlLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberCreatinineAdultGirlLow,
				MBPartner_BH.BH_GENDER_Female, adultBirthday, diagnostic, "44");
		int numberCreatinineAdultGirlNormalLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberCreatinineAdultGirlNormalLow,
				MBPartner_BH.BH_GENDER_Female, adultBirthday, diagnostic, "45");
		int numberCreatinineAdultGirlNormalHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberCreatinineAdultGirlNormalHigh,
				MBPartner_BH.BH_GENDER_Female, adultBirthday, diagnostic, "90");
		int numberCreatinineAdultGirlHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberCreatinineAdultGirlHigh,
				MBPartner_BH.BH_GENDER_Female, adultBirthday, diagnostic, "91");

		valueObject.setStepName("Create sodium concept if it doesn't exist");
		diagnostic = getOrCreateConcept(valueObject, "CIEL", "1132", "CIEL");
		int numberSodiumLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberSodiumLow, diagnostic, "134");
		int numberSodiumNormalLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberSodiumNormalLow, diagnostic, "135");
		int numberSodiumNormalHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberSodiumNormalHigh, diagnostic, "145");
		int numberSodiumHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberSodiumHigh, diagnostic, "146");

		valueObject.setStepName("Create urea concept if it doesn't exist");
		diagnostic = getOrCreateConcept(valueObject, "CIEL", "857", "CIEL");
		int numberUreaLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberUreaLow, diagnostic, "2.05");
		int numberUreaNormalLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberUreaNormalLow, diagnostic, "2.1");
		int numberUreaNormalHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberUreaNormalHigh, diagnostic, "7.1");
		int numberUreaHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberUreaHigh, diagnostic, "7.15");

		valueObject.setStepName("Create potassium concept if it doesn't exist");
		diagnostic = getOrCreateConcept(valueObject, "CIEL", "1133", "CIEL");
		int numberPotassiumLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberPotassiumLow, diagnostic, "3.45");
		int numberPotassiumNormalLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberPotassiumNormalLow, diagnostic, "3.5");
		int numberPotassiumNormalHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberPotassiumNormalHigh, diagnostic, "5.6");
		int numberPotassiumHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberPotassiumHigh, diagnostic, "5.65");

		valueObject.setStepName("Create chlorides concept if it doesn't exist");
		diagnostic = getOrCreateConcept(valueObject, "CIEL", "1134", "CIEL");
		int numberChloridesLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberChloridesLow, diagnostic, "95");
		int numberChloridesNormalLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberChloridesNormalLow, diagnostic, "96");
		int numberChloridesNormalHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberChloridesNormalHigh, diagnostic, "107");
		int numberChloridesHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberChloridesHigh, diagnostic, "108");

		valueObject.setStepName("Create direct bilirubin concept if it doesn't exist");
		diagnostic = getOrCreateConcept(valueObject, "CIEL", "1297", "CIEL");
		int numberDirectBilirubinNormalLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberDirectBilirubinNormalLow, diagnostic, "0.1");
		int numberDirectBilirubinNormalHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberDirectBilirubinNormalHigh, diagnostic, "5.1");
		int numberDirectBilirubinHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberDirectBilirubinHigh, diagnostic, "5.15");

		valueObject.setStepName("Create total bilirubin concept if it doesn't exist");
		diagnostic = getOrCreateConcept(valueObject, "CIEL", "655", "CIEL");
		int numberTotalBilirubinLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberTotalBilirubinLow, diagnostic, "1.7");
		int numberTotalBilirubinNormalLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberTotalBilirubinNormalLow, diagnostic, "1.71");
		int numberTotalBilirubinNormalHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberTotalBilirubinNormalHigh, diagnostic, "20.5");
		int numberTotalBilirubinHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberTotalBilirubinHigh, diagnostic, "20.6");

		valueObject.setStepName("Create asat concept if it doesn't exist");
		diagnostic = getOrCreateConcept(valueObject, "CIEL", "653", "CIEL");
		int numberAsatLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberAsatLow, diagnostic, "24");
		int numberAsatNormalLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberAsatNormalLow, diagnostic, "25");
		int numberAsatNormalHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberAsatNormalHigh, diagnostic, "45");
		int numberAsatHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberAsatHigh, diagnostic, "46");

		valueObject.setStepName("Create alat concept if it doesn't exist");
		diagnostic = getOrCreateConcept(valueObject, "CIEL", "654", "CIEL");
		int numberAlatNormalLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberAlatNormalLow, diagnostic, "0.1");
		int numberAlatNormalHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberAlatNormalHigh, diagnostic, "35");
		int numberAlatHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberAlatHigh, diagnostic, "36");

		valueObject.setStepName("Create serum protein concept if it doesn't exist");
		diagnostic = getOrCreateConcept(valueObject, "CIEL", "717", "CIEL");
		int numberSerumProteinLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberSerumProteinLow, diagnostic, "5.9");
		int numberSerumProteinNormalLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberSerumProteinNormalLow, diagnostic, "6");
		int numberSerumProteinNormalHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberSerumProteinNormalHigh, diagnostic, "8.3");
		int numberSerumProteinHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberSerumProteinHigh, diagnostic, "8.4");

		valueObject.setStepName("Create albumin concept if it doesn't exist");
		diagnostic = getOrCreateConcept(valueObject, "CIEL", "848", "CIEL");
		int numberAlbuminLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberAlbuminLow, diagnostic, "3.4");
		int numberAlbuminNormalLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberAlbuminNormalLow, diagnostic, "3.5");
		int numberAlbuminNormalHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberAlbuminNormalHigh, diagnostic, "5");
		int numberAlbuminHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberAlbuminHigh, diagnostic, "5.1");

		valueObject.setStepName("Create alkaline phosphatase concept if it doesn't exist");
		diagnostic = getOrCreateConcept(valueObject, "CIEL", "785", "CIEL");
		newbornBirthday = TimestampUtils.addToNow(Calendar.DATE, -15);
		int numberAlkalinePhosphataseNewbornLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberAlkalinePhosphataseNewbornLow, null,
				newbornBirthday, diagnostic, "82");
		int numberAlkalinePhosphataseNewbornNormalLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberAlkalinePhosphataseNewbornNormalLow,
				null,
				newbornBirthday, diagnostic, "83");
		int numberAlkalinePhosphataseNewbornNormalHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberAlkalinePhosphataseNewbornNormalHigh,
				null,
				newbornBirthday, diagnostic, "380");
		int numberAlkalinePhosphataseNewbornHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberAlkalinePhosphataseNewbornHigh, null,
				newbornBirthday, diagnostic, "381");
		//
		babyBirthday = TimestampUtils.addToNow(Calendar.MONTH, -6);
		int numberAlkalinePhosphataseBabyLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberAlkalinePhosphataseBabyLow, null,
				babyBirthday,
				diagnostic, "119");
		int numberAlkalinePhosphataseBabyNormalLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberAlkalinePhosphataseBabyNormalLow, null,
				babyBirthday, diagnostic, "120");
		int numberAlkalinePhosphataseBabyNormalHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberAlkalinePhosphataseBabyNormalHigh, null,
				babyBirthday, diagnostic, "470");
		int numberAlkalinePhosphataseBabyHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberAlkalinePhosphataseBabyHigh, null,
				babyBirthday,
				diagnostic, "471");
		//
		childBirthday = TimestampUtils.addToNow(Calendar.YEAR, -6);
		int numberAlkalinePhosphataseChildLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberAlkalinePhosphataseChildLow, null,
				childBirthday,
				diagnostic, "139");
		int numberAlkalinePhosphataseChildNormalLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberAlkalinePhosphataseChildNormalLow, null,
				childBirthday, diagnostic, "140");
		int numberAlkalinePhosphataseChildNormalHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberAlkalinePhosphataseChildNormalHigh,
				null,
				childBirthday, diagnostic, "335");
		int numberAlkalinePhosphataseChildHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberAlkalinePhosphataseChildHigh, null,
				childBirthday, diagnostic, "336");
		//
		Timestamp tweenBirthday = TimestampUtils.addToNow(Calendar.YEAR, -11);
		int numberAlkalinePhosphataseTweenLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberAlkalinePhosphataseTweenLow, null,
				tweenBirthday,
				diagnostic, "129");
		int numberAlkalinePhosphataseTweenNormalLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberAlkalinePhosphataseTweenNormalLow, null,
				tweenBirthday, diagnostic, "130");
		int numberAlkalinePhosphataseTweenNormalHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberAlkalinePhosphataseTweenNormalHigh,
				null,
				tweenBirthday, diagnostic, "420");
		int numberAlkalinePhosphataseTweenHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberAlkalinePhosphataseTweenHigh, null,
				tweenBirthday, diagnostic, "421");
		//
		Timestamp youngTeenagerBirthday = TimestampUtils.addToNow(Calendar.YEAR, -14);
		int numberAlkalinePhosphataseYoungTeenagerBoyLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberAlkalinePhosphataseYoungTeenagerBoyLow,
				MBPartner_BH.BH_GENDER_Male, youngTeenagerBirthday, diagnostic, "114");
		int numberAlkalinePhosphataseYoungTeenagerBoyNormalLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject,
				numberAlkalinePhosphataseYoungTeenagerBoyNormalLow,
				MBPartner_BH.BH_GENDER_Male, youngTeenagerBirthday, diagnostic, "115");
		int numberAlkalinePhosphataseYoungTeenagerBoyNormalHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject,
				numberAlkalinePhosphataseYoungTeenagerBoyNormalHigh,
				MBPartner_BH.BH_GENDER_Male, youngTeenagerBirthday, diagnostic, "420");
		int numberAlkalinePhosphataseYoungTeenagerBoyHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberAlkalinePhosphataseYoungTeenagerBoyHigh,
				MBPartner_BH.BH_GENDER_Male, youngTeenagerBirthday, diagnostic, "421");
		int numberAlkalinePhosphataseYoungTeenagerGirlLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberAlkalinePhosphataseYoungTeenagerGirlLow,
				MBPartner_BH.BH_GENDER_Female, youngTeenagerBirthday, diagnostic, "51");
		int numberAlkalinePhosphataseYoungTeenagerGirlNormalLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject,
				numberAlkalinePhosphataseYoungTeenagerGirlNormalLow,
				MBPartner_BH.BH_GENDER_Female, youngTeenagerBirthday, diagnostic, "52");
		int numberAlkalinePhosphataseYoungTeenagerGirlNormalHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject,
				numberAlkalinePhosphataseYoungTeenagerGirlNormalHigh,
				MBPartner_BH.BH_GENDER_Female, youngTeenagerBirthday, diagnostic, "255");
		int numberAlkalinePhosphataseYoungTeenagerGirlHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject,
				numberAlkalinePhosphataseYoungTeenagerGirlHigh,
				MBPartner_BH.BH_GENDER_Female, youngTeenagerBirthday, diagnostic, "256");
		//
		Timestamp middleTeenagerBirthday = TimestampUtils.addToNow(Calendar.YEAR, -15);
		int numberAlkalinePhosphataseMiddleTeenagerBoyLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberAlkalinePhosphataseMiddleTeenagerBoyLow,
				MBPartner_BH.BH_GENDER_Male, middleTeenagerBirthday, diagnostic, "79");
		int numberAlkalinePhosphataseMiddleTeenagerBoyNormalLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject,
				numberAlkalinePhosphataseMiddleTeenagerBoyNormalLow,
				MBPartner_BH.BH_GENDER_Male, middleTeenagerBirthday, diagnostic, "80");
		int numberAlkalinePhosphataseMiddleTeenagerBoyNormalHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject,
				numberAlkalinePhosphataseMiddleTeenagerBoyNormalHigh,
				MBPartner_BH.BH_GENDER_Male, middleTeenagerBirthday, diagnostic, "300");
		int numberAlkalinePhosphataseMiddleTeenagerBoyHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject,
				numberAlkalinePhosphataseMiddleTeenagerBoyHigh,
				MBPartner_BH.BH_GENDER_Male, middleTeenagerBirthday, diagnostic, "301");
		int numberAlkalinePhosphataseMiddleTeenagerGirlLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject,
				numberAlkalinePhosphataseMiddleTeenagerGirlLow,
				MBPartner_BH.BH_GENDER_Female, middleTeenagerBirthday, diagnostic, "49");
		int numberAlkalinePhosphataseMiddleTeenagerGirlNormalLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject,
				numberAlkalinePhosphataseMiddleTeenagerGirlNormalLow,
				MBPartner_BH.BH_GENDER_Female, middleTeenagerBirthday, diagnostic, "50");
		int numberAlkalinePhosphataseMiddleTeenagerGirlNormalHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject,
				numberAlkalinePhosphataseMiddleTeenagerGirlNormalHigh,
				MBPartner_BH.BH_GENDER_Female, middleTeenagerBirthday, diagnostic, "116");
		int numberAlkalinePhosphataseMiddleTeenagerGirlHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject,
				numberAlkalinePhosphataseMiddleTeenagerGirlHigh,
				MBPartner_BH.BH_GENDER_Female, middleTeenagerBirthday, diagnostic, "117");
		//
		Timestamp oldTeenagerBirthday = TimestampUtils.addToNow(Calendar.YEAR, -18);
		int numberAlkalinePhosphataseOldTeenagerBoyLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberAlkalinePhosphataseOldTeenagerBoyLow,
				MBPartner_BH.BH_GENDER_Male, oldTeenagerBirthday, diagnostic, "54");
		int numberAlkalinePhosphataseOldTeenagerBoyNormalLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject,
				numberAlkalinePhosphataseOldTeenagerBoyNormalLow,
				MBPartner_BH.BH_GENDER_Male, oldTeenagerBirthday, diagnostic, "55");
		int numberAlkalinePhosphataseOldTeenagerBoyNormalHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject,
				numberAlkalinePhosphataseOldTeenagerBoyNormalHigh,
				MBPartner_BH.BH_GENDER_Male, oldTeenagerBirthday, diagnostic, "149");
		int numberAlkalinePhosphataseOldTeenagerBoyHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberAlkalinePhosphataseOldTeenagerBoyHigh,
				MBPartner_BH.BH_GENDER_Male, oldTeenagerBirthday, diagnostic, "150");
		int numberAlkalinePhosphataseOldTeenagerGirlLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberAlkalinePhosphataseOldTeenagerGirlLow,
				MBPartner_BH.BH_GENDER_Female, oldTeenagerBirthday, diagnostic, "44");
		int numberAlkalinePhosphataseOldTeenagerGirlNormalLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject,
				numberAlkalinePhosphataseOldTeenagerGirlNormalLow,
				MBPartner_BH.BH_GENDER_Female, oldTeenagerBirthday, diagnostic, "45");
		int numberAlkalinePhosphataseOldTeenagerGirlNormalHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject,
				numberAlkalinePhosphataseOldTeenagerGirlNormalHigh,
				MBPartner_BH.BH_GENDER_Female, oldTeenagerBirthday, diagnostic, "87");
		int numberAlkalinePhosphataseOldTeenagerGirlHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberAlkalinePhosphataseOldTeenagerGirlHigh,
				MBPartner_BH.BH_GENDER_Female, oldTeenagerBirthday, diagnostic, "88");
		//
		adultBirthday = TimestampUtils.addToNow(Calendar.YEAR, -30);
		int numberAlkalinePhosphataseAdultLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberAlkalinePhosphataseAdultLow, null,
				adultBirthday,
				diagnostic, "29");
		int numberAlkalinePhosphataseAdultNormalLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberAlkalinePhosphataseAdultNormalLow, null,
				adultBirthday, diagnostic, "30");
		int numberAlkalinePhosphataseAdultNormalHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberAlkalinePhosphataseAdultNormalHigh,
				null,
				adultBirthday, diagnostic, "130");
		int numberAlkalinePhosphataseAdultHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberAlkalinePhosphataseAdultHigh, null,
				adultBirthday, diagnostic, "131");

		valueObject.setStepName("Create total cholesterol concept if it doesn't exist");
		diagnostic = getOrCreateConcept(valueObject, "CIEL", "1006", "CIEL");
		int numberTotalCholesterolNormalLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberTotalCholesterolNormalLow, diagnostic, "0.1");
		int numberTotalCholesterolNormalHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberTotalCholesterolNormalHigh, diagnostic, "5.17");
		int numberTotalCholesterolHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberTotalCholesterolHigh, diagnostic, "5.18");

		valueObject.setStepName("Create triglycerides concept if it doesn't exist");
		diagnostic = getOrCreateConcept(valueObject, "CIEL", "1009", "CIEL");
		int numberTriglyceridesNormalLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberTriglyceridesNormalLow, diagnostic, "0.1");
		int numberTriglyceridesNormalHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberTriglyceridesNormalHigh, diagnostic, "2.26");
		int numberTriglyceridesHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberTriglyceridesHigh, diagnostic, "2.27");

		valueObject.setStepName("Create ldl concept if it doesn't exist");
		diagnostic = getOrCreateConcept(valueObject, "CIEL", "1008", "CIEL");
		int numberLdlNormalLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberLdlNormalLow, diagnostic, "0.1");
		int numberLdlNormalHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberLdlNormalHigh, diagnostic, "3.4");
		int numberLdlHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberLdlHigh, diagnostic, "3.5");

		valueObject.setStepName("Create T3 concept if it doesn't exist");
		diagnostic = getOrCreateConcept(valueObject, "CIEL", "161503", "CIEL");
		int numberT3Low = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberT3Low, diagnostic, "0.15");
		int numberT3NormalLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberT3NormalLow, diagnostic, "0.2");
		int numberT3NormalHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberT3NormalHigh, diagnostic, "0.5");
		int numberT3High = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberT3High, diagnostic, "0.55");

		valueObject.setStepName("Create T4 concept if it doesn't exist");
		diagnostic = getOrCreateConcept(valueObject, "CIEL", "161504", "CIEL");
		int numberT4Low = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberT4Low, diagnostic, "4.4");
		int numberT4NormalLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberT4NormalLow, diagnostic, "4.5");
		int numberT4NormalHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberT4NormalHigh, diagnostic, "12.5");
		int numberT4High = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberT4High, diagnostic, "12.6");

		valueObject.setStepName("Create TSH concept if it doesn't exist");
		diagnostic = getOrCreateConcept(valueObject, "CIEL", "168213", "CIEL");
		int numberTshLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberTshLow, diagnostic, "0.35");
		int numberTshNormalLow = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberTshNormalLow, diagnostic, "0.4");
		int numberTshNormalHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberTshNormalHigh, diagnostic, "4.5");
		int numberTshHigh = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberTshHigh, diagnostic, "4.6");

		valueObject.setStepName("Create PSA concept if it doesn't exist");
		diagnostic = getOrCreateConcept(valueObject, "CIEL", "160913", "CIEL");
		int numberPsaNormal = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberPsaNormal, diagnostic, "4");
		int numberPsaPositive = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberPsaPositive, diagnostic, "4.1");

		valueObject.setStepName("Create CA 15-3 concept if it doesn't exist");
		diagnostic = getOrCreateConcept(valueObject, "CIEL", "160920", "CIEL");
		int numberCa15_3Normal = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberCa15_3Normal, diagnostic, "30");
		int numberCa15_3Positive = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberCa15_3Positive, diagnostic, "31");

		valueObject.setStepName("Create CA 19-9 concept if it doesn't exist");
		diagnostic = getOrCreateConcept(valueObject, "CIEL", "160921", "CIEL");
		int numberCa19_9Normal = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberCa19_9Normal, diagnostic, "37");
		int numberCa19_9Positive = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberCa19_9Positive, diagnostic, "38");

		valueObject.setStepName("Create CA 125 concept if it doesn't exist");
		diagnostic = getOrCreateConcept(valueObject, "CIEL", "160919", "CIEL");
		int numberCa125Normal = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberCa125Normal, diagnostic, "35");
		int numberCa125Positive = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberCa125Positive, diagnostic, "36");

		valueObject.setStepName("Create CEA concept if it doesn't exist");
		diagnostic = getOrCreateConcept(valueObject, "CIEL", "160915", "CIEL");
		int numberCeaNormal = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberCeaNormal, diagnostic, "3");
		int numberCeaPositive = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberCeaPositive, diagnostic, "3.05");

		valueObject.setStepName("Create AFP concept if it doesn't exist");
		diagnostic = getOrCreateConcept(valueObject, "CIEL", "160917", "CIEL");
		int numberAfpNormal = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberAfpNormal, diagnostic, "10");
		int numberAfpPositive = (int) Math.floor(Math.random() * 5) + 1;
		createNVisitsForThisDiagnosticWithValue(valueObject, numberAfpPositive, diagnostic, "11");

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
			Map<String, Map<String, Double>> bloodChemistryData =
					getTableInformation(sheet, "2. BLOOD CHEMISTRY", "9. Drug Susceptibility Testing");
			String label = "2.2 OGTT";
			Map<String, Double> data = bloodChemistryData.get(label);
			Map<String, Double> originalData = originalBloodChemistryData.get(label);
			assertEquals(originalData.get("Total Exam") + 1, data.get("Total Exam"), label + " total is correct");
			assertEquals(originalData.get("Low") + 1, data.get("Low"), label + " Low is correct");
			assertEquals(originalData.get("High"), data.get("High"), label + " high is correct");
			//
			label = "2.4 Creatinine";
			data = bloodChemistryData.get(label);
			originalData = originalBloodChemistryData.get(label);
			assertEquals(
					originalData.get("Low") + numberCreatinineNewbornLow + numberCreatinineBabyLow + numberCreatinineChildLow +
							numberCreatinineTeenagerBoyLow + numberCreatinineTeenagerGirlLow + numberCreatinineAdultBoyLow +
							numberCreatinineAdultGirlLow, data.get("Low"), label + " Low is correct");
			assertEquals(originalData.get("High") + numberCreatinineNewbornHigh + numberCreatinineBabyHigh +
					numberCreatinineChildHigh + numberCreatinineTeenagerBoyHigh + numberCreatinineTeenagerGirlHigh +
					numberCreatinineAdultBoyHigh + numberCreatinineAdultGirlHigh, data.get("High"), label + " high is correct");
			//
			label = "2.5 Urea";
			data = bloodChemistryData.get(label);
			originalData = originalBloodChemistryData.get(label);
			assertEquals(originalData.get("Low") + numberUreaLow, data.get("Low"), label + " Low is correct");
			assertEquals(originalData.get("High") + numberUreaHigh, data.get("High"), label + " high is correct");
			//
			label = "2.5 Sodium";
			data = bloodChemistryData.get(label);
			originalData = originalBloodChemistryData.get(label);
			assertEquals(originalData.get("Low") + numberSodiumLow, data.get("Low"), label + " Low is correct");
			assertEquals(originalData.get("High") + numberSodiumHigh, data.get("High"), label + " high is correct");
			//
			label = "2.6 Potassium";
			data = bloodChemistryData.get(label);
			originalData = originalBloodChemistryData.get(label);
			assertEquals(originalData.get("Low") + numberPotassiumLow, data.get("Low"), label + " Low is correct");
			assertEquals(originalData.get("High") + numberPotassiumHigh, data.get("High"), label + " high is correct");
			//
			label = "2.7 Chlorides";
			data = bloodChemistryData.get(label);
			originalData = originalBloodChemistryData.get(label);
			assertEquals(originalData.get("Low") + numberChloridesLow, data.get("Low"), label + " Low is correct");
			assertEquals(originalData.get("High") + numberChloridesHigh, data.get("High"), label + " high is correct");
			//
			label = "2.9 Direct bilirubin";
			data = bloodChemistryData.get(label);
			originalData = originalBloodChemistryData.get(label);
			assertEquals(0, data.get("Low"), label + " Low is correct");
			assertEquals(originalData.get("High") + numberDirectBilirubinHigh, data.get("High"), label + " high is correct");
			//
			label = "2.10 Total bilirubin";
			data = bloodChemistryData.get(label);
			originalData = originalBloodChemistryData.get(label);
			assertEquals(originalData.get("Low") + numberTotalBilirubinLow, data.get("Low"), label + " Low is correct");
			assertEquals(originalData.get("High") + numberTotalBilirubinHigh, data.get("High"), label + " high is correct");
			//
			label = "2.11 ASAT (SGOT)";
			data = bloodChemistryData.get(label);
			originalData = originalBloodChemistryData.get(label);
			assertEquals(originalData.get("Low") + numberAsatLow, data.get("Low"), label + " Low is correct");
			assertEquals(originalData.get("High") + numberAsatHigh, data.get("High"), label + " high is correct");
			//
			label = "2.12 ALAT (SGPT)";
			data = bloodChemistryData.get(label);
			originalData = originalBloodChemistryData.get(label);
			assertEquals(0, data.get("Low"), label + " Low is correct");
			assertEquals(originalData.get("High") + numberAlatHigh, data.get("High"), label + " high is correct");
			//
			label = "2.13 Serum Protein";
			data = bloodChemistryData.get(label);
			originalData = originalBloodChemistryData.get(label);
			assertEquals(originalData.get("Low") + numberSerumProteinLow, data.get("Low"), label + " Low is correct");
			assertEquals(originalData.get("High") + numberSerumProteinHigh, data.get("High"), label + " high is correct");
			//
			label = "2.14 Albumin";
			data = bloodChemistryData.get(label);
			originalData = originalBloodChemistryData.get(label);
			assertEquals(originalData.get("Low") + numberAlbuminLow, data.get("Low"), label + " Low is correct");
			assertEquals(originalData.get("High") + numberAlbuminHigh, data.get("High"), label + " high is correct");
			//
			label = "2.15 Alkaline Phosphatase";
			data = bloodChemistryData.get(label);
			originalData = originalBloodChemistryData.get(label);
			assertEquals(originalData.get("Low") + numberAlkalinePhosphataseNewbornLow + numberAlkalinePhosphataseBabyLow +
					numberAlkalinePhosphataseChildLow + numberAlkalinePhosphataseTweenLow +
					numberAlkalinePhosphataseYoungTeenagerBoyLow + numberAlkalinePhosphataseYoungTeenagerGirlLow +
					numberAlkalinePhosphataseMiddleTeenagerBoyLow + numberAlkalinePhosphataseMiddleTeenagerGirlLow +
					numberAlkalinePhosphataseOldTeenagerBoyLow + numberAlkalinePhosphataseOldTeenagerGirlLow +
					numberAlkalinePhosphataseAdultLow, data.get("Low"), label + " Low is correct");
			assertEquals(originalData.get("High") + numberAlkalinePhosphataseNewbornHigh + numberAlkalinePhosphataseBabyHigh +
							numberAlkalinePhosphataseChildHigh + numberAlkalinePhosphataseTweenHigh +
							numberAlkalinePhosphataseYoungTeenagerBoyHigh + numberAlkalinePhosphataseYoungTeenagerGirlHigh +
							numberAlkalinePhosphataseMiddleTeenagerBoyHigh + numberAlkalinePhosphataseMiddleTeenagerGirlHigh +
							numberAlkalinePhosphataseOldTeenagerBoyHigh + numberAlkalinePhosphataseOldTeenagerGirlHigh +
							numberAlkalinePhosphataseAdultHigh, data.get("High"),
					label + " high is correct");
			//
			label = "2.17 Total cholesterol";
			data = bloodChemistryData.get(label);
			originalData = originalBloodChemistryData.get(label);
			assertEquals(originalData.get("Total Exam") + numberTotalCholesterolHigh + numberTotalCholesterolNormalHigh +
					numberTotalCholesterolNormalLow, data.get("Total Exam"), label + " total is correct");
			assertEquals(0, data.get("Low"), label + " Low is correct");
			assertEquals(originalData.get("High") + numberTotalCholesterolHigh, data.get("High"), label + " high is " +
					"correct");
			//
			label = "2.18 Triglycerides";
			data = bloodChemistryData.get(label);
			originalData = originalBloodChemistryData.get(label);
			assertEquals(originalData.get("Total Exam") + numberTriglyceridesNormalLow + numberTriglyceridesNormalHigh +
					numberTriglyceridesHigh, data.get("Total Exam"), label + " total is correct");
			assertEquals(0, data.get("Low"), label + " Low is correct");
			assertEquals(originalData.get("High") + numberTriglyceridesHigh, data.get("High"), label + " high is " +
					"correct");
			//
			label = "2.19 LDL";
			data = bloodChemistryData.get(label);
			originalData = originalBloodChemistryData.get(label);
			assertEquals(originalData.get("Total Exam") + numberLdlNormalLow + numberLdlNormalHigh + numberLdlHigh,
					data.get("Total Exam"), label + " total is correct");
			assertEquals(0, data.get("Low"), label + " Low is correct");
			assertEquals(originalData.get("High") + numberLdlHigh, data.get("High"), label + " high is correct");
			//
			label = "2.20 T3";
			data = bloodChemistryData.get(label);
			originalData = originalBloodChemistryData.get(label);
			assertEquals(originalData.get("Total Exam") + numberT3Low + numberT3NormalLow + numberT3NormalHigh + numberT3High,
					data.get("Total Exam"), label + " total is correct");
			assertEquals(originalData.get("Low") + numberT3Low, data.get("Low"), label + " Low is correct");
			assertEquals(originalData.get("High") + numberT3High, data.get("High"), label + " high is correct");
			//
			label = "2.21 T4";
			data = bloodChemistryData.get(label);
			originalData = originalBloodChemistryData.get(label);
			assertEquals(originalData.get("Total Exam") + numberT4Low + numberT4NormalLow + numberT4NormalHigh + numberT4High,
					data.get("Total Exam"), label + " total is correct");
			assertEquals(originalData.get("Low") + numberT4Low, data.get("Low"), label + " Low is correct");
			assertEquals(originalData.get("High") + numberT4High, data.get("High"), label + " high is correct");
			//
			label = "2.22 TSH";
			data = bloodChemistryData.get(label);
			originalData = originalBloodChemistryData.get(label);
			assertEquals(
					originalData.get("Total Exam") + numberTshLow + numberTshNormalLow + numberTshNormalHigh + numberTshHigh,
					data.get("Total Exam"), label + " total is correct");
			assertEquals(originalData.get("Low") + numberTshLow, data.get("Low"), label + " Low is correct");
			assertEquals(originalData.get("High") + numberTshHigh, data.get("High"), label + " high is correct");
			//
			label = "2.23 PSA";
			data = bloodChemistryData.get(label);
			originalData = originalBloodChemistryData.get(label);
			assertEquals(originalData.get("Total Exam") + numberPsaNormal + numberPsaPositive, data.get("Total Exam"),
					label + " total is correct");
			assertEquals(originalData.get("Number Positive") + numberPsaPositive, data.get("Number Positive"),
					label + " number positive is correct");
			//
			label = "2.24 CA 15-3";
			data = bloodChemistryData.get(label);
			originalData = originalBloodChemistryData.get(label);
			assertEquals(originalData.get("Total Exam") + numberCa15_3Normal + numberCa15_3Positive, data.get("Total Exam"),
					label + " total is correct");
			assertEquals(originalData.get("Number Positive") + numberCa15_3Positive, data.get("Number Positive"),
					label + " number positive is correct");
			//
			label = "2.25 CA 19-9";
			data = bloodChemistryData.get(label);
			originalData = originalBloodChemistryData.get(label);
			assertEquals(originalData.get("Total Exam") + numberCa19_9Normal + numberCa19_9Positive, data.get("Total Exam"),
					label + " total is correct");
			assertEquals(originalData.get("Number Positive") + numberCa19_9Positive, data.get("Number Positive"),
					label + " number positive is correct");
			//
			label = "2.26 CA 125";
			data = bloodChemistryData.get(label);
			originalData = originalBloodChemistryData.get(label);
			assertEquals(originalData.get("Total Exam") + numberCa125Normal + numberCa125Positive, data.get("Total Exam"),
					label + " total is correct");
			assertEquals(originalData.get("Number Positive") + numberCa125Positive, data.get("Number Positive"),
					label + " number positive is correct");
			//
			label = "2.27 CEA";
			data = bloodChemistryData.get(label);
			originalData = originalBloodChemistryData.get(label);
			assertEquals(originalData.get("Total Exam") + numberCeaNormal + numberCeaPositive, data.get("Total Exam"),
					label + " total is correct");
			assertEquals(originalData.get("Number Positive") + numberCeaPositive, data.get("Number Positive"),
					label + " number positive is correct");
			//
			label = "2.28 AFP";
			data = bloodChemistryData.get(label);
			originalData = originalBloodChemistryData.get(label);
			assertEquals(originalData.get("Total Exam") + numberAfpNormal + numberAfpPositive, data.get("Total Exam"),
					label + " total is correct");
			assertEquals(originalData.get("Number Positive") + numberAfpPositive, data.get("Number Positive"),
					label + " number positive is correct");
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
		Map<String, Map<String, Double>> originalMalariaData;
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
			diagnostic.setOcl_Uuid("32AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
			diagnostic.setBH_OclID("32");
			diagnostic.setBH_Owner("CIEL");
			diagnostic.setOcl_Uuid(randomUUID().toString());
			diagnostic.setBH_Source("CIEL");
			diagnostic.setURL("/orgs/CIEL/sources/CIEL/concepts/32/");
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
		Map<String, Map<String, Double>> originalHaematologyData;
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
			cbcConcept.setOcl_Uuid("1019AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
			cbcConcept.setBH_OclID("1019");
			cbcConcept.setBH_Owner("CIEL");
			cbcConcept.setBH_Source("CIEL");
			cbcConcept.setURL("/orgs/CIEL/sources/CIEL/concepts/1019/");
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
			wbcConcept.setOcl_Uuid("678AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
			wbcConcept.setBH_OclID("678");
			wbcConcept.setBH_Owner("CIEL");
			wbcConcept.setBH_Source("CIEL");
			wbcConcept.setURL("/orgs/CIEL/sources/CIEL/concepts/678/");
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
			plateletsConcept.setOcl_Uuid("729AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
			plateletsConcept.setBH_OclID("729");
			plateletsConcept.setBH_Owner("CIEL");
			plateletsConcept.setBH_Source("CIEL");
			plateletsConcept.setURL("/orgs/CIEL/sources/CIEL/concepts/729/");
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
			hbConcept.setOcl_Uuid("21AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
			hbConcept.setBH_OclID("21");
			hbConcept.setBH_Owner("CIEL");
			hbConcept.setBH_Source("CIEL");
			hbConcept.setURL("/orgs/CIEL/sources/CIEL/concepts/21/");
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
		Map<String, Map<String, Double>> originalBacteriologyData;
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
			diagnostic.setOcl_Uuid("307AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
			diagnostic.setBH_OclID("307");
			diagnostic.setBH_Owner("CIEL");
			diagnostic.setBH_Source("CIEL");
			diagnostic.setURL("/orgs/CIEL/sources/CIEL/concepts/307/");
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
		Map<String, Map<String, Double>> originalSerologyData;
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
			diagnostic.setOcl_Uuid("299AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
			diagnostic.setBH_OclID("299");
			diagnostic.setBH_Owner("CIEL");
			diagnostic.setBH_Source("CIEL");
			diagnostic.setURL("/orgs/CIEL/sources/CIEL/concepts/299/");
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

	@IPopulateAnnotation.CanRun
	public void bandaSameAsMappingIsCounted() throws SQLException, IOException {
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
		Map<String, Map<String, Double>> originalSerologyData;
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

		valueObject.setStepName("Create CIEL Helocobacter diagnostic if it doesn't exist");
		MBHConcept cielConcept = new Query(valueObject.getContext(), MBHConcept.Table_Name,
				MBHConcept.COLUMNNAME_BH_OclID + "=? AND " + MBHConcept.COLUMNNAME_BH_Source + " =?",
				valueObject.getTransactionName()).setParameters("163620", "CIEL").first();
		if (cielConcept == null) {
			cielConcept = new MBHConcept(valueObject.getContext(), 0, valueObject.getTransactionName());
			cielConcept.setBH_Display_Name("Helicobacter Pylori Ab presence in serum by immunofluorescence test");
			cielConcept.setIsActive(true);
			cielConcept.setBH_ExternalID("163620AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
			cielConcept.setOcl_Uuid("163620AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
			cielConcept.setBH_OclID("163620");
			cielConcept.setBH_Owner("CIEL");
			cielConcept.setBH_Source("CIEL");
			cielConcept.setURL("/orgs/CIEL/sources/CIEL/concepts/163620/");
			cielConcept.saveEx();
			commitEx();
		}

		valueObject.setStepName("Create BH Helocobacter diagnostic if it doesn't exist");
		MBHConcept diagnostic = new Query(valueObject.getContext(), MBHConcept.Table_Name,
				MBHConcept.COLUMNNAME_BH_OclID + "=? AND " + MBHConcept.COLUMNNAME_BH_Source + " =?",
				valueObject.getTransactionName()).setParameters("7749563", "BHLabs").first();
		if (diagnostic == null) {
			diagnostic = new MBHConcept(valueObject.getContext(), 0, valueObject.getTransactionName());
			diagnostic.setBH_Display_Name("Helicobacter Pylori Ab presence in serum by immunofluorescence test");
			diagnostic.setIsActive(true);
			diagnostic.setBH_ExternalID("8ba6a78c-f49e-4acc-b076-e7ba55415173");
			diagnostic.setOcl_Uuid("8ba6a78c-f49e-4acc-b076-e7ba55415173");
			diagnostic.setBH_OclID("7749563");
			diagnostic.setBH_Owner("bandahealth");
			diagnostic.setBH_Source("BHLabs");
			diagnostic.setURL("/orgs/bandahealth/sources/BHLabs/concepts/7749563/");
			diagnostic.saveEx();
			commitEx();
		}

		// Confirm that the same-as mapping exists
		MBHConceptMapping conceptMapping = new Query(valueObject.getContext(), MBHConceptMapping.Table_Name,
				MBHConceptMapping.COLUMNNAME_BH_From_Concept_Url + "=? AND " + MBHConceptMapping.COLUMNNAME_BH_To_Concept_Url +
						"=?", valueObject.getTransactionName()).setParameters("/orgs/bandahealth/sources/BHLabs/concepts/7749563/",
				"/orgs/CIEL/sources/CIEL/concepts/163620/").first();
		if (conceptMapping == null) {
			conceptMapping = new MBHConceptMapping(valueObject.getContext(), 0, valueObject.getTransactionName());
			conceptMapping.setBH_Map_Type("SAME-AS");
			conceptMapping.setIsActive(true);
			conceptMapping.setFrom_BH_Concept_ID(diagnostic.get_ID());
			conceptMapping.setBH_From_Concept_Url("/orgs/bandahealth/sources/BHLabs/concepts/7749563/");
			conceptMapping.setBH_OclID("10246889");
			conceptMapping.setOcl_Uuid("10246889");
			conceptMapping.setBH_Owner("bandahealth");
			conceptMapping.setBH_Source("BHLabs");
			conceptMapping.setTo_BH_Concept_ID(cielConcept.get_ID());
			conceptMapping.setBH_To_Concept_Url("/orgs/CIEL/sources/CIEL/concepts/163620/");
			conceptMapping.saveEx();
			commitEx();
		}

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
			Map<String, Map<String, Double>> serologyData =
					getTableInformation(sheet, "7. SEROLOGY", "l. Cefoxitin/oxacillin");
			assertEquals(originalSerologyData.get("7.7 Helicobacter pylori").get("Total Exam") + 1,
					serologyData.get("7.7 Helicobacter pylori").get("Total Exam"), "7.7 total counts correct");
			assertEquals(originalSerologyData.get("7.7 Helicobacter pylori").get("Number Positive") + 1,
					serologyData.get("7.7 Helicobacter pylori").get("Number Positive"), "7.7 positive counts correct");
		}
	}

	private MBHConcept getOrCreateConcept(ChuBoePopulateVO valueObject, String source, String oclID, String owner)
			throws SQLException {
		MBHConcept diagnostic = new Query(valueObject.getContext(), MBHConcept.Table_Name,
				MBHConcept.COLUMNNAME_BH_OclID + "=? AND " + MBHConcept.COLUMNNAME_BH_Source + " =?",
				valueObject.getTransactionName()).setParameters(oclID, source).first();
		if (diagnostic == null) {
			diagnostic = new MBHConcept(valueObject.getContext(), 0, valueObject.getTransactionName());
			diagnostic.setBH_Display_Name(valueObject.getStepMessage());
			diagnostic.setIsActive(true);
			diagnostic.setBH_ExternalID(String.valueOf(randomUUID()));
			diagnostic.setOcl_Uuid(String.valueOf(randomUUID()));
			diagnostic.setBH_OclID(oclID);
			diagnostic.setBH_Owner(owner);
			diagnostic.setBH_Source(source);
			diagnostic.setURL("/orgs/" + owner + "/sources/" + source + "/concepts/" + oclID + "/");
			diagnostic.saveEx();
			commitEx();
		}
		return diagnostic;
	}

	private void createNVisitsForThisDiagnosticWithValue(ChuBoePopulateVO valueObject, int numberOfVisits,
			MBHConcept diagnostic, String diagnosticValue) throws SQLException {
		createNVisitsWithAPatientLikeForThisDiagnosticWithValue(valueObject, numberOfVisits, null, null, diagnostic,
				diagnosticValue);
	}

	private void createNVisitsWithAPatientLikeForThisDiagnosticWithValue(ChuBoePopulateVO valueObject,
			int numberOfVisits, String patientGender, Timestamp patientBirthday, MBHConcept diagnostic,
			String diagnosticValue) throws SQLException {
		String stepName = "Create a patient";
		if (!StringUtil.isNullOrEmpty(patientGender)) {
			stepName += " with gender " + patientGender;
		}
		if (patientBirthday != null) {
			stepName += " with birthday " + patientBirthday;
		}
		valueObject.setStepName(stepName);
		valueObject.clearBusinessPartner();
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		if (!StringUtil.isNullOrEmpty(patientGender)) {
			valueObject.getBusinessPartner().setbh_gender(patientGender);
		}
		if (patientBirthday != null) {
			valueObject.getBusinessPartner().setBH_Birthday(patientBirthday);
		}
		valueObject.getBusinessPartner().saveEx();
		commitEx();

		valueObject.setStepName("Create a visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create encounter");
		MBHEncounter encounter = new MBHEncounter(valueObject.getContext(), 0, valueObject.getTransactionName());
		encounter.setBH_Encounter_Type(MBHEncounter.BH_ENCOUNTER_TYPE_ClinicalDetails);
		encounter.setBH_Visit_ID(valueObject.getVisit().get_ID());
		encounter.setBH_Encounter_Date(TimestampUtils.today());
		encounter.saveEx();
		commitEx();

		valueObject.setStepName("Create diagnostics");
		for (int i = 0; i < numberOfVisits; i++) {
			MBHEncounterDiagnostic encounterDiagnostic = new MBHEncounterDiagnostic(valueObject.getContext(), 0,
					valueObject.getTransactionName());
			encounterDiagnostic.setBH_Encounter_ID(encounter.getBH_Encounter_ID());
			encounterDiagnostic.setBH_Concept_ID(diagnostic.get_ID());
			encounterDiagnostic.setBH_Value(diagnosticValue);
			encounterDiagnostic.setLineNo((i + 1) * 10);
			encounterDiagnostic.setGroup1(String.valueOf(valueObject.getRandomNumber()));
			encounterDiagnostic.saveEx();
			commitEx();
		}
	}
}
