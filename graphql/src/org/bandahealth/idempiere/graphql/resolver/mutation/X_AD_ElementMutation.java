package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_ElementInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_ElementInput;
import org.compiere.model.M_Element;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Element - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_ElementMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_ElementInput.Table_Name;
	}

	public M_Element AD_ElementSave(I_AD_ElementInput Entity, DataFetchingEnvironment environment) {
		return (M_Element) super.save((X_AD_ElementInput) Entity, environment);
	}

	public List<M_Element> AD_ElementSaveMany(List<I_AD_ElementInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_ElementInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (M_Element) entity).collect(Collectors.toList());
	}

	public boolean AD_ElementDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
