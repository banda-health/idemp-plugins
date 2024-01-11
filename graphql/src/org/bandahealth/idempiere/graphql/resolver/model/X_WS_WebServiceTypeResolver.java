package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TableDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_WS_WebServiceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_WS_WebServiceMethodDataLoader;
import org.compiere.model.MTable;
import org.compiere.model.X_WS_WebService;
import org.compiere.model.X_WS_WebServiceMethod;
import org.compiere.model.X_WS_WebServiceType;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for WS_WebServiceType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_WS_WebServiceTypeResolver extends POResolver<X_WS_WebServiceType> implements GraphQLResolver<X_WS_WebServiceType> {



	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	public CompletableFuture<MTable> AD_Table(X_WS_WebServiceType entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Table_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTable> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TableDataLoader.AD_Table_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Table_ID());
	}


	/**
	 * Get Web Service.
	 *
	 * @return Web Service
	 */
	public CompletableFuture<X_WS_WebService> WS_WebService(X_WS_WebServiceType entity, DataFetchingEnvironment environment) {
		if (entity.getWS_WebService_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_WS_WebService> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_WS_WebServiceDataLoader.WS_WebService_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getWS_WebService_ID());
	}


	/**
	 * Get Web Service Method.
	 *
	 * @return Web Service Method
	 */
	public CompletableFuture<X_WS_WebServiceMethod> WS_WebServiceMethod(X_WS_WebServiceType entity, DataFetchingEnvironment environment) {
		if (entity.getWS_WebServiceMethod_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_WS_WebServiceMethod> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_WS_WebServiceMethodDataLoader.WS_WebServiceMethod_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getWS_WebServiceMethod_ID());
	}

}
