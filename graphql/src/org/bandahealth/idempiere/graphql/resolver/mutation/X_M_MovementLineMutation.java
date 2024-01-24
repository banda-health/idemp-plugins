package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MMovementLine_BH;
import org.bandahealth.idempiere.graphql.model.input.I_M_MovementLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_MovementLineInput;

import java.util.List;

/**
 * Generated Query Resolver for M_MovementLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_MovementLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_MovementLineInput.Table_Name;
	}

	public MMovementLine_BH M_MovementLineSave(I_M_MovementLineInput input, DataFetchingEnvironment environment) {
		return (MMovementLine_BH) super.save((X_M_MovementLineInput) input, environment);
	}

	public boolean M_MovementLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
