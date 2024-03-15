package org.bandahealth.idempiere.rest.service.db;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHConcept;
import org.bandahealth.idempiere.base.model.MBHConceptExtra;
import org.bandahealth.idempiere.base.model.MBHConceptMapping;
import org.bandahealth.idempiere.rest.model.Concept;
import org.bandahealth.idempiere.rest.model.ConceptMapping;
import org.bandahealth.idempiere.rest.model.ConceptExtra;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConceptDBService extends BaseDBService<Concept, MBHConcept> {

	@Autowired
	private ConceptMappingDBService conceptMappingDBService;

	@Autowired
	private ConceptExtraDBService conceptExtraDBService;

	@Override
	public Concept saveEntity(Concept entity) {
		MBHConcept concept = getEntityByUuidFromDB(entity.getUuid());
		if (concept == null) {
			concept = new MBHConcept(Env.getCtx(), 0, null);
			concept.setBH_Concept_UU(entity.getUuid());
		}

		concept.setIsActive(entity.getIsActive());
		concept.setBH_Data_Type(entity.getDataType());
		concept.setbh_concept_class(entity.getConceptClass());
		concept.setBH_Concept_Type(entity.getConceptType());
		concept.setBH_Display_Locale(entity.getDisplayLocale());
		concept.setBH_Display_Name(entity.getDisplayName());
		concept.setBH_ExternalID(entity.getExternalId());
		concept.setBH_OclID(entity.getOclId());
		concept.setBH_Owner(entity.getOwner());
		concept.setBH_Source(entity.getSource());
		concept.setURL(entity.getUrl());

		concept.saveEx();

		// save mappings
		if (entity.getConceptMappings() != null && !entity.getConceptMappings().isEmpty()) {
			for (ConceptMapping conceptMapping : entity.getConceptMappings()) {
				conceptMappingDBService.saveEntity(conceptMapping);
			}
		}

		return transformData(Collections.singletonList(getEntityByUuidFromDB(concept.getUUIDColumnName()))).get(0);
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
		return new Concept(instance);
	}

	@Override
	protected MBHConcept getModelInstance() {
		return new MBHConcept(Env.getCtx(), 0, null);
	}

	@Override
	public List<Concept> transformData(List<MBHConcept> dbModels) {
		// get concept mappings
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

		return dbModels.stream().map(entity -> {
			Concept result = new Concept(entity);

			if (conceptMappingByConceptId.containsKey(result.getId())) {
				result.setConceptMappings(conceptMappingByConceptId.get(result.getId()));
			}

			if (conceptExtraByConceptId.containsKey(result.getId())) {
				result.setConceptExtras(conceptExtraByConceptId.get(result.getId()));
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
