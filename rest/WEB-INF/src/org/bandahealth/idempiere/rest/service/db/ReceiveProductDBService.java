package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.rest.model.AttributeSetInstance;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.OrderLine;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.model.ReceiveProduct;
import org.bandahealth.idempiere.rest.model.Warehouse;
import org.compiere.model.MOrder;
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

	public BaseListResponse<ReceiveProduct> getAll(Paging pagingInfo, String sortJson, String filterJson) {
		List<Object> parameters = new ArrayList<>();
		parameters.add("N");

		String join = "JOIN " + MBPartner_BH.Table_Name + " ON " + MBPartner_BH.Table_Name + "."
				+ MBPartner_BH.COLUMNNAME_C_BPartner_ID + "=" + MOrder_BH.Table_Name + "."
				+ MOrder_BH.COLUMNNAME_C_BPartner_ID;

		return super.getAll(MOrder_BH.COLUMNNAME_IsSOTrx + "=?", parameters, pagingInfo, sortJson, filterJson, join);
	}

	@Override
	public BaseListResponse<ReceiveProduct> search(String searchValue, Paging pagingInfo, String sortColumn,
			String sortOrder) {
		List<Object> parameters = new ArrayList<>();

		String whereClause = MOrder_BH.COLUMNNAME_IsSOTrx + "=?";
		parameters.add("N");

		return super.search(searchValue, pagingInfo, sortColumn, sortOrder, whereClause, parameters);
	}

	@Override
	protected void beforeSave(ReceiveProduct entity, MOrder_BH mOrder) {
		if (entity.getVendor() != null && entity.getVendor().getUuid() != null) {
			MBPartner_BH vendor = vendorDBService.getEntityByUuidFromDB(entity.getVendor().getUuid());
			mOrder.setC_BPartner_ID(vendor.get_ID());
		}

		mOrder.setIsSOTrx(false);
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
					orderLineDBService.getOrderLinesByOrderIds(Collections.singleton(instance.get_ID())).get(instance.get_ID()));
			result.setWarehouse(new Warehouse((MWarehouse_BH) instance.getM_Warehouse()));

			// Get any ASIs that need to be added
			Set<Integer> attributeSetInstanceIds =
					result.getOrderLines().stream().map(OrderLine::getAttributeSetInstanceId)
							.filter(attributeSetInstanceId -> attributeSetInstanceId > 0).collect(Collectors.toSet());
			Map<Integer, MAttributeSetInstance_BH> attributeSetInstancesById =
					attributeSetInstanceIds.isEmpty() ? new HashMap<>() :
							attributeSetInstanceDBService.getByIds(attributeSetInstanceIds);

			result.getOrderLines().forEach(orderLine -> {
				if (attributeSetInstancesById.containsKey(orderLine.getAttributeSetInstanceId())) {
					orderLine.setAttributeSetInstance(
							new AttributeSetInstance(attributeSetInstancesById.get(orderLine.getAttributeSetInstanceId())));
				}
				if (orderLine.getProduct() != null) {
					orderLine.setProduct(
							productDBService.batchChildDataCalls(Collections.singletonList(orderLine.getProduct())).get(0));
				}
			});

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
