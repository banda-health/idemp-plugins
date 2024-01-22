package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_MovementLineMAInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_MovementLineMAInput;
import org.compiere.model.MMovementLineMA;

import java.util.List;

/**
 * Generated Query Resolver for M_MovementLineMA - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_MovementLineMAMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_MovementLineMAInput.Table_Name;
	}

	public MMovementLineMA M_MovementLineMASave(I_M_MovementLineMAInput input, DataFetchingEnvironment environment) {
		return (MMovementLineMA) super.save((X_M_MovementLineMAInput) input, environment);
	}

	public boolean M_MovementLineMADelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
