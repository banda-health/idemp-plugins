package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MInOut_BH;
import org.bandahealth.idempiere.graphql.model.input.I_M_InOutInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_InOutInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_InOut - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_InOutMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_InOutInput.Table_Name;
	}

	public MInOut_BH M_InOutSave(I_M_InOutInput Entity, DataFetchingEnvironment environment) {
		return (MInOut_BH) super.save((X_M_InOutInput) Entity, environment);
	}

	public List<MInOut_BH> M_InOutSaveMany(List<I_M_InOutInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_InOutInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MInOut_BH) entity).collect(Collectors.toList());
	}

	public boolean M_InOutDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
