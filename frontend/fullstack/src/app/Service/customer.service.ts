import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private api: string = "http://localhost:8080/api/customers";

  constructor(private hhtp:HttpClient) {}

    getCustomerList():Observable<Customer []>{
    return this.hhtp.get<Customer[]>(this.api);
    }

    createCustomer(customer : Customer):Observable<Customer>{
      return this.hhtp.post<Customer>(this.api,customer);
    }

    deleteCustomerById(id : number):Observable<any>{
      return this.hhtp.delete(this.api+'/'+id);
    }
}
