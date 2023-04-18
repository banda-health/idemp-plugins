package org.bandahealth.idempiere.rest.model;

import org.compiere.model.MImage;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class Image extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String entityType;
	private String imageUrl;
	private String binaryData;

	public Image() {
	}

	public Image(MImage instance) {
		super(instance, instance.getName(), instance.getDescription(), null);

		this.entityType = instance.getEntityType();
		this.imageUrl = instance.getImageURL();
	}

	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public void setBinaryData(String binaryData) {
		this.binaryData = binaryData;
	}

	public String getBinaryData() {
		return binaryData;
	}
}
