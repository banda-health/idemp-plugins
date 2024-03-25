package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAttachmentNote;

/**
 * Generated Query Resolver for AD_AttachmentNote - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_AttachmentNoteQuery extends POQuery<MAttachmentNote> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAttachmentNote.Table_Name;
	}

	public Connection<MAttachmentNote> AD_AttachmentNoteGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
