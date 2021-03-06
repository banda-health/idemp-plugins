package org.bandahealth.idempiere.base.modelevent;

import java.sql.Timestamp;
import java.util.Date;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.utils.QueryUtil;
import org.compiere.model.MDocType;
import org.compiere.model.MInOut;
import org.compiere.model.MInOutLine;
import org.compiere.model.MOrderLine;
import org.compiere.model.MWarehouse;
import org.compiere.model.PO;
import org.compiere.model.Query;
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
		MOrder_BH order = null;
		PO persistantObject = getPO(event);
		if (persistantObject instanceof MOrder_BH) {
			order = (MOrder_BH) persistantObject;
			if (order.isSOTrx()) {
				return;
			}
		} else {
			return;
		}

		if (event.getTopic().equals(IEventTopics.DOC_AFTER_COMPLETE)) {
			createMaterialReceiptFromOrder(order);
		}
	}

	private void createMaterialReceiptFromOrder(MOrder_BH order) {
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
}
