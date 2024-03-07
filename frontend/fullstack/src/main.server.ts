import { bootstrapApplication } from '@angular/platform-browser';
import { AppComponent } from './app/app.component';
import { config } from './app/app.config.server';
import { CustomerListComponent } from './app/components/customer-list/customer-list.component';
import { CustomerAddComponent } from './app/components/customer-add/customer-add.component';

const bootstrap = () => bootstrapApplication(AppComponent, config,);

export default bootstrap;
