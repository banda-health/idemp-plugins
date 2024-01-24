package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_ChargeType_DocType;

/**
 * Generated Query Resolver for C_ChargeType_DocType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_ChargeType_DocTypeQuery extends POQuery<X_C_ChargeType_DocType> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_ChargeType_DocType.Table_Name;
	}

	public Connection<X_C_ChargeType_DocType> C_ChargeType_DocTypeGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
