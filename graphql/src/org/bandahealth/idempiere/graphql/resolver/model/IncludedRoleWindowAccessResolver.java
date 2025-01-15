package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WindowDataLoader;
import org.bandahealth.idempiere.graphql.model.IncludedRoleWindowAccess;
import org.compiere.model.MWindow;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

public class IncludedRoleWindowAccessResolver implements GraphQLResolver<IncludedRoleWindowAccess> {
	/**
	 * Get Window.
	 *
	 * @return Data entry or display window
	 */
	public CompletableFuture<MWindow> AD_Window(IncludedRoleWindowAccess entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Window_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MWindow> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WindowDataLoader.DATALOADER_AD_Window_BY_ID);
		return dataLoader.load(entity.getAD_Window_ID());
	}

	public Boolean BH_CanDeactivate(IncludedRoleWindowAccess entity) {
		return entity.isBH_CanDeactivate();
	}

	public Boolean IsReadWrite(IncludedRoleWindowAccess entity) {
		return entity.isReadWrite();
	}
}
