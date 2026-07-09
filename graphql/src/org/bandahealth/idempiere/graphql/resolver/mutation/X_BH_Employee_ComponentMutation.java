package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHEmployeeComponent;
import org.bandahealth.idempiere.graphql.model.input.I_BH_Employee_ComponentInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_Employee_ComponentInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_Employee_Component - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Employee_ComponentMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_Employee_ComponentInput.Table_Name;
	}

	public MBHEmployeeComponent BH_Employee_ComponentSave(I_BH_Employee_ComponentInput Entity, DataFetchingEnvironment environment) {
		return (MBHEmployeeComponent) super.save((X_BH_Employee_ComponentInput) Entity, environment);
	}

	public List<MBHEmployeeComponent> BH_Employee_ComponentSaveMany(List<I_BH_Employee_ComponentInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_BH_Employee_ComponentInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHEmployeeComponent) entity).collect(Collectors.toList());
	}

	public boolean BH_Employee_ComponentDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
