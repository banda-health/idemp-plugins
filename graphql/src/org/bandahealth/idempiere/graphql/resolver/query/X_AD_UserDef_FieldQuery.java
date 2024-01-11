package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MUserDefField;

/**
 * Generated Query Resolver for AD_UserDef_Field - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_UserDef_FieldQuery extends POQuery<MUserDefField> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MUserDefField.Table_Name;
	}

	public Connection<MUserDefField> AD_UserDef_FieldGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
