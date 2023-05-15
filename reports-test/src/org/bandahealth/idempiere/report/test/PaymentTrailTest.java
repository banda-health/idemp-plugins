package org.bandahealth.idempiere.report.test;

import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.base.model.MChargeType_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.report.test.utils.TableUtils;
import org.bandahealth.idempiere.report.test.utils.TimestampUtils;
import org.compiere.model.MAllocationHdr;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.hamcrest.Matchers;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PaymentTrailTest extends ChuBoePopulateFactoryVO {
	private final String reportUuid = "a7ac9f65-45d7-4ae0-80f3-72019de35a4a";

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
	public void canRunReport() throws SQLException, IOException, ParseException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		BigDecimal visitCharge = new BigDecimal(100);
		BigDecimal visitPayment = new BigDecimal(50);
		BigDecimal debtPayment = new BigDecimal(20);

		valueObject.setStepName("Create business partner");
		valueObject.setSalesStandardPrice(visitCharge);
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create visit for a previous day");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create purchase order for a previous day");
		valueObject.setDate(TimestampUtils.today());
		valueObject.setDateOffset(-1);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create payment");
		MInvoice_BH invoice =
				new Query(valueObject.getContext(), MInvoice_BH.Table_Name, MInvoice_BH.COLUMNNAME_C_Order_ID + "=?",
						valueObject.getTransactionName()).setParameters(valueObject.getOrder().get_ID()).first();
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setInvoice(invoice);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		valueObject.setPaymentAmount(visitPayment);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		valueObject.setStepName("Create debt payment");
		valueObject.setVisit(null);
		valueObject.setOrder(null);
		valueObject.setInvoice(null);
		valueObject.setDateOffset(1);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		valueObject.setPaymentAmount(debtPayment);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(reportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Collections.singletonList(
				new ProcessInfoParameter("c_bpartner_uu", valueObject.getBusinessPartner().getC_BPartner_UU(), null, null,
						null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Name");
			assertNotNull(headerRow, "Header row exists");

			int patientNameColumnIndex = TableUtils.getColumnIndex(headerRow, "Name");
			int itemColumnIndex = TableUtils.getColumnIndex(headerRow, "Item");
			int chargesColumnIndex = TableUtils.getColumnIndex(headerRow, "Charges");
			int paymentsColumnIndex = TableUtils.getColumnIndex(headerRow, "Payments");
			int openBalanceColumnIndex = TableUtils.getColumnIndex(headerRow, "Open Balance");

			List<Row> tableRows = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getCell(patientNameColumnIndex).getStringCellValue()
							.contains(valueObject.getBusinessPartner().getName().substring(0, 25))).collect(Collectors.toList());

			assertThat("Only three rows exist for patient on report", tableRows.size(), is(3));

			assertThat("Starting balance appears", tableRows.get(0).getCell(itemColumnIndex).getStringCellValue(),
					containsStringIgnoringCase("Starting Balance"));
			assertThat("Starting balance is zero", tableRows.get(0).getCell(openBalanceColumnIndex).getNumericCellValue(),
					is(0D));

			assertThat("Visit payment information appears", tableRows.get(1).getCell(itemColumnIndex).getStringCellValue(),
					containsStringIgnoringCase("Visit charges and payments"));
			assertThat("Visit charge is correct", tableRows.get(1).getCell(chargesColumnIndex).getNumericCellValue(),
					is(visitCharge.doubleValue()));
			assertThat("Visit payment is correct", tableRows.get(1).getCell(paymentsColumnIndex).getNumericCellValue(),
					is(visitPayment.doubleValue()));
			assertThat("Visit difference is correct", tableRows.get(1).getCell(openBalanceColumnIndex).getNumericCellValue(),
					is(visitCharge.doubleValue() - visitPayment.doubleValue()));


			assertThat("Debt payment information appears", tableRows.get(2).getCell(itemColumnIndex).getStringCellValue(),
					containsStringIgnoringCase("Outstanding Balance Payment"));
			assertThat("Debt charge is correct", tableRows.get(2).getCell(chargesColumnIndex).getNumericCellValue(),
					is(0D));
			assertThat("Debt payment is correct", tableRows.get(2).getCell(paymentsColumnIndex).getNumericCellValue(),
					is(debtPayment.doubleValue()));
			BigDecimal totalOpenBalance = visitCharge.subtract(visitPayment).subtract(debtPayment);
			assertThat("Open balance is correct", tableRows.get(2).getCell(openBalanceColumnIndex).getNumericCellValue(),
					is(totalOpenBalance.doubleValue()));

			valueObject.refresh();
			assertEquals(valueObject.getBusinessPartner().getTotalOpenBalance().longValue(), totalOpenBalance.longValue(),
					"Total open balance matches what's on the business partner");
		}
	}

	@IPopulateAnnotation.CanRun
	public void paymentsOnDifferentDaysForOneReopenedVisitShowUpCorrectly()
			throws SQLException, IOException, ParseException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		BigDecimal visitCharge = new BigDecimal(5000);
		BigDecimal visitCashPayment = new BigDecimal(1000);
		BigDecimal visitMobilePayment = new BigDecimal(1000);
		BigDecimal visitWaiver = new BigDecimal(1000);
		BigDecimal debtPayment = new BigDecimal(1000);

		valueObject.setStepName("Create business partner");
		valueObject.setSalesStandardPrice(visitCharge);
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create charge");
		ChuBoeCreateEntity.createCharge(valueObject);
		commitEx();

		valueObject.setStepName("Create purchase order for a previous day");
		valueObject.setDate(TimestampUtils.today());
		valueObject.setDateOffset(-1);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();
		DB.executeUpdate("UPDATE " + MBHVisit.Table_Name + " SET " + MBHVisit.COLUMNNAME_Created + " = " +
				DB.TO_DATE(valueObject.getDate()) + " WHERE " + MBHVisit.COLUMNNAME_BH_Visit_ID + "=" +
				valueObject.getVisit().get_ID(), valueObject.getTransactionName());

		valueObject.setStepName("Create sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Prepare);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		MOrder_BH order = valueObject.getOrder();
		valueObject.getOrder().saveEx();
		DB.executeUpdate("UPDATE " + MOrder_BH.Table_Name + " SET " + MOrder_BH.COLUMNNAME_Created + " = " +
				DB.TO_DATE(valueObject.getDate()) + " WHERE " + MOrder_BH.COLUMNNAME_C_Order_ID + "=" +
				valueObject.getOrder().get_ID(), valueObject.getTransactionName());

		MOrderLine_BH orderLine = new MOrderLine_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		orderLine.setAD_Org_ID(valueObject.getOrg().get_ID());
		orderLine.setDescription(valueObject.getStepMessageLong());
		orderLine.setC_Order_ID(order.get_ID());
		orderLine.setC_Charge_ID(valueObject.getCharge().get_ID());
		orderLine.setC_UOM_ID(valueObject.getProduct().getC_UOM_ID());
		orderLine.setQty(Env.ONE);
		orderLine.setHeaderInfo(order);
		orderLine.setPrice(visitWaiver.negate());
		orderLine.saveEx();

		valueObject.getOrder().setDocAction(DocAction.ACTION_Complete);
		assertTrue(valueObject.getOrder().processIt(DocAction.ACTION_Complete), "Order completed");
		valueObject.getOrder().saveEx();
		commitEx();

		valueObject.setStepName("Create cash payment");
		MInvoice_BH invoice =
				new Query(valueObject.getContext(), MInvoice_BH.Table_Name, MInvoice_BH.COLUMNNAME_C_Order_ID + "=?",
						valueObject.getTransactionName()).setParameters(valueObject.getOrder().get_ID()).first();
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setInvoice(invoice);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		valueObject.setPaymentAmount(visitCashPayment);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		DB.executeUpdate("UPDATE " + MPayment_BH.Table_Name + " SET " + MPayment_BH.COLUMNNAME_Created + " = " +
				DB.TO_DATE(valueObject.getDate()) + " WHERE " + MPayment_BH.COLUMNNAME_C_Payment_ID + "=" +
				valueObject.getPayment().get_ID(), valueObject.getTransactionName());

		valueObject.setStepName("Re-open order");
		List<MPayment_BH> ordersPayments = new Query(valueObject.getContext(), MPayment_BH.Table_Name,
				MPayment_BH.COLUMNNAME_BH_Visit_ID + "=? AND " + MPayment_BH.COLUMNNAME_DocStatus + "=? AND " +
						MPayment_BH.COLUMNNAME_Reversal_ID + " IS NULL", valueObject.getTransactionName()).setParameters(
				valueObject.getVisit().get_ID(), MPayment_BH.DOCSTATUS_Completed).list();
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
				valueObject.getTransactionName()).setParameters(valueObject.getVisit().get_ID(), MPayment_BH.DOCSTATUS_Drafted)
				.first());
		valueObject.refresh();

		valueObject.setStepName("Re-complete order");
		valueObject.getOrder().setDocAction(DocAction.ACTION_Complete);
		assertTrue(valueObject.getOrder().processIt(DocAction.ACTION_Complete), "Order re-completed");
		valueObject.getOrder().saveEx();
		commitEx();

		valueObject.setStepName("Complete payment that was auto-created after re-opening a visit");
		List<MPayment_BH> recreatedPayments = new Query(valueObject.getContext(), MPayment_BH.Table_Name,
				MPayment_BH.COLUMNNAME_BH_Visit_ID + "=? AND " + MPayment_BH.COLUMNNAME_DocStatus + "=?",
				valueObject.getTransactionName()).setParameters(valueObject.getVisit().get_ID(), MPayment_BH.DOCSTATUS_Drafted)
				.list();
		assertEquals(1, recreatedPayments.size(), "Assigned payment was re-created when visit re-opened");
		recreatedPayments.get(0).setDocAction(MPayment_BH.DOCACTION_Complete);
		recreatedPayments.get(0).processIt(MPayment_BH.DOCACTION_Complete);
		recreatedPayments.get(0).saveEx();
		commitEx();

		valueObject.setStepName("Create mobile payment for today");
		valueObject.setDateOffset(1);
		valueObject.setInvoice(invoice);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_MPesa);
		valueObject.setPaymentAmount(visitMobilePayment);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		valueObject.setStepName("Create debt payment for today");
		valueObject.setVisit(null);
		valueObject.setOrder(null);
		valueObject.setInvoice(null);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		valueObject.setPaymentAmount(debtPayment);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(reportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Collections.singletonList(
				new ProcessInfoParameter("c_bpartner_uu", valueObject.getBusinessPartner().getC_BPartner_UU(), null, null,
						null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Name");
			assertNotNull(headerRow, "Header row exists");

			int patientNameColumnIndex = TableUtils.getColumnIndex(headerRow, "Name");
			int dateColumnIndex = TableUtils.getColumnIndex(headerRow, "Date");
			int itemColumnIndex = TableUtils.getColumnIndex(headerRow, "Item");
			int chargesColumnIndex = TableUtils.getColumnIndex(headerRow, "Charges");
			int paymentsColumnIndex = TableUtils.getColumnIndex(headerRow, "Payments");
			int openBalanceColumnIndex = TableUtils.getColumnIndex(headerRow, "Open Balance");

			List<Row> tableRows = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getCell(patientNameColumnIndex).getStringCellValue()
							.contains(valueObject.getBusinessPartner().getName().substring(0, 25))).collect(Collectors.toList());

			assertThat("Only three rows exist for patient on report", tableRows.size(), is(3));

			Row row = tableRows.get(0);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			assertThat("Starting balance date correct", dateFormat.format(row.getCell(dateColumnIndex).getDateCellValue()),
					containsStringIgnoringCase(dateFormat.format(TimestampUtils.yesterday())));
			assertThat("Starting balance appears", row.getCell(itemColumnIndex).getStringCellValue(),
					containsStringIgnoringCase("Starting Balance"));
			assertThat("Starting balance is zero", row.getCell(openBalanceColumnIndex).getNumericCellValue(), is(0D));

			row = tableRows.get(1);
			assertThat("Visit payment information appears", row.getCell(itemColumnIndex).getStringCellValue(),
					containsStringIgnoringCase("Visit charges and payments"));
			assertThat("Visit charge is correct", row.getCell(chargesColumnIndex).getNumericCellValue(),
					is(visitCharge.doubleValue()));
			assertThat("Visit payment is correct", row.getCell(paymentsColumnIndex).getNumericCellValue(),
					is(visitMobilePayment.doubleValue() + visitCashPayment.doubleValue() + visitWaiver.doubleValue()));
			BigDecimal totalOpenBalance =
					visitCharge.subtract(visitMobilePayment).subtract(visitCashPayment).subtract(visitWaiver);
			assertThat("Open balance is correct", row.getCell(openBalanceColumnIndex).getNumericCellValue(),
					is(totalOpenBalance.doubleValue()));

			row = tableRows.get(2);
			assertThat("Open balance information appears", row.getCell(itemColumnIndex).getStringCellValue(),
					containsStringIgnoringCase("Outstanding Balance Payment"));
			assertThat("Visit charge is correct", row.getCell(chargesColumnIndex).getNumericCellValue(), is(0D));
			assertThat("Debt payment is correct", row.getCell(paymentsColumnIndex).getNumericCellValue(),
					is(debtPayment.doubleValue()));
			totalOpenBalance = totalOpenBalance.subtract(debtPayment);
			assertThat("Open balance is correct", row.getCell(openBalanceColumnIndex).getNumericCellValue(),
					is(totalOpenBalance.doubleValue()));

			valueObject.refresh();
			assertEquals(valueObject.getBusinessPartner().getTotalOpenBalance().longValue(), totalOpenBalance.longValue(),
					"Total open balance matches what's on the business partner");
		}
	}

	@IPopulateAnnotation.CanRun
	public void reportDisplaysDataWhenNoPaymentsMade() throws SQLException, IOException, ParseException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		BigDecimal visitCharge = new BigDecimal(1200);

		valueObject.setStepName("Create business partner");
		valueObject.setSalesStandardPrice(visitCharge);
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

		valueObject.setStepName("Create visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(reportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Collections.singletonList(
				new ProcessInfoParameter("c_bpartner_uu", valueObject.getBusinessPartner().getC_BPartner_UU(), null, null,
						null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Name");
			assertNotNull(headerRow, "Header row exists");

			int patientNameColumnIndex = TableUtils.getColumnIndex(headerRow, "Name");
			int itemColumnIndex = TableUtils.getColumnIndex(headerRow, "Item");
			int chargesColumnIndex = TableUtils.getColumnIndex(headerRow, "Charges");
			int paymentsColumnIndex = TableUtils.getColumnIndex(headerRow, "Payments");
			int openBalanceColumnIndex = TableUtils.getColumnIndex(headerRow, "Open Balance");

			List<Row> tableRows = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getCell(patientNameColumnIndex).getStringCellValue()
							.contains(valueObject.getBusinessPartner().getName().substring(0, 25))).collect(Collectors.toList());

			assertThat("Only two rows exist for patient on report", tableRows.size(), is(2));

			Row row = tableRows.get(0);
			assertThat("Starting balance appears", row.getCell(itemColumnIndex).getStringCellValue(),
					containsStringIgnoringCase("Starting Balance"));
			assertThat("Starting balance is zero", row.getCell(openBalanceColumnIndex).getNumericCellValue(), is(0D));

			row = tableRows.get(1);
			assertThat("Visit payment information appears", row.getCell(itemColumnIndex).getStringCellValue(),
					containsStringIgnoringCase("Visit"));
			assertThat("Visit charge is correct", row.getCell(chargesColumnIndex).getNumericCellValue(),
					is(visitCharge.doubleValue()));
			assertThat("Visit payment is correct", row.getCell(paymentsColumnIndex).getNumericCellValue(), is(0D));
			assertThat("Open balance is correct", row.getCell(openBalanceColumnIndex).getNumericCellValue(),
					is(visitCharge.doubleValue()));

			valueObject.refresh();
			assertEquals(valueObject.getBusinessPartner().getTotalOpenBalance().longValue(), visitCharge.longValue(),
					"Total open balance matches what's on the business partner");
		}
	}

	@IPopulateAnnotation.CanRun
	public void extraDebtPaymentShowsUp() throws SQLException, IOException, ParseException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		BigDecimal visitCharge = new BigDecimal(1200);

		valueObject.setStepName("Create business partner");
		valueObject.setSalesStandardPrice(visitCharge);
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

		valueObject.setStepName("Create visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create debt payment");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Prepare);
		valueObject.setPaymentAmount(visitCharge);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		ChuBoeCreateEntity.createPayment(valueObject);
		valueObject.getPayment().setBH_Visit_ID(0);
		valueObject.getPayment().setDocAction(DocumentEngine.ACTION_Complete);
		assertTrue(valueObject.getPayment().processIt(DocumentEngine.ACTION_Complete));
		valueObject.getPayment().saveEx();
		commitEx();

		valueObject.setStepName("Re-open order");
		valueObject.getOrder().setDocAction(MOrder_BH.DOCACTION_Re_Activate);
		assertTrue(valueObject.getOrder().processIt(MOrder_BH.DOCACTION_Re_Activate));
		valueObject.getOrder().saveEx();
		commitEx();

		valueObject.refresh();
		assertTrue(valueObject.getPayment().getDocStatus().equalsIgnoreCase(MPayment_BH.DOCSTATUS_Completed));

		valueObject.setStepName("Re-complete order");
		valueObject.getOrder().setDocAction(DocumentEngine.ACTION_Complete);
		assertTrue(valueObject.getOrder().processIt(DocumentEngine.ACTION_Complete));
		valueObject.getOrder().saveEx();
		commitEx();

		valueObject.setStepName("Create visit payment");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(reportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Collections.singletonList(
				new ProcessInfoParameter("c_bpartner_uu", valueObject.getBusinessPartner().getC_BPartner_UU(), null, null,
						null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Name");
			assertNotNull(headerRow, "Header row exists");

			int patientNameColumnIndex = TableUtils.getColumnIndex(headerRow, "Name");
			int chargesColumnIndex = TableUtils.getColumnIndex(headerRow, "Charges");
			int paymentsColumnIndex = TableUtils.getColumnIndex(headerRow, "Payments");
			int openBalanceColumnIndex = TableUtils.getColumnIndex(headerRow, "Open Balance");

			List<Row> tableRows = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getCell(patientNameColumnIndex).getStringCellValue()
							.contains(valueObject.getBusinessPartner().getName().substring(0, 25))).collect(Collectors.toList());

			assertThat("Only three rows exist for patient on report", tableRows.size(), is(3));

			Row row = tableRows.get(1);
			assertThat("Visit charge is correct", row.getCell(chargesColumnIndex).getNumericCellValue(),
					is(visitCharge.doubleValue()));
			assertThat("Visit payment is correct", row.getCell(paymentsColumnIndex).getNumericCellValue(),
					is(visitCharge.doubleValue()));

			row = tableRows.get(2);
			assertThat("Debt payment is correct", row.getCell(paymentsColumnIndex).getNumericCellValue(),
					is(visitCharge.doubleValue()));
			assertThat("Open balance is correct", row.getCell(openBalanceColumnIndex).getNumericCellValue(),
					is(visitCharge.negate().doubleValue()));

			valueObject.refresh();
			assertEquals(valueObject.getBusinessPartner().getTotalOpenBalance().longValue(),
					visitCharge.negate().longValue(),
					"Total open balance matches what's on the business partner");
		}
	}

	@IPopulateAnnotation.CanRun
	public void doublePaymentsDontAppearWhenMultipleAllocations() throws SQLException, IOException, ParseException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		BigDecimal visitCharge = new BigDecimal(1200);

		valueObject.setStepName("Create business partner");
		valueObject.setSalesStandardPrice(visitCharge);
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

		valueObject.setStepName("Create visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create partial visit payment");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setPaymentAmount(BigDecimal.valueOf(visitCharge.doubleValue() / 2));
		valueObject.setInvoice(new MInvoice_BH(valueObject.getContext(), valueObject.getOrder().getInvoices()[0].get_ID(),
				valueObject.getTransactionName()));
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		valueObject.setStepName("Re-do the allocations");
		MPayment_BH visitPayment = valueObject.getPayment();
		MAllocationHdr[] visitPaymentAllocations =
				MAllocationHdr.getOfPayment(valueObject.getContext(), visitPayment.get_ID(),
						valueObject.getTransactionName());
		assertEquals(1, visitPaymentAllocations.length, "Only one allocation made for visit payment");
		visitPaymentAllocations[0].setDocAction(MAllocationHdr.DOCACTION_Reverse_Accrual);
		assertTrue(visitPaymentAllocations[0].processIt(MAllocationHdr.DOCACTION_Reverse_Accrual),
				"Allocation was reversed");
		commitEx();

		visitPayment = new MPayment_BH(valueObject.getContext(), visitPayment.get_ID(), valueObject.getTransactionName());
		assertTrue(!visitPayment.isAllocated(), "Payment is no longer allocated");
		assertTrue(visitPayment.allocateIt(), "Payment was allocated");
		commitEx();

		visitPaymentAllocations =
				MAllocationHdr.getOfPayment(valueObject.getContext(), visitPayment.get_ID(), valueObject.getTransactionName());
		assertEquals(3, visitPaymentAllocations.length, "Three allocations exist");

		valueObject.setStepName("Create debt payment");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Prepare);
		valueObject.setPaymentAmount(BigDecimal.valueOf(visitCharge.doubleValue() / 2));
		valueObject.setInvoice(null);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		ChuBoeCreateEntity.createPayment(valueObject);
		valueObject.getPayment().setBH_Visit_ID(0);
		valueObject.getPayment().setDocAction(MPayment_BH.DOCACTION_Complete);
		assertTrue(valueObject.getPayment().processIt(MPayment_BH.DOCACTION_Complete), "Debt payment is completed");
		valueObject.getPayment().saveEx();
		commitEx();

		valueObject.setStepName("Re-do the allocations");
		MPayment_BH debtPayment = valueObject.getPayment();
		MAllocationHdr[] debtPaymentAllocations =
				MAllocationHdr.getOfPayment(valueObject.getContext(), debtPayment.get_ID(),
						valueObject.getTransactionName());
		assertEquals(1, debtPaymentAllocations.length, "Only one allocation made for visit payment");
		debtPaymentAllocations[0].setDocAction(MAllocationHdr.DOCACTION_Reverse_Accrual);
		assertTrue(debtPaymentAllocations[0].processIt(MAllocationHdr.DOCACTION_Reverse_Accrual),
				"Allocation was reversed");
		commitEx();

		debtPayment = new MPayment_BH(valueObject.getContext(), debtPayment.get_ID(), valueObject.getTransactionName());
		assertTrue(!debtPayment.isAllocated(), "Payment is no longer allocated");
		assertTrue(debtPayment.allocateIt(), "Payment was allocated");
		commitEx();

		debtPaymentAllocations =
				MAllocationHdr.getOfPayment(valueObject.getContext(), debtPayment.get_ID(), valueObject.getTransactionName());
		assertEquals(3, debtPaymentAllocations.length, "Three allocations exist");

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(reportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Collections.singletonList(
				new ProcessInfoParameter("c_bpartner_uu", valueObject.getBusinessPartner().getC_BPartner_UU(), null, null,
						null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Name");
			assertNotNull(headerRow, "Header row exists");

			int patientNameColumnIndex = TableUtils.getColumnIndex(headerRow, "Name");
			int chargesColumnIndex = TableUtils.getColumnIndex(headerRow, "Charges");
			int paymentsColumnIndex = TableUtils.getColumnIndex(headerRow, "Payments");
			int openBalanceColumnIndex = TableUtils.getColumnIndex(headerRow, "Open Balance");

			List<Row> tableRows = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getCell(patientNameColumnIndex).getStringCellValue()
							.contains(valueObject.getBusinessPartner().getName().substring(0, 25))).collect(Collectors.toList());

			assertThat("Only three rows exist for patient on report", tableRows.size(), is(3));

			Row row = tableRows.get(1);
			assertThat("Visit charge is correct", row.getCell(chargesColumnIndex).getNumericCellValue(),
					is(visitCharge.doubleValue()));
			assertThat("Visit payment is correct", row.getCell(paymentsColumnIndex).getNumericCellValue(),
					is(visitCharge.doubleValue() / 2));

			row = tableRows.get(2);
			assertThat("Debt payment is correct", row.getCell(paymentsColumnIndex).getNumericCellValue(),
					is(visitCharge.doubleValue() / 2));
			assertThat("Open balance is correct", row.getCell(openBalanceColumnIndex).getNumericCellValue(), is(0D));

			valueObject.refresh();
			assertEquals(valueObject.getBusinessPartner().getTotalOpenBalance().longValue(), 0L,
					"Total open balance matches what's on the business partner");
		}
	}

	@IPopulateAnnotation.CanRun
	public void debtWaiversAppear() throws SQLException, IOException, ParseException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		BigDecimal visitCharge = new BigDecimal(1200);

		valueObject.setStepName("Create business partner");
		valueObject.setSalesStandardPrice(visitCharge);
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

		valueObject.setStepName("Create visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create waiver charge");
		MChargeType_BH oneOffsChargeType =
				new Query(valueObject.getContext(), MChargeType_BH.Table_Name, MChargeType_BH.COLUMNNAME_Name + "=?",
						valueObject.getTransactionName()).setParameters("One-offs - DO NOT CHANGE").setClient_ID().first();
		if (oneOffsChargeType == null) {
			oneOffsChargeType = new MChargeType_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
			oneOffsChargeType.setName("One-offs - DO NOT CHANGE");
			oneOffsChargeType.saveEx();
			commitEx();
		}
		MCharge_BH badDebtWriteOffCharge = new Query(valueObject.getContext(), MCharge_BH.Table_Name,
				MCharge_BH.COLUMNNAME_Name + "=? AND " + MCharge_BH.COLUMNNAME_C_ChargeType_ID + "=?",
				valueObject.getTransactionName()).setParameters("Bad debt write-off - DO NOT CHANGE",
				oneOffsChargeType.get_ID()).setClient_ID().first();
		if (badDebtWriteOffCharge == null) {
			ChuBoeCreateEntity.createCharge(valueObject);
			valueObject.getCharge().setName("Bad debt write-off - DO NOT CHANGE");
			valueObject.getCharge().setC_ChargeType_ID(oneOffsChargeType.get_ID());
			valueObject.getCharge().saveEx();
			commitEx();
		} else {
			valueObject.setCharge(badDebtWriteOffCharge);
		}

		valueObject.setStepName("Waive part of the open balance");
		valueObject.setVisit(null);
		valueObject.setOrder(null);
		valueObject.setSalesPrice(BigDecimal.valueOf(visitCharge.negate().doubleValue() / 2));
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARInvoice, null, true, false, false);
		ChuBoeCreateEntity.createInvoice(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(reportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Collections.singletonList(
				new ProcessInfoParameter("c_bpartner_uu", valueObject.getBusinessPartner().getC_BPartner_UU(), null, null,
						null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Name");
			assertNotNull(headerRow, "Header row exists");

			int patientNameColumnIndex = TableUtils.getColumnIndex(headerRow, "Name");
			int itemColumnIndex = TableUtils.getColumnIndex(headerRow, "Item");
			int chargesColumnIndex = TableUtils.getColumnIndex(headerRow, "Charges");
			int paymentsColumnIndex = TableUtils.getColumnIndex(headerRow, "Payments");
			int openBalanceColumnIndex = TableUtils.getColumnIndex(headerRow, "Open Balance");

			List<Row> tableRows = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getCell(patientNameColumnIndex).getStringCellValue()
							.contains(valueObject.getBusinessPartner().getName().substring(0, 25))).collect(Collectors.toList());

			assertThat("Only three rows exist for patient on report", tableRows.size(), is(3));

			Row row = tableRows.get(1);
			assertThat("Visit charge is correct", row.getCell(chargesColumnIndex).getNumericCellValue(),
					is(visitCharge.doubleValue()));
			assertThat("Visit payment is correct", row.getCell(paymentsColumnIndex).getNumericCellValue(),
					is(0D));
			assertThat("Open balance is correct", row.getCell(openBalanceColumnIndex).getNumericCellValue(),
					is(visitCharge.doubleValue()));

			row = tableRows.get(2);
			assertThat("Waiver information appears", row.getCell(itemColumnIndex).getStringCellValue(),
					containsStringIgnoringCase("Waived Open Balance"));
			assertThat("Waived charge is correct", row.getCell(chargesColumnIndex).getNumericCellValue(), is(0D));
			assertThat("Debt payment is correct", row.getCell(paymentsColumnIndex).getNumericCellValue(),
					is(visitCharge.doubleValue() / 2));
			assertThat("Open balance is correct", row.getCell(openBalanceColumnIndex).getNumericCellValue(),
					is(visitCharge.doubleValue() / 2));

			valueObject.refresh();
			assertEquals(valueObject.getBusinessPartner().getTotalOpenBalance().longValue(), visitCharge.longValue() / 2,
					"Total open balance matches what's on the business partner");
		}
	}
}
