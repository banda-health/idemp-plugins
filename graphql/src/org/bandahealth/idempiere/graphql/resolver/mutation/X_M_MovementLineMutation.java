package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_MovementLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_MovementLineInput;
import org.compiere.model.MMovementLine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_MovementLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_MovementLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_MovementLineInput.Table_Name;
	}

	public MMovementLine M_MovementLineSave(I_M_MovementLineInput Entity, DataFetchingEnvironment environment) {
		return (MMovementLine) super.save((X_M_MovementLineInput) Entity, environment);
	}

	public List<MMovementLine> M_MovementLineSaveMany(List<I_M_MovementLineInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_MovementLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MMovementLine) entity).collect(Collectors.toList());
	}

	public boolean M_MovementLineDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
