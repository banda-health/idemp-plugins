package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MMailText;

/**
 * Generated Query Resolver for R_MailText - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_R_MailTextQuery extends POQuery<MMailText> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MMailText.Table_Name;
	}

	public Connection<MMailText> R_MailTextGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
