package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MUserMail;

/**
 * Generated Query Resolver for AD_UserMail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_UserMailQuery extends POQuery<MUserMail> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MUserMail.Table_Name;
	}

	public Connection<MUserMail> AD_UserMailGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
