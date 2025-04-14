package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_AttachmentNoteDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAttachmentNote;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_AttachmentNote - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_AttachmentNoteQuery extends POQuery<MAttachmentNote> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAttachmentNote.Table_Name;
	}

	public CompletableFuture<MAttachmentNote> AD_AttachmentNote(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MAttachmentNote> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_AttachmentNoteDataLoader.DATALOADER_AD_AttachmentNote_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MAttachmentNote> AD_AttachmentNoteGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
