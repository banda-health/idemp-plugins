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
import org.bandahealth.idempiere.base.model.MOrgInfo_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.report.test.utils.TableUtils;
import org.bandahealth.idempiere.report.test.utils.TimestampUtils;
import org.compiere.model.Query;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfoParameter;
import org.hamcrest.Matchers;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OpenBalanceInvoiceTest extends ChuBoePopulateFactoryVO {
	private final String reportUuid = "199f56a6-8e1f-47b4-8f22-e2bdb8da7505";

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

		valueObject.setStepName("Create purchase order for a previous day");
		valueObject.setDate(TimestampUtils.today());
		valueObject.setDateOffset(-5);
		valueObject.setQuantity(new BigDecimal(100));
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setQuantity(BigDecimal.ONE);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create debt payment");
		valueObject.setVisit(null);
		valueObject.setOrder(null);
		valueObject.setInvoice(null);
		valueObject.setDateOffset(1);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		valueObject.setPaymentAmount(visitCharge);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		valueObject.setStepName("Create second visit");
		valueObject.setDateOffset(5);
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
			Row headerRow = TableUtils.getHeaderRow(sheet, "Date");

			int chargesColumnIndex = TableUtils.getColumnIndex(headerRow, "Charges");
			int paymentsColumnIndex = TableUtils.getColumnIndex(headerRow, "Payments");
			int openBalanceColumnIndex = TableUtils.getColumnIndex(headerRow, "Open Balance");

			int headerRowIndex = TableUtils.getIndexOfRow(sheet, headerRow);
			List<Row> tableRows = new ArrayList<>();
			double totalOpenBalance = 0d;
			for (int i = headerRowIndex + 1; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				if (row != null && row.getCell(paymentsColumnIndex) != null &&
						row.getCell((paymentsColumnIndex)).getCellType().equals(CellType.STRING) &&
						row.getCell(paymentsColumnIndex).getStringCellValue().contains("TOTAL OPEN ")) {
					totalOpenBalance = row.getCell(openBalanceColumnIndex).getNumericCellValue();
					break;
				}
				tableRows.add(row);
			}

			assertThat("Only two rows exists for patient on report", tableRows.size(), is(2));

			assertThat("Visit charge is correct", tableRows.get(0).getCell(chargesColumnIndex).getNumericCellValue(),
					is(visitCharge.doubleValue()));
			assertThat("Visit payment is correct", tableRows.get(0).getCell(paymentsColumnIndex).getNumericCellValue(),
					is(visitPayment.doubleValue()));
			assertThat("Visit difference is correct", tableRows.get(0).getCell(openBalanceColumnIndex).getNumericCellValue(),
					is(visitCharge.doubleValue() - visitPayment.doubleValue()));

			assertThat("Debt payment charge is correct", tableRows.get(1).getCell(chargesColumnIndex).getNumericCellValue(),
					is(0d));
			assertThat("Charge payment is correct", tableRows.get(1).getCell(paymentsColumnIndex).getNumericCellValue(),
					is(debtPayment.doubleValue()));
			double reportTotalOpenBalance =
					visitCharge.doubleValue() - visitPayment.doubleValue() - debtPayment.doubleValue();
			assertThat("Visit difference is correct", tableRows.get(1).getCell(openBalanceColumnIndex).getNumericCellValue(),
					is(reportTotalOpenBalance));
			assertThat("Total open balance is correct", reportTotalOpenBalance, is(totalOpenBalance));

			valueObject.refresh();
			assertEquals(valueObject.getBusinessPartner().getTotalOpenBalance().doubleValue(), totalOpenBalance,
					"Total open balance matches what's on the business partner");
		}
	}

	@IPopulateAnnotation.CanRun
	public void invoiceShowsTheCorrectClinicAndPatientInformation() throws SQLException, IOException, ParseException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		ChuBoeCreateEntity.changeOrganization(valueObject);

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		valueObject.getBusinessPartner().setAD_Org_ID(valueObject.getOrg().getAD_Org_ID());
		valueObject.getBusinessPartner().setBH_Phone(String.valueOf(valueObject.getRandomNumber()));
		valueObject.getBusinessPartner().saveEx();
		commitEx();

		valueObject.setStepName("Update clinic phone");
		valueObject.setRandom();
		MOrgInfo_BH clinicInfo =
				new Query(valueObject.getContext(), MOrgInfo_BH.Table_Name, MOrgInfo_BH.COLUMNNAME_AD_Org_ID + "=?",
						valueObject.getTransactionName()).setParameters(valueObject.getOrg().get_ID()).first();
		clinicInfo.setPhone(String.valueOf(valueObject.getRandomNumber()));
		clinicInfo.saveEx();
		commitEx();

		valueObject.setStepName("Create product");
		valueObject.setRandom();
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

			Optional<Row> clinicPhoneRow = StreamSupport.stream(sheet.spliterator(), false).filter(
					row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
							cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
									cell.getStringCellValue().equals("TEL:  " + clinicInfo.getPhone()))).findFirst();
			Optional<Row> patientPhoneRow = StreamSupport.stream(sheet.spliterator(), false).filter(
							row -> StreamSupport.stream(row.spliterator(), false).anyMatch(
									cell -> cell != null && cell.getCellType().equals(CellType.STRING) &&
											cell.getStringCellValue().equals("Phone:  " + valueObject.getBusinessPartner().getBH_Phone())))
					.findFirst();

			assertTrue(clinicPhoneRow.isPresent(), "Clinic phone number is displayed");
			assertTrue(patientPhoneRow.isPresent(), "Patient phone number is displayed");
		}
	}
}
