package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_RoleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_DashboardContentDataLoader;
import org.compiere.model.MDashboardContent;
import org.compiere.model.MDashboardPreference;
import org.compiere.model.X_AD_Role;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for PA_DashboardPreference - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_DashboardPreferenceResolver extends POResolver<MDashboardPreference> implements GraphQLResolver<MDashboardPreference> {



	/**
	 * Get Role.
	 *
	 * @return Responsibility Role
	 */
	public CompletableFuture<X_AD_Role> AD_Role(MDashboardPreference entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Role_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_Role> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_RoleDataLoader.AD_Role_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Role_ID());
	}


	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(MDashboardPreference entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.AD_User_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_User_ID());
	}

	public Boolean IsCollapsedByDefault(MDashboardPreference entity, DataFetchingEnvironment environment) {
		return entity.isCollapsedByDefault();
	}

	public Boolean IsShowInDashboard(MDashboardPreference entity, DataFetchingEnvironment environment) {
		return entity.isShowInDashboard();
	}


	/**
	 * Get Dashboard Content.
	 *
	 * @return Dashboard Content
	 */
	public CompletableFuture<MDashboardContent> PA_DashboardContent(MDashboardPreference entity, DataFetchingEnvironment environment) {
		if (entity.getPA_DashboardContent_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MDashboardContent> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PA_DashboardContentDataLoader.PA_DashboardContent_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getPA_DashboardContent_ID());
	}

}
