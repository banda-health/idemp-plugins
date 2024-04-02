package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.InOutLine;
import org.compiere.model.MInOutLine;
import org.compiere.util.Env;

public class InOutLineDBService extends BaseDBService<InOutLine, MInOutLine> {
	private final InOutDBService inOutDBService = new InOutDBService();

	@Override
	public InOutLine saveEntity(InOutLine entity) {
		throw new NotImplementedException();
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new NotImplementedException();
	}

	@Override
	protected InOutLine createInstanceWithDefaultFields(MInOutLine instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected InOutLine createInstanceWithAllFields(MInOutLine instance) {
		return new InOutLine(instance);
	}

	@Override
	protected MInOutLine getModelInstance() {
		return new MInOutLine(Env.getCtx(), 0, null);
	}
}
