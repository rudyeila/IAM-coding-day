import { ContentObserver } from '@angular/cdk/observers';
import { HttpParams } from '@angular/common/http';
import { compileDeclareClassMetadata } from '@angular/compiler';
import { stringify } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { OAuthModule } from 'angular-oauth2-oidc';
import { OidcService } from '../oidc.service';
import { UserinfoService } from '../userinfo.service';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  ngOnInit(): void {
  }
  title = 'frontend';
  isLoggedIn: boolean = false;

  constructor(private oidcService: OidcService, private route: ActivatedRoute, private userinfo: UserinfoService) {
  }

  async login() {

    const result = await this.oidcService.login()
    console.log("test123")
    
    
    let code: string

    if (result) {
        this.isLoggedIn = true;
        console.log("Im logged in!");
      
    }
    
  }

  async logout() {
    const result = await this.oidcService.logout();
    if (result) {
      this.isLoggedIn = false;
    }
  }
  getParamValueQueryString( paramName : string) {
    const url = window.location.href;
    let paramValue;
    if (url.includes('?')) {
      const httpParams = new HttpParams({ fromString: url.split('?')[1] });
      paramValue = httpParams.get(paramName);
    }
    return paramValue;
  }
}
