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
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.report.test.utils.TableUtils;
import org.bandahealth.idempiere.report.test.utils.TimestampUtils;
import org.compiere.model.MProcess;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.util.Env;
import org.hamcrest.Matchers;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PurchasedStockReportTest extends ChuBoePopulateFactoryVO {
	private static final String reportUU = "113867a8-c1b0-4f80-8472-2c3cfc06abf5";

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
	public void hasBeginAndEndDateParameters() throws Exception {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		MProcess process = MProcess.get(Env.getCtx(), reportUU);
		assertThat("Purchased Stock Report has a Begin Date parameter", process.getParameter("Begin Date"),
				is(notNullValue()));
		assertThat("Purchased Stock Report has an End Date parameter", process.getParameter("End Date"),
				is(notNullValue()));
	}

	@IPopulateAnnotation.CanRun
	public void purchasedStockAppearsOnTheReport() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create vendor");
		valueObject.setSalesStandardPrice(new BigDecimal(100));
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create purchase order");
		valueObject.setDate(TimestampUtils.today());
		valueObject.setQuantity(new BigDecimal(2));
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create material receipt");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialReceipt, null, false, false, false);
		ChuBoeCreateEntity.createInOutFromOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create vendor bill");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_APInvoice, null, false, false, false);
		ChuBoeCreateEntity.createInvoice(valueObject);
		commitEx();

		BigDecimal grandTotal = valueObject.getInvoice().getGrandTotal();
		BigDecimal amountPaid = grandTotal.divide(new BigDecimal(2), 2, RoundingMode.HALF_UP);
		BigDecimal balanceDue = grandTotal.subtract(amountPaid);

		valueObject.setStepName("Pay part of the vendor bill");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		valueObject.setPaymentAmount(amountPaid);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_APPayment, null, false, false, false);
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(reportUU);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.startOfYesterday(), null, null, null),
				new ProcessInfoParameter("End Date", TimestampUtils.endOfTomorrow(), null, null, null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);
		assertThat("Report was generated", valueObject.getErrorMessage(), is(nullValue()));

		String vendorName = valueObject.getBusinessPartner().getName();
		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Transaction Date");
			int vendorColumnIndex = TableUtils.getColumnIndex(headerRow, "Supplier Name");
			int totalBillColumnIndex = TableUtils.getColumnIndex(headerRow, "Total Bill Amount");
			int amountPaidColumnIndex = TableUtils.getColumnIndex(headerRow, "Amount Paid");
			int balanceDueColumnIndex = TableUtils.getColumnIndex(headerRow, "Balance Due (AP)");
			int receivedByColumnIndex = TableUtils.getColumnIndex(headerRow, "Received By");

			Optional<Row> vendorRow = StreamSupport.stream(sheet.spliterator(), false).filter(
							row -> row.getCell(vendorColumnIndex) != null &&
									row.getCell(vendorColumnIndex).getCellType().equals(CellType.STRING) &&
									row.getCell(vendorColumnIndex).getStringCellValue().equals(vendorName))
					.findFirst();
			assertTrue(vendorRow.isPresent(), "The vendor bill appears on the report");

			assertEquals(grandTotal.doubleValue(),
					vendorRow.get().getCell(totalBillColumnIndex).getNumericCellValue(), 0.01,
					"Total bill amount is the invoice gross");
			assertEquals(amountPaid.doubleValue(),
					vendorRow.get().getCell(amountPaidColumnIndex).getNumericCellValue(), 0.01,
					"Amount paid reflects the allocated payment");
			assertEquals(balanceDue.doubleValue(),
					vendorRow.get().getCell(balanceDueColumnIndex).getNumericCellValue(), 0.01,
					"Balance due is gross less amount paid");

			Cell receivedByCell = vendorRow.get().getCell(receivedByColumnIndex);
			assertTrue(receivedByCell != null && receivedByCell.getCellType().equals(CellType.STRING) &&
					!receivedByCell.getStringCellValue().isBlank(), "Received by is populated from the receipt");
		}
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

		String earlyVendorName = "Early-" + valueObject.getRandomNumber();
		String inRangeVendorName = "InRange-" + valueObject.getRandomNumber();
		String lateVendorName = "Late-" + valueObject.getRandomNumber();

		createPurchasedStockVendorBill(valueObject, earlyDate, earlyVendorName);
		createPurchasedStockVendorBill(valueObject, TimestampUtils.today(), inRangeVendorName);
		createPurchasedStockVendorBill(valueObject, lateDate, lateVendorName);

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(reportUU);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", beginDate, null, null, null),
				new ProcessInfoParameter("End Date", endDate, null, null, null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);
		assertThat("Report was generated", valueObject.getErrorMessage(), is(nullValue()));

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Transaction Date");
			int vendorColumnIndex = TableUtils.getColumnIndex(headerRow, "Supplier Name");

			List<Row> inRangeVendorRows = findVendorRows(sheet, vendorColumnIndex, inRangeVendorName);
			List<Row> earlyVendorRows = findVendorRows(sheet, vendorColumnIndex, earlyVendorName);
			List<Row> lateVendorRows = findVendorRows(sheet, vendorColumnIndex, lateVendorName);

			assertEquals(1, inRangeVendorRows.size(), "The in-range vendor bill appears on the report");
			assertTrue(earlyVendorRows.isEmpty(), "The vendor bill before the date range is excluded");
			assertTrue(lateVendorRows.isEmpty(), "The vendor bill after the date range is excluded");
		}
	}

	private void createPurchasedStockVendorBill(ChuBoePopulateVO valueObject, Timestamp date, String vendorName)
			throws SQLException {
		valueObject.setStepName("Create vendor " + vendorName);
		valueObject.setSalesStandardPrice(new BigDecimal(100));
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		valueObject.getBusinessPartner().setName(vendorName);
		valueObject.getBusinessPartner().saveEx();
		commitEx();

		valueObject.setStepName("Create product for " + vendorName);
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create purchase order for " + vendorName);
		valueObject.setDate(date);
		valueObject.setQuantity(new BigDecimal(2));
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create material receipt for " + vendorName);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialReceipt, null, false, false, false);
		ChuBoeCreateEntity.createInOutFromOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create vendor bill for " + vendorName);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_APInvoice, null, false, false, false);
		ChuBoeCreateEntity.createInvoice(valueObject);
		commitEx();
	}

	private List<Row> findVendorRows(Sheet sheet, int vendorColumnIndex, String vendorName) {
		return StreamSupport.stream(sheet.spliterator(), false).filter(
						row -> row.getCell(vendorColumnIndex) != null &&
								row.getCell(vendorColumnIndex).getCellType().equals(CellType.STRING) &&
								row.getCell(vendorColumnIndex).getStringCellValue().equals(vendorName))
				.collect(Collectors.toList());
	}
}
