package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_LabelPrinter;

/**
 * Generated Query Resolver for AD_LabelPrinter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_LabelPrinterQuery extends POQuery<X_AD_LabelPrinter> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_LabelPrinter.Table_Name;
	}

	public Connection<X_AD_LabelPrinter> AD_LabelPrinterGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
