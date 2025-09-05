package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_BPartner - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_BPartnerQuery extends POQuery<MBPartner_BH> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBPartner_BH.Table_Name;
	}

	public CompletableFuture<MBPartner_BH> C_BPartner(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBPartner_BH> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBPartner_BH> C_BPartnerGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
