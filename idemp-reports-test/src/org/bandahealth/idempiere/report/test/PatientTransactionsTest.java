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
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.report.test.utils.PDFUtils;
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

		valueObject.setStepName("Create order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create payment");
		MInvoice_BH invoice =
				new Query(valueObject.getContext(), MInvoice_BH.Table_Name, MInvoice_BH.COLUMNNAME_C_Order_ID + "=?",
						valueObject.getTransactionName()).setParameters(valueObject.getOrder().get_ID()).first();
		valueObject.setInvoice(invoice);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		ChuBoeCreateEntity.createPayment(valueObject);
		valueObject.getPayment().setBH_C_Order_ID(valueObject.getOrder().get_ID());
		valueObject.getPayment().saveEx();
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(patientTransactionReportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.yesterday(), null, null, null),
				new ProcessInfoParameter("End Date", TimestampUtils.tomorrow(), null, null, null)
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

		valueObject.setStepName("Create order");
		valueObject.setDocumentAction(DocAction.ACTION_Prepare);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create second product");
		valueObject.clearProduct();
		valueObject.setSalesPrice(new BigDecimal(5));
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Add second order line");
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
		MInvoice_BH invoice =
				new Query(valueObject.getContext(), MInvoice_BH.Table_Name, MInvoice_BH.COLUMNNAME_C_Order_ID + "=?",
						valueObject.getTransactionName()).setParameters(valueObject.getOrder().get_ID()).first();
		valueObject.setInvoice(invoice);
		valueObject.setDocumentAction(DocAction.ACTION_Prepare);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		ChuBoeCreateEntity.createPayment(valueObject);
		valueObject.getPayment().setBH_C_Order_ID(valueObject.getOrder().get_ID());
		valueObject.getPayment().setPayAmt(new BigDecimal(9));
		valueObject.getPayment().saveEx();
		valueObject.getPayment().setDocAction(DocAction.ACTION_Complete);
		assertTrue(valueObject.getPayment().processIt(DocAction.ACTION_Complete), "First payment was completed");
		commitEx();

		valueObject.setStepName("Create second payment");
		valueObject.setDocumentAction(DocAction.ACTION_Prepare);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_MPesa);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		ChuBoeCreateEntity.createPayment(valueObject);
		valueObject.getPayment().setBH_C_Order_ID(valueObject.getOrder().get_ID());
		valueObject.getPayment().setPayAmt(new BigDecimal(6));
		valueObject.getPayment().saveEx();
		valueObject.getPayment().setDocAction(DocAction.ACTION_Complete);
		assertTrue(valueObject.getPayment().processIt(DocAction.ACTION_Complete), "Second payment was completed");
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(patientTransactionReportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.yesterday(), null, null, null),
				new ProcessInfoParameter("End Date", TimestampUtils.tomorrow(), null, null, null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			List<Row> patientRows = StreamSupport.stream(sheet.spliterator(), false).filter(
							row -> row.getCell(5) != null && row.getCell(5).getCellType().equals(CellType.STRING) &&
									row.getCell(5).getStringCellValue().contains(valueObject.getBusinessPartner().getName().substring(0,
											30)))
					.collect(Collectors.toList());

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

		valueObject.setStepName("Create first product");
		valueObject.setSalesPrice(BigDecimal.TEN);
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create order");
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

		valueObject.setStepName("Create second product");
		valueObject.clearProduct();
		valueObject.setSalesPrice(new BigDecimal(5));
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Complete the order");
		valueObject.getOrder().setDocAction(DocAction.ACTION_Complete);
		assertTrue(valueObject.getOrder().processIt(DocAction.ACTION_Complete), "Order was completed");
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(patientTransactionReportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.yesterday(), null, null, null),
				new ProcessInfoParameter("End Date", TimestampUtils.tomorrow(), null, null, null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			List<Row> patientRows = StreamSupport.stream(sheet.spliterator(), false).filter(
							row -> row.getCell(5) != null && row.getCell(5).getCellType().equals(CellType.STRING) &&
									row.getCell(5).getStringCellValue().contains(valueObject.getBusinessPartner().getName().substring(0,
											30)))
					.collect(Collectors.toList());

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

		valueObject.setStepName("Create order");
		valueObject.setDocumentAction(DocAction.ACTION_Prepare);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create second product");
		valueObject.clearProduct();
		valueObject.setSalesPrice(new BigDecimal(5));
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Add second order line");
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
		MInvoice_BH invoice =
				new Query(valueObject.getContext(), MInvoice_BH.Table_Name, MInvoice_BH.COLUMNNAME_C_Order_ID + "=?",
						valueObject.getTransactionName()).setParameters(valueObject.getOrder().get_ID()).first();
		valueObject.setInvoice(invoice);
		valueObject.setDocumentAction(DocAction.ACTION_Prepare);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		ChuBoeCreateEntity.createPayment(valueObject);
		valueObject.getPayment().setBH_C_Order_ID(valueObject.getOrder().get_ID());
		valueObject.getPayment().setPayAmt(new BigDecimal(9));
		valueObject.getPayment().saveEx();
		valueObject.getPayment().setDocAction(DocAction.ACTION_Complete);
		assertTrue(valueObject.getPayment().processIt(DocAction.ACTION_Complete), "First payment was completed");
		commitEx();

		valueObject.setStepName("Create second payment");
		valueObject.setDocumentAction(DocAction.ACTION_Prepare);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_MPesa);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		ChuBoeCreateEntity.createPayment(valueObject);
		valueObject.getPayment().setBH_C_Order_ID(valueObject.getOrder().get_ID());
		valueObject.getPayment().setPayAmt(new BigDecimal(6));
		valueObject.getPayment().saveEx();
		valueObject.getPayment().setDocAction(DocAction.ACTION_Complete);
		assertTrue(valueObject.getPayment().processIt(DocAction.ACTION_Complete), "Second payment was completed");
		commitEx();

		valueObject.setStepName("Create second order");
		valueObject.setQuantity(BigDecimal.TEN);
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create second order's payment");
		invoice =
				new Query(valueObject.getContext(), MInvoice_BH.Table_Name, MInvoice_BH.COLUMNNAME_C_Order_ID + "=?",
						valueObject.getTransactionName()).setParameters(valueObject.getOrder().get_ID()).first();
		valueObject.setInvoice(invoice);
		valueObject.setDocumentAction(DocAction.ACTION_Prepare);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		ChuBoeCreateEntity.createPayment(valueObject);
		valueObject.getPayment().setBH_C_Order_ID(valueObject.getOrder().get_ID());
		valueObject.getPayment().saveEx();
		valueObject.getPayment().setDocAction(DocAction.ACTION_Complete);
		assertTrue(valueObject.getPayment().processIt(DocAction.ACTION_Complete), "Second order's payment was completed");
		commitEx();

		valueObject.setStepName("Generate the report with Cash filter");
		valueObject.setProcessUuid(patientTransactionReportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.yesterday(), null, null, null),
				new ProcessInfoParameter("End Date", TimestampUtils.tomorrow(), null, null, null),
				new ProcessInfoParameter("Payment Mode", MPayment_BH.TENDERTYPE_Cash, null, null, null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			List<Row> patientRows = StreamSupport.stream(sheet.spliterator(), false).filter(
							row -> row.getCell(5) != null && row.getCell(5).getCellType().equals(CellType.STRING) &&
									row.getCell(5).getStringCellValue().contains(valueObject.getBusinessPartner().getName().substring(0,
											30)))
					.collect(Collectors.toList());

			assertEquals(2, patientRows.size(), "Both of the patient's visits appear");
			Optional<Row> firstVisit =
					patientRows.stream().filter(row -> row.getCell(9).getNumericCellValue() == 15D).findFirst();
			assertTrue(firstVisit.isPresent(), "First visit is displayed");
			Optional<Row> secondVisit =
					patientRows.stream().filter(row -> row.getCell(9).getNumericCellValue() == 50D).findFirst();
			assertTrue(secondVisit.isPresent(), "Second visit is displayed");

			assertEquals(15D, firstVisit.get().getCell(10).getNumericCellValue(), "First visit's total payment is correct");
			assertEquals(9D, firstVisit.get().getCell(12).getNumericCellValue(), "First visit's cash payment is correct");
			assertEquals(6D, firstVisit.get().getCell(13).getNumericCellValue(), "First visit's mobile payment is correct");

			assertEquals(50D, secondVisit.get().getCell(10).getNumericCellValue(), "First visit's total payment is correct");
			assertEquals(50D, secondVisit.get().getCell(12).getNumericCellValue(), "First visit's cash payment is correct");
			assertEquals(0D, secondVisit.get().getCell(13).getNumericCellValue(), "First visit's mobile payment is correct");
		}

		valueObject.setStepName("Generate the report with Cash filter");
		ChuBoeCreateEntity.clearReport(valueObject);
		valueObject.setProcessUuid(patientTransactionReportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.yesterday(), null, null, null),
				new ProcessInfoParameter("End Date", TimestampUtils.tomorrow(), null, null, null),
				new ProcessInfoParameter("Payment Mode", MPayment_BH.TENDERTYPE_MPesa, null, null, null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			List<Row> patientRows = StreamSupport.stream(sheet.spliterator(), false).filter(
							row -> row.getCell(5) != null && row.getCell(5).getCellType().equals(CellType.STRING) &&
									row.getCell(5).getStringCellValue().contains(valueObject.getBusinessPartner().getName().substring(0,
											30)))
					.collect(Collectors.toList());

			assertEquals(1, patientRows.size(), "Only one of the patient's visits appear");

			assertEquals(15D, patientRows.get(0).getCell(9).getNumericCellValue(), "Bill total is correct");
			assertEquals(15D, patientRows.get(0).getCell(10).getNumericCellValue(), "Visit's total payment is correct");
			assertEquals(9D, patientRows.get(0).getCell(12).getNumericCellValue(), "Visit's cash payment is correct");
			assertEquals(6D, patientRows.get(0).getCell(13).getNumericCellValue(), "Visit's mobile payment is correct");
		}
	}
}
