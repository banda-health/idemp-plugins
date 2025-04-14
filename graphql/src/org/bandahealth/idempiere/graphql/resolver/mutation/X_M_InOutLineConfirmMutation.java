package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_InOutLineConfirmInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_InOutLineConfirmInput;
import org.compiere.model.MInOutLineConfirm;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_InOutLineConfirm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_InOutLineConfirmMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_InOutLineConfirmInput.Table_Name;
	}

	public MInOutLineConfirm M_InOutLineConfirmSave(I_M_InOutLineConfirmInput Entity, DataFetchingEnvironment environment) {
		return (MInOutLineConfirm) super.save((X_M_InOutLineConfirmInput) Entity, environment);
	}

	public List<MInOutLineConfirm> M_InOutLineConfirmSaveMany(List<I_M_InOutLineConfirmInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_InOutLineConfirmInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MInOutLineConfirm) entity).collect(Collectors.toList());
	}

	public boolean M_InOutLineConfirmDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
