import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserinfoService {

  constructor(private http: HttpClient) { }

  getUserInfo(token: string) {

    return this.http.get<any>("http://localhost:8080/user?token=" + token);
  }

}
