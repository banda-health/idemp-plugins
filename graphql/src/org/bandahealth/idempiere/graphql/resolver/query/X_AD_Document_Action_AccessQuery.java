package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_Document_Action_Access;

/**
 * Generated Query Resolver for AD_Document_Action_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Document_Action_AccessQuery extends POQuery<X_AD_Document_Action_Access> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_Document_Action_Access.Table_Name;
	}

	public Connection<X_AD_Document_Action_Access> AD_Document_Action_AccessGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
