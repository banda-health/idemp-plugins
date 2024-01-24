package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFldVal;
import org.bandahealth.idempiere.graphql.model.Connection;

/**
 * Generated Query Resolver for BH_Payer_Info_Fld_Val - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_Payer_Info_Fld_ValQuery extends POQuery<MBHPayerInfoFldVal> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHPayerInfoFldVal.Table_Name;
	}

	public Connection<MBHPayerInfoFldVal> BH_Payer_Info_Fld_ValGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
