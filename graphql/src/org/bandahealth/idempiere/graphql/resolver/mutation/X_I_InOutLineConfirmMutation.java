package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_I_InOutLineConfirmInput;
import org.bandahealth.idempiere.graphql.model.input.X_I_InOutLineConfirmInput;
import org.compiere.model.X_I_InOutLineConfirm;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for I_InOutLineConfirm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_I_InOutLineConfirmMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_I_InOutLineConfirmInput.Table_Name;
	}

	public X_I_InOutLineConfirm I_InOutLineConfirmSave(I_I_InOutLineConfirmInput entity, DataFetchingEnvironment environment) {
		return (X_I_InOutLineConfirm) super.save((X_I_InOutLineConfirmInput) entity, environment);
	}

	public List<X_I_InOutLineConfirm> I_InOutLineConfirmSaveMany(List<I_I_InOutLineConfirmInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_I_InOutLineConfirmInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_I_InOutLineConfirm) entity).collect(Collectors.toList());
	}

	public boolean I_InOutLineConfirmDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
