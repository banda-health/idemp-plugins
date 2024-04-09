package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.eevolution.model.X_HR_Concept_Category;

/**
 * Generated Query Resolver for HR_Concept_Category - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_HR_Concept_CategoryQuery extends POQuery<X_HR_Concept_Category> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_HR_Concept_Category.Table_Name;
	}

	public Connection<X_HR_Concept_Category> HR_Concept_CategoryGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
