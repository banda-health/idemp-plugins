package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.rest.model.Reference;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

@Component
public class ReferenceDBService extends BaseDBService<Reference, MReference_BH> {
	@Override
	public Reference saveEntity(Reference entity) {
		return null;
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		return null;
	}

	@Override
	protected Reference createInstanceWithDefaultFields(MReference_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected Reference createInstanceWithAllFields(MReference_BH instance) {
		return new Reference(instance);
	}

	@Override
	protected Reference createInstanceWithSearchFields(MReference_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MReference_BH getModelInstance() {
		return new MReference_BH(Env.getCtx(), 0, null);
	}

	@Override
	protected boolean isClientIdFromTheContextNeededByDefaultForThisEntity() {
		return false;
	}
}
