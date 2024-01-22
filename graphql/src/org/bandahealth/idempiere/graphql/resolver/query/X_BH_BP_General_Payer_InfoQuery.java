package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHBPGeneralPayerInfo;
import org.bandahealth.idempiere.graphql.model.Connection;

/**
 * Generated Query Resolver for BH_BP_General_Payer_Info - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_BH_BP_General_Payer_InfoQuery extends POQuery<MBHBPGeneralPayerInfo> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHBPGeneralPayerInfo.Table_Name;
	}

	public Connection<MBHBPGeneralPayerInfo> BH_BP_General_Payer_InfoGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
