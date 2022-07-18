package org.bandahealth.idempiere.report.test;

import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.base.test.BandaCreateEntity;
import org.bandahealth.idempiere.base.test.BandaValueObjectWrapper;
import org.bandahealth.idempiere.report.test.utils.PDFUtils;
import org.bandahealth.idempiere.report.test.utils.TimestampUtils;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.util.Env;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PaymentTrailTest extends ChuBoePopulateFactoryVO {
	private List<MRefList> tenderTypes = new ArrayList<>();

	@IPopulateAnnotation.CanRunBeforeClass
	public void populateTenderTypes() {
		BandaValueObjectWrapper valueObject = new BandaValueObjectWrapper();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMsg(), is(nullValue()));

		tenderTypes = new Query(valueObject.getCtx(), MRefList.Table_Name,
				MReference_BH.Table_Name + "." + MReference_BH.COLUMNNAME_AD_Reference_UU + "=?",
				valueObject.get_trxName()).setParameters(MReference_BH.TENDER_TYPE_AD_REFERENCE_UU).addJoinClause(
				"JOIN " + MReference_BH.Table_Name + " ON " + MReference_BH.Table_Name + "." +
						MReference_BH.COLUMNNAME_AD_Reference_ID + "=" + MRefList.Table_Name + "." +
						MRefList.COLUMNNAME_AD_Reference_ID).list();
	}

	@IPopulateAnnotation.CanRun
	public void canRunReport() throws SQLException, IOException, ParseException {
		BandaValueObjectWrapper valueObject = new BandaValueObjectWrapper();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMsg(), is(nullValue()));

		BigDecimal visitCharge = new BigDecimal(100);
		BigDecimal visitPayment = new BigDecimal(50);
		BigDecimal debtPayment = new BigDecimal(20);

		valueObject.setStepName("Create business partner");
		valueObject.setStdPriceSO(visitCharge);
		BandaCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create product");
		BandaCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create order for a previous day");
		valueObject.setDate(TimestampUtils.today());
		valueObject.setDateOffset(-1);
		valueObject.setDocAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		BandaCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create payment");
		MRefList tenderTypeToUse = tenderTypes.stream()
				.filter(referenceList -> referenceList.getValue().equalsIgnoreCase(MPayment_BH.TENDERTYPE_Cash)).findFirst()
				.orElse(new MRefList(valueObject.getCtx(), 0, valueObject.get_trxName()));
		MInvoice_BH invoice =
				new Query(valueObject.getCtx(), MInvoice_BH.Table_Name, MInvoice_BH.COLUMNNAME_C_Order_ID + "=?",
						valueObject.get_trxName()).setParameters(valueObject.getOrder().get_ID()).first();
		valueObject.setDocAction(DocumentEngine.ACTION_Prepare);
		valueObject.setInvoice(invoice);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		BandaCreateEntity.createPayment(valueObject);
		valueObject.getPaymentBH().setBH_C_Order_ID(valueObject.getOrder().get_ID());
		valueObject.getPaymentBH().setTenderType(tenderTypeToUse.getValue());
		valueObject.getPaymentBH().setPayAmt(visitPayment);
		valueObject.getPaymentBH().saveEx();

		valueObject.getPaymentBH().setDocAction(MPayment_BH.DOCACTION_Complete);
		valueObject.getPaymentBH().processIt(MPayment_BH.DOCACTION_Complete);
		valueObject.getPaymentBH().saveEx();
		commitEx();

		valueObject.setStepName("Allocate the payment");
		valueObject.getPaymentBH().allocateIt();
		valueObject.getPaymentBH().saveEx();
		commitEx();

		valueObject.setStepName("Create another payment");
		valueObject.setPayment(null);
		valueObject.setDateOffset(1);
		valueObject.setInvoice(invoice);
		valueObject.setDocAction(DocumentEngine.ACTION_Prepare);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		BandaCreateEntity.createPayment(valueObject);
		valueObject.refresh();
		valueObject.getPaymentBH().setTenderType(tenderTypeToUse.getValue());
		valueObject.getPaymentBH().setC_Invoice_ID(0);
		valueObject.getPaymentBH().setPayAmt(debtPayment);
		valueObject.getPaymentBH().saveEx();
		commitEx();

		valueObject.getPaymentBH().setDocAction(MPayment_BH.DOCACTION_Complete);
		valueObject.getPaymentBH().processIt(MPayment_BH.DOCACTION_Complete);
		valueObject.getPaymentBH().saveEx();
		commitEx();

		// TODO: Remove this when we let iDempiere only handle open balance updating
		valueObject.setStepName("Reset BP open balance because it's wrong");
		valueObject.getBP().setTotalOpenBalance();
		valueObject.getBP().saveEx();
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcess_UU("a7ac9f65-45d7-4ae0-80f3-72019de35a4a");
		valueObject.setProcessRecord_ID(0);
		valueObject.setProcessTable_ID(0);
		valueObject.setProcessInfoParams(Collections.singletonList(
				new ProcessInfoParameter("c_bpartner_uu", valueObject.getBP().getC_BPartner_UU(), null, null, null)
		));
		valueObject.setReportType("xlsx");
		BandaCreateEntity.runReport(valueObject);

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
			assertEquals(valueObject.getBP().getTotalOpenBalance().longValue(), totalOpenBalance.longValue(),
					"Total open balance matches what's on the business partner");
		}
	}
}
