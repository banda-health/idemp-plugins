package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MBHChargeInfo;
import org.bandahealth.idempiere.base.model.MBHOrderLineInfo;
import org.bandahealth.idempiere.rest.model.OrderLineChargeInformation;
import org.bandahealth.idempiere.rest.utils.ModelUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.util.Env;

public class OrderLineChargeInformationDBService extends BaseDBService<OrderLineChargeInformation, MBHOrderLineInfo> {
	private final ChargeInformationDBService chargeInformationDBService;

	public OrderLineChargeInformationDBService() {
		chargeInformationDBService = new ChargeInformationDBService();
	}

	@Override
	public OrderLineChargeInformation saveEntity(OrderLineChargeInformation entity) {
		MBHOrderLineInfo orderChargeInformation = getEntityByUuidFromDB(entity.getUuid());
		if (orderChargeInformation == null) {
			orderChargeInformation = getModelInstance();
			if (!StringUtil.isNullOrEmpty(entity.getUuid())) {
				orderChargeInformation.setBH_OrderLine_Info_UU(entity.getUuid());
			}
		}

		// Set the charge information relationship
		if (entity.getChargeInformationId() > 0) {
			orderChargeInformation.setBH_Charge_Info_ID(entity.getChargeInformationId());
		} else {
			MBHChargeInfo chargeInformation =
					chargeInformationDBService.getEntityByUuidFromDB(entity.getChargeInformationUuid());
			if (chargeInformation != null) {
				orderChargeInformation.setBH_Charge_Info_ID(chargeInformation.getBH_Charge_Info_ID());
			}
		}
		orderChargeInformation.setC_OrderLine_ID(entity.getOrderLineId());
		orderChargeInformation.setName(entity.getName());
		ModelUtil.setPropertyIfPresent(entity.getDescription(), orderChargeInformation::setDescription);

		orderChargeInformation.saveEx();
		OrderLineChargeInformation newEntity = createInstanceWithAllFields(
				getEntityByUuidFromDB(orderChargeInformation.getBH_OrderLine_Info_UU()));
		newEntity.setChargeInformationUuid(entity.getChargeInformationUuid());
		return newEntity;
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		return getEntityByUuidFromDB(entityUuid).delete(false);
	}

	@Override
	protected OrderLineChargeInformation createInstanceWithDefaultFields(MBHOrderLineInfo instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected OrderLineChargeInformation createInstanceWithAllFields(MBHOrderLineInfo instance) {
		return new OrderLineChargeInformation(instance);
	}

	@Override
	protected OrderLineChargeInformation createInstanceWithSearchFields(MBHOrderLineInfo instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MBHOrderLineInfo getModelInstance() {
		return new MBHOrderLineInfo(Env.getCtx(), 0, null);
	}
}
