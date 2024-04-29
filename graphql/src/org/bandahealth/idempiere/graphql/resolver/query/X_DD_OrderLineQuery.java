package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.eevolution.model.MDDOrderLine;

/**
 * Generated Query Resolver for DD_OrderLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_DD_OrderLineQuery extends POQuery<MDDOrderLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDDOrderLine.Table_Name;
	}

	public Connection<MDDOrderLine> DD_OrderLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
