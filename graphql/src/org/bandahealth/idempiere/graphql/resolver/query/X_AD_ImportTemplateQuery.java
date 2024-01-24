package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MImportTemplate;

/**
 * Generated Query Resolver for AD_ImportTemplate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_ImportTemplateQuery extends POQuery<MImportTemplate> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MImportTemplate.Table_Name;
	}

	public Connection<MImportTemplate> AD_ImportTemplateGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
