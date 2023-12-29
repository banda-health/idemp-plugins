package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_AssetDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MAsset;
import org.compiere.model.MRefList;
import org.compiere.model.X_A_Asset_Info_Tax;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for A_Asset_Info_Tax - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_Info_TaxResolver extends POResolver<X_A_Asset_Info_Tax> implements GraphQLResolver<X_A_Asset_Info_Tax> {



	/**
	 * Get Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	public CompletableFuture<MAsset> A_Asset(X_A_Asset_Info_Tax entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAsset> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_AssetDataLoader.A_Asset_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getA_Asset_ID());
	}

	static Map<String, String> A_FINANCE_METH_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(X_A_Asset_Info_Tax.A_FINANCE_METH_CapitalizedLease, "5ee7a631-64da-4d26-a809-aff598643ec1");
			put(X_A_Asset_Info_Tax.A_FINANCE_METH_Non_CapitalizedLease, "411c5e65-0846-4984-ab10-009190a4c61d");
			put(X_A_Asset_Info_Tax.A_FINANCE_METH_Owned, "588fd084-de7d-46fc-819d-e7a2ce3ac705");
			put(X_A_Asset_Info_Tax.A_FINANCE_METH_Rented, "d7cbc9fa-35e6-4e71-9c8e-69f2777e33d4");
		}
	};
	public CompletableFuture<MRefList> A_Finance_Meth_RL(X_A_Asset_Info_Tax entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getA_Finance_Meth())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(A_FINANCE_METH_UUIDS_BY_VALUE.get(entity.getA_Finance_Meth()));
	}

}
