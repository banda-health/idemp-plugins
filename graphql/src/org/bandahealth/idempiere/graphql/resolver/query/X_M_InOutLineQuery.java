package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_InOutLineDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MInOutLine;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_InOutLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_InOutLineQuery extends POQuery<MInOutLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MInOutLine.Table_Name;
	}

	public CompletableFuture<MInOutLine> M_InOutLine(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MInOutLine> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_InOutLineDataLoader.DATALOADER_M_InOutLine_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MInOutLine> M_InOutLineGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
