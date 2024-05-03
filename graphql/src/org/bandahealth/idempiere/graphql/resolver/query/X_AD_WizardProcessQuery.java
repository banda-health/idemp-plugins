package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_WizardProcess;

/**
 * Generated Query Resolver for AD_WizardProcess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_WizardProcessQuery extends POQuery<X_AD_WizardProcess> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_WizardProcess.Table_Name;
	}

	public Connection<X_AD_WizardProcess> AD_WizardProcessGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
