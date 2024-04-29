package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDocumentStatus;

/**
 * Generated Query Resolver for PA_DocumentStatus - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_DocumentStatusQuery extends POQuery<MDocumentStatus> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDocumentStatus.Table_Name;
	}

	public Connection<MDocumentStatus> PA_DocumentStatusGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
