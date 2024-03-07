import { ApplicationConfig, importProvidersFrom } from '@angular/core';
import { RouterLink, RouterModule, Routes, provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideClientHydration } from '@angular/platform-browser';
import { HttpClientModule, provideHttpClient, withFetch } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';


export const appConfig: ApplicationConfig = {
  providers: [provideRouter(routes), provideClientHydration(),importProvidersFrom(HttpClientModule),
    importProvidersFrom(CommonModule), provideHttpClient(withFetch()), importProvidersFrom(FormsModule),
  importProvidersFrom(RouterModule.forRoot(routes)), importProvidersFrom(RouterLink)]
};
