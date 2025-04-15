package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WF_ActivityApproverDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MWFActivityApprover;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_WF_ActivityApprover - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_WF_ActivityApproverQuery extends POQuery<MWFActivityApprover> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MWFActivityApprover.Table_Name;
	}

	public CompletableFuture<MWFActivityApprover> AD_WF_ActivityApprover(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MWFActivityApprover> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_WF_ActivityApproverDataLoader.DATALOADER_AD_WF_ActivityApprover_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MWFActivityApprover> AD_WF_ActivityApproverGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
