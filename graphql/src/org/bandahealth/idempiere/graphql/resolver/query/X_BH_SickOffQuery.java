package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHSickOff;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_SickOffDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_SickOff - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_SickOffQuery extends POQuery<MBHSickOff> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHSickOff.Table_Name;
	}

	public CompletableFuture<MBHSickOff> BH_SickOff(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHSickOff> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_SickOffDataLoader.DATALOADER_BH_SickOff_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHSickOff> BH_SickOffGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
