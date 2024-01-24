package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_U_POSTerminalInput;
import org.bandahealth.idempiere.graphql.model.input.X_U_POSTerminalInput;
import org.compiere.model.MPOSTerminal;

import java.util.List;

/**
 * Generated Query Resolver for U_POSTerminal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_U_POSTerminalMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_U_POSTerminalInput.Table_Name;
	}

	public MPOSTerminal U_POSTerminalSave(I_U_POSTerminalInput input, DataFetchingEnvironment environment) {
		return (MPOSTerminal) super.save((X_U_POSTerminalInput) input, environment);
	}

	public boolean U_POSTerminalDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
