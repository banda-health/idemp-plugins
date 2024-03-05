package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MBHConceptExtra;
import org.bandahealth.idempiere.rest.model.ConceptExtra;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

@Component
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

}
