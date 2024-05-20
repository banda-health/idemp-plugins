package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MTree_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TreeDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MElement;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_Element - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_ElementResolver extends POResolver<MElement> implements GraphQLResolver<MElement> {



	/**
	 * Get Tree.
	 *
	 * @return Identifies a Tree
	 */
	public CompletableFuture<MTree_BH> AD_Tree(MElement entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Tree_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MTree_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TreeDataLoader.DATALOADER_AD_Tree_BY_ID);
		return dataLoader.load(entity.getAD_Tree_ID());
	}

	static Map<String, String> ELEMENTTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "56f0e1f5-78b1-4965-b423-5328ed649be1");
			put("U", "71e6a68d-1ec2-4d62-a5f3-81c725accd6d");
		}
	};
	public CompletableFuture<MRefList_BH> ElementType(MElement entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getElementType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ELEMENTTYPE_UUIDS_BY_VALUE.get(entity.getElementType()));
	}

	public Boolean IsBalancing(MElement entity, DataFetchingEnvironment environment) {
		return entity.isBalancing();
	}

	public Boolean IsNaturalAccount(MElement entity, DataFetchingEnvironment environment) {
		return entity.isNaturalAccount();
	}

}
