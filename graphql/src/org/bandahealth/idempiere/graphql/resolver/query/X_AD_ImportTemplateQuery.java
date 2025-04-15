package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ImportTemplateDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MImportTemplate;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_ImportTemplate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_ImportTemplateQuery extends POQuery<MImportTemplate> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MImportTemplate.Table_Name;
	}

	public CompletableFuture<MImportTemplate> AD_ImportTemplate(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MImportTemplate> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_ImportTemplateDataLoader.DATALOADER_AD_ImportTemplate_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MImportTemplate> AD_ImportTemplateGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
