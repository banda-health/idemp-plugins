package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_IndexColumnInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_IndexColumnInput;
import org.compiere.model.MIndexColumn;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_IndexColumn - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_IndexColumnMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_IndexColumnInput.Table_Name;
	}

	public MIndexColumn AD_IndexColumnSave(I_AD_IndexColumnInput entity, DataFetchingEnvironment environment) {
		return (MIndexColumn) super.save((X_AD_IndexColumnInput) entity, environment);
	}

	public List<MIndexColumn> AD_IndexColumnSaveMany(List<I_AD_IndexColumnInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_IndexColumnInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MIndexColumn) entity).collect(Collectors.toList());
	}

	public boolean AD_IndexColumnDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
