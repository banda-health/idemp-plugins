package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_Concept_AcctDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;
import org.eevolution.model.X_HR_Concept_Acct;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for HR_Concept_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_HR_Concept_AcctQuery extends POQuery<X_HR_Concept_Acct> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_HR_Concept_Acct.Table_Name;
	}

	public CompletableFuture<X_HR_Concept_Acct> HR_Concept_Acct(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_HR_Concept_Acct> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_HR_Concept_AcctDataLoader.DATALOADER_HR_Concept_Acct_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_HR_Concept_Acct> HR_Concept_AcctGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
