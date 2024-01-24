package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_ImpFormat_RowInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_ImpFormat_RowInput;
import org.compiere.model.X_AD_ImpFormat_Row;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_ImpFormat_Row - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_ImpFormat_RowMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_ImpFormat_RowInput.Table_Name;
	}

	public X_AD_ImpFormat_Row AD_ImpFormat_RowSave(I_AD_ImpFormat_RowInput entity, DataFetchingEnvironment environment) {
		return (X_AD_ImpFormat_Row) super.save((X_AD_ImpFormat_RowInput) entity, environment);
	}

	public List<X_AD_ImpFormat_Row> AD_ImpFormat_RowSaveMany(List<I_AD_ImpFormat_RowInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_ImpFormat_RowInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_ImpFormat_Row) entity).collect(Collectors.toList());
	}

	public boolean AD_ImpFormat_RowDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
