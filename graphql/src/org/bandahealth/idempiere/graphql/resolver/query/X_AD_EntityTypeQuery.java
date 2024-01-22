package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MEntityType;

/**
 * Generated Query Resolver for AD_EntityType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_EntityTypeQuery extends POQuery<MEntityType> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MEntityType.Table_Name;
	}

	public Connection<MEntityType> AD_EntityTypeGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
