package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRequestAction;

/**
 * Generated Query Resolver for R_RequestAction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_R_RequestActionQuery extends POQuery<MRequestAction> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRequestAction.Table_Name;
	}

	public Connection<MRequestAction> R_RequestActionGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
