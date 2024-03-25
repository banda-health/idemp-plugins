package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_U_POSTerminalInput;
import org.bandahealth.idempiere.graphql.model.input.X_U_POSTerminalInput;
import org.compiere.model.MPOSTerminal;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for U_POSTerminal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_U_POSTerminalMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_U_POSTerminalInput.Table_Name;
	}

	public MPOSTerminal U_POSTerminalSave(I_U_POSTerminalInput entity, DataFetchingEnvironment environment) {
		return (MPOSTerminal) super.save((X_U_POSTerminalInput) entity, environment);
	}

	public List<MPOSTerminal> U_POSTerminalSaveMany(List<I_U_POSTerminalInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_U_POSTerminalInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MPOSTerminal) entity).collect(Collectors.toList());
	}

	public boolean U_POSTerminalDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
