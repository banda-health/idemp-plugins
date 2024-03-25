package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MFormAccess;

/**
 * Generated Query Resolver for AD_Form_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_Form_AccessQuery extends POQuery<MFormAccess> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MFormAccess.Table_Name;
	}

	public Connection<MFormAccess> AD_Form_AccessGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
