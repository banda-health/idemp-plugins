package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_GroupDataLoader;
import org.compiere.model.MGroup;
import org.compiere.model.X_R_GroupUpdates;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for R_GroupUpdates - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_R_GroupUpdatesResolver extends POResolver<X_R_GroupUpdates> implements GraphQLResolver<X_R_GroupUpdates> {



	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(X_R_GroupUpdates entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getAD_User_ID());
	}

	public Boolean IsSelfService(X_R_GroupUpdates entity, DataFetchingEnvironment environment) {
		return entity.isSelfService();
	}


	/**
	 * Get Group.
	 *
	 * @return Request Group
	 */
	public CompletableFuture<MGroup> R_Group(X_R_GroupUpdates entity, DataFetchingEnvironment environment) {
		if (entity.getR_Group_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MGroup> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_R_GroupDataLoader.DATALOADER_R_Group_BY_ID);
		return dataLoader.load(entity.getR_Group_ID());
	}

}
