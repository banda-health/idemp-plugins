package org.bandahealth.idempiere.base.test.process;

import com.chuboe.test.populate.ChuBoeCreateEntity;
import com.chuboe.test.populate.ChuBoePopulateFactoryVO;
import com.chuboe.test.populate.ChuBoePopulateVO;
import com.chuboe.test.populate.IPopulateAnnotation;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.process.DocumentEngine;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CompleteOrdersProcessTest extends ChuBoePopulateFactoryVO {
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
	public void processCompletesPaymentsThatErrored() throws Exception {
		ChuBoePopulateVO valueObject = new ChuBoePopulateVO();
		valueObject.prepareIt(getScenarioName(), true, get_TrxName());
		assertThat("VO validation gives no errors", valueObject.getErrorMessage(), is(nullValue()));

		valueObject.setStepName("Create business partner");
		ChuBoeCreateEntity.createBusinessPartner(valueObject);
		commitEx();

		valueObject.setStepName("Create product");
		ChuBoeCreateEntity.createProduct(valueObject);
		commitEx();

		valueObject.setStepName("Create first order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create first order's payment");
		MOrder_BH firstOrder = valueObject.getOrder();
		valueObject.setInvoice(new MInvoice_BH(firstOrder.getInvoices()[0]));
		valueObject.setDocumentAction(DocumentEngine.ACTION_Prepare);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		ChuBoeCreateEntity.createPayment(valueObject);
		valueObject.getPayment().setBH_C_Order_ID(firstOrder.get_ID());
		valueObject.getPayment().setDocAction(MOrder_BH.DOCACTION_Complete);
		valueObject.getPayment().processIt(MOrder_BH.DOCACTION_Complete);
		commitEx();

		valueObject.setStepName("Re-activate order");
		List<MPayment_BH> ordersPayments = new Query(valueObject.getContext(), MPayment_BH.Table_Name,
				MPayment_BH.COLUMNNAME_BH_C_Order_ID + "=? AND " + MPayment_BH.COLUMNNAME_DocStatus + "=? AND " +
						MPayment_BH.COLUMNNAME_Reversal_ID + " IS NULL", valueObject.getTransactionName()).setParameters(
				firstOrder.get_ID(), MPayment_BH.DOCSTATUS_Completed).list();
		firstOrder.setDocAction(MOrder_BH.DOCACTION_Re_Activate);
		firstOrder.processIt(MOrder_BH.DOCACTION_Re_Activate);
		firstOrder.saveEx();

		valueObject.setStepName("Cancel previous payments");
		MPayment_BH newPayment = null;
		for (MPayment_BH payment : ordersPayments) {
			newPayment = payment.copy();
			newPayment.setDocStatus(MPayment_BH.DOCSTATUS_Drafted);
			newPayment.saveEx();

			payment.setDocAction(DocAction.ACTION_Reverse_Accrual);
			assertTrue(payment.processIt(DocAction.ACTION_Reverse_Accrual), "Old payment was reversed");
			payment.saveEx();
		}
		commitEx();
		valueObject.refresh();

		valueObject.setStepName("Re-complete order");
		firstOrder.setDocAction(MOrder_BH.DOCACTION_Complete);
		firstOrder.processIt(MOrder_BH.DOCACTION_Complete);
		firstOrder.saveEx();
		commitEx();

		valueObject.setStepName("Set payment as errored");
		assertNotNull(newPayment, "New payment was created");
		newPayment.setDocStatus(MPayment_BH.DOCSTATUS_Drafted);
		newPayment.setDocAction(MPayment_BH.DOCACTION_Complete);
		newPayment.setBH_C_Order_ID(firstOrder.get_ID());
		newPayment.setBH_Processing(true);
		newPayment.saveEx();
		commitEx();

		valueObject.setStepName("Create second order");
		valueObject.setDocumentAction(DocumentEngine.ACTION_Complete);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_SalesOrder, MDocType_BH.DOCSUBTYPESO_OnCreditOrder, true, false,
				false);
		ChuBoeCreateEntity.createOrder(valueObject);
		commitEx();

		valueObject.setStepName("Create second order's payment");
		valueObject.setInvoice(new MInvoice_BH(valueObject.getOrder().getInvoices()[0]));
		valueObject.setDocumentAction(DocumentEngine.ACTION_Prepare);
		valueObject.setDocBaseType(MDocType_BH.DOCBASETYPE_ARReceipt, null, true, false, false);
		valueObject.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		ChuBoeCreateEntity.createPayment(valueObject);
		valueObject.getPayment().setBH_C_Order_ID(valueObject.getOrder().get_ID());
		valueObject.getPayment().setDocAction(MOrder_BH.DOCACTION_Complete);
		valueObject.getPayment().processIt(MOrder_BH.DOCACTION_Complete);
		commitEx();

		valueObject.setStepName("Re-activate order");
		ordersPayments = new Query(valueObject.getContext(), MPayment_BH.Table_Name,
				MPayment_BH.COLUMNNAME_BH_C_Order_ID + "=? AND " + MPayment_BH.COLUMNNAME_DocStatus + "=? AND " +
						MPayment_BH.COLUMNNAME_Reversal_ID + " IS NULL", valueObject.getTransactionName()).setParameters(
				valueObject.getOrder().get_ID(), MPayment_BH.DOCSTATUS_Completed).list();
		valueObject.getOrder().setDocAction(MOrder_BH.DOCACTION_Re_Activate);
		valueObject.getOrder().processIt(MOrder_BH.DOCACTION_Re_Activate);
		valueObject.getOrder().saveEx();

		valueObject.setStepName("Cancel previous payments");
		for (MPayment_BH payment : ordersPayments) {
			MPayment_BH anotherNewPayment = payment.copy();
			anotherNewPayment.setDocStatus(MPayment_BH.DOCSTATUS_Drafted);
			anotherNewPayment.saveEx();

			payment.setDocAction(DocAction.ACTION_Reverse_Accrual);
			assertTrue(payment.processIt(DocAction.ACTION_Reverse_Accrual), "Old payment was reversed");
			payment.saveEx();
		}
		commitEx();
		valueObject.refresh();

		valueObject.setStepName("Run the order completion process");
		valueObject.setProcessUuid("1d5191dd-4792-464f-94c5-5b4d652e5fe5");
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		ChuBoeCreateEntity.runProcess(valueObject);

		newPayment = new Query(valueObject.getContext(), MPayment_BH.Table_Name,
				MPayment_BH.COLUMNNAME_BH_C_Order_ID + "=? AND " + MPayment_BH.COLUMNNAME_DocStatus + "=?",
				valueObject.getTransactionName()).setParameters(firstOrder.get_ID(), MPayment_BH.DOCSTATUS_Completed)
				.setOrderBy(MPayment_BH.COLUMNNAME_C_Payment_ID + " DESC").first();
		assertNotNull(newPayment, "First order's payment still exists");
		assertTrue(newPayment.getDocStatus().equalsIgnoreCase(MPayment_BH.DOCSTATUS_Completed), "Payment was completed");
		assertTrue(newPayment.isAllocated(), "Payment was allocated");

		newPayment = new Query(valueObject.getContext(), MPayment_BH.Table_Name,
				MPayment_BH.COLUMNNAME_BH_C_Order_ID + "=? AND " + MPayment_BH.COLUMNNAME_DocStatus + "!=?",
				valueObject.getTransactionName()).setParameters(valueObject.getOrder().get_ID(),
						MPayment_BH.DOCSTATUS_Reversed)
				.setOrderBy(MPayment_BH.COLUMNNAME_C_Payment_ID + " DESC").first();
		assertNotNull(newPayment, "Second order's payment still exists");
		assertFalse(valueObject.getOrder().getDocStatus().equalsIgnoreCase(MPayment_BH.DOCSTATUS_Completed),
				"Re-activated order was not completed by the process");
		assertFalse(newPayment.getDocStatus().equalsIgnoreCase(MPayment_BH.DOCSTATUS_Completed),
				"Second payment was not completed");
		assertFalse(newPayment.isAllocated(), "Second payment was not allocated");
	}
}
