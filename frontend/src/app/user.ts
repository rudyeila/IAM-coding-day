import { insurance } from "./insurance";

export class user {
    "sub": string;
    "email": string;
    "given_name": string;
    "family_name": string;
    "job": string;
    "birthday": string;
    "gender": string;
    "localityName": string;
    "postalCode": string;
    "stateOrProvinceName": string;
    "country": string;
    "hobbies": string[];
    "insuranceOffers": insurance[];

}