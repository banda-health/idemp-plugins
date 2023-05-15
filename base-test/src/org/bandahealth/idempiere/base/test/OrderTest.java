package org.bandahealth.idempiere.base.test;

import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.compiere.model.MInvoice;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.process.DocumentEngine;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderTest extends ChuBoePopulateFactoryVO {
	@IPopulateAnnotation.CanRun
	public void businessPartnerOpenBalanceIsCorrectWhenManipulatingASalesOrder() throws Exception {
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

		MInvoice[] ordersInvoices = valueObject.getOrder().getInvoices();
		assertEquals(1, ordersInvoices.length, "Invoice is automatically created");
		MInvoice completedInvoice = ordersInvoices[0];
		assertTrue(completedInvoice.getDocStatus().equalsIgnoreCase(MInvoice_BH.DOCSTATUS_Completed),
				"Invoice is completed");
		valueObject.setInvoice(
				new MInvoice_BH(valueObject.getContext(), completedInvoice.get_ID(), valueObject.getTransactionName()));
		valueObject.refresh();

		assertEquals(0, BigDecimal.TEN.compareTo(valueObject.getBusinessPartner().getTotalOpenBalance()),
				"Business partner has an open balance");

		valueObject.setStepName("Create payments");
		valueObject.setInvoice(null);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		valueObject.setPaymentAmount(new BigDecimal(5));
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		valueObject.setTenderType(MPayment_BH.TENDERTYPE_MPesa);
		valueObject.setPaymentAmount(new BigDecimal(5));
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		valueObject.refresh();

		assertEquals(0, BigDecimal.ZERO.compareTo(valueObject.getBusinessPartner().getTotalOpenBalance()),
				"Business partner's open balance is zero");

		valueObject.setStepName("Re-open the order");
		List<MPayment_BH> visitsPayments = new Query(valueObject.getContext(), MPayment_BH.Table_Name,
				MPayment_BH.COLUMNNAME_BH_Visit_ID + "=? AND " + MPayment_BH.COLUMNNAME_DocStatus + "=? AND " +
						MPayment_BH.COLUMNNAME_Reversal_ID + " IS NULL", valueObject.getTransactionName()).setParameters(
						valueObject.getOrder().getBH_Visit_ID(), MPayment_BH.DOCSTATUS_Completed)
				.setOrderBy(MPayment_BH.COLUMNNAME_C_Payment_ID + " ASC").list();
		valueObject.getOrder().setDocAction(MOrder_BH.DOCACTION_Re_Activate);
		assertTrue(valueObject.getOrder().processIt(MOrder_BH.DOCACTION_Re_Activate));
		valueObject.getOrder().saveEx();
		commitEx();
		valueObject.setPayment(null);

		valueObject.setStepName("Cancel previous payments");
		for (MPayment_BH payment : visitsPayments) {
			MPayment_BH newPayment = payment.copy();
			newPayment.setDocStatus(MPayment_BH.DOCSTATUS_Drafted);
			newPayment.saveEx();

			payment.setDocAction(DocAction.ACTION_Reverse_Accrual);
			assertTrue(payment.processIt(DocAction.ACTION_Reverse_Accrual), "Old payment was reversed");
			payment.saveEx();
		}
		commitEx();
		valueObject.refresh();

		ordersInvoices = valueObject.getOrder().getInvoices();
		assertEquals(2, ordersInvoices.length, "Only one new invoice created after reversal for the reverse");
		assertTrue(Arrays.stream(ordersInvoices)
						.allMatch(invoice -> invoice.getDocStatus().equalsIgnoreCase(MInvoice_BH.DOCSTATUS_Reversed)),
				"All order's invoices are reversed");
		assertEquals(0, BigDecimal.ZERO.compareTo(valueObject.getBusinessPartner().getTotalOpenBalance()),
				"Business partner no longer has an open balance");

		visitsPayments =
				new Query(valueObject.getContext(), MPayment_BH.Table_Name, MPayment_BH.COLUMNNAME_BH_Visit_ID + "=?",
						valueObject.getTransactionName()).setParameters(valueObject.getOrder().getBH_Visit_ID())
						.setOrderBy(MPayment_BH.COLUMNNAME_C_Payment_ID + " DESC").list();
		assertEquals(4, visitsPayments.stream()
				.filter(payment -> payment.getDocStatus().equalsIgnoreCase(MPayment_BH.DOCSTATUS_Reversed))
				.collect(Collectors.toSet()).size(), "Order has the original reversed payments");
		assertEquals(2, visitsPayments.stream()
				.filter(payment -> payment.getDocStatus().equalsIgnoreCase(MPayment_BH.DOCSTATUS_Drafted))
				.collect(Collectors.toSet()).size(), "Order has new payments");

		// Filter out the reversed payments
		visitsPayments = visitsPayments.stream().filter(payment -> payment.getPayAmt().compareTo(BigDecimal.ZERO) > 0)
				.sorted(Comparator.comparingInt(PO::get_ID)).collect(Collectors.toList());
		// Second re-created payment
		MPayment_BH paymentToCheck = visitsPayments.get(3);
		assertTrue(paymentToCheck.getTenderType().equalsIgnoreCase(MPayment_BH.TENDERTYPE_MPesa),
				"Second payment tender type is correct");
		assertEquals(new BigDecimal(5), paymentToCheck.getPayAmt(), "Second payment amount is correct");
		assertTrue(!paymentToCheck.getDocStatus().equalsIgnoreCase(MPayment_BH.DOCSTATUS_Completed) &&
						!paymentToCheck.getDocStatus().equalsIgnoreCase(MPayment_BH.DOCSTATUS_Reversed),
				"Second payment document status isn't completed or reversed");
		// First re-created payment
		paymentToCheck = visitsPayments.get(2);
		assertTrue(paymentToCheck.getTenderType().equalsIgnoreCase(MPayment_BH.TENDERTYPE_Cash),
				"First payment tender type is correct");
		assertEquals(new BigDecimal(5), paymentToCheck.getPayAmt(), "First payment amount is correct");
		assertTrue(!paymentToCheck.getDocStatus().equalsIgnoreCase(MPayment_BH.DOCSTATUS_Completed) &&
						!paymentToCheck.getDocStatus().equalsIgnoreCase(MPayment_BH.DOCSTATUS_Reversed),
				"First payment document status isn't completed or reversed");
		// Second original payment
		paymentToCheck = visitsPayments.get(1);
		assertTrue(paymentToCheck.getTenderType().equalsIgnoreCase(MPayment_BH.TENDERTYPE_MPesa),
				"Second original payment tender type is correct");
		assertEquals(new BigDecimal(5), paymentToCheck.getPayAmt(), "Second original payment amount is correct");
		assertTrue(paymentToCheck.getDocStatus().equalsIgnoreCase(MPayment_BH.DOCSTATUS_Reversed),
				"Second original payment document status isn't completed or reversed");
		// First original payment
		paymentToCheck = visitsPayments.get(0);
		assertTrue(paymentToCheck.getTenderType().equalsIgnoreCase(MPayment_BH.TENDERTYPE_Cash),
				"First original payment tender type is correct");
		assertEquals(new BigDecimal(5), paymentToCheck.getPayAmt(), "First original payment amount is correct");
		assertTrue(paymentToCheck.getDocStatus().equalsIgnoreCase(MPayment_BH.DOCSTATUS_Reversed),
				"First original payment document status isn't completed or reversed");
	}
}
