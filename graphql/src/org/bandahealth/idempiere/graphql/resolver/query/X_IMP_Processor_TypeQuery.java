package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_IMP_Processor_Type;

/**
 * Generated Query Resolver for IMP_Processor_Type - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_IMP_Processor_TypeQuery extends POQuery<X_IMP_Processor_Type> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_IMP_Processor_Type.Table_Name;
	}

	public Connection<X_IMP_Processor_Type> IMP_Processor_TypeGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
