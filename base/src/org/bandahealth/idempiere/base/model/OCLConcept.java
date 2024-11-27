package org.bandahealth.idempiere.base.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.bandahealth.idempiere.base.utils.JsonUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@JsonDeserialize(using = OCLConceptDeserializer.class)
public class OCLConcept {

	private JsonNode originalJsonNode;
	private String uuid;
	private String id;
	private String externalId;
	private String conceptClass;
	private String datatype;
	private String url;
	private boolean retired;
	private String source;
	private String owner;
	private String ownerType;
	private String displayName;
	private String displayLocale;
	private String version;
	private String updateComment;
	private String locale;
	private String versionCreatedBy;
	private String versionCreatedOn;
	private boolean isLatestVersion;
	private String type;
	private List<OCLConceptMapping> mappings = new ArrayList<>();
	private List<OCLConceptExtra> extras = new ArrayList<>();
	private List<OCLConceptName> names = new ArrayList<>();
	private List<OCLConceptDescription> descriptions = new ArrayList<>();
	private Map<String, List<OCLConceptMapping>> activeMappingsByMapType = new HashMap<>();
	private Map<String, String> extrasByKey = new HashMap<>();
	private Map<String, List<OCLConceptName>> namesByLanguageAndType = new HashMap<>();
	private Map<String, List<OCLConceptDescription>> descriptionsByLanguageAndType = new HashMap<>();

	public OCLConcept() {
	}

	public OCLConcept(JsonNode node) {
		originalJsonNode = node;
		setUuid(JsonUtils.getValue(node.get("uuid")));
		setId(JsonUtils.getValue(node.get("id")));
		setExternalId(JsonUtils.getValue(node.get("external_id")));
		setConceptClass(JsonUtils.getValue(node.get("concept_class")));
		setDatatype(JsonUtils.getValue(node.get("datatype")));
		setUrl(JsonUtils.getValue(node.get("url")));
		setRetired(JsonUtils.getBoolValue(node.get("retired")));
		setSource(JsonUtils.getValue(node.get("source")));
		setOwner(JsonUtils.getValue(node.get("owner")));
		setOwnerType(JsonUtils.getValue(node.get("owner_type")));
		setDisplayName(JsonUtils.getValue(node.get("display_name")));
		setDisplayLocale(JsonUtils.getValue(node.get("display_locale")));
		setVersion(JsonUtils.getValue(node.get("version")));
		setUpdateComment(JsonUtils.getValue(node.get("update_comment")));
		setLocale(JsonUtils.getValue(node.get("locale")));
		setVersionCreatedBy(JsonUtils.getValue(node.get("version_created_by")));
		setVersionCreatedOn(JsonUtils.getValue(node.get("version_created_on")));
		setLatestVersion(JsonUtils.getBoolValue(node.get("is_latest_version")));
		setType(JsonUtils.getValue(node.get("type")));

		if (node.get("mappings") != null) {
			setMappings(StreamSupport.stream(node.get("mappings").spliterator(), false).map(OCLConceptMapping::new).toList());
		}

		if (node.get("extras") != null) {
			Iterator<Entry<String, JsonNode>> iterator = node.get("extras").fields();
			setExtras(StreamSupport.stream(((Iterable<Entry<String, JsonNode>>) () -> iterator).spliterator(), false)
					.map(extra -> new OCLConceptExtra(extra.getKey(), extra.getValue().asText())).toList());
		}

		if (node.get("names") != null) {
			setNames(StreamSupport.stream(node.get("names").spliterator(), false).map(OCLConceptName::new).toList());
		}

		if (node.get("descriptions") != null) {
			setDescriptions(
					StreamSupport.stream(node.get("descriptions").spliterator(), false).map(OCLConceptDescription::new).toList());
		}
	}

	public void setPropertiesFromSameAsChild(OCLConcept sameAsChildConcept) {
		sameAsChildConcept.getExtras().forEach(sameAsChildExtra -> {
			if (!extrasByKey.containsKey(sameAsChildExtra.getKey().toLowerCase())) {
				extrasByKey.put(sameAsChildExtra.getKey().toLowerCase(), sameAsChildExtra.getValue());
			}
		});
		sameAsChildConcept.getActiveMappingsByMapType().forEach((sameAsChildMappingMapType, sameAsChildMappingList) -> {
			// For the SAME-AS Mapping, put its extras on the parent. Also add the mapping to the parent in case we need
			// the mapping (like ICD 10 for diagnoses)
			if (sameAsChildMappingMapType.equals(MBHConceptMapping.SAME_AS_MAP_TYPE)) {
				if (!activeMappingsByMapType.containsKey(sameAsChildMappingMapType)) {
					activeMappingsByMapType.put(sameAsChildMappingMapType, new ArrayList<>());
				}
				activeMappingsByMapType.get(sameAsChildMappingMapType).addAll(sameAsChildMappingList);
				sameAsChildMappingList.forEach(
						sameAsChildMapping -> {
							sameAsChildMapping.getExtras().forEach(sameAsChildMappingExtra -> {
								if (!extrasByKey.containsKey(sameAsChildMappingExtra.getKey().toLowerCase())) {
									extrasByKey.put(sameAsChildMappingExtra.getKey().toLowerCase(), sameAsChildMappingExtra.getValue());
								}
							});
							// Clear the extras since they're on the parent
							sameAsChildMapping.setExtras(new ArrayList<>());
						});
			} else {
				if (!activeMappingsByMapType.containsKey(sameAsChildMappingMapType)) {
					activeMappingsByMapType.put(sameAsChildMappingMapType, sameAsChildMappingList);
				}
			}
		});
		sameAsChildConcept.getNamesByLanguageAndType().forEach((languageAndType, childOclConceptNameList) -> {
			if (!this.namesByLanguageAndType.containsKey(languageAndType)) {
				this.namesByLanguageAndType.put(languageAndType, childOclConceptNameList);
			} else {
				// If it's not locale preferred, we'll add it; otherwise we'll only add it if it doesn't already have a
				// locale-preferred one
				boolean nameListAlreadyHasPreferredLocale =
						this.namesByLanguageAndType.get(languageAndType).stream().anyMatch(OCLConceptName::isLocalePreferred);
				for (OCLConceptName childConceptName : childOclConceptNameList) {
					if (childConceptName.isLocalePreferred() && nameListAlreadyHasPreferredLocale) {
						continue;
					} else if (childConceptName.isLocalePreferred()) {
						nameListAlreadyHasPreferredLocale = true;
					}
					this.namesByLanguageAndType.get(languageAndType).add(childConceptName);
				}
			}
		});
		sameAsChildConcept.getDescriptionsByLanguageAndType().forEach((languageAndType, childOclConceptNameList) -> {
			if (!this.descriptionsByLanguageAndType.containsKey(languageAndType)) {
				this.descriptionsByLanguageAndType.put(languageAndType, childOclConceptNameList);
			} else {
				// If it's not locale preferred, we'll add it; otherwise we'll only add it if it doesn't already have a
				// locale-preferred one
				boolean nameListAlreadyHasPreferredLocale = this.descriptionsByLanguageAndType.get(languageAndType).stream()
						.anyMatch(OCLConceptDescription::isLocalePreferred);
				for (OCLConceptDescription childConceptDescription : childOclConceptNameList) {
					if (childConceptDescription.isLocalePreferred() && nameListAlreadyHasPreferredLocale) {
						continue;
					} else if (childConceptDescription.isLocalePreferred()) {
						nameListAlreadyHasPreferredLocale = true;
					}
					this.descriptionsByLanguageAndType.get(languageAndType).add(childConceptDescription);
				}
			}
		});
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public String getConceptClass() {
		return conceptClass;
	}

	public void setConceptClass(String conceptClass) {
		this.conceptClass = conceptClass;
	}

	public String getDatatype() {
		return datatype;
	}

	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isRetired() {
		return retired;
	}

	public void setRetired(boolean retired) {
		this.retired = retired;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getOwnerType() {
		return ownerType;
	}

	public void setOwnerType(String ownerType) {
		this.ownerType = ownerType;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayLocale() {
		return displayLocale;
	}

	public void setDisplayLocale(String displayLocale) {
		this.displayLocale = displayLocale;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getUpdateComment() {
		return updateComment;
	}

	public void setUpdateComment(String updateComment) {
		this.updateComment = updateComment;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getVersionCreatedBy() {
		return versionCreatedBy;
	}

	public void setVersionCreatedBy(String versionCreatedBy) {
		this.versionCreatedBy = versionCreatedBy;
	}

	public String getVersionCreatedOn() {
		return versionCreatedOn;
	}

	public void setVersionCreatedOn(String versionCreatedOn) {
		this.versionCreatedOn = versionCreatedOn;
	}

	public boolean isLatestVersion() {
		return isLatestVersion;
	}

	public void setLatestVersion(boolean isLatestVersion) {
		this.isLatestVersion = isLatestVersion;
	}

	public List<OCLConceptMapping> getMappings() {
		return mappings;
	}

	public void setMappings(List<OCLConceptMapping> mappings) {
		this.mappings = mappings;
		this.activeMappingsByMapType = mappings.stream().filter(Predicate.not(OCLConceptMapping::isRetired))
				.collect(Collectors.groupingBy(OCLConceptMapping::getMapType));
		// Merge the different SAME-AS types
		if (this.activeMappingsByMapType.containsKey(MBHConceptMapping.SAME_AS2_MAP_TYPE)) {
			this.activeMappingsByMapType.compute(MBHConceptMapping.SAME_AS_MAP_TYPE,
					(key, value) -> {
						if (value == null) {
							return this.activeMappingsByMapType.get(MBHConceptMapping.SAME_AS2_MAP_TYPE);
						}
						value.addAll(this.activeMappingsByMapType.get(MBHConceptMapping.SAME_AS2_MAP_TYPE));
						return value;
					});
			this.activeMappingsByMapType.remove(MBHConceptMapping.SAME_AS2_MAP_TYPE);
		}
	}

	public List<OCLConceptExtra> getExtras() {
		return extras;
	}

	public void setExtras(List<OCLConceptExtra> extras) {
		this.extras = extras;
		this.extrasByKey = extras.stream().collect(
				Collectors.toMap(oclConceptExtra -> oclConceptExtra.getKey().toLowerCase(), OCLConceptExtra::getValue,
						(key1, key2) -> key1));
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<OCLConceptName> getNames() {
		return names;
	}

	public void setNames(List<OCLConceptName> names) {
		this.names = names;
		this.namesByLanguageAndType = names.stream().collect(Collectors.groupingBy(
				oclConceptName -> oclConceptName.getLocale().toLowerCase() +
						(oclConceptName.getType() == null ? "" : oclConceptName.getType().toLowerCase())));
	}

	public List<OCLConceptDescription> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(List<OCLConceptDescription> descriptions) {
		this.descriptions = descriptions;
		this.descriptionsByLanguageAndType = descriptions.stream().collect(Collectors.groupingBy(
				oclConceptDescription -> oclConceptDescription.getLocale().toLowerCase() +
						(oclConceptDescription.getType() == null ? "" : oclConceptDescription.getType().toLowerCase())));
	}

	public Map<String, List<OCLConceptMapping>> getActiveMappingsByMapType() {
		return activeMappingsByMapType;
	}

	public Map<String, String> getExtrasByKey() {
		return extrasByKey;
	}

	public Map<String, List<OCLConceptName>> getNamesByLanguageAndType() {
		return namesByLanguageAndType;
	}

	public Map<String, List<OCLConceptDescription>> getDescriptionsByLanguageAndType() {
		return descriptionsByLanguageAndType;
	}

	public JsonNode getOriginalJsonNode() {
		return originalJsonNode;
	}

	public OCLConcept cloneOriginal() {
		return new OCLConcept(getOriginalJsonNode());
	}

	/**
	 * This method clears the dependent entities out so that it can be the end of an override tree
	 */
	public void truncate() {
		setNames(new ArrayList<>());
		setDescriptions(new ArrayList<>());
		setExtras(new ArrayList<>());
		setMappings(new ArrayList<>());
	}
}
