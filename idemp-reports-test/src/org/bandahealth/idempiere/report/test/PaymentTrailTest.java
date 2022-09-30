package org.bandahealth.idempiere.report.test;

import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.report.test.utils.TimestampUtils;
import org.compiere.model.Query;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfoParameter;
import org.hamcrest.Matchers;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PaymentTrailTest extends ChuBoePopulateFactoryVO {
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

		valueObject.setStepName("Create order for a previous day");
		valueObject.setDate(TimestampUtils.today());
		valueObject.setDateOffset(-1);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create payment");
		MInvoice_BH invoice =
				new Query(valueObject.getContext(), MInvoice_BH.Table_Name, MInvoice_BH.COLUMNNAME_C_Order_ID + "=?",
						valueObject.getTransactionName()).setParameters(valueObject.getOrder().get_ID()).first();
		valueObject.setDocumentAction(DocumentEngine.ACTION_Prepare);
		valueObject.setInvoice(invoice);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		ChuBoeCreateEntity.createPayment(valueObject);
		valueObject.getPayment().setBH_C_Order_ID(valueObject.getOrder().get_ID());
		valueObject.getPayment().setPayAmt(visitPayment);
		valueObject.getPayment().saveEx();

		valueObject.getPayment().setDocAction(MPayment_BH.DOCACTION_Complete);
		valueObject.getPayment().processIt(MPayment_BH.DOCACTION_Complete);
		valueObject.getPayment().saveEx();
		commitEx();

		valueObject.setStepName("Allocate the payment");
		valueObject.getPayment().allocateIt();
		valueObject.getPayment().saveEx();
		commitEx();

		valueObject.setStepName("Create another payment");
		valueObject.setPayment(null);
		valueObject.setDateOffset(1);
		valueObject.setInvoice(invoice);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Prepare);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		ChuBoeCreateEntity.createPayment(valueObject);
		valueObject.refresh();
		valueObject.getPayment().setTenderType(MPayment_BH.TENDERTYPE_Cash);
		valueObject.getPayment().setC_Invoice_ID(0);
		valueObject.getPayment().setPayAmt(debtPayment);
		valueObject.getPayment().saveEx();
		commitEx();

		valueObject.getPayment().setDocAction(MPayment_BH.DOCACTION_Complete);
		valueObject.getPayment().processIt(MPayment_BH.DOCACTION_Complete);
		valueObject.getPayment().saveEx();
		commitEx();

		// TODO: Remove this when we let iDempiere only handle open balance updating
		valueObject.setStepName("Reset BP open balance because it's wrong");
		valueObject.getBusinessPartner().setTotalOpenBalance();
		valueObject.getBusinessPartner().saveEx();
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("a7ac9f65-45d7-4ae0-80f3-72019de35a4a");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Collections.singletonList(
				new ProcessInfoParameter("c_bpartner_uu", valueObject.getBusinessPartner().getC_BPartner_UU(), null, null, null)
		));
		valueObject.setReportType("xlsx");
		ChuBoeCreateEntity.runReport(valueObject);

		FileInputStream file = new FileInputStream(valueObject.getReport());
		try (Workbook workbook = new XSSFWorkbook(file)) {
			Sheet sheet = workbook.getSheetAt(0);
			int rowIndex = 0;
			int headerRowIndex = -1;
			for (Row row : sheet) {
				if (row.getCell(0).getStringCellValue().equalsIgnoreCase("Name")) {
					headerRowIndex = rowIndex;
					break;
				}
				rowIndex++;
			}

			NumberFormat numberFormat = NumberFormat.getInstance();

			assertTrue(headerRowIndex >= 0, "Header row exists");
			assertThat("Starting balance appears", sheet.getRow(headerRowIndex + 1).getCell(2).getStringCellValue(),
					containsStringIgnoringCase("Starting Balance"));
			assertThat("Starting balance is zero",
					numberFormat.parse(sheet.getRow(headerRowIndex + 1).getCell(6).getStringCellValue().trim()), is(0L));

			assertThat("Visit payment information appears", sheet.getRow(headerRowIndex + 2).getCell(2).getStringCellValue(),
					containsStringIgnoringCase("Visit Charges and payments"));
			assertThat("Visit charge is correct",
					numberFormat.parse(sheet.getRow(headerRowIndex + 2).getCell(3).getStringCellValue()),
					is(visitCharge.longValue()));
			assertThat("Visit payment is correct",
					numberFormat.parse(sheet.getRow(headerRowIndex + 2).getCell(4).getStringCellValue()),
					is(visitPayment.longValue()));
			assertThat("Debt payment is correct",
					numberFormat.parse(sheet.getRow(headerRowIndex + 2).getCell(5).getStringCellValue()),
					is(debtPayment.longValue()));
			BigDecimal totalOpenBalance = visitCharge.subtract(visitPayment).subtract(debtPayment);
			assertThat("Open balance is correct",
					numberFormat.parse(sheet.getRow(headerRowIndex + 2).getCell(6).getStringCellValue()),
					is(totalOpenBalance.longValue()));

			valueObject.refresh();
			assertEquals(valueObject.getBusinessPartner().getTotalOpenBalance().longValue(), totalOpenBalance.longValue(),
					"Total open balance matches what's on the business partner");
		}
	}
}
