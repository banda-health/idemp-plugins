package org.bandahealth.idempiere.base.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;

import org.compiere.model.*;
import org.compiere.model.MBPartner;
import org.compiere.model.MBankAccount;
import org.compiere.model.MClient;
import org.compiere.model.MConversionRate;
import org.compiere.model.MConversionRateUtil;
import org.compiere.model.MDocType;
import org.compiere.model.MInOut;
import org.compiere.model.MInOutLine;
import org.compiere.model.MInvoice;
import org.compiere.model.MInvoiceBatch;
import org.compiere.model.MInvoiceBatchLine;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MMatchInv;
import org.compiere.model.MMatchPO;
import org.compiere.model.MOrder;
import org.compiere.model.MOrderLine;
import org.compiere.model.MPeriod;
import org.compiere.model.MProject;
import org.compiere.model.MRMALine;
import org.compiere.model.MSysConfig;
import org.compiere.model.MUser;
import org.compiere.model.ModelValidationEngine;
import org.compiere.model.ModelValidator;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.Msg;
import org.compiere.util.TimeUtil;

public class MInvoice_BH extends MInvoice {
	
	private static final long serialVersionUID = 1L;

	private boolean	m_justPrepared = false;

	public MInvoice_BH(Properties ctx, int C_Invoice_ID, String trxName) {
		super(ctx, C_Invoice_ID, trxName);
	}
	
	public MInvoice_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
	
	public MInvoice_BH(MOrder order, int C_DocTypeTarget_ID, Timestamp invoiceDate) {
		super(order, C_DocTypeTarget_ID, invoiceDate);
	}
	
	public MInvoice_BH(MInOut ship, Timestamp invoiceDate) {
		super(ship, invoiceDate);
	}
	
	public MInvoice_BH(MInvoiceBatch batch, MInvoiceBatchLine line) {
		super(batch, line);
	}

	@Override
	public String prepareIt() {
		String status = super.prepareIt();
		if (status == DocAction.STATUS_InProgress) {
			m_justPrepared = true;
		}
		
		return status;
	}
	
	/**
	 * 	Complete Document
	 * 	@return new status (Complete, In Progress, Invalid, Waiting ..)
	 */
	public String completeIt()
	{
		//	Re-Check
		if (!m_justPrepared)
		{
			String status = prepareIt();
			m_justPrepared = false;
			if (!DocAction.STATUS_InProgress.equals(status))
				return status;
		}

		// Set the definite document number after completed (if needed)
		setDefiniteDocumentNo();

		setProcessMessage(ModelValidationEngine.get().fireDocValidate(this, ModelValidator.TIMING_BEFORE_COMPLETE));
		if (getProcessMsg() != null) {
			return DocAction.STATUS_Invalid;
		}

		//	Implicit Approval
		if (!isApproved()) {
			approveIt();
		}
		if (log.isLoggable(Level.INFO)) {
			log.info(toString());
		}

		// Create BHGo payment
		createPayment();

		//	User Validation
		String valid = ModelValidationEngine.get().fireDocValidate(this, ModelValidator.TIMING_AFTER_COMPLETE);
		if (valid != null)
		{
			setProcessMessage(valid);
			return DocAction.STATUS_Invalid;
		}

		setProcessed(true);
		setDocAction(DOCACTION_Close);
		return DocAction.STATUS_Completed;
	}	//	completeIt
	
	/**
	 * Create a payment for the expenses
	 */
	private void createPayment() {
		// Add a payment equaling the amount of this invoice, associate it, and complete it
		MPayment_BH expensePayment = new MPayment_BH(Env.getCtx(), 0, get_TrxName());
		expensePayment.setC_DocType_ID(false);
		expensePayment.setC_Invoice_ID(getC_Invoice_ID());
		expensePayment.setDateTrx(getDateInvoiced());
		expensePayment.setDateAcct(getDateAcct());
		expensePayment.setC_BPartner_ID(getC_BPartner_ID());
		expensePayment.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		expensePayment.setPayAmt(getTotalLines());
		expensePayment.setAD_Org_ID(getAD_Org_ID());
		expensePayment.setC_Currency_ID(getC_Currency_ID());

		MBankAccount bankAccount = new Query(
				Env.getCtx(),
				MBankAccount.Table_Name,
				"ad_client_id = ?",
				expensePayment.get_TrxName()
		)
				.setParameters(getAD_Client_ID())
				.first();
		if (bankAccount != null) {
			expensePayment.setC_BankAccount_ID(bankAccount.getC_BankAccount_ID());
		}

		expensePayment.saveEx(get_TrxName());

		boolean paymentIsComplete = expensePayment.processIt(DocAction.ACTION_Complete);
		if (!paymentIsComplete) {
			log.severe("Error auto-processing payment " + expensePayment.getC_Payment_ID()
					+ "and associating it to invoice " + getC_Invoice_ID());
		}

		// IDEMPIERE-2588 - add the allocation generation with the payment
		if (expensePayment.getJustCreatedAllocInv() != null) {
			addDocsPostProcess(expensePayment.getJustCreatedAllocInv());
		}
	}

	/**
	 * 	Set the definite document number after completed
	 */
	private void setDefiniteDocumentNo() {
		if (isReversal() &&
				!MSysConfig.getBooleanValue(MSysConfig.Invoice_ReverseUseNewNumber, true, getAD_Client_ID())
		) // IDEMPIERE-1771
			return;
		MDocType dt = MDocType.get(getCtx(), getC_DocType_ID());
		if (dt.isOverwriteDateOnComplete()) {
			setDateInvoiced(TimeUtil.getDay(0));
			if (getDateAcct().before(getDateInvoiced())) {
				setDateAcct(getDateInvoiced());
				MPeriod.testPeriodOpen(getCtx(), getDateAcct(), getC_DocType_ID(), getAD_Org_ID());
			}
		}
		if (dt.isOverwriteSeqOnComplete()) {
			String value = DB.getDocumentNo(getC_DocType_ID(), get_TrxName(), true, this);
			if (value != null)
				setDocumentNo(value);
		}
	}
	
	private void addDocsPostProcess(PO doc) {
		getDocsPostProcess().add(doc);
	}
}
