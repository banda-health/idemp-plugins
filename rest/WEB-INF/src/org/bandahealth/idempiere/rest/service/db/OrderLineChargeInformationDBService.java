package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MBHChargeInfo;
import org.bandahealth.idempiere.base.model.MBHOrderLineChargeInfo;
import org.bandahealth.idempiere.rest.model.OrderLineChargeInformation;
import org.bandahealth.idempiere.rest.utils.ModelUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderLineChargeInformationDBService extends BaseDBService<OrderLineChargeInformation, MBHOrderLineChargeInfo> {
	@Autowired
	private ChargeInformationDBService chargeInformationDBService;

	@Override
	public OrderLineChargeInformation saveEntity(OrderLineChargeInformation entity) {
		MBHOrderLineChargeInfo orderChargeInformation = getEntityByUuidFromDB(entity.getUuid());
		if (orderChargeInformation == null) {
			orderChargeInformation = getModelInstance();
			if (!StringUtil.isNullOrEmpty(entity.getUuid())) {
				orderChargeInformation.setBH_OrderLine_Charge_Info_UU(entity.getUuid());
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
				getEntityByUuidFromDB(orderChargeInformation.getBH_OrderLine_Charge_Info_UU()));
		newEntity.setChargeInformationUuid(entity.getChargeInformationUuid());
		return newEntity;
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		return getEntityByUuidFromDB(entityUuid).delete(false);
	}

	@Override
	protected OrderLineChargeInformation createInstanceWithDefaultFields(MBHOrderLineChargeInfo instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected OrderLineChargeInformation createInstanceWithAllFields(MBHOrderLineChargeInfo instance) {
		return new OrderLineChargeInformation(instance);
	}

	@Override
	protected OrderLineChargeInformation createInstanceWithSearchFields(MBHOrderLineChargeInfo instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MBHOrderLineChargeInfo getModelInstance() {
		return new MBHOrderLineChargeInfo(Env.getCtx(), 0, null);
	}
}
