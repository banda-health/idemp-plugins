package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MSerNoCtl_BH;
import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.SerialNumberControl;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

@Component
public class SerialNumberControlDBService extends BaseDBService<SerialNumberControl, MSerNoCtl_BH> {
	@Override
	public SerialNumberControl saveEntity(SerialNumberControl entity) {
		throw new NotImplementedException();
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new NotImplementedException();
	}

	@Override
	protected SerialNumberControl createInstanceWithDefaultFields(MSerNoCtl_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected SerialNumberControl createInstanceWithAllFields(MSerNoCtl_BH instance) {
		return new SerialNumberControl(instance);
	}

	@Override
	protected SerialNumberControl createInstanceWithSearchFields(MSerNoCtl_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MSerNoCtl_BH getModelInstance() {
		return new MSerNoCtl_BH(Env.getCtx(), 0, null);
	}
}
