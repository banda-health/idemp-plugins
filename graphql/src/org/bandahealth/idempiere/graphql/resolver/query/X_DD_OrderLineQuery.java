package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.eevolution.model.MDDOrderLine;

/**
 * Generated Query Resolver for DD_OrderLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_DD_OrderLineQuery extends POQuery<MDDOrderLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDDOrderLine.Table_Name;
	}

	public Connection<MDDOrderLine> DD_OrderLineGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
