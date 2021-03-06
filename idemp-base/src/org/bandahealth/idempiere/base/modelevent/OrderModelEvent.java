package org.bandahealth.idempiere.base.modelevent;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.utils.QueryConstants;
import org.compiere.model.MDocType;
import org.compiere.model.MInOut;
import org.compiere.model.MOrder;
import org.compiere.model.MRoleOrgAccess;
import org.compiere.model.MUserOrgAccess;
import org.compiere.model.MWarehouse;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.util.AdempiereSystemError;
import org.compiere.util.Env;
import org.osgi.service.event.Event;

public class OrderModelEvent extends AbstractEventHandler {

	private int clientId = -1;

	@Override
	protected void doHandleEvent(Event event) {
		MOrder_BH order = null;
		PO persistantObject = getPO(event);
		clientId = persistantObject.getAD_Client_ID();
		if (persistantObject instanceof MOrder_BH) {
			order = (MOrder_BH) persistantObject;
		} else {
			return;
		}

		boolean isPurchase = true;
		if (order.isSOTrx()) {
			order.setBH_Isexpense(false);
			isPurchase = false;
		}

		if (event.getTopic().equals(IEventTopics.PO_BEFORE_NEW)) {
			if (!isPurchase) {
				beforeSalesOrderSaveRequest(order);
			}
		} else if (event.getTopic().equals(IEventTopics.PO_AFTER_NEW)) {
//			afterSaveRequest(businessPartner);
		} else if (event.getTopic().equals(IEventTopics.PO_BEFORE_CHANGE)) {
			if (!isPurchase) {
				beforeSalesOrderUpdateRequest(order);
			}
		} else if (event.getTopic().equals(IEventTopics.DOC_AFTER_VOID)) {
			if (isPurchase) {
				afterPurchaseOrderVoid(order);
			}
		} else if (event.getTopic().equals(IEventTopics.DOC_AFTER_COMPLETE)) {
			if (!isPurchase) {
				order.setBH_ProcessStage(null);
			}
		}
	}

	private void afterPurchaseOrderVoid(MOrder_BH order) {
		// Get the material receipt associated with this order, if any
		MInOut materialReceipt =
				new Query(Env.getCtx(), MInOut.Table_Name, MInOut.COLUMNNAME_C_Order_ID + "=?", order.get_TrxName())
						.setParameters(order.getC_Order_ID()).setClient_ID().first();
		if (materialReceipt == null) {
			return;
		}
		// "Void" the material receipt as well, which is a "RA" for them
		materialReceipt.processIt(MInOut.ACTION_Reverse_Accrual);
		// Since processing an entity doesn't save it, now save it
		materialReceipt.saveEx();
	}

	private void beforeSalesOrderSaveRequest(MOrder_BH salesOrder) {

		int userId = Env.getAD_User_ID(Env.getCtx());

		if (salesOrder.getM_Warehouse_ID() == 0) {
			MWarehouse[] warehouses = MWarehouse.getForOrg(Env.getCtx(), salesOrder.getAD_Org_ID());
			if (warehouses.length == 0) {
				throw new Error(new AdempiereSystemError("No warehouses are assigned to this organization."));
			}
			salesOrder.setM_Warehouse_ID(warehouses[0].getM_Warehouse_ID());
		}

		salesOrder.setSalesRep_ID(userId);

		String WHERE = MDocType.COLUMNNAME_DocSubTypeSO + " = ? AND " + MDocType.COLUMNNAME_AD_Client_ID + " = ?";

		int posOrderDocTypeId = (new Query(Env.getCtx(), MDocType.Table_Name, WHERE, null))
				.setParameters(MOrder.DocSubTypeSO_POS, clientId)
				.firstId();
		salesOrder.setC_DocType_ID(posOrderDocTypeId);
		salesOrder.setC_DocTypeTarget_ID(posOrderDocTypeId);

		salesOrder.setPaymentRule(MOrder.PAYMENTRULE_Cash);
	}

	private void beforeSalesOrderUpdateRequest(MOrder_BH salesOrder) {
		String WHERE = MDocType.COLUMNNAME_DocSubTypeSO + " = ? AND " + MDocType.COLUMNNAME_AD_Client_ID + " = ?";

		int posOrderDocTypeId = (new Query(Env.getCtx(), MDocType.Table_Name, WHERE, null))
				.setParameters(MOrder.DocSubTypeSO_POS, clientId)
				.firstId();

		MDocType docType = MDocType.get(Env.getCtx(), posOrderDocTypeId);

		if (docType.getAD_Client_ID() != clientId) {
			salesOrder.setC_DocType_ID(posOrderDocTypeId);
			salesOrder.setC_DocTypeTarget_ID(posOrderDocTypeId);
		}

	}

	private int getOrganizationIDForUser(int userId, int roleId, int clientId) {
		// Check to see if they are limited to an org
		String whereClause = String.format("%1$s = ? and %2$s = ? and %3$s <> ?",
				QueryConstants.USER_ID_COLUMN_NAME,
				QueryConstants.CLIENT_ID_COLUMN_NAME,
				QueryConstants.ORGANIZATION_ID_COLUMN_NAME);
		Query query = new Query(Env.getCtx(), MUserOrgAccess.Table_Name, whereClause, null)
				.setParameters(userId, clientId, QueryConstants.BASE_ORGANIZATION_ID);
		if (query.count() == 0) {
			// The org assignment must be in the role
			whereClause = String.format("%1$s = ? and %2$s = ? and %3$s <> ?",
					QueryConstants.ROLE_ID_COLUMN_NAME,
					QueryConstants.CLIENT_ID_COLUMN_NAME,
					QueryConstants.ORGANIZATION_ID_COLUMN_NAME);
			query = new Query(Env.getCtx(), MRoleOrgAccess.Table_Name, whereClause, null)
					.setParameters(roleId, clientId, QueryConstants.BASE_ORGANIZATION_ID);
		}

		if (query.count() == 0) {
			throw new Error(new AdempiereSystemError("User not assigned to any organizations."));
		}

		return query.first().getAD_Org_ID();
	}

	@Override
	protected void initialize() {
		registerTableEvent(IEventTopics.PO_BEFORE_NEW, MOrder_BH.Table_Name);
		registerTableEvent(IEventTopics.PO_BEFORE_CHANGE, MOrder_BH.Table_Name);
		registerTableEvent(IEventTopics.DOC_AFTER_VOID, MOrder_BH.Table_Name);
		registerTableEvent(IEventTopics.DOC_AFTER_COMPLETE, MOrder_BH.Table_Name);
	}
}
