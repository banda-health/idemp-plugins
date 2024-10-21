import { ValueObject } from '../models';
import {
	Ad_ClientGetQuery,
	Ad_RoleGetWindowAccessQuery,
	C_AcctSchemaGetQuery,
	M_PriceListSaveMutation,
	SignInMutation,
} from '../__generated__/graphql';

declare global {
	var __VALUE_OBJECT__: ValueObject;
}

export type LoginInfo = {
	token: string;
	AD_Client?: Ad_ClientGetQuery['AD_ClientGet']['Results'][0];
	AD_Clients: Ad_ClientGetQuery['AD_ClientGet']['Results'];
	AD_Role: Ad_RoleGetWindowAccessQuery['AD_RoleGet']['Results'][0];
	AD_Client_UU: string;
	AD_Org_UU: string;
	AD_Role_UU?: string;
	AD_User: SignInMutation['SignIn']['AD_User'];
	M_Warehouse_UU: string;
	C_Country?: C_LocationGetQuery['C_LocationGet']['Results'][0]['C_Country'];
	C_Region?: C_LocationGetQuery['C_LocationGet']['Results'][0]['C_Region'];
	SalesPriceList?: M_PriceListSaveMutation['M_PriceListSave'];
	PurchasePriceList?: M_PriceListSaveMutation['M_PriceListSave'];
	C_Currency?: C_AcctSchemaGetQuery['C_AcctSchemaGet']['Results'][0]['C_Currency'];
};
