package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDef_Info_ColumnDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MUserDefInfoColumn;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_UserDef_Info_Column - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_UserDef_Info_ColumnQuery extends POQuery<MUserDefInfoColumn> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MUserDefInfoColumn.Table_Name;
	}

	public CompletableFuture<MUserDefInfoColumn> AD_UserDef_Info_Column(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MUserDefInfoColumn> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_UserDef_Info_ColumnDataLoader.DATALOADER_AD_UserDef_Info_Column_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MUserDefInfoColumn> AD_UserDef_Info_ColumnGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
