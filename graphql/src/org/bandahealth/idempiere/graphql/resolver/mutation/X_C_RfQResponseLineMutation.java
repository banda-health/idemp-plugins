package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_RfQResponseLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_RfQResponseLineInput;
import org.compiere.model.MRfQResponseLine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_RfQResponseLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_RfQResponseLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_RfQResponseLineInput.Table_Name;
	}

	public MRfQResponseLine C_RfQResponseLineSave(I_C_RfQResponseLineInput entity, DataFetchingEnvironment environment) {
		return (MRfQResponseLine) super.save((X_C_RfQResponseLineInput) entity, environment);
	}

	public List<MRfQResponseLine> C_RfQResponseLineSaveMany(List<I_C_RfQResponseLineInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_RfQResponseLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MRfQResponseLine) entity).collect(Collectors.toList());
	}

	public boolean C_RfQResponseLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
