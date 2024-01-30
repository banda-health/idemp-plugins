package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_LabelPrinter;
import org.compiere.model.X_AD_LabelPrinterFunction;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_LabelPrinterFunction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_LabelPrinterFunctionInput extends X_AD_LabelPrinterFunction implements I_AD_LabelPrinterFunctionInput {

	private ForeignEntityInput mAD_LabelPrinter;
	private ForeignEntityInput mAD_Org;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_LabelPrinterFunction_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_LabelPrinterFunctionInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Label printer.
	 *
	 * @param AD_LabelPrinter Label Printer Definition
	 */
	@JsonProperty("AD_LabelPrinter")
	public void setAD_LabelPrinterInput(ForeignEntityInput AD_LabelPrinter) {
		this.mAD_LabelPrinter = AD_LabelPrinter;
		if (get_ID() != 0) {
			return;
		}
		if (AD_LabelPrinter != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_LabelPrinter foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_LabelPrinter", "AD_LabelPrinter_UU=?", get_TrxName())
							.setParameters(AD_LabelPrinter.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_LabelPrinter_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_LabelPrinter with UUID " + AD_LabelPrinter.getUUID());
			}
		} else {
			this.setAD_LabelPrinter_ID(0);
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_LabelPrinterFunction_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
		} else {
			this.setAD_Org_ID(0);
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
