package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_PrintTableFormatInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_PrintTableFormatInput;
import org.compiere.model.X_AD_PrintTableFormat;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_PrintTableFormat - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_PrintTableFormatMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_PrintTableFormatInput.Table_Name;
	}

	public X_AD_PrintTableFormat AD_PrintTableFormatSave(I_AD_PrintTableFormatInput entity, DataFetchingEnvironment environment) {
		return (X_AD_PrintTableFormat) super.save((X_AD_PrintTableFormatInput) entity, environment);
	}

	public List<X_AD_PrintTableFormat> AD_PrintTableFormatSaveMany(List<I_AD_PrintTableFormatInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_PrintTableFormatInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_PrintTableFormat) entity).collect(Collectors.toList());
	}

	public boolean AD_PrintTableFormatDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
