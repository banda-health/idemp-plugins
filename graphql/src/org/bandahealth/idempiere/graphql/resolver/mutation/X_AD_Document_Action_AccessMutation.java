package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_Document_Action_AccessInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_Document_Action_AccessInput;
import org.compiere.model.MDocumentActionAccess;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Document_Action_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_Document_Action_AccessMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_Document_Action_AccessInput.Table_Name;
	}

	public MDocumentActionAccess AD_Document_Action_AccessSave(I_AD_Document_Action_AccessInput Entity, DataFetchingEnvironment environment) {
		return (MDocumentActionAccess) super.save((X_AD_Document_Action_AccessInput) Entity, environment);
	}

	public List<MDocumentActionAccess> AD_Document_Action_AccessSaveMany(List<I_AD_Document_Action_AccessInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_Document_Action_AccessInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MDocumentActionAccess) entity).collect(Collectors.toList());
	}

	public boolean AD_Document_Action_AccessDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
