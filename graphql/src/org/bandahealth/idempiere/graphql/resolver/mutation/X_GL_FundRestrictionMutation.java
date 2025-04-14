package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_GL_FundRestrictionInput;
import org.bandahealth.idempiere.graphql.model.input.X_GL_FundRestrictionInput;
import org.compiere.model.X_GL_FundRestriction;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for GL_FundRestriction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_GL_FundRestrictionMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_GL_FundRestrictionInput.Table_Name;
	}

	public X_GL_FundRestriction GL_FundRestrictionSave(I_GL_FundRestrictionInput Entity, DataFetchingEnvironment environment) {
		return (X_GL_FundRestriction) super.save((X_GL_FundRestrictionInput) Entity, environment);
	}

	public List<X_GL_FundRestriction> GL_FundRestrictionSaveMany(List<I_GL_FundRestrictionInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_GL_FundRestrictionInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_GL_FundRestriction) entity).collect(Collectors.toList());
	}

	public boolean GL_FundRestrictionDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
