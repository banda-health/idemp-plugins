package org.bandahealth.idempiere.base.model;

import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import java.util.logging.Level;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MDocType;
import org.compiere.model.MInOut;
import org.compiere.model.MInOutLine;
import org.compiere.model.MInvoice;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MInvoicePaySchedule;
import org.compiere.model.MOrder;
import org.compiere.model.MOrderLine;
import org.compiere.model.MOrderPaySchedule;
import org.compiere.model.MProject;
import org.compiere.model.MSysConfig;
import org.compiere.model.MWarehouse;
import org.compiere.model.ModelValidationEngine;
import org.compiere.model.ModelValidator;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.util.Util;

public class MOrder_BH extends MOrder {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Column name BH_Payments
	 */
	public static final String COLUMNNAME_BH_Payments = "BH_Payments";

	/**
	 * Column name bh_isexpense
	 */
	public static final String COLUMNNAME_BH_IsExpense = "BH_isexpense";

	public static final String COLUMNNAME_BH_NEWVISIT = "bh_newvisit";
	
	public static final String COLUMNNAME_BH_CHIEF_COMPLAINT = "BH_ChiefComplaint";
	
	public static final String COLUMNNAME_BH_TEMPERATURE = "BH_Temperature";
	
	public static final String COLUMNNAME_BH_PULSE = "BH_Pulse";
	
	public static final String COLUMNNAME_BH_RESPIRATORY_RATE = "BH_RespiratoryRate";
	
	public static final String COLUMNNAME_BH_BLOOD_PRESSURE = "BH_BloodPressure";
	
	public static final String COLUMNNAME_BH_HEIGHT = "BH_Height";
	
	public static final String COLUMNNAME_BH_WEIGHT = "BH_Weight";

	public MOrder_BH(Properties ctx, int C_Order_ID, String trxName) {
		super(ctx, C_Order_ID, trxName);
	}

	public MOrder_BH(MProject project, boolean IsSOTrx, String DocSubTypeSO) {
		super(project, IsSOTrx, DocSubTypeSO);
	}

	public MOrder_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
	
	
	public String completeIt()
	{
		MDocType dt = MDocType.get(getCtx(), getC_DocType_ID());
		String DocSubTypeSO = dt.getDocSubTypeSO();
		
		//	Just prepare
		if (DOCACTION_Prepare.equals(getDocAction()))
		{
			setProcessed(false);
			return DocAction.STATUS_InProgress;
		}

		// Set the definite document number after completed (if needed)
		setDefiniteDocumentNo();

		//	Offers
		if (MDocType.DOCSUBTYPESO_Proposal.equals(DocSubTypeSO)
			|| MDocType.DOCSUBTYPESO_Quotation.equals(DocSubTypeSO)) 
		{
			//	Binding
			if (MDocType.DOCSUBTYPESO_Quotation.equals(DocSubTypeSO))
				reserveStock(dt, getLines(true, MOrderLine.COLUMNNAME_M_Product_ID));
			m_processMsg = ModelValidationEngine.get().fireDocValidate(this, ModelValidator.TIMING_BEFORE_COMPLETE);
			if (m_processMsg != null)
				return DocAction.STATUS_Invalid;
			m_processMsg = ModelValidationEngine.get().fireDocValidate(this, ModelValidator.TIMING_AFTER_COMPLETE);
			if (m_processMsg != null)
				return DocAction.STATUS_Invalid;
			setProcessed(true);
			return DocAction.STATUS_Completed;
		}
		//	Waiting Payment - until we have a payment
		if (!m_forceCreation 
			&& MDocType.DOCSUBTYPESO_PrepayOrder.equals(DocSubTypeSO) 
			&& getC_Payment_ID() == 0 && getC_CashLine_ID() == 0)
		{
			setProcessed(true);
			return DocAction.STATUS_WaitingPayment;
		}
		
		//	Re-Check
		if (!m_justPrepared)
		{
			String status = prepareIt();
			m_justPrepared = false;
			if (!DocAction.STATUS_InProgress.equals(status))
				return status;
		}
		
		m_processMsg = ModelValidationEngine.get().fireDocValidate(this, ModelValidator.TIMING_BEFORE_COMPLETE);
		if (m_processMsg != null)
			return DocAction.STATUS_Invalid;
		
		//	Implicit Approval
		if (!isApproved())
			approveIt();
		getLines(true,null);
		if (log.isLoggable(Level.INFO)) log.info(toString());
		StringBuilder info = new StringBuilder();
		
		boolean realTimePOS = MSysConfig.getBooleanValue(MSysConfig.REAL_TIME_POS, false , getAD_Client_ID());
		
		//	Create SO Shipment - Force Shipment
		MInOut shipment = null;
		if (MDocType.DOCSUBTYPESO_OnCreditOrder.equals(DocSubTypeSO)		//	(W)illCall(I)nvoice
			|| MDocType.DOCSUBTYPESO_WarehouseOrder.equals(DocSubTypeSO)	//	(W)illCall(P)ickup	
			|| MDocType.DOCSUBTYPESO_POSOrder.equals(DocSubTypeSO)			//	(W)alkIn(R)eceipt
			|| MDocType.DOCSUBTYPESO_PrepayOrder.equals(DocSubTypeSO)) 
		{
			if (!DELIVERYRULE_Force.equals(getDeliveryRule()))
			{
				MWarehouse wh = new MWarehouse (getCtx(), getM_Warehouse_ID(), get_TrxName());
				if (!wh.isDisallowNegativeInv())
					setDeliveryRule(DELIVERYRULE_Force);
			}
			//
			shipment = createShipment (dt, realTimePOS ? null : getDateOrdered());
			if (shipment == null)
				return DocAction.STATUS_Invalid;
			info.append("@M_InOut_ID@: ").append(shipment.getDocumentNo());
			String msg = shipment.getProcessMsg();
			if (msg != null && msg.length() > 0)
				info.append(" (").append(msg).append(")");
		}	//	Shipment
		

		//	Create SO Invoice - Always invoice complete Order
		if ( MDocType.DOCSUBTYPESO_POSOrder.equals(DocSubTypeSO)
			|| MDocType.DOCSUBTYPESO_OnCreditOrder.equals(DocSubTypeSO) 	
			|| MDocType.DOCSUBTYPESO_PrepayOrder.equals(DocSubTypeSO)) 
		{
			MInvoice_BH invoice = createInvoice (dt, shipment, realTimePOS ? null : getDateOrdered());
			if (invoice == null)
				return DocAction.STATUS_Invalid;
			info.append(" - @C_Invoice_ID@: ").append(invoice.getDocumentNo());
			String msg = invoice.getProcessMsg();
			if (msg != null && msg.length() > 0)
				info.append(" (").append(msg).append(")");
		}	//	Invoice
		
		String msg = createPOSPayments();
		if (msg != null) {
			m_processMsg = msg;
			return DocAction.STATUS_Invalid;
		}

		//	Counter Documents
		MOrder counter = createCounterDoc();
		if (counter != null)
			info.append(" - @CounterDoc@: @Order@=").append(counter.getDocumentNo());
		//	User Validation
		String valid = ModelValidationEngine.get().fireDocValidate(this, ModelValidator.TIMING_AFTER_COMPLETE);
		if (valid != null)
		{
			if (info.length() > 0)
				info.append(" - ");
			info.append(valid);
			m_processMsg = info.toString();
			return DocAction.STATUS_Invalid;
		}

		//landed cost
		if (!isSOTrx())
		{
			String error = landedCostAllocation();
			if (!Util.isEmpty(error))
			{
				m_processMsg = error;
				return DocAction.STATUS_Invalid;
			}
		}

		setProcessed(true);	
		m_processMsg = info.toString();
		//
		setDocAction(DOCACTION_Close);
		return DocAction.STATUS_Completed;
	}	//	completeIt
	
	/**
	 * 	Create Invoice
	 *	@param dt order document type
	 *	@param shipment optional shipment
	 *	@param invoiceDate invoice date
	 *	@return invoice or null
	 */
	protected MInvoice_BH createInvoice (MDocType dt, MInOut shipment, Timestamp invoiceDate)
	{
		if (log.isLoggable(Level.INFO)) log.info(dt.toString());
		
		// check if there is an associated invoice for this order
		MInvoice existingInvoice = new Query(getCtx(), MInvoice_BH.Table_Name, MInvoice_BH.COLUMNNAME_C_Order_ID + " = ? ", get_TrxName())
				.setParameters(getC_Order_ID()).setOnlyActiveRecords(true).first();
		
		if (existingInvoice != null) {
			return new MInvoice_BH(existingInvoice);
		}
		
		MInvoice_BH invoice = new MInvoice_BH (this, dt.getC_DocTypeInvoice_ID(), invoiceDate);
		if (!invoice.save(get_TrxName()))
		{
			m_processMsg = "Could not create Invoice";
			return null;
		}
		
		//	If we have a Shipment - use that as a base
		if (shipment != null)
		{
			if (!INVOICERULE_AfterDelivery.equals(getInvoiceRule()))
				setInvoiceRule(INVOICERULE_AfterDelivery);
			//
			MInOutLine[] sLines = shipment.getLines(false);
			for (int i = 0; i < sLines.length; i++)
			{
				MInOutLine sLine = sLines[i];
				//
				MInvoiceLine iLine = new MInvoiceLine(invoice);
				iLine.setShipLine(sLine);
				//	Qty = Delivered	
				if (sLine.sameOrderLineUOM())
					iLine.setQtyEntered(sLine.getQtyEntered());
				else
					iLine.setQtyEntered(sLine.getMovementQty());
				iLine.setQtyInvoiced(sLine.getMovementQty());
				if (!iLine.save(get_TrxName()))
				{
					m_processMsg = "Could not create Invoice Line from Shipment Line";
					return null;
				}
				//
				sLine.setIsInvoiced(true);
				if (!sLine.save(get_TrxName()))
				{
					log.warning("Could not update Shipment line: " + sLine);
				}
			}
		}
		else	//	Create Invoice from Order
		{
			if (!INVOICERULE_Immediate.equals(getInvoiceRule()))
				setInvoiceRule(INVOICERULE_Immediate);
			//
			MOrderLine[] oLines = getLines();
			for (int i = 0; i < oLines.length; i++)
			{
				MOrderLine oLine = oLines[i];
				//
				MInvoiceLine iLine = new MInvoiceLine(invoice);
				iLine.setOrderLine(oLine);
				//	Qty = Ordered - Invoiced	
				iLine.setQtyInvoiced(oLine.getQtyOrdered().subtract(oLine.getQtyInvoiced()));
				if (oLine.getQtyOrdered().compareTo(oLine.getQtyEntered()) == 0)
					iLine.setQtyEntered(iLine.getQtyInvoiced());
				else
					iLine.setQtyEntered(iLine.getQtyInvoiced().multiply(oLine.getQtyEntered())
						.divide(oLine.getQtyOrdered(), 12, RoundingMode.HALF_UP));
				if (!iLine.save(get_TrxName()))
				{
					m_processMsg = "Could not create Invoice Line from Order Line";
					return null;
				}
			}
		}
		
		// Copy payment schedule from order to invoice if any
		for (MOrderPaySchedule ops : MOrderPaySchedule.getOrderPaySchedule(getCtx(), getC_Order_ID(), 0, get_TrxName())) {
			MInvoicePaySchedule ips = new MInvoicePaySchedule(getCtx(), 0, get_TrxName());
			PO.copyValues(ops, ips);
			ips.setC_Invoice_ID(invoice.getC_Invoice_ID());
			ips.setAD_Org_ID(ops.getAD_Org_ID());
			ips.setProcessing(ops.isProcessing());
			ips.setIsActive(ops.isActive());
			if (!ips.save()) {
				m_processMsg = "ERROR: creating pay schedule for invoice from : "+ ops.toString();
				return null;
			}
		}
		
		// added AdempiereException by zuhri
		if (!invoice.processIt(DocAction.ACTION_Complete))
			throw new AdempiereException("Failed when processing document - " + invoice.getProcessMsg());
		// end added
		invoice.saveEx(get_TrxName());
		setC_CashLine_ID(invoice.getC_CashLine_ID());
		if (!DOCSTATUS_Completed.equals(invoice.getDocStatus()))
		{
			m_processMsg = "@C_Invoice_ID@: " + invoice.getProcessMsg();
			return null;
		}
		return invoice;
	}	//	createInvoice

	/**
	 * Get Payments.
	 *
	 * @return Payments
	 */
	public Object getBH_Payments() {
		return get_Value(COLUMNNAME_BH_Payments);
	}

	/**
	 * Set Payments.
	 *
	 * @param BH_Payments Payments
	 */
	public void setBH_Payments(Object BH_Payments) {
		set_Value(COLUMNNAME_BH_Payments, BH_Payments);
	}

	public Object getBH_Isexpense() {
		return get_Value(COLUMNNAME_BH_IsExpense);
	}

	public void setBH_Isexpense(Object bh_isexpense) {
		set_Value(COLUMNNAME_BH_IsExpense, bh_isexpense);
	}
	
	public boolean isBH_NewVisit() {
		Object oo = get_Value(COLUMNNAME_BH_NEWVISIT);
		if (oo != null) {
			if (oo instanceof Boolean) {
				return ((Boolean) oo).booleanValue();
			}
			return "Y".equals(oo);
		}
		return false;
	}
	
	public void setBH_NewVisit(boolean newVisit) {
		set_Value(COLUMNNAME_BH_NEWVISIT, newVisit);
	}

	public String getBH_Chief_Complaint() {
		return (String)get_Value(COLUMNNAME_BH_CHIEF_COMPLAINT);
	}
	
	public void setBH_Chief_Complaint(String BH_Chief_Complaint) {
		set_Value(COLUMNNAME_BH_CHIEF_COMPLAINT, BH_Chief_Complaint);
	}

	public String getBH_Temperature() {
		return (String)get_Value( COLUMNNAME_BH_TEMPERATURE);
	}
	
	public void setBH_Temperature(String BH_Temperature) {
		set_Value(COLUMNNAME_BH_TEMPERATURE, BH_Temperature);
	}

	public String getBH_Pulse() {
		return (String)get_Value( COLUMNNAME_BH_PULSE);
	}
	
	public void setBH_Pulse(String BH_Pulse) {
		set_Value(COLUMNNAME_BH_PULSE, BH_Pulse);
	}

	public String getBH_Respiratory_Rate() {
		return (String)get_Value( COLUMNNAME_BH_RESPIRATORY_RATE);
	}
	
	public void setBH_Respiratory_Rate(String BH_Respiratory_Rate) {
		set_Value(COLUMNNAME_BH_RESPIRATORY_RATE, BH_Respiratory_Rate);
	}

	public String getBH_Blood_Pressure() {
		return (String)get_Value( COLUMNNAME_BH_BLOOD_PRESSURE);
	}
	
	public void setBH_Blood_Pressure(String BH_Blood_Pressure) {
		set_Value(COLUMNNAME_BH_BLOOD_PRESSURE, BH_Blood_Pressure);
	}

	public String getBH_Height() {
		return (String)get_Value( COLUMNNAME_BH_HEIGHT);
	}
	
	public void setBH_Height(String BH_Height) {
		set_Value(COLUMNNAME_BH_HEIGHT, BH_Height);
	}

	public String getBH_Weight() {
		return (String)get_Value( COLUMNNAME_BH_WEIGHT);
	}
	
	public void setBH_Weight(String BH_Weight) {
		set_Value(COLUMNNAME_BH_WEIGHT, BH_Weight);
	}
}
