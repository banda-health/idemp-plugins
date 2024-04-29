package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAttributeSetExclude;

/**
 * Generated Query Resolver for M_AttributeSetExclude - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_AttributeSetExcludeQuery extends POQuery<MAttributeSetExclude> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAttributeSetExclude.Table_Name;
	}

	public Connection<MAttributeSetExclude> M_AttributeSetExcludeGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
