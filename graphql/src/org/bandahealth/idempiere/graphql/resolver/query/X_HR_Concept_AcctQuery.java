package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.eevolution.model.X_HR_Concept_Acct;

/**
 * Generated Query Resolver for HR_Concept_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_HR_Concept_AcctQuery extends POQuery<X_HR_Concept_Acct> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_HR_Concept_Acct.Table_Name;
	}

	public Connection<X_HR_Concept_Acct> HR_Concept_AcctGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
