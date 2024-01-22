package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MGroup;

/**
 * Generated Query Resolver for R_Group - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_R_GroupQuery extends POQuery<MGroup> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MGroup.Table_Name;
	}

	public Connection<MGroup> R_GroupGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
