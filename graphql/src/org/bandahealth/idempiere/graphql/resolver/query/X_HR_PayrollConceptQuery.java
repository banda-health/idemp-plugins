package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.eevolution.model.X_HR_PayrollConcept;

/**
 * Generated Query Resolver for HR_PayrollConcept - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_HR_PayrollConceptQuery extends POQuery<X_HR_PayrollConcept> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_HR_PayrollConcept.Table_Name;
	}

	public Connection<X_HR_PayrollConcept> HR_PayrollConceptGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
