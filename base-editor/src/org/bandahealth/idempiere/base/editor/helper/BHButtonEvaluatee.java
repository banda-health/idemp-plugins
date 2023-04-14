package org.bandahealth.idempiere.base.editor.helper;

import java.util.Properties;

import org.compiere.model.GridTab;
import org.compiere.model.MColumn;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.Evaluatee;
import org.compiere.util.Util;

public class BHButtonEvaluatee implements Evaluatee {

	private int windowNo;
	private int tabNo;
	private GridTab gridTab;

	public BHButtonEvaluatee(GridTab gridTab) {
		this.gridTab = gridTab;
		windowNo = gridTab.getWindowNo();
		tabNo = gridTab.getTabNo();
	}

	/**
	 * Copied from {@Link GridField} and modified for Banda Health
	 * @param variableName name
	 * @return
	 */
	@Override
	public String get_ValueAsString(String variableName) {
		//ref column
		String foreignColumn = "";
		int f = variableName.indexOf('.');
		if (f > 0) {
			foreignColumn = variableName.substring(f+1, variableName.length());
			variableName = variableName.substring(0, f);
		}

		Properties ctx = Env.getCtx();
		String value = null;
		if(tabNo == 0) {
			value = Env.getContext(ctx, windowNo, variableName, true);
		} else {
			boolean tabOnly = false;
			if (variableName.startsWith("~")) {
				variableName = variableName.substring(1);
				tabOnly = true;
			}
			value = Env.getContext(ctx, windowNo, tabNo, variableName, tabOnly, true);
		}
		if (!Util.isEmpty(value) && !Util.isEmpty(foreignColumn) && variableName.endsWith("_ID") && gridTab != null) {
			String refValue = "";
			int id = 0;
			try {
				id = Integer.parseInt(value);
			} catch (Exception e){}
			if (id > 0) {
				MColumn column = MColumn.get(ctx, gridTab.getTableName(), variableName);
				if (column != null) {
					String foreignTable = column.getReferenceTableName();
					refValue = DB.getSQLValueString(null,
							"SELECT " + foreignColumn + " FROM " + foreignTable + " WHERE "
									+ foreignTable + "_ID = ?", id);
				}
			}
			return refValue;
		}
		return value;
	}
}
