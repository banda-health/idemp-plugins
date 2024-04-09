package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_PerpetualInvInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_PerpetualInvInput;
import org.compiere.model.X_M_PerpetualInv;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_PerpetualInv - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_PerpetualInvMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_PerpetualInvInput.Table_Name;
	}

	public X_M_PerpetualInv M_PerpetualInvSave(I_M_PerpetualInvInput Entity, DataFetchingEnvironment environment) {
		return (X_M_PerpetualInv) super.save((X_M_PerpetualInvInput) Entity, environment);
	}

	public List<X_M_PerpetualInv> M_PerpetualInvSaveMany(List<I_M_PerpetualInvInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_PerpetualInvInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_M_PerpetualInv) entity).collect(Collectors.toList());
	}

	public boolean M_PerpetualInvDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
