package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_IMP_Processor_TypeInput;
import org.bandahealth.idempiere.graphql.model.input.X_IMP_Processor_TypeInput;
import org.compiere.model.X_IMP_Processor_Type;

import java.util.List;

/**
 * Generated Query Resolver for IMP_Processor_Type - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_IMP_Processor_TypeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_IMP_Processor_TypeInput.Table_Name;
	}

	public X_IMP_Processor_Type IMP_Processor_TypeSave(I_IMP_Processor_TypeInput input, DataFetchingEnvironment environment) {
		return (X_IMP_Processor_Type) super.save((X_IMP_Processor_TypeInput) input, environment);
	}

	public boolean IMP_Processor_TypeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
