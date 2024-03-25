package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MStyle;

/**
 * Generated Query Resolver for AD_Style - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_StyleQuery extends POQuery<MStyle> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MStyle.Table_Name;
	}

	public Connection<MStyle> AD_StyleGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
