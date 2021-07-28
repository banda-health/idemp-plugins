package org.bandahealth.idempiere.rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.bandahealth.idempiere.base.model.MDashboardButtonGroupButton;
import org.compiere.model.MWindow;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement(name = "lineitems")
@JsonInclude(value = Include.NON_NULL)
public class MenuGroupLineItem extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private int lineNumber;
	private String iconClassName;
	private String buttonClassName;
	private String windowUuid;
	@JsonIgnore
	private Integer windowId;

   public MenuGroupLineItem(MDashboardButtonGroupButton button, MWindow window) {
		super(button, button.getName(), button.getDescription(), null); 
		this.lineNumber = button.getLineNo();
		this.iconClassName = button.getIconClassName();
		this.buttonClassName = button.getButtonClassName();
		this.windowId = window.getAD_Window_ID();
		if(window != null ) {
			this.windowUuid = window.getAD_Window_UU();
		}
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	public String getIconClassName() {
		return iconClassName;
	}

	public void setIconClassName(String iconClassName) {
		this.iconClassName = iconClassName;
	}

	public String getButtonClassName() {
		return buttonClassName;
	}

	public void setButtonClassName(String buttonClassName) {
		this.buttonClassName = buttonClassName;
	}

	public Integer getWindowId() {
		return windowId;
	}

	public void setWindowId(Integer windowId) {
		this.windowId = windowId;
	}

	public String getWindowUuid() {
		return windowUuid;
	}

	public void setWindowUuid(String windowUuid) {
		this.windowUuid = windowUuid;
	}
	
	
}
