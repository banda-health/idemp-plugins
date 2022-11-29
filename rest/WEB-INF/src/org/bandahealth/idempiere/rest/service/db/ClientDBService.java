package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MClient_BH;
import org.bandahealth.idempiere.rest.model.Client;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

@Component
public class ClientDBService extends BaseDBService<Client, MClient_BH> {
	@Override
	public Client saveEntity(Client entity) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	protected Client createInstanceWithDefaultFields(MClient_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected Client createInstanceWithAllFields(MClient_BH instance) {
		return new Client(instance);
	}

	@Override
	protected Client createInstanceWithSearchFields(MClient_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MClient_BH getModelInstance() {
		return new MClient_BH(Env.getCtx(), 0, null);
	}

	@Override
	protected boolean isClientIdFromTheContextNeededByDefaultForThisEntity() {
		return false;
	}
}
