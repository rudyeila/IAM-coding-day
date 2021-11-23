import { Injectable } from '@angular/core';
import {AuthConfig, OAuthService} from 'angular-oauth2-oidc';

@Injectable({
  providedIn: 'root'
})
export class OidcService {

  authCodeFlowConfig: AuthConfig = {
    // Url of the Identity Provider
    //issuer: 'https://icd-team-4.demo.dev-servicelayers.io/auth/oauth2/realms/root/realms/consumer/',
    issuer: "https://icd-team-4.demo.dev-servicelayers.io:443/auth/oauth2/realms/root/realms/consumer",
    
    // URL of the SPA to redirect the user to after login
    redirectUri: window.location.origin,

    // The SPA's id. The SPA is registerd with this id at the auth-server
    // clientId: 'server.code',
    clientId: 'testclient',
    
    //dummyClientSecret: 'wirklichsupersicher',

    // responseType: 'token',

    scope: 'openid profile',

    showDebugInformation: true,
  };

  constructor(private oauthService: OAuthService) { }

  login(): Promise<boolean> {
    // this.oauthService.initCodeFlow();
    this.oauthService.initLoginFlow();
    this.oauthService.configure(this.authCodeFlowConfig);
    return this.oauthService.loadDiscoveryDocumentAndTryLogin();
  }

  logout(): Promise<any> {
    this.oauthService.logOut();
    return this.oauthService.revokeTokenAndLogout();
  }

  getToken(): string {
    return this.oauthService.getAccessToken();
  }
}
