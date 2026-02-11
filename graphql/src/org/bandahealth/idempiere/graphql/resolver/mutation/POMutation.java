package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.PO;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.compiere.util.Trx;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public abstract class POMutation {
	protected final CLogger log;

	public POMutation() {
		log = CLogger.getCLogger(getClass());
	}

	protected abstract String getTableName();

	protected PO save(PO entity, DataFetchingEnvironment environment) {
		Properties idempiereProperties = BandaGraphQLContext.getCtx(environment);
		ModelUtil.getTableAndCheckAccess(idempiereProperties, getTableName(), true);
		entity.saveEx();
		return entity;
	}

	protected List<PO> saveMany(List<PO> entities, DataFetchingEnvironment environment) {
		Trx saveManyTransaction = Trx.get(Trx.createTrxName("SaveMany"), true);
		try {
			for (PO entity : entities) {
				entity.set_TrxName(saveManyTransaction.getTrxName());
				save(entity, environment);
			}
			saveManyTransaction.commit();
		} catch (Exception exception) {
			saveManyTransaction.rollback();
			throw exception;
		} finally {
			saveManyTransaction.close();
		}
		return entities;
	}

	protected boolean delete(List<String> uuids, DataFetchingEnvironment environment) {
		ModelUtil.getTableAndCheckAccess(BandaGraphQLContext.getCtx(environment), getTableName(), true);
		Map<String, PO> entitiesByUuid =
				Repository.getByUuids(BandaGraphQLContext.getCtx(environment), getTableName(), null, new HashSet<>(uuids));
		// Since ordering might matter, use the original UU ordering for deletion
		uuids.forEach(uuid -> {
			PO entity = entitiesByUuid.get(uuid);
			if (entity != null) {
				entity.deleteEx(false);
			}
		});
		return true;
	}
}
