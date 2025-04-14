package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_CM_ChatTypeInput;
import org.bandahealth.idempiere.graphql.model.input.X_CM_ChatTypeInput;
import org.compiere.model.MChatType;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for CM_ChatType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_CM_ChatTypeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_CM_ChatTypeInput.Table_Name;
	}

	public MChatType CM_ChatTypeSave(I_CM_ChatTypeInput Entity, DataFetchingEnvironment environment) {
		return (MChatType) super.save((X_CM_ChatTypeInput) Entity, environment);
	}

	public List<MChatType> CM_ChatTypeSaveMany(List<I_CM_ChatTypeInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_CM_ChatTypeInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MChatType) entity).collect(Collectors.toList());
	}

	public boolean CM_ChatTypeDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
