package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHVisitFamilyPlanningProduct;
import org.bandahealth.idempiere.graphql.model.input.I_BH_Visit_Family_Planning_ProductInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_Visit_Family_Planning_ProductInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_Visit_Family_Planning_Product - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Visit_Family_Planning_ProductMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_Visit_Family_Planning_ProductInput.Table_Name;
	}

	public MBHVisitFamilyPlanningProduct BH_Visit_Family_Planning_ProductSave(I_BH_Visit_Family_Planning_ProductInput Entity, DataFetchingEnvironment environment) {
		return (MBHVisitFamilyPlanningProduct) super.save((X_BH_Visit_Family_Planning_ProductInput) Entity, environment);
	}

	public List<MBHVisitFamilyPlanningProduct> BH_Visit_Family_Planning_ProductSaveMany(List<I_BH_Visit_Family_Planning_ProductInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_BH_Visit_Family_Planning_ProductInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHVisitFamilyPlanningProduct) entity).collect(Collectors.toList());
	}

	public boolean BH_Visit_Family_Planning_ProductDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
