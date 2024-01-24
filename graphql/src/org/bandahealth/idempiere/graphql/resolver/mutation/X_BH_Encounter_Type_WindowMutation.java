package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHEncounterTypeWindow;
import org.bandahealth.idempiere.graphql.model.input.I_BH_Encounter_Type_WindowInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_Encounter_Type_WindowInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_Encounter_Type_Window - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_BH_Encounter_Type_WindowMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_Encounter_Type_WindowInput.Table_Name;
	}

	public MBHEncounterTypeWindow BH_Encounter_Type_WindowSave(I_BH_Encounter_Type_WindowInput entity, DataFetchingEnvironment environment) {
		return (MBHEncounterTypeWindow) super.save((X_BH_Encounter_Type_WindowInput) entity, environment);
	}

	public List<MBHEncounterTypeWindow> BH_Encounter_Type_WindowSaveMany(List<I_BH_Encounter_Type_WindowInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_BH_Encounter_Type_WindowInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHEncounterTypeWindow) entity).collect(Collectors.toList());
	}

	public boolean BH_Encounter_Type_WindowDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
