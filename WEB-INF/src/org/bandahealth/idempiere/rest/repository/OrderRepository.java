package org.bandahealth.idempiere.rest.repository;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.utils.ModelUtil;
import org.compiere.model.MDocType;
import org.compiere.model.MOrder;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class OrderRepository extends BaseRepository<MOrder_BH> {

	private final OrderLineRepository orderLineRepository;
	private final BusinessPartnerRepository businessPartnerRepository;
	private final PaymentRepository paymentRepository;
//	private final ProcessRepository processRepository;

	private final String businessPartnerJoin = "JOIN " + MBPartner_BH.Table_Name + " ON " + MBPartner_BH.Table_Name +
			"." + MBPartner_BH.COLUMNNAME_C_BPartner_ID + "=" + MOrder_BH.Table_Name + "." +
			MOrder_BH.COLUMNNAME_C_BPartner_ID;

	public OrderRepository() {
		orderLineRepository = new OrderLineRepository();
		businessPartnerRepository = new BusinessPartnerRepository();
		paymentRepository = new PaymentRepository();
//		processRepository = new ProcessRepository();
	}

	public List<MOrder_BH> getPurchaseOrders(String filter, String sort, Paging pagingInfo) {
		List<Object> parameters = new ArrayList<>();
		parameters.add("N");

		return super.get(filter, sort, pagingInfo, MOrder_BH.COLUMNNAME_IsSOTrx + "=? AND " +
				MOrder_BH.COLUMNNAME_BH_IsExpense + " IS NULL", parameters, businessPartnerJoin);
	}

	public List<MOrder_BH> getSalesOrders(String filter, String sort, Paging pagingInfo) {
		List<Object> parameters = new ArrayList<>();
		parameters.add("Y");

		return super.get(filter, sort, pagingInfo, MOrder_BH.COLUMNNAME_IsSOTrx + "=?", parameters,
				businessPartnerJoin);
	}

	public Paging getSalesOrdersPagingInfo(String filter, String sort, Paging pagingInfo) {
		List<Object> parameters = new ArrayList<>();
		parameters.add("Y");

		return super.getPagingInfo(filter, sort, pagingInfo, MOrder_BH.COLUMNNAME_IsSOTrx + "=?", parameters,
				businessPartnerJoin);
	}

	@Override
	protected MOrder_BH createModelInstance() {
		return new MOrder_BH(Env.getCtx(), 0, null);
	}

	@Override
	public MOrder_BH mapInputModelToModel(MOrder_BH entity) {
		try {
			MOrder_BH order = getByUuid(entity.getC_Order_UU());
			if (order == null) {
				order = createModelInstance();
			}

			ModelUtil.setPropertyIfPresent(entity.getDateOrdered(), order::setDateOrdered);
			ModelUtil.setPropertyIfPresent(entity.getDescription(), order::setDescription);

			order.setIsActive(entity.isActive());
			order.setIsApproved(true);
			order.setDocAction(MOrder_BH.DOCACTION_Complete);

			MBPartner_BH businessPartner = null;

			// set patient
			if (entity.getC_BPartner_ID() > 0) {
				businessPartner = businessPartnerRepository.getById(entity.getC_BPartner_ID());
				if (businessPartner != null) {
					order.setC_BPartner_ID(businessPartner.get_ID());
				}
			}

			// Set properties specifically for sales orders
			if (order.isSOTrx()) {
				ModelUtil.setPropertyIfPresent(entity.getbh_lab_notes(), order::setbh_lab_notes);
				ModelUtil.setPropertyIfPresent(entity.getDescription(), order::setDescription);

				ModelUtil.setPropertyIfPresent(entity.getBH_PatientType(), order::setBH_PatientType);
				ModelUtil.setPropertyIfPresent(entity.getbh_referral(), order::setbh_referral);

				ModelUtil.setPropertyIfPresent(entity.isBH_NewVisit(), order::setBH_NewVisit);
				ModelUtil.setPropertyIfPresent(entity.getBH_Chief_Complaint(), order::setBH_Chief_Complaint);
				ModelUtil.setPropertyIfPresent(entity.getBH_Temperature(), order::setBH_Temperature);
				ModelUtil.setPropertyIfPresent(entity.getBH_Pulse(), order::setBH_Pulse);
				ModelUtil.setPropertyIfPresent(entity.getBH_Respiratory_Rate(), order::setBH_Respiratory_Rate);
				ModelUtil.setPropertyIfPresent(entity.getBH_Blood_Pressure(), order::setBH_Blood_Pressure);
				ModelUtil.setPropertyIfPresent(entity.getBH_Height(), order::setBH_Height);
				ModelUtil.setPropertyIfPresent(entity.getBH_Weight(), order::setBH_Weight);
				ModelUtil.setPropertyIfPresent(entity.getBH_SecondDiagnosis(), order::setBH_SecondDiagnosis);
				ModelUtil.setPropertyIfPresent(entity.isSOTrx(), order::setIsSOTrx);
			}

			// set target document type
			if (!order.isSOTrx()) {
				order.setC_DocTypeTarget_ID(getPurchaseOrderDocumentTypeId());
			}

			return order;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.severe(ex.getMessage());

			throw new AdempiereException(ex.getLocalizedMessage());
		}
	}

	public MOrder_BH saveSalesOrder(MOrder_BH entity) {
		entity.setIsSOTrx(true);
		return save(entity);
	}

	public MOrder_BH savePurchaseOrder(MOrder_BH entity) {
		entity.setIsSOTrx(false);
		return save(entity);
	}

	/**
	 * Process order
	 *
	 * @param uuid
	 * @return
	 */
	public MOrder_BH process(String uuid) {
		MOrder_BH order = getByUuid(uuid);
		if (order == null) {
			logger.severe("No order with uuid = " + uuid);
			return null;
		}

//		processRepository.runOrderProcess(order.get_ID(), idempiereContext);
//		cache.delete(order.get_ID());
//		cache.delete(uuid);
//		businessPartnerRepository.cache.delete(order.getC_BPartner_ID());

		return getByUuid(order.getC_Order_UU());
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

	public CompletableFuture<Boolean> delete(String id) {
		try {
			MOrder order = getByUuid(id);
			if (order.isComplete()) {
				throw new AdempiereException("Order is already completed");
			} else {
				return CompletableFuture.supplyAsync(() -> order.delete(false));
			}
		} catch (Exception ex) {
			throw new AdempiereException(ex.getLocalizedMessage());
		}
	}
}
