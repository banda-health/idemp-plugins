package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_AuthorizationAccountDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_RoleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_SchedulerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.compiere.model.MAuthorizationAccount;
import org.compiere.model.MScheduler;
import org.compiere.model.MSchedulerRecipient;
import org.compiere.model.X_AD_Role;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_SchedulerRecipient - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_SchedulerRecipientResolver extends POResolver<MSchedulerRecipient> implements GraphQLResolver<MSchedulerRecipient> {



	/**
	 * Get Authorization Account.
	 *
	 * @return Authorization Account
	 */
	public CompletableFuture<MAuthorizationAccount> AD_AuthorizationAccount(MSchedulerRecipient entity, DataFetchingEnvironment environment) {
		if (entity.getAD_AuthorizationAccount_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MAuthorizationAccount> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_AuthorizationAccountDataLoader.DATALOADER_AD_AuthorizationAccount_BY_ID);
		return dataLoader.load(entity.getAD_AuthorizationAccount_ID());
	}


	/**
	 * Get Role.
	 *
	 * @return Responsibility Role
	 */
	public CompletableFuture<X_AD_Role> AD_Role(MSchedulerRecipient entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Role_ID() < 0) {
			return null;
		}
		DataLoader<Integer, X_AD_Role> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_RoleDataLoader.DATALOADER_AD_Role_BY_ID);
		return dataLoader.load(entity.getAD_Role_ID());
	}


	/**
	 * Get Scheduler.
	 *
	 * @return Schedule Processes
	 */
	public CompletableFuture<MScheduler> AD_Scheduler(MSchedulerRecipient entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Scheduler_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MScheduler> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_SchedulerDataLoader.DATALOADER_AD_Scheduler_BY_ID);
		return dataLoader.load(entity.getAD_Scheduler_ID());
	}


	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(MSchedulerRecipient entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getAD_User_ID());
	}

	public Boolean IsUpload(MSchedulerRecipient entity, DataFetchingEnvironment environment) {
		return entity.isUpload();
	}

}
