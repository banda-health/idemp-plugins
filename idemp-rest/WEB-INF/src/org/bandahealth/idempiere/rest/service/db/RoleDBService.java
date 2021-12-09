package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.rest.model.Role;
import org.compiere.model.MRole;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Component
public class RoleDBService extends BaseDBService<Role, MRole> {
	@Override
	public Role saveEntity(Role entity) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	protected Role createInstanceWithDefaultFields(MRole instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected Role createInstanceWithAllFields(MRole instance) {
		return new Role(instance);
	}

	@Override
	protected Role createInstanceWithSearchFields(MRole instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MRole getModelInstance() {
		return new MRole(Env.getCtx(), 0, null);
	}
}
