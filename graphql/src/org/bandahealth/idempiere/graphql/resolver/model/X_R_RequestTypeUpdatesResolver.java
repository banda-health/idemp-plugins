package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_RequestTypeDataLoader;
import org.compiere.model.MRequestType;
import org.compiere.model.X_R_RequestTypeUpdates;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for R_RequestTypeUpdates - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_R_RequestTypeUpdatesResolver extends POResolver<X_R_RequestTypeUpdates> implements GraphQLResolver<X_R_RequestTypeUpdates> {



	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(X_R_RequestTypeUpdates entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getAD_User_ID());
	}

	public Boolean IsSelfService(X_R_RequestTypeUpdates entity, DataFetchingEnvironment environment) {
		return entity.isSelfService();
	}


	/**
	 * Get Request Type.
	 *
	 * @return Type of request (e.g. Inquiry, Complaint, ..)
	 */
	public CompletableFuture<MRequestType> R_RequestType(X_R_RequestTypeUpdates entity, DataFetchingEnvironment environment) {
		if (entity.getR_RequestType_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MRequestType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_R_RequestTypeDataLoader.DATALOADER_R_RequestType_BY_ID);
		return dataLoader.load(entity.getR_RequestType_ID());
	}

}
