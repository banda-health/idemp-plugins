package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.rest.model.AttributeSetInstance;
import org.compiere.model.MAttributeSetInstance;
import org.compiere.util.Env;

public class AttributeSetInstanceDBService extends BaseDBService<AttributeSetInstance, MAttributeSetInstance> {
	@Override
	public AttributeSetInstance saveEntity(AttributeSetInstance entity) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	protected AttributeSetInstance createInstanceWithDefaultFields(MAttributeSetInstance instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected AttributeSetInstance createInstanceWithAllFields(MAttributeSetInstance instance) {
		return new AttributeSetInstance(instance);
	}

	@Override
	protected AttributeSetInstance createInstanceWithSearchFields(MAttributeSetInstance instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MAttributeSetInstance getModelInstance() {
		return new MAttributeSetInstance(Env.getCtx(), 0, null);
	}
}
