import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, map, tap } from 'rxjs';
import { environment } from 'src/environments/environment';

export interface LoginData {
  email: string,
  password: string
}
export interface SignupData {
 name: string,
 username:string,
 email: string,
 password: string

}

export interface AuthData {
  accessToken: string,
  user: {
    id: number,
    name: string,
    username:string,
    email: string,
    password: string

  }
}


@Injectable({
  providedIn: 'root'
})
export class AuthService {


  authSubj = new BehaviorSubject<null|AuthData>(null);
  user = this.authSubj.asObservable()
  logged = this.user.pipe(map((res)=>!!res))

utente:any



  constructor(private http:HttpClient) { }

verificaCredenziali(){

  const storedAuthData = localStorage.getItem('user');
  if (storedAuthData) {
    const authData: AuthData = JSON.parse(storedAuthData);

    this.authSubj.next(authData);
    this.utente=authData
  }
}



  login(d:LoginData) {
    return this.http.post<AuthData>("http://localhost:8080/api/auth/login", d).pipe(tap((res)=>{

      localStorage.setItem("user", JSON.stringify(res))
      //this.l.reload()
      this.authSubj.next(res)

    }))
  }

  signup(d:SignupData) {
    return this.http.post<AuthData>("http://localhost:8080/api/auth/signup", d)
}
  logout() {
    localStorage.removeItem("user")
    this.authSubj.next(null)
  }

}
