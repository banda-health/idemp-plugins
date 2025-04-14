package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MFieldGroup_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_FieldGroupDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_FieldGroup - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_FieldGroupQuery extends POQuery<MFieldGroup_BH> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MFieldGroup_BH.Table_Name;
	}

	public CompletableFuture<MFieldGroup_BH> AD_FieldGroup(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MFieldGroup_BH> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_FieldGroupDataLoader.DATALOADER_AD_FieldGroup_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MFieldGroup_BH> AD_FieldGroupGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
