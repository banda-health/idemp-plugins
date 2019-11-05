package org.bandahealth.idempiere.rest.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class BaseListResponse<T extends BaseMetadata> {

	private List<T> results;

	private Paging pagingInfo;

	public BaseListResponse(List<T> results, Paging pagingInfo) {
		this.results = results;
		this.pagingInfo = pagingInfo;
	}

	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}

	public Paging getPagingInfo() {
		return pagingInfo;
	}

	public void setPagingInfo(Paging pagingInfo) {
		this.pagingInfo = pagingInfo;
	}

}
