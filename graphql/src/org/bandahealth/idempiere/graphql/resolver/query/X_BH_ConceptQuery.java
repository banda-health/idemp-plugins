package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHConcept;
import org.bandahealth.idempiere.graphql.model.Connection;

/**
 * Generated Query Resolver for BH_Concept - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_ConceptQuery extends POQuery<MBHConcept> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHConcept.Table_Name;
	}

	public Connection<MBHConcept> BH_ConceptGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.get(Page, PageSize, Sort, Filter, environment);
	}
}
