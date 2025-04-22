package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MMenu_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_MenuDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Menu - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_MenuQuery extends POQuery<MMenu_BH> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MMenu_BH.Table_Name;
	}

	public CompletableFuture<MMenu_BH> AD_Menu(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MMenu_BH> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_MenuDataLoader.DATALOADER_AD_Menu_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MMenu_BH> AD_MenuGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
