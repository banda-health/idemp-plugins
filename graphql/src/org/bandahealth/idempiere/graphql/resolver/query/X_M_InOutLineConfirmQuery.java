package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MInOutLineConfirm;

/**
 * Generated Query Resolver for M_InOutLineConfirm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_InOutLineConfirmQuery extends POQuery<MInOutLineConfirm> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MInOutLineConfirm.Table_Name;
	}

	public Connection<MInOutLineConfirm> M_InOutLineConfirmGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
