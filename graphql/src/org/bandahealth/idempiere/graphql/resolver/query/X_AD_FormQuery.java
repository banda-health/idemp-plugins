package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_FormDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MForm;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Form - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_FormQuery extends POQuery<MForm> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MForm.Table_Name;
	}

	public CompletableFuture<MForm> AD_Form(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MForm> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_FormDataLoader.DATALOADER_AD_Form_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MForm> AD_FormGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
