package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.SerialNumberControl;
import org.compiere.model.MSerNoCtl;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

@Component
public class SerialNumberControlDBService extends BaseDBService<SerialNumberControl, MSerNoCtl> {
	@Override
	public SerialNumberControl saveEntity(SerialNumberControl entity) {
		throw new NotImplementedException();
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new NotImplementedException();
	}

	@Override
	protected SerialNumberControl createInstanceWithDefaultFields(MSerNoCtl instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected SerialNumberControl createInstanceWithAllFields(MSerNoCtl instance) {
		return new SerialNumberControl(instance);
	}

	@Override
	protected SerialNumberControl createInstanceWithSearchFields(MSerNoCtl instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MSerNoCtl getModelInstance() {
		return new MSerNoCtl(Env.getCtx(), 0, null);
	}
}
