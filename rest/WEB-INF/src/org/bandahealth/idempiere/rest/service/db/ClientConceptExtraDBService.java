package org.bandahealth.idempiere.rest.service.db;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHClientConceptExtra;
import org.bandahealth.idempiere.base.model.MBHConceptExtra;
import org.bandahealth.idempiere.rest.model.ClientConceptExtra;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

@Component
public class ClientConceptExtraDBService extends BaseDBService<ClientConceptExtra, MBHClientConceptExtra> {

	private final ConceptExtraDBService conceptExtraDBService = new ConceptExtraDBService();

	public void deleteClientConceptExtrasNotInList(List<ClientConceptExtra> clientConceptExtras) {
		// get existing client concept extras
		List<MBHClientConceptExtra> mClientConceptExtras = new Query(Env.getCtx(), MBHClientConceptExtra.Table_Name,
				null, null).setClient_ID().list();

		mClientConceptExtras.stream()
				.filter(existingClientConcept -> clientConceptExtras.stream()
						.noneMatch(newClientConceptExtra -> newClientConceptExtra.getUuid()
								.equals(existingClientConcept.getBH_Client_Concept_Extra_UU())))
				.forEach(entity -> deleteEntity(entity.getBH_Client_Concept_Extra_UU()));
	}

	@Override
	protected ClientConceptExtra createInstanceWithDefaultFields(MBHClientConceptExtra instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected ClientConceptExtra createInstanceWithAllFields(MBHClientConceptExtra instance) {
		return new ClientConceptExtra(instance);
	}

	@Override
	protected MBHClientConceptExtra getModelInstance() {
		return new MBHClientConceptExtra(Env.getCtx(), 0, null);
	}

	@Override
	public ClientConceptExtra saveEntity(ClientConceptExtra entity) {
		MBHClientConceptExtra clientConceptExtra = getEntityByUuidFromDB(entity.getUuid());
		if (clientConceptExtra == null) {
			clientConceptExtra = new MBHClientConceptExtra(Env.getCtx(), 0, null);
			clientConceptExtra.setBH_Client_Concept_Extra_UU(entity.getUuid());
		}

		// ensure link to concept extra
		if (entity.getConceptExtraId() > 0) {
			clientConceptExtra.setBH_Concept_Extra_ID(entity.getConceptExtraId());
		} else {
			throw new AdempiereException("Concept extra missing!");
		}
		clientConceptExtra.setBH_Value(entity.getValue());

		clientConceptExtra.saveEx();

		return createInstanceWithAllFields(clientConceptExtra);
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		try {
			MBHClientConceptExtra entity = getEntityByUuidFromDB(entityUuid);
			return entity.delete(false);
		} catch (Exception ex) {
			throw new AdempiereException(ex.getLocalizedMessage());
		}
	}

	@Override
	public List<ClientConceptExtra> transformData(List<MBHClientConceptExtra> dbModels) {
		Map<Integer, MBHConceptExtra> conceptExtrasById = conceptExtraDBService.getByIds(
				dbModels.stream().map(MBHClientConceptExtra::getBH_Concept_Extra_ID).collect(Collectors.toSet()));

		return dbModels.stream().map(entity -> {
			ClientConceptExtra result = new ClientConceptExtra(entity);
			if (conceptExtrasById.containsKey(entity.getBH_Concept_Extra_ID())) {
				result.setConceptExtra(conceptExtraDBService
						.transformData(
								Collections.singletonList(conceptExtrasById.get(entity.getBH_Concept_Extra_ID())))
						.get(0));
			}
			return result;
		}).collect(Collectors.toList());
	}
}
