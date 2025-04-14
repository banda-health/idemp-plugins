package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_ImageInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_ImageInput;
import org.compiere.model.MImage;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Image - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_ImageMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_ImageInput.Table_Name;
	}

	public MImage AD_ImageSave(I_AD_ImageInput Entity, DataFetchingEnvironment environment) {
		return (MImage) super.save((X_AD_ImageInput) Entity, environment);
	}

	public List<MImage> AD_ImageSaveMany(List<I_AD_ImageInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_ImageInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MImage) entity).collect(Collectors.toList());
	}

	public boolean AD_ImageDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
