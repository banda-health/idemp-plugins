package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MBPartnerInfo;

/**
 * Generated Query Resolver for RV_BPartner - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_RV_BPartnerQuery extends POQuery<MBPartnerInfo> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBPartnerInfo.Table_Name;
	}

	public Connection<MBPartnerInfo> RV_BPartnerGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
