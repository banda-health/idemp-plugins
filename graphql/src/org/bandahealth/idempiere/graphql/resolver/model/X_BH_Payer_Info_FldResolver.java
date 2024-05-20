package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFld;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for BH_Payer_Info_Fld - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_Payer_Info_FldResolver extends POResolver<MBHPayerInfoFld> implements GraphQLResolver<MBHPayerInfoFld> {


	public Boolean BH_FillFromPatient(MBHPayerInfoFld entity, DataFetchingEnvironment environment) {
		return entity.isBH_FillFromPatient();
	}


	/**
	 * Get Payer ID.
	 *
	 * @return Payer ID
	 */
	public CompletableFuture<MBPartner_BH> BH_Payer(MBHPayerInfoFld entity, DataFetchingEnvironment environment) {
		if (entity.getBH_Payer_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getBH_Payer_ID());
	}

	static Map<String, String> BH_PAYERINFOFIELDDATATYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("T", "30c39cd3-e132-4b80-811e-74c5e06f8fae");
			put("L", "5be1018a-8aa1-4f9a-8ec9-a022fa3675b9");
		}
	};
	public CompletableFuture<MRefList_BH> BH_PayerInfoFieldDataType(MBHPayerInfoFld entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBH_PayerInfoFieldDataType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BH_PAYERINFOFIELDDATATYPE_UUIDS_BY_VALUE.get(entity.getBH_PayerInfoFieldDataType()));
	}

}
