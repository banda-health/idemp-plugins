package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.bandahealth.idempiere.base.model.MMenu_BH;
import org.bandahealth.idempiere.rest.function.VoidFunction;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.Menu;
import org.bandahealth.idempiere.rest.model.Paging;
import org.compiere.model.MProcess;
import org.compiere.model.MRole;
import org.compiere.model.MTree_NodeMM;
import org.compiere.model.MWindow;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MenuDBService extends BaseDBService<Menu, MMenu_BH> {

	@Autowired
	private WindowDBService windowDBService;

	@Autowired
	private ProcessDBService processDBService;

	private final String GREENLIGHT_MENU_UUID = "bb0670c5-0dc1-468a-8b85-a91b15407368";
	private final String ERROR_NO_MENU = "Greenlight Menu Tree not found.";
	private final String REPORTS_MENU_NAME = "Reports"; // does this change with translations?
	private final String ERROR_NO_REPORTS = "No reports found..";

	public BaseListResponse<Menu> getAll(Paging pagingInfo, String sortJson, String filterJson) {

		// get root menu
		MMenu_BH greenlightMenu = getRootMenu();
		if (greenlightMenu == null) {
			return null;
		}

		MRole role = MRole.get(Env.getCtx(), Env.getAD_Role_ID(Env.getCtx()));

		// fetch all menus under the greenlight menu "tree"..
		List<Menu> menus = getSubMenus(greenlightMenu.get_ID(), null, role, null);
		menus.stream().forEach(menu -> {
			menu.setSubMenus(getSubMenus(menu.getId(), menu.isShowOnUIMenu(), role, null));
		});

		// get total count
		pagingInfo.setTotalRecordCount(menus.size());

		return new BaseListResponse<Menu>(menus, pagingInfo);
	}

	private MMenu_BH getRootMenu() {
		// get greenlight menu id
		MMenu_BH greenlightMenu = new Query(Env.getCtx(), MMenu_BH.Table_Name, MMenu_BH.COLUMNNAME_AD_Menu_UU + " =?",
				null).setParameters(GREENLIGHT_MENU_UUID).first();
		if (greenlightMenu == null) {
			log.severe(ERROR_NO_MENU);
			return null;
		}

		return greenlightMenu;
	}

	/*
	 * Retrieve menus and sub menus below it.
	 */
	private List<Menu> getSubMenus(Integer parentId, Boolean showUI, MRole role, String searchName) {
		StringBuilder whereClause = new StringBuilder();
		StringBuilder joinClause = new StringBuilder();
		List<Object> parameters = new ArrayList<>();

		whereClause.append(MMenu_BH.Table_Name + "." + MMenu_BH.COLUMNNAME_IsActive + " =?");
		whereClause.append(" AND " + MTree_NodeMM.Table_Name + "." + MTree_NodeMM.COLUMNNAME_Parent_ID + " =? ");

		joinClause.append(" JOIN " + MTree_NodeMM.Table_Name + " ON " + MMenu_BH.Table_Name + "."
				+ MMenu_BH.COLUMNNAME_AD_Menu_ID);
		joinClause.append(" = " + MTree_NodeMM.Table_Name + "." + MTree_NodeMM.COLUMNNAME_Node_ID);

		parameters.add("Y");
		parameters.add(parentId);
		if (showUI != null) {
			whereClause.append(" AND " + MMenu_BH.Table_Name + "." + MMenu_BH.COLUMNNAME_ShowOnUIMenu + " =? ");
			parameters.add(showUI ? "Y" : "N");
		}

		if (searchName != null) {
			whereClause.append(" AND " + MMenu_BH.Table_Name + "." + MMenu_BH.COLUMNNAME_Name + " =? ");
			parameters.add(searchName);
		}

		Query query = new Query(Env.getCtx(), MMenu_BH.Table_Name, whereClause.toString(), null)
				.setParameters(parameters).addJoinClause(joinClause.toString())
				.setOrderBy("ORDER BY " + MTree_NodeMM.Table_Name + "." + MTree_NodeMM.COLUMNNAME_SeqNo);

		List<MMenu_BH> results = query.list();

		List<Menu> menus = transformData(results);

		if (role != null) {
			// don't filter menu groups since they may not have window and process IDs.
			menus = menus.stream()
					.filter(menu -> menu.getWindowId() == null
							|| (menu.getWindowId() > 0 && role.getWindowAccess(menu.getWindowId()) != null))
					.filter(menu -> menu.getProcessId() == null
							|| (menu.getProcessId() > 0 && role.getProcessAccess(menu.getProcessId()) != null))
					.collect(Collectors.toList());
		}

		menus.stream().forEach(menu -> {
			menu.setSubMenus(getSubMenus(menu.getId(), menu.isShowOnUIMenu(), role, null));
		});

		return menus;
	}

	public List<Menu> getReports(MRole userRole) {
		// get root menu
		MMenu_BH greenlightMenu = getRootMenu();
		if (greenlightMenu == null) {
			return null;
		}

		List<Menu> results = getSubMenus(greenlightMenu.get_ID(), null, userRole, REPORTS_MENU_NAME);
		if (results.isEmpty()) {
			log.severe(ERROR_NO_REPORTS);
			return null;
		}

		return results.get(0).getSubMenus(); // return report processes and not the report menu
	}

	@Override
	public List<Menu> transformData(List<MMenu_BH> dbModels) {
		List<Menu> results = new ArrayList<>();
		if (dbModels == null || dbModels.isEmpty()) {
			return results;
		}

		// get menu ids
		Set<Integer> windowIds = dbModels.stream().map(MMenu_BH::getAD_Window_ID).collect(Collectors.toSet());

		// get windows
		Map<Integer, MWindow> windows = windowDBService.getByIds(windowIds);

		// get process ids
		Set<Integer> processIds = dbModels.stream().map(MMenu_BH::getAD_Process_ID).collect(Collectors.toSet());

		// get process
		Map<Integer, MProcess> processes = processDBService.getByIds(processIds);

		// transform data
		dbModels.stream().forEach(model -> {
			MWindow mWindow = model.getAD_Window_ID() > 0 ? windows.get(model.getAD_Window_ID()) : null;

			MProcess mProcess = model.getAD_Process_ID() > 0 ? processes.get(model.getAD_Process_ID()) : null;

			results.add(new Menu(model, mWindow, mProcess));
		});

		return results;
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
		return new Menu(instance, null, null);
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
