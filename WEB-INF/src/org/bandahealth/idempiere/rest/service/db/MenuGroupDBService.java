package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.List;
import org.bandahealth.idempiere.base.model.MHomeScreenButton;
import org.bandahealth.idempiere.base.model.MHomeScreenButtonGroup;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.MenuGroupItem;
import org.bandahealth.idempiere.rest.model.MenuGroupLineItem;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.compiere.model.MRole;
import org.compiere.model.MRoleIncluded;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.Env;

/**
 * Retrieve menu group and line items.
 * 
 * @author andrew
 *
 */
public class MenuGroupDBService {

	private static CLogger log = CLogger.getCLogger(MenuGroupDBService.class);

	// private Integer roleId = Env.getContextAsInt(Env.getCtx(), "#AD_Role_ID");
	private final String ALL_SUBROLES_INCLUDED = "BandaGo Admin";

	/**
	 * Get group items
	 * 
	 * @param pagingInfo
	 * @return
	 */
	public BaseListResponse<MenuGroupItem> getMenuGroupItems(Paging pagingInfo) {
		try {
			List<MenuGroupItem> results = new ArrayList<>();

			Query query = new Query(Env.getCtx(), MHomeScreenButtonGroup.Table_Name, null, null)
					.setOrderBy(MHomeScreenButtonGroup.COLUMNNAME_LineNo).setOnlyActiveRecords(true);

			// get total count without pagination parameters
			pagingInfo.setTotalRecordCount(query.count());

			// set pagination params
			query = query.setPage(pagingInfo.getPageSize(), pagingInfo.getPage());
			List<MHomeScreenButtonGroup> menus = query.list();

			boolean isAdmin = hasAdminPrivileges(getRoleId());

			if (!menus.isEmpty()) {
				for (MHomeScreenButtonGroup menu : menus) {
					List<MenuGroupLineItem> groupLineItems = getMenuGroupLineItems(menu.get_ID(), isAdmin);
					if (groupLineItems != null && !groupLineItems.isEmpty()) {
						results.add(new MenuGroupItem(menu.getAD_Client_ID(), menu.getAD_Org_ID(),
								menu.getBH_HmScrn_ButtonGroup_UU(), menu.isActive(), DateUtil.parse(menu.getCreated()),
								menu.getCreatedBy(), menu.getName(), menu.getDescription(), menu.getLineNo(),
								groupLineItems));
					}
				}
			}

			return new BaseListResponse<MenuGroupItem>(results, pagingInfo);

		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}

	/**
	 * Retrieve all groupline items for the logged in user.
	 * 
	 * @return
	 */
	public BaseListResponse<MenuGroupLineItem> getMenuGroupLineItems() {
		try {
			// get all items
			return new BaseListResponse<MenuGroupLineItem>(getMenuGroupLineItems(0, hasAdminPrivileges(getRoleId())),
					null);
		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}

	public MenuGroupItem getMenuGroupItem(String uuid) {
		try {
			String whereClause = MHomeScreenButtonGroup.COLUMNNAME_BH_HmScrn_ButtonGroup_UU + "=?";
			MHomeScreenButtonGroup menu = new Query(Env.getCtx(), MHomeScreenButtonGroup.Table_Name, whereClause, null)
					.setOrderBy(MHomeScreenButtonGroup.COLUMNNAME_LineNo).setOnlyActiveRecords(true).setParameters(uuid)
					.first();

			if (menu != null) {
				List<MenuGroupLineItem> items = getMenuGroupLineItems(menu.get_ID(), hasAdminPrivileges(getRoleId()));
				if (items != null && !items.isEmpty()) {
					return new MenuGroupItem(menu.getAD_Client_ID(), menu.getAD_Org_ID(),
							menu.getBH_HmScrn_ButtonGroup_UU(), menu.isActive(), DateUtil.parse(menu.getCreated()),
							menu.getCreatedBy(), menu.getName(), menu.getDescription(), menu.getLineNo(), items);
				}
			}
		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}

	public boolean hasAccessToReports() {
		// Retrieve Reports Menu
		MHomeScreenButtonGroup menu = new Query(Env.getCtx(), MHomeScreenButtonGroup.Table_Name,
				MHomeScreenButtonGroup.COLUMNNAME_Name + "=?", null)
						.setOrderBy(MHomeScreenButtonGroup.COLUMNNAME_LineNo).setOnlyActiveRecords(true)
						.setParameters("Reports").first();
		if (menu == null) {
			return false;
		}

		// Get reports
		List<MHomeScreenButton> reports = getMenuGroupLineItems(menu.get_ID(), hasAdminPrivileges(getRoleId()), null);
		if (!reports.isEmpty()) {
			return true;
		}

		return false;
	}

	/**
	 * Get group line items
	 * 
	 * @param menuGroupItemId
	 * @return
	 */
	private List<MenuGroupLineItem> getMenuGroupLineItems(int menuGroupItemId, boolean isAdmin) {
		List<MenuGroupLineItem> results = new ArrayList<>();

		List<MHomeScreenButton> menuItems = getMenuGroupLineItems(menuGroupItemId, isAdmin, "'Metrics', 'Reports'");

		if (!menuItems.isEmpty()) {
			for (MHomeScreenButton menuItem : menuItems) {
				results.add(new MenuGroupLineItem(menuItem.getAD_Client_ID(), menuItem.getAD_Org_ID(),
						menuItem.getBH_HmScrn_ButtonGroupLine_UU(), menuItem.isActive(),
						DateUtil.parse(menuItem.getCreated()), menuItem.getCreatedBy(), menuItem.getName(),
						menuItem.getDescription(), menuItem.getAD_InfoWindow_ID(), menuItem.getAD_Window_ID(),
						menuItem.getAD_Process_ID(), menuItem.getAD_Form_ID(), menuItem.getIncludedRole_ID(),
						menuItem.getLineNo(), menuItem.getButtonText(), menuItem.getIconClassName(),
						menuItem.getButtonClassName()));
			}
		}

		return results;
	}

	private List<MHomeScreenButton> getMenuGroupLineItems(int menuGroupItemId, boolean isAdmin, String exclude) {
		try {
			List<Object> parameters = new ArrayList<>();

			StringBuilder whereClause = new StringBuilder();
			if (menuGroupItemId > 0) {
				whereClause = new StringBuilder(
						MHomeScreenButton.Table_Name + "." + MHomeScreenButton.COLUMNNAME_BH_HmScrn_ButtonGroup_ID)
								.append(" =?");
				parameters.add(menuGroupItemId);
			} else {
				// filter out metrics and reports by default
				whereClause.append(MHomeScreenButtonGroup.Table_Name + "." + MHomeScreenButtonGroup.COLUMNNAME_Name);

				if (exclude != null) {
					whereClause.append(" NOT IN (").append(exclude).append(")");
				}
			}

			if (!isAdmin) {
				whereClause.append(" AND ");

				whereClause.append(MRoleIncluded.Table_Name + "." + MRoleIncluded.COLUMNNAME_AD_Role_ID + "=?");
				parameters.add(getRoleId());
			}

			Query query = new Query(Env.getCtx(), MHomeScreenButton.Table_Name, whereClause.toString(), null)
					.setOnlyActiveRecords(true)
					.setOrderBy(MHomeScreenButton.Table_Name + "." + MHomeScreenButton.COLUMNNAME_LineNo);

			// join MHomeScreenButtonGroup Table
			query = query.addJoinClause(" JOIN " + MHomeScreenButtonGroup.Table_Name + " ON "
					+ MHomeScreenButton.Table_Name + "." + MHomeScreenButton.COLUMNNAME_BH_HmScrn_ButtonGroup_ID + "="
					+ MHomeScreenButtonGroup.Table_Name + "."
					+ MHomeScreenButtonGroup.COLUMNNAME_BH_HmScrn_ButtonGroup_ID);

			if (!isAdmin) {
				// join Role Table
				query = query.addJoinClause(" JOIN " + MRoleIncluded.Table_Name + " ON " + MHomeScreenButton.Table_Name
						+ "." + MHomeScreenButton.COLUMNNAME_Included_Role_ID + "=" + MRoleIncluded.Table_Name + "."
						+ MRoleIncluded.COLUMNNAME_Included_Role_ID);
			}

			if (parameters.size() > 0) {
				query = query.setParameters(parameters);
			}

			return query.list();

		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}

	private boolean hasAdminPrivileges(int roleId) {
		String whereClause = MRoleIncluded.Table_Name + "." + MRoleIncluded.COLUMNNAME_AD_Role_ID + "= ? AND "
				+ MRole.COLUMNNAME_Name + " = ?";
		Query query = new Query(Env.getCtx(), MRole.Table_Name, whereClause, null).addJoinClause(
				"JOIN " + MRoleIncluded.Table_Name + " ON " + MRole.Table_Name + "." + MRole.COLUMNNAME_AD_Role_ID + "="
						+ MRoleIncluded.Table_Name + "." + MRoleIncluded.COLUMNNAME_Included_Role_ID);

		if (query.setParameters(roleId, ALL_SUBROLES_INCLUDED).match()) {
			return true;
		}

		return false;
	}

	private int getRoleId() {
		return Env.getContextAsInt(Env.getCtx(), "#AD_Role_ID");
	}
}
