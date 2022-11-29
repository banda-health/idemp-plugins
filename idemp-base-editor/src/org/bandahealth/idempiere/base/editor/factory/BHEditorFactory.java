package org.bandahealth.idempiere.base.editor.factory;

import org.adempiere.webui.editor.WEditor;
import org.adempiere.webui.factory.IEditorFactory;
import org.bandahealth.idempiere.base.editor.editor.WBHTabNavButtons;
import org.bandahealth.idempiere.base.editor.editor.WTableEditor;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.util.CLogger;

public class BHEditorFactory implements IEditorFactory {

	CLogger log = CLogger.getCLogger(BHEditorFactory.class);

	@Override
	public WEditor getEditor(GridTab gridTab, GridField gridField, boolean tableEditor) {

		if (gridField == null) {
			return null;
		}

		WEditor editor = null;
		int displayType = gridField.getDisplayType();

		if (displayType == BHDisplayTypeFactory.PaymentRow) {
//			log.warning("MY CUSTOM MULTISELECTION DISPLAYTYPE");
			editor = new WTableEditor(gridField, gridTab);
		} else if (displayType == BHDisplayTypeFactory.TabNavButton) {
			editor = new WBHTabNavButtons(gridField, gridTab);
		}

		if (editor != null) {
			editor.setTableEditor(tableEditor);
		}

		return editor;
	}
}
