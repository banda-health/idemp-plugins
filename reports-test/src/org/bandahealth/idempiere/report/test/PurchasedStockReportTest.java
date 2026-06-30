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
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfoParameter;
import org.hamcrest.Matchers;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.hamcrest.CoreMatchers.is;
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
}
