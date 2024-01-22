package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_RoleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_WS_WebServiceTypeDataLoader;
import org.compiere.model.X_AD_Role;
import org.compiere.model.X_WS_WebServiceType;
import org.compiere.model.X_WS_WebServiceTypeAccess;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for WS_WebServiceTypeAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_WS_WebServiceTypeAccessResolver extends POResolver<X_WS_WebServiceTypeAccess> implements GraphQLResolver<X_WS_WebServiceTypeAccess> {



	/**
	 * Get Role.
	 *
	 * @return Responsibility Role
	 */
	public CompletableFuture<X_AD_Role> AD_Role(X_WS_WebServiceTypeAccess entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Role_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_Role> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_RoleDataLoader.DATALOADER_AD_Role_BY_ID);
		return dataLoader.load(entity.getAD_Role_ID());
	}

	public Boolean IsReadWrite(X_WS_WebServiceTypeAccess entity, DataFetchingEnvironment environment) {
		return entity.isReadWrite();
	}


	/**
	 * Get Web Service Type.
	 *
	 * @return Web Service Type
	 */
	public CompletableFuture<X_WS_WebServiceType> WS_WebServiceType(X_WS_WebServiceTypeAccess entity, DataFetchingEnvironment environment) {
		if (entity.getWS_WebServiceType_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_WS_WebServiceType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_WS_WebServiceTypeDataLoader.DATALOADER_WS_WebServiceType_BY_ID);
		return dataLoader.load(entity.getWS_WebServiceType_ID());
	}

}
