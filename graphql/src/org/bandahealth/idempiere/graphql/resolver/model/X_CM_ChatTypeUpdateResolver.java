package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_CM_ChatTypeDataLoader;
import org.compiere.model.MChatType;
import org.compiere.model.X_CM_ChatTypeUpdate;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for CM_ChatTypeUpdate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_CM_ChatTypeUpdateResolver extends POResolver<X_CM_ChatTypeUpdate> implements GraphQLResolver<X_CM_ChatTypeUpdate> {



	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(X_CM_ChatTypeUpdate entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getAD_User_ID());
	}


	/**
	 * Get Chat Type.
	 *
	 * @return Type of discussion / chat
	 */
	public CompletableFuture<MChatType> CM_ChatType(X_CM_ChatTypeUpdate entity, DataFetchingEnvironment environment) {
		if (entity.getCM_ChatType_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MChatType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_CM_ChatTypeDataLoader.DATALOADER_CM_ChatType_BY_ID);
		return dataLoader.load(entity.getCM_ChatType_ID());
	}

	public Boolean IsSelfService(X_CM_ChatTypeUpdate entity, DataFetchingEnvironment environment) {
		return entity.isSelfService();
	}

}
