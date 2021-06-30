package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MBHVoidedReason;
import org.bandahealth.idempiere.rest.model.VoidedReason;
import org.compiere.util.Env;

public class VoidedReasonDBService extends BaseDBService<VoidedReason, MBHVoidedReason> {

	@Override
	public VoidedReason saveEntity(VoidedReason entity) {
		return null;
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		return null;
	}

	@Override
	protected VoidedReason createInstanceWithDefaultFields(MBHVoidedReason instance) {
		return new VoidedReason(instance);
	}

	@Override
	protected VoidedReason createInstanceWithAllFields(MBHVoidedReason instance) {
		return new VoidedReason(instance);
	}

	@Override
	protected VoidedReason createInstanceWithSearchFields(MBHVoidedReason instance) {
		return new VoidedReason(instance);
	}

	@Override
	protected MBHVoidedReason getModelInstance() {
		return new MBHVoidedReason(Env.getCtx(), 0, null);
	}
}
