package org.bandahealth.idempiere.rest.service.db;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MBHVoidedReason;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.rest.model.AttributeSetInstance;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Order;
import org.bandahealth.idempiere.rest.model.OrderLine;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.model.VoidedReason;
import org.bandahealth.idempiere.rest.model.Warehouse;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MDocType;
import org.compiere.model.MWarehouse;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Order (c_order) base functionality (billing, receive goods, track expenses).
 *
 * @param <T>
 * @author andrew
 */
public abstract class BaseOrderDBService<T extends Order> extends DocumentDBService<T, MOrder_BH> {

	private final String PURCHASE_ORDER = "Purchase Order";
	@Autowired
	protected OrderLineDBService orderLineDBService;
	@Autowired
	protected EntityMetadataDBService entityMetadataDBService;
	@Autowired
	protected ProcessDBService processDBService;
	@Autowired
	protected VoidedReasonDBService voidedReasonDBService;
	@Autowired
	protected AttributeSetInstanceDBService attributeSetInstanceDBService;
	@Autowired
	protected ProductDBService productDBService;

	protected abstract void beforeSave(T entity, MOrder_BH mOrder);

	protected abstract void afterSave(T entity, MOrder_BH mOrder);

	/**
	 * Search an order by patient/vendor name
	 *
	 * @param value
	 * @param pagingInfo
	 * @param sortColumn
	 * @param sortOrder
	 * @return
	 */
	@Override
	public BaseListResponse<T> search(String value, Paging pagingInfo, String sortColumn, String sortOrder) {
		return this.search(value, pagingInfo, sortColumn, sortOrder, null, null);
	}

	/**
	 * Search an order by patient/vendor name
	 *
	 * @param value
	 * @param pagingInfo
	 * @param sortColumn
	 * @param sortOrder
	 * @param initialWhereClause an optional where clause to filter results
	 * @param parameters         an optional parameters list for use in the where
	 *                           clause
	 * @return
	 */
	public BaseListResponse<T> search(String value, Paging pagingInfo, String sortColumn, String sortOrder,
			String initialWhereClause, List<Object> parameters) {
		if (parameters == null) {
			parameters = new ArrayList<>();
		}

		// Do this first because parameters would've already been added to the array if
		// so
		StringBuilder whereClause = new StringBuilder();
		if (initialWhereClause != null && !initialWhereClause.isEmpty()) {
			whereClause.append(initialWhereClause).append(AND_OPERATOR);
		}

		// search patient
		whereClause.append("(").append(MBPartner_BH.Table_Name).append(".").append(MBPartner_BH.COLUMNNAME_BH_PatientID)
				.append("=?").append(OR_OPERATOR).append("LOWER(").append(MBPartner_BH.Table_Name).append(".")
				.append(MBPartner_BH.COLUMNNAME_Name).append(") ").append(LIKE_COMPARATOR).append(" ?)");
		parameters.add(value);
		parameters.add(constructSearchValue(value));

		Query query = new Query(Env.getCtx(), getModelInstance().get_TableName(), whereClause.toString(), null)
				.addJoinClause("JOIN " + MBPartner_BH.Table_Name + " ON " + MOrder_BH.Table_Name + "."
						+ MOrder_BH.COLUMNNAME_C_BPartner_ID + " = " + MBPartner_BH.Table_Name + "."
						+ MBPartner_BH.COLUMNNAME_C_BPartner_ID)
				.setClient_ID();

		String orderBy = getOrderBy(sortColumn, sortOrder);
		if (orderBy != null) {
			query = query.setOrderBy(orderBy);
		}

		if (parameters != null) {
			query = query.setParameters(parameters);
		}

		// get total count without pagination parameters
		pagingInfo.setTotalRecordCount(query.count());

		// set pagination params
		query = query.setPage(pagingInfo.getPageSize(), pagingInfo.getPage());

		List<T> results = new ArrayList<>();
		List<MOrder_BH> entities = query.list();

		if (!entities.isEmpty()) {
			for (MOrder_BH entity : entities) {
				if (entity != null) {
					results.add(createInstanceWithSearchFields(entity));
				}
			}
		}

		return new BaseListResponse<T>(results, pagingInfo);
	}

	@Override
	public T saveEntity(T entity) {
		try {
			MOrder_BH mOrder = getEntityByUuidFromDB(entity.getUuid());
			if (mOrder == null) {
				mOrder = getModelInstance();
				if (!StringUtil.isNullOrEmpty(entity.getUuid())) {
					mOrder.setC_Order_UU(entity.getUuid());
				}
			}

			if (entity.getDateOrdered() != null) {
				mOrder.setDateOrdered(DateUtil.getTimestamp(entity.getDateOrdered()));
			}

			if (StringUtil.isNotNullAndEmpty(entity.getDescription())) {
				mOrder.setDescription(entity.getDescription());
			}

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

			beforeSave(entity, mOrder);

			// set target document type
			if (!mOrder.isSOTrx()) {
				mOrder.setC_DocTypeTarget_ID(getPurchaseOrderDocumentTypeId());
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

			// any post save operation
			afterSave(entity, mOrder);

			return createInstanceWithAllFields(getEntityByUuidFromDB(mOrder.getC_Order_UU()));

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

	/**
	 * Get Purchase Order Target Document Type
	 *
	 * @return
	 */
	protected int getPurchaseOrderDocumentTypeId() {
		// set target document type
		MDocType docType = new Query(Env.getCtx(), MDocType.Table_Name,
				MDocType.COLUMNNAME_Name + "=? AND " + MDocType.COLUMNNAME_DocBaseType + "=?", null)
				.setParameters(PURCHASE_ORDER, MDocType.DOCBASETYPE_PurchaseOrder).setClient_ID().first();
		if (docType != null) {
			return docType.get_ID();
		}

		return 0;
	}

	@Override
	public T saveAndProcessEntity(T entity, String docAction) throws Exception {
		// Orders that have already been processed can't be saved again
		MOrder_BH order = getEntityByUuidFromDB(entity.getUuid());

		if (order != null) {
			if (docAction.equals(MOrder_BH.DOCACTION_Void)) {
				// set voided reason
				VoidedReason voidedReason = entity.getVoidedReason();
				if (voidedReason != null && StringUtil.isNotNullAndEmpty(voidedReason.getUuid())) {
					MBHVoidedReason mVoidedReason = voidedReasonDBService.getEntityByUuidFromDB(voidedReason.getUuid());
					if (mVoidedReason != null) {
						order.setBH_VoidedReasonID(mVoidedReason.get_ID());
						order.saveEx();
					}
				}
			}

			// If this order is complete already (i.e. we're voiding/re-activating), we shouldn't save it
			if (order.isComplete()) {
				return processEntity(entity.getUuid(), docAction);
			}
		}

		return super.saveAndProcessEntity(entity, docAction);
	}
}
