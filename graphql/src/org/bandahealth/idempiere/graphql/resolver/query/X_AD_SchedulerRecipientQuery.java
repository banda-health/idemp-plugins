package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MSchedulerRecipient;

/**
 * Generated Query Resolver for AD_SchedulerRecipient - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_SchedulerRecipientQuery extends POQuery<MSchedulerRecipient> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MSchedulerRecipient.Table_Name;
	}

	public Connection<MSchedulerRecipient> AD_SchedulerRecipientGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
