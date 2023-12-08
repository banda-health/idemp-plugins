package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MFieldGroup_BH;
import org.bandahealth.idempiere.rest.exceptions.NotImplementedException;
import org.bandahealth.idempiere.rest.model.FieldGroup;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

@Component
public class FieldGroupDBService extends BaseDBService<FieldGroup, MFieldGroup_BH> {

	@Override
	public FieldGroup saveEntity(FieldGroup entity) {
		return null;
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new NotImplementedException();
	}

	@Override
	protected FieldGroup createInstanceWithDefaultFields(MFieldGroup_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected FieldGroup createInstanceWithAllFields(MFieldGroup_BH instance) {
		return new FieldGroup(instance);
	}

	@Override
	protected MFieldGroup_BH getModelInstance() {
		return new MFieldGroup_BH(Env.getCtx(), 0, null);
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
