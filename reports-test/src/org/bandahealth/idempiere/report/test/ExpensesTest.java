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
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExpensesTest extends ChuBoePopulateFactoryVO {
	private static final String patientTransactionReportUuid = "bbffd5e1-973a-4d17-9ddf-9ca78a4e140d";
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

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create expense category");
		ChuBoeCreateEntity.createCharge(valueObject);
		valueObject.getCharge().setC_ChargeType_ID(expenseCategoryChargeType.getC_ChargeType_ID());
		valueObject.getCharge().saveEx();
		commitEx();

		valueObject.setStepName("Create expense");
		valueObject.setSalesPrice(new BigDecimal(100));
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_APInvoice, null, false, false, false);
		ChuBoeCreateEntity.createInvoice(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(patientTransactionReportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.startOfYesterday(), null, null, null),
				new ProcessInfoParameter("End Date", TimestampUtils.endOfTomorrow(), null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Date");
			int expenseCategoryColumnIndex = TableUtils.getColumnIndex(headerRow, "Expense Category");
			int supplierColumnIndex = TableUtils.getColumnIndex(headerRow, "Supplier");

			List<Row> expenseRows = StreamSupport.stream(sheet.spliterator(), false)
					.filter(row -> row.getCell(expenseCategoryColumnIndex) != null
							&& row.getCell(expenseCategoryColumnIndex).getCellType().equals(CellType.STRING)
							&& row.getCell(expenseCategoryColumnIndex).getStringCellValue()
							.contains(valueObject.getCharge().getName().substring(0, 30)))
					.collect(Collectors.toList());
			assertEquals(1, expenseRows.size(), "Expense category only appears once");
			assertTrue(expenseRows.get(0).getCell(supplierColumnIndex).getStringCellValue()
					.contains(valueObject.getBusinessPartner().getName().substring(0, 30)), "Supplier is correct");
		}
	}

	@IPopulateAnnotation.CanRun
	public void canFilterExpensesByExpenseCategory() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create expense category 1");
		ChuBoeCreateEntity.createCharge(valueObject);
		valueObject.getCharge().setC_ChargeType_ID(expenseCategoryChargeType.getC_ChargeType_ID());
		valueObject.getCharge().saveEx();
		MCharge_BH charge = valueObject.getCharge();
		commitEx();

		valueObject.setStepName("Create expense 1");
		valueObject.setSalesPrice(new BigDecimal(100));
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_APInvoice, null, false, false, false);
		ChuBoeCreateEntity.createInvoice(valueObject);
		commitEx();

		valueObject.clearCharge();

		valueObject.setStepName("Create expense category 2");
		ChuBoeCreateEntity.createCharge(valueObject);
		valueObject.getCharge().setC_ChargeType_ID(expenseCategoryChargeType.getC_ChargeType_ID());
		valueObject.getCharge().saveEx();
		commitEx();

		valueObject.setStepName("Create expense 2");
		valueObject.setSalesPrice(new BigDecimal(200));
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_APInvoice, null, false, false, false);
		ChuBoeCreateEntity.createInvoice(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(patientTransactionReportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.startOfYesterday(), null, null, null),
				new ProcessInfoParameter("End Date", TimestampUtils.endOfTomorrow(), null, null, null),
				new ProcessInfoParameter("C_Charge_UU", valueObject.getCharge().get_UUID(), null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Date");
			int expenseCategoryColumnIndex = TableUtils.getColumnIndex(headerRow, "Expense Category");

			Optional<Row> expense2Row = StreamSupport.stream(sheet.spliterator(), false).filter(
							row -> row.getCell(expenseCategoryColumnIndex) != null &&
									row.getCell(5).getCellType().equals(CellType.STRING) &&
									row.getCell(expenseCategoryColumnIndex).getStringCellValue().contains(valueObject.getCharge().getName()))
					.findFirst();
			assertTrue(expense2Row.isPresent(), "Searched expense appears");
			Optional<Row> expense1Row = StreamSupport.stream(sheet.spliterator(), false).filter(
							row -> row.getCell(expenseCategoryColumnIndex) != null &&
									row.getCell(expenseCategoryColumnIndex).getCellType().equals(CellType.STRING) &&
									row.getCell(expenseCategoryColumnIndex).getStringCellValue().contains(charge.getName()))
					.findFirst();
			assertTrue(expense1Row.isEmpty(), "Filtered expense doesn't appear");
		}
	}

	@IPopulateAnnotation.CanRun
	public void canFilterExpensesByBusinessPartner() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner 1");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		MBPartner_BH businessPartner = valueObject.getBusinessPartner();
		commitEx();

		valueObject.setStepName("Create expense category");
		ChuBoeCreateEntity.createCharge(valueObject);
		valueObject.getCharge().setC_ChargeType_ID(expenseCategoryChargeType.getC_ChargeType_ID());
		valueObject.getCharge().saveEx();
		commitEx();

		valueObject.setStepName("Create expense");
		valueObject.setSalesPrice(new BigDecimal(100));
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_APInvoice, null, false, false, false);
		ChuBoeCreateEntity.createInvoice(valueObject);
		commitEx();

		valueObject.clearBusinessPartner();

		valueObject.setStepName("Create business partner 2");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create expense");
		valueObject.setSalesPrice(new BigDecimal(400));
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_APInvoice, null, false, false, false);
		ChuBoeCreateEntity.createInvoice(valueObject);
		commitEx();


		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(patientTransactionReportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.startOfYesterday(), null, null, null),
				new ProcessInfoParameter("End Date", TimestampUtils.endOfTomorrow(), null, null, null),
				new ProcessInfoParameter("C_BPartner_UU", valueObject.getBusinessPartner().get_UUID(), null, null, null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Date");
			int supplierColumnIndex = TableUtils.getColumnIndex(headerRow, "Supplier");

			Optional<Row> businessPartner2Row = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getCell(supplierColumnIndex) != null &&
							row.getCell(supplierColumnIndex).getCellType().equals(CellType.STRING) &&
							row.getCell(supplierColumnIndex).getStringCellValue()
									.contains(valueObject.getBusinessPartner().getName())).findFirst();
			assertTrue(businessPartner2Row.isPresent(), "Searched business partner appears");
			Optional<Row> businessPartner1Row = StreamSupport.stream(sheet.spliterator(), false).filter(
							row -> row.getCell(supplierColumnIndex) != null &&
									row.getCell(supplierColumnIndex).getCellType().equals(CellType.STRING) &&
									row.getCell(supplierColumnIndex).getStringCellValue().contains(businessPartner.getName()))
					.findFirst();
			assertTrue(businessPartner1Row.isEmpty(), "Filtered business partner doesn't appear");
		}
	}
}
