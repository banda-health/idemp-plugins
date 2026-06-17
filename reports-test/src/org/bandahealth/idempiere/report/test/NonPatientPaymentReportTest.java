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
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.report.test.utils.EntityUtils;
import org.bandahealth.idempiere.report.test.utils.TableUtils;
import org.bandahealth.idempiere.report.test.utils.TimestampUtils;
import org.compiere.model.MInvoiceLine;
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

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NonPatientPaymentReportTest extends ChuBoePopulateFactoryVO {
	private final String nonPatientPaymentReportUuid = "19464274-e2bc-4dbe-ad69-ae48b9f7778c";

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
	public void reportRendersAndDisplaysCorrectData() throws SQLException, IOException {
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
		commitEx();

		valueObject.setStepName("Create material receipt");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialReceipt, null, false, false, false);
		ChuBoeCreateEntity.createInOutFromOrder(valueObject);
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
		valueObject.setSalesStandardPrice(invoiceLine.getPriceActual().negate());
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARInvoice, null, true, false, false);
		ChuBoeCreateEntity.createInvoice(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(nonPatientPaymentReportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				Arrays.asList(new ProcessInfoParameter("Begin Date", TimestampUtils.yesterday(), null, null, null),
						new ProcessInfoParameter("End Date", TimestampUtils.tomorrow(), null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);
		assertThat("Report was generated", valueObject.getErrorMessage(), is(nullValue()));
		commitEx();

		assertNotNull(valueObject.getReport(), "Report was generated successfully");

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Date");
			TableUtils.getColumnIndex(headerRow, "Patient Name");
			TableUtils.getColumnIndex(headerRow, "Patient No");
			TableUtils.getColumnIndex(headerRow, "Visit Type");
			TableUtils.getColumnIndex(headerRow, "Member ID");
			TableUtils.getColumnIndex(headerRow, "Member Name ");
			TableUtils.getColumnIndex(headerRow, "Relationship");
			TableUtils.getColumnIndex(headerRow, "Claims Number");
			TableUtils.getColumnIndex(headerRow, "Total Charge from Visit");
			TableUtils.getColumnIndex(headerRow, "Total Charged to Selected Non-patient Payment Type");
			TableUtils.getColumnIndex(headerRow, "Total Other Charges");
		}
	}

	@IPopulateAnnotation.CanRun
	public void onlyVisitsWithNonPatientPaymentsAppear() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		valueObject.getBusinessPartner()
				.setName(valueObject.getRandomNumber() + valueObject.getBusinessPartner().getName());
		valueObject.getBusinessPartner().saveEx();
		commitEx();

		valueObject.setStepName("Create product");
		valueObject.setSalesPrice(BigDecimal.TEN);
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create PO");
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(BigDecimal.TEN);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create material receipt");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialReceipt, null, false, false, false);
		ChuBoeCreateEntity.createInOutFromOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create first visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create first SO");
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setQuantity(BigDecimal.ONE);
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
		valueObject.setSalesStandardPrice(invoiceLine.getPriceActual().negate());
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARInvoice, null, true, false, false);
		ChuBoeCreateEntity.createInvoice(valueObject);
		commitEx();

		valueObject.setStepName("Create payment");
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		valueObject.setStepName("Create business partner");
		valueObject.clearBusinessPartner();
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		valueObject.getBusinessPartner()
				.setName(valueObject.getRandomNumber() + valueObject.getBusinessPartner().getName());
		valueObject.getBusinessPartner().saveEx();
		commitEx();

		valueObject.setStepName("Create second visit");
		valueObject.setInvoice(null);
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create second SO");
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_WarehouseOrder, true,
				false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create invoice");
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARInvoice, null, true, false, false);
		ChuBoeCreateEntity.createInvoice(valueObject);
		commitEx();

		valueObject.setStepName("Create payment");
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(nonPatientPaymentReportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				Arrays.asList(new ProcessInfoParameter("Begin Date", TimestampUtils.yesterday(), null, null, null),
						new ProcessInfoParameter("End Date", TimestampUtils.tomorrow(), null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);
		assertThat("Report was generated", valueObject.getErrorMessage(), is(nullValue()));
		commitEx();

		assertNotNull(valueObject.getReport(), "Report was generated successfully");

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Date");
			int patientNameColumnIndex = TableUtils.getColumnIndex(headerRow, "Patient Name");

			List<Row> patientRows = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getCell(patientNameColumnIndex) != null &&
							row.getCell(patientNameColumnIndex).getCellType().equals(CellType.STRING) &&
							row.getCell(patientNameColumnIndex).getStringCellValue()
									.contains(valueObject.getBusinessPartner().getName().substring(0, 15))).collect(Collectors.toList());

			assertEquals(0, patientRows.size(), "Patient doesn't appear");
		}
	}

	@IPopulateAnnotation.CanRun
	public void filterByInsurerWorks() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		valueObject.getBusinessPartner()
				.setName(valueObject.getRandomNumber() + valueObject.getBusinessPartner().getName());
		valueObject.getBusinessPartner().saveEx();
		MBPartner_BH firstBusinessPartner = valueObject.getBusinessPartner();
		commitEx();

		valueObject.setStepName("Create product");
		valueObject.setSalesPrice(BigDecimal.TEN);
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create PO");
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(BigDecimal.TEN);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create material receipt");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialReceipt, null, false, false, false);
		ChuBoeCreateEntity.createInOutFromOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create first visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create first SO");
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setQuantity(BigDecimal.ONE);
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
		MBPartner_BH donor = valueObject.getBusinessPartner();
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
		valueObject.setSalesStandardPrice(invoiceLine.getPriceActual().negate());
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARInvoice, null, true, false, false);
		ChuBoeCreateEntity.createInvoice(valueObject);
		commitEx();

		valueObject.setStepName("Create second business partner");
		valueObject.clearBusinessPartner();
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		valueObject.getBusinessPartner()
				.setName(valueObject.getRandomNumber() + valueObject.getBusinessPartner().getName());
		valueObject.getBusinessPartner().saveEx();
		commitEx();

		valueObject.setStepName("Create second visit");
		valueObject.setInvoice(null);
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create second SO");
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_WarehouseOrder, true,
				false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create second invoice");
		valueObject.setDocumentAction(DocAction.ACTION_Prepare);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARInvoice, null, true, false, false);
		ChuBoeCreateEntity.createInvoice(valueObject);
		invoice = valueObject.getInvoice();
		commitEx();

		valueObject.setStepName("Create second donor");
		valueObject.stackAndClearBusinessPartner();
		EntityUtils.getBandaHealthDonorAndAssociatedCharge(valueObject);
		commitEx();

		valueObject.setStepName("Create second donor invoice line discount");
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

		valueObject.setStepName("Create second donor invoice");
		valueObject.setOrder(null);
		valueObject.setOrderLine(null);
		valueObject.setSalesStandardPrice(invoiceLine.getPriceActual().negate());
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARInvoice, null, true, false, false);
		ChuBoeCreateEntity.createInvoice(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid(nonPatientPaymentReportUuid);
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(
				Arrays.asList(new ProcessInfoParameter("Begin Date", TimestampUtils.yesterday(), null, null, null),
						new ProcessInfoParameter("End Date", TimestampUtils.tomorrow(), null, null, null),
						new ProcessInfoParameter("C_BPartner_UU", donor.getC_BPartner_UU(), null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);
		assertThat("Report was generated", valueObject.getErrorMessage(), is(nullValue()));
		commitEx();

		assertNotNull(valueObject.getReport(), "Report was generated successfully");

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Date");
			int patientNameColumnIndex = TableUtils.getColumnIndex(headerRow, "Patient Name");

			// Find the one we searched for
			Optional<Row> patientRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getCell(patientNameColumnIndex) != null &&
							row.getCell(patientNameColumnIndex).getCellType().equals(CellType.STRING) &&
							row.getCell(patientNameColumnIndex).getStringCellValue()
									.contains(firstBusinessPartner.getName().substring(0, 15))).findFirst();

			assertTrue(patientRow.isPresent(), "First patient for specified donor appears");
			//
			// Ensure the one we filtered out isn't there
			patientRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getCell(patientNameColumnIndex) != null &&
							row.getCell(patientNameColumnIndex).getCellType().equals(CellType.STRING) &&
							row.getCell(patientNameColumnIndex).getStringCellValue()
									.contains(valueObject.getBusinessPartner().getName().substring(0, 15))).findFirst();

			assertTrue(patientRow.isEmpty(), "Second patient for filtered donor doesn't appear");

			// Ensure the correct insurer/donor filter is present
			Optional<Row> donorRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().contains(donor.getName()))).findFirst();
			assertTrue(donorRow.isPresent(), "Donor appears");
		}
	}
}
