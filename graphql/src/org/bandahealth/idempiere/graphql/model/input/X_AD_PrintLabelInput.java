package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MTable_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_LabelPrinter;
import org.compiere.model.X_AD_PrintLabel;

import java.sql.ResultSet;

/**
 * Generated Model for AD_PrintLabel - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_PrintLabelInput extends X_AD_PrintLabel implements I_AD_PrintLabelInput {

	private ForeignEntityInput mAD_LabelPrinter;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Table;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_PrintLabelInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_AD_PrintLabel(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Label printer.
	 *
	 * @param AD_LabelPrinter Label Printer Definition
	 */
	@JsonProperty("AD_LabelPrinter")
	public void setAD_LabelPrinterInput(ForeignEntityInput AD_LabelPrinter) {
		this.mAD_LabelPrinter = AD_LabelPrinter;
		X_AD_LabelPrinter foreignEntity;
		if (AD_LabelPrinter != null &&
				(foreignEntity = new Query(getCtx(), "AD_LabelPrinter", "AD_LabelPrinter_UU=?", get_TrxName())
						.setParameters(AD_LabelPrinter.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_LabelPrinter_ID(foreignEntity.get_ID());
		} else {
			super.setAD_LabelPrinter_ID(0);
		}
	}

	/**
	 * Get Label printer.
	 *
	 * @return Label Printer Definition
	 */
	@JsonProperty("AD_LabelPrinter")
	public ForeignEntityInput AD_LabelPrinter() {
		return mAD_LabelPrinter;
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}
	/**
	 * Set Print Label.
	 *
	 * @param AD_PrintLabel_ID Label Format to print
	 */

	public void setAD_PrintLabel_ID(int AD_PrintLabel_ID) {
		if (get_ID() == 0) {
			super.setAD_PrintLabel_ID(AD_PrintLabel_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_PrintLabel_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_PrintLabel_UU();
	}

	/**
	 * Set Table.
	 *
	 * @param AD_Table Database Table information
	 */
	@JsonProperty("AD_Table")
	public void setAD_TableInput(ForeignEntityInput AD_Table) {
		this.mAD_Table = AD_Table;
		MTable_BH foreignEntity;
		if (AD_Table != null &&
				(foreignEntity = new Query(getCtx(), "AD_Table", "AD_Table_UU=?", get_TrxName())
						.setParameters(AD_Table.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Table_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Table_ID(0);
		}
	}

	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	@JsonProperty("AD_Table")
	public ForeignEntityInput AD_Table() {
		return mAD_Table;
	}
}
