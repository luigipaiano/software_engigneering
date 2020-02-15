import { Injectable } from '@angular/core';
import { User } from '../models/User';
import {HttpClient} from '@angular/common/http';
import {map} from 'rxjs/operators';
import {ApiResponse} from '../models/ApiResponse';
import { Observable } from 'rxjs';

@Injectable()
export class DataService {
  users: User[];
  data: Observable<any>;

  constructor(private http: HttpClient) { }

  getUsers(): Observable<User[]> {

    return this.http.get('https://jsonplaceholder.typicode.com/users').pipe(map((response: ApiResponse[]) => {
      const myObjs: User[] = [];

      response.forEach(element => {
        const myObj: User = {} as User;

        myObj.firstname = element.name;
        myObj.address = element.address;

        myObjs.push(myObj);
      });

      return myObjs;

    }));

    /* this.users = [
      {
        firstname: 'Marge',
        lastname: 'Simpson',
        age: 38,
        address: {
          city: 'Roma',
          street: 'via Lecce 2'
        },
        showdetails: true
      },
      {
        firstname: 'Lisa',
        lastname: 'Simpson',
        age: 7,
        address: {
          city: 'Roma',
          street: 'via Lecce 2'
        },
        showdetails: false
      },
      {
        firstname: 'Meggie',
        lastname: 'Simpson',
        age: 2,
        address: {
          city: 'Roma',
          street: 'via Lecce 2'
        },
        showdetails: true
      }
    ];

    return of(this.users); */
  }

  postUser(user: User) {
    this.users.unshift(user);
  }

  getData(): Observable<any> {
    this.data = new Observable<any>(observer => {

      setTimeout(() => {
        observer.next(1);
      }, 1000);

      setTimeout(() => {
        observer.next(2);
      }, 2000);

      setTimeout(() => {
        observer.next(3);
      }, 3000);

      setTimeout(() => {
        observer.next(4);
        observer.complete();
      }, 4000);

    });

    return this.data;
  }

}
