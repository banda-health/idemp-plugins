package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_Sequence_NoInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_Sequence_NoInput;
import org.compiere.model.X_AD_Sequence_No;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Sequence_No - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_Sequence_NoMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_Sequence_NoInput.Table_Name;
	}

	public X_AD_Sequence_No AD_Sequence_NoSave(I_AD_Sequence_NoInput Entity, DataFetchingEnvironment environment) {
		return (X_AD_Sequence_No) super.save((X_AD_Sequence_NoInput) Entity, environment);
	}

	public List<X_AD_Sequence_No> AD_Sequence_NoSaveMany(List<I_AD_Sequence_NoInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_Sequence_NoInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_Sequence_No) entity).collect(Collectors.toList());
	}

	public boolean AD_Sequence_NoDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
