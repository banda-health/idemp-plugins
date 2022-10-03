package org.bandahealth.idempiere.base.modelevent;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.compiere.model.MDocType;
import org.compiere.model.MInOut;
import org.compiere.model.MInOutLine;
import org.compiere.model.MOrderLine;
import org.compiere.model.MWarehouse;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.osgi.service.event.Event;

import java.sql.Timestamp;

public class OrderModelEvent extends AbstractEventHandler {

	CLogger logger = CLogger.getCLogger(OrderModelEvent.class);

	@Override
	protected void doHandleEvent(Event event) {
		MOrder_BH order = null;
		PO persistantObject = getPO(event);
		if (persistantObject instanceof MOrder_BH) {
			order = (MOrder_BH) persistantObject;
		} else {
			return;
		}

		boolean isPurchase = !order.isSOTrx();
		order.setBH_Isexpense(isPurchase);

		if (event.getTopic().equals(IEventTopics.PO_BEFORE_NEW)) {
			if (!isPurchase) {
				beforeSalesOrderSaveRequest(order);
			}
		} else if (event.getTopic().equals(IEventTopics.DOC_AFTER_VOID)) {
			if (isPurchase) {
				afterPurchaseOrderVoid(order);
			}
		} else if (event.getTopic().equals(IEventTopics.DOC_AFTER_COMPLETE)) {
			if (!isPurchase) {
				order.setBH_ProcessStage(null);
			} else {
				createMaterialReceiptFromPurchaseOrder(order);
			}
		}
	}

	private void createMaterialReceiptFromPurchaseOrder(MOrder_BH order) {
		// Create Material Receipt header
		Timestamp movementDate = order.getDateOrdered() != null ? order.getDateOrdered()
				: new Timestamp(System.currentTimeMillis());
		MDocType docTypeShipment =
				new Query(Env.getCtx(), MDocType.Table_Name, MDocType.COLUMNNAME_PrintName + "=?", order.get_TrxName())
						.setParameters(MDocType_BH.DOCUMENTBASETYPE_ORDER_CONFIRMATION).setClient_ID().first();
		if (docTypeShipment == null) {
			throw new AdempiereException("Shipment DocType not defined");
		}
		MInOut mReceipt = new MInOut(order, docTypeShipment.getC_DocTypeShipment_ID(), movementDate);

		mReceipt.setMovementType(MInOut.MOVEMENTTYPE_VendorReceipts);
		mReceipt.setDocAction(MInOut.DOCACTION_Complete);
		mReceipt.save();

		// add lines if any
		MOrderLine[] oLines = order.getLines(true, "M_Product_ID");
		if (oLines.length > 0) {
			MWarehouse mWarehouse = new MWarehouse(Env.getCtx(), order.getM_Warehouse_ID(), order.get_TrxName());
			for (MOrderLine oLine : oLines) {
				MInOutLine line = new MInOutLine(mReceipt);
				line.setOrderLine(oLine, mWarehouse.getDefaultLocator().get_ID(), Env.ZERO);
				line.setQty(oLine.getQtyOrdered());
				line.saveEx(order.get_TrxName());
			}
		}

		// complete operation
		String m_status = mReceipt.completeIt();
		mReceipt.setDocStatus(m_status);
		mReceipt.save();
	}

	private void afterPurchaseOrderVoid(MOrder_BH order) {
		// Get the material receipt associated with this order, if any
		MInOut materialReceipt = new Query(Env.getCtx(), MInOut.Table_Name, MInOut.COLUMNNAME_C_Order_ID + "=?",
				order.get_TrxName()).setParameters(order.getC_Order_ID()).setClient_ID().first();
		if (materialReceipt == null) {
			return;
		}
		// "Void" the material receipt as well
		materialReceipt.processIt(MInOut.ACTION_Void);
		// Since processing an entity doesn't save it, now save it
		materialReceipt.saveEx();
	}

	private void beforeSalesOrderSaveRequest(MOrder_BH salesOrder) {
		// If no sales rep was passed in, just use the logged-in user
		if (salesOrder.getSalesRep_ID() == 0) {
			salesOrder.setSalesRep_ID(Env.getAD_User_ID(Env.getCtx()));
		}
	}

	@Override
	protected void initialize() {
		registerTableEvent(IEventTopics.PO_BEFORE_NEW, MOrder_BH.Table_Name);
		registerTableEvent(IEventTopics.PO_BEFORE_CHANGE, MOrder_BH.Table_Name);
		registerTableEvent(IEventTopics.DOC_AFTER_VOID, MOrder_BH.Table_Name);
		registerTableEvent(IEventTopics.DOC_AFTER_COMPLETE, MOrder_BH.Table_Name);
	}
}
