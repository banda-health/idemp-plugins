package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_Package_Imp_Inst;

/**
 * Generated Query Resolver for AD_Package_Imp_Inst - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_Package_Imp_InstQuery extends POQuery<X_AD_Package_Imp_Inst> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_Package_Imp_Inst.Table_Name;
	}

	public Connection<X_AD_Package_Imp_Inst> AD_Package_Imp_InstGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
