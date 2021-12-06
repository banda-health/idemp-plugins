package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.rest.model.StorageOnHand;
import org.compiere.model.MStorageOnHand;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

@Component
public class StorageOnHandDBService extends BaseDBService<StorageOnHand, MStorageOnHand> {
	@Override
	public StorageOnHand saveEntity(StorageOnHand entity) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	protected StorageOnHand createInstanceWithDefaultFields(MStorageOnHand instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected StorageOnHand createInstanceWithAllFields(MStorageOnHand instance) {
		return new StorageOnHand(instance);
	}

	@Override
	protected StorageOnHand createInstanceWithSearchFields(MStorageOnHand instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MStorageOnHand getModelInstance() {
		return new MStorageOnHand(Env.getCtx(), 0, null);
	}
}
