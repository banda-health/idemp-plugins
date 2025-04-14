package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ChargeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CurrencyDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MCommission;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_Commission - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_CommissionResolver extends POResolver<MCommission> implements GraphQLResolver<MCommission> {



	/**
	 * Get Business Partner.
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(MCommission entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getC_BPartner_ID());
	}


	/**
	 * Get Charge.
	 *
	 * @return Additional document charges
	 */
	public CompletableFuture<MCharge_BH> C_Charge(MCommission entity, DataFetchingEnvironment environment) {
		if (entity.getC_Charge_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MCharge_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ChargeDataLoader.DATALOADER_C_Charge_BY_ID);
		return dataLoader.load(entity.getC_Charge_ID());
	}


	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public CompletableFuture<MCurrency_BH> C_Currency(MCommission entity, DataFetchingEnvironment environment) {
		if (entity.getC_Currency_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MCurrency_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.DATALOADER_C_Currency_BY_ID);
		return dataLoader.load(entity.getC_Currency_ID());
	}

	public static Map<String, String> DOCBASISTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("O", "a6694e87-d8ec-4b61-a066-3f9cbe5aabf7"); // Order
			put("I", "21d4a6f4-aa51-4391-bc8f-3e2530bfb928"); // Invoice
			put("R", "713af4ae-8428-4807-b8a9-a7593b33944b"); // Receipt
		}
	};
	public CompletableFuture<MRefList_BH> DocBasisType(MCommission entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDocBasisType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(DOCBASISTYPE_UUIDS_BY_VALUE.get(entity.getDocBasisType()));
	}

	public static Map<String, String> FREQUENCYTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("W", "45de694a-befc-4911-bbf3-500a6b9a791b"); // Weekly
			put("M", "96dd7501-7e9a-4bab-903a-613555ec7255"); // Monthly
			put("Q", "0d0890c4-d3f7-4a5d-85a2-d4438e0f52f9"); // Quarterly
			put("Y", "70084efb-5cc5-404c-956e-eab1da9b9191"); // Yearly
		}
	};
	public CompletableFuture<MRefList_BH> FrequencyType(MCommission entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getFrequencyType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(FREQUENCYTYPE_UUIDS_BY_VALUE.get(entity.getFrequencyType()));
	}

	public Boolean ListDetails(MCommission entity, DataFetchingEnvironment environment) {
		return entity.isListDetails();
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(MCommission entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_Product_ID());
	}

	public Boolean Processing(MCommission entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
