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
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.report.test.utils.EntityUtils;
import org.bandahealth.idempiere.report.test.utils.TableUtils;
import org.bandahealth.idempiere.report.test.utils.TimestampUtils;
import org.compiere.model.MInvoiceLine;
import org.compiere.process.DocAction;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.util.Env;
import org.hamcrest.Matchers;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DonorFundReportTest extends ChuBoePopulateFactoryVO {

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
		Timestamp birthday = TimestampUtils.addToNow(Calendar.YEAR, -1);
		valueObject.getBusinessPartner().setBH_Birthday(birthday);
		String patientId = String.valueOf(valueObject.getRandomNumber());
		valueObject.getBusinessPartner().setBH_PatientID(patientId);
		valueObject.getBusinessPartner().saveEx();
		commitEx();

		valueObject.setStepName("Create product");
		valueObject.setSalesPrice(BigDecimal.TEN);
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create PO");
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		valueObject.getVisit().setbh_primaryuncodeddiagnosis("pain");
		valueObject.getVisit().saveEx();
		commitEx();

		valueObject.setStepName("Create SO");
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_WarehouseOrder, true,
				false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create invoice");
		valueObject.setDocumentAction(DocAction.ACTION_Prepare);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARInvoice, null, true, false, false);
		ChuBoeCreateEntity.createInvoice(valueObject);
		MInvoice_BH invoice = valueObject.getInvoice();
		commitEx();

		valueObject.setStepName("Create donor");
		valueObject.stackAndClearBusinessPartner();
		EntityUtils.getBandaHealthDonorAndAssociatedCharge(valueObject);
		commitEx();

		valueObject.setStepName("Create donor invoice line discount");
		MInvoiceLine invoiceLine = new MInvoiceLine(valueObject.getContext(), 0, valueObject.getTransactionName());
		invoiceLine.setC_Invoice_ID(invoice.get_ID());
		invoiceLine.setDescription(valueObject.getStepMessageLong());
		invoiceLine.setAD_Org_ID(valueObject.getOrg().get_ID());
		invoiceLine.setC_Charge_ID(valueObject.getCharge().get_ID());
		invoiceLine.setC_UOM_ID(valueObject.getProduct().getC_UOM_ID());
		invoiceLine.setQty(Env.ONE);
		invoiceLine.setPrice(new BigDecimal(-2));
		invoiceLine.saveEx();

		invoice.setDocAction(DocAction.ACTION_Complete);
		assertTrue(invoice.processIt(DocAction.ACTION_Complete), "Invoice completed");
		invoice.saveEx();
		commitEx();

		valueObject.setStepName("Create donor invoice");
		valueObject.setOrder(null);
		valueObject.setOrderLine(null);
		BigDecimal salesStandardPrice = valueObject.getSalesStandardPrice();
		valueObject.setSalesStandardPrice(invoiceLine.getPriceActual().negate());
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARInvoice, null, true, false, false);
		ChuBoeCreateEntity.createInvoice(valueObject);
		commitEx();

		valueObject.setStepName("Create payment");
		valueObject.popBusinessPartnerFromStack();
		valueObject.setSalesStandardPrice(salesStandardPrice);
		valueObject.setInvoice(invoice);
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("3478d341-c6d9-4f52-a865-5bf0ba8a7607");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", TimestampUtils.yesterday(), null, null, null),
				new ProcessInfoParameter("End Date", TimestampUtils.tomorrow(), null, null, null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);
		commitEx();

		assertNotNull(valueObject.getReport(), "Report was generated successfully");

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Visit Date");
			int patientNameColumnIndex = TableUtils.getColumnIndex(headerRow, "Patient Name");
			int dateOfBirthColumnIndex = TableUtils.getColumnIndex(headerRow, "Date of Birth");
			TableUtils.getColumnIndexContaining(headerRow, "Patient Donor ");
			int patientClinicIdNumberColumnIndex = TableUtils.getColumnIndexContaining(headerRow, "Patient Clinic ");
			int diagnosisColumnIndex = TableUtils.getColumnIndex(headerRow, "Diagnosis");
			int totalBilledToColumnIndex = TableUtils.getColumnIndexContaining(headerRow, "Total billed to ");

			List<Row> patientRows = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getCell(patientNameColumnIndex) != null &&
							row.getCell(patientNameColumnIndex).getCellType().equals(CellType.STRING) &&
							row.getCell(patientNameColumnIndex).getStringCellValue()
									.contains(valueObject.getBusinessPartner().getName().substring(0, 30))).collect(Collectors.toList());

			assertEquals(1, patientRows.size(), "Patient's visit appears");
			Row visit = patientRows.get(0);

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			assertTrue(visit.getCell(patientNameColumnIndex).getStringCellValue()
					.contains(valueObject.getBusinessPartner().getName().substring(0, 30)), "Patient Name is displayed");
			assertEquals(dateFormat.format(birthday),
					dateFormat.format(visit.getCell(dateOfBirthColumnIndex).getDateCellValue()), "Date of Birth is displayed");
			assertEquals(patientId, visit.getCell(patientClinicIdNumberColumnIndex).getStringCellValue(),
					"Patient Clinic column exists");
			assertEquals("pain", visit.getCell(diagnosisColumnIndex).getStringCellValue(), "Diagnosis is displayed");
			assertEquals(2D, visit.getCell(totalBilledToColumnIndex).getNumericCellValue(), "Bill total is correct");
		}
	}

	@IPopulateAnnotation.CanRun
	public void dateTimeFiltersWork() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		Timestamp birthday = TimestampUtils.addToNow(Calendar.YEAR, -1);
		valueObject.getBusinessPartner().setBH_Birthday(birthday);
		String patientId = String.valueOf(valueObject.getRandomNumber());
		valueObject.getBusinessPartner().setBH_PatientID(patientId);
		valueObject.getBusinessPartner().saveEx();
		commitEx();

		valueObject.setStepName("Create product");
		valueObject.setSalesPrice(BigDecimal.TEN);
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create PO");
		valueObject.setQuantity(BigDecimal.TEN);
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		ChuBoeCreateEntity.createOrder(valueObject);

		Timestamp earlyDate = TimestampUtils.startOfYesterday();
		Timestamp beginDate = TimestampUtils.add(earlyDate, Calendar.HOUR, 2);
		Timestamp endDate = TimestampUtils.addToNow(Calendar.DAY_OF_YEAR, 2);

		valueObject.setStepName("Create visit");
		valueObject.setDate(earlyDate);
		ChuBoeCreateEntity.createVisit(valueObject);
		valueObject.getVisit().setbh_primaryuncodeddiagnosis("pain");
		valueObject.getVisit().saveEx();
		commitEx();

		valueObject.setStepName("Create SO");
		valueObject.setQuantity(BigDecimal.ONE);
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_WarehouseOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create invoice");
		valueObject.setDocumentAction(DocAction.ACTION_Prepare);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARInvoice, null, true, false, false);
		ChuBoeCreateEntity.createInvoice(valueObject);
		MInvoice_BH invoice = valueObject.getInvoice();
		commitEx();

		valueObject.setStepName("Create donor");
		valueObject.stackAndClearBusinessPartner();
		EntityUtils.getBandaHealthDonorAndAssociatedCharge(valueObject);
		commitEx();

		valueObject.setStepName("Create donor invoice line discount");
		MInvoiceLine invoiceLine = new MInvoiceLine(valueObject.getContext(), 0, valueObject.getTransactionName());
		invoiceLine.setC_Invoice_ID(invoice.get_ID());
		invoiceLine.setDescription(valueObject.getStepMessageLong());
		invoiceLine.setAD_Org_ID(valueObject.getOrg().get_ID());
		invoiceLine.setC_Charge_ID(valueObject.getCharge().get_ID());
		invoiceLine.setC_UOM_ID(valueObject.getProduct().getC_UOM_ID());
		invoiceLine.setQty(Env.ONE);
		invoiceLine.setPrice(new BigDecimal(-2));
		invoiceLine.saveEx();

		invoice.setDocAction(DocAction.ACTION_Complete);
		assertTrue(invoice.processIt(DocAction.ACTION_Complete), "Invoice completed");
		invoice.saveEx();
		commitEx();

		valueObject.setStepName("Create donor invoice");
		valueObject.setOrder(null);
		valueObject.setOrderLine(null);
		BigDecimal salesStandardPrice = valueObject.getSalesStandardPrice();
		valueObject.setSalesStandardPrice(invoiceLine.getPriceActual().negate());
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARInvoice, null, true, false, false);
		ChuBoeCreateEntity.createInvoice(valueObject);
		commitEx();

		valueObject.setStepName("Create payment");
		valueObject.popBusinessPartnerFromStack();
		valueObject.setSalesStandardPrice(salesStandardPrice);
		valueObject.setInvoice(invoice);
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		valueObject.setStepName("Create visit");
		valueObject.setDateOffset(1);
		ChuBoeCreateEntity.createVisit(valueObject);
		valueObject.getVisit().setbh_primaryuncodeddiagnosis("pain");
		valueObject.getVisit().saveEx();
		commitEx();

		valueObject.setStepName("Create SO");
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_WarehouseOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create invoice");
		valueObject.setDocumentAction(DocAction.ACTION_Prepare);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARInvoice, null, true, false, false);
		ChuBoeCreateEntity.createInvoice(valueObject);
		invoice = valueObject.getInvoice();
		commitEx();

		valueObject.setStepName("Create donor");
		valueObject.stackAndClearBusinessPartner();
		EntityUtils.getBandaHealthDonorAndAssociatedCharge(valueObject);
		commitEx();

		valueObject.setStepName("Create donor invoice line discount");
		invoiceLine = new MInvoiceLine(valueObject.getContext(), 0, valueObject.getTransactionName());
		invoiceLine.setC_Invoice_ID(invoice.get_ID());
		invoiceLine.setDescription(valueObject.getStepMessageLong());
		invoiceLine.setAD_Org_ID(valueObject.getOrg().get_ID());
		invoiceLine.setC_Charge_ID(valueObject.getCharge().get_ID());
		invoiceLine.setC_UOM_ID(valueObject.getProduct().getC_UOM_ID());
		invoiceLine.setQty(Env.ONE);
		invoiceLine.setPrice(new BigDecimal(-2));
		invoiceLine.saveEx();

		invoice.setDocAction(DocAction.ACTION_Complete);
		assertTrue(invoice.processIt(DocAction.ACTION_Complete), "Invoice completed");
		invoice.saveEx();
		commitEx();

		valueObject.setStepName("Create donor invoice");
		valueObject.setOrder(null);
		valueObject.setOrderLine(null);
		salesStandardPrice = valueObject.getSalesStandardPrice();
		valueObject.setSalesStandardPrice(invoiceLine.getPriceActual().negate());
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARInvoice, null, true, false, false);
		ChuBoeCreateEntity.createInvoice(valueObject);
		commitEx();

		valueObject.setStepName("Create payment");
		valueObject.popBusinessPartnerFromStack();
		valueObject.setSalesStandardPrice(salesStandardPrice);
		valueObject.setInvoice(invoice);
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("3478d341-c6d9-4f52-a865-5bf0ba8a7607");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", beginDate, null, null, null),
				new ProcessInfoParameter("End Date", endDate, null, null, null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);
		commitEx();

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Visit Date");
			int patientNameColumnIndex = TableUtils.getColumnIndex(headerRow, "Patient Name");

			List<Row> patientRows = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getCell(patientNameColumnIndex) != null &&
							row.getCell(patientNameColumnIndex).getCellType().equals(CellType.STRING) &&
							row.getCell(patientNameColumnIndex).getStringCellValue()
									.contains(valueObject.getBusinessPartner().getName().substring(0, 30))).collect(Collectors.toList());

			assertEquals(1, patientRows.size(), "Patient's visit appears only once");
		}
	}
}
