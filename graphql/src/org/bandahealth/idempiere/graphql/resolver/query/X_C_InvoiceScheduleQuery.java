package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MInvoiceSchedule;

/**
 * Generated Query Resolver for C_InvoiceSchedule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_InvoiceScheduleQuery extends POQuery<MInvoiceSchedule> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MInvoiceSchedule.Table_Name;
	}

	public Connection<MInvoiceSchedule> C_InvoiceScheduleGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
