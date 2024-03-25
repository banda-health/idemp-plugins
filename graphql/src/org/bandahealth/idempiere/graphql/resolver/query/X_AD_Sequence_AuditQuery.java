package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_Sequence_Audit;

/**
 * Generated Query Resolver for AD_Sequence_Audit - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_Sequence_AuditQuery extends POQuery<X_AD_Sequence_Audit> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_Sequence_Audit.Table_Name;
	}

	public Connection<X_AD_Sequence_Audit> AD_Sequence_AuditGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
