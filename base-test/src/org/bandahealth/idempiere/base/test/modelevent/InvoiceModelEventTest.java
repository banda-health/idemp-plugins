package org.bandahealth.idempiere.base.test.modelevent;

import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.compiere.model.MInvoice;
import org.compiere.process.DocumentEngine;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InvoiceModelEventTest extends ChuBoePopulateFactoryVO {
	@IPopulateAnnotation.CanRunBeforeClass
	public void prepareIt() throws Exception {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Open needed periods");
		ChuBoeCreateEntity.createAndOpenAllFiscalYears(valueObject);
		commitEx();
	}

	@IPopulateAnnotation.CanRun
	public void invoiceDateAccountMatchesDateInvoicedIfDateAccountNull() throws Exception {
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
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_POSOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create invoice");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Prepare);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARInvoice, null, true, false, false);
		ChuBoeCreateEntity.createInvoice(valueObject);
		commitEx();

		assertThat("Date account matches date invoiced", valueObject.getInvoice().getDateAcct(),
				is(valueObject.getInvoice().getDateInvoiced()));
	}

	@IPopulateAnnotation.CanRun
	public void automaticallyCreatedInvoiceFromOrderWithChargesHasTheCharges() throws SQLException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create charge");
		ChuBoeCreateEntity.createCharge(valueObject);

		valueObject.setStepName("Create order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Prepare);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Add charge to order");
		MOrderLine_BH chargeOrderLine = new MOrderLine_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		MOrderLine_BH.copyValues(valueObject.getOrderLine(), chargeOrderLine);
		chargeOrderLine.setC_Charge_ID(valueObject.getCharge().getC_Charge_ID());
		chargeOrderLine.setM_Product_ID(0);
		chargeOrderLine.setPrice(valueObject.getOrderLine().getPriceEntered().negate());
		chargeOrderLine.setOrder(valueObject.getOrder());
		chargeOrderLine.saveEx();
		commitEx();
		valueObject.refresh();

		valueObject.setStepName("Complete the order");
		valueObject.getOrder().setDocAction(MOrder_BH.DOCACTION_Complete);
		assertTrue(valueObject.getOrder().processIt(MOrder_BH.DOCACTION_Complete), "Order was completed");
		valueObject.getOrder().saveEx();
		commitEx();

		MInvoice[] ordersInvoices = valueObject.getOrder().getInvoices();
		assertEquals(1, ordersInvoices.length, "Invoice was created for order");
		MInvoice completedInvoice = ordersInvoices[0];
		assertTrue(completedInvoice.isComplete(), "Invoice was automatically completed");
		assertEquals(0, valueObject.getOrder().getGrandTotal().compareTo(completedInvoice.getGrandTotal()),
				"Invoice grand total matches order's");
		assertEquals(0, new MBPartner_BH(valueObject.getContext(), valueObject.getBusinessPartner().get_ID(),
						valueObject.getTransactionName()).getTotalOpenBalance().compareTo(BigDecimal.ZERO),
				"Business partner has no open balance");

		valueObject.setStepName("Re-activate the order");
		valueObject.getOrder().setDocAction(MOrder_BH.DOCACTION_Re_Activate);
		assertTrue(valueObject.getOrder().processIt(MOrder_BH.DOCACTION_Re_Activate), "Order was reactivated");
		valueObject.getOrder().saveEx();
		commitEx();

		ordersInvoices = valueObject.getOrder().getInvoices();
		assertEquals(2, ordersInvoices.length, "Invoice was created for for reopened order");
		assertTrue(
				ordersInvoices[0].isComplete() && ordersInvoices[0].getDocStatus().equals(MInvoice_BH.DOCSTATUS_Reversed),
				"Original invoice is completed");
		assertTrue(
				ordersInvoices[1].isComplete() && ordersInvoices[1].getDocStatus().equals(MInvoice_BH.DOCSTATUS_Reversed),
				"Second invoice is completed");
		assertEquals(0, ordersInvoices[0].getGrandTotal().negate().compareTo(ordersInvoices[1].getGrandTotal()),
				"Invoices have opposite grand totals");
		assertEquals(0, new MBPartner_BH(valueObject.getContext(), valueObject.getBusinessPartner().get_ID(),
						valueObject.getTransactionName()).getTotalOpenBalance().compareTo(BigDecimal.ZERO),
				"Business partner still has no open balance");
	}

	@IPopulateAnnotation.CanRun
	public void manuallyCreatedInvoiceFromOrderWithChargesDoesntHaveTheCharges() throws SQLException {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create charge");
		ChuBoeCreateEntity.createCharge(valueObject);

		valueObject.setStepName("Create order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Prepare);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_StandardOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Add charge to order");
		MOrderLine_BH chargeOrderLine = new MOrderLine_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		MOrderLine_BH.copyValues(valueObject.getOrderLine(), chargeOrderLine);
		chargeOrderLine.setC_Charge_ID(valueObject.getCharge().getC_Charge_ID());
		chargeOrderLine.setM_Product_ID(0);
		chargeOrderLine.setPrice(valueObject.getOrderLine().getPriceEntered().negate());
		chargeOrderLine.setOrder(valueObject.getOrder());
		chargeOrderLine.saveEx();
		commitEx();

		valueObject.setStepName("Complete the order");
		valueObject.getOrder().setDocAction(MOrder_BH.DOCACTION_Complete);
		assertTrue(valueObject.getOrder().processIt(MOrder_BH.DOCACTION_Complete), "Order was completed");
		valueObject.getOrder().saveEx();
		commitEx();

		MInvoice[] ordersInvoices = valueObject.getOrder().getInvoices();
		assertEquals(0, ordersInvoices.length, "No invoice was created for order");

		valueObject.setStepName("Create invoice");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARInvoice, null, true, false, false);
		ChuBoeCreateEntity.createInvoice(valueObject);
		commitEx();

		ordersInvoices = valueObject.getOrder().getInvoices();
		assertEquals(1, ordersInvoices.length, "Invoice was created for order");
		assertTrue(Arrays.stream(ordersInvoices[0].getLines(true)).noneMatch(
				invoiceLine -> invoiceLine.getC_Charge_ID() > 0 &&
						invoiceLine.getC_Charge_ID() == valueObject.getCharge().get_ID()), "Invoice doesn't have charge");
	}
}
