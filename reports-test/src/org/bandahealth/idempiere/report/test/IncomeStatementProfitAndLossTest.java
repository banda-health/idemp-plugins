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
import org.bandahealth.idempiere.base.model.MChargeType_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
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
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IncomeStatementProfitAndLossTest extends ChuBoePopulateFactoryVO {
	private static final String incomeStatementProfitAndLossReportUuid = "8ea6c947-4450-48dd-8bd0-76b0f307dcb0";
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
	public void canRunReport() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(incomeStatementProfitAndLossReportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.startOfYesterday(), null, null, null),
				new ProcessInfoParameter("End Date", TimestampUtils.endOfTomorrow(), null, null, null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		double productRevenue = 0;
		double serviceRevenue = 0;
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Item");
			int amountColumnIndex = TableUtils.getColumnIndex(headerRow, "Amount");

			Optional<Row> itemRow = StreamSupport
					.stream(sheet.spliterator(), false).filter(
							row -> StreamSupport.stream(row.spliterator(), false)
									.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING)
											&& cell.getStringCellValue().contains("Product Sales")))
					.findFirst();
			assertTrue(itemRow.isPresent(), "Product Revenue is present");
			productRevenue = itemRow.get().getCell(amountColumnIndex).getNumericCellValue();

			itemRow = StreamSupport
					.stream(sheet.spliterator(), false).filter(
							row -> StreamSupport.stream(row.spliterator(), false)
									.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING)
											&& cell.getStringCellValue().contains("Service Revenue")))
					.findFirst();
			assertTrue(itemRow.isPresent(), "Service Revenue is present");
			serviceRevenue = itemRow.get().getCell(amountColumnIndex).getNumericCellValue();
		}

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createPatient(valueObject);
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(50000));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create first visit");
		Timestamp valueObjectDate = valueObject.getDate();
		valueObject.setDate(valueObjectDate);
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create first sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true,
				false, false);
		valueObject.setQuantity(new BigDecimal(1300));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create payment for the first sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_MPesa);
		valueObject.setPaymentAmount(new BigDecimal(1300));
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		valueObject.clearProduct();
		valueObject.setStepName("Create Service");
		ChuBoeCreateEntity.createProduct(valueObject);
		valueObject.getProduct().setProductType(MProduct_BH.PRODUCTTYPE_Service);
		valueObject.getProduct().saveEx();
		commitEx();

		valueObject.setStepName("Create second visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create second sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true,
				false, false);
		valueObject.setQuantity(new BigDecimal(1400));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(incomeStatementProfitAndLossReportUuid);
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

			Optional<Row> productSalesRow = StreamSupport
					.stream(sheet.spliterator(), false).filter(
							row -> StreamSupport.stream(row.spliterator(), false)
									.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING)
											&& cell.getStringCellValue().contains("Product Sales")))
					.findFirst();
			assertTrue(productSalesRow.isPresent(), "Product Revenue is present");
			assertEquals(1300, productSalesRow.get().getCell(amountColumnIndex).getNumericCellValue() - productRevenue,
					"Product revenue amount is correct");

			Optional<Row> serviceRevenueRow = StreamSupport
					.stream(sheet.spliterator(), false).filter(
							row -> StreamSupport.stream(row.spliterator(), false)
									.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING)
											&& cell.getStringCellValue().contains("Service Revenue")))
					.findFirst();
			assertTrue(serviceRevenueRow.isPresent(), "Service Revenue is present");
			assertEquals(1400, serviceRevenueRow.get().getCell(amountColumnIndex).getNumericCellValue() - serviceRevenue,
					"Service revenue amount is correct");

			Optional<Row> totalRevenueRow = StreamSupport
					.stream(sheet.spliterator(), false).filter(
							row -> StreamSupport.stream(row.spliterator(), false)
									.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING)
											&& cell.getStringCellValue().contains("Total Revenue")))
					.findFirst();
			assertTrue(totalRevenueRow.isPresent(), "Total Revenue is present");
			assertEquals(productSalesRow.get().getCell(amountColumnIndex).getNumericCellValue() +
							serviceRevenueRow.get().getCell(amountColumnIndex).getNumericCellValue(),
					totalRevenueRow.get().getCell(amountColumnIndex).getNumericCellValue(),
					"Service revenue amount is correct");
		}
	}

	@IPopulateAnnotation.CanRun
	public void costOfGoodsSoldIsCorrect() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(incomeStatementProfitAndLossReportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.startOfYesterday(), null, null, null),
				new ProcessInfoParameter("End Date", TimestampUtils.endOfTomorrow(), null, null, null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		double costOfGoodsSold = 0;
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Item");
			int amountColumnIndex = TableUtils.getColumnIndex(headerRow, "Amount");

			Optional<Row> itemRow = StreamSupport
					.stream(sheet.spliterator(), false).filter(
							row -> StreamSupport.stream(row.spliterator(), false)
									.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING)
											&& cell.getStringCellValue().contains("Product Purchases")))
					.findFirst();
			assertTrue(itemRow.isPresent(), "Product purchases is present");
			costOfGoodsSold = itemRow.get().getCell(amountColumnIndex).getNumericCellValue();
		}

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createPatient(valueObject);
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(50000));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create first sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true,
				false, false);
		valueObject.setQuantity(new BigDecimal(900));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(incomeStatementProfitAndLossReportUuid);
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

			Optional<Row> totalRevenueRow = StreamSupport
					.stream(sheet.spliterator(), false).filter(
							row -> StreamSupport.stream(row.spliterator(), false)
									.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING)
											&& cell.getStringCellValue().contains("Total Revenue")))
					.findFirst();
			assertTrue(totalRevenueRow.isPresent(), "Total Revenue is present");

			Optional<Row> productPurchasesRow = StreamSupport
					.stream(sheet.spliterator(), false).filter(
							row -> StreamSupport.stream(row.spliterator(), false)
									.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING)
											&& cell.getStringCellValue().contains("Product Purchases")))
					.findFirst();
			assertTrue(productPurchasesRow.isPresent(), "Product purchases is present");
			assertEquals(-900, productPurchasesRow.get().getCell(amountColumnIndex).getNumericCellValue() - costOfGoodsSold,
					"Service revenue amount is correct");

			Optional<Row> grossProfitRow = StreamSupport
					.stream(sheet.spliterator(), false).filter(
							row -> StreamSupport.stream(row.spliterator(), false)
									.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING)
											&& cell.getStringCellValue().contains("Gross Profit")))
					.findFirst();
			assertTrue(grossProfitRow.isPresent(), "Gross Profit is present");
			assertEquals(totalRevenueRow.get().getCell(amountColumnIndex).getNumericCellValue() +
							productPurchasesRow.get().getCell(amountColumnIndex).getNumericCellValue(),
					grossProfitRow.get().getCell(amountColumnIndex).getNumericCellValue(),
					"Gross Profit amount is correct");
		}
	}

	@IPopulateAnnotation.CanRun
	public void expensesAreGroupedCorrectly() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(incomeStatementProfitAndLossReportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.startOfYesterday(), null, null, null),
				new ProcessInfoParameter("End Date", TimestampUtils.endOfTomorrow(), null, null, null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		double facilitiesExpenses;
		double otherExpenses;
		double totalOperatingExpenses;
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Item");
			int amountColumnIndex = TableUtils.getColumnIndex(headerRow, "Amount");

			Optional<Row> itemRow = StreamSupport
					.stream(sheet.spliterator(), false).filter(
							row -> StreamSupport.stream(row.spliterator(), false)
									.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING)
											&& cell.getStringCellValue().contains("Facilities")))
					.findFirst();
			facilitiesExpenses = itemRow.map(row -> row.getCell(amountColumnIndex).getNumericCellValue()).orElse(0.0);
			//
			itemRow = StreamSupport
					.stream(sheet.spliterator(), false).filter(
							row -> StreamSupport.stream(row.spliterator(), false)
									.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING)
											&& cell.getStringCellValue().contains("Other")))
					.findFirst();
			otherExpenses = itemRow.map(row -> row.getCell(amountColumnIndex).getNumericCellValue()).orElse(0.0);
			//
			itemRow = StreamSupport
					.stream(sheet.spliterator(), false).filter(
							row -> StreamSupport.stream(row.spliterator(), false)
									.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING)
											&& cell.getStringCellValue().contains("Total Operating Expenses")))
					.findFirst();
			totalOperatingExpenses = itemRow.map(row -> row.getCell(amountColumnIndex).getNumericCellValue()).orElse(0.0);
		}

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createPatient(valueObject);
		commitEx();

		valueObject.setStepName("Create facilities expense");
		ChuBoeCreateEntity.createCharge(valueObject);
		valueObject.getCharge().setC_ChargeType_ID(expenseCategoryChargeType.getC_ChargeType_ID());
		valueObject.getCharge().setName("Facilities -" + valueObject.getRandomNumber());
		valueObject.getCharge().saveEx();
		commitEx();

		valueObject.setStepName("Create first expense");
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

		valueObject.setStepName("Create second expense");
		valueObject.setSalesPrice(new BigDecimal(200));
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_APInvoice, null, false, false, false);
		ChuBoeCreateEntity.createInvoice(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(incomeStatementProfitAndLossReportUuid);
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

			Optional<Row> facilitiesExpenseRow = StreamSupport
					.stream(sheet.spliterator(), false).filter(
							row -> StreamSupport.stream(row.spliterator(), false)
									.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING)
											&& cell.getStringCellValue().contains("Facilities")))
					.findFirst();
			assertTrue(facilitiesExpenseRow.isPresent(), "Facility expenses are present");
			assertEquals(-100,
					facilitiesExpenseRow.get().getCell(amountColumnIndex).getNumericCellValue() - facilitiesExpenses,
					"Facilities expense amount is correct");

			Optional<Row> otherExpensesRow = StreamSupport
					.stream(sheet.spliterator(), false).filter(
							row -> StreamSupport.stream(row.spliterator(), false)
									.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING)
											&& cell.getStringCellValue().contains("Other")))
					.findFirst();
			assertTrue(otherExpensesRow.isPresent(), "Other expenses are present");
			assertEquals(-200, otherExpensesRow.get().getCell(amountColumnIndex).getNumericCellValue() - otherExpenses,
					"Other expenses amount is correct");

			Optional<Row> totalOperatingExpensesRow = StreamSupport
					.stream(sheet.spliterator(), false).filter(
							row -> StreamSupport.stream(row.spliterator(), false)
									.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING)
											&& cell.getStringCellValue().contains("Total Operating Expenses")))
					.findFirst();
			assertTrue(totalOperatingExpensesRow.isPresent(), "Total operating expenses are present");
			assertEquals(-300,
					totalOperatingExpensesRow.get().getCell(amountColumnIndex).getNumericCellValue() - totalOperatingExpenses,
					"Other expenses amount is correct");

			Optional<Row> grossProfitRow = StreamSupport
					.stream(sheet.spliterator(), false).filter(
							row -> StreamSupport.stream(row.spliterator(), false)
									.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING)
											&& cell.getStringCellValue().contains("Gross Profit")))
					.findFirst();
			assertTrue(grossProfitRow.isPresent(), "Gross Profit is present");
			Optional<Row> netIncomeRow = StreamSupport
					.stream(sheet.spliterator(), false).filter(
							row -> StreamSupport.stream(row.spliterator(), false)
									.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING)
											&& cell.getStringCellValue().contains("Net Income / Profit (Loss)")))
					.findFirst();
			assertTrue(netIncomeRow.isPresent(), "Net Income row is present");
			assertEquals(grossProfitRow.get().getCell(amountColumnIndex).getNumericCellValue() +
							totalOperatingExpensesRow.get().getCell(amountColumnIndex).getNumericCellValue(),
					netIncomeRow.get().getCell(amountColumnIndex).getNumericCellValue(),
					"Gross Profit amount is correct");
		}
	}

	@IPopulateAnnotation.CanRun
	public void chargesNamedMedicationsAndSuppliesDontAppear() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(incomeStatementProfitAndLossReportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.startOfYesterday(), null, null, null),
				new ProcessInfoParameter("End Date", TimestampUtils.endOfTomorrow(), null, null, null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		double totalOperatingExpenses;
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Item");
			int amountColumnIndex = TableUtils.getColumnIndex(headerRow, "Amount");

			Optional<Row> itemRow = StreamSupport
					.stream(sheet.spliterator(), false).filter(
							row -> StreamSupport.stream(row.spliterator(), false)
									.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING)
											&& cell.getStringCellValue().contains("Total Operating Expenses")))
					.findFirst();
			totalOperatingExpenses = itemRow.map(row -> row.getCell(amountColumnIndex).getNumericCellValue()).orElse(0.0);
		}

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

		valueObject.setStepName("Create expense");
		valueObject.setSalesPrice(new BigDecimal(100));
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_APInvoice, null, false, false, false);
		ChuBoeCreateEntity.createInvoice(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(incomeStatementProfitAndLossReportUuid);
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

			Optional<Row> itemRow = StreamSupport
					.stream(sheet.spliterator(), false).filter(
							row -> StreamSupport.stream(row.spliterator(), false)
									.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING)
											&& cell.getStringCellValue().contains("Facilities")))
					.findFirst();
			double facilitiesExpenses = itemRow.map(row -> row.getCell(amountColumnIndex).getNumericCellValue()).orElse(0.0);
			//
			itemRow = StreamSupport
					.stream(sheet.spliterator(), false).filter(
							row -> StreamSupport.stream(row.spliterator(), false)
									.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING)
											&& cell.getStringCellValue().contains("Personnel")))
					.findFirst();
			double personnelExpenses = itemRow.map(row -> row.getCell(amountColumnIndex).getNumericCellValue()).orElse(0.0);
			//
			itemRow = StreamSupport
					.stream(sheet.spliterator(), false).filter(
							row -> StreamSupport.stream(row.spliterator(), false)
									.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING)
											&& cell.getStringCellValue().contains("Vehicle")))
					.findFirst();
			double vehicleExpenses = itemRow.map(row -> row.getCell(amountColumnIndex).getNumericCellValue()).orElse(0.0);
			//
			itemRow = StreamSupport
					.stream(sheet.spliterator(), false).filter(
							row -> StreamSupport.stream(row.spliterator(), false)
									.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING)
											&& cell.getStringCellValue().contains("Services")))
					.findFirst();
			double serviceExpenses = itemRow.map(row -> row.getCell(amountColumnIndex).getNumericCellValue()).orElse(0.0);
			//
			itemRow = StreamSupport
					.stream(sheet.spliterator(), false).filter(
							row -> StreamSupport.stream(row.spliterator(), false)
									.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING)
											&& cell.getStringCellValue().contains("Other")))
					.findFirst();
			double otherExpenses = itemRow.map(row -> row.getCell(amountColumnIndex).getNumericCellValue()).orElse(0.0);


			Optional<Row> totalOperatingExpensesRow = StreamSupport
					.stream(sheet.spliterator(), false).filter(
							row -> StreamSupport.stream(row.spliterator(), false)
									.anyMatch(cell -> cell != null && cell.getCellType().equals(CellType.STRING)
											&& cell.getStringCellValue().contains("Total Operating Expenses")))
					.findFirst();
			assertTrue(totalOperatingExpensesRow.isPresent(), "Total operating expenses are present");
			assertEquals(totalOperatingExpenses,
					totalOperatingExpensesRow.get().getCell(amountColumnIndex).getNumericCellValue(),
					"Total operating expenses didn't change");
			assertEquals(facilitiesExpenses + personnelExpenses + vehicleExpenses + serviceExpenses + otherExpenses,
					totalOperatingExpensesRow.get().getCell(amountColumnIndex).getNumericCellValue(),
					"Total operating amount is correct");
		}
	}
}
