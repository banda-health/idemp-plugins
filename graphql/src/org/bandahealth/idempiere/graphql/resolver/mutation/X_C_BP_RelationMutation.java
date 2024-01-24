package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_C_BP_RelationInput;
import org.bandahealth.idempiere.graphql.model.input.X_C_BP_RelationInput;
import org.compiere.model.X_C_BP_Relation;

import java.util.List;

/**
 * Generated Query Resolver for C_BP_Relation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_BP_RelationMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_C_BP_RelationInput.Table_Name;
	}

	public X_C_BP_Relation C_BP_RelationSave(I_C_BP_RelationInput input, DataFetchingEnvironment environment) {
		return (X_C_BP_Relation) super.save((X_C_BP_RelationInput) input, environment);
	}

	public boolean C_BP_RelationDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
