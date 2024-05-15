package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRMATax;

/**
 * Generated Query Resolver for M_RMATax - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_RMATaxQuery extends POQuery<MRMATax> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRMATax.Table_Name;
	}

	public Connection<MRMATax> M_RMATaxGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
