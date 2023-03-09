package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MMenu_BH;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.rest.function.VoidFunction;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Menu;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.model.Process;
import org.bandahealth.idempiere.rest.model.Window;
import org.bandahealth.idempiere.rest.utils.QueryUtil;
import org.compiere.model.MProcess;
import org.compiere.model.MRole;
import org.compiere.model.MTree_NodeMM;
import org.compiere.model.MWindow;
import org.compiere.model.Query;
import org.compiere.model.X_AD_TreeNodeMM;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MenuDBService extends BaseDBService<Menu, MMenu_BH> {

	private final String ERROR_NO_MENU = "Greenlight Menu Tree not found.";
	private final String REPORTS_MENU_UUID = "Reports"; // does this change with translations?
	private final String ERROR_NO_REPORTS = "No reports found..";
	@Autowired
	private WindowDBService windowDBService;
	@Autowired
	private ProcessDBService processDBService;

	public BaseListResponse<Menu> getAll(String rootUuid, Paging pagingInfo, String sortJson, String filterJson) {
		MMenu_BH rootMenu = getEntityByUuidFromDB(rootUuid);
		if (rootMenu == null) {
			log.severe("Not menu found for root menu UU " + rootUuid);
			return new BaseListResponse<>(new ArrayList<>(), pagingInfo);
		}
		List<Menu> menus = getAll(rootMenu.get_ID());

		// Arrange menus into their tree
		Map<Integer, Menu> menusById = menus.stream().collect(Collectors.toMap(Menu::getId, menu -> menu));
		Map<Integer, List<Menu>> menusByParentId = menus.stream().collect(Collectors.groupingBy(Menu::getParentId));

		Menu instanceRootMenu = menus.stream().filter(menu -> menu.getId() == rootMenu.get_ID()).findFirst().orElse(null);

		if (instanceRootMenu == null) {
			throw new AdempiereException(ERROR_NO_MENU);
		}

		createMenuTree(instanceRootMenu, menusById, menusByParentId);

		return new BaseListResponse<>(instanceRootMenu.getSubMenus(), pagingInfo);
	}

	public BaseListResponse<Menu> getAll(Paging pagingInfo, String sortJson, String filterJson) {
		return getAll(MMenu_BH.MENUUUID_GREENLIGHT, pagingInfo, sortJson, filterJson);
	}

	private List<Menu> getAll(int rootNodeId) {
		List<X_AD_TreeNodeMM> allMenuTreeNodes = getAllNodesInTree(rootNodeId);

		List<Object> parameters = new ArrayList<>();
		String whereClause = QueryUtil.getWhereClauseAndSetParametersForSet(
				allMenuTreeNodes.stream().map(X_AD_TreeNodeMM::getNode_ID).collect(Collectors.toSet()), parameters);

		BaseListResponse<Menu> menus =
				getAll(MMenu_BH.COLUMNNAME_AD_Menu_ID + " IN (" + whereClause + ")", parameters, Paging.ALL.getInstance(),
						null,
						null);

		Map<Integer, X_AD_TreeNodeMM> nodesByNodeId =
				allMenuTreeNodes.stream().collect(Collectors.toMap(X_AD_TreeNodeMM::getNode_ID, treeNode -> treeNode));

		// The user's role will help determine what the user can/can't see
		MRole role = MRole.get(Env.getCtx(), Env.getAD_Role_ID(Env.getCtx()));
		// Filter out menus the user can't see with their access, plus set parent information
		return menus.getResults().stream().filter(menu -> menu.getWindow() == null ||
				(menu.getWindow().getId() > 0 && role.getWindowAccess(menu.getWindow().getId()) != null)).filter(
				menu -> menu.getProcess() == null ||
						(menu.getProcess().getId() > 0 && role.getProcessAccess(menu.getProcess().getId()) != null)).peek(menu -> {
			if (nodesByNodeId.containsKey(menu.getId())) {
				X_AD_TreeNodeMM menuNode = nodesByNodeId.get(menu.getId());
				menu.setSequenceNumber(menuNode.getSeqNo());
				menu.setParentId(menuNode.getParent_ID());
			}
		}).collect(Collectors.toList());
	}

	private void createMenuTree(Menu menu, Map<Integer, Menu> menusById, Map<Integer, List<Menu>> menusByParentId) {
		// If the user can see it and this node has children, do something with it
		if (menusById.containsKey(menu.getId()) && menusByParentId.containsKey(menu.getId())) {
			// Get the children, but filter out any that aren't in the main list (for whatever reason)
			menu.setSubMenus(
					menusByParentId.get(menu.getId()).stream().filter(childMenu -> menusById.containsKey(childMenu.getId()))
							.peek(childMenu -> createMenuTree(childMenu, menusById, menusByParentId))
							.collect(Collectors.toList()));
		}
	}

	public List<Menu> getReports() {
		MMenu_BH rootMenu = getEntityByUuidFromDB(MMenu_BH.MENUUUID_GREENLIGHT_REPORT_DROPDOWN);
		if (rootMenu == null) {
			throw new AdempiereException(ERROR_NO_REPORTS);
		}
		return getAll(rootMenu.get_ID()).stream().filter(menu -> menu.getProcess() != null && menu.getProcess().getId() > 0)
				.collect(Collectors.toList());
	}

	private List<X_AD_TreeNodeMM> getAllNodesInTree(int rootNodeId) {
		List<X_AD_TreeNodeMM> allNodes = new ArrayList<>();
		List<X_AD_TreeNodeMM> nodesToAdd =
				new Query(Env.getCtx(), X_AD_TreeNodeMM.Table_Name, X_AD_TreeNodeMM.COLUMNNAME_Node_ID + "=?",
						null).setParameters(rootNodeId).list();

		// Continue fetching nodes while there are any
		while (!nodesToAdd.isEmpty()) {
			allNodes.addAll(nodesToAdd);

			List<Object> parameters = new ArrayList<>();
			String whereClause = QueryUtil.getWhereClauseAndSetParametersForSet(
					nodesToAdd.stream().map(X_AD_TreeNodeMM::getNode_ID).collect(Collectors.toSet()), parameters);

			nodesToAdd = new Query(Env.getCtx(), X_AD_TreeNodeMM.Table_Name,
					X_AD_TreeNodeMM.COLUMNNAME_Parent_ID + " IN (" + whereClause + ")", null).setParameters(parameters).list();
		}

		return allNodes;
	}

	@Override
	public List<Menu> transformData(List<MMenu_BH> dbModels) {
		// get menu ids
		Set<Integer> windowIds = dbModels.stream().map(MMenu_BH::getAD_Window_ID).collect(Collectors.toSet());

		// get windows
		Map<Integer, MWindow> windows = windowDBService.getByIds(windowIds);

		// get process ids
		Set<Integer> processIds = dbModels.stream().map(MMenu_BH::getAD_Process_ID).collect(Collectors.toSet());

		// get process
		Map<Integer, MProcess_BH> processes = processDBService.getByIds(processIds);

		// transform data
		return dbModels.stream().map(model -> {
			Menu menu = new Menu(model);

			if (windows.containsKey(model.getAD_Window_ID())) {
				menu.setWindow(new Window(windows.get(model.getAD_Window_ID())));
			}
			if (processes.containsKey(model.getAD_Process_ID())) {
				menu.setProcess(new Process(processes.get(model.getAD_Process_ID()), null));
			}

			return menu;
		}).collect(Collectors.toList());
	}

	@Override
	public Menu saveEntity(Menu entity) {
		return null;
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		return null;
	}

	@Override
	protected Menu createInstanceWithDefaultFields(MMenu_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected Menu createInstanceWithAllFields(MMenu_BH instance) {
		return new Menu(instance);
	}

	@Override
	protected Menu createInstanceWithSearchFields(MMenu_BH instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MMenu_BH getModelInstance() {
		return new MMenu_BH(Env.getCtx(), 0, null);
	}

	@Override
	public boolean isClientIdFromTheContextNeededByDefaultForThisEntity() {
		return false;
	}

	@Override
	protected Map<String, Function<MMenu_BH, VoidFunction<String>>> getColumnsToTranslate() {
		return new HashMap<>() {
			{
				put(MMenu_BH.COLUMNNAME_Name, menu -> menu::setName);
				put(MMenu_BH.COLUMNNAME_Description, menu -> menu::setDescription);
			}
		};
	}
}
