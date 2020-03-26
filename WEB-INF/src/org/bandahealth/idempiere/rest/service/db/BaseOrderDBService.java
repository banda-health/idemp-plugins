package org.bandahealth.idempiere.rest.service.db;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.rest.model.Order;
import org.bandahealth.idempiere.rest.model.OrderLine;
import org.bandahealth.idempiere.rest.model.Payment;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.process.DocAction;
import org.compiere.util.Env;

/**
 * Order (c_order) base functionality (billing, receive goods, track expenses).
 * 
 * @author andrew
 *
 * @param <T>
 */
public abstract class BaseOrderDBService<T extends Order> extends BaseDBService<T, MOrder_BH> {

	protected OrderLineDBService orderLineDBService = new OrderLineDBService();
	protected PaymentDBService paymentDBService = new PaymentDBService();
	private ProcessDBService processDBService = new ProcessDBService();

	protected abstract void populateExtraFields(T entity, MOrder_BH mOrder);

	@Override
	public T saveEntity(T entity) {
		try {
			MOrder_BH mOrder = getEntityFromDB(entity.getUuid());
			if (mOrder == null) {
				mOrder = getModelInstance();
			}

			if (entity.getDateOrdered() != null) {
				mOrder.setDateOrdered(DateUtil.getTimestamp(entity.getDateOrdered()));
			}

			if (StringUtil.isNotNullAndEmpty(entity.getDescription())) {
				mOrder.setDescription(entity.getDescription());
			}

			mOrder.setC_BPartner_ID(entity.getBusinessPartnerId());
			mOrder.setIsSOTrx(entity.isIsSalesOrderTransaction());
			mOrder.setIsActive(entity.isIsActive());
			mOrder.setIsApproved(true);
			mOrder.setDocAction(MOrder_BH.DOCACTION_Complete);

			populateExtraFields(entity, mOrder);

			mOrder.saveEx();

			// persist product/service/charge order lines
			if (entity.getOrderLines() != null) {
				for (OrderLine orderLine : entity.getOrderLines()) {
					orderLine.setOrderId(mOrder.get_ID());
					orderLineDBService.saveEntity(orderLine);
				}
			}

			// only a visit/bill/sales order can have payments
			if (entity.getPayments() != null && entity.isIsSalesOrderTransaction()) {
				for (Payment payment : entity.getPayments()) {
					payment.setOrderId(mOrder.get_ID());
					payment.setBusinessPartnerId(mOrder.getC_BPartner_ID());
					paymentDBService.saveEntity(payment);
				}
			}

			return createInstanceWithAllFields(getEntityFromDB(mOrder.getC_Order_UU()));

		} catch (Exception ex) {
			throw new AdempiereException(ex.getLocalizedMessage());
		}
	}

	/**
	 * Asynchronously process order
	 * 
	 * @param uuid
	 * @return
	 */
	public String asyncProcessEntity(String uuid) {
		MOrder_BH order = getEntityFromDB(uuid);
		if (order == null) {
			log.severe("No order with uuid = " + uuid);
			return "No order with uuid = " + uuid;
		}

		return processDBService.runOrderProcess(order.get_ID());
	}

	/**
	 * Synchronously process order
	 * 
	 * @param uuid
	 * @return
	 */
	public T processEntity(String uuid) {
		MOrder_BH order = getEntityFromDB(uuid);
		if (order == null) {
			log.severe("No order with uuid = " + uuid);
			return null;
		}

		order.processIt(DocAction.ACTION_Complete);

		return createInstanceWithAllFields(getEntityFromDB(order.getC_Order_UU()));
	}

	/**
	 * Save and asynchronously process order
	 * 
	 * @param entity
	 * @return
	 */
	public String asynSaveAndProcessEntity(T entity) {
		T saveEntity = saveEntity(entity);
		if (saveEntity != null) {
			return asyncProcessEntity(saveEntity.getUuid());
		}

		return null;
	}

	/**
	 * Synchronously save and process order
	 * 
	 * @param entity
	 * @return
	 */
	public T saveAndProcessEntity(T entity) {
		T saveEntity = saveEntity(entity);
		if (saveEntity != null) {
			return processEntity(saveEntity.getUuid());
		}

		return null;
	}

	@Override
	protected MOrder_BH getModelInstance() {
		return new MOrder_BH(Env.getCtx(), 0, null);
	}
}
