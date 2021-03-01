package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.rest.model.ProcessParameter;
import org.compiere.model.MProcessPara;
import org.compiere.util.Env;

public class ProcessParameterDBService extends BaseDBService<ProcessParameter, MProcessPara> {
	@Override
	public ProcessParameter saveEntity(ProcessParameter entity) {
		return null;
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		return null;
	}

	@Override
	protected ProcessParameter createInstanceWithDefaultFields(MProcessPara instance) {
		return this.createInstanceWithAllFields(instance);
	}

	@Override
	protected ProcessParameter createInstanceWithAllFields(MProcessPara instance) {
		return new ProcessParameter(instance, null, null);
	}

	@Override
	protected ProcessParameter createInstanceWithSearchFields(MProcessPara instance) {
		return this.createInstanceWithAllFields(instance);
	}

	@Override
	protected MProcessPara getModelInstance() {
		return new MProcessPara(Env.getCtx(), 0, null);
	}
}
