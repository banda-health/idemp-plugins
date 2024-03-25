package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_PrintFormatInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_PrintFormatInput;
import org.compiere.model.X_AD_PrintFormat;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_PrintFormat - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_PrintFormatMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_PrintFormatInput.Table_Name;
	}

	public X_AD_PrintFormat AD_PrintFormatSave(I_AD_PrintFormatInput entity, DataFetchingEnvironment environment) {
		return (X_AD_PrintFormat) super.save((X_AD_PrintFormatInput) entity, environment);
	}

	public List<X_AD_PrintFormat> AD_PrintFormatSaveMany(List<I_AD_PrintFormatInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_PrintFormatInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_PrintFormat) entity).collect(Collectors.toList());
	}

	public boolean AD_PrintFormatDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
