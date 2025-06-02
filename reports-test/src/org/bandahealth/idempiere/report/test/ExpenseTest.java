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
import org.bandahealth.idempiere.base.model.MChargeType_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.report.test.utils.TableUtils;
import org.bandahealth.idempiere.report.test.utils.TimestampUtils;
import org.compiere.model.Query;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfoParameter;
import org.hamcrest.Matchers;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.stream.StreamSupport;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This is meant to test all reports related to income so numbers can be
 * verified across them
 */
public class ExpenseTest extends ChuBoePopulateFactoryVO {
	private final String incomeAndExpenseReportUuid = "f777f042-3907-4293-94c4-49fe6eb58780";
	private final String incomeStatementReportUuid = "8ea6c947-4450-48dd-8bd0-76b0f307dcb0";
	private MChargeType_BH expenseCategoryChargeType;

	@IPopulateAnnotation.CanRunBeforeClass
	public void prepareIt() throws Exception {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), Matchers.is(Matchers.nullValue()));

		expenseCategoryChargeType = new Query(valueObject.getContext(), MChargeType_BH.Table_Name,
				MChargeType_BH.COLUMNNAME_Name + "=?", valueObject.getTransactionName())
				.setParameters(MChargeType_BH.CHARGETYPENAME_DEFAULT_EXPENSE_CATEGORY).setClient_ID().first();
		if (expenseCategoryChargeType == null) {
			expenseCategoryChargeType = new MChargeType_BH(valueObject.getContext(), 0,
					valueObject.getTransactionName());
			expenseCategoryChargeType.setDescription("For an expense category added by default");
			expenseCategoryChargeType.setName(MChargeType_BH.CHARGETYPENAME_DEFAULT_EXPENSE_CATEGORY);
			expenseCategoryChargeType.saveEx();
		}

		valueObject.setStepName("Open needed periods");
		ChuBoeCreateEntity.createAndOpenAllFiscalYears(valueObject);
		commitEx();
	}

	@IPopulateAnnotation.CanRun
	public void expensesAreConsistentAcrossReports() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createPatient(valueObject);
		commitEx();

		valueObject.setStepName("Create Medications & Supplies expense");
		MCharge_BH medicationsAndExpensesCharge =
				new Query(valueObject.getContext(), MCharge_BH.Table_Name, MCharge_BH.COLUMNNAME_Name + "=?",
						valueObject.getTransactionName()).setParameters("Medications & Supplies").setClient_ID().first();
		if (medicationsAndExpensesCharge == null) {
			medicationsAndExpensesCharge = new MCharge_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
			medicationsAndExpensesCharge.setName("Medications & Supplies");
			medicationsAndExpensesCharge.setC_ChargeType_ID(expenseCategoryChargeType.getC_ChargeType_ID());
			medicationsAndExpensesCharge.saveEx();
		}
		valueObject.setCharge(medicationsAndExpensesCharge);
		commitEx();

		valueObject.setStepName("Create first expense");
		valueObject.setSalesPrice(new BigDecimal(100));
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_APInvoice, null, false, false, false);
		ChuBoeCreateEntity.createInvoice(valueObject);
		commitEx();

		valueObject.setStepName("Create facilities expense");
		ChuBoeCreateEntity.createCharge(valueObject);
		valueObject.getCharge().setC_ChargeType_ID(expenseCategoryChargeType.getC_ChargeType_ID());
		valueObject.getCharge().setName("Facilities -" + valueObject.getRandomNumber());
		valueObject.getCharge().saveEx();
		commitEx();

		valueObject.setStepName("Create second expense");
		valueObject.setSalesPrice(new BigDecimal(100));
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_APInvoice, null, false, false, false);
		ChuBoeCreateEntity.createInvoice(valueObject);
		commitEx();

		valueObject.setStepName("Create other expense");
		valueObject.clearCharge();
		ChuBoeCreateEntity.createCharge(valueObject);
		valueObject.getCharge().setC_ChargeType_ID(expenseCategoryChargeType.getC_ChargeType_ID());
		valueObject.getCharge().saveEx();
		commitEx();

		valueObject.setStepName("Create third expense");
		valueObject.setSalesPrice(new BigDecimal(200));
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_APInvoice, null, false, false, false);
		ChuBoeCreateEntity.createInvoice(valueObject);
		commitEx();

		valueObject.setStepName("Create finances expense");
		valueObject.clearCharge();
		ChuBoeCreateEntity.createCharge(valueObject);
		valueObject.getCharge().setC_ChargeType_ID(expenseCategoryChargeType.getC_ChargeType_ID());
		valueObject.getCharge().setName("Finances -" + valueObject.getRandomNumber());
		valueObject.getCharge().saveEx();
		commitEx();

		valueObject.setStepName("Create fourth expense");
		valueObject.setSalesPrice(new BigDecimal(200));
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_APInvoice, null, false, false, false);
		ChuBoeCreateEntity.createInvoice(valueObject);
		commitEx();

		valueObject.setStepName("Generate the income & expense overview report");
		valueObject.setProcessUuid(incomeAndExpenseReportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.startOfYesterday(), null, null, null),
				new ProcessInfoParameter("End Date", TimestampUtils.endOfTomorrow(), null, null, null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		double facilityExpenses = 0;
		double personnelExpenses = 0;
		double vehicleExpenses = 0;
		double financeExpenses = 0;
		double serviceExpenses = 0;
		double otherExpenses = 0;
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Category");
			int headerRowIndex = TableUtils.getIndexOfRow(sheet, headerRow);
			int expenseNameIndex = TableUtils.getColumnIndex(headerRow, "Category");
			final int expenseAmountIndex = TableUtils.getColumnIndex(headerRow, "Amount");

			int totalsRowIndex = -1;
			for (int i = headerRowIndex + 1; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				Cell expenseName = row.getCell(expenseNameIndex);
				if (expenseName != null && expenseName.getCellType().equals(CellType.STRING)) {
					switch (expenseName.getStringCellValue()) {
						case "Facility":
							facilityExpenses = row.getCell(expenseAmountIndex).getNumericCellValue();
							break;
						case "Personnel":
							personnelExpenses = row.getCell(expenseAmountIndex).getNumericCellValue();
							break;
						case "Vehicle":
							vehicleExpenses = row.getCell(expenseAmountIndex).getNumericCellValue();
							break;
						case "Finances":
							financeExpenses = row.getCell(expenseAmountIndex).getNumericCellValue();
							break;
						case "Services":
							serviceExpenses = row.getCell(expenseAmountIndex).getNumericCellValue();
							break;
						case "Other":
							otherExpenses = row.getCell(expenseAmountIndex).getNumericCellValue();
							break;
					}
				}
			}
		}

		valueObject.setStepName("Generate the income statement report");
		valueObject.setProcessUuid(incomeStatementReportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.startOfYesterday(), null, null, null),
				new ProcessInfoParameter("End Date", TimestampUtils.endOfTomorrow(), null, null, null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Item");
			int amountColumnIndex = TableUtils.getColumnIndex(headerRow, "Amount");

			assertEquals(facilityExpenses, StreamSupport.stream(sheet.spliterator(), false).filter(
									row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
											cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
													cell.getStringCellValue().contains("Facilities"))).findFirst()
							.map(row -> row.getCell(amountColumnIndex).getNumericCellValue() * -1).orElse(0.0),
					"Facilities expense totals match");

			assertEquals(personnelExpenses, StreamSupport.stream(sheet.spliterator(), false).filter(
									row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
											cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
													cell.getStringCellValue().contains("Personnel"))).findFirst()
							.map(row -> row.getCell(amountColumnIndex).getNumericCellValue() * -1).orElse(0.0),
					"Personnel expense totals match");

			assertEquals(vehicleExpenses, StreamSupport.stream(sheet.spliterator(), false).filter(
									row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
											cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
													cell.getStringCellValue().contains("Vehicle"))).findFirst()
							.map(row -> row.getCell(amountColumnIndex).getNumericCellValue() * -1).orElse(0.0),
					"Vehicle expense totals match");

			assertEquals(financeExpenses, StreamSupport.stream(sheet.spliterator(), false).filter(
									row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
											cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
													cell.getStringCellValue().contains("Finances"))).findFirst()
							.map(row -> row.getCell(amountColumnIndex).getNumericCellValue() * -1).orElse(0.0),
					"Finances expense totals match");

			assertEquals(serviceExpenses, StreamSupport.stream(sheet.spliterator(), false).filter(
									row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
											cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
													cell.getStringCellValue().contains("Services"))).findFirst()
							.map(row -> row.getCell(amountColumnIndex).getNumericCellValue() * -1).orElse(0.0),
					"Services expense totals match");

			assertEquals(otherExpenses, StreamSupport.stream(sheet.spliterator(), false).filter(
									row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
											cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
													cell.getStringCellValue().contains("Other"))).findFirst()
							.map(row -> row.getCell(amountColumnIndex).getNumericCellValue() * -1).orElse(0.0),
					"Other expense totals match");

			assertEquals(
					facilityExpenses + personnelExpenses + vehicleExpenses + financeExpenses + serviceExpenses + otherExpenses,
					StreamSupport.stream(sheet.spliterator(), false).filter(row -> StreamSupport.stream(row.spliterator(), false)
									.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
											cell.getStringCellValue().contains("Total Operating Expenses"))).findFirst()
							.map(row -> row.getCell(amountColumnIndex).getNumericCellValue() * -1).orElse(0.0),
					"Total Operating expense totals match");
		}
	}
}
