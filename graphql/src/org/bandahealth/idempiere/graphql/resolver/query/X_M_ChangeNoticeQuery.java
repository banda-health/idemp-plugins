package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MChangeNotice;

/**
 * Generated Query Resolver for M_ChangeNotice - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_ChangeNoticeQuery extends POQuery<MChangeNotice> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MChangeNotice.Table_Name;
	}

	public Connection<MChangeNotice> M_ChangeNoticeGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
