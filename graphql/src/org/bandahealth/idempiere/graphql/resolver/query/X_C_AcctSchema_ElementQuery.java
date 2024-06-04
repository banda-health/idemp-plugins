package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AcctSchema_ElementDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAcctSchemaElement;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_AcctSchema_Element - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_AcctSchema_ElementQuery extends POQuery<MAcctSchemaElement> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAcctSchemaElement.Table_Name;
	}

	public CompletableFuture<MAcctSchemaElement> C_AcctSchema_Element(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MAcctSchemaElement> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_AcctSchema_ElementDataLoader.DATALOADER_C_AcctSchema_Element_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MAcctSchemaElement> C_AcctSchema_ElementGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
