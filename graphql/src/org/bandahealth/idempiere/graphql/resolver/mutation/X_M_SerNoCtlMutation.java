package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MSerNoCtl_BH;
import org.bandahealth.idempiere.graphql.model.input.I_M_SerNoCtlInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_SerNoCtlInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_SerNoCtl - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_SerNoCtlMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_SerNoCtlInput.Table_Name;
	}

	public MSerNoCtl_BH M_SerNoCtlSave(I_M_SerNoCtlInput entity, DataFetchingEnvironment environment) {
		return (MSerNoCtl_BH) super.save((X_M_SerNoCtlInput) entity, environment);
	}

	public List<MSerNoCtl_BH> M_SerNoCtlSaveMany(List<I_M_SerNoCtlInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_M_SerNoCtlInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MSerNoCtl_BH) entity).collect(Collectors.toList());
	}

	public boolean M_SerNoCtlDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
