package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_BP_RelationInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_BP_RelationInput;
import org.compiere.model.X_C_BP_Relation;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for C_BP_Relation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_BP_RelationMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_BP_RelationInput.Table_Name;
	}

	public X_C_BP_Relation C_BP_RelationSave(I_C_BP_RelationInput Entity, DataFetchingEnvironment environment) {
		return (X_C_BP_Relation) super.save((X_C_BP_RelationInput) Entity, environment);
	}

	public List<X_C_BP_Relation> C_BP_RelationSaveMany(List<I_C_BP_RelationInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_C_BP_RelationInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_C_BP_Relation) entity).collect(Collectors.toList());
	}

	public boolean C_BP_RelationDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
