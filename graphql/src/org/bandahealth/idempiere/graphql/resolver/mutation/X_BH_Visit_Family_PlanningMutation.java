package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHVisitFamilyPlanning;
import org.bandahealth.idempiere.graphql.model.input.I_BH_Visit_Family_PlanningInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_Visit_Family_PlanningInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_Visit_Family_Planning - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Visit_Family_PlanningMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_Visit_Family_PlanningInput.Table_Name;
	}

	public MBHVisitFamilyPlanning BH_Visit_Family_PlanningSave(I_BH_Visit_Family_PlanningInput Entity, DataFetchingEnvironment environment) {
		return (MBHVisitFamilyPlanning) super.save((X_BH_Visit_Family_PlanningInput) Entity, environment);
	}

	public List<MBHVisitFamilyPlanning> BH_Visit_Family_PlanningSaveMany(List<I_BH_Visit_Family_PlanningInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_BH_Visit_Family_PlanningInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHVisitFamilyPlanning) entity).collect(Collectors.toList());
	}

	public boolean BH_Visit_Family_PlanningDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
