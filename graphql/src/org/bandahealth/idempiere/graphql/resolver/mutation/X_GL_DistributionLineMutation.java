package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_GL_DistributionLineInput;
import org.bandahealth.idempiere.graphql.model.input.X_GL_DistributionLineInput;
import org.compiere.model.MDistributionLine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for GL_DistributionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_GL_DistributionLineMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_GL_DistributionLineInput.Table_Name;
	}

	public MDistributionLine GL_DistributionLineSave(I_GL_DistributionLineInput entity, DataFetchingEnvironment environment) {
		return (MDistributionLine) super.save((X_GL_DistributionLineInput) entity, environment);
	}

	public List<MDistributionLine> GL_DistributionLineSaveMany(List<I_GL_DistributionLineInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_GL_DistributionLineInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MDistributionLine) entity).collect(Collectors.toList());
	}

	public boolean GL_DistributionLineDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
