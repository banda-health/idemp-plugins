package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_OperationResourceInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_OperationResourceInput;
import org.compiere.model.X_M_OperationResource;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_OperationResource - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_OperationResourceMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_OperationResourceInput.Table_Name;
	}

	public X_M_OperationResource M_OperationResourceSave(I_M_OperationResourceInput Entity, DataFetchingEnvironment environment) {
		return (X_M_OperationResource) super.save((X_M_OperationResourceInput) Entity, environment);
	}

	public List<X_M_OperationResource> M_OperationResourceSaveMany(List<I_M_OperationResourceInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_OperationResourceInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_M_OperationResource) entity).collect(Collectors.toList());
	}

	public boolean M_OperationResourceDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
