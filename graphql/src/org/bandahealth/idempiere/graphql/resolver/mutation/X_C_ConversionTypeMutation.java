package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_ConversionTypeInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_ConversionTypeInput;
import org.compiere.model.MConversionType;

import java.util.List;

/**
 * Generated Query Resolver for C_ConversionType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_ConversionTypeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_ConversionTypeInput.Table_Name;
	}

	public MConversionType C_ConversionTypeSave(I_C_ConversionTypeInput input, DataFetchingEnvironment environment) {
		return (MConversionType) super.save((X_C_ConversionTypeInput) input, environment);
	}

	public boolean C_ConversionTypeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
