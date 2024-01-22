package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDiscountSchemaBreak;

/**
 * Generated Query Resolver for M_DiscountSchemaBreak - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_DiscountSchemaBreakQuery extends POQuery<MDiscountSchemaBreak> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDiscountSchemaBreak.Table_Name;
	}

	public Connection<MDiscountSchemaBreak> M_DiscountSchemaBreakGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
