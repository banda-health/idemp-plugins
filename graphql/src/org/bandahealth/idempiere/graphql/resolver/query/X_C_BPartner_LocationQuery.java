package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartner_LocationDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MBPartnerLocation;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_BPartner_Location - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_BPartner_LocationQuery extends POQuery<MBPartnerLocation> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBPartnerLocation.Table_Name;
	}

	public CompletableFuture<MBPartnerLocation> C_BPartner_Location(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBPartnerLocation> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_BPartner_LocationDataLoader.DATALOADER_C_BPartner_Location_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBPartnerLocation> C_BPartner_LocationGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
