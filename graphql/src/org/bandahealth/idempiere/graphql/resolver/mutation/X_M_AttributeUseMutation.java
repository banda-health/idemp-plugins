package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_M_AttributeUseInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_AttributeUseInput;
import org.compiere.model.MAttributeUse;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_AttributeUse - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_AttributeUseMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_AttributeUseInput.Table_Name;
	}

	public MAttributeUse M_AttributeUseSave(I_M_AttributeUseInput entity, DataFetchingEnvironment environment) {
		return (MAttributeUse) super.save((X_M_AttributeUseInput) entity, environment);
	}

	public List<MAttributeUse> M_AttributeUseSaveMany(List<I_M_AttributeUseInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_M_AttributeUseInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MAttributeUse) entity).collect(Collectors.toList());
	}

	public boolean M_AttributeUseDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
