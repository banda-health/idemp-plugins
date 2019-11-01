package org.bandahealth.idempiere.rest.service.db;

import java.util.ArrayList;
import java.util.List;

import org.bandahealth.idempiere.base.model.MHomeScreenButton;
import org.bandahealth.idempiere.base.model.MHomeScreenButtonGroup;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.MenuGroupItem;
import org.bandahealth.idempiere.rest.model.MenuGroupLineItem;
import org.bandahealth.idempiere.rest.model.Paging;
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

	/**
	 * Get group items
	 * 
	 * @param pagingInfo
	 * @return
	 */
	public BaseListResponse<MenuGroupItem> getMenuGroupItems(Paging pagingInfo) {
		try {
			List<MenuGroupItem> results = new ArrayList<>();

			Query query = new Query(Env.getCtx(), MHomeScreenButtonGroup.Table_Name, null, null).setClient_ID()
					.setOrderBy(MHomeScreenButtonGroup.COLUMNNAME_LineNo).setOnlyActiveRecords(true);

			// get total count without pagination parameters
			pagingInfo.setTotalRecordCount(query.count());

			// set pagination params
			query = query.setPage(pagingInfo.getPageSize(), pagingInfo.getPage());
			List<MHomeScreenButtonGroup> menus = query.list();

			if (!menus.isEmpty()) {
				for (MHomeScreenButtonGroup menu : menus) {
					results.add(new MenuGroupItem(menu.getAD_Client_ID(), menu.getAD_Org_ID(),
							menu.getBH_HmScrn_ButtonGroup_UU(), menu.isActive(), menu.getCreated(), menu.getCreatedBy(),
							menu.getName(), menu.getDescription(), menu.getLineNo(),
							getMenuGroupLineItems(menu.get_ID())));
				}
			}

			return new BaseListResponse<MenuGroupItem>(results, pagingInfo);

		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}

	public MenuGroupItem getMenuGroupItem(String uuid) {
		try {
			String whereClause = MHomeScreenButtonGroup.COLUMNNAME_BH_HmScrn_ButtonGroup_UU + "=?";
			MHomeScreenButtonGroup menu = new Query(Env.getCtx(), MHomeScreenButtonGroup.Table_Name, whereClause, null)
					.setClient_ID().setOrderBy(MHomeScreenButtonGroup.COLUMNNAME_LineNo).setOnlyActiveRecords(true)
					.setParameters(uuid).first();

			if (menu != null) {
				return new MenuGroupItem(menu.getAD_Client_ID(), menu.getAD_Org_ID(),
						menu.getBH_HmScrn_ButtonGroup_UU(), menu.isActive(), menu.getCreated(), menu.getCreatedBy(),
						menu.getName(), menu.getDescription(), menu.getLineNo(), getMenuGroupLineItems(menu.get_ID()));
			}
		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}

	/**
	 * Get group line items
	 * 
	 * @param menuGroupItemId
	 * @return
	 */
	private List<MenuGroupLineItem> getMenuGroupLineItems(int menuGroupItemId) {
		try {
			List<MenuGroupLineItem> results = new ArrayList<>();

			String whereClause = MHomeScreenButton.COLUMNNAME_BH_HmScrn_ButtonGroup_ID + "=?";
			Query query = new Query(Env.getCtx(), MHomeScreenButton.Table_Name, whereClause, null)
					.setParameters(menuGroupItemId).setClient_ID().setOrderBy(MHomeScreenButton.COLUMNNAME_LineNo)
					.setOnlyActiveRecords(true);

			List<MHomeScreenButton> menuItems = query.list();

			if (!menuItems.isEmpty()) {
				for (MHomeScreenButton menuItem : menuItems) {
					results.add(new MenuGroupLineItem(menuItem.getAD_Client_ID(), menuItem.getAD_Org_ID(),
							menuItem.getBH_HmScrn_ButtonGroupLine_UU(), menuItem.isActive(), menuItem.getCreated(),
							menuItem.getCreatedBy(), menuItem.getName(), menuItem.getDescription(),
							menuItem.getAD_InfoWindow_ID(), menuItem.getAD_Window_ID(), menuItem.getAD_Process_ID(),
							menuItem.getAD_Form_ID(), menuItem.getIncludedRole_ID(), menuItem.getLineNo(),
							menuItem.getButtonText()));
				}
			}

			return results;

		} catch (Exception ex) {
			log.severe(ex.getMessage());
		}

		return null;
	}
}
