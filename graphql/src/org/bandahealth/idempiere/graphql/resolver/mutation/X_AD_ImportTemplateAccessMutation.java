package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_ImportTemplateAccessInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_ImportTemplateAccessInput;
import org.compiere.model.X_AD_ImportTemplateAccess;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_ImportTemplateAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_ImportTemplateAccessMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_ImportTemplateAccessInput.Table_Name;
	}

	public X_AD_ImportTemplateAccess AD_ImportTemplateAccessSave(I_AD_ImportTemplateAccessInput entity, DataFetchingEnvironment environment) {
		return (X_AD_ImportTemplateAccess) super.save((X_AD_ImportTemplateAccessInput) entity, environment);
	}

	public List<X_AD_ImportTemplateAccess> AD_ImportTemplateAccessSaveMany(List<I_AD_ImportTemplateAccessInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_ImportTemplateAccessInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_ImportTemplateAccess) entity).collect(Collectors.toList());
	}

	public boolean AD_ImportTemplateAccessDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
