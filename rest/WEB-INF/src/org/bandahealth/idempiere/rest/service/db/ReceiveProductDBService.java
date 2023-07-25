package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.rest.model.AttributeSetInstance;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.BusinessPartner;
import org.bandahealth.idempiere.rest.model.OrderLine;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.model.Product;
import org.bandahealth.idempiere.rest.model.ReceiveProduct;
import org.bandahealth.idempiere.rest.model.Vendor;
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
	@Autowired
	private WarehouseDBService warehouseDBService;

	public BaseListResponse<ReceiveProduct> getAll(Paging pagingInfo, String sortJson, String filterJson) {
		List<Object> parameters = new ArrayList<>();
		parameters.add("N");

		String join = "JOIN " + MBPartner_BH.Table_Name + " ON " + MBPartner_BH.Table_Name + "."
				+ MBPartner_BH.COLUMNNAME_C_BPartner_ID + "=" + MOrder_BH.Table_Name + "."
				+ MOrder_BH.COLUMNNAME_C_BPartner_ID;

		return super.getAll(MOrder_BH.COLUMNNAME_IsSOTrx + "=?", parameters, pagingInfo, sortJson, filterJson, join);
	}

	@Override
	protected void beforeSave(ReceiveProduct entity, MOrder_BH mOrder) {
		if (entity.getVendor() != null && entity.getVendor().getUuid() != null) {
			MBPartner_BH vendor = vendorDBService.getEntityByUuidFromDB(entity.getVendor().getUuid());
			mOrder.setC_BPartner_ID(vendor.get_ID());
		}

		mOrder.setC_DocTypeTarget_ID(
				Arrays.stream(MDocType_BH.getOfDocBaseType(Env.getCtx(), MDocType_BH.DOCBASETYPE_PurchaseOrder))
						.filter(documentType -> documentType.getDocSubTypeSO() == null).findFirst().orElseThrow()
						.getC_DocType_ID());
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
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected ReceiveProduct createInstanceWithAllFields(MOrder_BH instance) {
		return new ReceiveProduct(instance);
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

	@Override
	public List<ReceiveProduct> transformData(List<MOrder_BH> dbModels) {
		List<ReceiveProduct> purchaseOrders = super.transformData(dbModels);

		Map<Integer, MBPartner_BH> businessPartnersById = businessPartnerDBService.getByIds(
				purchaseOrders.stream().map(ReceiveProduct::getBusinessPartnerId).collect(Collectors.toSet()));
		Map<Integer, MWarehouse_BH> warehousesById = warehouseDBService.getByIds(
				purchaseOrders.stream().map(ReceiveProduct::getWarehouseId).collect(Collectors.toSet()));
		Map<Integer, MAttributeSetInstance_BH> attributeSetInstancesById = attributeSetInstanceDBService.getByIds(
				purchaseOrders.stream().map(ReceiveProduct::getOrderLines).flatMap(Collection::stream)
						.map(OrderLine::getAttributeSetInstanceId).filter(attributeSetInstanceId -> attributeSetInstanceId > 0)
						.collect(Collectors.toSet()));
		Map<Integer, Product> productsByIds = productDBService.transformData(new ArrayList<>(productDBService.getByIds(
						purchaseOrders.stream().map(ReceiveProduct::getOrderLines).flatMap(Collection::stream)
								.map(OrderLine::getProductId).collect(Collectors.toSet())).values())).stream()
				.collect(Collectors.toMap(Product::getId, product -> product));

		return purchaseOrders.stream().peek(purchaseOrder -> {
			if (warehousesById.containsKey(purchaseOrder.getWarehouseId())) {
				purchaseOrder.setWarehouse(new Warehouse((warehousesById.get(purchaseOrder.getWarehouseId()))));
			}
			purchaseOrder.getOrderLines().forEach(orderLine -> {
				if (attributeSetInstancesById.containsKey(orderLine.getAttributeSetInstanceId())) {
					orderLine.setAttributeSetInstance(
							new AttributeSetInstance(attributeSetInstancesById.get(orderLine.getAttributeSetInstanceId())));
				}
				if (productsByIds.containsKey(orderLine.getProductId())) {
					orderLine.setProduct(productsByIds.get(orderLine.getProductId()));
				}
			});
			purchaseOrder.setVendor(new Vendor(businessPartnersById.get(purchaseOrder.getBusinessPartnerId())));
		}).collect(Collectors.toList());
	}

	@Override
	public ReceiveProduct getEntity(String uuid) {
		return transformData(Collections.singletonList(getEntityByUuidFromDB(uuid))).get(0);
	}
}
