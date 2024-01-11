package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Package_ImpDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TableDataLoader;
import org.compiere.model.MTable;
import org.compiere.model.X_AD_Package_Imp;
import org.compiere.model.X_AD_Package_Imp_Detail;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Package_Imp_Detail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Package_Imp_DetailResolver extends POResolver<X_AD_Package_Imp_Detail> implements GraphQLResolver<X_AD_Package_Imp_Detail> {



	/**
	 * Get Package Imp..
	 *
	 * @return Package Imp.
	 */
	public CompletableFuture<X_AD_Package_Imp> AD_Package_Imp(X_AD_Package_Imp_Detail entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Package_Imp_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_Package_Imp> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Package_ImpDataLoader.AD_Package_Imp_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Package_Imp_ID());
	}


	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	public CompletableFuture<MTable> AD_Table(X_AD_Package_Imp_Detail entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Table_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTable> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TableDataLoader.AD_Table_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Table_ID());
	}

	public Boolean Uninstall(X_AD_Package_Imp_Detail entity, DataFetchingEnvironment environment) {
		return entity.isUninstall();
	}

}
