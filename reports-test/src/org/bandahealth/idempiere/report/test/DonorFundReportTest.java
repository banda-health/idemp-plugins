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
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.report.test.utils.TableUtils;
import org.bandahealth.idempiere.report.test.utils.TimestampUtils;
import org.compiere.process.DocAction;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.util.Env;

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

		valueObject.setStepName("Create donor charge");
		ChuBoeCreateEntity.createCharge(valueObject);
		valueObject.getCharge().setBH_SubType(MCharge_BH.BH_SUBTYPE_Donation);
		valueObject.getCharge().saveEx();
		commitEx();

		valueObject.setStepName("Create PO");
		valueObject.setDocumentAction(DocAction.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		ChuBoeCreateEntity.createOrder(valueObject);

		valueObject.setStepName("Create visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		valueObject.getVisit().setbh_primaryuncodeddiagnosis("pain");
		valueObject.getVisit().saveEx();
		commitEx();

		valueObject.setStepName("Create SO");
		valueObject.setDocumentAction(DocAction.ACTION_Prepare);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		MOrder_BH order = valueObject.getOrder();

		MOrderLine_BH orderLine = new MOrderLine_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		orderLine.setAD_Org_ID(valueObject.getOrg().get_ID());
		orderLine.setDescription(valueObject.getStepMessageLong());
		orderLine.setC_Order_ID(order.get_ID());
		orderLine.setC_Charge_ID(valueObject.getCharge().get_ID());
		orderLine.setC_UOM_ID(valueObject.getProduct().getC_UOM_ID());
		orderLine.setQty(Env.ONE);
		orderLine.setHeaderInfo(order);
		orderLine.setPrice(new BigDecimal(-2));
		orderLine.saveEx();

		valueObject.getOrder().setDocAction(DocAction.ACTION_Complete);
		assertTrue(valueObject.getOrder().processIt(DocAction.ACTION_Complete), "Order completed");
		valueObject.getOrder().saveEx();
		commitEx();

		valueObject.setStepName("Create payment");
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
			TableUtils.getColumnIndex(headerRow, "Patient Donor ");
			int patientClinicIdNumberColumnIndex = TableUtils.getColumnIndex(headerRow, "Patient Clinic ");
			int diagnosisColumnIndex = TableUtils.getColumnIndex(headerRow, "Diagnosis");
			int totalBilledToColumnIndex = TableUtils.getColumnIndex(headerRow, "Total billed to ");

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
}
