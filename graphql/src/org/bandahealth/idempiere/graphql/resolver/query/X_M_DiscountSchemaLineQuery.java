package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDiscountSchemaLine;

/**
 * Generated Query Resolver for M_DiscountSchemaLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_DiscountSchemaLineQuery extends POQuery<MDiscountSchemaLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDiscountSchemaLine.Table_Name;
	}

	public Connection<MDiscountSchemaLine> M_DiscountSchemaLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
