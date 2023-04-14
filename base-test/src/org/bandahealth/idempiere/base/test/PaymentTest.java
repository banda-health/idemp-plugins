package org.bandahealth.idempiere.base.test;

import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.compiere.process.DocumentEngine;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PaymentTest extends ChuBoePopulateFactoryVO {
	@IPopulateAnnotation.CanRun
	public void allocationsForReceiptAreCorrectForOldInvoices() throws Exception {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create product");
		valueObject.setSalesPrice(new BigDecimal(100));
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create first sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create partial payment for first sales order");
		int firstInvoicesId = valueObject.getOrder().getInvoices()[0].get_ID();
		valueObject.setInvoice(
				new MInvoice_BH(valueObject.getContext(), firstInvoicesId, valueObject.getTransactionName()));
		valueObject.setDocumentAction(null);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		ChuBoeCreateEntity.createPayment(valueObject);
		valueObject.getPayment().setPayAmt(new BigDecimal(50));
		valueObject.getPayment().setC_Invoice_ID(0); // we associate to invoices through the allocation
		valueObject.getPayment().setBH_C_Order_ID(valueObject.getOrder().get_ID());
		valueObject.getPayment().setDocAction(MOrder_BH.DOCACTION_Complete);
		assertTrue(valueObject.getPayment().processIt(MOrder_BH.DOCACTION_Complete));
		valueObject.getPayment().saveEx();
		commitEx();

		assertTrue(valueObject.getPayment().isAllocated(), "First payment is allocated");
		MInvoice_BH firstInvoice =
				new MInvoice_BH(valueObject.getContext(), firstInvoicesId, valueObject.getTransactionName());
		assertFalse(firstInvoice.isPaid(), "First invoice isn't paid");
		assertEquals(0,
				firstInvoice.getGrandTotal().subtract(firstInvoice.getAllocatedAmt()).compareTo(new BigDecimal(50)),
				"First invoice has the correct amount remaining to allocate");
		assertEquals(0, new MBPartner_BH(valueObject.getContext(), valueObject.getBusinessPartner().get_ID(),
						valueObject.getTransactionName()).getTotalOpenBalance().compareTo(new BigDecimal(50)),
				"BP open balance correct after first sales order");

		valueObject.setStepName("Create second sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create partial payment for second sales order");
		int secondInvoicesId = valueObject.getOrder().getInvoices()[0].get_ID();
		valueObject.setInvoice(
				new MInvoice_BH(valueObject.getContext(), secondInvoicesId, valueObject.getTransactionName()));
		valueObject.setDocumentAction(null);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		ChuBoeCreateEntity.createPayment(valueObject);
		valueObject.getPayment().setPayAmt(new BigDecimal(60));
		valueObject.getPayment().setC_Invoice_ID(0); // we associate to invoices through the allocation
		valueObject.getPayment().setBH_C_Order_ID(valueObject.getOrder().get_ID());
		valueObject.getPayment().setDocAction(MOrder_BH.DOCACTION_Complete);
		assertTrue(valueObject.getPayment().processIt(MOrder_BH.DOCACTION_Complete));
		valueObject.getPayment().saveEx();
		commitEx();

		assertTrue(valueObject.getPayment().isAllocated(), "Second payment is allocated");
		MInvoice_BH secondInvoice =
				new MInvoice_BH(valueObject.getContext(), secondInvoicesId, valueObject.getTransactionName());
		assertFalse(secondInvoice.isPaid(), "Second invoice isn't paid");
		assertEquals(0,
				secondInvoice.getGrandTotal().subtract(secondInvoice.getAllocatedAmt()).compareTo(new BigDecimal(40)),
				"Second invoice has the correct amount remaining to allocate");
		assertEquals(0, new MBPartner_BH(valueObject.getContext(), valueObject.getBusinessPartner().get_ID(),
						valueObject.getTransactionName()).getTotalOpenBalance().compareTo(new BigDecimal(90)),
				"BP open balance correct after second sales order");

		valueObject.setStepName("Create third sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create open-debt payment for some of current balance");
		int thirdInvoicesId = valueObject.getOrder().getInvoices()[0].get_ID();
		valueObject.setInvoice(
				new MInvoice_BH(valueObject.getContext(), thirdInvoicesId, valueObject.getTransactionName()));
		valueObject.setDocumentAction(null);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		ChuBoeCreateEntity.createPayment(valueObject);
		valueObject.getPayment().setPayAmt(new BigDecimal(150));
		valueObject.getPayment().setC_Invoice_ID(0); // we associate to invoices through the allocation
		valueObject.getPayment().setBH_C_Order_ID(0);
		valueObject.getPayment().setDocAction(MOrder_BH.DOCACTION_Complete);
		assertTrue(valueObject.getPayment().processIt(MOrder_BH.DOCACTION_Complete));
		valueObject.getPayment().saveEx();
		commitEx();

		assertTrue(valueObject.getPayment().isAllocated(), "Third payment is allocated");
		firstInvoice = new MInvoice_BH(valueObject.getContext(), firstInvoicesId, valueObject.getTransactionName());
		assertTrue(firstInvoice.isPaid(), "First invoice is paid");
		assertEquals(0, firstInvoice.getGrandTotal().subtract(firstInvoice.getAllocatedAmt()).signum(),
				"First invoice is fully paid");

		secondInvoice = new MInvoice_BH(valueObject.getContext(), secondInvoicesId, valueObject.getTransactionName());
		assertTrue(secondInvoice.isPaid(), "Second invoice is paid");
		assertEquals(0, secondInvoice.getGrandTotal().subtract(secondInvoice.getAllocatedAmt()).signum(),
				"Second invoice is fully paid");

		MInvoice_BH thirdInvoice =
				new MInvoice_BH(valueObject.getContext(), thirdInvoicesId, valueObject.getTransactionName());
		assertFalse(thirdInvoice.isPaid(), "Third invoice is not paid");
		assertEquals(0,
				thirdInvoice.getGrandTotal().subtract(thirdInvoice.getAllocatedAmt()).compareTo(new BigDecimal(40)),
				"Third invoice has the correct remaining amount");

		valueObject.refresh();
		assertEquals(0, valueObject.getBusinessPartner().getTotalOpenBalance().compareTo(new BigDecimal(40)),
				"Business partner has the correct open balance");
	}
}
