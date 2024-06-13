package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WF_ActivityDataLoader;
import org.compiere.model.MWFActivityApprover;
import org.compiere.model.X_AD_WF_Activity;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_WF_ActivityApprover - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_WF_ActivityApproverResolver extends POResolver<MWFActivityApprover> implements GraphQLResolver<MWFActivityApprover> {



	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(MWFActivityApprover entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getAD_User_ID());
	}


	/**
	 * Get Workflow Activity.
	 *
	 * @return Workflow Activity
	 */
	public CompletableFuture<X_AD_WF_Activity> AD_WF_Activity(MWFActivityApprover entity, DataFetchingEnvironment environment) {
		if (entity.getAD_WF_Activity_ID() < 0) {
			return null;
		}
		DataLoader<Integer, X_AD_WF_Activity> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WF_ActivityDataLoader.DATALOADER_AD_WF_Activity_BY_ID);
		return dataLoader.load(entity.getAD_WF_Activity_ID());
	}

}
