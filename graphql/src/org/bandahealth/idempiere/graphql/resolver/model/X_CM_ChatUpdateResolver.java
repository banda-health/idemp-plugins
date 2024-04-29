package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_CM_ChatDataLoader;
import org.compiere.model.MChat;
import org.compiere.model.X_CM_ChatUpdate;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for CM_ChatUpdate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_CM_ChatUpdateResolver extends POResolver<X_CM_ChatUpdate> implements GraphQLResolver<X_CM_ChatUpdate> {



	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(X_CM_ChatUpdate entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getAD_User_ID());
	}


	/**
	 * Get Chat.
	 *
	 * @return Chat or discussion thread
	 */
	public CompletableFuture<MChat> CM_Chat(X_CM_ChatUpdate entity, DataFetchingEnvironment environment) {
		if (entity.getCM_Chat_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MChat> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_CM_ChatDataLoader.DATALOADER_CM_Chat_BY_ID);
		return dataLoader.load(entity.getCM_Chat_ID());
	}

	public Boolean IsSelfService(X_CM_ChatUpdate entity, DataFetchingEnvironment environment) {
		return entity.isSelfService();
	}

}
