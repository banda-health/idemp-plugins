package org.bandahealth.idempiere.rest.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.bandahealth.idempiere.base.model.MMenu_BH;
import org.compiere.model.MProcess;
import org.compiere.model.MWindow;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement(name = "menu")
@JsonInclude(value = Include.NON_NULL)
public class Menu extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private String iconClassName;
	private String windowUuid;
	private String processUuid;
	private List<Menu> subMenus;
	@JsonIgnore
	private Integer windowId;
	@JsonIgnore
	private Integer processId;
	private boolean showOnUIMenu;

	public Menu(MMenu_BH menu, MWindow window, MProcess process) {
		super(menu, menu.getName(), menu.getDescription(), null);

		this.iconClassName = menu.getIconClassName();

		if (window != null) {
			this.windowUuid = window.getAD_Window_UU();
			this.windowId = window.get_ID();
		}

		if (process != null) {
			this.processUuid = process.getAD_Process_UU();
			this.processId = process.get_ID();
		}
		
		this.showOnUIMenu = menu.isShowOnUIMenu();
	}

	public String getIconClassName() {
		return iconClassName;
	}

	public void setIconClassName(String iconClassName) {
		this.iconClassName = iconClassName;
	}

	public String getWindowUuid() {
		return windowUuid;
	}

	public void setWindowUuid(String windowUuid) {
		this.windowUuid = windowUuid;
	}

	public String getProcessUuid() {
		return processUuid;
	}

	public void setProcessUuid(String processUuid) {
		this.processUuid = processUuid;
	}

	public List<Menu> getSubMenus() {
		return subMenus;
	}

	public void setSubMenus(List<Menu> subMenus) {
		this.subMenus = subMenus;
	}

	public Integer getWindowId() {
		return windowId;
	}

	public void setWindowId(Integer windowId) {
		this.windowId = windowId;
	}

	public Integer getProcessId() {
		return processId;
	}

	public void setProcessId(Integer processId) {
		this.processId = processId;
	}

	public boolean isShowOnUIMenu() {
		return showOnUIMenu;
	}

	public void setShowOnUIMenu(boolean showOnUIMenu) {
		this.showOnUIMenu = showOnUIMenu;
	}
}
