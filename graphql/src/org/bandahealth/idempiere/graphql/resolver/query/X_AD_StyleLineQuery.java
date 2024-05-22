package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MStyleLine;

/**
 * Generated Query Resolver for AD_StyleLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_StyleLineQuery extends POQuery<MStyleLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MStyleLine.Table_Name;
	}

	public Connection<MStyleLine> AD_StyleLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
