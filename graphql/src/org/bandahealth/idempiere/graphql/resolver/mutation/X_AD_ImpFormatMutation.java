package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_ImpFormatInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_ImpFormatInput;
import org.compiere.model.X_AD_ImpFormat;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_ImpFormat - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_ImpFormatMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_ImpFormatInput.Table_Name;
	}

	public X_AD_ImpFormat AD_ImpFormatSave(I_AD_ImpFormatInput Entity, DataFetchingEnvironment environment) {
		return (X_AD_ImpFormat) super.save((X_AD_ImpFormatInput) Entity, environment);
	}

	public List<X_AD_ImpFormat> AD_ImpFormatSaveMany(List<I_AD_ImpFormatInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_ImpFormatInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_ImpFormat) entity).collect(Collectors.toList());
	}

	public boolean AD_ImpFormatDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
