package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.eevolution.model.X_HR_Job;

/**
 * Generated Query Resolver for HR_Job - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_HR_JobQuery extends POQuery<X_HR_Job> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_HR_Job.Table_Name;
	}

	public Connection<X_HR_Job> HR_JobGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
