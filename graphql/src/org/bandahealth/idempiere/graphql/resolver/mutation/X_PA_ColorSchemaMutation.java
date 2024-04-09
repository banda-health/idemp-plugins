package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PA_ColorSchemaInput;
import org.bandahealth.idempiere.graphql.model.input.X_PA_ColorSchemaInput;
import org.compiere.model.MColorSchema;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for PA_ColorSchema - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_ColorSchemaMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PA_ColorSchemaInput.Table_Name;
	}

	public MColorSchema PA_ColorSchemaSave(I_PA_ColorSchemaInput Entity, DataFetchingEnvironment environment) {
		return (MColorSchema) super.save((X_PA_ColorSchemaInput) Entity, environment);
	}

	public List<MColorSchema> PA_ColorSchemaSaveMany(List<I_PA_ColorSchemaInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_PA_ColorSchemaInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MColorSchema) entity).collect(Collectors.toList());
	}

	public boolean PA_ColorSchemaDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
