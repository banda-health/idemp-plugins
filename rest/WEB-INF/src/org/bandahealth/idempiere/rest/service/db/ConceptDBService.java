package org.bandahealth.idempiere.rest.service.db;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.bandahealth.idempiere.base.model.MBHConcept;
import org.bandahealth.idempiere.base.model.MBHConceptMapping;
import org.bandahealth.idempiere.rest.model.Concept;
import org.bandahealth.idempiere.rest.model.ConceptMapping;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConceptDBService extends BaseDBService<Concept, MBHConcept> {

	@Autowired
	private ConceptMappingDBService conceptMappingDBService;

	@Override
	public Concept saveEntity(Concept entity) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new UnsupportedOperationException("Not implemented");
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

		return dbModels.stream().map(entity -> {
			Concept result = new Concept(entity);

			if (conceptMappingByConceptId.containsKey(result.getId())) {
				result.setConceptMappings(conceptMappingByConceptId.get(result.getId()));
			}

			return result;

		}).collect(Collectors.toList());
	}
}
