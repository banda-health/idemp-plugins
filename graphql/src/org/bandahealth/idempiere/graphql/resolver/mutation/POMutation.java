package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.schema.DataFetchingEnvironment;
import org.adempiere.util.ServerContext;
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
		// For some reason the context isn't always set during entity initialization, so set some fields correctly
		if (entity.getAD_Client_ID() == 0) {
			entity.set_ValueNoCheck("AD_Client_ID", Env.getAD_Client_ID(idempiereProperties));
		}
		// These properties only get updated if the entity is new
		if (entity.get_ID() == 0) {
			if ( entity.getAD_Org_ID() == 0) {
				entity.setAD_Org_ID(Env.getAD_Org_ID(idempiereProperties));
			}
			if ( entity.getCreatedBy() == 0) {
				entity.set_ValueNoCheck("CreatedBy", Env.getAD_User_ID(idempiereProperties));
			}
		}
		entity.set_ValueNoCheck("UpdatedBy", Env.getAD_User_ID(idempiereProperties));
		entity.saveEx();
		return entity;
	}

	protected List<PO> saveMany(List<PO> entities, DataFetchingEnvironment environment) {
		Trx saveManyTransaction = Trx.get(Trx.createTrxName("SaveMany"), true);
		try {
			Properties idempiereProperties = BandaGraphQLContext.getCtx(environment);
			for (PO entity : entities) {
				entity.set_TrxName(saveManyTransaction.getTrxName());
				save(entity, environment);
			}
			saveManyTransaction.commit();
		} catch (Exception exception) {
			saveManyTransaction.rollback();
			throw exception;
		}
		finally {
			saveManyTransaction.close();
		}
		return entities;
	}

	protected boolean delete(List<String> uuids, DataFetchingEnvironment environment) {
		ModelUtil.getTableAndCheckAccess(BandaGraphQLContext.getCtx(environment), getTableName(), true);
		Map<String, PO> entitiesByUuid =
				Repository.getByUuids(BandaGraphQLContext.getCtx(environment), getTableName(), null, new HashSet<>(uuids));
		entitiesByUuid.values().forEach(entity -> entity.deleteEx(false));
		return true;
	}
}
