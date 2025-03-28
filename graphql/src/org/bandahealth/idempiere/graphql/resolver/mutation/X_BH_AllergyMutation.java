package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHAllergy;
import org.bandahealth.idempiere.graphql.model.input.I_BH_AllergyInput;
import org.bandahealth.idempiere.graphql.model.input.X_BH_AllergyInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for BH_Allergy - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_AllergyMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_BH_AllergyInput.Table_Name;
	}

	public MBHAllergy BH_AllergySave(I_BH_AllergyInput Entity, DataFetchingEnvironment environment) {
		return (MBHAllergy) super.save((X_BH_AllergyInput) Entity, environment);
	}

	public List<MBHAllergy> BH_AllergySaveMany(List<I_BH_AllergyInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_BH_AllergyInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MBHAllergy) entity).collect(Collectors.toList());
	}

	public boolean BH_AllergyDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
