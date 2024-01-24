package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_FormDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ProcessDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WindowDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_AssetDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_IssueKnownDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_IssueProjectDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_IssueSystemDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_IssueUserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_RequestDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MAsset;
import org.compiere.model.MForm;
import org.compiere.model.MIssue;
import org.compiere.model.MIssueProject;
import org.compiere.model.MIssueSystem;
import org.compiere.model.MIssueUser;
import org.compiere.model.MRequest;
import org.compiere.model.MWindow;
import org.compiere.model.X_R_IssueKnown;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Issue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_IssueResolver extends POResolver<MIssue> implements GraphQLResolver<MIssue> {



	/**
	 * Get Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	public CompletableFuture<MAsset> A_Asset(MIssue entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAsset> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_AssetDataLoader.DATALOADER_A_Asset_BY_ID);
		return dataLoader.load(entity.getA_Asset_ID());
	}


	/**
	 * Get Special Form.
	 *
	 * @return Special Form
	 */
	public CompletableFuture<MForm> AD_Form(MIssue entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Form_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MForm> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_FormDataLoader.DATALOADER_AD_Form_BY_ID);
		return dataLoader.load(entity.getAD_Form_ID());
	}


	/**
	 * Get Process.
	 *
	 * @return Process or Report
	 */
	public CompletableFuture<MProcess_BH> AD_Process(MIssue entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Process_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProcess_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ProcessDataLoader.DATALOADER_AD_Process_BY_ID);
		return dataLoader.load(entity.getAD_Process_ID());
	}


	/**
	 * Get Window.
	 *
	 * @return Data entry or display window
	 */
	public CompletableFuture<MWindow> AD_Window(MIssue entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Window_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MWindow> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WindowDataLoader.DATALOADER_AD_Window_BY_ID);
		return dataLoader.load(entity.getAD_Window_ID());
	}

	static Map<String, String> ISREPRODUCIBLE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Y", "44077eb2-6028-4a65-b270-bcc3c15ef1e5");
			put("N", "41aaf35b-62b5-4872-b159-89257acb66db");
		}
	};
	public CompletableFuture<MRefList_BH> IsReproducible(MIssue entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getIsReproducible())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ISREPRODUCIBLE_UUIDS_BY_VALUE.get(entity.getIsReproducible()));
	}

	static Map<String, String> ISSUESOURCE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("W", "50032107-b314-40a1-ae3a-809f3e643572");
			put("T", "df7f040f-75dd-4025-947e-34479cf8811b");
			put("F", "9a71d7fd-585b-4896-a454-9b823d2ae291");
			put("P", "172a85d0-4f69-4486-9f95-bfd30c092519");
			put("R", "e3f9a66b-72b1-4552-9c6a-ff27de1cb83c");
			put("X", "96201326-b894-4f80-a572-ccac1d7dd878");
			put("B", "df913f43-3e3b-45bc-9d03-26e0d506f9f3");
			put("I", "5484a32f-202c-4316-9ae7-c295ed508aee");
			put("D", "c08370ea-385c-4569-bc28-1b6a869f700a");
		}
	};
	public CompletableFuture<MRefList_BH> IssueSource(MIssue entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getIssueSource())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ISSUESOURCE_UUIDS_BY_VALUE.get(entity.getIssueSource()));
	}

	static Map<String, String> ISVANILLASYSTEM_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Y", "44077eb2-6028-4a65-b270-bcc3c15ef1e5");
			put("N", "41aaf35b-62b5-4872-b159-89257acb66db");
		}
	};
	public CompletableFuture<MRefList_BH> IsVanillaSystem(MIssue entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getIsVanillaSystem())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ISVANILLASYSTEM_UUIDS_BY_VALUE.get(entity.getIsVanillaSystem()));
	}

	public Boolean Processed(MIssue entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(MIssue entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}


	/**
	 * Get Known Issue.
	 *
	 * @return Known Issue
	 */
	public CompletableFuture<X_R_IssueKnown> R_IssueKnown(MIssue entity, DataFetchingEnvironment environment) {
		if (entity.getR_IssueKnown_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_R_IssueKnown> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_R_IssueKnownDataLoader.DATALOADER_R_IssueKnown_BY_ID);
		return dataLoader.load(entity.getR_IssueKnown_ID());
	}


	/**
	 * Get Issue Project.
	 *
	 * @return Implementation Projects
	 */
	public CompletableFuture<MIssueProject> R_IssueProject(MIssue entity, DataFetchingEnvironment environment) {
		if (entity.getR_IssueProject_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MIssueProject> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_R_IssueProjectDataLoader.DATALOADER_R_IssueProject_BY_ID);
		return dataLoader.load(entity.getR_IssueProject_ID());
	}


	/**
	 * Get Issue System.
	 *
	 * @return System creating the issue
	 */
	public CompletableFuture<MIssueSystem> R_IssueSystem(MIssue entity, DataFetchingEnvironment environment) {
		if (entity.getR_IssueSystem_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MIssueSystem> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_R_IssueSystemDataLoader.DATALOADER_R_IssueSystem_BY_ID);
		return dataLoader.load(entity.getR_IssueSystem_ID());
	}


	/**
	 * Get IssueUser.
	 *
	 * @return User who reported issues
	 */
	public CompletableFuture<MIssueUser> R_IssueUser(MIssue entity, DataFetchingEnvironment environment) {
		if (entity.getR_IssueUser_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MIssueUser> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_R_IssueUserDataLoader.DATALOADER_R_IssueUser_BY_ID);
		return dataLoader.load(entity.getR_IssueUser_ID());
	}


	/**
	 * Get Request.
	 *
	 * @return Request from a Business Partner or Prospect
	 */
	public CompletableFuture<MRequest> R_Request(MIssue entity, DataFetchingEnvironment environment) {
		if (entity.getR_Request_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MRequest> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_R_RequestDataLoader.DATALOADER_R_Request_BY_ID);
		return dataLoader.load(entity.getR_Request_ID());
	}

	static Map<String, String> SYSTEMSTATUS_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("E", "80ee3010-2e49-4aa8-934e-2c5662b1b70d");
			put("I", "d3239ec8-bbdc-42c3-997b-c3be8d89d914");
			put("P", "1b3201b9-d2a4-4101-a4a0-a53571550f32");
		}
	};
	public CompletableFuture<MRefList_BH> SystemStatus(MIssue entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getSystemStatus())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(SYSTEMSTATUS_UUIDS_BY_VALUE.get(entity.getSystemStatus()));
	}

}
