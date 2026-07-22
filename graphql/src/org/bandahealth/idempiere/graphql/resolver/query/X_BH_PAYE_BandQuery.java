package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPAYEBand;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_PAYE_BandDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_PAYE_Band - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_PAYE_BandQuery extends POQuery<MBHPAYEBand> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHPAYEBand.Table_Name;
	}

	public CompletableFuture<MBHPAYEBand> BH_PAYE_Band(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHPAYEBand> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_PAYE_BandDataLoader.DATALOADER_BH_PAYE_Band_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHPAYEBand> BH_PAYE_BandGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
