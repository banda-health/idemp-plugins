package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MMenu_BH;
import org.bandahealth.idempiere.base.model.MMessage_BH;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_EntityTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_FormDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ImpFormatDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_InfoWindowDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_MenuDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_MessageDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ModelValidatorDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Package_ExpDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintFormatDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ProcessDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ReferenceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ReportViewDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_RoleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TableDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Val_RuleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WindowDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WorkbenchDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WorkflowDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.MForm;
import org.compiere.model.MInfoWindow;
import org.compiere.model.MPackageExp;
import org.compiere.model.MPackageExpDetail;
import org.compiere.model.MReportView;
import org.compiere.model.MTable;
import org.compiere.model.MValRule;
import org.compiere.model.MWindow;
import org.compiere.model.X_AD_ImpFormat;
import org.compiere.model.X_AD_ModelValidator;
import org.compiere.model.X_AD_PrintFormat;
import org.compiere.model.X_AD_Role;
import org.compiere.model.X_AD_Workbench;
import org.compiere.model.X_AD_Workflow;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Package_Exp_Detail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Package_Exp_DetailResolver extends POResolver<MPackageExpDetail> implements GraphQLResolver<MPackageExpDetail> {



	/**
	 * Get Entity Type.
	 *
	 * @return System Entity Type
	 */
	public CompletableFuture<MEntityType> AD_EntityType(MPackageExpDetail entity, DataFetchingEnvironment environment) {
		if (entity.getAD_EntityType_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MEntityType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_EntityTypeDataLoader.DATALOADER_AD_EntityType_BY_ID);
		return dataLoader.load(entity.getAD_EntityType_ID());
	}


	/**
	 * Get Special Form.
	 *
	 * @return Special Form
	 */
	public CompletableFuture<MForm> AD_Form(MPackageExpDetail entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Form_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MForm> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_FormDataLoader.DATALOADER_AD_Form_BY_ID);
		return dataLoader.load(entity.getAD_Form_ID());
	}


	/**
	 * Get Import Format.
	 *
	 * @return Import Format
	 */
	public CompletableFuture<X_AD_ImpFormat> AD_ImpFormat(MPackageExpDetail entity, DataFetchingEnvironment environment) {
		if (entity.getAD_ImpFormat_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_ImpFormat> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ImpFormatDataLoader.DATALOADER_AD_ImpFormat_BY_ID);
		return dataLoader.load(entity.getAD_ImpFormat_ID());
	}


	/**
	 * Get Info Window.
	 *
	 * @return Info and search/select Window
	 */
	public CompletableFuture<MInfoWindow> AD_InfoWindow(MPackageExpDetail entity, DataFetchingEnvironment environment) {
		if (entity.getAD_InfoWindow_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInfoWindow> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_InfoWindowDataLoader.DATALOADER_AD_InfoWindow_BY_ID);
		return dataLoader.load(entity.getAD_InfoWindow_ID());
	}


	/**
	 * Get Menu.
	 *
	 * @return Identifies a Menu
	 */
	public CompletableFuture<MMenu_BH> AD_Menu(MPackageExpDetail entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Menu_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MMenu_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_MenuDataLoader.DATALOADER_AD_Menu_BY_ID);
		return dataLoader.load(entity.getAD_Menu_ID());
	}


	/**
	 * Get Message.
	 *
	 * @return System Message
	 */
	public CompletableFuture<MMessage_BH> AD_Message(MPackageExpDetail entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Message_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MMessage_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_MessageDataLoader.DATALOADER_AD_Message_BY_ID);
		return dataLoader.load(entity.getAD_Message_ID());
	}


	/**
	 * Get Model Validator.
	 *
	 * @return Model Validator
	 */
	public CompletableFuture<X_AD_ModelValidator> AD_ModelValidator(MPackageExpDetail entity, DataFetchingEnvironment environment) {
		if (entity.getAD_ModelValidator_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_ModelValidator> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ModelValidatorDataLoader.DATALOADER_AD_ModelValidator_BY_ID);
		return dataLoader.load(entity.getAD_ModelValidator_ID());
	}


	/**
	 * Get Package Exp..
	 *
	 * @return Package Exp.
	 */
	public CompletableFuture<MPackageExp> AD_Package_Exp(MPackageExpDetail entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Package_Exp_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPackageExp> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Package_ExpDataLoader.DATALOADER_AD_Package_Exp_BY_ID);
		return dataLoader.load(entity.getAD_Package_Exp_ID());
	}


	/**
	 * Get Print Format.
	 *
	 * @return Data Print Format
	 */
	public CompletableFuture<X_AD_PrintFormat> AD_PrintFormat(MPackageExpDetail entity, DataFetchingEnvironment environment) {
		if (entity.getAD_PrintFormat_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintFormat> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintFormatDataLoader.DATALOADER_AD_PrintFormat_BY_ID);
		return dataLoader.load(entity.getAD_PrintFormat_ID());
	}


	/**
	 * Get Process.
	 *
	 * @return Process or Report
	 */
	public CompletableFuture<MProcess_BH> AD_Process(MPackageExpDetail entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Process_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProcess_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ProcessDataLoader.DATALOADER_AD_Process_BY_ID);
		return dataLoader.load(entity.getAD_Process_ID());
	}


	/**
	 * Get Reference.
	 *
	 * @return System Reference and Validation
	 */
	public CompletableFuture<MReference_BH> AD_Reference(MPackageExpDetail entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Reference_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MReference_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ReferenceDataLoader.DATALOADER_AD_Reference_BY_ID);
		return dataLoader.load(entity.getAD_Reference_ID());
	}


	/**
	 * Get Report View.
	 *
	 * @return View used to generate this report
	 */
	public CompletableFuture<MReportView> AD_ReportView(MPackageExpDetail entity, DataFetchingEnvironment environment) {
		if (entity.getAD_ReportView_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MReportView> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ReportViewDataLoader.DATALOADER_AD_ReportView_BY_ID);
		return dataLoader.load(entity.getAD_ReportView_ID());
	}


	/**
	 * Get Role.
	 *
	 * @return Responsibility Role
	 */
	public CompletableFuture<X_AD_Role> AD_Role(MPackageExpDetail entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Role_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_Role> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_RoleDataLoader.DATALOADER_AD_Role_BY_ID);
		return dataLoader.load(entity.getAD_Role_ID());
	}


	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	public CompletableFuture<MTable> AD_Table(MPackageExpDetail entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Table_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTable> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TableDataLoader.DATALOADER_AD_Table_BY_ID);
		return dataLoader.load(entity.getAD_Table_ID());
	}


	/**
	 * Get Dynamic Validation.
	 *
	 * @return Dynamic Validation Rule
	 */
	public CompletableFuture<MValRule> AD_Val_Rule(MPackageExpDetail entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Val_Rule_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MValRule> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Val_RuleDataLoader.DATALOADER_AD_Val_Rule_BY_ID);
		return dataLoader.load(entity.getAD_Val_Rule_ID());
	}


	/**
	 * Get Window.
	 *
	 * @return Data entry or display window
	 */
	public CompletableFuture<MWindow> AD_Window(MPackageExpDetail entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Window_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MWindow> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WindowDataLoader.DATALOADER_AD_Window_BY_ID);
		return dataLoader.load(entity.getAD_Window_ID());
	}


	/**
	 * Get Workbench.
	 *
	 * @return Collection of windows, reports
	 */
	public CompletableFuture<X_AD_Workbench> AD_Workbench(MPackageExpDetail entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Workbench_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_Workbench> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WorkbenchDataLoader.DATALOADER_AD_Workbench_BY_ID);
		return dataLoader.load(entity.getAD_Workbench_ID());
	}


	/**
	 * Get Workflow.
	 *
	 * @return Workflow or combination of tasks
	 */
	public CompletableFuture<X_AD_Workflow> AD_Workflow(MPackageExpDetail entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Workflow_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_Workflow> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WorkflowDataLoader.DATALOADER_AD_Workflow_BY_ID);
		return dataLoader.load(entity.getAD_Workflow_ID());
	}

	static Map<String, String> DBTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("ALL", "2f54cf12-a78f-4d40-8561-db566c5df12f");
			put("DB2", "38017bf1-7336-4e46-904e-9a1f262156b3");
			put("Firebird", "1d22c56c-d4ea-4f20-92f4-a3a22f07b120");
			put("MySQL", "3b24e285-a892-420e-bb0a-8a89bcd93025");
			put("Oracle", "264365f3-21e1-4c68-a202-86641344c5b4");
			put("Postgres", "ff9d6bf3-c576-40af-b7ed-a0e4baf1b8e3");
			put("SQL", "f2439cba-6556-4eaf-883f-bf1fabde7068");
			put("Sybase", "faa945f1-15c2-44e8-989d-c090eada7615");
		}
	};
	public CompletableFuture<MRefList_BH> DBType(MPackageExpDetail entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDBType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(DBTYPE_UUIDS_BY_VALUE.get(entity.getDBType()));
	}

	public Boolean Processed(MPackageExpDetail entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(MPackageExpDetail entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

	static Map<String, String> RELEASENO_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Release 2.5.2a", "d975e574-2e8e-47db-b541-cd9eb65056d9");
			put("Release 2.5.2b", "cd25b4fe-5dba-44b5-9a9d-39f36a898ac8");
			put("Release 2.5.2c", "78ee505b-f70a-49ad-8fc5-c9e8fe7cffd0");
			put("Release 2.5.2d", "e9ef48ac-4288-4016-bde2-6efbaa764ce5");
			put("Release 2.5.2e", "b6aeb737-b529-4365-a02d-e67588fb1abb");
			put("Release 2.5.3a", "592848cc-9c95-452a-a977-a4980f136740");
			put("Release 2.5.3b", "97d816d9-ecf7-4812-ab18-d14868a3af36");
			put("all", "b4557873-6a91-4219-b37c-295f62f1eb1e");
			put("Release 3.1.0", "02a67c21-a1ce-4943-a356-121fa3fd1c41");
			put("Release 3.2.0", "5046d1f5-6961-4c28-98ed-aebcde52f1a4");
			put("Release 3.3.0", "e2f98be7-ed36-4b40-b678-a957793ee8e4");
		}
	};
	public CompletableFuture<MRefList_BH> ReleaseNo(MPackageExpDetail entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getReleaseNo())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(RELEASENO_UUIDS_BY_VALUE.get(entity.getReleaseNo()));
	}

	static Map<String, String> TYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("B", "a35c0eb5-e62e-4c31-8757-7c0f448458b6");
			put("C", "0a0c196e-7b95-4765-b1f9-ff2a18fbe6bb");
			put("D", "97f11708-c94c-4314-8967-204989224832");
			put("F", "84a42d1d-fb1b-42e2-b658-0e9d005601e8");
			put("IMP", "b154a444-c4db-4678-a2a7-5948c4b8c302");
			put("M", "8991c6f4-dd48-4b9a-8e0f-e5e6537d7a3e");
			put("P", "969caf02-c2a7-4eed-8d77-c9e74e7efe32");
			put("R", "b5a3f1e8-dfde-47f0-8213-bdd4581b4a65");
			put("S", "33b42dff-997b-48d1-ac5f-e121e624fe61");
			put("SNI", "f4c6398e-f40c-46a6-bf94-b5a1818860b0");
			put("SQL", "fd7db47d-3c36-4176-866b-ba069d22ebb0");
			put("T", "ca867fbc-c2bf-44c1-94c3-232397b476ca");
			put("W", "29eadafd-906c-49c7-a22d-098d3f707a47");
			put("X", "66bc4085-92f6-4209-a22f-7abf3dff723e");
			put("V", "f9daf3dd-48f6-4db5-9d2f-ec3ba39ecd9d");
			put("MSG", "300328cf-1bd2-4bc1-a225-4c0933d06588");
			put("PFT", "5415dc1a-1e7f-4ffe-805a-2c5221e2d351");
			put("REF", "df633d27-88d1-4391-b326-2ef81c8d7676");
			put("MV", "59c565aa-99f3-42dd-93d8-4a25b59b09f3");
			put("ET", "19020e49-1e7c-4dea-9957-1f434714c8b3");
			put("SQM", "63605262-3ba3-4140-b839-4e5b0f8ad23d");
			put("IW", "c1e5ee93-987c-43cd-90e9-e4cf5d592105");
			put("DS", "bb6620c6-4cef-4796-90d6-007b83fe213f");
		}
	};
	public CompletableFuture<MRefList_BH> Type(MPackageExpDetail entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(TYPE_UUIDS_BY_VALUE.get(entity.getType()));
	}

}
