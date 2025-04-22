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
 * @version Release 12 - $Id$
 */
public class X_C_RfQResponseLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_RfQResponseLineInput.Table_Name;
	}

	public MRfQResponseLine C_RfQResponseLineSave(I_C_RfQResponseLineInput Entity, DataFetchingEnvironment environment) {
		return (MRfQResponseLine) super.save((X_C_RfQResponseLineInput) Entity, environment);
	}

	public List<MRfQResponseLine> C_RfQResponseLineSaveMany(List<I_C_RfQResponseLineInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_RfQResponseLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MRfQResponseLine) entity).collect(Collectors.toList());
	}

	public boolean C_RfQResponseLineDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
