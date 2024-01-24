package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MMessage_BH;
import org.bandahealth.idempiere.base.model.MTable_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_BroadcastMessageDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_MessageDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TableDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WF_ActivityDataLoader;
import org.compiere.model.MNote;
import org.compiere.model.X_AD_BroadcastMessage;
import org.compiere.model.X_AD_WF_Activity;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Note - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_NoteResolver extends POResolver<MNote> implements GraphQLResolver<MNote> {



	/**
	 * Get Broadcast Message.
	 *
	 * @return Broadcast Message
	 */
	public CompletableFuture<X_AD_BroadcastMessage> AD_BroadcastMessage(MNote entity, DataFetchingEnvironment environment) {
		if (entity.getAD_BroadcastMessage_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_BroadcastMessage> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_BroadcastMessageDataLoader.DATALOADER_AD_BroadcastMessage_BY_ID);
		return dataLoader.load(entity.getAD_BroadcastMessage_ID());
	}


	/**
	 * Get Message.
	 *
	 * @return System Message
	 */
	public CompletableFuture<MMessage_BH> AD_Message(MNote entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Message_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MMessage_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_MessageDataLoader.DATALOADER_AD_Message_BY_ID);
		return dataLoader.load(entity.getAD_Message_ID());
	}


	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	public CompletableFuture<MTable_BH> AD_Table(MNote entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Table_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTable_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TableDataLoader.DATALOADER_AD_Table_BY_ID);
		return dataLoader.load(entity.getAD_Table_ID());
	}


	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(MNote entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() <= 0) {
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
	public CompletableFuture<X_AD_WF_Activity> AD_WF_Activity(MNote entity, DataFetchingEnvironment environment) {
		if (entity.getAD_WF_Activity_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_WF_Activity> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WF_ActivityDataLoader.DATALOADER_AD_WF_Activity_BY_ID);
		return dataLoader.load(entity.getAD_WF_Activity_ID());
	}

	public Boolean Processed(MNote entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(MNote entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
