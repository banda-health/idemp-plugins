package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHEncounter;
import org.bandahealth.idempiere.graphql.model.input.I_BH_EncounterInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_EncounterInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_Encounter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_EncounterMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_EncounterInput.Table_Name;
	}

	public MBHEncounter BH_EncounterSave(I_BH_EncounterInput Entity, DataFetchingEnvironment environment) {
		return (MBHEncounter) super.save((X_BH_EncounterInput) Entity, environment);
	}

	public List<MBHEncounter> BH_EncounterSaveMany(List<I_BH_EncounterInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_BH_EncounterInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHEncounter) entity).collect(Collectors.toList());
	}

	public boolean BH_EncounterDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
