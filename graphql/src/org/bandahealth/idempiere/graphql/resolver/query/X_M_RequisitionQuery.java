package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRequisition;

/**
 * Generated Query Resolver for M_Requisition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_RequisitionQuery extends POQuery<MRequisition> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRequisition.Table_Name;
	}

	public Connection<MRequisition> M_RequisitionGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
