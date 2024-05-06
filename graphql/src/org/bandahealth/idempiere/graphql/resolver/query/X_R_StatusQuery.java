package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MStatus;

/**
 * Generated Query Resolver for R_Status - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_R_StatusQuery extends POQuery<MStatus> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MStatus.Table_Name;
	}

	public Connection<MStatus> R_StatusGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
