package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_AttachmentDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAttachment;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Attachment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_AttachmentQuery extends POQuery<MAttachment> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAttachment.Table_Name;
	}

	public CompletableFuture<MAttachment> AD_Attachment(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MAttachment> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_AttachmentDataLoader.DATALOADER_AD_Attachment_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MAttachment> AD_AttachmentGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
