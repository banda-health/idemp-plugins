package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.eevolution.model.X_QM_Specification;

/**
 * Generated Query Resolver for QM_Specification - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_QM_SpecificationQuery extends POQuery<X_QM_Specification> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_QM_Specification.Table_Name;
	}

	public Connection<X_QM_Specification> QM_SpecificationGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
