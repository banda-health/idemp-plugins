package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_AllClients_VDataLoader;
import org.compiere.model.X_AD_AllClients_V;
import org.compiere.model.X_AD_AllUsers_V;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_AllUsers_V - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_AllUsers_VResolver extends POResolver<X_AD_AllUsers_V> implements GraphQLResolver<X_AD_AllUsers_V> {



	/**
	 * Get Tenant (All).
	 *
	 * @return Tenant (All)
	 */
	public CompletableFuture<X_AD_AllClients_V> AD_AllClients_V(X_AD_AllUsers_V entity, DataFetchingEnvironment environment) {
		if (entity.getAD_AllClients_V_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_AD_AllClients_V> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_AllClients_VDataLoader.DATALOADER_AD_AllClients_V_BY_ID);
		return dataLoader.load(entity.getAD_AllClients_V_ID());
	}

	public Boolean IsExpired(X_AD_AllUsers_V entity, DataFetchingEnvironment environment) {
		return entity.isExpired();
	}

	public Boolean IsLocked(X_AD_AllUsers_V entity, DataFetchingEnvironment environment) {
		return entity.isLocked();
	}

	public Boolean IsNoExpire(X_AD_AllUsers_V entity, DataFetchingEnvironment environment) {
		return entity.isNoExpire();
	}

	public Boolean IsNoPasswordReset(X_AD_AllUsers_V entity, DataFetchingEnvironment environment) {
		return entity.isNoPasswordReset();
	}

	public Boolean IsSupportUser(X_AD_AllUsers_V entity, DataFetchingEnvironment environment) {
		return entity.isSupportUser();
	}

}
