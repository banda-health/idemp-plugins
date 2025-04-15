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
 * @version Release 12 - $Id$
 */
public class X_AD_ViewColumnMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_ViewColumnInput.Table_Name;
	}

	public MViewColumn AD_ViewColumnSave(I_AD_ViewColumnInput Entity, DataFetchingEnvironment environment) {
		return (MViewColumn) super.save((X_AD_ViewColumnInput) Entity, environment);
	}

	public List<MViewColumn> AD_ViewColumnSaveMany(List<I_AD_ViewColumnInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_ViewColumnInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MViewColumn) entity).collect(Collectors.toList());
	}

	public boolean AD_ViewColumnDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
