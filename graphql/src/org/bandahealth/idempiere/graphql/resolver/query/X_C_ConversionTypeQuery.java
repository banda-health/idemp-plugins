package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MConversionType;

/**
 * Generated Query Resolver for C_ConversionType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ConversionTypeQuery extends POQuery<MConversionType> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MConversionType.Table_Name;
	}

	public Connection<MConversionType> C_ConversionTypeGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
