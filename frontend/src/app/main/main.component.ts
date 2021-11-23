import { stringify } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { OidcService } from '../oidc.service';
import { user } from '../user';
import { UserinfoService } from '../userinfo.service';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
  user!: user;
  constructor(private userInfo : UserinfoService, private route: ActivatedRoute, private oidc: OidcService) { }
  

  ngOnInit(): void {
    this.route.fragment.subscribe((fragment) => {
      let token = new URLSearchParams(fragment?fragment:" ").get('access_token');
      this.userInfo.getUserInfo(token?token:" ").subscribe((info) => {
        this.user = info
      })

    })

    try {
      let token
      console.log(this.route.queryParams)
      console.log(this.route.url)
      console.log(this.route.queryParamMap)
      this.route.queryParams.subscribe(params => {
        token = params["access_token"]
        console.log(params)
        console.log(token)
      })
    } catch {
      console.log("")
    }
    
  }


}
