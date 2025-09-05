package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHVoidedReason;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Voided_ReasonDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_Voided_Reason - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Voided_ReasonQuery extends POQuery<MBHVoidedReason> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHVoidedReason.Table_Name;
	}

	public CompletableFuture<MBHVoidedReason> BH_Voided_Reason(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHVoidedReason> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_Voided_ReasonDataLoader.DATALOADER_BH_Voided_Reason_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHVoidedReason> BH_Voided_ReasonGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
