package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_RequisitionLineDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRequisitionLine;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_RequisitionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_RequisitionLineQuery extends POQuery<MRequisitionLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRequisitionLine.Table_Name;
	}

	public CompletableFuture<MRequisitionLine> M_RequisitionLine(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MRequisitionLine> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_RequisitionLineDataLoader.DATALOADER_M_RequisitionLine_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MRequisitionLine> M_RequisitionLineGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
