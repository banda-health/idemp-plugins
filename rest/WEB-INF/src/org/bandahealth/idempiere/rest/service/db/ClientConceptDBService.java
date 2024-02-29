package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MBHClientConcept;
import org.bandahealth.idempiere.rest.model.ClientConcept;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

@Component
public class ClientConceptDBService extends BaseDBService<ClientConcept, MBHClientConcept> {

	@Override
	protected ClientConcept createInstanceWithDefaultFields(MBHClientConcept instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected ClientConcept createInstanceWithAllFields(MBHClientConcept instance) {
		return new ClientConcept(instance);
	}

	@Override
	protected MBHClientConcept getModelInstance() {
		return new MBHClientConcept(Env.getCtx(), 0, null);
	}

	@Override
	public ClientConcept saveEntity(ClientConcept entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		// TODO Auto-generated method stub
		return null;
	}

}
