package org.bandahealth.idempiere.rest.service.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.bandahealth.idempiere.base.model.MDashboardButtonGroup;
import org.bandahealth.idempiere.base.model.MDashboardButtonGroupButton;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.MenuGroupItem;
import org.bandahealth.idempiere.rest.model.MenuGroupLineItem;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.bandahealth.idempiere.rest.utils.ModelUtil;
import org.bandahealth.idempiere.rest.utils.QueryUtil;
import org.bandahealth.idempiere.rest.utils.SqlUtil;
import org.compiere.model.MLanguage;
import org.compiere.model.MRefList;
import org.compiere.model.MRole;
import org.compiere.model.MRoleIncluded;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.Language;

/**
 * Retrieve menu group and line items.
 *
 * @author andrew
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

			Query query = new Query(Env.getCtx(), MDashboardButtonGroup.Table_Name, null, null)
					.setOrderBy(MDashboardButtonGroup.COLUMNNAME_LineNo).setOnlyActiveRecords(true);

			// get total count without pagination parameters
			pagingInfo.setTotalRecordCount(query.count());

			// set pagination params
			query = query.setPage(pagingInfo.getPageSize(), pagingInfo.getPage());
			List<MDashboardButtonGroup> menus = query.list();

			boolean isAdmin = hasAdminPrivileges(getRoleId());

			if (!menus.isEmpty()) {
				for (MDashboardButtonGroup menu : menus) {
					List<MenuGroupLineItem> groupLineItems = getMenuGroupLineItems(menu.get_ID(), isAdmin);
					if (groupLineItems != null && !groupLineItems.isEmpty()) {
						results.add(new MenuGroupItem(menu.getAD_Client_ID(), menu.getAD_Org_ID(),
								menu.getBH_DbrdBtnGrp_UU(), menu.isActive(), DateUtil.parse(menu.getCreated()),
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
			String whereClause = MDashboardButtonGroup.COLUMNNAME_BH_DbrdBtnGrp_UU + "=?";
			MDashboardButtonGroup menu = new Query(Env.getCtx(), MDashboardButtonGroup.Table_Name, whereClause, null)
					.setOrderBy(MDashboardButtonGroup.COLUMNNAME_LineNo).setOnlyActiveRecords(true).setParameters(uuid)
					.first();

			if (menu != null) {
				List<MenuGroupLineItem> items = getMenuGroupLineItems(menu.get_ID(), hasAdminPrivileges(getRoleId()));
				if (items != null && !items.isEmpty()) {
					return new MenuGroupItem(menu.getAD_Client_ID(), menu.getAD_Org_ID(), menu.getBH_DbrdBtnGrp_UU(),
							menu.isActive(), DateUtil.parse(menu.getCreated()), menu.getCreatedBy(), menu.getName(),
							menu.getDescription(), menu.getLineNo(), items);
				}
			}
		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}

	public boolean hasAccessToReports() {
		// Retrieve Reports Menu
		MDashboardButtonGroup menu = new Query(Env.getCtx(), MDashboardButtonGroup.Table_Name,
				MDashboardButtonGroup.COLUMNNAME_Name + "=?", null).setOrderBy(MDashboardButtonGroup.COLUMNNAME_LineNo)
						.setOnlyActiveRecords(true).setParameters("Reports").first();
		if (menu == null) {
			return false;
		}

		// Get reports
		List<MDashboardButtonGroupButton> reports = getMenuGroupLineItems(menu.get_ID(),
				hasAdminPrivileges(getRoleId()), null);
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

		List<MDashboardButtonGroupButton> menuItems = getMenuGroupLineItems(menuGroupItemId, isAdmin,
				"'Metrics', " + "'Reports'");

		if (!menuItems.isEmpty()) {
			for (MDashboardButtonGroupButton menuItem : menuItems) {
				results.add(new MenuGroupLineItem(menuItem.getAD_Client_ID(), menuItem.getAD_Org_ID(),
						menuItem.getBH_DbrdBtnGrp_Btn_UU(), menuItem.isActive(), DateUtil.parse(menuItem.getCreated()),
						menuItem.getCreatedBy(), menuItem.getName(), menuItem.getDescription(),
						menuItem.getAD_InfoWindow_ID(), menuItem.getAD_Window_ID(), menuItem.getAD_Process_ID(),
						menuItem.getAD_Form_ID(), menuItem.getIncludedRole_ID(), menuItem.getLineNo(),
						menuItem.getButtonText(), menuItem.getIconClassName(), menuItem.getButtonClassName()));
			}
		}

		return results;
	}

	private List<MDashboardButtonGroupButton> getMenuGroupLineItems(int menuGroupItemId, boolean isAdmin,
			String exclude) {
		try {
			List<Object> parameters = new ArrayList<>();

			StringBuilder whereClause = new StringBuilder();
			if (menuGroupItemId > 0) {
				whereClause = new StringBuilder(MDashboardButtonGroupButton.Table_Name + "."
						+ MDashboardButtonGroupButton.COLUMNNAME_BH_DbrdBtnGrp_ID).append(" =?");
				parameters.add(menuGroupItemId);
			} else {
				// filter out metrics and reports by default
				whereClause.append(MDashboardButtonGroup.Table_Name + "." + MDashboardButtonGroup.COLUMNNAME_Name);

				if (exclude != null) {
					whereClause.append(" NOT IN (").append(exclude).append(")");
				}
			}
			Query query = new Query(Env.getCtx(), MDashboardButtonGroupButton.Table_Name, whereClause.toString(), null)
					.setOnlyActiveRecords(true).setOrderBy(MDashboardButtonGroupButton.Table_Name + "."
							+ MDashboardButtonGroupButton.COLUMNNAME_LineNo);

			// join MDashboardButtonGroup Table
			query = query.addJoinClause(" JOIN " + MDashboardButtonGroup.Table_Name + " ON "
					+ MDashboardButtonGroupButton.Table_Name + "."
					+ MDashboardButtonGroupButton.COLUMNNAME_BH_DbrdBtnGrp_ID + "=" + MDashboardButtonGroup.Table_Name
					+ "." + MDashboardButtonGroup.COLUMNNAME_BH_DbrdBtnGrp_ID);

			if (parameters.size() > 0) {
				query = query.setParameters(parameters);
			}

			List<MDashboardButtonGroupButton> dashboardButtonGroupButtons = query.list();

			MRole role = MRole.get(Env.getCtx(), Env.getAD_Role_ID(Env.getCtx()));
			dashboardButtonGroupButtons = dashboardButtonGroupButtons.stream()
					.filter(button -> role.getWindowAccess(button.getAD_Window_ID()) != null)
					.collect(Collectors.toList());
			if (!Language.isBaseLanguage(Env.getAD_Language(Env.getCtx()))) {
				Map<Integer, MDashboardButtonGroupButton> dashboardButtonGroupButtonMap = dashboardButtonGroupButtons
						.stream()
						.collect(Collectors.toMap(MDashboardButtonGroupButton::getBH_DbrdBtnGrp_Btn_ID, v -> v));

				// Setup translation fetching SQL
				List<Object> translationParameters = new ArrayList<>();
				String translationWhereClause = QueryUtil.getWhereClauseAndSetParametersForSet(
						dashboardButtonGroupButtons.stream().map(MDashboardButtonGroupButton::getBH_DbrdBtnGrp_Btn_ID)
								.collect(Collectors.toSet()),
						translationParameters);
				String sql = "SELECT " + MDashboardButtonGroupButton.COLUMNNAME_BH_DbrdBtnGrp_Btn_ID + ","
						+ MDashboardButtonGroupButton.COLUMNNAME_Name + ","
						+ MDashboardButtonGroupButton.COLUMNNAME_Description + ","
						+ MDashboardButtonGroupButton.COLUMNNAME_ButtonText + ","
						+ MDashboardButtonGroupButton.COLUMNNAME_ButtonHelpText + " FROM "
						+ MDashboardButtonGroupButton.Table_Name + "_Trl WHERE "
						+ MDashboardButtonGroupButton.COLUMNNAME_BH_DbrdBtnGrp_Btn_ID + " IN(" + translationWhereClause
						+ ")" + " AND " + MLanguage.COLUMNNAME_AD_Language + "=?";
				translationParameters.add(Env.getLanguage(Env.getCtx()).getAD_Language());

				SqlUtil.executeQuery(sql, translationParameters, null, resultSet -> {
					try {
						MDashboardButtonGroupButton dashboardButtonGroupButtonToTranslate = dashboardButtonGroupButtonMap
								.get(resultSet.getInt(1));
						ModelUtil.setPropertyIfPresent(resultSet.getString(2),
								dashboardButtonGroupButtonToTranslate::setName);
						ModelUtil.setPropertyIfPresent(resultSet.getString(3),
								dashboardButtonGroupButtonToTranslate::setDescription);
						ModelUtil.setPropertyIfPresent(resultSet.getString(4),
								dashboardButtonGroupButtonToTranslate::setButtonText);
						ModelUtil.setPropertyIfPresent(resultSet.getString(5),
								dashboardButtonGroupButtonToTranslate::setButtonHelpText);
					} catch (Exception ex) {
						log.warning("Error processing dashboard button group button translations: " + ex.getMessage());
					}
				});
			}
			return dashboardButtonGroupButtons;
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
