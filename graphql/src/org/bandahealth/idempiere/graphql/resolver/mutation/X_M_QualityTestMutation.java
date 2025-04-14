package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_QualityTestInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_QualityTestInput;
import org.compiere.model.MQualityTest;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_QualityTest - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_QualityTestMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_QualityTestInput.Table_Name;
	}

	public MQualityTest M_QualityTestSave(I_M_QualityTestInput Entity, DataFetchingEnvironment environment) {
		return (MQualityTest) super.save((X_M_QualityTestInput) Entity, environment);
	}

	public List<MQualityTest> M_QualityTestSaveMany(List<I_M_QualityTestInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_QualityTestInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MQualityTest) entity).collect(Collectors.toList());
	}

	public boolean M_QualityTestDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
