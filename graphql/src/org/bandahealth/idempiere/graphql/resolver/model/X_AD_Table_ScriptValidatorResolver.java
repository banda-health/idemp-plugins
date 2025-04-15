package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_RuleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TableDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MRule;
import org.compiere.model.MTable;
import org.compiere.model.MTableScriptValidator;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Table_ScriptValidator - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_Table_ScriptValidatorResolver extends POResolver<MTableScriptValidator> implements GraphQLResolver<MTableScriptValidator> {



	/**
	 * Get Rule.
	 *
	 * @return Rule
	 */
	public CompletableFuture<MRule> AD_Rule(MTableScriptValidator entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Rule_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MRule> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_RuleDataLoader.DATALOADER_AD_Rule_BY_ID);
		return dataLoader.load(entity.getAD_Rule_ID());
	}


	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	public CompletableFuture<MTable> AD_Table(MTableScriptValidator entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Table_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MTable> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TableDataLoader.DATALOADER_AD_Table_BY_ID);
		return dataLoader.load(entity.getAD_Table_ID());
	}

	public static Map<String, String> EVENTMODELVALIDATOR_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("TBN", "07b24a37-d4c4-4ab7-a13a-f74de22114b2"); // Table Before New
			put("TBC", "9bc96112-8ecc-4a2f-8dc9-0fd64a950816"); // Table Before Change
			put("TBD", "195ca2b2-2e84-4c98-9088-87d5fcf4b085"); // Table Before Delete
			put("TAN", "40940b20-0d07-4438-9884-b98a4b9d02b5"); // Table After New
			put("TAC", "0dda34af-9bc2-402e-90d0-b11e3fa0051f"); // Table After Change
			put("TAD", "e2fab327-0bb1-4bda-8d06-b9a61b5ba61d"); // Table After Delete
			put("DBPR", "46fb7a3f-f244-45e9-a62a-4d65e2ad8514"); // Document Before Prepare
			put("DBVO", "90ae09ec-e5b5-4595-8e9a-30e94bb75cb2"); // Document Before Void
			put("DBCL", "d665179a-4de0-43a3-9c35-31ff1df33284"); // Document Before Close
			put("DBAC", "b8819262-7f59-4a1f-9ff2-ecff5c5d2b56"); // Document Before Reactivate
			put("DBRC", "426769c8-050f-40ef-b5a6-ea1983fa6368"); // Document Before Reverse Correct
			put("DBRA", "caf4572c-477a-4288-b118-a87b1b030abc"); // Document Before Reverse Accrual
			put("DBCO", "4e09ab62-78e1-405b-8ace-b13e65a9c657"); // Document Before Complete
			put("DBPO", "dfd93bfe-8183-483b-b77c-7990bd1e1537"); // Document Before Post
			put("DAPR", "31a00c1c-0d9c-4fc5-b9ed-f699abe7284b"); // Document After Prepare
			put("DAVO", "c02a1905-3728-4324-8d4b-2e61ff100371"); // Document After Void
			put("DACL", "28ebb981-3f08-4f02-80f5-35db958d4ada"); // Document After Close
			put("DAAC", "4fa16164-a971-4e9f-a3b3-b07f945161a6"); // Document After Reactivate
			put("DARC", "4b474a30-ee50-4d0c-bd2f-2f8ab78a4db4"); // Document After Reverse Correct
			put("DARA", "8890d644-6706-4cfd-aaa3-4fa92b3b8ccc"); // Document After Reverse Accrual
			put("DACO", "069c3cd7-ae5a-4142-a59b-6e91398cd54f"); // Document After Complete
			put("DAPO", "15610c7e-eb20-491a-b8f5-9e8c6a097664"); // Document After Post
			put("TANR", "3f29d1ba-6440-4057-8da2-31b5dea6fdc3"); // Table After New Replication
			put("TACR", "70de3624-9aa2-46c7-9dd3-ad93b0934e0f"); // Table After Change Replication
			put("TBDR", "dce2402b-8bc0-430f-b6f3-0b01363aceed"); // Table Before Delete Replication
		}
	};
	public CompletableFuture<MRefList_BH> EventModelValidator(MTableScriptValidator entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getEventModelValidator())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(EVENTMODELVALIDATOR_UUIDS_BY_VALUE.get(entity.getEventModelValidator()));
	}

}
