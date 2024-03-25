package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MBPartnerLocation;

/**
 * Generated Query Resolver for C_BPartner_Location - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_BPartner_LocationQuery extends POQuery<MBPartnerLocation> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBPartnerLocation.Table_Name;
	}

	public Connection<MBPartnerLocation> C_BPartner_LocationGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
