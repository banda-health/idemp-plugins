package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PaymentTerm_TrlDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MPaymentTerm;
import org.compiere.model.PO;
import org.compiere.util.Env;
import org.compiere.util.Language;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_PaymentTerm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_PaymentTermResolver extends POResolver<MPaymentTerm> implements GraphQLResolver<MPaymentTerm> {


	public Boolean AfterDelivery(MPaymentTerm entity, DataFetchingEnvironment environment) {
		return entity.isAfterDelivery();
	}

	/**
	 * Get Description.
	 *
	 * @return Optional short description of the record
	 */
	public CompletableFuture<String> Description(MPaymentTerm entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getDescription);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_PaymentTerm_TrlDataLoader.DATALOADER_C_PaymentTerm_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(MPaymentTerm.COLUMNNAME_Description));
	}

	/**
	 * Get Document Note.
	 *
	 * @return Additional information for a Document
	 */
	public CompletableFuture<String> DocumentNote(MPaymentTerm entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getDocumentNote);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_PaymentTerm_TrlDataLoader.DATALOADER_C_PaymentTerm_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(MPaymentTerm.COLUMNNAME_DocumentNote));
	}

	public Boolean IsDefault(MPaymentTerm entity, DataFetchingEnvironment environment) {
		return entity.isDefault();
	}

	public Boolean IsDueFixed(MPaymentTerm entity, DataFetchingEnvironment environment) {
		return entity.isDueFixed();
	}

	public Boolean IsNextBusinessDay(MPaymentTerm entity, DataFetchingEnvironment environment) {
		return entity.isNextBusinessDay();
	}

	public Boolean IsValid(MPaymentTerm entity, DataFetchingEnvironment environment) {
		return entity.isValid();
	}

	/**
	 * Get Name.
	 *
	 * @return Alphanumeric identifier of the entity
	 */
	public CompletableFuture<String> Name(MPaymentTerm entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getName);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_PaymentTerm_TrlDataLoader.DATALOADER_C_PaymentTerm_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(MPaymentTerm.COLUMNNAME_Name));
	}

	static Map<String, String> NETDAY_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("7", "ad54c61a-75e4-4257-9c70-4e6b1b772686");
			put("1", "a225bd22-7f57-493e-aee5-d0cf71891cd0");
			put("2", "6c7920e4-dc0e-436f-b220-0729aad44bf2");
			put("3", "f0e5917d-cfa7-460c-a0b1-b9610e9506f1");
			put("4", "7862d4ca-778b-4425-974e-6002d925e8d5");
			put("5", "e2bdb391-5b9a-41f9-a3b0-8309e47b299a");
			put("6", "13efb0f3-7cc6-4339-85e5-bcaadf0ca31c");
		}
	};
	public CompletableFuture<MRefList_BH> NetDay(MPaymentTerm entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getNetDay())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(NETDAY_UUIDS_BY_VALUE.get(entity.getNetDay()));
	}

	static Map<String, String> PAYMENTTERMUSAGE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("B", "e53178f3-c4d9-4506-8057-0e78e4307496");
			put("S", "30236d5e-9737-4bae-a6df-d7066fce1293");
			put("P", "9ac2a127-4566-42bc-8e58-3ec461b76822");
		}
	};
	public CompletableFuture<MRefList_BH> PaymentTermUsage(MPaymentTerm entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getPaymentTermUsage())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(PAYMENTTERMUSAGE_UUIDS_BY_VALUE.get(entity.getPaymentTermUsage()));
	}

	public Boolean Processing(MPaymentTerm entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
