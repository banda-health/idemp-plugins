package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_ReplicationDocumentInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_ReplicationDocumentInput;
import org.compiere.model.X_AD_ReplicationDocument;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_ReplicationDocument - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_ReplicationDocumentMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_ReplicationDocumentInput.Table_Name;
	}

	public X_AD_ReplicationDocument AD_ReplicationDocumentSave(I_AD_ReplicationDocumentInput Entity, DataFetchingEnvironment environment) {
		return (X_AD_ReplicationDocument) super.save((X_AD_ReplicationDocumentInput) Entity, environment);
	}

	public List<X_AD_ReplicationDocument> AD_ReplicationDocumentSaveMany(List<I_AD_ReplicationDocumentInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_ReplicationDocumentInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_AD_ReplicationDocument) entity).collect(Collectors.toList());
	}

	public boolean AD_ReplicationDocumentDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
