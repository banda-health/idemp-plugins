package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.rest.function.VoidFunction;
import org.bandahealth.idempiere.rest.model.ProcessParameter;
import org.compiere.model.MProcessPara;
import org.compiere.model.MRefList;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
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

	@Override
	protected Map<String, Function<MProcessPara, VoidFunction<String>>> getColumnsToTranslate() {
		return new HashMap<>() {{
			put(MProcessPara.COLUMNNAME_Name, entity -> entity::setName);
			put(MProcessPara.COLUMNNAME_Description, entity -> entity::setDescription);
		}};
	}

	@Override
	protected boolean isClientIdFromTheContextNeededByDefaultForThisEntity() {
		return false;
	}
}
