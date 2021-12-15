package org.bandahealth.idempiere.rest.service.db;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.bandahealth.idempiere.base.model.MDashboardButtonGroupButton;
import org.bandahealth.idempiere.rest.function.VoidFunction;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.MenuGroupLineItem;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MRole;
import org.compiere.model.MUser;
import org.compiere.model.MWindow;
import org.compiere.util.Env;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Retrieve menu group and line items.
 *
 * @author andrew
 */
@Component
public class MenuGroupDBService extends BaseDBService<MenuGroupLineItem, MDashboardButtonGroupButton> {

	@Autowired
	private WindowDBService windowDBService;

	/**
	 * Retrieve all groupline items for the logged in user.
	 *
	 * @return MenuLineItems
	 */
	public BaseListResponse<MenuGroupLineItem> getAll(Paging pagingInfo, String sortJson, String filterJson) {

		BaseListResponse<MenuGroupLineItem> dashboardButtonGroupButtons = super
				.getAll(MDashboardButtonGroupButton.Table_Name + "." + MDashboardButtonGroupButton.COLUMNNAME_IsActive +
								"='Y'",
						null, pagingInfo, sortJson, filterJson, null);


		MRole role = MRole.get(Env.getCtx(), Env.getAD_Role_ID(Env.getCtx()));
		dashboardButtonGroupButtons.setResults(dashboardButtonGroupButtons.getResults().stream()
				.filter(button -> button.getWindowId() != null && role.getWindowAccess(button.getWindowId()) != null)
				.collect(Collectors.toList()));

		Set<Integer> windowIDs = dashboardButtonGroupButtons.getResults().stream()
				.map(MenuGroupLineItem::getWindowId).collect(Collectors.toSet());
		Map<Integer, MWindow> windows = windowDBService.getByIds(windowIDs);

		dashboardButtonGroupButtons.getResults().forEach(menuGroupLineItem -> {
			if (windows.containsKey(menuGroupLineItem.getWindowId())) {
				menuGroupLineItem.setWindowUuid(windows.get(menuGroupLineItem.getWindowId()).getAD_Window_UU());
			}
		});
		return dashboardButtonGroupButtons;
	}

	@Override
	public MenuGroupLineItem saveEntity(MenuGroupLineItem entity) {
		return null;
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		return null;
	}

	@Override
	protected MenuGroupLineItem createInstanceWithDefaultFields(MDashboardButtonGroupButton instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MenuGroupLineItem createInstanceWithAllFields(MDashboardButtonGroupButton instance) {

		return new MenuGroupLineItem(instance, (MWindow) instance.getAD_Window());
	}

	@Override
	protected MenuGroupLineItem createInstanceWithSearchFields(MDashboardButtonGroupButton instance) {
		return createInstanceWithAllFields(instance);
	}

	@Override
	protected MDashboardButtonGroupButton getModelInstance() {
		return new MDashboardButtonGroupButton(Env.getCtx(), 0, null);
	}

	@Override
	public boolean isClientIdFromTheContextNeededByDefaultForThisEntity() {
		return false;
	}

	@Override
	protected Map<String, Function<MDashboardButtonGroupButton, VoidFunction<String>>> getColumnsToTranslate() {
		return new HashMap<>() {{
			put(MDashboardButtonGroupButton.COLUMNNAME_Name, menuDashBoardLineItem -> menuDashBoardLineItem::setName);
			put(MDashboardButtonGroupButton.COLUMNNAME_Description,
					menuDashBoardLineItem -> menuDashBoardLineItem::setDescription);
			put(MDashboardButtonGroupButton.COLUMNNAME_ButtonText,
					menuDashBoardLineItem -> menuDashBoardLineItem::setButtonText);
			put(MDashboardButtonGroupButton.COLUMNNAME_ButtonHelpText,
					menuDashBoardLineItem -> menuDashBoardLineItem::setButtonHelpText);
		}};
	}
}
