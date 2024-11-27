package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ColumnDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ElementDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ElementValueDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MColumn;
import org.compiere.model.MElement;
import org.compiere.model.MElementValue;
import org.compiere.model.X_I_ElementValue;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for I_ElementValue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_I_ElementValueResolver extends POResolver<X_I_ElementValue> implements GraphQLResolver<X_I_ElementValue> {


	public static Map<String, String> ACCOUNTSIGN_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("N", "546f7a30-b932-4a00-81c1-6f7cb6fdcbb6"); // Natural
			put("D", "f494267a-f7e6-49a7-913e-c51e3e093623"); // Debit
			put("C", "8c58849d-0535-4df8-85a1-508818db6386"); // Credit
		}
	};
	public CompletableFuture<MRefList_BH> AccountSign(X_I_ElementValue entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getAccountSign())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ACCOUNTSIGN_UUIDS_BY_VALUE.get(entity.getAccountSign()));
	}

	public static Map<String, String> ACCOUNTTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "76e172f2-9bbe-4e84-967b-c9734a5e539b"); // Asset
			put("L", "2d05ac35-1b03-4768-9146-ff188980453d"); // Liability
			put("R", "ffc1c6a1-0a0d-49a5-8097-7739253e4cdf"); // Revenue
			put("E", "25ad94f8-6eaf-4a4a-9944-e671de2e86a3"); // Expense
			put("O", "a2107a18-879b-4947-a45b-9e86ced65526"); // Owner's Equity
			put("M", "ddabbd2e-569b-4396-953d-9994050abc23"); // Memo
		}
	};
	public CompletableFuture<MRefList_BH> AccountType(X_I_ElementValue entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getAccountType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ACCOUNTTYPE_UUIDS_BY_VALUE.get(entity.getAccountType()));
	}


	/**
	 * Get Column.
	 *
	 * @return Column in the table
	 */
	public CompletableFuture<MColumn> AD_Column(X_I_ElementValue entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Column_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MColumn> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ColumnDataLoader.DATALOADER_AD_Column_BY_ID);
		return dataLoader.load(entity.getAD_Column_ID());
	}


	/**
	 * Get Element.
	 *
	 * @return Accounting Element
	 */
	public CompletableFuture<MElement> C_Element(X_I_ElementValue entity, DataFetchingEnvironment environment) {
		if (entity.getC_Element_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MElement> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ElementDataLoader.DATALOADER_C_Element_BY_ID);
		return dataLoader.load(entity.getC_Element_ID());
	}


	/**
	 * Get Account Element.
	 *
	 * @return Account Element
	 */
	public CompletableFuture<MElementValue> C_ElementValue(X_I_ElementValue entity, DataFetchingEnvironment environment) {
		if (entity.getC_ElementValue_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MElementValue> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ElementValueDataLoader.DATALOADER_C_ElementValue_BY_ID);
		return dataLoader.load(entity.getC_ElementValue_ID());
	}

	public Boolean I_IsImported(X_I_ElementValue entity, DataFetchingEnvironment environment) {
		return entity.isI_IsImported();
	}

	public Boolean IsDocControlled(X_I_ElementValue entity, DataFetchingEnvironment environment) {
		return entity.isDocControlled();
	}

	public Boolean IsSummary(X_I_ElementValue entity, DataFetchingEnvironment environment) {
		return entity.isSummary();
	}


	/**
	 * Get Parent Account.
	 *
	 * @return The parent (summary) account
	 */
	public CompletableFuture<MElementValue> ParentElementValue(X_I_ElementValue entity, DataFetchingEnvironment environment) {
		if (entity.getParentElementValue_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MElementValue> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ElementValueDataLoader.DATALOADER_C_ElementValue_BY_ID);
		return dataLoader.load(entity.getParentElementValue_ID());
	}

	public Boolean PostActual(X_I_ElementValue entity, DataFetchingEnvironment environment) {
		return entity.isPostActual();
	}

	public Boolean PostBudget(X_I_ElementValue entity, DataFetchingEnvironment environment) {
		return entity.isPostBudget();
	}

	public Boolean PostEncumbrance(X_I_ElementValue entity, DataFetchingEnvironment environment) {
		return entity.isPostEncumbrance();
	}

	public Boolean PostStatistical(X_I_ElementValue entity, DataFetchingEnvironment environment) {
		return entity.isPostStatistical();
	}

	public Boolean Processed(X_I_ElementValue entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(X_I_ElementValue entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
