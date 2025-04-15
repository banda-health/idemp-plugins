package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_AssetDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MAsset;
import org.compiere.model.X_A_Asset_Info_Fin;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for A_Asset_Info_Fin - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_A_Asset_Info_FinResolver extends POResolver<X_A_Asset_Info_Fin> implements GraphQLResolver<X_A_Asset_Info_Fin> {



	/**
	 * Get Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	public CompletableFuture<MAsset> A_Asset(X_A_Asset_Info_Fin entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MAsset> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_AssetDataLoader.DATALOADER_A_Asset_BY_ID);
		return dataLoader.load(entity.getA_Asset_ID());
	}

	public static Map<String, String> A_DUE_ON_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("15T", "2a7fd03c-83ac-412f-84fe-05119af3794d"); // 15th of every month
			put("1st", "e983ee93-7e72-4d22-bc9c-657d61a583f3"); // 1st of every month
			put("BEG", "21d933d8-38d7-4092-83ae-cd40498dc3e6"); // Beginning of every month
			put("YER", "5d2f4dbe-d00b-4d8f-ab12-bbf445e2cc45"); // Yearly on or before contract date
		}
	};
	public CompletableFuture<MRefList_BH> A_Due_On(X_A_Asset_Info_Fin entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getA_Due_On())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(A_DUE_ON_UUIDS_BY_VALUE.get(entity.getA_Due_On()));
	}

	public static Map<String, String> A_FINANCE_METH_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("CL", "5ee7a631-64da-4d26-a809-aff598643ec1"); // Capitalized Lease
			put("NL", "411c5e65-0846-4984-ab10-009190a4c61d"); // Non-Capitalized Lease
			put("OW", "588fd084-de7d-46fc-819d-e7a2ce3ac705"); // Owned
			put("RE", "d7cbc9fa-35e6-4e71-9c8e-69f2777e33d4"); // Rented
		}
	};
	public CompletableFuture<MRefList_BH> A_Finance_Meth(X_A_Asset_Info_Fin entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getA_Finance_Meth())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(A_FINANCE_METH_UUIDS_BY_VALUE.get(entity.getA_Finance_Meth()));
	}

	public Boolean A_Purchase_Option(X_A_Asset_Info_Fin entity, DataFetchingEnvironment environment) {
		return entity.isA_Purchase_Option();
	}


	/**
	 * Get Business Partner.
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(X_A_Asset_Info_Fin entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getC_BPartner_ID());
	}

	public Boolean Processed(X_A_Asset_Info_Fin entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

}
