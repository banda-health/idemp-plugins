package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WizardProcessDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_WizardProcess;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_WizardProcess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_WizardProcessQuery extends POQuery<X_AD_WizardProcess> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_WizardProcess.Table_Name;
	}

	public CompletableFuture<X_AD_WizardProcess> AD_WizardProcess(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_AD_WizardProcess> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_WizardProcessDataLoader.DATALOADER_AD_WizardProcess_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_AD_WizardProcess> AD_WizardProcessGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
