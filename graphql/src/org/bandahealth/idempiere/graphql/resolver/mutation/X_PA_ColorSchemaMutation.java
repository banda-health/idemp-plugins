package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_PA_ColorSchemaInput;
import org.bandahealth.idempiere.graphql.model.input.X_PA_ColorSchemaInput;
import org.compiere.model.MColorSchema;

import java.util.List;

/**
 * Generated Query Resolver for PA_ColorSchema - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_PA_ColorSchemaMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_PA_ColorSchemaInput.Table_Name;
	}

	public MColorSchema PA_ColorSchemaSave(I_PA_ColorSchemaInput input, DataFetchingEnvironment environment) {
		return (MColorSchema) super.save((X_PA_ColorSchemaInput) input, environment);
	}

	public boolean PA_ColorSchemaDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
