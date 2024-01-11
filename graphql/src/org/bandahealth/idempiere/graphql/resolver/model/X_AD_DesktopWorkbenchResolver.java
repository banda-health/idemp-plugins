package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_DesktopDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WorkbenchDataLoader;
import org.compiere.model.X_AD_Desktop;
import org.compiere.model.X_AD_DesktopWorkbench;
import org.compiere.model.X_AD_Workbench;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_DesktopWorkbench - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_DesktopWorkbenchResolver extends POResolver<X_AD_DesktopWorkbench> implements GraphQLResolver<X_AD_DesktopWorkbench> {



	/**
	 * Get Desktop.
	 *
	 * @return Collection of Workbenches
	 */
	public CompletableFuture<X_AD_Desktop> AD_Desktop(X_AD_DesktopWorkbench entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Desktop_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_Desktop> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_DesktopDataLoader.AD_Desktop_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Desktop_ID());
	}


	/**
	 * Get Workbench.
	 *
	 * @return Collection of windows, reports
	 */
	public CompletableFuture<X_AD_Workbench> AD_Workbench(X_AD_DesktopWorkbench entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Workbench_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_Workbench> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WorkbenchDataLoader.AD_Workbench_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Workbench_ID());
	}

}
