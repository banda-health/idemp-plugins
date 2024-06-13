package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BP_RelationDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_BP_Relation;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_BP_Relation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_BP_RelationQuery extends POQuery<X_C_BP_Relation> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_BP_Relation.Table_Name;
	}

	public CompletableFuture<X_C_BP_Relation> C_BP_Relation(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_C_BP_Relation> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_BP_RelationDataLoader.DATALOADER_C_BP_Relation_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_C_BP_Relation> C_BP_RelationGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
