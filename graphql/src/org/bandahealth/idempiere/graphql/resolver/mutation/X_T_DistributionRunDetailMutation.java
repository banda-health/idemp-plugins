package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_T_DistributionRunDetailInput;
import org.bandahealth.idempiere.graphql.model.input.X_T_DistributionRunDetailInput;
import org.compiere.model.MDistributionRunDetail;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for T_DistributionRunDetail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_T_DistributionRunDetailMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_T_DistributionRunDetailInput.Table_Name;
	}

	public MDistributionRunDetail T_DistributionRunDetailSave(I_T_DistributionRunDetailInput Entity, DataFetchingEnvironment environment) {
		return (MDistributionRunDetail) super.save((X_T_DistributionRunDetailInput) Entity, environment);
	}

	public List<MDistributionRunDetail> T_DistributionRunDetailSaveMany(List<I_T_DistributionRunDetailInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_T_DistributionRunDetailInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MDistributionRunDetail) entity).collect(Collectors.toList());
	}

	public boolean T_DistributionRunDetailDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
