import axios from 'axios';
import { DocumentAction, DocumentStatus, DocumentBaseType, ValueObject } from '../models';
import { ReferenceList } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi, IDEMPIERE_ENDPOINT } from './base';

class ReferenceListApi extends BaseApi<ReferenceList> {
	entityName = 'reference-lists';

	async getDocumentStatusActionMap(valueObject: ValueObject) {
		return (
			await axios.get<{
				[documentType in DocumentBaseType]: { [documentStatus in DocumentStatus]: DocumentAction[] };
			}>(`${IDEMPIERE_ENDPOINT}/${this.entityName}/documentStatusActionMap`, this.getAuthorizationHeaders(valueObject))
		).data;
	}

	async getByReference(
		valueObject: ValueObject,
		referenceUuid: string,
		includeInactive: boolean,
	): Promise<ReferenceList[]> {
		const filter = { ad_reference: { ad_reference_uu: referenceUuid } } as any; // not sure if we want any types for the filter
		if (!includeInactive) {
			filter.isactive = 'Y';
		}
		return (await this.get(valueObject, 0, 100, undefined, JSON.stringify(filter))).results;
	}
}

export const referenceListApi = new ReferenceListApi();
