package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MBHConceptMapping;
import org.bandahealth.idempiere.rest.model.ConceptMapping;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

@Component
public class ConceptMappingDBService extends BaseDBService<ConceptMapping, MBHConceptMapping> {

	@Override
	public ConceptMapping saveEntity(ConceptMapping entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		// TODO Auto-generated method stub
		return null;
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

}
