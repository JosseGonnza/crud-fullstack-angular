import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { AppComponent } from './app/app.component';
import { CustomerListComponent } from './app/components/customer-list/customer-list.component';
import { CustomerAddComponent } from './app/components/customer-add/customer-add.component';

bootstrapApplication(AppComponent, appConfig)
  .catch((err) => console.error(err));
