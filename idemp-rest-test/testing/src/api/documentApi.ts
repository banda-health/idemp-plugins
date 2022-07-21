import { ValueObject } from '../models';
import { BaseApi, IDEMPIERE_ENDPOINT } from './baseApi';

export abstract class DocumentApi<T> extends BaseApi<T> {
	async process(valueObject: ValueObject, uuid: string, documentAction: string): Promise<T> {
		const headers = this.getAuthorizationHeaders(valueObject);
		const response = await fetch(`${IDEMPIERE_ENDPOINT}/${this.entityName}/${uuid}/process/${documentAction}`, {
			method: 'POST',
			headers,
		});
		const result = await (response.json() as Promise<T>);
		if (!response.ok) {
			throw new Error(`could not process ${this.entityName}`);
		}
		return result;
	}

	async saveAndProcess(valueObject: ValueObject, data: T, documentAction: string): Promise<T> {
		const headers = this.getAuthorizationHeaders(valueObject);
		const response = await fetch(`${IDEMPIERE_ENDPOINT}/${this.entityName}/process/${documentAction}`, {
			method: 'POST',
			headers,
			body: JSON.stringify(data),
		});
		const result = await (response.json() as Promise<T>);
		if (!response.ok) {
			throw new Error(`could not save and process ${this.entityName}`);
		}
		return result;
	}
}
