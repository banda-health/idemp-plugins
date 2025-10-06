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
import org.bandahealth.idempiere.report.test.utils.PDFUtils;
import org.bandahealth.idempiere.report.test.utils.TableUtils;
import org.compiere.process.DocumentEngine;
import org.hamcrest.Matchers;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OpenBalanceListTest extends ChuBoePopulateFactoryVO {
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

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createPatient(valueObject);
		valueObject.getBusinessPartner().setName(String.valueOf(valueObject.getRandomNumber()));
		valueObject.getBusinessPartner().saveEx();
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(200));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create material receipt");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialReceipt, null, false, false, false);
		ChuBoeCreateEntity.createInOutFromOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		valueObject.setQuantity(new BigDecimal(100));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("b4f11e14-b9d8-4f6c-aa46-adfd77c4f773");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);
		valueObject.refresh();

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Patient Name");
			int patientColumnIndex = TableUtils.getColumnIndex(headerRow, "Patient Name");
			int remainingOpenBalanceColumnIndex = TableUtils.getColumnIndex(headerRow, "Remaining Open Balance");
			//
			Optional<Row> patientRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> row.getCell(patientColumnIndex) != null &&
							row.getCell(patientColumnIndex).getCellType().equals(CellType.STRING) &&
							row.getCell(patientColumnIndex).getStringCellValue()
									.equalsIgnoreCase(valueObject.getBusinessPartner().getName())).findFirst();
			assertTrue(patientRow.isPresent(), "Report contains patient");
			assertThat("Patient's open balance is correct",
					patientRow.get().getCell(remainingOpenBalanceColumnIndex).getNumericCellValue(),
					is(valueObject.getOrder().getGrandTotal().doubleValue()));
		}
	}

	@IPopulateAnnotation.CanRun
	public void onlyPatientsAreIncluded() throws SQLException, IOException, ParseException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create non-patient business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		valueObject.getBusinessPartner()
				.setName(valueObject.getRandomNumber() + valueObject.getBusinessPartner().getName());
		valueObject.getBusinessPartner().saveEx();
		MBPartner_BH nonPatientBusinessPartner = valueObject.getBusinessPartner();
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(200));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create material receipt");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialReceipt, null, false, false, false);
		ChuBoeCreateEntity.createInOutFromOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		valueObject.setQuantity(new BigDecimal(100));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.clearBusinessPartner();
		valueObject.clearProduct();

		valueObject.setStepName("Create patient business partner");
		valueObject.clearBusinessPartner();
		ChuBoeCreateEntity.createPatient(valueObject);
		valueObject.getBusinessPartner()
				.setName(valueObject.getRandomNumber() + valueObject.getBusinessPartner().getName());
		valueObject.getBusinessPartner().saveEx();
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(200));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create material receipt");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialReceipt, null, false, false, false);
		ChuBoeCreateEntity.createInOutFromOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		valueObject.setQuantity(new BigDecimal(100));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("b4f11e14-b9d8-4f6c-aa46-adfd77c4f773");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);
		valueObject.refresh();

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Patient Name");
			int patientColumnIndex = TableUtils.getColumnIndex(headerRow, "Patient Name");
//
			Optional<Row> nonPatientRow = StreamSupport.stream(sheet.spliterator(), false).filter(
							row -> row.getCell(patientColumnIndex) != null &&
									row.getCell(patientColumnIndex).getCellType().equals(CellType.STRING) &&
									row.getCell(patientColumnIndex).getStringCellValue().contains(nonPatientBusinessPartner.getName()))
					.findFirst();
			assertTrue(nonPatientRow.isEmpty(), "Report does not contain the non-patient");
			Optional<Row> patientRow = StreamSupport.stream(sheet.spliterator(), false).filter(
							row -> row.getCell(patientColumnIndex) != null &&
									row.getCell(patientColumnIndex).getCellType().equals(CellType.STRING) &&
									row.getCell(patientColumnIndex).getStringCellValue().contains(valueObject.getBusinessPartner().getName()))
					.findFirst();
			assertTrue(patientRow.isPresent(), "Report contains patient");
		}
	}

	@IPopulateAnnotation.CanRun
	public void totalMatchesWhatPatientsOwe() throws SQLException, IOException, ParseException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create non-patient business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		valueObject.getBusinessPartner()
				.setName(valueObject.getRandomNumber() + valueObject.getBusinessPartner().getName());
		valueObject.getBusinessPartner().saveEx();
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(200));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create material receipt");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialReceipt, null, false, false, false);
		ChuBoeCreateEntity.createInOutFromOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		valueObject.setQuantity(new BigDecimal(100));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.clearBusinessPartner();
		valueObject.clearProduct();

		valueObject.setStepName("Create patient business partner");
		valueObject.clearBusinessPartner();
		ChuBoeCreateEntity.createPatient(valueObject);
		valueObject.getBusinessPartner()
				.setName(valueObject.getRandomNumber() + valueObject.getBusinessPartner().getName());
		valueObject.getBusinessPartner().saveEx();
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(200));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create material receipt");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialReceipt, null, false, false, false);
		ChuBoeCreateEntity.createInOutFromOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		valueObject.setQuantity(new BigDecimal(100));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("b4f11e14-b9d8-4f6c-aa46-adfd77c4f773");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);
		valueObject.refresh();

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Patient Name");
			int remainingOpenBalanceColumnIndex = TableUtils.getColumnIndex(headerRow, "Remaining Open Balance");
			double runningTotal = 0;
			Row tableRow;
			for (int rowNumber = headerRow.getRowNum() + 1; rowNumber < sheet.getLastRowNum(); rowNumber++) {
				if ((tableRow = sheet.getRow(rowNumber)).getCell(remainingOpenBalanceColumnIndex) != null &&
						tableRow.getCell(remainingOpenBalanceColumnIndex).getCellType().equals(CellType.NUMERIC)) {
					runningTotal += tableRow.getCell(remainingOpenBalanceColumnIndex).getNumericCellValue();
				}
			}
			assertTrue(runningTotal > 0, "There is an open balance");

			Optional<Row> totalsRow = StreamSupport.stream(sheet.spliterator(), false).filter(
							row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
									cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
											cell.getStringCellValue().contains("Total Open Balance")))
					.findFirst();
			assertTrue(totalsRow.isPresent(), "Total Open Balance row exists");

			double finalRunningTotal = runningTotal;
			assertTrue(StreamSupport.stream(totalsRow.get().spliterator(), false).anyMatch(
					cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC) &&
							cell.getNumericCellValue() == finalRunningTotal), "Report displays the correct open balance");
		}
	}

	@IPopulateAnnotation.CanRun
	public void longTotalIsDisplayed() throws SQLException, IOException, ParseException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		valueObject.setSalesPrice(new BigDecimal(100000000));
		ChuBoeCreateEntity.createPatient(valueObject);
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(200));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create material receipt");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialReceipt, null, false, false, false);
		ChuBoeCreateEntity.createInOutFromOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		valueObject.setQuantity(new BigDecimal(100));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("b4f11e14-b9d8-4f6c-aa46-adfd77c4f773");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);
		valueObject.refresh();

		double runningTotal = 0;
		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			Row headerRow = TableUtils.getHeaderRow(sheet, "Patient Name");
			int remainingOpenBalanceColumnIndex = TableUtils.getColumnIndex(headerRow, "Remaining Open Balance");
			Row tableRow;
			for (int rowNumber = headerRow.getRowNum() + 1; rowNumber < sheet.getLastRowNum(); rowNumber++) {
				if ((tableRow = sheet.getRow(rowNumber)).getCell(remainingOpenBalanceColumnIndex) != null &&
						tableRow.getCell(remainingOpenBalanceColumnIndex).getCellType().equals(CellType.NUMERIC)) {
					runningTotal += tableRow.getCell(remainingOpenBalanceColumnIndex).getNumericCellValue();
				}
			}
			assertTrue(runningTotal > 0, "There is an open balance");

			Optional<Row> totalsRow = StreamSupport.stream(sheet.spliterator(), false).filter(
							row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
									cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
											cell.getStringCellValue().contains("Total Open Balance")))
					.findFirst();
			assertTrue(totalsRow.isPresent(), "Total Open Balance row exists");

			double finalRunningTotal = runningTotal;
			assertTrue(StreamSupport.stream(totalsRow.get().spliterator(), false).anyMatch(
					cell -> cell != null && cell.getCellType().equals(CellType.NUMERIC) &&
							cell.getNumericCellValue() == finalRunningTotal), "Report displays the correct open balance");
		}

		valueObject.setStepName("Regenerate the report");
		valueObject.setProcessUuid("b4f11e14-b9d8-4f6c-aa46-adfd77c4f773");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setReportType("pdf");
		ChuBoeCreateEntity.runReport(valueObject);

		String reportContent = PDFUtils.readPdfContent(valueObject.getReport(), true);
		DecimalFormat decimalFormat = new DecimalFormat("#,###");
		assertTrue(reportContent.toLowerCase().contains(decimalFormat.format(runningTotal)),
				"Long total is displayed on the report");
	}
}
