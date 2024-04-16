package org.bandahealth.idempiere.rest.service.db;

import java.util.Collections;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHClientConcept;
import org.bandahealth.idempiere.base.model.MBHConcept;
import org.bandahealth.idempiere.rest.model.ClientConcept;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
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
		MBHClientConcept clientConcept = getEntityByUuidFromDB(entity.getUuid());
		if (clientConcept == null) {
			clientConcept = new MBHClientConcept(Env.getCtx(), 0, null);
			clientConcept.setBH_Client_Concept_UU(entity.getUuid());
		}

		// ensure link to concept
		if (entity.getConceptId() > 0) {
			clientConcept.setBH_Concept_ID(entity.getConceptId());
		} else {
			throw new AdempiereException("Concept missing!");
		}
		clientConcept.setName(entity.getName());
		
		clientConcept.saveEx();

		return createInstanceWithAllFields(clientConcept);
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		try {
			MBHClientConcept entity = getEntityByUuidFromDB(entityUuid);
			return entity.delete(false);
		} catch (Exception ex) {
			throw new AdempiereException(ex.getLocalizedMessage());
		}
	}
}
