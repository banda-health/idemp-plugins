package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_PayrollConceptDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;
import org.eevolution.model.X_HR_PayrollConcept;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for HR_PayrollConcept - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_HR_PayrollConceptQuery extends POQuery<X_HR_PayrollConcept> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_HR_PayrollConcept.Table_Name;
	}

	public CompletableFuture<X_HR_PayrollConcept> HR_PayrollConcept(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_HR_PayrollConcept> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_HR_PayrollConceptDataLoader.DATALOADER_HR_PayrollConcept_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_HR_PayrollConcept> HR_PayrollConceptGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
