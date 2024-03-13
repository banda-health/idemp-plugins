package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MBHConceptDescription;
import org.bandahealth.idempiere.rest.model.ConceptDescription;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

@Component
public class ConceptDescriptionDBService extends BaseDBService<ConceptDescription, MBHConceptDescription> {

	@Override
	public ConceptDescription saveEntity(ConceptDescription entity) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	protected ConceptDescription createInstanceWithDefaultFields(MBHConceptDescription instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected ConceptDescription createInstanceWithAllFields(MBHConceptDescription instance) {
		return new ConceptDescription(instance);
	}

	@Override
	protected MBHConceptDescription getModelInstance() {
		return new MBHConceptDescription(Env.getCtx(), 0, null);
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new UnsupportedOperationException("Not implemented");
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
