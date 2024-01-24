package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_InOutConfirmInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_InOutConfirmInput;
import org.compiere.model.MInOutConfirm;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_InOutConfirm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_InOutConfirmMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_InOutConfirmInput.Table_Name;
	}

	public MInOutConfirm M_InOutConfirmSave(I_M_InOutConfirmInput entity, DataFetchingEnvironment environment) {
		return (MInOutConfirm) super.save((X_M_InOutConfirmInput) entity, environment);
	}

	public List<MInOutConfirm> M_InOutConfirmSaveMany(List<I_M_InOutConfirmInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_M_InOutConfirmInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MInOutConfirm) entity).collect(Collectors.toList());
	}

	public boolean M_InOutConfirmDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
