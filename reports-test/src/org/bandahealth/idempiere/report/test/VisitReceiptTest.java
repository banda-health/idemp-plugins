package org.bandahealth.idempiere.report.test;

import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.report.test.utils.PDFUtils;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.process.DocumentEngine;
import org.compiere.process.ProcessInfoParameter;
import org.hamcrest.Matchers;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VisitReceiptTest extends ChuBoePopulateFactoryVO {
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
	public void canGenerateReceipt() throws SQLException, IOException {
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
		valueObject.setDocumentAction(DocumentEngine.ACTION_Prepare);
		valueObject.setQuantity(new BigDecimal(50));
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_POSOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create payment");
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		MPayment_BH payment = new MPayment_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		payment.setAD_Org_ID(valueObject.getOrg().get_ID());
		payment.setC_DocType_ID(valueObject.getDocumentType().get_ID());
		payment.setIsReceipt(valueObject.getDocumentType().isSOTrx());
		payment.setDateTrx(valueObject.getDate());
		payment.setC_BPartner_ID(valueObject.getBusinessPartner().get_ID());
		payment.setDescription(valueObject.getStepMessageLong());
		valueObject.setBankAccount(ChuBoeCreateEntity.getBankAccountOfOrganization(valueObject));
		payment.setC_BankAccount_ID(valueObject.getBankAccount().get_ID());
		payment.setPayAmt(new BigDecimal(20));
		payment.setBH_C_Order_ID(valueObject.getOrder().get_ID());
		payment.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		payment.setC_Currency_ID(valueObject.getOrder().getC_Currency_ID());
		payment.saveEx();
		valueObject.setPayment(payment);
		commitEx();

		valueObject.setStepName("Complete the order");
		valueObject.getOrder().setDocAction(MOrder_BH.DOCACTION_Complete);
		valueObject.getOrder().processIt(MOrder_BH.DOCACTION_Complete);
		valueObject.getOrder().saveEx();
		commitEx();

		valueObject.setStepName("Generate the receipt");
		valueObject.setProcessUuid("30dd7243-11c1-4584-af26-5d977d117c84");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Collections.singletonList(
				new ProcessInfoParameter("billId", new BigDecimal(valueObject.getOrder().get_ID()), null, null, null)));
		ChuBoeCreateEntity.runReport(valueObject);

		String receiptContent = PDFUtils.readPdfContent(valueObject.getReport());
		assertThat("Patient's name is on the receipt", receiptContent,
				containsString(valueObject.getBusinessPartner().getName().substring(0, 12)));
		assertThat("Products are included", receiptContent,
				containsString(valueObject.getOrderLine().getName().substring(0, 18)));
		assertThat("Products prices are included", receiptContent,
				containsString(String.valueOf(valueObject.getOrderLine().getLineNetAmt().intValue())));
		assertThat("Payments are included", receiptContent.toLowerCase(), containsString("Cash".toLowerCase()));
		assertThat("Products prices are included", receiptContent,
				containsString(String.valueOf(valueObject.getPayment().getPayAmt().intValue())));
	}

	@IPopulateAnnotation.CanRun
	public void receiptCorrectForReCompletedVisits() throws SQLException, IOException {
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
		valueObject.setQuantity(new BigDecimal(50));
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_POSOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create payment");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Prepare);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		valueObject.setInvoice(
				new Query(valueObject.getContext(), MInvoice_BH.Table_Name, MInvoice_BH.COLUMNNAME_C_Order_ID + "=?",
						valueObject.getTransactionName()).setParameters(valueObject.getOrder().get_ID()).first());
		ChuBoeCreateEntity.createPayment(valueObject);
		valueObject.getPayment().setPayAmt(new BigDecimal(20));
		valueObject.getPayment().setBH_C_Order_ID(valueObject.getOrder().get_ID());
		valueObject.getPayment().setC_Invoice_ID(0);
		valueObject.getPayment().setDocAction(DocAction.ACTION_Complete);
		assertTrue(valueObject.getPayment().processIt(DocAction.ACTION_Complete), "Partial payment was completed");
		valueObject.getPayment().saveEx();
		commitEx();

		valueObject.setStepName("Generate the receipt");
		valueObject.setProcessUuid("30dd7243-11c1-4584-af26-5d977d117c84");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Collections.singletonList(
				new ProcessInfoParameter("billId", new BigDecimal(valueObject.getOrder().get_ID()), null, null, null)));
		ChuBoeCreateEntity.runReport(valueObject);

		String receiptContent = PDFUtils.readPdfContent(valueObject.getReport());
		assertThat("'Outstanding' is on the receipt", receiptContent, containsString("Outstanding"));
		assertThat("'CASH' is on the receipt", receiptContent, containsString("CASH"));
		assertThat("Payment is on the receipt", receiptContent, containsString("20"));
		assertThat("Outstanding balance is on the receipt", receiptContent, containsString("30"));

		valueObject.setStepName("Re-open order");
		List<MPayment_BH> ordersPayments = new Query(valueObject.getContext(), MPayment_BH.Table_Name,
				MPayment_BH.COLUMNNAME_BH_C_Order_ID + "=? AND " + MPayment_BH.COLUMNNAME_DocStatus + "=? AND " +
						MPayment_BH.COLUMNNAME_Reversal_ID + " IS NULL", valueObject.getTransactionName()).setParameters(
				valueObject.getOrder().get_ID(), MPayment_BH.DOCSTATUS_Completed).list();
		valueObject.getOrder().setDocAction(MOrder_BH.DOCACTION_Re_Activate);
		assertTrue(valueObject.getOrder().processIt(MOrder_BH.DOCACTION_Re_Activate), "Order was re-activated");
		valueObject.getOrder().saveEx();
		commitEx();
		valueObject.setPayment(null);

		valueObject.setStepName("Cancel previous payments");
		for (MPayment_BH payment : ordersPayments) {
			MPayment_BH newPayment = payment.copy();
			newPayment.setDocStatus(MPayment_BH.DOCSTATUS_Drafted);
			newPayment.saveEx();

			payment.setDocAction(DocAction.ACTION_Reverse_Accrual);
			assertTrue(payment.processIt(DocAction.ACTION_Reverse_Accrual), "Old payment was reversed");
			payment.saveEx();
		}
		commitEx();
		valueObject.refresh();

		valueObject.setPayment(new Query(valueObject.getContext(), MPayment_BH.Table_Name,
				MPayment_BH.COLUMNNAME_BH_C_Order_ID + "=? AND " + MPayment_BH.COLUMNNAME_DocStatus + "=?",
				valueObject.getTransactionName()).setParameters(valueObject.getOrder().get_ID(), MPayment_BH.DOCSTATUS_Drafted)
				.first());
		valueObject.refresh();

		valueObject.setStepName("Re-complete order");
		valueObject.getOrder().setDocAction(MOrder_BH.DOCACTION_Complete);
		assertTrue(valueObject.getOrder().processIt(MOrder_BH.DOCACTION_Complete), "Sales order was re-completed");
		commitEx();

		valueObject.setStepName("Change payment");
		valueObject.getPayment().setTenderType(MPayment_BH.TENDERTYPE_MPesa);
		valueObject.getPayment().setPayAmt(new BigDecimal(21));
		valueObject.getPayment().saveEx();
		valueObject.getPayment().setDocAction(DocAction.ACTION_Complete);
		assertTrue(valueObject.getPayment().processIt(DocAction.ACTION_Complete), "Partial payment was re-completed");
		commitEx();

		valueObject.setStepName("Regenerate the receipt");
		valueObject.setProcessUuid("30dd7243-11c1-4584-af26-5d977d117c84");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setProcessInformationParameters(Collections.singletonList(
				new ProcessInfoParameter("billId", new BigDecimal(valueObject.getOrder().get_ID()), null, null, null)));
		ChuBoeCreateEntity.runReport(valueObject);

		receiptContent = PDFUtils.readPdfContent(valueObject.getReport());
		assertThat("'Outstanding' is still on the receipt", receiptContent, containsString("Outstanding"));
		assertThat("'MOBILE MONEY' is on the receipt", receiptContent, containsString("MOBILE MONEY"));
		assertThat("Payment is on the receipt", receiptContent, containsString("21"));
		assertThat("Outstanding balance is on the receipt", receiptContent, containsString("29"));
	}
}
