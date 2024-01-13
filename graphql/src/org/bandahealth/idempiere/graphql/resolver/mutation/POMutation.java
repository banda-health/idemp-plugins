package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.PO;
import org.compiere.util.CLogger;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

public abstract class POMutation {
	protected final CLogger log;

	public POMutation() {
		log = CLogger.getCLogger(getClass());
	}

	protected abstract String getTableName();

	protected PO save(PO entity, DataFetchingEnvironment environment) {
		ModelUtil.getTableAndCheckAccess(BandaGraphQLContext.getCtx(environment), getTableName(), true);
//		entity.saveEx();
		return entity;
	}

	protected boolean delete(List<String> uuids, DataFetchingEnvironment environment) {
		ModelUtil.getTableAndCheckAccess(BandaGraphQLContext.getCtx(environment), getTableName(), true);
		Map<String, PO> entitiesByUuid =
				Repository.getByUuids(BandaGraphQLContext.getCtx(environment), getTableName(), null, new HashSet<>(uuids));
		entitiesByUuid.values().forEach(entity -> entity.deleteEx(true));
		return true;
	}
}
