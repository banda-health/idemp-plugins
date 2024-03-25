package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_RMATaxInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_RMATaxInput;
import org.compiere.model.MRMATax;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_RMATax - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_RMATaxMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_RMATaxInput.Table_Name;
	}

	public MRMATax M_RMATaxSave(I_M_RMATaxInput entity, DataFetchingEnvironment environment) {
		return (MRMATax) super.save((X_M_RMATaxInput) entity, environment);
	}

	public List<MRMATax> M_RMATaxSaveMany(List<I_M_RMATaxInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_M_RMATaxInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MRMATax) entity).collect(Collectors.toList());
	}

	public boolean M_RMATaxDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
