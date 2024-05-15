package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_Package_Imp_Proc;

/**
 * Generated Query Resolver for AD_Package_Imp_Proc - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_Package_Imp_ProcQuery extends POQuery<X_AD_Package_Imp_Proc> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_Package_Imp_Proc.Table_Name;
	}

	public Connection<X_AD_Package_Imp_Proc> AD_Package_Imp_ProcGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
