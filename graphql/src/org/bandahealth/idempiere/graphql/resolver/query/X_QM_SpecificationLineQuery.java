package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.eevolution.model.X_QM_SpecificationLine;

/**
 * Generated Query Resolver for QM_SpecificationLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_QM_SpecificationLineQuery extends POQuery<X_QM_SpecificationLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_QM_SpecificationLine.Table_Name;
	}

	public Connection<X_QM_SpecificationLine> QM_SpecificationLineGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
