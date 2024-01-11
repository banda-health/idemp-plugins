package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ColumnDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ReferenceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_WS_WebServiceTypeDataLoader;
import org.compiere.model.MColumn;
import org.compiere.model.X_WS_WebServiceFieldInput;
import org.compiere.model.X_WS_WebServiceType;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for WS_WebServiceFieldInput - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_WS_WebServiceFieldInputResolver extends POResolver<X_WS_WebServiceFieldInput> implements GraphQLResolver<X_WS_WebServiceFieldInput> {



	/**
	 * Get Column.
	 *
	 * @return Column in the table
	 */
	public CompletableFuture<MColumn> AD_Column(X_WS_WebServiceFieldInput entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Column_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MColumn> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ColumnDataLoader.AD_Column_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Column_ID());
	}


	/**
	 * Get Reference.
	 *
	 * @return System Reference and Validation
	 */
	public CompletableFuture<MReference_BH> AD_Reference(X_WS_WebServiceFieldInput entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Reference_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MReference_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ReferenceDataLoader.AD_Reference_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Reference_ID());
	}


	/**
	 * Get Reference Key.
	 *
	 * @return Required to specify, if data type is Table or List
	 */
	public CompletableFuture<MReference_BH> AD_Reference_Value(X_WS_WebServiceFieldInput entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Reference_Value_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MReference_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ReferenceDataLoader.AD_Reference_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Reference_Value_ID());
	}

	public Boolean IsIdentifier(X_WS_WebServiceFieldInput entity, DataFetchingEnvironment environment) {
		return entity.isIdentifier();
	}

	public Boolean IsNullIdentifier(X_WS_WebServiceFieldInput entity, DataFetchingEnvironment environment) {
		return entity.isNullIdentifier();
	}


	/**
	 * Get Web Service Type.
	 *
	 * @return Web Service Type
	 */
	public CompletableFuture<X_WS_WebServiceType> WS_WebServiceType(X_WS_WebServiceFieldInput entity, DataFetchingEnvironment environment) {
		if (entity.getWS_WebServiceType_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_WS_WebServiceType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_WS_WebServiceTypeDataLoader.WS_WebServiceType_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getWS_WebServiceType_ID());
	}

}
