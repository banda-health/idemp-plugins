package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTableScriptValidator;

/**
 * Generated Query Resolver for AD_Table_ScriptValidator - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_Table_ScriptValidatorQuery extends POQuery<MTableScriptValidator> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTableScriptValidator.Table_Name;
	}

	public Connection<MTableScriptValidator> AD_Table_ScriptValidatorGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
