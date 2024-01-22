package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAttachment;

/**
 * Generated Query Resolver for AD_Attachment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_AttachmentQuery extends POQuery<MAttachment> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAttachment.Table_Name;
	}

	public Connection<MAttachment> AD_AttachmentGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
