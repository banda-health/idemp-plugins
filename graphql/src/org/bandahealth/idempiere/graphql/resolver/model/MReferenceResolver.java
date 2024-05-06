package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.MRefListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.MRefTableDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MRefTable;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MReferenceResolver extends X_AD_ReferenceResolver {

	public CompletableFuture<List<MRefList_BH>> AD_Ref_ListList(MReference_BH entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MRefList_BH>> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MRefListDataLoader.DATALOADER_AD_Ref_List_BY_AD_Reference_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getAD_Reference_ID()));
	}

	public CompletableFuture<MRefTable> AD_Ref_Table(MReference_BH entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, MRefTable> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(MRefTableDataLoader.DATALOADER_AD_Ref_Table_BY_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getAD_Reference_ID()));
	}
}
