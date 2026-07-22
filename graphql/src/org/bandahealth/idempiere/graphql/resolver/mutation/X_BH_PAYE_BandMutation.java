package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPAYEBand;
import org.bandahealth.idempiere.graphql.model.input.I_BH_PAYE_BandInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_PAYE_BandInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_PAYE_Band - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_PAYE_BandMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_PAYE_BandInput.Table_Name;
	}

	public MBHPAYEBand BH_PAYE_BandSave(I_BH_PAYE_BandInput Entity, DataFetchingEnvironment environment) {
		return (MBHPAYEBand) super.save((X_BH_PAYE_BandInput) Entity, environment);
	}

	public List<MBHPAYEBand> BH_PAYE_BandSaveMany(List<I_BH_PAYE_BandInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_BH_PAYE_BandInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHPAYEBand) entity).collect(Collectors.toList());
	}

	public boolean BH_PAYE_BandDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
