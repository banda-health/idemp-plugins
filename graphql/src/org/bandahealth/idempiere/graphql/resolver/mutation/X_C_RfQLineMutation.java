package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_RfQLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_RfQLineInput;
import org.compiere.model.MRfQLine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_RfQLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_RfQLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_RfQLineInput.Table_Name;
	}

	public MRfQLine C_RfQLineSave(I_C_RfQLineInput Entity, DataFetchingEnvironment environment) {
		return (MRfQLine) super.save((X_C_RfQLineInput) Entity, environment);
	}

	public List<MRfQLine> C_RfQLineSaveMany(List<I_C_RfQLineInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_RfQLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MRfQLine) entity).collect(Collectors.toList());
	}

	public boolean C_RfQLineDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
