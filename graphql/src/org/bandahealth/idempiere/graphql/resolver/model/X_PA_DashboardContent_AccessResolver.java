package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_RoleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_DashboardContentDataLoader;
import org.compiere.model.MDashboardContent;
import org.compiere.model.MDashboardContentAccess;
import org.compiere.model.X_AD_Role;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for PA_DashboardContent_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_DashboardContent_AccessResolver extends POResolver<MDashboardContentAccess> implements GraphQLResolver<MDashboardContentAccess> {



	/**
	 * Get Role.
	 *
	 * @return Responsibility Role
	 */
	public CompletableFuture<X_AD_Role> AD_Role(MDashboardContentAccess entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Role_ID() < 0) {
			return null;
		}
		DataLoader<Integer, X_AD_Role> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_RoleDataLoader.DATALOADER_AD_Role_BY_ID);
		return dataLoader.load(entity.getAD_Role_ID());
	}


	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(MDashboardContentAccess entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getAD_User_ID());
	}


	/**
	 * Get Dashboard Content.
	 *
	 * @return Dashboard Content
	 */
	public CompletableFuture<MDashboardContent> PA_DashboardContent(MDashboardContentAccess entity, DataFetchingEnvironment environment) {
		if (entity.getPA_DashboardContent_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MDashboardContent> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PA_DashboardContentDataLoader.DATALOADER_PA_DashboardContent_BY_ID);
		return dataLoader.load(entity.getPA_DashboardContent_ID());
	}

}
