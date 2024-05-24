package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_AuthorizationProviderDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MAuthorizationCredential;
import org.compiere.model.MAuthorizationProvider;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_AuthorizationCredential - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_AuthorizationCredentialResolver extends POResolver<MAuthorizationCredential> implements GraphQLResolver<MAuthorizationCredential> {



	/**
	 * Get Authorization Provider.
	 *
	 * @return Authorization Provider
	 */
	public CompletableFuture<MAuthorizationProvider> AD_AuthorizationProvider(MAuthorizationCredential entity, DataFetchingEnvironment environment) {
		if (entity.getAD_AuthorizationProvider_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MAuthorizationProvider> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_AuthorizationProviderDataLoader.DATALOADER_AD_AuthorizationProvider_BY_ID);
		return dataLoader.load(entity.getAD_AuthorizationProvider_ID());
	}

	public static Map<String, String> AD_AUTHORIZATIONSCOPELIST_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Calendar", "2d70e5ab-b291-44dc-b610-e4de4170e635"); // Calendar
			put("EMail", "d104581f-ad0b-41f2-9922-174d8e27487a"); // EMail
			put("Document", "b2c69b9e-c59d-4bec-8b2d-d871047a0904"); // Document
			put("Profile", "2961bff8-d875-4b01-84f2-1f311b41a15f"); // Profile
			put("Storage", "df766e64-dad7-4970-a026-fa759e4de151"); // Storage
		}
	};
	public CompletableFuture<MRefList_BH> AD_AuthorizationScopeList(MAuthorizationCredential entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getAD_AuthorizationScopeList())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(AD_AUTHORIZATIONSCOPELIST_UUIDS_BY_VALUE.get(entity.getAD_AuthorizationScopeList()));
	}

}
