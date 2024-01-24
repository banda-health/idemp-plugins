package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_RMAInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_RMAInput;
import org.compiere.model.MRMA;

import java.util.List;

/**
 * Generated Query Resolver for M_RMA - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_RMAMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_RMAInput.Table_Name;
	}

	public MRMA M_RMASave(I_M_RMAInput input, DataFetchingEnvironment environment) {
		return (MRMA) super.save((X_M_RMAInput) input, environment);
	}

	public boolean M_RMADelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
