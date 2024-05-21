package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_GL_FundInput;
import org.bandahealth.idempiere.graphql.model.input.X_GL_FundInput;
import org.compiere.model.X_GL_Fund;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for GL_Fund - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_GL_FundMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_GL_FundInput.Table_Name;
	}

	public X_GL_Fund GL_FundSave(I_GL_FundInput Entity, DataFetchingEnvironment environment) {
		return (X_GL_Fund) super.save((X_GL_FundInput) Entity, environment);
	}

	public List<X_GL_Fund> GL_FundSaveMany(List<I_GL_FundInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_GL_FundInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_GL_Fund) entity).collect(Collectors.toList());
	}

	public boolean GL_FundDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
