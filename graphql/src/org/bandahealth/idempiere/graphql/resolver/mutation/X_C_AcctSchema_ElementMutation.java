package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_AcctSchema_ElementInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_AcctSchema_ElementInput;
import org.compiere.model.MAcctSchemaElement;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_AcctSchema_Element - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_AcctSchema_ElementMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_AcctSchema_ElementInput.Table_Name;
	}

	public MAcctSchemaElement C_AcctSchema_ElementSave(I_C_AcctSchema_ElementInput entity, DataFetchingEnvironment environment) {
		return (MAcctSchemaElement) super.save((X_C_AcctSchema_ElementInput) entity, environment);
	}

	public List<MAcctSchemaElement> C_AcctSchema_ElementSaveMany(List<I_C_AcctSchema_ElementInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_AcctSchema_ElementInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MAcctSchemaElement) entity).collect(Collectors.toList());
	}

	public boolean C_AcctSchema_ElementDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
