package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_UOM_ConversionInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_UOM_ConversionInput;
import org.compiere.model.MUOMConversion;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_UOM_Conversion - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_UOM_ConversionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_UOM_ConversionInput.Table_Name;
	}

	public MUOMConversion C_UOM_ConversionSave(I_C_UOM_ConversionInput Entity, DataFetchingEnvironment environment) {
		return (MUOMConversion) super.save((X_C_UOM_ConversionInput) Entity, environment);
	}

	public List<MUOMConversion> C_UOM_ConversionSaveMany(List<I_C_UOM_ConversionInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_UOM_ConversionInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MUOMConversion) entity).collect(Collectors.toList());
	}

	public boolean C_UOM_ConversionDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
