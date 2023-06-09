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
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.report.test.utils.PDFUtils;
import org.bandahealth.idempiere.report.test.utils.TableUtils;
import org.bandahealth.idempiere.report.test.utils.TimestampUtils;
import org.compiere.process.ProcessInfoParameter;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Calendar;

import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoH717NewAndRevisitPatientCountTest extends ChuBoePopulateFactoryVO {
	private final String reportUuid = "742f515a-81c7-4690-8d35-2c6f1252ad5b";
	private final String over5YearsMale = "Over 5 years - Male";
	private final String over5YearsFemale = "Over 5 years - Female";
	private final String under5YearsMale = "Children Under 5 years - Male";
	private final String under5YearsFemale = "Children Under 5 years - Female";
	private final String over60Years = "Over 60 years";
	private final String totalGeneralOutpatients = "TOTAL GENERAL OUTPATIENTS";

	@IPopulateAnnotation.CanRun
	public void canRunReport() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(reportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		Timestamp startOfMonth = TimestampUtils.startOfMonth();
		Timestamp endOfMonth = TimestampUtils.endOfMonth();
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", startOfMonth, null, null, null),
				new ProcessInfoParameter("End Date", endOfMonth, null, null, null)
		));
		ChuBoeCreateEntity.runReport(valueObject);

		String reportContent = PDFUtils.readPdfContent(valueObject.getReport(), true);
		assertThat("Report contains General Outpatients title", reportContent,
				containsStringIgnoringCase("General Outpatients"));
	}

	@IPopulateAnnotation.CanRun
	public void dateTimeFiltersWork() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		Timestamp earlyDate = TimestampUtils.startOfYesterday();
		Timestamp beginDate = TimestampUtils.add(earlyDate, Calendar.HOUR, 2);
		Timestamp endDate = TimestampUtils.addToNow(Calendar.DAY_OF_YEAR, 2);
		Timestamp lateDate = TimestampUtils.add(endDate, Calendar.DAY_OF_YEAR, 2);

		valueObject.setStepName("Generate the report to get initial counts");
		valueObject.setProcessUuid(reportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				Arrays.asList(new ProcessInfoParameter("Begin Date", beginDate, null, null, null),
						new ProcessInfoParameter("End Date", endDate, null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		MoH717Counts initialOver5YearsMale = new MoH717Counts() {{
			name = over5YearsMale;
		}};
		MoH717Counts initialOver5YearsFemale = new MoH717Counts() {{
			name = over5YearsFemale;
		}};
		MoH717Counts initialUnder5YearsMale = new MoH717Counts() {{
			name = under5YearsMale;
		}};
		MoH717Counts initialUnder5YearsFemale = new MoH717Counts() {{
			name = under5YearsFemale;
		}};
		MoH717Counts initialOver60Years = new MoH717Counts() {{
			name = over60Years;
		}};
		MoH717Counts initialTotalGeneralOutpatients = new MoH717Counts() {{
			name = totalGeneralOutpatients;
		}};
		int labelColumnIndex = -1;
		int newVisitColumnIndex = -1;
		int revisitColumnIndex = -1;
		int totalVisitColumnIndex = -1;

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "A.1 GENERAL OUTPATIENTS(FILTER CLINICS)");
			newVisitColumnIndex = TableUtils.getColumnIndex(headerRow, "NEW");
			revisitColumnIndex = TableUtils.getColumnIndex(headerRow, "RE-ATT");
			totalVisitColumnIndex = TableUtils.getColumnIndex(headerRow, "TOTAL");

			int headerRowIndex = TableUtils.getIndexOfRow(sheet, headerRow);
			for (int i = headerRowIndex + 1; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				if (labelColumnIndex < 0) {
					for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
						if (row.getCell(j) != null && row.getCell(j).getCellType().equals(CellType.STRING) &&
								row.getCell(j).getStringCellValue().equals(initialOver5YearsMale.name)) {
							labelColumnIndex = j;
							break;
						}
					}
				}
				switch (row.getCell(labelColumnIndex).getStringCellValue()) {
					case over5YearsMale:
						initialOver5YearsMale.rowNumber = i;
						initialOver5YearsMale.newVisitsCount = (int) row.getCell(newVisitColumnIndex).getNumericCellValue();
						initialOver5YearsMale.revisitsCount = (int) row.getCell(revisitColumnIndex).getNumericCellValue();
						initialOver5YearsMale.totalCount = (int) row.getCell(totalVisitColumnIndex).getNumericCellValue();
						break;
					case over5YearsFemale:
						initialOver5YearsFemale.rowNumber = i;
						initialOver5YearsFemale.newVisitsCount = (int) row.getCell(newVisitColumnIndex).getNumericCellValue();
						initialOver5YearsFemale.revisitsCount = (int) row.getCell(revisitColumnIndex).getNumericCellValue();
						initialOver5YearsFemale.totalCount = (int) row.getCell(totalVisitColumnIndex).getNumericCellValue();
						break;
					case under5YearsMale:
						initialUnder5YearsMale.rowNumber = i;
						initialUnder5YearsMale.newVisitsCount = (int) row.getCell(newVisitColumnIndex).getNumericCellValue();
						initialUnder5YearsMale.revisitsCount = (int) row.getCell(revisitColumnIndex).getNumericCellValue();
						initialUnder5YearsMale.totalCount = (int) row.getCell(totalVisitColumnIndex).getNumericCellValue();
						break;
					case under5YearsFemale:
						initialUnder5YearsFemale.rowNumber = i;
						initialUnder5YearsFemale.newVisitsCount = (int) row.getCell(newVisitColumnIndex).getNumericCellValue();
						initialUnder5YearsFemale.revisitsCount = (int) row.getCell(revisitColumnIndex).getNumericCellValue();
						initialUnder5YearsFemale.totalCount = (int) row.getCell(totalVisitColumnIndex).getNumericCellValue();
						break;
					case over60Years:
						initialOver60Years.rowNumber = i;
						initialOver60Years.newVisitsCount = (int) row.getCell(newVisitColumnIndex).getNumericCellValue();
						initialOver60Years.revisitsCount = (int) row.getCell(revisitColumnIndex).getNumericCellValue();
						initialOver60Years.totalCount = (int) row.getCell(totalVisitColumnIndex).getNumericCellValue();
						break;
					case totalGeneralOutpatients:
						initialTotalGeneralOutpatients.rowNumber = i;
						initialTotalGeneralOutpatients.newVisitsCount =
								(int) row.getCell(newVisitColumnIndex).getNumericCellValue();
						initialTotalGeneralOutpatients.revisitsCount = (int) row.getCell(revisitColumnIndex).getNumericCellValue();
						initialTotalGeneralOutpatients.totalCount = (int) row.getCell(totalVisitColumnIndex).getNumericCellValue();
						break;
				}
			}
		}

		assertTrue(labelColumnIndex >= 0, "Label column exists");

		Timestamp birthday = TimestampUtils.addToNow(Calendar.YEAR, -10);

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		MBPartner_BH firstBusinessPartner = valueObject.getBusinessPartner();
		firstBusinessPartner.setbh_gender(MBPartner_BH.BH_GENDER_Male);
		firstBusinessPartner.setBH_Birthday(birthday);
		firstBusinessPartner.saveEx();
		commitEx();

		valueObject.setStepName("Create visit");
		valueObject.setDate(earlyDate);
		ChuBoeCreateEntity.createVisit(valueObject);
		valueObject.getVisit().setBH_NewVisit(true);
		valueObject.getVisit().saveEx();
		commitEx();

		valueObject.setStepName("Create second visit");
		valueObject.setDate(TimestampUtils.today());
		ChuBoeCreateEntity.createVisit(valueObject);
		valueObject.getVisit().setBH_NewVisit(false);
		valueObject.getVisit().saveEx();
		commitEx();

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		MBPartner_BH secondBusinessPartner = valueObject.getBusinessPartner();
		secondBusinessPartner.setbh_gender(MBPartner_BH.BH_GENDER_Male);
		secondBusinessPartner.setBH_Birthday(birthday);
		secondBusinessPartner.saveEx();
		commitEx();

		valueObject.setStepName("Create third visit");
		valueObject.setDate(TimestampUtils.today());
		ChuBoeCreateEntity.createVisit(valueObject);
		valueObject.getVisit().setBH_NewVisit(true);
		valueObject.getVisit().saveEx();
		commitEx();

		valueObject.setStepName("Create fourth visit");
		valueObject.setDate(lateDate);
		ChuBoeCreateEntity.createVisit(valueObject);
		valueObject.getVisit().setBH_NewVisit(false);
		valueObject.getVisit().saveEx();
		commitEx();

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		valueObject.getBusinessPartner().setbh_gender(MBPartner_BH.BH_GENDER_Male);
		valueObject.getBusinessPartner().setBH_Birthday(birthday);
		valueObject.getBusinessPartner().saveEx();
		commitEx();

		valueObject.setStepName("Create fifth visit");
		valueObject.setDate(lateDate);
		ChuBoeCreateEntity.createVisit(valueObject);
		valueObject.getVisit().setBH_NewVisit(true);
		valueObject.getVisit().saveEx();
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(reportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				Arrays.asList(new ProcessInfoParameter("Begin Date", beginDate, null, null, null),
						new ProcessInfoParameter("End Date", endDate, null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);

			// Over 5 years - male
			assertEquals(initialOver5YearsMale.newVisitsCount + 1,
					(int) sheet.getRow(initialOver5YearsMale.rowNumber).getCell(newVisitColumnIndex).getNumericCellValue(),
					"Over 5 years - male new visit value correct");
			assertEquals(initialOver5YearsMale.revisitsCount + 1,
					(int) sheet.getRow(initialOver5YearsMale.rowNumber).getCell(revisitColumnIndex).getNumericCellValue(),
					"Over 5 years - male revisit value correct");
			assertEquals(initialOver5YearsMale.totalCount + 2,
					(int) sheet.getRow(initialOver5YearsMale.rowNumber).getCell(totalVisitColumnIndex).getNumericCellValue(),
					"Over 5 years - male total visits value correct");

			// Over 5 years - female
			assertEquals(initialOver5YearsFemale.newVisitsCount,
					(int) sheet.getRow(initialOver5YearsFemale.rowNumber).getCell(newVisitColumnIndex).getNumericCellValue(),
					"Over 5 years - female new visit value correct");
			assertEquals(initialOver5YearsFemale.revisitsCount,
					(int) sheet.getRow(initialOver5YearsFemale.rowNumber).getCell(revisitColumnIndex).getNumericCellValue(),
					"Over 5 years - female revisit value correct");
			assertEquals(initialOver5YearsFemale.totalCount,
					(int) sheet.getRow(initialOver5YearsFemale.rowNumber).getCell(totalVisitColumnIndex).getNumericCellValue(),
					"Over 5 years - female total visits value correct");

			// Under 5 years - male
			assertEquals(initialUnder5YearsMale.newVisitsCount,
					(int) sheet.getRow(initialUnder5YearsMale.rowNumber).getCell(newVisitColumnIndex).getNumericCellValue(),
					"Under 5 years - male new visit value correct");
			assertEquals(initialUnder5YearsMale.revisitsCount,
					(int) sheet.getRow(initialUnder5YearsMale.rowNumber).getCell(revisitColumnIndex).getNumericCellValue(),
					"Under 5 years - male revisit value correct");
			assertEquals(initialUnder5YearsMale.totalCount,
					(int) sheet.getRow(initialUnder5YearsMale.rowNumber).getCell(totalVisitColumnIndex).getNumericCellValue(),
					"Under 5 years - male total visits value correct");

			// Under 5 years - female
			assertEquals(initialUnder5YearsFemale.newVisitsCount,
					(int) sheet.getRow(initialUnder5YearsFemale.rowNumber).getCell(newVisitColumnIndex).getNumericCellValue(),
					"Under 5 years - female new visit value correct");
			assertEquals(initialUnder5YearsFemale.revisitsCount,
					(int) sheet.getRow(initialUnder5YearsFemale.rowNumber).getCell(revisitColumnIndex).getNumericCellValue(),
					"Under 5 years - female revisit value correct");
			assertEquals(initialUnder5YearsFemale.totalCount,
					(int) sheet.getRow(initialUnder5YearsFemale.rowNumber).getCell(totalVisitColumnIndex).getNumericCellValue(),
					"Under 5 years - female total visits value correct");

			// Over 60 years
			assertEquals(initialOver60Years.newVisitsCount,
					(int) sheet.getRow(initialOver60Years.rowNumber).getCell(newVisitColumnIndex).getNumericCellValue(),
					"Over 60 years new visit value correct");
			assertEquals(initialOver60Years.revisitsCount,
					(int) sheet.getRow(initialOver60Years.rowNumber).getCell(revisitColumnIndex).getNumericCellValue(),
					"Over 60 years revisit value correct");
			assertEquals(initialOver60Years.totalCount,
					(int) sheet.getRow(initialOver60Years.rowNumber).getCell(totalVisitColumnIndex).getNumericCellValue(),
					"Over 60 years total visits value correct");

			// Totals
			assertEquals(initialTotalGeneralOutpatients.newVisitsCount + 1,
					(int) sheet.getRow(initialTotalGeneralOutpatients.rowNumber).getCell(newVisitColumnIndex)
							.getNumericCellValue(),
					"Totals for new visit values correct");
			assertEquals(initialTotalGeneralOutpatients.revisitsCount + 1,
					(int) sheet.getRow(initialTotalGeneralOutpatients.rowNumber).getCell(revisitColumnIndex)
							.getNumericCellValue(),
					"Totals for revisit values correct");
			assertEquals(initialTotalGeneralOutpatients.totalCount + 2,
					(int) sheet.getRow(initialTotalGeneralOutpatients.rowNumber).getCell(totalVisitColumnIndex)
							.getNumericCellValue(),
					"Totals for total visits values correct");
		}
	}

	static class MoH717Counts {
		public int rowNumber;
		public String name;
		public int newVisitsCount;
		public int revisitsCount;
		public int totalCount;
	}
}
