package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPGroup_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BP_GroupDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_BP_Group - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_BP_GroupQuery extends POQuery<MBPGroup_BH> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBPGroup_BH.Table_Name;
	}

	public CompletableFuture<MBPGroup_BH> C_BP_Group(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBPGroup_BH> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_BP_GroupDataLoader.DATALOADER_C_BP_Group_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBPGroup_BH> C_BP_GroupGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
