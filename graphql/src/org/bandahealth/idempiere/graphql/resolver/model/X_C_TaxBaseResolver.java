package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.dataloader.DataLoader;
import org.eevolution.model.X_C_TaxBase;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_TaxBase - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_TaxBaseResolver extends POResolver<X_C_TaxBase> implements GraphQLResolver<X_C_TaxBase> {


	static Map<String, String> BASE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("C", "43591f8f-4a8b-40c3-9418-165c0f8ae93b");
			put("P", "44c04e7c-02e7-4bc0-b2ef-29d579e041c2");
			put("Q", "f3a61fa4-4e81-4c25-9a18-5c505b1a1f3f");
			put("W", "960bcc55-b06f-423f-b401-2dd150d98703");
		}
	};
	public CompletableFuture<MRefList_BH> Base(X_C_TaxBase entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBase())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(BASE_UUIDS_BY_VALUE.get(entity.getBase()));
	}

}
