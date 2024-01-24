package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MImage;

/**
 * Generated Query Resolver for AD_Image - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ImageQuery extends POQuery<MImage> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MImage.Table_Name;
	}

	public Connection<MImage> AD_ImageGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
