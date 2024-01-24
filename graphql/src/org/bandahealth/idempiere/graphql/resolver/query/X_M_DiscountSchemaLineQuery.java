package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MDiscountSchemaLine_BH;
import org.bandahealth.idempiere.graphql.model.Connection;

/**
 * Generated Query Resolver for M_DiscountSchemaLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_DiscountSchemaLineQuery extends POQuery<MDiscountSchemaLine_BH> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDiscountSchemaLine_BH.Table_Name;
	}

	public Connection<MDiscountSchemaLine_BH> M_DiscountSchemaLineGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
