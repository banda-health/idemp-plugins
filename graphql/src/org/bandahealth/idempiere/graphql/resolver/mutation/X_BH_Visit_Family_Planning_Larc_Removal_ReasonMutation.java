package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHVisitFamilyPlanningLarcRemovalReason;
import org.bandahealth.idempiere.graphql.model.input.I_BH_Visit_Family_Planning_Larc_Removal_ReasonInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_Visit_Family_Planning_Larc_Removal_ReasonInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_Visit_Family_Planning_Larc_Removal_Reason - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Visit_Family_Planning_Larc_Removal_ReasonMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_Visit_Family_Planning_Larc_Removal_ReasonInput.Table_Name;
	}

	public MBHVisitFamilyPlanningLarcRemovalReason BH_Visit_Family_Planning_Larc_Removal_ReasonSave(I_BH_Visit_Family_Planning_Larc_Removal_ReasonInput Entity, DataFetchingEnvironment environment) {
		return (MBHVisitFamilyPlanningLarcRemovalReason) super.save((X_BH_Visit_Family_Planning_Larc_Removal_ReasonInput) Entity, environment);
	}

	public List<MBHVisitFamilyPlanningLarcRemovalReason> BH_Visit_Family_Planning_Larc_Removal_ReasonSaveMany(List<I_BH_Visit_Family_Planning_Larc_Removal_ReasonInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_BH_Visit_Family_Planning_Larc_Removal_ReasonInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHVisitFamilyPlanningLarcRemovalReason) entity).collect(Collectors.toList());
	}

	public boolean BH_Visit_Family_Planning_Larc_Removal_ReasonDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
