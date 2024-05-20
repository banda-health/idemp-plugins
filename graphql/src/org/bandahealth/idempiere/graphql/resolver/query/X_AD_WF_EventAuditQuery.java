package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WF_EventAuditDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_WF_EventAudit;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_WF_EventAudit - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_WF_EventAuditQuery extends POQuery<X_AD_WF_EventAudit> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_WF_EventAudit.Table_Name;
	}

	public CompletableFuture<X_AD_WF_EventAudit> AD_WF_EventAudit(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_AD_WF_EventAudit> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_WF_EventAuditDataLoader.DATALOADER_AD_WF_EventAudit_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_AD_WF_EventAudit> AD_WF_EventAuditGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
