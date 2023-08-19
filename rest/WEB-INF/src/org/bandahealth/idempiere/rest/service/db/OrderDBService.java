package org.bandahealth.idempiere.rest.service.db;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MBHVoidedReason;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.rest.model.AttributeSetInstance;
import org.bandahealth.idempiere.rest.model.BusinessPartner;
import org.bandahealth.idempiere.rest.model.DocumentType;
import org.bandahealth.idempiere.rest.model.Order;
import org.bandahealth.idempiere.rest.model.OrderLine;
import org.bandahealth.idempiere.rest.model.Product;
import org.bandahealth.idempiere.rest.model.Warehouse;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MOrder;
import org.compiere.model.MWarehouse;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Order (c_order) base functionality (billing, receive goods, track expenses).
 *
 * @author andrew
 */
@Component
public class OrderDBService extends DocumentDBService<Order, MOrder_BH> {
	@Autowired
	protected OrderLineDBService orderLineDBService;
	@Autowired
	protected EntityMetadataDBService entityMetadataDBService;
	@Autowired
	protected VoidedReasonDBService voidedReasonDBService;
	@Autowired
	protected AttributeSetInstanceDBService attributeSetInstanceDBService;
	@Autowired
	protected ProductDBService productDBService;
	@Autowired
	protected BusinessPartnerDBService businessPartnerDBService;
	@Autowired
	protected DocumentTypeDBService documentTypeDBService;
	@Autowired
	private WarehouseDBService warehouseDBService;

	@Override
	public Order saveEntity(Order entity) {
		try {
			MDocType_BH documentTypeTarget;
			if (entity.getDocumentTypeTarget() == null ||
					StringUtil.isNullOrEmpty(entity.getDocumentTypeTarget().getUuid()) || (documentTypeTarget =
					documentTypeDBService.getEntityByUuidFromDB(entity.getDocumentTypeTarget().getUuid())) == null) {
				throw new AdempiereException("Document Type is required");
			}

			MOrder_BH mOrder = getEntityByUuidFromDB(entity.getUuid());
			if (mOrder == null) {
				mOrder = getModelInstance();
				if (!StringUtil.isNullOrEmpty(entity.getUuid())) {
					mOrder.setC_Order_UU(entity.getUuid());
				}
			}

			mOrder.setC_DocTypeTarget_ID(documentTypeTarget.get_ID());
			mOrder.setIsSOTrx(documentTypeTarget.isSOTrx());

			if (entity.getDateOrdered() != null) {
				mOrder.setDateOrdered(entity.getDateOrdered());
			}

			if (StringUtil.isNotNullAndEmpty(entity.getDescription())) {
				mOrder.setDescription(entity.getDescription());
			}

			mOrder.setBH_Visit_ID(entity.getVisitId());
			mOrder.setIsActive(entity.getIsActive());

			mOrder.setIsApproved(true);
			mOrder.setDocAction(MOrder_BH.DOCACTION_Complete);

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

			if (entity.getVoidedReason() != null && entity.getVoidedReason().getUuid() != null) {
				MBHVoidedReason voidingReason =
						voidedReasonDBService.getEntityByUuidFromDB(entity.getVoidedReason().getUuid());
				if (voidingReason != null) {
					mOrder.setBH_Voided_Reason_ID(voidingReason.get_ID());
				}
			}

			MBPartner_BH businessPartner;
			if (entity.getBusinessPartner() != null && entity.getBusinessPartner().getUuid() != null &&
					(businessPartner = businessPartnerDBService.getEntityByUuidFromDB(entity.getBusinessPartner().getUuid())) !=
							null) {
				mOrder.setBPartner(businessPartner);
			}

			mOrder.saveEx();

			// list of persisted order line ids
			String lineIds = "";
			// persist product/service/charge order lines
			List<OrderLine> orderLines = entity.getOrderLines();

			if (orderLines != null && !orderLines.isEmpty()) {
				// Get the ASI batches, if any should be there
				Set<String> attributeSetInstanceUuids =
						orderLines.stream().map(OrderLine::getAttributeSetInstance).filter(Objects::nonNull)
								.map(AttributeSetInstance::getUuid).filter(StringUtil::isNotNullAndEmpty).collect(Collectors.toSet());
				Map<String, MAttributeSetInstance_BH> attributeSetInstancesByUuid =
						attributeSetInstanceDBService.getByUuids(attributeSetInstanceUuids);
				int count = 0;
				for (OrderLine orderLine : orderLines) {
					orderLine.setOrderId(mOrder.get_ID());
					orderLine.setOrder(mOrder);

					// Set the ASI ID, if need be
					if (orderLine.getAttributeSetInstance() != null &&
							!StringUtil.isNullOrEmpty(orderLine.getAttributeSetInstance().getUuid()) &&
							attributeSetInstancesByUuid.containsKey(orderLine.getAttributeSetInstance().getUuid())) {
						orderLine.setAttributeSetInstanceId(
								attributeSetInstancesByUuid.get(orderLine.getAttributeSetInstance().getUuid()).get_ID());
					}

					OrderLine response = orderLineDBService.saveEntity(orderLine);
					lineIds += "'" + response.getUuid() + "'";
					if (++count < orderLines.size()) {
						lineIds += ",";
					}
				}
			}

			// delete order lines not in request
			orderLineDBService.deleteOrderLinesByOrder(mOrder.get_ID(), lineIds);

			return transformData(Collections.singletonList(getEntityByUuidFromDB(mOrder.getC_Order_UU()))).get(0);

		} catch (Exception ex) {
			ex.printStackTrace();
			log.severe(ex.getMessage());

			throw new AdempiereException(ex.getLocalizedMessage());
		}
	}

	@Override
	protected MOrder_BH getModelInstance() {
		return new MOrder_BH(Env.getCtx(), 0, null);
	}

	@Override
	int getDocumentProcessId() {
		return MProcess_BH.PROCESSID_PROCESS_ORDERS;
	}

	@Override
	public List<Order> transformData(List<MOrder_BH> dbModels) {
		if (dbModels == null || dbModels.isEmpty()) {
			return new ArrayList<>();
		}
		// Batch orders
		Map<Integer, List<OrderLine>> orderLinesByOrderId = orderLineDBService.transformData(
						orderLineDBService.getGroupsByIds(MOrderLine_BH::getC_Order_ID, MOrderLine_BH.COLUMNNAME_C_Order_ID,
										dbModels.stream().map(MOrder_BH::get_ID).collect(Collectors.toSet())).values().stream()
								.flatMap(Collection::stream).collect(Collectors.toList())).stream()
				.collect(Collectors.groupingBy(OrderLine::getOrderId));

		// Batch business partners
		Map<Integer, BusinessPartner> businessPartnersById = businessPartnerDBService.transformData(
						new ArrayList<>(businessPartnerDBService.getByIds(
								dbModels.stream().map(MOrder_BH::getC_BPartner_ID).collect(Collectors.toSet())).values())).stream()
				.collect(Collectors.toMap(BusinessPartner::getId, businessPartner -> businessPartner));

		// Batch warehouses
		Map<Integer, MWarehouse_BH> warehousesById =
				warehouseDBService.getByIds(dbModels.stream().map(MOrder_BH::getM_Warehouse_ID).collect(Collectors.toSet()));
		Map<Integer, MAttributeSetInstance_BH> attributeSetInstancesById = attributeSetInstanceDBService.getByIds(
				orderLinesByOrderId.values().stream().flatMap(Collection::stream).map(OrderLine::getAttributeSetInstanceId)
						.filter(attributeSetInstanceId -> attributeSetInstanceId > 0).collect(Collectors.toSet()));
		Map<Integer, Product> productsByIds = productDBService.transformData(new ArrayList<>(productDBService.getByIds(
						orderLinesByOrderId.values().stream().flatMap(Collection::stream).map(OrderLine::getProductId)
								.collect(Collectors.toSet())).values())).stream()
				.collect(Collectors.toMap(Product::getId, product -> product));
		Map<Integer, MDocType_BH> documentTypesById = documentTypeDBService.getByIds(
				dbModels.stream().map(MOrder_BH::getC_DocTypeTarget_ID).collect(Collectors.toSet()));

		return dbModels.stream().map(order -> {
			Order entity = createInstanceWithDefaultFields(order);
			entity.setOrderLines(orderLinesByOrderId.getOrDefault(entity.getId(), new ArrayList<>()));
			entity.setBusinessPartner(businessPartnersById.get(order.getC_BPartner_ID()));

			if (warehousesById.containsKey(entity.getWarehouseId())) {
				entity.setWarehouse(new Warehouse((warehousesById.get(entity.getWarehouseId()))));
			}
			if (documentTypesById.containsKey(order.getC_DocTypeTarget_ID())) {
				entity.setDocumentTypeTarget(new DocumentType(documentTypesById.get(order.getC_DocTypeTarget_ID())));
			}
			entity.getOrderLines().forEach(orderLine -> {
				if (attributeSetInstancesById.containsKey(orderLine.getAttributeSetInstanceId())) {
					orderLine.setAttributeSetInstance(
							new AttributeSetInstance(attributeSetInstancesById.get(orderLine.getAttributeSetInstanceId())));
				}
				if (productsByIds.containsKey(orderLine.getProductId())) {
					orderLine.setProduct(productsByIds.get(orderLine.getProductId()));
				}
			});
			return entity;
		}).collect(Collectors.toList());
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		MOrder_BH order =
				new Query(Env.getCtx(), MOrder_BH.Table_Name, MOrder.COLUMNNAME_C_Order_UU + "=?", null).setParameters(
						entityUuid).first();
		if (order.isComplete()) {
			throw new AdempiereException("Order is already completed");
		} else {
			return order.delete(false);
		}
	}

	@Override
	protected Order createInstanceWithDefaultFields(MOrder_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected Order createInstanceWithAllFields(MOrder_BH instance) {
		return new Order(instance);
	}

	@Override
	public Order getEntity(String uuid) {
		return transformData(Collections.singletonList(getEntityByUuidFromDB(uuid))).get(0);
	}

	@Override
	int getDocumentTypeId(MOrder_BH entity) {
		return entity.getC_DocTypeTarget_ID();
	}
}
