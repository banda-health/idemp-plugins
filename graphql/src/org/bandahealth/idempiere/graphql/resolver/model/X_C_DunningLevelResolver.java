package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintFormatDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_DunningDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_DunningLevel_TrlDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PaymentTermDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MDunning;
import org.compiere.model.MDunningLevel;
import org.compiere.model.MPaymentTerm;
import org.compiere.model.PO;
import org.compiere.model.X_AD_PrintFormat;
import org.compiere.util.Env;
import org.compiere.util.Language;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_DunningLevel - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_DunningLevelResolver extends POResolver<MDunningLevel> implements GraphQLResolver<MDunningLevel> {



	/**
	 * Get Dunning.
	 *
	 * @return Dunning Rules for overdue invoices
	 */
	public CompletableFuture<MDunning> C_Dunning(MDunningLevel entity, DataFetchingEnvironment environment) {
		if (entity.getC_Dunning_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MDunning> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_DunningDataLoader.DATALOADER_C_Dunning_BY_ID);
		return dataLoader.load(entity.getC_Dunning_ID());
	}


	/**
	 * Get Payment Term.
	 *
	 * @return The terms of Payment (timing, discount)
	 */
	public CompletableFuture<MPaymentTerm> C_PaymentTerm(MDunningLevel entity, DataFetchingEnvironment environment) {
		if (entity.getC_PaymentTerm_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPaymentTerm> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_PaymentTermDataLoader.DATALOADER_C_PaymentTerm_BY_ID);
		return dataLoader.load(entity.getC_PaymentTerm_ID());
	}

	public Boolean ChargeFee(MDunningLevel entity, DataFetchingEnvironment environment) {
		return entity.isChargeFee();
	}

	public Boolean ChargeInterest(MDunningLevel entity, DataFetchingEnvironment environment) {
		return entity.isChargeInterest();
	}


	/**
	 * Get Dunning Print Format.
	 *
	 * @return Print Format for printing Dunning Letters
	 */
	public CompletableFuture<X_AD_PrintFormat> Dunning_PrintFormat(MDunningLevel entity, DataFetchingEnvironment environment) {
		if (entity.getDunning_PrintFormat_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintFormat> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintFormatDataLoader.DATALOADER_AD_PrintFormat_BY_ID);
		return dataLoader.load(entity.getDunning_PrintFormat_ID());
	}

	static Map<String, String> INVOICECOLLECTIONTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("D", "451767f3-eea6-4809-9d1f-bccd5831913c");
			put("C", "d5422428-9e78-45ec-b83d-30e52302aac9");
			put("L", "18587352-5a00-4c61-9b78-91424935e13d");
			put("U", "60a1b77c-d200-4adc-b845-7ec3760ce5b7");
		}
	};
	public CompletableFuture<MRefList_BH> InvoiceCollectionType(MDunningLevel entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getInvoiceCollectionType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(INVOICECOLLECTIONTYPE_UUIDS_BY_VALUE.get(entity.getInvoiceCollectionType()));
	}

	public Boolean IsSetCreditStop(MDunningLevel entity, DataFetchingEnvironment environment) {
		return entity.isSetCreditStop();
	}

	public Boolean IsSetPaymentTerm(MDunningLevel entity, DataFetchingEnvironment environment) {
		return entity.isSetPaymentTerm();
	}

	public Boolean IsShowAllDue(MDunningLevel entity, DataFetchingEnvironment environment) {
		return entity.isShowAllDue();
	}

	public Boolean IsShowNotDue(MDunningLevel entity, DataFetchingEnvironment environment) {
		return entity.isShowNotDue();
	}

	public Boolean IsStatement(MDunningLevel entity, DataFetchingEnvironment environment) {
		return entity.isStatement();
	}

	/**
	 * Get Note.
	 *
	 * @return Optional additional user defined information
	 */
	public CompletableFuture<String> Note(MDunningLevel entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getNote);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_DunningLevel_TrlDataLoader.DATALOADER_C_DunningLevel_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(MDunningLevel.COLUMNNAME_Note));
	}

	/**
	 * Get Print Text.
	 *
	 * @return The label text to be printed on a document or correspondence.
	 */
	public CompletableFuture<String> PrintName(MDunningLevel entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getPrintName);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_DunningLevel_TrlDataLoader.DATALOADER_C_DunningLevel_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(MDunningLevel.COLUMNNAME_PrintName));
	}

}
