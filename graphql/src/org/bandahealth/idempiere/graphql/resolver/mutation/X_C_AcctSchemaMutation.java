package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_AcctSchemaInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_AcctSchemaInput;
import org.compiere.model.MAcctSchema;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_AcctSchema - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_AcctSchemaMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_AcctSchemaInput.Table_Name;
	}

	public MAcctSchema C_AcctSchemaSave(I_C_AcctSchemaInput Entity, DataFetchingEnvironment environment) {
		return (MAcctSchema) super.save((X_C_AcctSchemaInput) Entity, environment);
	}

	public List<MAcctSchema> C_AcctSchemaSaveMany(List<I_C_AcctSchemaInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_AcctSchemaInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MAcctSchema) entity).collect(Collectors.toList());
	}

	public boolean C_AcctSchemaDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
