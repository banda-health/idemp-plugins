package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.graphql.model.input.I_BH_VisitInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_VisitInput;

import java.util.List;

/**
 * Generated Query Resolver for BH_Visit - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_BH_VisitMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_VisitInput.Table_Name;
	}

	public MBHVisit BH_VisitSave(I_BH_VisitInput input, DataFetchingEnvironment environment) {
		return (MBHVisit) super.save((X_BH_VisitInput) input, environment);
	}

	public boolean BH_VisitDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
