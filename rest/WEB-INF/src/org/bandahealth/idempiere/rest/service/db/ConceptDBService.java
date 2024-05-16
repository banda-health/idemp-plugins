package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHClientConceptExtra;
import org.bandahealth.idempiere.base.model.MBHConcept;
import org.bandahealth.idempiere.base.model.MBHConceptExtra;
import org.bandahealth.idempiere.base.model.MBHConceptMapping;
import org.bandahealth.idempiere.base.model.MBHConceptName;
import org.bandahealth.idempiere.rest.model.ClientConceptExtra;
import org.bandahealth.idempiere.rest.model.Concept;
import org.bandahealth.idempiere.rest.model.ConceptExtra;
import org.bandahealth.idempiere.rest.model.ConceptMapping;
import org.bandahealth.idempiere.rest.model.ConceptName;
import org.bandahealth.idempiere.rest.utils.QueryUtil;
import org.compiere.model.Query;
import org.compiere.util.Env;

public class ConceptDBService extends BaseDBService<Concept, MBHConcept> {

	private final ConceptMappingDBService conceptMappingDBService = new ConceptMappingDBService();
	private final ConceptExtraDBService conceptExtraDBService = new ConceptExtraDBService();
	private final ConceptNameDBService conceptNameDBService = new ConceptNameDBService();
	private final ClientConceptExtraDBService clientConceptExtraDBService = new ClientConceptExtraDBService();

	@Override
	public Concept saveEntity(Concept entity) {
		MBHConcept concept = getEntityByUuidFromDB(entity.getUuid());
		// save client concept extras
		if (entity.getClientConceptExtras() != null && !entity.getClientConceptExtras().isEmpty()) {
			Map<String, MBHConceptExtra> mConceptExtras = conceptExtraDBService
					.getByUuids(entity.getClientConceptExtras().stream().map(ClientConceptExtra::getConceptExtra)
							.map(ConceptExtra::getUuid).collect(Collectors.toSet()));

			entity.getClientConceptExtras().stream().forEach(clientConceptExtra -> {
				if (mConceptExtras.containsKey(clientConceptExtra.getConceptExtra().getUuid())) {
					clientConceptExtra.setConceptExtraId(
							mConceptExtras.get(clientConceptExtra.getConceptExtra().getUuid()).get_ID());
					clientConceptExtra.getConceptExtra().setConceptId(concept.get_ID());
				}

				clientConceptExtraDBService.saveEntity(clientConceptExtra);
			});
		}

		// save extras
		if (entity.getConceptExtras() != null && !entity.getConceptExtras().isEmpty()) {
			for (ConceptExtra extra : entity.getConceptExtras()) {
				conceptExtraDBService.saveEntity(extra);
			}
		}

		// delete old client concept extras
		clientConceptExtraDBService.deleteClientConceptExtrasNotInList(entity.getClientConceptExtras());

		return transformData(Collections.singletonList(getEntityByUuidFromDB(entity.getUuid()))).get(0);
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		try {
			MBHConcept entity = getEntityByUuidFromDB(entityUuid);
			return entity.delete(false);
		} catch (Exception ex) {
			throw new AdempiereException(ex.getLocalizedMessage());
		}
	}

	@Override
	protected Concept createInstanceWithDefaultFields(MBHConcept instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected Concept createInstanceWithAllFields(MBHConcept instance) {
		return transformData(Collections.singletonList(instance)).get(0);
	}

	@Override
	protected MBHConcept getModelInstance() {
		return new MBHConcept(Env.getCtx(), 0, null);
	}

	@Override
	public List<Concept> transformData(List<MBHConcept> dbModels) {
		return transformData(dbModels, new HashMap<>());
	}

	private List<Concept> transformData(List<MBHConcept> dbModels, Map<Integer, Concept> visitedConcepts) {
		if (dbModels.isEmpty()) {
			return new ArrayList<Concept>();
		}

		// get child concept mappings
		Map<Integer, List<ConceptMapping>> conceptMappingByConceptId = conceptMappingDBService
				.transformData(conceptMappingDBService
						.getGroupsByIds(MBHConceptMapping::getBH_Concept_ID, MBHConceptMapping.COLUMNNAME_BH_Concept_ID,
								dbModels.stream().map(MBHConcept::get_ID).collect(Collectors.toSet()))
						.values().stream().flatMap(Collection::stream).collect(Collectors.toList()))
				.stream().collect(Collectors.groupingBy(ConceptMapping::getConceptId));

		// get concept extras
		Map<Integer, List<ConceptExtra>> conceptExtraByConceptId = conceptExtraDBService
				.transformData(conceptExtraDBService
						.getGroupsByIds(MBHConceptExtra::getBH_Concept_ID, MBHConceptExtra.COLUMNNAME_BH_Concept_ID,
								dbModels.stream().map(MBHConcept::get_ID).collect(Collectors.toSet()))
						.values().stream().flatMap(Collection::stream).collect(Collectors.toList()))
				.stream().collect(Collectors.groupingBy(ConceptExtra::getConceptId));

		// get concept names
		Map<Integer, List<ConceptName>> conceptNameByConceptId = conceptNameDBService
				.transformData(conceptNameDBService
						.getGroupsByIds(MBHConceptName::getBH_Concept_ID, MBHConceptName.COLUMNNAME_BH_Concept_ID,
								dbModels.stream().map(MBHConcept::get_ID).collect(Collectors.toSet()))
						.values().stream().flatMap(Collection::stream).collect(Collectors.toList()))
				.stream().collect(Collectors.groupingBy(ConceptName::getConceptId));

		// get parent concept mappings
		List<Object> parameters = new ArrayList<>();
		String inClause = QueryUtil.getWhereClauseAndSetParametersForSet(
				dbModels.stream().map(MBHConcept::get_ID).collect(Collectors.toSet()), parameters);

		String whereClause = MBHConceptMapping.COLUMNNAME_BH_To_Concept_Code + " IN ( SELECT "
				+ MBHConcept.COLUMNNAME_BH_OclID + " FROM " + MBHConcept.Table_Name + " WHERE "
				+ MBHConcept.COLUMNNAME_BH_Concept_ID + " IN (" + inClause + ") AND "
				+ MBHConcept.COLUMNNAME_BH_Concept_Class + " = ?)";

		parameters.add(MBHConcept.TEST_CONCEPT_CLASS);

		List<MBHConceptMapping> parentMappingList = new Query(Env.getCtx(), MBHConceptMapping.Table_Name, whereClause,
				null).setParameters(parameters).list();

		Map<String, MBHConceptMapping> parentConceptMappings = parentMappingList.stream()
				.collect(Collectors.toMap(MBHConceptMapping::getBH_To_Concept_Code, mapping -> mapping,
						(existingMmapping, newMapping) -> existingMmapping));

		// get client concept extras
		whereClause = MBHClientConceptExtra.COLUMNNAME_BH_Concept_Extra_ID + " IN (SELECT "
				+ MBHConceptExtra.COLUMNNAME_BH_Concept_Extra_ID + " FROM " + MBHConceptExtra.Table_Name + " WHERE "
				+ MBHConceptExtra.COLUMNNAME_BH_Concept_ID + " IN (" + inClause + "))";

		List<MBHClientConceptExtra> mClientConceptExtras = new Query(Env.getCtx(), MBHClientConceptExtra.Table_Name,
				whereClause, null).list();
		Map<Integer, List<ClientConceptExtra>> clientConceptExtraByConceptId = clientConceptExtraDBService
				.transformData(mClientConceptExtras).stream().collect(Collectors
						.groupingBy(clientConceptExtra -> clientConceptExtra.getConceptExtra().getConceptId()));

		final Map<String, MBHConcept> parentConceptsByConceptId = new HashMap<>();

		if (!parentConceptMappings.isEmpty()) {
			parameters.clear();
			whereClause = QueryUtil.getWhereClauseAndSetParametersForSet(parentConceptMappings.values().stream()
					.map(MBHConceptMapping::getBH_From_Concept_Code).collect(Collectors.toSet()), parameters);

			List<MBHConcept> parentConcepts = new Query(Env.getCtx(), MBHConcept.Table_Name,
					MBHConcept.COLUMNNAME_BH_OclID + " IN (" + whereClause + ")", null).setParameters(parameters)
					.list();

			parentConceptsByConceptId.putAll(
					parentConcepts.stream().collect(Collectors.toMap(MBHConcept::getBH_OclID, concept -> concept)));
		}

		return dbModels.stream().map(entity -> {
			if (visitedConcepts.containsKey(entity.get_ID())) {
				return visitedConcepts.get(entity.get_ID());
			}

			Concept result = new Concept(entity);

			if (conceptMappingByConceptId.containsKey(result.getId())) {
				result.setToConceptMappings(conceptMappingByConceptId.get(result.getId()));
			}

			if (conceptExtraByConceptId.containsKey(result.getId())) {
				result.setConceptExtras(conceptExtraByConceptId.get(result.getId()));
			}

			if (conceptNameByConceptId.containsKey(result.getId())) {
				result.setConceptNames(conceptNameByConceptId.get(result.getId()));
			}

			if (clientConceptExtraByConceptId.containsKey(result.getId())) {
				result.setClientConceptExtras(clientConceptExtraByConceptId.get(result.getId()));
			}

			if (parentConceptMappings.containsKey(result.getOclId())) {
				result.getFromConceptMappings().add(transformData(Collections.singletonList(parentConceptsByConceptId
						.get(parentConceptMappings.get(result.getOclId()).getBH_From_Concept_Code()))).get(0));
			}

			return result;

		}).collect(Collectors.toList());
	}

	@Override
	protected EntityConfiguration getDefaultEntityConfiguration() {
		return new EntityConfiguration() {
			{
				setShouldUseContextClientId(false);
				setShouldFetchFromSystemClient(true);
			}
		};
	}
}
