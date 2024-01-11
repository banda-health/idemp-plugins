package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_CategoryDataLoader;
import org.compiere.model.MRequestCategory;
import org.compiere.model.X_R_CategoryUpdates;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for R_CategoryUpdates - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_CategoryUpdatesResolver extends POResolver<X_R_CategoryUpdates> implements GraphQLResolver<X_R_CategoryUpdates> {



	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(X_R_CategoryUpdates entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.AD_User_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_User_ID());
	}

	public Boolean IsSelfService(X_R_CategoryUpdates entity, DataFetchingEnvironment environment) {
		return entity.isSelfService();
	}


	/**
	 * Get Category.
	 *
	 * @return Request Category
	 */
	public CompletableFuture<MRequestCategory> R_Category(X_R_CategoryUpdates entity, DataFetchingEnvironment environment) {
		if (entity.getR_Category_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MRequestCategory> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_R_CategoryDataLoader.R_Category_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getR_Category_ID());
	}

}
