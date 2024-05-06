package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_IMP_ProcessorParameter;

/**
 * Generated Query Resolver for IMP_ProcessorParameter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_IMP_ProcessorParameterQuery extends POQuery<X_IMP_ProcessorParameter> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_IMP_ProcessorParameter.Table_Name;
	}

	public Connection<X_IMP_ProcessorParameter> IMP_ProcessorParameterGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
