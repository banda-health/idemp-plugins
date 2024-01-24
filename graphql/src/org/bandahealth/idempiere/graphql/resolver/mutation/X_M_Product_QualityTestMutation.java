package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_Product_QualityTestInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_Product_QualityTestInput;
import org.compiere.model.X_M_Product_QualityTest;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_Product_QualityTest - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_Product_QualityTestMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_Product_QualityTestInput.Table_Name;
	}

	public X_M_Product_QualityTest M_Product_QualityTestSave(I_M_Product_QualityTestInput entity, DataFetchingEnvironment environment) {
		return (X_M_Product_QualityTest) super.save((X_M_Product_QualityTestInput) entity, environment);
	}

	public List<X_M_Product_QualityTest> M_Product_QualityTestSaveMany(List<I_M_Product_QualityTestInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_M_Product_QualityTestInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_M_Product_QualityTest) entity).collect(Collectors.toList());
	}

	public boolean M_Product_QualityTestDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
