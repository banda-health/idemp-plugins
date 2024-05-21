package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MAuthorizationProvider;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_AuthorizationProvider - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_AuthorizationProviderResolver extends POResolver<MAuthorizationProvider> implements GraphQLResolver<MAuthorizationProvider> {


	static Map<String, String> AD_AUTHORIZATIONTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("OAuth2", "ee3a6b03-f7fc-4bc1-8022-43ee69d35164");
			put("SAML", "33116e52-3591-4455-a4b5-581602cd06cb");
		}
	};
	public CompletableFuture<MRefList_BH> AD_AuthorizationType(MAuthorizationProvider entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getAD_AuthorizationType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(AD_AUTHORIZATIONTYPE_UUIDS_BY_VALUE.get(entity.getAD_AuthorizationType()));
	}

}
