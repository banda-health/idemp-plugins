package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_TestInput;
import org.bandahealth.idempiere.graphql.model.input.X_TestInput;
import org.compiere.model.MTest;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for Test - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_TestMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_TestInput.Table_Name;
	}

	public MTest TestSave(I_TestInput Entity, DataFetchingEnvironment environment) {
		return (MTest) super.save((X_TestInput) Entity, environment);
	}

	public List<MTest> TestSaveMany(List<I_TestInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_TestInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MTest) entity).collect(Collectors.toList());
	}

	public boolean TestDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
