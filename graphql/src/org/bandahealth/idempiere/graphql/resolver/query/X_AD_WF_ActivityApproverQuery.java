package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MWFActivityApprover;

/**
 * Generated Query Resolver for AD_WF_ActivityApprover - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_WF_ActivityApproverQuery extends POQuery<MWFActivityApprover> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MWFActivityApprover.Table_Name;
	}

	public Connection<MWFActivityApprover> AD_WF_ActivityApproverGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
