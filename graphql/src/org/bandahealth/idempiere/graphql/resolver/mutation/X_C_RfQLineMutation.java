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
 * @version Release 7.1 - $Id$
 */
public class X_C_RfQLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_RfQLineInput.Table_Name;
	}

	public MRfQLine C_RfQLineSave(I_C_RfQLineInput entity, DataFetchingEnvironment environment) {
		return (MRfQLine) super.save((X_C_RfQLineInput) entity, environment);
	}

	public List<MRfQLine> C_RfQLineSaveMany(List<I_C_RfQLineInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_C_RfQLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MRfQLine) entity).collect(Collectors.toList());
	}

	public boolean C_RfQLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
