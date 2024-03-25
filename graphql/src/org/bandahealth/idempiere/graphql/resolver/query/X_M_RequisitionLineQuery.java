package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRequisitionLine;

/**
 * Generated Query Resolver for M_RequisitionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_RequisitionLineQuery extends POQuery<MRequisitionLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRequisitionLine.Table_Name;
	}

	public Connection<MRequisitionLine> M_RequisitionLineGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
