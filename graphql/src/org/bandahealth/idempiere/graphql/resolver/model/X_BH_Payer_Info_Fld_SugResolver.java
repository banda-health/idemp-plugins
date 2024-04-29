package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFldSug;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for BH_Payer_Info_Fld_Sug - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_Payer_Info_Fld_SugResolver extends POResolver<MBHPayerInfoFldSug> implements GraphQLResolver<MBHPayerInfoFldSug> {


	public Boolean BH_FillFromPatient(MBHPayerInfoFldSug entity, DataFetchingEnvironment environment) {
		return entity.isBH_FillFromPatient();
	}

	static Map<String, String> BH_PAYERINFOFIELDDATATYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("T", "30c39cd3-e132-4b80-811e-74c5e06f8fae");
			put("L", "5be1018a-8aa1-4f9a-8ec9-a022fa3675b9");
		}
	};
	public CompletableFuture<MRefList_BH> BH_PayerInfoFieldDataType(MBHPayerInfoFldSug entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_PayerInfoFieldDataType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BH_PAYERINFOFIELDDATATYPE_UUIDS_BY_VALUE.get(entity.getBH_PayerInfoFieldDataType()));
	}

	static Map<String, String> BH_SUBTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("I", "d8547f6d-5ad0-4025-b8f8-0f4796cf9d0f");
			put("W", "406d22a4-b3ee-48e4-9bba-7031f653aa06");
			put("D", "4782b135-a84e-4eb9-ae3d-88c872a030ce");
		}
	};
	public CompletableFuture<MRefList_BH> BH_SubType(MBHPayerInfoFldSug entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_SubType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BH_SUBTYPE_UUIDS_BY_VALUE.get(entity.getBH_SubType()));
	}

}
