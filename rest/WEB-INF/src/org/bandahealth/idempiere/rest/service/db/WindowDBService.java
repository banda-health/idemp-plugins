package org.bandahealth.idempiere.rest.service.db;

import java.util.Map;
import java.util.Set;

import org.bandahealth.idempiere.rest.model.Window;
import org.compiere.model.MWindow;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

@Component
public class WindowDBService extends BaseDBService<Window, MWindow> {
	@Override
	public Window saveEntity(Window entity) {
		return null;
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		return null;
	}

	@Override
	protected Window createInstanceWithDefaultFields(MWindow instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected Window createInstanceWithAllFields(MWindow instance) {
		return new Window(instance);
	}

	@Override
	protected Window createInstanceWithSearchFields(MWindow instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MWindow getModelInstance() {
		return new MWindow(Env.getCtx(), 0, null);
	}

	protected boolean isClientIdFromTheContextNeededByDefaultForThisEntity() {
		return false;
	}
}
