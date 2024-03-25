package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAlertRecipient;

/**
 * Generated Query Resolver for AD_AlertRecipient - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_AlertRecipientQuery extends POQuery<MAlertRecipient> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAlertRecipient.Table_Name;
	}

	public Connection<MAlertRecipient> AD_AlertRecipientGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
