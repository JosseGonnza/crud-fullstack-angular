import { ApplicationModule, Component, OnInit } from '@angular/core';
import { Customer } from '../../customer';
import { CustomerService } from '../../Service/customer.service';
import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-customer-list',
  standalone: true,
  imports: [FormsModule, HttpClientModule, CommonModule, RouterModule],
  templateUrl: './customer-list.component.html',
  styleUrl: './customer-list.component.css'
})
export class CustomerListComponent implements OnInit {

  customers : Customer [] = [];

  constructor(private customerService: CustomerService ){}

  ngOnInit(): void {
    this.listCustomers();
  }

  listCustomers(){
    this.customerService.getCustomerList().subscribe(
      data => {
        this.customers = data;
        console.log(this.customers)
      }
    );
  }

  deleteCustomer(id : number){
    console.log(id);
    this.customerService.deleteCustomerById(id).subscribe(
      ()=> this.listCustomers()
    );
  }

}