import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Customer } from '../../customer';
import { CustomerService } from '../../Service/customer.service';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-customer-add',
  standalone: true,
  imports: [RouterModule, FormsModule],
  templateUrl: './customer-add.component.html',
  styleUrl: './customer-add.component.css'
})
export class CustomerAddComponent implements OnInit{

  id : number = 0;
  firstName : string = "";
  lastName : string = "";
  email : string = "";

  constructor(private customerService : CustomerService){}

  ngOnInit(): void {

  }

  addCustomer(){
    let customer = new Customer(this.id, this.firstName, this.lastName, this.email);
    console.log(customer);
    this.customerService.createCustomer(customer).subscribe(
      res => console.log(res)
    );
  }
}
