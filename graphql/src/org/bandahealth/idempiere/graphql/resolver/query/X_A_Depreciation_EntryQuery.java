package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDepreciationEntry;

/**
 * Generated Query Resolver for A_Depreciation_Entry - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Depreciation_EntryQuery extends POQuery<MDepreciationEntry> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDepreciationEntry.Table_Name;
	}

	public Connection<MDepreciationEntry> A_Depreciation_EntryGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
