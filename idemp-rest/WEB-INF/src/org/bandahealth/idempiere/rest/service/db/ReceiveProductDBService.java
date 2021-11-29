package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.List;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.model.ReceiveProduct;
import org.bandahealth.idempiere.rest.model.Warehouse;
import org.compiere.model.MOrder;
import org.compiere.model.MWarehouse;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Receive products logic
 *
 * @author andrew
 */
@Component
public class ReceiveProductDBService extends BaseOrderDBService<ReceiveProduct> {

	@Autowired
	private VendorDBService vendorDBService;

	public BaseListResponse<ReceiveProduct> getAll(Paging pagingInfo, String sortColumn, String sortOrder,
			String filterJson) {
		List<Object> parameters = new ArrayList<>();
		parameters.add("N");

		String join = "JOIN " + MBPartner_BH.Table_Name + " ON " + MBPartner_BH.Table_Name + "."
				+ MBPartner_BH.COLUMNNAME_C_BPartner_ID + "=" + MOrder_BH.Table_Name + "."
				+ MOrder_BH.COLUMNNAME_C_BPartner_ID;

		return super.getAll(MOrder_BH.COLUMNNAME_IsSOTrx + "=? AND " + MOrder_BH.COLUMNNAME_BH_IsExpense + " IS NULL",
				parameters, pagingInfo, sortColumn, sortOrder, filterJson, join);
	}

	@Override
	public BaseListResponse<ReceiveProduct> search(String searchValue, Paging pagingInfo, String sortColumn,
			String sortOrder) {
		List<Object> parameters = new ArrayList<>();

		StringBuilder whereClause = new StringBuilder().append(MOrder_BH.COLUMNNAME_IsSOTrx).append("=?")
				.append(AND_OPERATOR).append(MOrder_BH.COLUMNNAME_BH_IsExpense).append(" IS NULL");
		parameters.add("N");

		return super.search(searchValue, pagingInfo, sortColumn, sortOrder, whereClause.toString(), parameters);
	}

	@Override
	protected void beforeSave(ReceiveProduct entity, MOrder_BH mOrder) {
		if (entity.getVendor() != null && entity.getVendor().getUuid() != null) {
			MBPartner_BH vendor = vendorDBService.getEntityByUuidFromDB(entity.getVendor().getUuid());
			mOrder.setC_BPartner_ID(vendor.get_ID());
		}

		mOrder.setIsSOTrx(false);

		// set warehouse
		Warehouse warehouse = entity.getWarehouse();
		if (warehouse != null && warehouse.getUuid() != null) {
			MWarehouse mWarehouse = new Query(Env.getCtx(), MWarehouse.Table_Name,
					MWarehouse.COLUMNNAME_M_Warehouse_UU + " =?", null).setClient_ID()
					.setParameters(warehouse.getUuid()).first();
			if (mWarehouse != null) {
				mOrder.setM_Warehouse_ID(mWarehouse.get_ID());
			}
		}
	}

	@Override
	protected void afterSave(ReceiveProduct entity, MOrder_BH mOrder) {
	}

	@Override
	protected String getDocumentTypeName() {
		return DOCUMENTNAME_RECEIVE_PRODUCT;
	}

	@Override
	protected ReceiveProduct createInstanceWithDefaultFields(MOrder_BH instance) {
		try {
			MBPartner_BH vendor = vendorDBService.getEntityByIdFromDB(instance.getC_BPartner_ID());
			if (vendor == null) {
				log.severe("Missing vendor");
				return null;
			}

			ReceiveProduct result = new ReceiveProduct(instance, vendor, null);
			result.setWarehouse(new Warehouse((MWarehouse_BH) instance.getM_Warehouse()));
			return result;
		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}
		return null;
	}

	@Override
	protected ReceiveProduct createInstanceWithAllFields(MOrder_BH instance) {
		try {
			MBPartner_BH vendor = vendorDBService.getEntityByIdFromDB(instance.getC_BPartner_ID());
			if (vendor == null) {
				log.severe("Missing vendor");
				return null;
			}

			ReceiveProduct result = new ReceiveProduct(instance, vendor,
					orderLineDBService.getOrderLinesByOrderId(instance.get_ID()));
			result.setWarehouse(new Warehouse((MWarehouse_BH) instance.getM_Warehouse()));
			return result;
		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}

	@Override
	protected ReceiveProduct createInstanceWithSearchFields(MOrder_BH instance) {
		return createInstanceWithDefaultFields(instance);
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		try {
			MOrder order = new Query(Env.getCtx(), MOrder_BH.Table_Name, MOrder.COLUMNNAME_C_Order_UU + "=?", null)
					.setParameters(entityUuid).first();
			if (order.isSOTrx()) {
				throw new AdempiereException("Document id not a receive product (PO)");
			}
			if (order.isComplete()) {
				throw new AdempiereException("Order is already completed");
			} else {
				return order.delete(false);
			}
		} catch (Exception ex) {
			throw new AdempiereException(ex.getLocalizedMessage());
		}
	}
}
