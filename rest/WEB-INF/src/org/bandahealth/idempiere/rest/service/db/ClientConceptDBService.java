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

	@Autowired
	private ConceptDBService conceptDBService;

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

		// get concept
		if (entity.getConcept() != null) {
			MBHConcept concept = conceptDBService.getEntityByUuidFromDB(entity.getConcept().getUuid());
			clientConcept.setBH_Concept_ID(concept.get_ID());
		}

		clientConcept.saveEx();

		return transformData(Collections.singletonList(getEntityByUuidFromDB(clientConcept.getUUIDColumnName())))
				.get(0);
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
