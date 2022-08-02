import axios from 'axios';
import { ValueObject } from '../models';
import { BaseApi, IDEMPIERE_ENDPOINT } from './base';

export abstract class DocumentApi<T> extends BaseApi<T> {
	async process(valueObject: ValueObject, uuid: string, documentAction: string): Promise<T> {
		return (
			await axios.post<T>(
				`${IDEMPIERE_ENDPOINT}/${this.entityName}/${uuid}/process/${documentAction}`,
				undefined,
				this.getAuthorizationHeaders(valueObject),
			)
		).data;
	}

	async saveAndProcess(valueObject: ValueObject, data: T, documentAction: string): Promise<T> {
		return (
			await axios.post<T>(
				`${IDEMPIERE_ENDPOINT}/${this.entityName}/process/${documentAction}`,
				data,
				this.getAuthorizationHeaders(valueObject),
			)
		).data;
	}
}
