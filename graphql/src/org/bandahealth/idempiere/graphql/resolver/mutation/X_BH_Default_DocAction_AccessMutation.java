package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHDefaultDocActionAccess;
import org.bandahealth.idempiere.graphql.model.input.I_BH_Default_DocAction_AccessInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_Default_DocAction_AccessInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_Default_DocAction_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Default_DocAction_AccessMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_Default_DocAction_AccessInput.Table_Name;
	}

	public MBHDefaultDocActionAccess BH_Default_DocAction_AccessSave(I_BH_Default_DocAction_AccessInput Entity, DataFetchingEnvironment environment) {
		return (MBHDefaultDocActionAccess) super.save((X_BH_Default_DocAction_AccessInput) Entity, environment);
	}

	public List<MBHDefaultDocActionAccess> BH_Default_DocAction_AccessSaveMany(List<I_BH_Default_DocAction_AccessInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_BH_Default_DocAction_AccessInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHDefaultDocActionAccess) entity).collect(Collectors.toList());
	}

	public boolean BH_Default_DocAction_AccessDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
