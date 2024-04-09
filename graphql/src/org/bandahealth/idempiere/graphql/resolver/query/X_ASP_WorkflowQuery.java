package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_ASP_Workflow;

/**
 * Generated Query Resolver for ASP_Workflow - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_ASP_WorkflowQuery extends POQuery<X_ASP_Workflow> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_ASP_Workflow.Table_Name;
	}

	public Connection<X_ASP_Workflow> ASP_WorkflowGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
