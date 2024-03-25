package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MMeasure;

/**
 * Generated Query Resolver for PA_Measure - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_MeasureQuery extends POQuery<MMeasure> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MMeasure.Table_Name;
	}

	public Connection<MMeasure> PA_MeasureGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
