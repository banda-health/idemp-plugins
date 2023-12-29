package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MCtxHelp;
import org.compiere.model.MRefList;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_CtxHelp - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_CtxHelpResolver extends POResolver<MCtxHelp> implements GraphQLResolver<MCtxHelp> {


	static Map<String, String> CTXTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(MCtxHelp.CTXTYPE_Tab, "9f05baa2-95a5-4dd8-8e98-325d3a99ed8a");
			put(MCtxHelp.CTXTYPE_Process, "23ad31bb-d366-462c-a8ac-d6b4f7b8698c");
			put(MCtxHelp.CTXTYPE_Form, "20d41f7f-b9d9-4167-b08f-21961f12a046");
			put(MCtxHelp.CTXTYPE_Info, "fda43bed-c524-4266-b4a5-bd1b994f6d9d");
			put(MCtxHelp.CTXTYPE_Workflow, "cf5c0d72-f4fd-471f-883a-f9bcf8a3f27d");
			put(MCtxHelp.CTXTYPE_Task, "8cc9dcb5-3b44-40b7-a179-e08c5ee148e7");
			put(MCtxHelp.CTXTYPE_Home, "6a1f4225-4625-48a0-8272-4fcb9f9739bb");
			put(MCtxHelp.CTXTYPE_All, "298064ff-6e69-435f-aa0e-d156375339f5");
			put(MCtxHelp.CTXTYPE_Node, "daeadda1-f591-4efe-92dc-9693b5fe2826");
		}
	};
	public CompletableFuture<MRefList> CtxType_RL(MCtxHelp entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getCtxType())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(CTXTYPE_UUIDS_BY_VALUE.get(entity.getCtxType()));
	}

}
