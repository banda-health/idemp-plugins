package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Table_ScriptValidatorDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTableScriptValidator;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Table_ScriptValidator - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_Table_ScriptValidatorQuery extends POQuery<MTableScriptValidator> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTableScriptValidator.Table_Name;
	}

	public CompletableFuture<MTableScriptValidator> AD_Table_ScriptValidator(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MTableScriptValidator> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Table_ScriptValidatorDataLoader.DATALOADER_AD_Table_ScriptValidator_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MTableScriptValidator> AD_Table_ScriptValidatorGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
