package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_WF_EventAudit;

/**
 * Generated Query Resolver for AD_WF_EventAudit - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_WF_EventAuditQuery extends POQuery<X_AD_WF_EventAudit> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_WF_EventAudit.Table_Name;
	}

	public Connection<X_AD_WF_EventAudit> AD_WF_EventAuditGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
