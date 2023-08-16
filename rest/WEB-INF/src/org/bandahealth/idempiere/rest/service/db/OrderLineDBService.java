package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHPayerInfoField;
import org.bandahealth.idempiere.base.model.MBHBPSpecificPayerInfo;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.rest.model.Charge;
import org.bandahealth.idempiere.rest.model.OrderLine;
import org.bandahealth.idempiere.rest.model.BusinessPartnerSpecificPayerInformation;
import org.bandahealth.idempiere.rest.model.Product;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.bandahealth.idempiere.rest.utils.QueryUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * OrderLine (product/service/charge) db service
 *
 * @author andrew
 */
@Component
public class OrderLineDBService extends BaseDBService<OrderLine, MOrderLine_BH> {

	@Autowired
	private BusinessPartnerSpecificPayerInformationDBService businessPartnerSpecificPayerInformationDBService;
	@Autowired
	private ChargeDBService chargeDBService;
	@Autowired
	private PayerInformationFieldDBService payerInformationFieldDBService;
	@Autowired
	private ProductDBService productDBService;
	@Autowired
	private StorageOnHandDBService storageOnHandDBService;

	@Override
	public OrderLine saveEntity(OrderLine entity) {
		MOrderLine_BH mOrderLine = getEntityByUuidFromDB(entity.getUuid());
		if (mOrderLine == null) {
			mOrderLine = new MOrderLine_BH(Env.getCtx(), 0, null);
			mOrderLine.setAD_Org_ID(Env.getAD_Org_ID(Env.getCtx()));
			if (!StringUtil.isNullOrEmpty(entity.getUuid())) {
				mOrderLine.setC_OrderLine_UU(entity.getUuid());
			}
		}

		if (entity.getOrderId() != null) {
			mOrderLine.setC_Order_ID(entity.getOrderId());
			// Take care that price lists and other things are set on the order line from
			// the header
			mOrderLine.setHeaderInfo(entity.getOrder());
		}

		if (entity.getProduct() != null) {
			MProduct_BH product = productDBService.getEntityByUuidFromDB(entity.getProduct().getUuid());

			if (product != null) {
				mOrderLine.setM_Product_ID(product.get_ID());
			}
		}

		if (entity.getPrice() != null) {
			// We can't override the price to zero if we don't first set the price generally
			mOrderLine.setPrice();
			mOrderLine.setPrice(entity.getPrice());
		}

		if (entity.getQuantity() != null) {
			mOrderLine.setQty(entity.getQuantity());
		}

		// only save for receive products
		if (entity.getLineNetAmount() != null) {
			mOrderLine.setLineNetAmt(entity.getLineNetAmount());
		}

		if (entity.getAttributeSetInstanceId() != null) {
			mOrderLine.setM_AttributeSetInstance_ID(entity.getAttributeSetInstanceId());
		}

		if (StringUtil.isNotNullAndEmpty(entity.getInstructions())) {
			mOrderLine.setBH_Instructions(entity.getInstructions());
		}

		mOrderLine.setIsActive(entity.getIsActive());

		// Set the charge relationship, if it exists
		if (entity.getChargeId() > 0) {
			mOrderLine.setC_Charge_ID(entity.getChargeId());
		} else if (entity.getCharge() != null) {
			MCharge_BH charge = chargeDBService.getEntityByUuidFromDB(entity.getCharge().getUuid());
			if (charge != null) {
				mOrderLine.setC_Charge_ID(charge.getC_Charge_ID());
			}
		}

		mOrderLine.saveEx();
		entity.setId(mOrderLine.get_ID());

		// If there is any information to save with this line, save it
		if (entity.getBusinessPartnerSpecificPayerInformationList() != null) {
			entity.setBusinessPartnerSpecificPayerInformationList(
					entity.getBusinessPartnerSpecificPayerInformationList().stream().map(
							businessPartnerSpecificPayerInformation -> {
								businessPartnerSpecificPayerInformation.setInvoiceLineId(entity.getId());
								return businessPartnerSpecificPayerInformationDBService.saveEntity(
										businessPartnerSpecificPayerInformation);
							}).collect(Collectors.toList()));
		} else {
			entity.setBusinessPartnerSpecificPayerInformationList(new ArrayList<>());
		}
//		// Delete what is no longer there
//		List<MBHBPSpecificPayerInfo> businessPartnerSpecificPayerInformationList =
//				businessPartnerSpecificPayerInformationDBService
//						.getGroupsByIds(MBHBPSpecificPayerInfo::getC_OrderLine_ID,
//								MBHBPSpecificPayerInfo.COLUMNNAME_C_OrderLine_ID, Collections.singleton(entity.getId()))
//						.get(entity.getId());
//		if (businessPartnerSpecificPayerInformationList != null) {
//			businessPartnerSpecificPayerInformationList.stream()
//					.filter(
//							existingBusinessPartnerSpecificPayerInformation -> entity.getBusinessPartnerSpecificPayerInformationList()
//									.stream()
//									.noneMatch(
//											newBusinessPartnerSpecificPayerInformation -> newBusinessPartnerSpecificPayerInformation.getUuid()
//													.equals(existingBusinessPartnerSpecificPayerInformation.getBH_BP_Specific_Payer_Info_UU())))
//					.forEach(orderLineChargeInformation -> businessPartnerSpecificPayerInformationDBService
//							.deleteEntity(orderLineChargeInformation.getBH_BP_Specific_Payer_Info_UU()));
//		}

		return createInstanceWithAllFields(getEntityByUuidFromDB(mOrderLine.getC_OrderLine_UU()));
	}

	@Override
	protected OrderLine createInstanceWithDefaultFields(MOrderLine_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected OrderLine createInstanceWithAllFields(MOrderLine_BH instance) {
		try {
			MProduct_BH product = productDBService.getEntityByIdFromDB(instance.getM_Product_ID());
			if (product != null) {
				OrderLine orderLine =
						new OrderLine(instance.getAD_Client_ID(), instance.getAD_Org_ID(), instance.getC_OrderLine_UU(),
								instance.isActive(), DateUtil.parse(instance.getCreated()), instance.getCreatedBy(),
								instance.getC_Order_ID(), new Product(product.getName(), product.getM_Product_UU(), product),
								instance.getPriceActual(), instance.getQtyOrdered(), instance.getLineNetAmt(),
								instance.getBH_Instructions(), instance);
				orderLine.getProduct()
						.setTotalQuantity(storageOnHandDBService.getQuantityOnHand(instance.getM_Product_ID(), false));
				return orderLine;
			} else if (instance.getC_Charge_ID() > 0) {
				return new OrderLine(instance);
			}
		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}
		return null;
	}

	@Override
	protected MOrderLine_BH getModelInstance() {
		return new MOrderLine_BH(Env.getCtx(), 0, null);
	}

	public Map<Integer, List<OrderLine>> getOrderLinesByOrderIds(Set<Integer> orderIds) {
		if (orderIds == null || orderIds.isEmpty()) {
			return new HashMap<>();
		}
		List<OrderLine> orderLines = new ArrayList<>();
		List<Object> parameters = new ArrayList<>();
		String whereClause = QueryUtil.getWhereClauseAndSetParametersForSet(orderIds, parameters);

		List<MOrderLine_BH> mOrderLines = new Query(Env.getCtx(), MOrderLine_BH.Table_Name,
				MOrderLine_BH.COLUMNNAME_C_Order_ID + " IN (" + whereClause + ")", null).setParameters(parameters)
				.setOnlyActiveRecords(true).setClient_ID().list();
		for (MOrderLine_BH mOrderLine : mOrderLines) {
			orderLines.add(createInstanceWithDefaultFields(mOrderLine));
		}

		// Batch calls for charges and charge information
		Set<Integer> chargeIds = mOrderLines.stream().map(MOrderLine_BH::getC_Charge_ID).collect(Collectors.toSet());
		Set<Integer> orderLineIds = mOrderLines.stream().map(MOrderLine_BH::get_ID).collect(Collectors.toSet());

		Map<Integer, MCharge_BH> chargesById = chargeDBService.getByIds(chargeIds);
//		Map<Integer, List<MBHBPSpecificPayerInfo>> businessPartnerSpecificPayerInformationByOrderLineId =
//				businessPartnerSpecificPayerInformationDBService
//						.getGroupsByIds(MBHBPSpecificPayerInfo::getC_OrderLine_ID,
//								MBHBPSpecificPayerInfo.COLUMNNAME_C_OrderLine_ID, orderLineIds);
//		Map<Integer, MBHPayerInfoField> payerInformationFieldsById = payerInformationFieldDBService.getByIds(
//				businessPartnerSpecificPayerInformationByOrderLineId.values().stream().flatMap(
//						businessPartnerSpecificPayerInformation -> businessPartnerSpecificPayerInformation.stream()
//								.map(MBHBPSpecificPayerInfo::getBH_Payer_Info_Field_ID)).collect(Collectors.toSet()));

		// Get the product IDs so we can fetch storage on hand
		Set<Integer> productIds =
				orderLines.stream().map(OrderLine::getProductId).filter(productId -> productId > 0).collect(Collectors.toSet());
		// TODO: Fetch Products Here instead of on a 1-by-1 basis up in the `createInstanceWithAllFields` method
		// This should duplicate whatever is done in `ProductDBService#searchItems`

		// go-2331 Returning all this data is leading to serious performance issues. 
		// TODO: Work on an efficient way of returning all the data or just the totalQuantity field 
		
		/*Map<Integer, List<StorageOnHand>> storageOnHandListByProductIds = storageOnHandDBService.transformData(
				storageOnHandDBService.getNonExpiredGroupsByIds(MStorageOnHand::getM_Product_ID,
								MStorageOnHand.COLUMNNAME_M_Product_ID, productIds).values().stream().flatMap(Collection::stream)
						.collect(Collectors.toList())).stream().collect(Collectors.groupingBy(StorageOnHand::getProductId));*/

		orderLines.forEach(orderLine -> {
			if (orderLine.getChargeId() > 0) {
				orderLine.setCharge(new Charge(chargesById.get(orderLine.getChargeId())));
			}
//			if (businessPartnerSpecificPayerInformationByOrderLineId.containsKey(orderLine.getId())) {
//				orderLine.setBusinessPartnerSpecificPayerInformationList(
//						businessPartnerSpecificPayerInformationByOrderLineId.get(orderLine.getId()).stream()
//								.map(BusinessPartnerSpecificPayerInformation::new).peek(
//										businessPartnerSpecificPayerInformation -> businessPartnerSpecificPayerInformation.setPayerInformationFieldUuid(
//												payerInformationFieldsById.get(businessPartnerSpecificPayerInformation.getPayerInformationFieldId())
//														.getBH_Payer_Info_Field_UU())).collect(Collectors.toList()));
//			}

			// go-2331 - revert
			/*if (orderLine.getProductId() > 0 && orderLine.getProduct() != null &&
					storageOnHandListByProductIds.containsKey(orderLine.getProductId())) {
				orderLine.getProduct().setStorageOnHandList(storageOnHandListByProductIds.get(orderLine.getProductId()));
			}*/
		});

		return orderLines.stream().collect(Collectors.groupingBy(OrderLine::getOrderId));
	}

	/**
	 * Delete orderlines for a given order and not in given subset orderlines
	 *
	 * @param orderId
	 */
	public void deleteOrderLinesByOrder(int orderId, String orderLineUuids) {
		String whereClause = MOrderLine_BH.COLUMNNAME_C_Order_ID + "=?";
		if (StringUtil.isNotNullAndEmpty(orderLineUuids)) {
			whereClause += " AND " + MOrderLine_BH.COLUMNNAME_C_OrderLine_UU + " NOT IN(" + orderLineUuids + ")";
		}

		List<MOrderLine_BH> mOrderLines = new Query(Env.getCtx(), MOrderLine_BH.Table_Name, whereClause, null)
				.setParameters(orderId).setClient_ID().list();

		// Get the associated order line charge information and delete it
//		Set<Integer> orderLineIds = mOrderLines.stream().map(MOrderLine_BH::getC_OrderLine_ID)
//				.collect(Collectors.toSet());
//		boolean wereChildrenDeletesSuccessful = businessPartnerSpecificPayerInformationDBService
//				.getGroupsByIds(MBHBPSpecificPayerInfo::getC_OrderLine_ID,
//						MBHBPSpecificPayerInfo.COLUMNNAME_C_OrderLine_ID, orderLineIds)
//				.values().stream().flatMap(Collection::stream)
//				.allMatch(businessPartnerChargeInformation -> businessPartnerSpecificPayerInformationDBService
//						.deleteEntity(businessPartnerChargeInformation.getBH_BP_Specific_Payer_Info_UU()));
//		if (!wereChildrenDeletesSuccessful) {
//			throw new AdempiereException("There was an error deleting information");
//		}

		for (MOrderLine_BH mOrderLine : mOrderLines) {
			mOrderLine.deleteEx(false);
		}
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		// TODO Auto-generated method stub
		return null;
	}
}
