package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_AssetDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Asset_Info_OthDataLoader;
import org.compiere.model.MAsset;
import org.compiere.model.X_A_Asset_Info_Oth;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for A_Asset_Info_Oth - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Asset_Info_OthResolver extends POResolver<X_A_Asset_Info_Oth> implements GraphQLResolver<X_A_Asset_Info_Oth> {



	/**
	 * Get Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	public CompletableFuture<MAsset> A_Asset(X_A_Asset_Info_Oth entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MAsset> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_AssetDataLoader.DATALOADER_A_Asset_BY_ID);
		return dataLoader.load(entity.getA_Asset_ID());
	}


	/**
	 * Get A_Asset_Info_Oth_ID.
	 *
	 * @return A_Asset_Info_Oth_ID
	 */
	public CompletableFuture<X_A_Asset_Info_Oth> A_Asset_Info_Oth(X_A_Asset_Info_Oth entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_Info_Oth_ID() < 0) {
			return null;
		}
		DataLoader<Integer, X_A_Asset_Info_Oth> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_Asset_Info_OthDataLoader.DATALOADER_A_Asset_Info_Oth_BY_ID);
		return dataLoader.load(entity.getA_Asset_Info_Oth_ID());
	}

}
