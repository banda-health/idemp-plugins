package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_RelationType;

/**
 * Generated Query Resolver for AD_RelationType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_RelationTypeQuery extends POQuery<X_AD_RelationType> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_RelationType.Table_Name;
	}

	public Connection<X_AD_RelationType> AD_RelationTypeGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
