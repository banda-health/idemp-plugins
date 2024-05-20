package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AcctSchemaDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_GL_BudgetDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MAcctSchema;
import org.compiere.model.X_GL_Budget;
import org.compiere.model.X_GL_BudgetControl;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for GL_BudgetControl - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_GL_BudgetControlResolver extends POResolver<X_GL_BudgetControl> implements GraphQLResolver<X_GL_BudgetControl> {


	static Map<String, String> BUDGETCONTROLSCOPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("P", "5f9dbdd7-0440-43a7-b378-73205f6a617b");
			put("Y", "3e08b16d-04c2-4a76-880d-b560c611c12b");
			put("T", "f673be33-b26a-44e6-b2ea-606d51340d33");
		}
	};
	public CompletableFuture<MRefList_BH> BudgetControlScope(X_GL_BudgetControl entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBudgetControlScope())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(BUDGETCONTROLSCOPE_UUIDS_BY_VALUE.get(entity.getBudgetControlScope()));
	}


	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	public CompletableFuture<MAcctSchema> C_AcctSchema(X_GL_BudgetControl entity, DataFetchingEnvironment environment) {
		if (entity.getC_AcctSchema_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MAcctSchema> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_AcctSchemaDataLoader.DATALOADER_C_AcctSchema_BY_ID);
		return dataLoader.load(entity.getC_AcctSchema_ID());
	}

	static Map<String, String> COMMITMENTTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("C", "1be67031-d46a-4519-8888-d9c63e01d3dd");
			put("B", "eee976d9-bd85-477f-be29-c6a84875af91");
			put("N", "0d79afb6-a0b9-4a89-8802-da1d6966944d");
			put("A", "6a24d75b-d67a-419e-afbe-ff685ad306ec");
			put("S", "14f78d5d-456b-4f9f-844b-85fe3506b60a");
			put("O", "fcc2f5f5-6882-440b-8ce8-46050cf2e9d3");
		}
	};
	public CompletableFuture<MRefList_BH> CommitmentType(X_GL_BudgetControl entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getCommitmentType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(COMMITMENTTYPE_UUIDS_BY_VALUE.get(entity.getCommitmentType()));
	}


	/**
	 * Get Budget.
	 *
	 * @return General Ledger Budget
	 */
	public CompletableFuture<X_GL_Budget> GL_Budget(X_GL_BudgetControl entity, DataFetchingEnvironment environment) {
		if (entity.getGL_Budget_ID() < 0) {
			return null;
		}
		DataLoader<Integer, X_GL_Budget> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_GL_BudgetDataLoader.DATALOADER_GL_Budget_BY_ID);
		return dataLoader.load(entity.getGL_Budget_ID());
	}

	public Boolean IsBeforeApproval(X_GL_BudgetControl entity, DataFetchingEnvironment environment) {
		return entity.isBeforeApproval();
	}

}
