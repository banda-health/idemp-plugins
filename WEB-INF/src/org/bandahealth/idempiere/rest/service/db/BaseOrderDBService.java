package org.bandahealth.idempiere.rest.service.db;

import java.util.List;

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
	protected EntityMetadataDBService entityMetadataDBService = new EntityMetadataDBService();

	protected abstract void populateExtraFields(T entity, MOrder_BH mOrder);

	@Override
	public T saveEntity(T entity) {
		try {
			MOrder_BH mOrder = getEntityByUuidFromDB(entity.getUuid());
			if (mOrder == null) {
				mOrder = getModelInstance();
			}

			if (entity.getDateOrdered() != null) {
				mOrder.setDateOrdered(DateUtil.getTimestamp(entity.getDateOrdered()));
			}

			if (StringUtil.isNotNullAndEmpty(entity.getDescription())) {
				mOrder.setDescription(entity.getDescription());
			}

			mOrder.setIsActive(entity.isIsActive());

			mOrder.setIsApproved(true);
			mOrder.setDocAction(MOrder_BH.DOCACTION_Complete);

			populateExtraFields(entity, mOrder);

			mOrder.saveEx();

			// list of persisted order line ids
			String lineIds = "";
			// persist product/service/charge order lines
			List<OrderLine> orderLines = entity.getOrderLines();
			if (orderLines != null) {
				int count = 0;
				for (OrderLine orderLine : orderLines) {
					orderLine.setOrderId(mOrder.get_ID());
					OrderLine response = orderLineDBService.saveEntity(orderLine);
					lineIds += "'" + response.getUuid() + "'";
					if (++count < orderLines.size()) {
						lineIds += ",";
					}
				}
			}

			// delete order lines not in request
			orderLineDBService.deleteOrderLinesByOrder(mOrder.get_ID(), lineIds);

			// list of persisted payment line ids
			lineIds = "";
			// only a visit/bill/sales order can have payments
			List<Payment> payments = entity.getPayments();
			if (payments != null && entity.isIsSalesOrderTransaction()) {
				int count = 0;
				for (Payment payment : entity.getPayments()) {
					payment.setOrderId(mOrder.get_ID());
					payment.setBusinessPartnerId(mOrder.getC_BPartner_ID());
					Payment response = paymentDBService.saveEntity(payment);
					lineIds += "'" + response.getUuid() + "'";
					if (++count < payments.size()) {
						lineIds += ",";
					}
				}
			}

			// delete payment lines not in request
			paymentDBService.deletePaymentLinesByOrder(mOrder.get_ID(), lineIds);

			return createInstanceWithAllFields(getEntityByUuidFromDB(mOrder.getC_Order_UU()));

		} catch (Exception ex) {
			ex.printStackTrace();
			log.severe(ex.getMessage());

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
		MOrder_BH order = getEntityByUuidFromDB(uuid);
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
		MOrder_BH order = getEntityByUuidFromDB(uuid);
		if (order == null) {
			log.severe("No order with uuid = " + uuid);
			return null;
		}

		order.processIt(DocAction.ACTION_Complete);

		return createInstanceWithAllFields(getEntityByUuidFromDB(order.getC_Order_UU()));
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
