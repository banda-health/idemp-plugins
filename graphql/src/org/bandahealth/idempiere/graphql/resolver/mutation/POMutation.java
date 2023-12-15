package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.PO;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

public abstract class POMutation<T extends PO> {
	protected abstract String getTableName();

	protected T save(T entity) {
		entity.saveEx();
		return entity;
	}

	protected boolean delete(List<String> uuids, DataFetchingEnvironment environment) {
		Map<String, T> entitiesByUuid =
				Repository.getByUuids(BandaGraphQLContext.getCtx(environment), getTableName(), null, new HashSet<>(uuids));
		entitiesByUuid.values().forEach(entity -> entity.deleteEx(true));
		return true;
	}
}
