package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_ConversionTypeInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_ConversionTypeInput;
import org.compiere.model.MConversionType;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_ConversionType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_ConversionTypeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_ConversionTypeInput.Table_Name;
	}

	public MConversionType C_ConversionTypeSave(I_C_ConversionTypeInput Entity, DataFetchingEnvironment environment) {
		return (MConversionType) super.save((X_C_ConversionTypeInput) Entity, environment);
	}

	public List<MConversionType> C_ConversionTypeSaveMany(List<I_C_ConversionTypeInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_ConversionTypeInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MConversionType) entity).collect(Collectors.toList());
	}

	public boolean C_ConversionTypeDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
