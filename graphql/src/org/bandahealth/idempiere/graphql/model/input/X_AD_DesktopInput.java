package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MImage;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Desktop;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Desktop - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_DesktopInput extends X_AD_Desktop implements I_AD_DesktopInput {

	private ForeignEntityInput mAD_Image;
	private ForeignEntityInput mAD_Org;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_Desktop_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_DesktopInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_AD_Desktop(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
	}
	/**
	 * Set Desktop.
	 *
	 * @param AD_Desktop_ID Collection of Workbenches
	 */

	public void setAD_Desktop_ID(int AD_Desktop_ID) {
		if (get_ID() == 0) {
			super.setAD_Desktop_ID(AD_Desktop_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_Desktop_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getAD_Desktop_UU();
	}

	/**
	 * Set Image.
	 *
	 * @param AD_Image Image or Icon
	 */
	@JsonProperty("AD_Image")
	public void setAD_ImageInput(ForeignEntityInput AD_Image) {
		this.mAD_Image = AD_Image;
		MImage foreignEntity;
		if (AD_Image != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Image", "AD_Image_UU=?", get_TrxName())
							.setParameters(AD_Image.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Image_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Image with UUID " + AD_Image.getUUID());
			}
		} else {
			super.setAD_Image_ID(0);
		}
	}

	/**
	 * Get Image.
	 *
	 * @return Image or Icon
	 */
	@JsonProperty("AD_Image")
	public ForeignEntityInput AD_Image() {
		return mAD_Image;
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
		if (get_ID() == 0 && AD_Org != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
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
