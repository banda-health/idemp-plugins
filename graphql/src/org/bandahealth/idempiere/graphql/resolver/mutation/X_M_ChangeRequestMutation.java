package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_ChangeRequestInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_ChangeRequestInput;
import org.compiere.model.MChangeRequest;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_ChangeRequest - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_ChangeRequestMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_ChangeRequestInput.Table_Name;
	}

	public MChangeRequest M_ChangeRequestSave(I_M_ChangeRequestInput Entity, DataFetchingEnvironment environment) {
		return (MChangeRequest) super.save((X_M_ChangeRequestInput) Entity, environment);
	}

	public List<MChangeRequest> M_ChangeRequestSaveMany(List<I_M_ChangeRequestInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_ChangeRequestInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MChangeRequest) entity).collect(Collectors.toList());
	}

	public boolean M_ChangeRequestDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
