package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Asset_ClassDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Asset_TypeDataLoader;
import org.compiere.model.MAssetClass;
import org.compiere.model.MAssetGroup;
import org.compiere.model.MAssetType;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for A_Asset_Group - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_GroupResolver extends POResolver<MAssetGroup> implements GraphQLResolver<MAssetGroup> {



	/**
	 * Get Asset class.
	 *
	 * @return Asset class
	 */
	public CompletableFuture<MAssetClass> A_Asset_Class(MAssetGroup entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_Class_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAssetClass> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_Asset_ClassDataLoader.A_Asset_Class_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getA_Asset_Class_ID());
	}


	/**
	 * Get Asset Type.
	 *
	 * @return Asset Type
	 */
	public CompletableFuture<MAssetType> A_Asset_Type(MAssetGroup entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_Type_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAssetType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_Asset_TypeDataLoader.A_Asset_Type_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getA_Asset_Type_ID());
	}

}
