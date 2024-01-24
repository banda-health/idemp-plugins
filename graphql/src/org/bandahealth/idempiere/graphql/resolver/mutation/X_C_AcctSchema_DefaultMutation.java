package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_AcctSchema_DefaultInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_AcctSchema_DefaultInput;
import org.compiere.model.MAcctSchemaDefault;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_AcctSchema_Default - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_AcctSchema_DefaultMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_AcctSchema_DefaultInput.Table_Name;
	}

	public MAcctSchemaDefault C_AcctSchema_DefaultSave(I_C_AcctSchema_DefaultInput entity, DataFetchingEnvironment environment) {
		return (MAcctSchemaDefault) super.save((X_C_AcctSchema_DefaultInput) entity, environment);
	}

	public List<MAcctSchemaDefault> C_AcctSchema_DefaultSaveMany(List<I_C_AcctSchema_DefaultInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_AcctSchema_DefaultInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MAcctSchemaDefault) entity).collect(Collectors.toList());
	}

	public boolean C_AcctSchema_DefaultDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
