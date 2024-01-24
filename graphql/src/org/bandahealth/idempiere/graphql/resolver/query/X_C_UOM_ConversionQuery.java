package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MUOMConversion;

/**
 * Generated Query Resolver for C_UOM_Conversion - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_UOM_ConversionQuery extends POQuery<MUOMConversion> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MUOMConversion.Table_Name;
	}

	public Connection<MUOMConversion> C_UOM_ConversionGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
