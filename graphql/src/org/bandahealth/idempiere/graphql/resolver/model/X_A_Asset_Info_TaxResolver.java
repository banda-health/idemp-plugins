package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_AssetDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MAsset;
import org.compiere.model.X_A_Asset_Info_Tax;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for A_Asset_Info_Tax - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_A_Asset_Info_TaxResolver extends POResolver<X_A_Asset_Info_Tax> implements GraphQLResolver<X_A_Asset_Info_Tax> {



	/**
	 * Get Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	public CompletableFuture<MAsset> A_Asset(X_A_Asset_Info_Tax entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MAsset> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_AssetDataLoader.DATALOADER_A_Asset_BY_ID);
		return dataLoader.load(entity.getA_Asset_ID());
	}

	public static Map<String, String> A_FINANCE_METH_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("CL", "5ee7a631-64da-4d26-a809-aff598643ec1"); // Capitalized Lease
			put("NL", "411c5e65-0846-4984-ab10-009190a4c61d"); // Non-Capitalized Lease
			put("OW", "588fd084-de7d-46fc-819d-e7a2ce3ac705"); // Owned
			put("RE", "d7cbc9fa-35e6-4e71-9c8e-69f2777e33d4"); // Rented
		}
	};
	public CompletableFuture<MRefList_BH> A_Finance_Meth(X_A_Asset_Info_Tax entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getA_Finance_Meth())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(A_FINANCE_METH_UUIDS_BY_VALUE.get(entity.getA_Finance_Meth()));
	}

	public Boolean A_New_Used(X_A_Asset_Info_Tax entity, DataFetchingEnvironment environment) {
		return entity.isA_New_Used();
	}

}
