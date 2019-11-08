package org.bandahealth.idempiere.base.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;

import org.compiere.model.MBPartner;
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

	public MInvoice_BH (Properties ctx, int C_Invoice_ID, String trxName) {
		super(ctx, C_Invoice_ID, trxName);
	}
	
	public MInvoice_BH (Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
	
	public MInvoice_BH (MOrder order, int C_DocTypeTarget_ID, Timestamp invoiceDate) {
		super(order, C_DocTypeTarget_ID, invoiceDate);
	}
	
	public MInvoice_BH(MInOut ship, Timestamp invoiceDate) {
		super(ship, invoiceDate);
	}
	
	public MInvoice_BH (MInvoiceBatch batch, MInvoiceBatchLine line) {
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

		setProcessMessage (ModelValidationEngine.get().fireDocValidate(this, ModelValidator.TIMING_BEFORE_COMPLETE));
		if (getProcessMsg() != null)
			return DocAction.STATUS_Invalid;

		//	Implicit Approval
		if (!isApproved())
			approveIt();
		if (log.isLoggable(Level.INFO)) log.info(toString());
		StringBuilder info = new StringBuilder();
		
		// POS supports multiple payments
		/**
		 * Remove block of code. 
		 */

		// Create BHGo payments..
		BigDecimal totalPayments = createPayments(info);
		
		//	Update Order & Match
		int matchInv = 0;
		int matchPO = 0;
		MInvoiceLine[] lines = getLines(false);
		for (int i = 0; i < lines.length; i++)
		{
			MInvoiceLine line = lines[i];

			//	Matching - Inv-Shipment
			if (!isSOTrx()
				&& line.getM_InOutLine_ID() != 0
				&& line.getM_Product_ID() != 0
				&& !isReversal())
			{
				MInOutLine receiptLine = new MInOutLine (getCtx(),line.getM_InOutLine_ID(), get_TrxName());
				BigDecimal matchQty = line.getQtyInvoiced();

				if (receiptLine.getMovementQty().compareTo(matchQty) < 0)
					matchQty = receiptLine.getMovementQty();

				MMatchInv inv = new MMatchInv(line, getDateInvoiced(), matchQty);
				if (!inv.save(get_TrxName()))
				{
					setProcessMessage( CLogger.retrieveErrorString("Could not create Invoice Matching"));
					return DocAction.STATUS_Invalid;
				}
				matchInv++;
				addDocsPostProcess(inv);
			}
					
			//	Update Order Line
			MOrderLine ol = null;
			if (line.getC_OrderLine_ID() != 0)
			{
				if (isSOTrx()
					|| line.getM_Product_ID() == 0)
				{
					ol = new MOrderLine (getCtx(), line.getC_OrderLine_ID(), get_TrxName());
					if (line.getQtyInvoiced() != null)
						ol.setQtyInvoiced(ol.getQtyInvoiced().add(line.getQtyInvoiced()));
					if (!ol.save(get_TrxName()))
					{
						setProcessMessage("Could not update Order Line");
						return DocAction.STATUS_Invalid;
					}
				}
				//	Order Invoiced Qty updated via Matching Inv-PO
				else if (!isSOTrx()
					&& line.getM_Product_ID() != 0
					&& !isReversal())
				{
					//	MatchPO is created also from MInOut when Invoice exists before Shipment
					BigDecimal matchQty = line.getQtyInvoiced();
					MMatchPO po = MMatchPO.create (line, null,
						getDateInvoiced(), matchQty);
					if (po != null) 
					{
						if (!po.save(get_TrxName()))
						{
							setProcessMessage("Could not create PO Matching");
							return DocAction.STATUS_Invalid;
						}
						matchPO++;
						if (!po.isPosted())
							addDocsPostProcess(po);
						
						MMatchInv[] matchInvoices = MMatchInv.getInvoiceLine(getCtx(), line.getC_InvoiceLine_ID(), get_TrxName());
						if (matchInvoices != null && matchInvoices.length > 0) 
						{
							for(MMatchInv matchInvoice : matchInvoices)
							{
								if (!matchInvoice.isPosted())
								{
									addDocsPostProcess(matchInvoice);
								}
							}
						}
					}
				}
			}

			//Update QtyInvoiced RMA Line
			if (line.getM_RMALine_ID() != 0)
			{
				MRMALine rmaLine = new MRMALine (getCtx(),line.getM_RMALine_ID(), get_TrxName());
				if (rmaLine.getQtyInvoiced() != null)
					rmaLine.setQtyInvoiced(rmaLine.getQtyInvoiced().add(line.getQtyInvoiced()));
				else
					rmaLine.setQtyInvoiced(line.getQtyInvoiced());
				if (!rmaLine.save(get_TrxName()))
				{
					setProcessMessage("Could not update RMA Line");
					return DocAction.STATUS_Invalid;
				}
			}
			//			
		}	//	for all lines
		if (matchInv > 0)
			info.append(" @M_MatchInv_ID@#").append(matchInv).append(" ");
		if (matchPO > 0)
			info.append(" @M_MatchPO_ID@#").append(matchPO).append(" ");


		//	Update BP Statistics
		MBPartner bp = new MBPartner (getCtx(), getC_BPartner_ID(), get_TrxName());
		DB.getDatabase().forUpdate(bp, 0);
		//	Update total revenue and balance / credit limit (reversed on AllocationLine.processIt)
		BigDecimal invAmt = MConversionRate.convertBase(getCtx(), getGrandTotal(true),	//	CM adjusted
			getC_Currency_ID(), getDateAcct(), getC_ConversionType_ID(), getAD_Client_ID(), getAD_Org_ID());
		if (invAmt == null)
		{
			setProcessMessage(MConversionRateUtil.getErrorMessage(getCtx(), "ErrorConvertingCurrencyToBaseCurrency",
					getC_Currency_ID(), MClient.get(getCtx()).getC_Currency_ID(), getC_ConversionType_ID(), getDateAcct(), get_TrxName()));
			return DocAction.STATUS_Invalid;
		}
		
		// adjust invAmt based on how much was paid.
		BigDecimal change = totalPayments.subtract(invAmt);
		if (change.compareTo(BigDecimal.ZERO) > 0) {
			invAmt = totalPayments;
		}
		
		//	Total Balance
		BigDecimal newBalance = bp.getTotalOpenBalance();
		if (newBalance == null)
			newBalance = Env.ZERO;
		if (isSOTrx())
		{
			newBalance = newBalance.add(invAmt);
			//
			if (bp.getFirstSale() == null)
				bp.setFirstSale(getDateInvoiced());
			BigDecimal newLifeAmt = bp.getActualLifeTimeValue();
			if (newLifeAmt == null)
				newLifeAmt = invAmt;
			else
				newLifeAmt = newLifeAmt.add(invAmt);
			BigDecimal newCreditAmt = bp.getSO_CreditUsed();
			if (newCreditAmt == null)
				newCreditAmt = invAmt;
			else
				newCreditAmt = newCreditAmt.add(invAmt);
			//
			if (log.isLoggable(Level.FINE)) log.fine("GrandTotal=" + getGrandTotal(true) + "(" + invAmt
				+ ") BP Life=" + bp.getActualLifeTimeValue() + "->" + newLifeAmt
				+ ", Credit=" + bp.getSO_CreditUsed() + "->" + newCreditAmt
				+ ", Balance=" + bp.getTotalOpenBalance() + " -> " + newBalance);
			bp.setActualLifeTimeValue(newLifeAmt);
			bp.setSO_CreditUsed(newCreditAmt);
		}	//	SO
		else
		{
			newBalance = newBalance.subtract(invAmt);
			if (log.isLoggable(Level.FINE)) log.fine("GrandTotal=" + getGrandTotal(true) + "(" + invAmt
				+ ") Balance=" + bp.getTotalOpenBalance() + " -> " + newBalance);
		}
		
		bp.setTotalOpenBalance(newBalance);
		bp.setSOCreditStatus();
		if (!bp.save(get_TrxName()))
		{
			setProcessMessage("Could not update Business Partner");
			return DocAction.STATUS_Invalid;
		}

		//	User - Last Result/Contact
		if (getAD_User_ID() != 0)
		{
			MUser user = new MUser (getCtx(), getAD_User_ID(), get_TrxName());
			user.setLastContact(new Timestamp(System.currentTimeMillis()));
			StringBuilder msgset = new StringBuilder().append(Msg.translate(getCtx(), "C_Invoice_ID")).append(": ").append(getDocumentNo());
			user.setLastResult(msgset.toString());
			if (!user.save(get_TrxName()))
			{
				setProcessMessage( "Could not update Business Partner User");
				return DocAction.STATUS_Invalid;
			}
		}	//	user

		//	Update Project
		if (isSOTrx() && getC_Project_ID() != 0)
		{
			MProject project = new MProject (getCtx(), getC_Project_ID(), get_TrxName());
			BigDecimal amt = getGrandTotal(true);
			int C_CurrencyTo_ID = project.getC_Currency_ID();
			if (C_CurrencyTo_ID != getC_Currency_ID())
				amt = MConversionRate.convert(getCtx(), amt, getC_Currency_ID(), C_CurrencyTo_ID,
					getDateAcct(), 0, getAD_Client_ID(), getAD_Org_ID());
			if (amt == null)
			{
				setProcessMessage( MConversionRateUtil.getErrorMessage(getCtx(), "ErrorConvertingCurrencyToProjectCurrency",
						getC_Currency_ID(), C_CurrencyTo_ID, 0, getDateAcct(), get_TrxName()));
				return DocAction.STATUS_Invalid;
			}
			BigDecimal newAmt = project.getInvoicedAmt();
			if (newAmt == null)
				newAmt = amt;
			else
				newAmt = newAmt.add(amt);
			if (log.isLoggable(Level.FINE)) log.fine("GrandTotal=" + getGrandTotal(true) + "(" + amt
				+ ") Project " + project.getName()
				+ " - Invoiced=" + project.getInvoicedAmt() + "->" + newAmt);
			project.setInvoicedAmt(newAmt);
			if (!project.save(get_TrxName()))
			{
				setProcessMessage( "Could not update Project");
				return DocAction.STATUS_Invalid;
			}
		}	//	project
		
		// auto delay capture authorization payment
		/**
		 * Remove block of code.
		 */
		//	User Validation
		String valid = ModelValidationEngine.get().fireDocValidate(this, ModelValidator.TIMING_AFTER_COMPLETE);
		if (valid != null)
		{
			setProcessMessage( valid);
			return DocAction.STATUS_Invalid;
		}

		//	Counter Documents
		/**
		 * Remove block of code.
		 */

		setProcessMessage( info.toString().trim());
		setProcessed(true);
		setDocAction(DOCACTION_Close);
		return DocAction.STATUS_Completed;
	}	//	completeIt
	
	/**
	 * Create payments the BHGo way..
	 */
	private BigDecimal createPayments(StringBuilder info) {
		// Go through and add the payment with the amount specified on the order
		String where = MPayment_BH.COLUMNNAME_BH_C_Order_ID + "=?";
		List<MPayment_BH> orderPayments = new Query(getCtx(), MPayment_BH.Table_Name, where, get_TrxName())
		        .setParameters(getC_Order_ID()).list();
		BigDecimal totalPayments = new BigDecimal(0);
		for (MPayment_BH orderPayment : orderPayments) {
			orderPayment.setC_Invoice_ID(getC_Invoice_ID());
			orderPayment.saveEx(get_TrxName());

			boolean paymentIsComplete = orderPayment.processIt(DocAction.ACTION_Complete);
			if (!paymentIsComplete) {
				log.severe("Error auto-processing payment " + orderPayment.getC_Payment_ID()
				        + "and associating it to invoice " + getC_Invoice_ID());
			}
			
			info.append("@C_Payment_ID@: " + orderPayment.getDocumentInfo());

			// IDEMPIERE-2588 - add the allocation generation with the payment
			if (orderPayment.getJustCreatedAllocInv() != null)
				addDocsPostProcess(orderPayment.getJustCreatedAllocInv());

			totalPayments = totalPayments.add(orderPayment.getPayAmt());
		}
		
		return totalPayments;
	}
	/**
	 * 	Set the definite document number after completed
	 */
	private void setDefiniteDocumentNo() {
		if (isReversal() && ! MSysConfig.getBooleanValue(MSysConfig.Invoice_ReverseUseNewNumber, true, getAD_Client_ID())) // IDEMPIERE-1771
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
