package org.bandahealth.idempiere.base.test;

import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.compiere.process.DocumentEngine;
import org.hamcrest.Matchers;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PaymentTest extends ChuBoePopulateFactoryVO {

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

		valueObject.setStepName("Create purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(new BigDecimal(100));
		ChuBoeCreateEntity.createOrder(valueObject);
		valueObject.setQuantity(null);
		commitEx();

		valueObject.setStepName("Create first visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create first sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create partial payment for first sales order");
		int firstInvoicesId = valueObject.getOrder().getInvoices()[0].get_ID();
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		valueObject.setPaymentAmount(new BigDecimal(50));
		ChuBoeCreateEntity.createPayment(valueObject);
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

		valueObject.setStepName("Create second visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create second sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create partial payment for second sales order");
		int secondInvoicesId = valueObject.getOrder().getInvoices()[0].get_ID();
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		valueObject.setPaymentAmount(new BigDecimal(60));
		ChuBoeCreateEntity.createPayment(valueObject);
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

		valueObject.setStepName("Create third visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create third sales order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create open-debt payment for some of current balance");
		int thirdInvoicesId = valueObject.getOrder().getInvoices()[0].get_ID();
		valueObject.setVisit(null);
		valueObject.setOrder(null);
		valueObject.setInvoice(null);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		valueObject.setPaymentAmount(new BigDecimal(150));
		ChuBoeCreateEntity.createPayment(valueObject);
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

	@IPopulateAnnotation.CanRun
	public void allocationsWorkWhenInvoiceHasFutureAccountDate() throws Exception {
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

		valueObject.setStepName("Create purchase order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_PurchaseOrder, null, false, false, false);
		valueObject.setQuantity(BigDecimal.TEN);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create first visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create first sales order");
		valueObject.setDateOffset(1);
		valueObject.setQuantity(BigDecimal.ONE);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create partial payment for first sales order");
		MInvoice_BH firstInvoice =
				new MInvoice_BH(valueObject.getContext(), valueObject.getOrder().getInvoices()[0].get_ID(),
						valueObject.getTransactionName());
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDateOffset(-1);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		valueObject.setPaymentAmount(new BigDecimal(50));
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		assertTrue(valueObject.getPayment().isAllocated(), "First payment is allocated");
		assertFalse(firstInvoice.isPaid(), "First invoice isn't paid");
		assertEquals(0,
				firstInvoice.getGrandTotal().subtract(firstInvoice.getAllocatedAmt()).compareTo(new BigDecimal(50)),
				"First invoice has the correct amount remaining to allocate");
		assertEquals(0, new MBPartner_BH(valueObject.getContext(), valueObject.getBusinessPartner().get_ID(),
						valueObject.getTransactionName()).getTotalOpenBalance().compareTo(new BigDecimal(50)),
				"BP open balance correct after first sales order");

		valueObject.setStepName("Create second visit");
		ChuBoeCreateEntity.createVisit(valueObject);
		commitEx();

		valueObject.setStepName("Create second sales order");
		valueObject.setDateOffset(10);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();
		MInvoice_BH secondInvoice =
				new MInvoice_BH(valueObject.getContext(), valueObject.getOrder().getInvoices()[0].get_ID(),
						valueObject.getTransactionName());

		valueObject.setStepName("Create open-debt payment for all of the current balance");
		valueObject.setDateOffset(-15);
		valueObject.setVisit(null);
		valueObject.setOrder(null);
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		valueObject.setPaymentAmount(new BigDecimal(150));
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		assertTrue(valueObject.getPayment().isAllocated(), "Third payment is allocated");
		firstInvoice = new MInvoice_BH(valueObject.getContext(), firstInvoice.get_ID(), valueObject.getTransactionName());
		assertTrue(firstInvoice.isPaid(), "First invoice is paid");
		assertEquals(0, firstInvoice.getGrandTotal().subtract(firstInvoice.getAllocatedAmt()).signum(),
				"First invoice is fully paid");

		secondInvoice = new MInvoice_BH(valueObject.getContext(), secondInvoice.get_ID(),
				valueObject.getTransactionName());
		assertTrue(secondInvoice.isPaid(), "Second invoice is paid");
		assertEquals(0, secondInvoice.getGrandTotal().subtract(secondInvoice.getAllocatedAmt()).signum(),
				"Second invoice is fully paid");

		valueObject.refresh();
		assertEquals(0, valueObject.getBusinessPartner().getTotalOpenBalance().compareTo(BigDecimal.ZERO),
				"Business partner has the correct open balance");
	}

	@IPopulateAnnotation.CanRun
	public void openBalancePaymentNotAllocatedWhenNoOpenInvoices() throws Exception {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create payment");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		valueObject.setPaymentAmount(new BigDecimal(150));
		ChuBoeCreateEntity.createPayment(valueObject);
		commitEx();

		valueObject.refresh();
		assertEquals(0, valueObject.getBusinessPartner().getTotalOpenBalance().compareTo(new BigDecimal(-150)),
				"Business partner has the correct open balance");
	}
}
