package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.eevolution.model.X_PP_WF_Node_Asset;

/**
 * Generated Query Resolver for PP_WF_Node_Asset - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_PP_WF_Node_AssetQuery extends POQuery<X_PP_WF_Node_Asset> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_PP_WF_Node_Asset.Table_Name;
	}

	public Connection<X_PP_WF_Node_Asset> PP_WF_Node_AssetGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
