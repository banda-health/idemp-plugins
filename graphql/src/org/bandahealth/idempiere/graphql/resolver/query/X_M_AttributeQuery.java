package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_AttributeDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAttribute;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_Attribute - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_AttributeQuery extends POQuery<MAttribute> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAttribute.Table_Name;
	}

	public CompletableFuture<MAttribute> M_Attribute(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MAttribute> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_AttributeDataLoader.DATALOADER_M_Attribute_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MAttribute> M_AttributeGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
