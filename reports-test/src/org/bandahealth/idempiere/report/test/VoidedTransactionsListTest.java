package org.bandahealth.idempiere.report.test;

import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bandahealth.idempiere.base.model.MBHVoidedReason;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.report.test.utils.TimestampUtils;
import org.compiere.model.Query;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.util.DB;
import org.hamcrest.Matchers;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VoidedTransactionsListTest extends ChuBoePopulateFactoryVO {
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
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		valueObject.getBusinessPartner().setName(String.valueOf(valueObject.getRandomNumber()));
		valueObject.getBusinessPartner().saveEx();
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

		valueObject.setStepName("Create payment");
		MInvoice_BH invoice =
				new Query(valueObject.getContext(), MInvoice_BH.Table_Name, MInvoice_BH.COLUMNNAME_C_Order_ID + "=?",
						valueObject.getTransactionName()).setParameters(valueObject.getOrder().get_ID()).first();
		valueObject.setInvoice(invoice);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

//		PO.setCrossTenantSafe();
		MBHVoidedReason voidedReason = new Query(valueObject.getContext(), MBHVoidedReason.Table_Name, null,
				valueObject.getTransactionName()).setOnlyActiveRecords(true).first();
//		PO.clearCrossTenantSafe();
		assertTrue(!voidedReason.getName().isEmpty() && !voidedReason.getName().isBlank(), "Voiding reason has a name");

		valueObject.setStepName("Void order");
		valueObject.refresh();
		valueObject.getOrder().setBH_Voided_Reason_ID(voidedReason.get_ID());
		valueObject.getOrder().setDocAction(MOrder_BH.DOCACTION_Void);
		valueObject.getOrder().processIt(MOrder_BH.DOCACTION_Void);
		valueObject.getOrder().saveEx();
		commitEx();

		valueObject.setStepName("Reverse payment");
		valueObject.getPayment().setDocAction(MPayment_BH.DOCACTION_Reverse_Accrual);
		assertTrue(valueObject.getPayment().processIt(MPayment_BH.DOCACTION_Reverse_Accrual), "Payment was reversed");
		valueObject.getPayment().saveEx();
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("20a623fb-e127-4c26-98d5-3604a6d100b2");
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
			Optional<Row> patientRow =
					StreamSupport.stream(sheet.spliterator(), false).filter(row -> row.getCell(1) != null &&
									row.getCell(1).getStringCellValue().equalsIgnoreCase(valueObject.getBusinessPartner().getName()))
							.findFirst();

			assertTrue(patientRow.isPresent(), "Voided record exists");
			assertThat("Voided reason is present", patientRow.get().getCell(4).getStringCellValue(),
					containsStringIgnoringCase(voidedReason.getName()));
		}
	}

	@IPopulateAnnotation.CanRun
	public void dateTimeFiltersWork() throws SQLException, IOException, ParseException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		valueObject.getBusinessPartner().setName(String.valueOf(valueObject.getRandomNumber()));
		valueObject.getBusinessPartner().saveEx();
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		Timestamp earlyDate = TimestampUtils.startOfYesterday();
		Timestamp beginDate = TimestampUtils.add(earlyDate, Calendar.HOUR, 2);
		Timestamp endDate = TimestampUtils.addToNow(Calendar.DAY_OF_YEAR, 2);

		valueObject.setStepName("Create visit");
		valueObject.setDate(earlyDate);
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
		valueObject.setInvoice(invoice);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

//		PO.setCrossTenantSafe();
		MBHVoidedReason voidedReason = new Query(valueObject.getContext(), MBHVoidedReason.Table_Name, null,
				valueObject.getTransactionName()).setOnlyActiveRecords(true).first();
//		PO.clearCrossTenantSafe();
		assertTrue(!voidedReason.getName().isEmpty() && !voidedReason.getName().isBlank(), "Voiding reason has a name");

		valueObject.setStepName("Void order");
		valueObject.refresh();
		valueObject.getOrder().setBH_Voided_Reason_ID(voidedReason.get_ID());
		valueObject.getOrder().setDocAction(MOrder_BH.DOCACTION_Void);
		valueObject.getOrder().processIt(MOrder_BH.DOCACTION_Void);
		valueObject.getOrder().saveEx();
		commitEx();

		valueObject.setStepName("Reverse payment");
		valueObject.getPayment().setDocAction(MPayment_BH.DOCACTION_Reverse_Accrual);
		assertTrue(valueObject.getPayment().processIt(MPayment_BH.DOCACTION_Reverse_Accrual), "Payment was reversed");
		valueObject.getPayment().saveEx();
		commitEx();

		valueObject.setStepName("Update the updated date of the voided order");
		SimpleDateFormat dbDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		DB.executeUpdate("UPDATE c_order SET updated = '" + dbDateFormat.format(earlyDate) + "' WHERE c_order_id = " +
				valueObject.getOrder().get_ID(), valueObject.getTransactionName());
		commitEx();

		valueObject.setStepName("Create visit");
		valueObject.setDate(TimestampUtils.today());
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create payment");
		invoice =
				new Query(valueObject.getContext(), MInvoice_BH.Table_Name, MInvoice_BH.COLUMNNAME_C_Order_ID + "=?",
						valueObject.getTransactionName()).setParameters(valueObject.getOrder().get_ID()).first();
		valueObject.setInvoice(invoice);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

//		PO.setCrossTenantSafe();
		voidedReason = new Query(valueObject.getContext(), MBHVoidedReason.Table_Name, null,
				valueObject.getTransactionName()).setOnlyActiveRecords(true).first();
//		PO.clearCrossTenantSafe();
		assertTrue(!voidedReason.getName().isEmpty() && !voidedReason.getName().isBlank(), "Voiding reason has a name");

		valueObject.setStepName("Void order");
		valueObject.refresh();
		valueObject.getOrder().setBH_Voided_Reason_ID(voidedReason.get_ID());
		valueObject.getOrder().setDocAction(MOrder_BH.DOCACTION_Void);
		valueObject.getOrder().processIt(MOrder_BH.DOCACTION_Void);
		valueObject.getOrder().saveEx();
		commitEx();

		valueObject.setStepName("Reverse payment");
		valueObject.getPayment().setDocAction(MPayment_BH.DOCACTION_Reverse_Accrual);
		assertTrue(valueObject.getPayment().processIt(MPayment_BH.DOCACTION_Reverse_Accrual), "Payment was reversed");
		valueObject.getPayment().saveEx();
		commitEx();

		valueObject.setStepName("Generate the report");
		valueObject.setProcessUuid("20a623fb-e127-4c26-98d5-3604a6d100b2");
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
			List<Row> patientRows =
					StreamSupport.stream(sheet.spliterator(), false).filter(row -> row.getCell(1) != null &&
									row.getCell(1).getStringCellValue().equalsIgnoreCase(valueObject.getBusinessPartner().getName()))
							.collect(Collectors.toList());

			assertEquals(1, patientRows.size(), "Only one voided visit appears");
			assertThat("Voided reason is present", patientRows.get(0).getCell(4).getStringCellValue(),
					containsStringIgnoringCase(voidedReason.getName()));
		}
	}
}
