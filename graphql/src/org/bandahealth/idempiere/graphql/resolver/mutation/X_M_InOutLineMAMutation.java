package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_InOutLineMAInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_InOutLineMAInput;
import org.compiere.model.MInOutLineMA;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_InOutLineMA - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_InOutLineMAMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_InOutLineMAInput.Table_Name;
	}

	public MInOutLineMA M_InOutLineMASave(I_M_InOutLineMAInput entity, DataFetchingEnvironment environment) {
		return (MInOutLineMA) super.save((X_M_InOutLineMAInput) entity, environment);
	}

	public List<MInOutLineMA> M_InOutLineMASaveMany(List<I_M_InOutLineMAInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_M_InOutLineMAInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MInOutLineMA) entity).collect(Collectors.toList());
	}

	public boolean M_InOutLineMADelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
