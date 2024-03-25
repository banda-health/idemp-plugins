package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_DistributionRunLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_DistributionRunLineInput;
import org.compiere.model.MDistributionRunLine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_DistributionRunLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_DistributionRunLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_DistributionRunLineInput.Table_Name;
	}

	public MDistributionRunLine M_DistributionRunLineSave(I_M_DistributionRunLineInput entity, DataFetchingEnvironment environment) {
		return (MDistributionRunLine) super.save((X_M_DistributionRunLineInput) entity, environment);
	}

	public List<MDistributionRunLine> M_DistributionRunLineSaveMany(List<I_M_DistributionRunLineInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_M_DistributionRunLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MDistributionRunLine) entity).collect(Collectors.toList());
	}

	public boolean M_DistributionRunLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
