package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MUserDefInfoRelated;

/**
 * Generated Query Resolver for AD_UserDef_Info_Related - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_UserDef_Info_RelatedQuery extends POQuery<MUserDefInfoRelated> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MUserDefInfoRelated.Table_Name;
	}

	public Connection<MUserDefInfoRelated> AD_UserDef_Info_RelatedGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
