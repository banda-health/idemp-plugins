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
import org.compiere.model.MStorageOnHand;
import org.compiere.model.MWarehouse;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.process.DocAction;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.compiere.util.Msg;
import org.osgi.service.event.Event;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.util.logging.Level;

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

	/**
	 * This is largely copied from {@link org.compiere.model.MOrder#createShipment(MDocType, Timestamp)} and meant to
	 * apply for purchase orders
	 *
	 * @param order The order to create a shipment off of
	 */
	private void createMaterialReceiptFromPurchaseOrder(MOrder_BH order) {
		// Create Material Receipt header
		Timestamp movementDate = order.getDateOrdered() != null ? order.getDateOrdered()
				: new Timestamp(System.currentTimeMillis());
		MDocType shipmentDocumentType = MDocType.getOfDocBaseType(Env.getCtx(), MDocType.DOCBASETYPE_MaterialReceipt)[0];

		MInOut shipment = new MInOut(order, shipmentDocumentType.get_ID(), movementDate);
		//	shipment.setDateAcct(getDateAcct());
		if (!shipment.save(order.get_TrxName())) {
			throw new AdempiereException("Could not create Shipment");
		}
		//
		MOrderLine[] oLines = order.getLines(true, null);
		for (MOrderLine oLine : oLines) {
			MInOutLine ioLine = new MInOutLine(shipment);
			//	Qty = Ordered - Delivered
			BigDecimal MovementQty = oLine.getQtyOrdered().subtract(oLine.getQtyDelivered());
			if (MovementQty.signum() == 0 && order.getProcessedOn().signum() != 0) {
				// do not create lines with qty = 0 when the order is reactivated and completed again
				continue;
			}
			//	Location
			int M_Locator_ID = MStorageOnHand.getM_Locator_ID(oLine.getM_Warehouse_ID(), oLine.getM_Product_ID(),
					oLine.getM_AttributeSetInstance_ID(), MovementQty, order.get_TrxName());
			//	Get default Location
			if (M_Locator_ID == 0) {
				MWarehouse wh = MWarehouse.get(order.getCtx(), oLine.getM_Warehouse_ID());
				M_Locator_ID = wh.getDefaultLocator().getM_Locator_ID();
			}

			ioLine.setOrderLine(oLine, M_Locator_ID, MovementQty);
			ioLine.setQty(MovementQty);
			if (oLine.getQtyEntered().compareTo(oLine.getQtyOrdered()) != 0) {
				ioLine.setQtyEntered(MovementQty
						.multiply(oLine.getQtyEntered())
						.divide(oLine.getQtyOrdered(), 6, RoundingMode.HALF_UP));
			}
			if (!ioLine.save(order.get_TrxName())) {
				throw new AdempiereException("Could not create Shipment Line");
			}
		}

		if (!shipment.processIt(DocAction.ACTION_Complete)) {
			throw new AdempiereException(
					Msg.getMsg(order.getCtx(), "FailedProcessingDocument") + " - " + shipment.getProcessMsg());
		}
		shipment.saveEx(order.get_TrxName());
	}

	private void afterPurchaseOrderVoid(MOrder_BH order) {
		// Get the material receipt associated with this order, if any
		MInOut materialReceipt = new Query(Env.getCtx(), MInOut.Table_Name, MInOut.COLUMNNAME_C_Order_ID + "=?",
				order.get_TrxName()).setParameters(order.getC_Order_ID()).setClient_ID().first();
		if (materialReceipt == null) {
			return;
		}
		// "Void" the material receipt as well
		if (!materialReceipt.processIt(MInOut.ACTION_Reverse_Accrual)) {
			throw new AdempiereException(materialReceipt.getProcessMsg());
		}
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
