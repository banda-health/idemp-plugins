package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MInvoicePaySchedule;

/**
 * Generated Query Resolver for C_InvoicePaySchedule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_InvoicePayScheduleQuery extends POQuery<MInvoicePaySchedule> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MInvoicePaySchedule.Table_Name;
	}

	public Connection<MInvoicePaySchedule> C_InvoicePayScheduleGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
