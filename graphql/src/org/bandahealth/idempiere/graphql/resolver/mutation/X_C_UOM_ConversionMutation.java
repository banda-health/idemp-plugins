package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_UOM_ConversionInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_UOM_ConversionInput;
import org.compiere.model.MUOMConversion;

import java.util.List;

/**
 * Generated Query Resolver for C_UOM_Conversion - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_UOM_ConversionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_UOM_ConversionInput.Table_Name;
	}

	public MUOMConversion C_UOM_ConversionSave(I_C_UOM_ConversionInput input, DataFetchingEnvironment environment) {
		return (MUOMConversion) super.save((X_C_UOM_ConversionInput) input, environment);
	}

	public boolean C_UOM_ConversionDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
