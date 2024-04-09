package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_B_BidCommentInput;
import org.bandahealth.idempiere.graphql.model.input.X_B_BidCommentInput;
import org.compiere.model.X_B_BidComment;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for B_BidComment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_B_BidCommentMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_B_BidCommentInput.Table_Name;
	}

	public X_B_BidComment B_BidCommentSave(I_B_BidCommentInput Entity, DataFetchingEnvironment environment) {
		return (X_B_BidComment) super.save((X_B_BidCommentInput) Entity, environment);
	}

	public List<X_B_BidComment> B_BidCommentSaveMany(List<I_B_BidCommentInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_B_BidCommentInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (X_B_BidComment) entity).collect(Collectors.toList());
	}

	public boolean B_BidCommentDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
