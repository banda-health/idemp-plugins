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
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.report.test.utils.PDFUtils;
import org.bandahealth.idempiere.report.test.utils.TimestampUtils;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.util.DB;
import org.hamcrest.Matchers;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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

public class InPatientReportTest extends ChuBoePopulateFactoryVO {
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
	public void canGenerateReport() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		valueObject.getBusinessPartner().setName(valueObject.getBusinessPartner().getName().substring(0, 19));
		valueObject.getBusinessPartner().saveEx();
		valueObject.setRandom();
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(100));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

//		valueObject.setStepName("Create material receipt");
//		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
//		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialReceipt, null, false, false, false);
//		ChuBoeCreateEntity.createInOutFromOrder(valueObject);
//		commitEx();

		valueObject.setStepName("Create visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		valueObject.getVisit().setBH_PatientType(MBHVisit.BH_PATIENTTYPE_InpatientIPD);
		valueObject.getVisit().saveEx();
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Generate the in-patient report");
		valueObject.setProcessUuid("a1b2c3d4-e5f6-7890-abcd-ef1234567890");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", Timestamp.valueOf(LocalDateTime.now().minusDays(7)), null, null, null),
				new ProcessInfoParameter("End Date", Timestamp.valueOf(LocalDateTime.now().plusDays(7)), null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);

			Optional<Row> patientNameRow = StreamSupport.stream(sheet.spliterator(), false).filter(
							row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
									cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
											cell.getStringCellValue().contains(valueObject.getBusinessPartner().getName().substring(0, 15))))
					.findFirst();
			assertTrue(patientNameRow.isPresent(), "Patient name is on the in-patient report");
		}
	}

	@IPopulateAnnotation.CanRun
	public void reportWorksWithDateRangeParameters() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		valueObject.getBusinessPartner().setName(valueObject.getBusinessPartner().getName().substring(0, 19));
		valueObject.getBusinessPartner().saveEx();
		valueObject.setRandom();
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(100));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		// valueObject.setStepName("Create material receipt");
		// valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		// valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialReceipt, null, false, false, false);
		// ChuBoeCreateEntity.createInOutFromOrder(valueObject);
		// commitEx();

		valueObject.setStepName("Create visit an old visit that should be filtered out");
		valueObject.setDateOffset(-10);
		ChuBoeCreateEntity.createVisit(valueObject);
		valueObject.getVisit().setBH_PatientType(MBHVisit.BH_PATIENTTYPE_InpatientIPD);
		valueObject.getVisit().saveEx();
		commitEx();

		valueObject.setStepName("Ensure the updated date is in the past");
		DB.executeUpdate("UPDATE bh_visit set updated = ? WHERE bh_visit_id = ?",
				List.of(valueObject.getDate(), valueObject.getVisit().get_ID()).toArray(), true,
				valueObject.getTransactionName());

		valueObject.setStepName("Create sales order 1");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		valueObject.setQuantity(BigDecimal.ONE);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create visit where the end date is in the range");
		ChuBoeCreateEntity.createVisit(valueObject);
		valueObject.getVisit().setBH_PatientType(MBHVisit.BH_PATIENTTYPE_InpatientIPD);
		valueObject.getVisit().saveEx();
		commitEx();

		valueObject.setStepName("Create sales order 2");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create visit where the start date is in the range");
		valueObject.setDateOffset(10);
		ChuBoeCreateEntity.createVisit(valueObject);
		valueObject.getVisit().setBH_PatientType(MBHVisit.BH_PATIENTTYPE_InpatientIPD);
		valueObject.getVisit().saveEx();
		commitEx();

		valueObject.setStepName("Ensure the updated date is in the future");
		valueObject.setDateOffset(10);
		DB.executeUpdate("UPDATE bh_visit set updated = ? WHERE bh_visit_id = ?",
				List.of(valueObject.getDate(), valueObject.getVisit().get_ID()).toArray(), true,
				valueObject.getTransactionName());

		valueObject.setStepName("Create sales order 3");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create visit where the start date is before the range and the end date is in the future");
		valueObject.setDateOffset(-20);
		ChuBoeCreateEntity.createVisit(valueObject);
		valueObject.getVisit().setBH_PatientType(MBHVisit.BH_PATIENTTYPE_InpatientIPD);
		valueObject.getVisit().saveEx();
		commitEx();

		valueObject.setStepName("Ensure the updated date is in the past");
		valueObject.setDateOffset(20);
		DB.executeUpdate("UPDATE bh_visit set updated = ? WHERE bh_visit_id = ?",
				List.of(valueObject.getDate(), valueObject.getVisit().get_ID()).toArray(), true,
				valueObject.getTransactionName());

		valueObject.setStepName("Create sales order 4");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		// Test with a specific date range
		Timestamp startDate = TimestampUtils.startOfYesterday();
		Timestamp endDate = TimestampUtils.endOfTomorrow();

		valueObject.setStepName("Generate the in-patient report with custom date range");
		valueObject.setProcessUuid("a1b2c3d4-e5f6-7890-abcd-ef1234567890");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", startDate, null, null, null),
				new ProcessInfoParameter("End Date", endDate, null, null, null)));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);

			List<Row> patientNameRow = StreamSupport.stream(sheet.spliterator(), false).filter(
							row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
									cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
											cell.getStringCellValue().contains(valueObject.getBusinessPartner().getName().substring(0, 15))))
					.collect(Collectors.toUnmodifiableList());
			assertEquals(3, patientNameRow.size(), "Correct number of visits is filtered");
		}
	}

	@IPopulateAnnotation.CanRun
	public void reportWorksWithPDFOutput() throws SQLException, IOException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		valueObject.getBusinessPartner().setName(valueObject.getBusinessPartner().getName().substring(0, 19));
		valueObject.getBusinessPartner().saveEx();
		valueObject.setRandom();
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(100));
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		// valueObject.setStepName("Create material receipt");
		// valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		// valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_MaterialReceipt, null, false, false, false);
		// ChuBoeCreateEntity.createInOutFromOrder(valueObject);
		// commitEx();

		valueObject.setStepName("Create visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		valueObject.getVisit().setBH_PatientType(MBHVisit.BH_PATIENTTYPE_InpatientIPD);
		valueObject.getVisit().saveEx();
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Generate the in-patient report as PDF");
		valueObject.setProcessUuid("a1b2c3d4-e5f6-7890-abcd-ef1234567890");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Arrays.asList(
				new ProcessInfoParameter("Begin Date", Timestamp.valueOf(LocalDateTime.now().minusDays(7)), null, null, null),
				new ProcessInfoParameter("End Date", Timestamp.valueOf(LocalDateTime.now().plusDays(7)), null, null, null)));
		valueObject.setReportType("pdf");
		ChuBoeCreateEntity.runReport(valueObject);

		String reportContent = PDFUtils.readPdfContent(valueObject.getReport(), true);
		assertTrue(reportContent.contains("In-Patient Report"), "In-Patient Report title appears in PDF");
		assertTrue(reportContent.contains(valueObject.getBusinessPartner().getName().substring(0, 15)),
				"Patient name appears in PDF report");
	}
}
