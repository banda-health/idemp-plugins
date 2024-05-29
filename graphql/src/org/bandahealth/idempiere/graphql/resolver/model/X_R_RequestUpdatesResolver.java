package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_RequestDataLoader;
import org.compiere.model.MRequest;
import org.compiere.model.X_R_RequestUpdates;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for R_RequestUpdates - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_R_RequestUpdatesResolver extends POResolver<X_R_RequestUpdates> implements GraphQLResolver<X_R_RequestUpdates> {



	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(X_R_RequestUpdates entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getAD_User_ID());
	}

	public Boolean IsSelfService(X_R_RequestUpdates entity, DataFetchingEnvironment environment) {
		return entity.isSelfService();
	}


	/**
	 * Get Request.
	 *
	 * @return Request from a Business Partner or Prospect
	 */
	public CompletableFuture<MRequest> R_Request(X_R_RequestUpdates entity, DataFetchingEnvironment environment) {
		if (entity.getR_Request_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MRequest> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_R_RequestDataLoader.DATALOADER_R_Request_BY_ID);
		return dataLoader.load(entity.getR_Request_ID());
	}

}
