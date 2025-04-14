package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Document_Action_AccessDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDocumentActionAccess;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Document_Action_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_Document_Action_AccessQuery extends POQuery<MDocumentActionAccess> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDocumentActionAccess.Table_Name;
	}

	public CompletableFuture<MDocumentActionAccess> AD_Document_Action_Access(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MDocumentActionAccess> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Document_Action_AccessDataLoader.DATALOADER_AD_Document_Action_Access_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MDocumentActionAccess> AD_Document_Action_AccessGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
