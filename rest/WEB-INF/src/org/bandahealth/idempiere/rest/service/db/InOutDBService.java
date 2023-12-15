package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MInOut_BH;
import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.InOut;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

@Component
public class InOutDBService extends BaseDBService<InOut, MInOut_BH> {
	@Override
	public InOut saveEntity(InOut entity) {
		throw new NotImplementedException();
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new NotImplementedException();
	}

	@Override
	protected InOut createInstanceWithDefaultFields(MInOut_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected InOut createInstanceWithAllFields(MInOut_BH instance) {
		return new InOut(instance);
	}

	@Override
	protected MInOut_BH getModelInstance() {
		return new MInOut_BH(Env.getCtx(), 0, null);
	}
}
