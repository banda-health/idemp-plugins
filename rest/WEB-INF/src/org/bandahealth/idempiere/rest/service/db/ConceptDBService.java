package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MBHConcept;
import org.bandahealth.idempiere.rest.model.Concept;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

@Component
public class ConceptDBService extends BaseDBService<Concept, MBHConcept> {

	@Override
	public Concept saveEntity(Concept entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		// TODO Auto-generated method stub
		return null;
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

}
