package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_AttributeInstanceDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAttributeInstance;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_AttributeInstance - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_AttributeInstanceQuery extends POQuery<MAttributeInstance> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAttributeInstance.Table_Name;
	}

	public CompletableFuture<MAttributeInstance> M_AttributeInstance(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MAttributeInstance> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_AttributeInstanceDataLoader.DATALOADER_M_AttributeInstance_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MAttributeInstance> M_AttributeInstanceGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
