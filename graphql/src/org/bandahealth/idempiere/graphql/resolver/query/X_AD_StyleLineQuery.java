package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MStyleLine;

/**
 * Generated Query Resolver for AD_StyleLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_StyleLineQuery extends POQuery<MStyleLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MStyleLine.Table_Name;
	}

	public Connection<MStyleLine> AD_StyleLineGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
