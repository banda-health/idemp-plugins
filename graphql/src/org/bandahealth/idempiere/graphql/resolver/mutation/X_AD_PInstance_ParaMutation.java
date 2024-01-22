package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_PInstance_ParaInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_PInstance_ParaInput;
import org.compiere.model.MPInstancePara;

import java.util.List;

/**
 * Generated Query Resolver for AD_PInstance_Para - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_PInstance_ParaMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_PInstance_ParaInput.Table_Name;
	}

	public MPInstancePara AD_PInstance_ParaSave(I_AD_PInstance_ParaInput input, DataFetchingEnvironment environment) {
		return (MPInstancePara) super.save((X_AD_PInstance_ParaInput) input, environment);
	}

	public boolean AD_PInstance_ParaDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
