package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_ViewColumnInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_ViewColumnInput;
import org.compiere.model.MViewColumn;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_ViewColumn - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_ViewColumnMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_ViewColumnInput.Table_Name;
	}

	public MViewColumn AD_ViewColumnSave(I_AD_ViewColumnInput entity, DataFetchingEnvironment environment) {
		return (MViewColumn) super.save((X_AD_ViewColumnInput) entity, environment);
	}

	public List<MViewColumn> AD_ViewColumnSaveMany(List<I_AD_ViewColumnInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_ViewColumnInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MViewColumn) entity).collect(Collectors.toList());
	}

	public boolean AD_ViewColumnDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
