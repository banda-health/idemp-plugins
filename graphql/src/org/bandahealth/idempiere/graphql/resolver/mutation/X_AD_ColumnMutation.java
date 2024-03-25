package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_ColumnInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_ColumnInput;
import org.compiere.model.MColumn;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Column - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_ColumnMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_ColumnInput.Table_Name;
	}

	public MColumn AD_ColumnSave(I_AD_ColumnInput entity, DataFetchingEnvironment environment) {
		return (MColumn) super.save((X_AD_ColumnInput) entity, environment);
	}

	public List<MColumn> AD_ColumnSaveMany(List<I_AD_ColumnInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_ColumnInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MColumn) entity).collect(Collectors.toList());
	}

	public boolean AD_ColumnDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
