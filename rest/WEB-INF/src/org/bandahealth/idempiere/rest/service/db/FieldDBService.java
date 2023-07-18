package org.bandahealth.idempiere.rest.service.db;

import java.util.Collections;

import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.Field;
import org.compiere.model.MField;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

@Component
public class FieldDBService extends BaseDBService<Field, MField> {

	@Override
	public Field saveEntity(Field entity) {
		return null;
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new NotImplementedException();
	}

	@Override
	protected Field createInstanceWithDefaultFields(MField instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected Field createInstanceWithAllFields(MField instance) {
		return transformData(Collections.singletonList(instance)).get(0);
	}

	@Override
	protected Field createInstanceWithSearchFields(MField instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MField getModelInstance() {
		return new MField(Env.getCtx(), 0, null);
	}
}
