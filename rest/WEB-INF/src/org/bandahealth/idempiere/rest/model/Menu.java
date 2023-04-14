package org.bandahealth.idempiere.rest.model;

import java.util.ArrayList;
import java.util.List;

import org.bandahealth.idempiere.base.model.MMenu_BH;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Menu extends BaseEntity {

	private String iconClassName;
	private Window window;
	private Process process;
	private List<Menu> subMenus = new ArrayList<>();
	@JsonIgnore
	private Integer parentId;
	private Integer sequenceNumber;

	public Menu(MMenu_BH menu) {
		super(menu, menu.getName(), menu.getDescription(), null);

		this.iconClassName = menu.getIconClassName();
	}

	public String getIconClassName() {
		return iconClassName;
	}

	public void setIconClassName(String iconClassName) {
		this.iconClassName = iconClassName;
	}

	public Window getWindow() {
		return window;
	}

	public void setWindow(Window window) {
		this.window = window;
	}

	public Process getProcess() {
		return process;
	}

	public void setProcess(Process process) {
		this.process = process;
	}

	public List<Menu> getSubMenus() {
		return subMenus;
	}

	public void setSubMenus(List<Menu> subMenus) {
		this.subMenus = subMenus;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(Integer sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}
}
