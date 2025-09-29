package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_RequisitionDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRequisition;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_Requisition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_RequisitionQuery extends POQuery<MRequisition> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRequisition.Table_Name;
	}

	public CompletableFuture<MRequisition> M_Requisition(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MRequisition> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_RequisitionDataLoader.DATALOADER_M_Requisition_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MRequisition> M_RequisitionGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
