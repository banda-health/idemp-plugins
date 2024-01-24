package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_InOutLineConfirmInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_InOutLineConfirmInput;
import org.compiere.model.MInOutLineConfirm;

import java.util.List;

/**
 * Generated Query Resolver for M_InOutLineConfirm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_InOutLineConfirmMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_InOutLineConfirmInput.Table_Name;
	}

	public MInOutLineConfirm M_InOutLineConfirmSave(I_M_InOutLineConfirmInput input, DataFetchingEnvironment environment) {
		return (MInOutLineConfirm) super.save((X_M_InOutLineConfirmInput) input, environment);
	}

	public boolean M_InOutLineConfirmDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
