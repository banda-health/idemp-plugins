package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MSequence_BH;
import org.bandahealth.idempiere.graphql.model.input.I_AD_SequenceInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_SequenceInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Sequence - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_SequenceMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_SequenceInput.Table_Name;
	}

	public MSequence_BH AD_SequenceSave(I_AD_SequenceInput Entity, DataFetchingEnvironment environment) {
		return (MSequence_BH) super.save((X_AD_SequenceInput) Entity, environment);
	}

	public List<MSequence_BH> AD_SequenceSaveMany(List<I_AD_SequenceInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_SequenceInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MSequence_BH) entity).collect(Collectors.toList());
	}

	public boolean AD_SequenceDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
