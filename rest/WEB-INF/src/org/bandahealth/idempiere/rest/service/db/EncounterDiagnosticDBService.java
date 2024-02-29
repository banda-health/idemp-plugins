package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MBHEncounterDiagnostic;
import org.bandahealth.idempiere.rest.model.EncounterDiagnostic;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

@Component
public class EncounterDiagnosticDBService extends BaseDBService<EncounterDiagnostic, MBHEncounterDiagnostic> {

	@Override
	public EncounterDiagnostic saveEntity(EncounterDiagnostic entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected EncounterDiagnostic createInstanceWithDefaultFields(MBHEncounterDiagnostic instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected EncounterDiagnostic createInstanceWithAllFields(MBHEncounterDiagnostic instance) {
		return new EncounterDiagnostic(instance);
	}

	@Override
	protected MBHEncounterDiagnostic getModelInstance() {
		return new MBHEncounterDiagnostic(Env.getCtx(), 0, null);
	}

}
