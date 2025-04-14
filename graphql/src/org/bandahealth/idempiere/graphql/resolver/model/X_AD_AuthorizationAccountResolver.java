package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_AuthorizationCredentialDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MAuthorizationAccount;
import org.compiere.model.MAuthorizationCredential;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_AuthorizationAccount - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_AuthorizationAccountResolver extends POResolver<MAuthorizationAccount> implements GraphQLResolver<MAuthorizationAccount> {



	/**
	 * Get Authorization Credential.
	 *
	 * @return Authorization Credential
	 */
	public CompletableFuture<MAuthorizationCredential> AD_AuthorizationCredential(MAuthorizationAccount entity, DataFetchingEnvironment environment) {
		if (entity.getAD_AuthorizationCredential_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MAuthorizationCredential> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_AuthorizationCredentialDataLoader.DATALOADER_AD_AuthorizationCredential_BY_ID);
		return dataLoader.load(entity.getAD_AuthorizationCredential_ID());
	}

	public static Map<String, String> AD_AUTHORIZATIONSCOPES_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Calendar", "2d70e5ab-b291-44dc-b610-e4de4170e635"); // Calendar
			put("EMail", "d104581f-ad0b-41f2-9922-174d8e27487a"); // EMail
			put("Document", "b2c69b9e-c59d-4bec-8b2d-d871047a0904"); // Document
			put("Profile", "2961bff8-d875-4b01-84f2-1f311b41a15f"); // Profile
			put("Storage", "df766e64-dad7-4970-a026-fa759e4de151"); // Storage
		}
	};
	public CompletableFuture<MRefList_BH> AD_AuthorizationScopes(MAuthorizationAccount entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getAD_AuthorizationScopes())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(AD_AUTHORIZATIONSCOPES_UUIDS_BY_VALUE.get(entity.getAD_AuthorizationScopes()));
	}


	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(MAuthorizationAccount entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getAD_User_ID());
	}

	public Boolean IsAccessRevoked(MAuthorizationAccount entity, DataFetchingEnvironment environment) {
		return entity.isAccessRevoked();
	}

	public Boolean IsAuthorized(MAuthorizationAccount entity, DataFetchingEnvironment environment) {
		return entity.isAuthorized();
	}

}
