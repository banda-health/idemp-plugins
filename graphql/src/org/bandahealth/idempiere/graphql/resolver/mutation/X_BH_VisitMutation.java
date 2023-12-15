package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.graphql.model.input.M_BH_VisitInput;

import java.util.List;

public class X_BH_VisitMutation extends POMutation<M_BH_VisitInput> implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return M_BH_VisitInput.Table_Name;
	}

	public MBHVisit BH_VisitSave(M_BH_VisitInput visitInput) {
		return super.save(visitInput);
	}

	public boolean BH_VisitDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
