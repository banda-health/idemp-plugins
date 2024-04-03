package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MBHConceptName;
import org.bandahealth.idempiere.rest.model.ConceptName;
import org.compiere.util.Env;

public class ConceptNameDBService extends BaseDBService<ConceptName, MBHConceptName> {

	@Override
	public ConceptName saveEntity(ConceptName entity) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	protected ConceptName createInstanceWithDefaultFields(MBHConceptName instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected ConceptName createInstanceWithAllFields(MBHConceptName instance) {
		return new ConceptName(instance);
	}

	@Override
	protected MBHConceptName getModelInstance() {
		return new MBHConceptName(Env.getCtx(), 0, null);
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
