package org.bandahealth.idempiere.base.editor.editor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.adempiere.webui.editor.WEditor;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.I_AD_Ref_List;
import org.compiere.model.I_AD_Reference;
import org.compiere.model.MOrder;
import org.compiere.model.Query;
import org.compiere.model.StateChangeEvent;
import org.compiere.model.StateChangeListener;
import org.compiere.model.X_AD_Ref_List;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.zkoss.zhtml.Input;
import org.zkoss.zhtml.Option;
import org.zkoss.zhtml.Select;
import org.zkoss.zhtml.Span;
import org.zkoss.zhtml.Text;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zul.Vlayout;

public class WTableEditor extends WEditor implements StateChangeListener {

	private CLogger log = CLogger.getCLogger(WTableEditor.class);
	private boolean readWrite;
	private int ad_User_ID = 0;
	private Set<Object> items = null;
	private Div tableContainer;
	private int numberOfDataRows = 1;
	private int dataRowId = 0;

	private List<X_AD_Ref_List> tenderTypes;

	public WTableEditor(GridField gridField, GridTab gridTab) {
		super(new Vlayout(), gridField);

		if (gridField.getGridTab() != null) {
			gridField.getGridTab().getField(MOrder.COLUMNNAME_C_Order_ID).addPropertyChangeListener(this);
			gridField.getGridTab().addStateChangeListener(this);
		}

		String where = I_AD_Reference.COLUMNNAME_Name + "=?";
		int ad_Reference_List_Id = new Query(Env.getCtx(), I_AD_Reference.Table_Name, where, null)
				.setParameters("C_Payment Tender Type")
				.firstId();
		where = I_AD_Ref_List.COLUMNNAME_AD_Reference_ID + "=?";
		tenderTypes = new Query(Env.getCtx(), I_AD_Ref_List.Table_Name, where, null)
				.setParameters(ad_Reference_List_Id)
				.setOnlyActiveRecords(true)
				.list();

		initializeEditor();
	}

	private void initializeEditor() {

		Vlayout layout = (Vlayout) this.getComponent();
		layout.setWidth("100%");
		layout.setSclass("bh");

		tableContainer = new Div();
		tableContainer.setClass("bh-editable-rows-container");
		tableContainer.setParent(layout);

		buildTable(tableContainer, numberOfDataRows);
	}

	private void buildTable(Div containingDiv, int numberOfDataRows) {

		// Header row
		Div columnOne = new Div();
		Div columnTwo = new Div();
		Div columnThree = new Div();

		columnOne.setParent(containingDiv);
		columnTwo.setParent(containingDiv);
		columnThree.setParent(containingDiv);

		Span span = new Span();
		span.setSclass("z-label");
		span.setParent(columnTwo);

		Text text = new Text();
		text.setValue("Tender Type");
		text.setParent(span);

		span = new Span();
		span.setSclass("z-label");
		span.setParent(columnThree);

		text = new Text();
		text.setValue("Amount");
		text.setParent(span);

		// Final row
		columnOne = new Div();

		columnOne.setClass("bh-add-row");
		columnOne.setParent(containingDiv);

		Button button = new Button();
		button.setSclass("form-button z-button bh-button");
		button.setParent(columnOne);
		button.setLabel("Add Another Payment");
		button.addEventListener(Events.ON_CLICK, this);

		// Data rows
		for (int i = 0; i < numberOfDataRows; i++) {
			columnOne = new Div();
			columnTwo = new Div();
			columnThree = new Div();

			columnOne.setAttribute("data-row", dataRowId);
			columnOne.setClass("delete-button-container");
			columnOne.setParent(containingDiv);
			columnTwo.setAttribute("data-row", dataRowId);
			columnTwo.setParent(containingDiv);
			columnThree.setAttribute("data-row", dataRowId);
			columnThree.setParent(containingDiv);

			Div deleteButton = new Div();
			deleteButton.setClass("i fa fa-times delete-button");
			deleteButton.addEventListener(Events.ON_CLICK, this);
			deleteButton.setAttribute("data-row", dataRowId);
			deleteButton.setParent(columnOne);
			columnOne.setClass("center");

			Select combobox = new Select();
			combobox.setSclass("z-textbox");
			combobox.setParent(columnTwo);
			Option comboItem = new Option();
			comboItem.setParent(combobox);
			for (X_AD_Ref_List tenderType : tenderTypes) {
				comboItem = new Option();
				comboItem.setSclass("z-comboitem");
				comboItem.setParent(combobox);
				comboItem.setAttribute("value", tenderType.getValue());

				Text comboItemText = new Text(tenderType.getName());
				comboItemText.setParent(comboItem);
			}
//			span = new Span();
//			span.setSclass("z-combobox");
//			span.setParent(columnTwo);
//			Input input = new Input();
//			input.setSclass("z-combobox-input");
//			input.setParent(span);
//			A comboBoxButton = new A();
//			comboBoxButton.setSclass("z-combobox-button");
//			comboBoxButton.setParent(span);
//			I comboboxIcon = new I();
//			comboboxIcon.setSclass("z-combobox-icon z-icon-caret-down");
//			comboboxIcon.setParent(comboBoxButton);
//			Div comboboxPopup = new Div();
//			comboboxPopup.setClass("z-combobox-popup");
//			comboboxPopup.setParent(span);
//			Ul comboboxContent = new Ul();
//			comboboxContent.setSclass("z-combobox-content");
//			comboboxContent.setParent(comboboxPopup);
//			for (X_AD_Ref_List tenderType : tenderTypes) {
//				Li comboItem = new Li();
//				comboItem.setSclass("z-comboitem");
//				comboItem.setParent(comboboxContent);
//
//				Span comboItemTextHolder = new Span();
//				comboItemTextHolder.setSclass("z-comboitem-text");
//				comboItemTextHolder.setParent(comboItem);
//
//				Text comboItemText = new Text(tenderType.getName());
//				comboItemText.setParent(comboItemTextHolder);
//			}

			Input input = new Input();
			input.setSclass("editor-input z-decimalbox bh-number-box");
			input.setParent(columnThree);

			dataRowId++;
		}
	}

	@Override
	public void setReadWrite(boolean readWrite) {
		this.readWrite = readWrite;
		// TODO: disable rows if readWrite is false
	}

	@Override
	public boolean isReadWrite() {
		return readWrite;
	}

	@Override
	public void setValue(Object value) {

	}

	@Override
	public Object getValue() {
		return null;
	}

	@Override
	public String getDisplay() {
		return null;
	}

	@Override
	public void stateChange(StateChangeEvent event) {

	}

	@Override
	public void onEvent(Event event) throws Exception {
		if (event.getTarget() instanceof Button) {
			clearPaymentsSection();
			numberOfDataRows++;
			buildTable(tableContainer, numberOfDataRows);
		} else if (event.getTarget() instanceof Div) {
			removeDataRow((int) ((Div) event.getTarget()).getAttribute("data-row"));
		}
	}

	private void removeDataRow(int dataRowIdToRemove) {
		List<Component> children = tableContainer.getChildren();
		List<Component> dataElementsToRemove = new ArrayList<>();
		for (Component child : children) {
			if (!child.hasAttribute("data-row")) {
				continue;
			}
			if (((int) child.getAttribute("data-row")) == dataRowIdToRemove) {
				dataElementsToRemove.add(child);
			}
		}
		for (Component dataElementToRemove : dataElementsToRemove) {
			tableContainer.removeChild(dataElementToRemove);
		}
		numberOfDataRows--;
		if (numberOfDataRows == 0) {
			buildTable(tableContainer, ++numberOfDataRows);
		}
	}

	private void clearPaymentsSection() {
		List<Component> children = new ArrayList<>(tableContainer.getChildren());
		for (Component child : children) {
			tableContainer.removeChild(child);
		}
	}
}
