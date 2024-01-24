package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.X_GL_Budget;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for GL_Budget - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_GL_BudgetResolver extends POResolver<X_GL_Budget> implements GraphQLResolver<X_GL_Budget> {


	static Map<String, String> BUDGETSTATUS_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("D", "4c031892-77e7-4aaa-b9ab-b94b711cd744");
			put("A", "64d20b2c-6615-4ea0-a1d4-b518a7199159");
		}
	};
	public CompletableFuture<MRefList_BH> BudgetStatus(X_GL_Budget entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getBudgetStatus())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(BUDGETSTATUS_UUIDS_BY_VALUE.get(entity.getBudgetStatus()));
	}

	public Boolean IsPrimary(X_GL_Budget entity, DataFetchingEnvironment environment) {
		return entity.isPrimary();
	}

}
