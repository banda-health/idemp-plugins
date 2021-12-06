package org.bandahealth.idempiere.rest.service.db;

import java.util.HashMap;
import java.util.Map;

import org.bandahealth.idempiere.base.model.MBHVoidedReason;
import org.bandahealth.idempiere.rest.model.VoidedReason;
import org.compiere.model.MWindow;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

@Component
public class VoidedReasonDBService extends BaseDBService<VoidedReason, MBHVoidedReason> {
	private Map<String, String> dynamicJoins = new HashMap<>() {
		{
			put(MWindow.Table_Name, "LEFT JOIN " + MWindow.Table_Name + " ON " + MBHVoidedReason.Table_Name + "."
					+ MBHVoidedReason.COLUMNNAME_BH_Window_Id + " = " + MWindow.Table_Name + "." + MWindow.COLUMNNAME_AD_Window_ID
			);
		}
	};

	@Override
	public Map<String, String> getDynamicJoins() {
		return dynamicJoins;
	}

	@Override
	public VoidedReason saveEntity(VoidedReason entity) {
		// We don't have a requirement to allow this
		return null;
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		// We don't have a requirement to allow this
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

	@Override
	protected boolean isClientIdFromTheContextNeededByDefaultForThisEntity() {
		return false;
	}
}
