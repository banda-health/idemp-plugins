package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MMailText;

/**
 * Generated Query Resolver for R_MailText - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_R_MailTextQuery extends POQuery<MMailText> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MMailText.Table_Name;
	}

	public Connection<MMailText> R_MailTextGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
