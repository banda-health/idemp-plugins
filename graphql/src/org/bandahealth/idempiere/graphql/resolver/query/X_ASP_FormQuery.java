package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_ASP_Form;

/**
 * Generated Query Resolver for ASP_Form - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_ASP_FormQuery extends POQuery<X_ASP_Form> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_ASP_Form.Table_Name;
	}

	public Connection<X_ASP_Form> ASP_FormGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
