package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Package_Imp_ProcDataLoader;
import org.compiere.model.X_AD_Package_Imp;
import org.compiere.model.X_AD_Package_Imp_Proc;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Package_Imp - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_Package_ImpResolver extends POResolver<X_AD_Package_Imp> implements GraphQLResolver<X_AD_Package_Imp> {



	/**
	 * Get Package Imp. Proc..
	 *
	 * @return Package Imp. Proc.
	 */
	public CompletableFuture<X_AD_Package_Imp_Proc> AD_Package_Imp_Proc(X_AD_Package_Imp entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Package_Imp_Proc_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_AD_Package_Imp_Proc> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Package_Imp_ProcDataLoader.DATALOADER_AD_Package_Imp_Proc_BY_ID);
		return dataLoader.load(entity.getAD_Package_Imp_Proc_ID());
	}

	public Boolean Processed(X_AD_Package_Imp entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(X_AD_Package_Imp entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

	public Boolean Uninstall(X_AD_Package_Imp entity, DataFetchingEnvironment environment) {
		return entity.isUninstall();
	}

}
