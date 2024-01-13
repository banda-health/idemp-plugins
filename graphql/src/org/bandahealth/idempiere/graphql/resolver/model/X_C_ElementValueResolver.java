package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBankAccount_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BankAccountDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CurrencyDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ElementDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ElementValue_TrlDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MElement;
import org.compiere.model.MElementValue;
import org.compiere.model.PO;
import org.compiere.util.Env;
import org.compiere.util.Language;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_ElementValue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ElementValueResolver extends POResolver<MElementValue> implements GraphQLResolver<MElementValue> {


	static Map<String, String> ACCOUNTSIGN_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("N", "546f7a30-b932-4a00-81c1-6f7cb6fdcbb6");
			put("D", "f494267a-f7e6-49a7-913e-c51e3e093623");
			put("C", "8c58849d-0535-4df8-85a1-508818db6386");
		}
	};
	public CompletableFuture<MRefList_BH> AccountSign(MElementValue entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getAccountSign())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(ACCOUNTSIGN_UUIDS_BY_VALUE.get(entity.getAccountSign()));
	}

	static Map<String, String> ACCOUNTTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "76e172f2-9bbe-4e84-967b-c9734a5e539b");
			put("L", "2d05ac35-1b03-4768-9146-ff188980453d");
			put("R", "ffc1c6a1-0a0d-49a5-8097-7739253e4cdf");
			put("E", "25ad94f8-6eaf-4a4a-9944-e671de2e86a3");
			put("O", "a2107a18-879b-4947-a45b-9e86ced65526");
			put("M", "ddabbd2e-569b-4396-953d-9994050abc23");
		}
	};
	public CompletableFuture<MRefList_BH> AccountType(MElementValue entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getAccountType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(ACCOUNTTYPE_UUIDS_BY_VALUE.get(entity.getAccountType()));
	}

	static Map<String, String> BPARTNERTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("C", "261c79ec-c7fd-458e-8823-cac29cf1ec35");
			put("V", "b0d3a446-cb7d-4b3f-9cd0-37052c4de7f5");
			put("E", "5a2e2ea0-9902-4747-9eed-e6d1832544ba");
		}
	};
	public CompletableFuture<MRefList_BH> BPartnerType(MElementValue entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBPartnerType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(BPARTNERTYPE_UUIDS_BY_VALUE.get(entity.getBPartnerType()));
	}


	/**
	 * Get Bank Account.
	 *
	 * @return Account at the Bank
	 */
	public CompletableFuture<MBankAccount_BH> C_BankAccount(MElementValue entity, DataFetchingEnvironment environment) {
		if (entity.getC_BankAccount_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBankAccount_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BankAccountDataLoader.DATALOADER_C_BankAccount_BY_ID);
		return dataLoader.load(entity.getC_BankAccount_ID());
	}


	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public CompletableFuture<MCurrency_BH> C_Currency(MElementValue entity, DataFetchingEnvironment environment) {
		if (entity.getC_Currency_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCurrency_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.DATALOADER_C_Currency_BY_ID);
		return dataLoader.load(entity.getC_Currency_ID());
	}


	/**
	 * Get Element.
	 *
	 * @return Accounting Element
	 */
	public CompletableFuture<MElement> C_Element(MElementValue entity, DataFetchingEnvironment environment) {
		if (entity.getC_Element_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MElement> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ElementDataLoader.DATALOADER_C_Element_BY_ID);
		return dataLoader.load(entity.getC_Element_ID());
	}

	/**
	 * Get Description.
	 *
	 * @return Optional short description of the record
	 */
	public CompletableFuture<String> Description(MElementValue entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getDescription);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_ElementValue_TrlDataLoader.DATALOADER_C_ElementValue_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(MElementValue.COLUMNNAME_Description));
	}

	public Boolean IsBankAccount(MElementValue entity, DataFetchingEnvironment environment) {
		return entity.isBankAccount();
	}

	public Boolean IsDetailBPartner(MElementValue entity, DataFetchingEnvironment environment) {
		return entity.isDetailBPartner();
	}

	public Boolean IsDetailProduct(MElementValue entity, DataFetchingEnvironment environment) {
		return entity.isDetailProduct();
	}

	public Boolean IsDocControlled(MElementValue entity, DataFetchingEnvironment environment) {
		return entity.isDocControlled();
	}

	public Boolean IsForeignCurrency(MElementValue entity, DataFetchingEnvironment environment) {
		return entity.isForeignCurrency();
	}

	public Boolean IsSummary(MElementValue entity, DataFetchingEnvironment environment) {
		return entity.isSummary();
	}

	/**
	 * Get Name.
	 *
	 * @return Alphanumeric identifier of the entity
	 */
	public CompletableFuture<String> Name(MElementValue entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getName);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_ElementValue_TrlDataLoader.DATALOADER_C_ElementValue_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(MElementValue.COLUMNNAME_Name));
	}

	public Boolean PostActual(MElementValue entity, DataFetchingEnvironment environment) {
		return entity.isPostActual();
	}

	public Boolean PostBudget(MElementValue entity, DataFetchingEnvironment environment) {
		return entity.isPostBudget();
	}

	public Boolean PostEncumbrance(MElementValue entity, DataFetchingEnvironment environment) {
		return entity.isPostEncumbrance();
	}

	public Boolean PostStatistical(MElementValue entity, DataFetchingEnvironment environment) {
		return entity.isPostStatistical();
	}

}
