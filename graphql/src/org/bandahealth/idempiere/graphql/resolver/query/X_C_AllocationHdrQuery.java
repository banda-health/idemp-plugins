package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AllocationHdrDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAllocationHdr;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_AllocationHdr - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_AllocationHdrQuery extends POQuery<MAllocationHdr> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAllocationHdr.Table_Name;
	}

	public CompletableFuture<MAllocationHdr> C_AllocationHdr(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MAllocationHdr> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_AllocationHdrDataLoader.DATALOADER_C_AllocationHdr_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MAllocationHdr> C_AllocationHdrGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
