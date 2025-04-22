package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_RV_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MBPartnerInfo;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for RV_BPartner - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_RV_BPartnerQuery extends POQuery<MBPartnerInfo> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBPartnerInfo.Table_Name;
	}

	public CompletableFuture<MBPartnerInfo> RV_BPartner(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBPartnerInfo> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_RV_BPartnerDataLoader.DATALOADER_RV_BPartner_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBPartnerInfo> RV_BPartnerGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
