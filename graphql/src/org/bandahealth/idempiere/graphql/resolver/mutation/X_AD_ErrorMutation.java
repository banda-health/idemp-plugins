package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_ErrorInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_ErrorInput;
import org.compiere.model.X_AD_Error;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Error - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_ErrorMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_ErrorInput.Table_Name;
	}

	public X_AD_Error AD_ErrorSave(I_AD_ErrorInput Entity, DataFetchingEnvironment environment) {
		return (X_AD_Error) super.save((X_AD_ErrorInput) Entity, environment);
	}

	public List<X_AD_Error> AD_ErrorSaveMany(List<I_AD_ErrorInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_ErrorInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_Error) entity).collect(Collectors.toList());
	}

	public boolean AD_ErrorDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
