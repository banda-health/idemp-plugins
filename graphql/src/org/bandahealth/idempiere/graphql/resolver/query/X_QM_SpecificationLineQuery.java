package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_QM_SpecificationLineDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;
import org.eevolution.model.X_QM_SpecificationLine;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for QM_SpecificationLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_QM_SpecificationLineQuery extends POQuery<X_QM_SpecificationLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_QM_SpecificationLine.Table_Name;
	}

	public CompletableFuture<X_QM_SpecificationLine> QM_SpecificationLine(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_QM_SpecificationLine> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_QM_SpecificationLineDataLoader.DATALOADER_QM_SpecificationLine_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_QM_SpecificationLine> QM_SpecificationLineGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
