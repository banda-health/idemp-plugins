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
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.report.test.utils.PDFUtils;
import org.bandahealth.idempiere.report.test.utils.TableUtils;
import org.bandahealth.idempiere.report.test.utils.TimestampUtils;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.util.Env;
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

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PatientTransactionsTest extends ChuBoePopulateFactoryVO {
	private static final String patientTransactionReportUuid = "4cf22d3f-1fc8-4bdd-83e1-fc5d79537269";

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
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create payment");
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(patientTransactionReportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.startOfYesterday(), null, null, null),
				new ProcessInfoParameter("End Date", TimestampUtils.endOfTomorrow(), null, null, null)
		));
		ChuBoeCreateEntity.runReport(valueObject);

		MUser_BH currentUser =
				new Query(valueObject.getContext(), MUser_BH.Table_Name, MUser_BH.COLUMNNAME_AD_User_ID + "=?",
						valueObject.getTransactionName()).setParameters(Env.getAD_User_ID(valueObject.getContext())).first();

		String reportContent = PDFUtils.readPdfContent(valueObject.getReport(), true);
		assertThat("Patient's name is on the report", reportContent,
				containsString(valueObject.getBusinessPartner().getName().substring(0, 30)));
		assertThat("The cashier's name is on the report", reportContent, containsString(currentUser.getName()));
	}

	@IPopulateAnnotation.CanRun
	public void visitWithMultiplePaymentsOnlyShowsUpOnce() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create first product");
		valueObject.setSalesPrice(BigDecimal.TEN);
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();
		MProduct_BH firstProduct = valueObject.getProduct();

		valueObject.setStepName("Create purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create second product");
		valueObject.clearProduct();
		valueObject.setSalesPrice(new BigDecimal(5));
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();
		MProduct_BH secondProduct = valueObject.getProduct();

		valueObject.setStepName("Create purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setProduct(firstProduct);
		valueObject.setDocumentAction(DocAction.ACTION_Prepare);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Add second order line");
		valueObject.setProduct(secondProduct);
		MOrder_BH order = valueObject.getOrder();
		ChuBoeCreateEntity.createOrder(valueObject);
		valueObject.setOrder(order);
		valueObject.getOrderLine().setC_Order_ID(order.get_ID());
		valueObject.getOrderLine().saveEx();
		commitEx();

		valueObject.setStepName("Complete the order");
		order.setDocAction(DocAction.ACTION_Complete);
		assertTrue(order.processIt(DocAction.ACTION_Complete), "Order was completed");
		commitEx();

		valueObject.setStepName("Create first payment");
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		valueObject.setPaymentAmount(new BigDecimal(9));
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		valueObject.setStepName("Create second payment");
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_MPesa);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		valueObject.setPaymentAmount(new BigDecimal(6));
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(patientTransactionReportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.startOfYesterday(), null, null, null),
				new ProcessInfoParameter("End Date", TimestampUtils.endOfTomorrow(), null, null, null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Bill Date");
			int patientNameColumnIndex = TableUtils.getColumnIndex(headerRow, "Patient Name");

			List<Row> patientRows = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getCell(patientNameColumnIndex) != null && row.getCell(5).getCellType().equals(CellType.STRING) &&
							row.getCell(patientNameColumnIndex).getStringCellValue()
									.contains(valueObject.getBusinessPartner().getName().substring(0, 30))).collect(Collectors.toList());
			assertEquals(1, patientRows.size(), "Patient only appears once");
		}
	}

	@IPopulateAnnotation.CanRun
	public void visitWithMultipleChargesOnlyShowsUpOnce() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create product");
		valueObject.setSalesPrice(BigDecimal.TEN);
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setDocumentAction(DocAction.ACTION_Prepare);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create first charge");
		ChuBoeCreateEntity.createCharge(valueObject);
		valueObject.getCharge().setBH_SubType(MCharge_BH.BH_SUBTYPE_Waiver);
		valueObject.getCharge().saveEx();
		MOrderLine_BH orderLine = new MOrderLine_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		orderLine.setAD_Org_ID(valueObject.getOrg().get_ID());
		orderLine.setDescription(valueObject.getStepMessageLong());
		orderLine.setC_Order_ID(valueObject.getOrder().get_ID());
		orderLine.setC_Charge_ID(valueObject.getCharge().get_ID());
		orderLine.setQty(Env.ONE);
		orderLine.setHeaderInfo(valueObject.getOrder());
		orderLine.setPriceEntered(new BigDecimal(-4));
		orderLine.setPriceActual(new BigDecimal(-4));
		orderLine.saveEx();
		commitEx();

		valueObject.setStepName("Create second charge");
		valueObject.clearCharge();
		ChuBoeCreateEntity.createCharge(valueObject);
		valueObject.getCharge().setBH_SubType(MCharge_BH.BH_SUBTYPE_Donation);
		valueObject.getCharge().saveEx();
		orderLine = new MOrderLine_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		orderLine.setAD_Org_ID(valueObject.getOrg().get_ID());
		orderLine.setDescription(valueObject.getStepMessageLong());
		orderLine.setC_Order_ID(valueObject.getOrder().get_ID());
		orderLine.setC_Charge_ID(valueObject.getCharge().get_ID());
		orderLine.setQty(Env.ONE);
		orderLine.setHeaderInfo(valueObject.getOrder());
		orderLine.setPriceEntered(new BigDecimal(-6));
		orderLine.setPriceActual(new BigDecimal(-6));
		orderLine.saveEx();
		commitEx();

		valueObject.setStepName("Complete the sales order");
		valueObject.getOrder().setDocAction(DocAction.ACTION_Complete);
		assertTrue(valueObject.getOrder().processIt(DocAction.ACTION_Complete), "Order was completed");
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(patientTransactionReportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.startOfYesterday(), null, null, null),
				new ProcessInfoParameter("End Date", TimestampUtils.endOfTomorrow(), null, null, null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Bill Date");
			int patientNameColumnIndex = TableUtils.getColumnIndex(headerRow, "Patient Name");

			List<Row> patientRows = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getCell(patientNameColumnIndex) != null &&
							row.getCell(patientNameColumnIndex).getCellType().equals(CellType.STRING) &&
							row.getCell(patientNameColumnIndex).getStringCellValue()
									.contains(valueObject.getBusinessPartner().getName().substring(0, 30))).collect(Collectors.toList());

			assertEquals(1, patientRows.size(), "Patient only appears once");
		}
	}

	@IPopulateAnnotation.CanRun
	public void paymentFilterDoesntReduceTotalsShownOnVisit() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create first product");
		valueObject.setSalesPrice(BigDecimal.TEN);
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();
		MProduct_BH firstProduct = valueObject.getProduct();

		valueObject.setStepName("Create first purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(100));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create second product");
		valueObject.clearProduct();
		valueObject.setSalesPrice(new BigDecimal(5));
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();
		MProduct_BH secondProduct = valueObject.getProduct();

		valueObject.setStepName("Create second purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		valueObject.setQuantity(null);
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setProduct(firstProduct);
		valueObject.setDocumentAction(DocAction.ACTION_Prepare);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Add second order line");
		valueObject.setProduct(secondProduct);
		MOrder_BH order = valueObject.getOrder();
		ChuBoeCreateEntity.createOrder(valueObject);
		valueObject.setOrder(order);
		valueObject.getOrderLine().setC_Order_ID(order.get_ID());
		valueObject.getOrderLine().saveEx();
		commitEx();

		valueObject.setStepName("Complete the order");
		order.setDocAction(DocAction.ACTION_Complete);
		assertTrue(order.processIt(DocAction.ACTION_Complete), "Order was completed");
		commitEx();

		valueObject.setStepName("Create first payment");
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		valueObject.setPaymentAmount(new BigDecimal(9));
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		valueObject.setStepName("Create second payment");
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_MPesa);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		valueObject.setPaymentAmount(new BigDecimal(6));
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		valueObject.setStepName("Create second order");
		valueObject.setQuantity(BigDecimal.TEN);
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create second order's payment");
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		valueObject.setPaymentAmount(null);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report with Cash filter");
		valueObject.setProcessUuid(patientTransactionReportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.startOfYesterday(), null, null, null),
				new ProcessInfoParameter("End Date", TimestampUtils.endOfTomorrow(), null, null, null),
				new ProcessInfoParameter("Payment Mode", MPayment_BH.TENDERTYPE_Cash, null, null, null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Bill Date");
			int patientNameColumnIndex = TableUtils.getColumnIndex(headerRow, "Patient Name");
			int billTotalColumnIndex = TableUtils.getColumnIndex(headerRow, "Bill Total");
			int totalPaymentColumnIndex = TableUtils.getColumnIndex(headerRow, "Total Payment");
			int cashColumnIndex = TableUtils.getColumnIndex(headerRow, "Cash");
			int mobileMoneyColumnIndex = TableUtils.getColumnIndex(headerRow, "Mobile Money");

			List<Row> patientRows = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getCell(patientNameColumnIndex) != null &&
							row.getCell(patientNameColumnIndex).getCellType().equals(CellType.STRING) &&
							row.getCell(patientNameColumnIndex).getStringCellValue()
									.contains(valueObject.getBusinessPartner().getName().substring(0, 30))).collect(Collectors.toList());

			assertEquals(2, patientRows.size(), "Both of the patient's visits appear");
			Optional<Row> firstVisit =
					patientRows.stream().filter(row -> row.getCell(billTotalColumnIndex).getNumericCellValue() == 15D)
							.findFirst();
			assertTrue(firstVisit.isPresent(), "First visit is displayed");
			Optional<Row> secondVisit =
					patientRows.stream().filter(row -> row.getCell(billTotalColumnIndex).getNumericCellValue() == 50D)
							.findFirst();
			assertTrue(secondVisit.isPresent(), "Second visit is displayed");

			assertEquals(15D, firstVisit.get().getCell(totalPaymentColumnIndex).getNumericCellValue(),
					"First visit's total payment is correct");
			assertEquals(9D, firstVisit.get().getCell(cashColumnIndex).getNumericCellValue(),
					"First visit's cash payment is correct");
			assertEquals(6D, firstVisit.get().getCell(mobileMoneyColumnIndex).getNumericCellValue(),
					"First visit's mobile payment is correct");

			assertEquals(50D, secondVisit.get().getCell(totalPaymentColumnIndex).getNumericCellValue(),
					"First visit's total payment is correct");
			assertEquals(50D, secondVisit.get().getCell(cashColumnIndex).getNumericCellValue(),
					"First visit's cash payment is correct");
			assertEquals(0D, secondVisit.get().getCell(mobileMoneyColumnIndex).getNumericCellValue(),
					"First visit's mobile payment is correct");
		}

		valueObject.setStepName("Generate the report with Cash filter");
		ChuBoeCreateEntity.clearReport(valueObject);
		valueObject.setProcessUuid(patientTransactionReportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.startOfYesterday(), null, null, null),
				new ProcessInfoParameter("End Date", TimestampUtils.endOfTomorrow(), null, null, null),
				new ProcessInfoParameter("Payment Mode", MPayment_BH.TENDERTYPE_MPesa, null, null, null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Bill Date");
			int patientNameColumnIndex = TableUtils.getColumnIndex(headerRow, "Patient Name");
			int billTotalColumnIndex = TableUtils.getColumnIndex(headerRow, "Bill Total");
			int totalPaymentColumnIndex = TableUtils.getColumnIndex(headerRow, "Total Payment");
			int cashColumnIndex = TableUtils.getColumnIndex(headerRow, "Cash");
			int mobileMoneyColumnIndex = TableUtils.getColumnIndex(headerRow, "Mobile Money");

			List<Row> patientRows = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getCell(patientNameColumnIndex) != null &&
							row.getCell(patientNameColumnIndex).getCellType().equals(CellType.STRING) &&
							row.getCell(patientNameColumnIndex).getStringCellValue()
									.contains(valueObject.getBusinessPartner().getName().substring(0, 30))).collect(Collectors.toList());

			assertEquals(1, patientRows.size(), "Only one of the patient's visits appear");

			assertEquals(15D, patientRows.get(0).getCell(billTotalColumnIndex).getNumericCellValue(),
					"Bill total is correct");
			assertEquals(15D, patientRows.get(0).getCell(totalPaymentColumnIndex).getNumericCellValue(),
					"Visit's total payment is correct");
			assertEquals(9D, patientRows.get(0).getCell(cashColumnIndex).getNumericCellValue(),
					"Visit's cash payment is correct");
			assertEquals(6D, patientRows.get(0).getCell(mobileMoneyColumnIndex).getNumericCellValue(),
					"Visit's mobile payment is correct");
		}
	}

	@IPopulateAnnotation.CanRun
	public void visitsWithoutPaymentAppearOnTheReport() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create product");
		valueObject.setSalesPrice(BigDecimal.TEN);
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(patientTransactionReportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.startOfYesterday(), null, null, null),
				new ProcessInfoParameter("End Date", TimestampUtils.endOfTomorrow(), null, null, null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Bill Date");
			int patientNameColumnIndex = TableUtils.getColumnIndex(headerRow, "Patient Name");
			int billTotalColumnIndex = TableUtils.getColumnIndex(headerRow, "Bill Total");
			int totalPaymentColumnIndex = TableUtils.getColumnIndex(headerRow, "Total Payment");
			int cashColumnIndex = TableUtils.getColumnIndex(headerRow, "Cash");
			int mobileMoneyColumnIndex = TableUtils.getColumnIndex(headerRow, "Mobile Money");

			List<Row> patientRows = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getCell(patientNameColumnIndex) != null &&
							row.getCell(patientNameColumnIndex).getCellType().equals(CellType.STRING) &&
							row.getCell(patientNameColumnIndex).getStringCellValue()
									.contains(valueObject.getBusinessPartner().getName().substring(0, 30))).collect(Collectors.toList());

			assertEquals(1, patientRows.size(), "Patient's visit appears");
			Row visit = patientRows.get(0);
			assertEquals(10D, visit.getCell(billTotalColumnIndex).getNumericCellValue(), "Bill total is correct");
			assertEquals(0D, visit.getCell(totalPaymentColumnIndex).getNumericCellValue(), "Total payment is correct");
			assertEquals(0D, visit.getCell(cashColumnIndex).getNumericCellValue(), "Cash payment is correct");
			assertEquals(0D, visit.getCell(mobileMoneyColumnIndex).getNumericCellValue(), "Mobile payment is correct");
		}
	}

	@IPopulateAnnotation.CanRun
	public void recompletedVisitsShowTheCorrectValues() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create product");
		valueObject.setSalesPrice(BigDecimal.TEN);
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create PO");
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		ChuBoeCreateEntity.createOrder(valueObject);

		valueObject.setStepName("Create visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create SO");
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create partial payment");
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_MPesa);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		valueObject.setPaymentAmount(new BigDecimal(6));
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(patientTransactionReportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.startOfYesterday(), null, null, null),
				new ProcessInfoParameter("End Date", TimestampUtils.endOfTomorrow(), null, null, null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Bill Date");
			int patientNameColumnIndex = TableUtils.getColumnIndex(headerRow, "Patient Name");
			int billTotalColumnIndex = TableUtils.getColumnIndex(headerRow, "Bill Total");
			int totalPaymentColumnIndex = TableUtils.getColumnIndex(headerRow, "Total Payment");
			int cashColumnIndex = TableUtils.getColumnIndex(headerRow, "Cash");
			int mobileMoneyColumnIndex = TableUtils.getColumnIndex(headerRow, "Mobile Money");

			List<Row> patientRows = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getCell(patientNameColumnIndex) != null &&
							row.getCell(patientNameColumnIndex).getCellType().equals(CellType.STRING) &&
							row.getCell(patientNameColumnIndex).getStringCellValue()
									.contains(valueObject.getBusinessPartner().getName().substring(0, 30))).collect(Collectors.toList());

			assertEquals(1, patientRows.size(), "Patient's visit appears");
			Row visit = patientRows.get(0);
			assertEquals(10D, visit.getCell(billTotalColumnIndex).getNumericCellValue(), "Bill total is correct");
			assertEquals(6D, visit.getCell(totalPaymentColumnIndex).getNumericCellValue(), "Total payment is correct");
			assertEquals(0D, visit.getCell(cashColumnIndex).getNumericCellValue(), "Cash payment is correct");
			assertEquals(6D, visit.getCell(mobileMoneyColumnIndex).getNumericCellValue(), "Mobile payment is correct");

			int headerRowIndex = TableUtils.getIndexOfRow(sheet, headerRow);
			int totalsRowIndex = -1;
			double totalCharged = 0;
			for (int i = headerRowIndex + 1; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				Cell patientNameCell = row.getCell(patientNameColumnIndex);
				Cell totalPaymentCell = row.getCell(totalPaymentColumnIndex);
				if (patientNameCell != null && patientNameCell.getCellType().equals(CellType.STRING) &&
						patientNameCell.getStringCellValue().isEmpty() && totalPaymentCell != null &&
						totalPaymentCell.getCellType().equals(CellType.NUMERIC) && totalPaymentCell.getNumericCellValue() > 0) {
					totalsRowIndex = i;
					totalCharged = totalPaymentCell.getNumericCellValue();
					break;
				}
			}

			assertTrue(totalsRowIndex > -1, "Row totals displayed for transactions");
			assertTrue(totalCharged > 0, "Total charged is greater than zero");

			Row cashierPivotTableHeaderRow = TableUtils.getHeaderRow(sheet, "Cash", totalsRowIndex + 1);
			assertNotNull(cashierPivotTableHeaderRow, "Cashier income table exists");
			int cashierTotalsColumnIndex = TableUtils.getColumnIndex(cashierPivotTableHeaderRow, "Total");

			Row cashierPivotTableFooterRow =
					TableUtils.getHeaderRow(sheet, "Total", TableUtils.getIndexOfRow(sheet, cashierPivotTableHeaderRow) + 1);
			assertNotNull(cashierPivotTableFooterRow, "Cashier income table has a footer row");
			assertEquals(CellType.NUMERIC, cashierPivotTableFooterRow.getCell(cashierTotalsColumnIndex).getCellType(),
					"Cashiers' totals cell is numeric");
			assertEquals(totalCharged, cashierPivotTableFooterRow.getCell(cashierTotalsColumnIndex).getNumericCellValue(),
					"Cashier total matches total payment");
		}

		valueObject.setStepName("Re-open SO");
		List<MPayment_BH> ordersPayments = new Query(valueObject.getContext(), MPayment_BH.Table_Name,
				MPayment_BH.COLUMNNAME_BH_Visit_ID + "=? AND " + MPayment_BH.COLUMNNAME_DocStatus + "=? AND " +
						MPayment_BH.COLUMNNAME_Reversal_ID + " IS NULL", valueObject.getTransactionName()).setParameters(
				valueObject.getOrder().get_ID(), MPayment_BH.DOCSTATUS_Completed).list();
		valueObject.getOrder().setDocAction(MOrder_BH.DOCACTION_Re_Activate);
		assertTrue(valueObject.getOrder().processIt(MOrder_BH.DOCACTION_Re_Activate), "Sales order was re-activated");
		valueObject.getOrder().saveEx();
		commitEx();
		valueObject.setPayment(null);

		valueObject.setStepName("Cancel previous payments");
		for (MPayment_BH payment : ordersPayments) {
			MPayment_BH newPayment = payment.copy();
			newPayment.setDocStatus(MPayment_BH.DOCSTATUS_Drafted);
			newPayment.saveEx();

			payment.setDocAction(DocAction.ACTION_Reverse_Accrual);
			assertTrue(payment.processIt(DocAction.ACTION_Reverse_Accrual), "Old payment was reversed");
			payment.saveEx();
		}
		commitEx();
		valueObject.refresh();

		valueObject.setPayment(new Query(valueObject.getContext(), MPayment_BH.Table_Name,
				MPayment_BH.COLUMNNAME_BH_Visit_ID + "=? AND " + MPayment_BH.COLUMNNAME_DocStatus + "=?",
				valueObject.getTransactionName()).setParameters(valueObject.getOrder().get_ID(), MPayment_BH.DOCSTATUS_Drafted)
				.first());
		valueObject.refresh();

		valueObject.setStepName("Re-complete SO");
		valueObject.getOrder().setDocAction(MOrder_BH.DOCACTION_Complete);
		assertTrue(valueObject.getOrder().processIt(MOrder_BH.DOCACTION_Complete), "Sales order was re-completed");
		commitEx();

		valueObject.setStepName("Change payment");
		valueObject.getPayment().setTenderType(MPayment_BH.TENDERTYPE_Cash);
		valueObject.getPayment().setPayAmt(new BigDecimal(4));
		valueObject.getPayment().setBH_TenderAmount(new BigDecimal(4));
		valueObject.getPayment().saveEx();
		valueObject.getPayment().setDocAction(DocAction.ACTION_Complete);
		assertTrue(valueObject.getPayment().processIt(DocAction.ACTION_Complete), "Partial payment was re-completed");
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(patientTransactionReportUuid);
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
			Row headerRow = TableUtils.getHeaderRow(sheet, "Bill Date");
			int patientNameColumnIndex = TableUtils.getColumnIndex(headerRow, "Patient Name");
			int billTotalColumnIndex = TableUtils.getColumnIndex(headerRow, "Bill Total");
			int totalPaymentColumnIndex = TableUtils.getColumnIndex(headerRow, "Total Payment");
			int cashColumnIndex = TableUtils.getColumnIndex(headerRow, "Cash");
			int mobileMoneyColumnIndex = TableUtils.getColumnIndex(headerRow, "Mobile Money");

			List<Row> patientRows = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getCell(patientNameColumnIndex) != null &&
							row.getCell(patientNameColumnIndex).getCellType().equals(CellType.STRING) &&
							row.getCell(patientNameColumnIndex).getStringCellValue()
									.contains(valueObject.getBusinessPartner().getName().substring(0, 30))).collect(Collectors.toList());

			assertEquals(1, patientRows.size(), "Patient's visit appears");
			Row visit = patientRows.get(0);
			assertEquals(10D, visit.getCell(billTotalColumnIndex).getNumericCellValue(), "Bill total is correct");
			assertEquals(4D, visit.getCell(totalPaymentColumnIndex).getNumericCellValue(), "Total payment is correct");
			assertEquals(4D, visit.getCell(cashColumnIndex).getNumericCellValue(), "Cash payment is correct");
			assertEquals(0D, visit.getCell(mobileMoneyColumnIndex).getNumericCellValue(), "Mobile payment is correct");

			int headerRowIndex = TableUtils.getIndexOfRow(sheet, headerRow);
			int totalsRowIndex = -1;
			double totalCharged = 0;
			for (int i = headerRowIndex + 1; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				Cell patientNameCell = row.getCell(patientNameColumnIndex);
				Cell totalPaymentCell = row.getCell(totalPaymentColumnIndex);
				if (patientNameCell != null && patientNameCell.getCellType().equals(CellType.STRING) &&
						patientNameCell.getStringCellValue().isEmpty() && totalPaymentCell != null &&
						totalPaymentCell.getCellType().equals(CellType.NUMERIC) && totalPaymentCell.getNumericCellValue() > 0) {
					totalsRowIndex = i;
					totalCharged = totalPaymentCell.getNumericCellValue();
					break;
				}
			}

			assertTrue(totalsRowIndex > -1, "Row totals displayed for transactions");
			assertTrue(totalCharged > 0, "Total charged is greater than zero");

			Row cashierPivotTableHeaderRow = TableUtils.getHeaderRow(sheet, "Cash", totalsRowIndex + 1);
			assertNotNull(cashierPivotTableHeaderRow, "Cashier income table exists");
			int cashierTotalsColumnIndex = TableUtils.getColumnIndex(cashierPivotTableHeaderRow, "Total");

			Row cashierPivotTableFooterRow =
					TableUtils.getHeaderRow(sheet, "Total", TableUtils.getIndexOfRow(sheet, cashierPivotTableHeaderRow) + 1);
			assertNotNull(cashierPivotTableFooterRow, "Cashier income table has a footer row");
			assertEquals(CellType.NUMERIC, cashierPivotTableFooterRow.getCell(cashierTotalsColumnIndex).getCellType(),
					"Cashiers' totals cell is numeric");
			assertEquals(totalCharged, cashierPivotTableFooterRow.getCell(cashierTotalsColumnIndex).getNumericCellValue(),
					"Cashier total matches total payment");
		}
	}

	@IPopulateAnnotation.CanRun
	public void openBalancePaymentsShowCorrectly() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create product");
		valueObject.setSalesPrice(BigDecimal.TEN);
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create PO");
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		ChuBoeCreateEntity.createOrder(valueObject);

		valueObject.setStepName("Create visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create SO");
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create open-balance payment");
		valueObject.setVisit(null);
		valueObject.setOrder(null);
		valueObject.setInvoice(null);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		valueObject.setPaymentAmount(new BigDecimal(4));
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(patientTransactionReportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.startOfYesterday(), null, null, null),
				new ProcessInfoParameter("End Date", TimestampUtils.endOfTomorrow(), null, null, null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Bill Date");
			int patientNameColumnIndex = TableUtils.getColumnIndex(headerRow, "Patient Name");
			int billTotalColumnIndex = TableUtils.getColumnIndex(headerRow, "Bill Total");
			int totalPaymentColumnIndex = TableUtils.getColumnIndex(headerRow, "Total Payment");
			int cashColumnIndex = TableUtils.getColumnIndex(headerRow, "Cash");
			int mobileMoneyColumnIndex = TableUtils.getColumnIndex(headerRow, "Mobile Money");

			List<Row> patientRows = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getCell(patientNameColumnIndex) != null &&
							row.getCell(patientNameColumnIndex).getCellType().equals(CellType.STRING) &&
							row.getCell(patientNameColumnIndex).getStringCellValue()
									.contains(valueObject.getBusinessPartner().getName().substring(0, 30))).collect(Collectors.toList());

			assertEquals(1, patientRows.size(), "Patient's visit appears");
			Row visit = patientRows.get(0);
			assertEquals(10D, visit.getCell(billTotalColumnIndex).getNumericCellValue(), "Bill total is correct");
			assertEquals(0D, visit.getCell(totalPaymentColumnIndex).getNumericCellValue(), "Total payment is correct");
			assertEquals(0D, visit.getCell(cashColumnIndex).getNumericCellValue(), "Cash payment is correct");
			assertEquals(0D, visit.getCell(mobileMoneyColumnIndex).getNumericCellValue(), "Mobile payment is correct");

			int headerRowIndex = TableUtils.getIndexOfRow(sheet, headerRow);
			int totalsRowIndex = -1;
			double totalCharged = 0;
			for (int i = headerRowIndex + 1; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				Cell patientNameCell = row.getCell(patientNameColumnIndex);
				Cell totalPaymentCell = row.getCell(totalPaymentColumnIndex);
				if (patientNameCell != null && patientNameCell.getCellType().equals(CellType.STRING) &&
						patientNameCell.getStringCellValue().isEmpty() && totalPaymentCell != null &&
						totalPaymentCell.getCellType().equals(CellType.NUMERIC) && totalPaymentCell.getNumericCellValue() > 0) {
					totalsRowIndex = i;
					totalCharged = totalPaymentCell.getNumericCellValue();
					break;
				}
			}

			assertTrue(totalsRowIndex > -1, "Row totals displayed for transactions");
			assertTrue(totalCharged > 0, "Total charged is greater than zero");

			Row cashierPivotTableHeaderRow = TableUtils.getHeaderRow(sheet, "Cash", totalsRowIndex + 1);
			assertNotNull(cashierPivotTableHeaderRow, "Cashier income table exists");
			int cashierTotalsColumnIndex = TableUtils.getColumnIndex(cashierPivotTableHeaderRow, "Total");

			Row cashierPivotTableFooterRow =
					TableUtils.getHeaderRow(sheet, "Total", TableUtils.getIndexOfRow(sheet, cashierPivotTableHeaderRow) + 1);
			assertNotNull(cashierPivotTableFooterRow, "Cashier income table has a footer row");
			assertEquals(CellType.NUMERIC, cashierPivotTableFooterRow.getCell(cashierTotalsColumnIndex).getCellType(),
					"Cashiers' totals cell is numeric");
			assertEquals(totalCharged, cashierPivotTableFooterRow.getCell(cashierTotalsColumnIndex).getNumericCellValue(),
					"Cashier total matches total payment");

			Row outstandingBalanceHeaderRow =
					TableUtils.getHeaderRow(sheet, "Date Paid", TableUtils.getIndexOfRow(sheet, cashierPivotTableFooterRow));
			assertNotNull(outstandingBalanceHeaderRow, "Outstanding balance table header row exists");
			int openBalancePatientNameColumnIndex = TableUtils.getColumnIndex(outstandingBalanceHeaderRow, "Patient Name");
			int paymentModeColumnIndex = TableUtils.getColumnIndex(outstandingBalanceHeaderRow, "Payment Mode");
			int amountPaidColumnIndex = TableUtils.getColumnIndex(outstandingBalanceHeaderRow, "Amount Paid");
			int openBalanceColumnIndex = TableUtils.getColumnIndex(outstandingBalanceHeaderRow, "Open Balance");

			patientRows = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getCell(openBalancePatientNameColumnIndex) != null &&
							row.getCell(openBalancePatientNameColumnIndex).getCellType().equals(CellType.STRING) &&
							row.getCell(openBalancePatientNameColumnIndex).getStringCellValue()
									.contains(valueObject.getBusinessPartner().getName().substring(0, 30))).collect(Collectors.toList());

			assertEquals(1, patientRows.size(), "Patient's visit appears");
			Row openBalanceForPatient = patientRows.get(0);
			assertEquals("Cash", openBalanceForPatient.getCell(paymentModeColumnIndex).getStringCellValue(),
					"Payment mode is correct");
			assertEquals(4D, openBalanceForPatient.getCell(amountPaidColumnIndex).getNumericCellValue(),
					"Amount paid is correct");
			assertEquals(6D, openBalanceForPatient.getCell(openBalanceColumnIndex).getNumericCellValue(),
					"Open balance is correct");
		}
	}

	@IPopulateAnnotation.CanRun
	public void openBalancePaymentsNotDuplicated() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create product");
		valueObject.setSalesPrice(BigDecimal.TEN);
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create PO");
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(10));
		ChuBoeCreateEntity.createOrder(valueObject);
		valueObject.setQuantity(null);
		commitEx();

		valueObject.setStepName("Create first visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create first SO");
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create second visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create second SO");
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create third visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create third SO");
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create open-balance payment");
		valueObject.setVisit(null);
		valueObject.setOrder(null);
		valueObject.setInvoice(null);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		valueObject.setPaymentAmount(new BigDecimal(30));
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(patientTransactionReportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.startOfYesterday(), null, null, null),
				new ProcessInfoParameter("End Date", TimestampUtils.endOfTomorrow(), null, null, null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row outstandingBalanceHeaderRow = TableUtils.getHeaderRow(sheet, "Date Paid");
			assertNotNull(outstandingBalanceHeaderRow, "Outstanding balance table header row exists");
			int openBalancePatientNameColumnIndex = TableUtils.getColumnIndex(outstandingBalanceHeaderRow, "Patient Name");

			List<Row> patientRows = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getCell(openBalancePatientNameColumnIndex) != null &&
							row.getCell(openBalancePatientNameColumnIndex).getCellType().equals(CellType.STRING) &&
							row.getCell(openBalancePatientNameColumnIndex).getStringCellValue()
									.contains(valueObject.getBusinessPartner().getName().substring(0, 30))).collect(Collectors.toList());

			assertEquals(1, patientRows.size(), "Patient's payments aren't duplicated");
		}
	}
}
