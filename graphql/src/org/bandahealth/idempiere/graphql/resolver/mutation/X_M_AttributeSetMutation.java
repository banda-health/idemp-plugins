package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MAttributeSet_BH;
import org.bandahealth.idempiere.graphql.model.input.I_M_AttributeSetInput;
import org.bandahealth.idempiere.graphql.model.input.X_M_AttributeSetInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for M_AttributeSet - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_AttributeSetMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_M_AttributeSetInput.Table_Name;
	}

	public MAttributeSet_BH M_AttributeSetSave(I_M_AttributeSetInput Entity, DataFetchingEnvironment environment) {
		return (MAttributeSet_BH) super.save((X_M_AttributeSetInput) Entity, environment);
	}

	public List<MAttributeSet_BH> M_AttributeSetSaveMany(List<I_M_AttributeSetInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_M_AttributeSetInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MAttributeSet_BH) entity).collect(Collectors.toList());
	}

	public boolean M_AttributeSetDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
