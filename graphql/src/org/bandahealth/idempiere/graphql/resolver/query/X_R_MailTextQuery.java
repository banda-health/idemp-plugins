package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_MailTextDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MMailText;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for R_MailText - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_R_MailTextQuery extends POQuery<MMailText> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MMailText.Table_Name;
	}

	public CompletableFuture<MMailText> R_MailText(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MMailText> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_R_MailTextDataLoader.DATALOADER_R_MailText_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MMailText> R_MailTextGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
