package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_InfoProcessInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_InfoProcessInput;
import org.compiere.model.X_AD_InfoProcess;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_InfoProcess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_InfoProcessMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_InfoProcessInput.Table_Name;
	}

	public X_AD_InfoProcess AD_InfoProcessSave(I_AD_InfoProcessInput entity, DataFetchingEnvironment environment) {
		return (X_AD_InfoProcess) super.save((X_AD_InfoProcessInput) entity, environment);
	}

	public List<X_AD_InfoProcess> AD_InfoProcessSaveMany(List<I_AD_InfoProcessInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_InfoProcessInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_InfoProcess) entity).collect(Collectors.toList());
	}

	public boolean AD_InfoProcessDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
