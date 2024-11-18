package org.bandahealth.idempiere.rest.service.db;

import java.util.List;
import java.util.stream.Collectors;

import org.bandahealth.idempiere.base.model.MBHConceptExtra;
import org.bandahealth.idempiere.rest.model.ConceptExtra;
import org.compiere.util.Env;

public class ConceptExtraDBService extends BaseDBService<ConceptExtra, MBHConceptExtra> {

	@Override
	public ConceptExtra saveEntity(ConceptExtra entity) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	protected ConceptExtra createInstanceWithDefaultFields(MBHConceptExtra instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected ConceptExtra createInstanceWithAllFields(MBHConceptExtra instance) {
		return new ConceptExtra(instance);
	}

	@Override
	protected MBHConceptExtra getModelInstance() {
		return new MBHConceptExtra(Env.getCtx(), 0, null);
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
	public List<ConceptExtra> transformData(List<MBHConceptExtra> dbModels) {
		return dbModels.stream().map(entity -> {
			ConceptExtra result = new ConceptExtra(entity);
			result.setConceptId(entity.getBH_Concept_ID());

			return result;
		}).collect(Collectors.toList());
	}

}
