package org.bandahealth.idempiere.base.modelevent;

import java.sql.Timestamp;
import java.util.Date;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.utils.QueryUtil;
import org.compiere.model.MInOut;
import org.compiere.model.MInOutLine;
import org.compiere.model.MOrder;
import org.compiere.model.MOrderLine;
import org.compiere.model.MWarehouse;
import org.compiere.model.PO;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.osgi.service.event.Event;

public class OrderLineModelEvent extends AbstractEventHandler {

	@Override
	protected void initialize() {
		registerEvent(IEventTopics.DOC_AFTER_COMPLETE);
		registerTableEvent(IEventTopics.PO_BEFORE_NEW, MOrderLine.Table_Name);
		registerTableEvent(IEventTopics.PO_BEFORE_CHANGE, MOrderLine.Table_Name);
	}

	@Override
	protected void doHandleEvent(Event event) {
		MOrder order = null;
		MOrderLine_BH orderLine = null;
		PO persistantObject = getPO(event);
		if (persistantObject instanceof MOrder) {
			order = (MOrder) persistantObject;
			if (order.isSOTrx()) {
				return;
			}
		} else if (persistantObject instanceof MOrderLine_BH) {
			orderLine = (MOrderLine_BH) persistantObject;
		} else {
			return;
		}

		if (event.getTopic().equals(IEventTopics.PO_BEFORE_NEW)
				|| event.getTopic().equals(IEventTopics.PO_BEFORE_CHANGE)) {
			beforeSaveRequest(orderLine);
		} else if (event.getTopic().equals(IEventTopics.DOC_AFTER_COMPLETE)) {
			createMaterialReceiptFromOrder(order);
		}
	}

	/**
	 * Create an attribute set instance with guarantee date
	 *
	 * @param orderLine
	 */
	private void beforeSaveRequest(MOrderLine_BH orderLine) {
		MOrder order = (MOrder) orderLine.getC_Order();
		boolean isReceiveGoods = !order.isSOTrx();
		if (!order.isComplete() && (isReceiveGoods || orderLine.getBH_Expiration() != null)) {
			receiveGoodsBeforeSaveRequest(orderLine);
		}
	}

	private void receiveGoodsBeforeSaveRequest(MOrderLine_BH orderLine) {
		if (orderLine.getBH_Expiration() != null && orderLine.getBH_Expiration().before(new Date())) {
			throw new RuntimeException("Expiration should be a future date");
		}

		int attributeSetInstanceId = QueryUtil.createExpirationDateAttributeInstance(
				orderLine.getM_AttributeSetInstance_ID(), orderLine.getBH_Expiration(), orderLine.get_TrxName(),
				orderLine.getCtx());
		if (attributeSetInstanceId > 0) {
			orderLine.setM_AttributeSetInstance_ID(attributeSetInstanceId);
		}
	}

	private void createMaterialReceiptFromOrder(MOrder order) {
		// Create Material Receipt header
		Timestamp movementDate = order.getDateOrdered() != null ? order.getDateOrdered()
				: new Timestamp(System.currentTimeMillis());
		int C_DocTypeShipment_ID = DB.getSQLValue(order.get_TrxName(),
				"SELECT C_DocTypeShipment_ID FROM C_DocType WHERE printname=?", "Order Confirmation");
		MInOut mReceipt = new MInOut(order, C_DocTypeShipment_ID, movementDate);

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
}
