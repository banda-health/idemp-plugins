package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDiscountSchema;

/**
 * Generated Query Resolver for M_DiscountSchema - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_DiscountSchemaQuery extends POQuery<MDiscountSchema> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDiscountSchema.Table_Name;
	}

	public Connection<MDiscountSchema> M_DiscountSchemaGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
