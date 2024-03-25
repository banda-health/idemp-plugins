package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFldValSug;
import org.bandahealth.idempiere.graphql.model.Connection;

/**
 * Generated Query Resolver for BH_Payer_Info_Fld_Val_Sug - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_Payer_Info_Fld_Val_SugQuery extends POQuery<MBHPayerInfoFldValSug> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHPayerInfoFldValSug.Table_Name;
	}

	public Connection<MBHPayerInfoFldValSug> BH_Payer_Info_Fld_Val_SugGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
