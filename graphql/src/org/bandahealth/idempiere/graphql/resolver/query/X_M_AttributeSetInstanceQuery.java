package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_AttributeSetInstanceDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_AttributeSetInstance - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_AttributeSetInstanceQuery extends POQuery<MAttributeSetInstance_BH> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAttributeSetInstance_BH.Table_Name;
	}

	public CompletableFuture<MAttributeSetInstance_BH> M_AttributeSetInstance(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MAttributeSetInstance_BH> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_AttributeSetInstanceDataLoader.DATALOADER_M_AttributeSetInstance_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MAttributeSetInstance_BH> M_AttributeSetInstanceGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
