package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_AttributeUseInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_AttributeUseInput;
import org.compiere.model.MAttributeUse;

import java.util.List;

/**
 * Generated Query Resolver for M_AttributeUse - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_AttributeUseMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_AttributeUseInput.Table_Name;
	}

	public MAttributeUse M_AttributeUseSave(I_M_AttributeUseInput input, DataFetchingEnvironment environment) {
		return (MAttributeUse) super.save((X_M_AttributeUseInput) input, environment);
	}

	public boolean M_AttributeUseDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
