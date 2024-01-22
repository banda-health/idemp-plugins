package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_LabelPrinter;
import org.compiere.model.X_AD_LabelPrinterFunction;

import java.sql.ResultSet;

/**
 * Generated Model for AD_LabelPrinterFunction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_LabelPrinterFunctionInput extends X_AD_LabelPrinterFunction implements I_AD_LabelPrinterFunctionInput {

	private ForeignEntityInput mAD_LabelPrinter;
	private ForeignEntityInput mAD_Org;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_LabelPrinterFunctionInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_AD_LabelPrinterFunction(null, (ResultSet) null, null), null, Table_Name, ID),
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
		if (get_ID() == 0 && AD_LabelPrinter != null &&
				(foreignEntity = new Query(getCtx(), "AD_LabelPrinter", "AD_LabelPrinter_UU=?", get_TrxName())
						.setParameters(AD_LabelPrinter.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_LabelPrinter_ID(foreignEntity.get_ID());
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
	 * Set Label printer Function.
	 *
	 * @param AD_LabelPrinterFunction_ID Function of Label Printer
	 */

	public void setAD_LabelPrinterFunction_ID(int AD_LabelPrinterFunction_ID) {
		if (get_ID() == 0) {
			super.setAD_LabelPrinterFunction_ID(AD_LabelPrinterFunction_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_LabelPrinterFunction_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_LabelPrinterFunction_UU();
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
}
