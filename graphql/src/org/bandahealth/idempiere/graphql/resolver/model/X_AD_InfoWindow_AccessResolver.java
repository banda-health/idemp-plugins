package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_InfoWindowDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_RoleDataLoader;
import org.compiere.model.MInfoWindow;
import org.compiere.model.MInfoWindowAccess;
import org.compiere.model.X_AD_Role;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_InfoWindow_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_InfoWindow_AccessResolver extends POResolver<MInfoWindowAccess> implements GraphQLResolver<MInfoWindowAccess> {



	/**
	 * Get Info Window.
	 *
	 * @return Info and search/select Window
	 */
	public CompletableFuture<MInfoWindow> AD_InfoWindow(MInfoWindowAccess entity, DataFetchingEnvironment environment) {
		if (entity.getAD_InfoWindow_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInfoWindow> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_InfoWindowDataLoader.DATALOADER_AD_InfoWindow_BY_ID);
		return dataLoader.load(entity.getAD_InfoWindow_ID());
	}


	/**
	 * Get Role.
	 *
	 * @return Responsibility Role
	 */
	public CompletableFuture<X_AD_Role> AD_Role(MInfoWindowAccess entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Role_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_Role> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_RoleDataLoader.DATALOADER_AD_Role_BY_ID);
		return dataLoader.load(entity.getAD_Role_ID());
	}

}
