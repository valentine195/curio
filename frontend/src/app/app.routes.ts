import type { Routes } from '@angular/router';
import { ErrorComponent } from './pages/error/error.component';
import { HomeComponent } from './pages/home/home.component';
import { CollectionsComponent } from './pages/collections/collections.component';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: "collections", loadComponent: () => CollectionsComponent },
  { path: '**', loadComponent: () => ErrorComponent },
];
