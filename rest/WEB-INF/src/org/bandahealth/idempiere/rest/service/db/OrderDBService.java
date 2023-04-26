package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.rest.model.Order;
import org.springframework.stereotype.Component;

/**
 * We have to have this class because Spring can't differentiate beans in a class-inheritance structure.
 * This class will be removed after we eliminate the ReceiveProductsDBService class.
 */
@Component
public class OrderDBService extends BaseOrderDBService<Order> {
	@Override
	protected void beforeSave(Order entity, MOrder_BH mOrder) {}

	@Override
	protected void afterSave(Order entity, MOrder_BH mOrder) {}

	@Override
	protected String getDocumentTypeName() {
		return DOCUMENTNAME_BILLS;
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
	protected Order createInstanceWithSearchFields(MOrder_BH instance) {
		return createInstanceWithAllFields(instance);
	}
}
