package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_WS_WebServiceDataLoader;
import org.compiere.model.X_WS_WebService;
import org.compiere.model.X_WS_WebServiceMethod;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for WS_WebServiceMethod - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_WS_WebServiceMethodResolver extends POResolver<X_WS_WebServiceMethod> implements GraphQLResolver<X_WS_WebServiceMethod> {



	/**
	 * Get Web Service.
	 *
	 * @return Web Service
	 */
	public CompletableFuture<X_WS_WebService> WS_WebService(X_WS_WebServiceMethod entity, DataFetchingEnvironment environment) {
		if (entity.getWS_WebService_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_WS_WebService> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_WS_WebServiceDataLoader.WS_WebService_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getWS_WebService_ID());
	}

}
