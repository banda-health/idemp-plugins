package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_DistributionRunInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_DistributionRunInput;
import org.compiere.model.MDistributionRun;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_DistributionRun - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_DistributionRunMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_DistributionRunInput.Table_Name;
	}

	public MDistributionRun M_DistributionRunSave(I_M_DistributionRunInput Entity, DataFetchingEnvironment environment) {
		return (MDistributionRun) super.save((X_M_DistributionRunInput) Entity, environment);
	}

	public List<MDistributionRun> M_DistributionRunSaveMany(List<I_M_DistributionRunInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_DistributionRunInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MDistributionRun) entity).collect(Collectors.toList());
	}

	public boolean M_DistributionRunDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
