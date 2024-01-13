package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ColumnDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_WS_WebServiceTypeDataLoader;
import org.compiere.model.MColumn;
import org.compiere.model.X_WS_WebServiceFieldOutput;
import org.compiere.model.X_WS_WebServiceType;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for WS_WebServiceFieldOutput - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_WS_WebServiceFieldOutputResolver extends POResolver<X_WS_WebServiceFieldOutput> implements GraphQLResolver<X_WS_WebServiceFieldOutput> {



	/**
	 * Get Column.
	 *
	 * @return Column in the table
	 */
	public CompletableFuture<MColumn> AD_Column(X_WS_WebServiceFieldOutput entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Column_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MColumn> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ColumnDataLoader.DATALOADER_AD_Column_BY_ID);
		return dataLoader.load(entity.getAD_Column_ID());
	}


	/**
	 * Get Web Service Type.
	 *
	 * @return Web Service Type
	 */
	public CompletableFuture<X_WS_WebServiceType> WS_WebServiceType(X_WS_WebServiceFieldOutput entity, DataFetchingEnvironment environment) {
		if (entity.getWS_WebServiceType_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_WS_WebServiceType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_WS_WebServiceTypeDataLoader.DATALOADER_WS_WebServiceType_BY_ID);
		return dataLoader.load(entity.getWS_WebServiceType_ID());
	}

}
