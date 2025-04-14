package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserMailDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MUserMail;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_UserMail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_UserMailQuery extends POQuery<MUserMail> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MUserMail.Table_Name;
	}

	public CompletableFuture<MUserMail> AD_UserMail(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MUserMail> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_UserMailDataLoader.DATALOADER_AD_UserMail_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MUserMail> AD_UserMailGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
