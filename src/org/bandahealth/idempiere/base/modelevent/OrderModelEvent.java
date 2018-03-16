package org.bandahealth.idempiere.base.modelevent;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventTopics;
import org.bandahealth.idempiere.base.utils.QueryConstants;
import org.compiere.model.I_AD_Role_OrgAccess;
import org.compiere.model.I_AD_User_OrgAccess;
import org.compiere.model.I_C_DocType;
import org.compiere.model.I_C_Order;
import org.compiere.model.I_M_Warehouse;
import org.compiere.model.MOrder;
import org.compiere.model.MWarehouse;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.util.AdempiereSystemError;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.osgi.service.event.Event;

public class OrderModelEvent extends AbstractEventHandler {

	private CLogger log = CLogger.getCLogger(OrderModelEvent.class);

	@Override
	protected void doHandleEvent(Event event) {
		log.info("Made it here");

		MOrder order = null;
		PO persistantObject = getPO(event);
		if (persistantObject instanceof MOrder) {
			order = (MOrder) persistantObject;
		} else {
			return;
		}

		boolean isPurchase = true;
		if (order.isSOTrx()) {
			isPurchase = false;
		}

		if (event.getTopic().equals(IEventTopics.PO_BEFORE_NEW)) {
			if (!isPurchase) {
				beforeSalesOrderSaveRequest(order);
			}
		} else if (event.getTopic().equals(IEventTopics.PO_AFTER_NEW)) {
//			afterSaveRequest(businessPartner);
		}
	}

	private void beforeSalesOrderSaveRequest(MOrder salesOrder) {

		int userId = Env.getAD_User_ID(Env.getCtx());

		if (salesOrder.getM_Warehouse_ID() == 0) {
			MWarehouse[] warehouses = MWarehouse.getForOrg(Env.getCtx(), salesOrder.getAD_Org_ID());
			if (warehouses.length == 0) {
				throw new Error(new AdempiereSystemError("No warehouses are assigned to this organization."));
			}
			salesOrder.setM_Warehouse_ID(warehouses[0].getM_Warehouse_ID());
		}

		salesOrder.setSalesRep_ID(userId);

		int posOrderDocType = (new Query(Env.getCtx(), I_C_DocType.Table_Name, I_C_DocType.COLUMNNAME_DocSubTypeSO
				+ " = '" + MOrder.DocSubTypeSO_POS + "'", null)).firstId();
		salesOrder.setC_DocType_ID(posOrderDocType);
	}

	private int getOrganizationIDForUser(int userId, int roleId, int clientId) {
		// Check to see if they are limited to an org
		Query query = new Query(Env.getCtx(), I_AD_User_OrgAccess.Table_Name, QueryConstants.USER_ID_COLUMN_NAME
				+ " = " + userId + " and " + QueryConstants.CLIENT_ID_COLUMN_NAME + " = " + clientId + " and "
				+ QueryConstants.ORGANIZATION_ID_COLUMN_NAME + " <> " + QueryConstants.BASE_ORGANIZATION_ID, null);
		if (query.count() == 0) {
			// The org assignment must be in the role
			query = new Query(Env.getCtx(), I_AD_Role_OrgAccess.Table_Name,  QueryConstants.ROLE_ID_COLUMN_NAME
					+ " = " + roleId + " and " + QueryConstants.CLIENT_ID_COLUMN_NAME + " = " + clientId + " and "
					+ QueryConstants.ORGANIZATION_ID_COLUMN_NAME + " <> " + QueryConstants.BASE_ORGANIZATION_ID, null);
		}

		if (query.count() == 0) {
			throw new Error(new AdempiereSystemError("User not assigned to any organizations."));
		}

		return query.first().getAD_Org_ID();
	}

	@Override
	protected void initialize() {
		registerTableEvent(IEventTopics.PO_BEFORE_NEW, I_C_Order.Table_Name);
//		registerTableEvent(IEventTopics.PO_AFTER_NEW, I_C_Order.Table_Name);
	}
}
