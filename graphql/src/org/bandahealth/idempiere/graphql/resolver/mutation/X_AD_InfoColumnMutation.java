package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_InfoColumnInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_InfoColumnInput;
import org.compiere.model.MInfoColumn;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_InfoColumn - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_InfoColumnMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_InfoColumnInput.Table_Name;
	}

	public MInfoColumn AD_InfoColumnSave(I_AD_InfoColumnInput entity, DataFetchingEnvironment environment) {
		return (MInfoColumn) super.save((X_AD_InfoColumnInput) entity, environment);
	}

	public List<MInfoColumn> AD_InfoColumnSaveMany(List<I_AD_InfoColumnInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_InfoColumnInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MInfoColumn) entity).collect(Collectors.toList());
	}

	public boolean AD_InfoColumnDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
