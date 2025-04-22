package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_T_AgingInput;
import org.bandahealth.idempiere.graphql.model.input.X_T_AgingInput;
import org.compiere.model.MAging;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for T_Aging - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_T_AgingMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_T_AgingInput.Table_Name;
	}

	public MAging T_AgingSave(I_T_AgingInput Entity, DataFetchingEnvironment environment) {
		return (MAging) super.save((X_T_AgingInput) Entity, environment);
	}

	public List<MAging> T_AgingSaveMany(List<I_T_AgingInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_T_AgingInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MAging) entity).collect(Collectors.toList());
	}

	public boolean T_AgingDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
