package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.eevolution.model.X_HR_ListLine;

/**
 * Generated Query Resolver for HR_ListLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_HR_ListLineQuery extends POQuery<X_HR_ListLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_HR_ListLine.Table_Name;
	}

	public Connection<X_HR_ListLine> HR_ListLineGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
