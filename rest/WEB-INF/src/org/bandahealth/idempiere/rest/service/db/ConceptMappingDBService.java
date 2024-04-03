package org.bandahealth.idempiere.rest.service.db;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.bandahealth.idempiere.base.model.MBHConceptExtra;
import org.bandahealth.idempiere.base.model.MBHConceptMapping;
import org.bandahealth.idempiere.rest.model.ConceptExtra;
import org.bandahealth.idempiere.rest.model.ConceptMapping;
import org.compiere.util.Env;

public class ConceptMappingDBService extends BaseDBService<ConceptMapping, MBHConceptMapping> {

	private final ConceptExtraDBService conceptExtraDBService = new ConceptExtraDBService();

	@Override
	public ConceptMapping saveEntity(ConceptMapping entity) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	protected ConceptMapping createInstanceWithDefaultFields(MBHConceptMapping instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected ConceptMapping createInstanceWithAllFields(MBHConceptMapping instance) {
		return new ConceptMapping(instance);
	}

	@Override
	protected MBHConceptMapping getModelInstance() {
		return new MBHConceptMapping(Env.getCtx(), 0, null);
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

	@Override
	public List<ConceptMapping> transformData(List<MBHConceptMapping> dbModels) {
		// get concept extras
		Map<Integer, List<ConceptExtra>> conceptExtraByConceptMappingId = conceptExtraDBService
				.transformData(conceptExtraDBService
						.getGroupsByIds(MBHConceptExtra::getBH_Concept_Mapping_ID,
								MBHConceptExtra.COLUMNNAME_BH_Concept_Mapping_ID,
								dbModels.stream().map(MBHConceptMapping::getBH_Concept_Mapping_ID)
										.collect(Collectors.toSet()))
						.values().stream().flatMap(Collection::stream).collect(Collectors.toList()))
				.stream().collect(Collectors.groupingBy(ConceptExtra::getConceptMappingId));

		return dbModels.stream().map(entity -> {
			ConceptMapping result = new ConceptMapping(entity);

			if (conceptExtraByConceptMappingId.containsKey(result.getId())) {
				result.setConceptExtras(conceptExtraByConceptMappingId.get(result.getId()));
			}

			return result;

		}).collect(Collectors.toList());
	}

}
