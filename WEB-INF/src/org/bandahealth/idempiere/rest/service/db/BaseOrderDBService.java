package org.bandahealth.idempiere.rest.service.db;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.rest.model.Order;
import org.bandahealth.idempiere.rest.model.OrderLine;
import org.bandahealth.idempiere.rest.model.Payment;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.util.Env;

/**
 * Order (c_order) base functionality (billing, receive goods, track expenses).
 * 
 * @author andrew
 *
 * @param <T>
 */
public abstract class BaseOrderDBService<T extends Order> extends BaseDBService<T, MOrder_BH> {

	protected OrderLineDBService orderLineDBService;
	protected PaymentDBService paymentDBService;
	private ProcessDBService processDBService = new ProcessDBService();

	@Override
	public T saveEntity(T entity) {
		try {
			MOrder_BH mOrder;
			MOrder_BH exists = getEntityFromDB(entity.getUuid());
			if (exists != null) {
				mOrder = exists;
			} else {
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
			mOrder.setDeliveryRule(MOrder_BH.DELIVERYRULE_Force);
			mOrder.setDocAction(MOrder_BH.DOCACTION_Complete);
			mOrder.saveEx();

			// persist product/service/charge order lines
			if (entity.getOrderLines() != null) {
				orderLineDBService = new OrderLineDBService(mOrder.get_ID());
				for (OrderLine orderLine : entity.getOrderLines()) {
					orderLineDBService.saveEntity(orderLine);
				}
			}

			// only a visit/bill/sales order can have payments
			if (entity.getPayments() != null && entity.isIsSalesOrderTransaction()) {
				paymentDBService = new PaymentDBService(mOrder.get_ID(), mOrder.getC_BPartner_ID());
				for (Payment payment : entity.getPayments()) {
					paymentDBService.saveEntity(payment);
				}
			}

			return createInstanceWithAllFields(getEntityFromDB(mOrder.getC_Order_UU()));

		} catch (Exception ex) {
			throw new AdempiereException(ex.getLocalizedMessage());
		}
	}

	public T processEntity(String uuid) {
		MOrder_BH order = getEntityFromDB(uuid);
		if (order == null) {
			log.severe("No order with uuid = " + uuid);
			return null;
		}

		/*
		 * boolean processed = order.processIt(DocAction.ACTION_Complete); if
		 * (processed) { return
		 * createInstanceWithAllFields(getEntityFromDB(order.getC_Order_UU())); }
		 */
		processDBService.runOrderProcess(order.get_ID());

		return null;
	}

	public T saveAndProcessEntity(T entity) {
		T saveEntity = saveEntity(entity);
		if (saveEntity != null) {
			return processEntity(saveEntity.getUuid());
		}

		return null;
	}

	public void asyncProcessEntity(int orderId) {
		processDBService.runOrderProcess(orderId);
	}

	@Override
	protected MOrder_BH getModelInstance() {
		return new MOrder_BH(Env.getCtx(), 0, null);
	}
}
