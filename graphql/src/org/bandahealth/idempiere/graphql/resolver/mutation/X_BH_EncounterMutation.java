package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHEncounter;
import org.bandahealth.idempiere.graphql.model.input.I_BH_EncounterInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_EncounterInput;

import java.util.List;

/**
 * Generated Query Resolver for BH_Encounter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_BH_EncounterMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_EncounterInput.Table_Name;
	}

	public MBHEncounter BH_EncounterSave(I_BH_EncounterInput input, DataFetchingEnvironment environment) {
		return (MBHEncounter) super.save((X_BH_EncounterInput) input, environment);
	}

	public boolean BH_EncounterDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
