package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MStorageReservation;

/**
 * Generated Query Resolver for M_StorageReservation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_StorageReservationQuery extends POQuery<MStorageReservation> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MStorageReservation.Table_Name;
	}

	public Connection<MStorageReservation> M_StorageReservationGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
