import type { Routes } from '@angular/router';
import { ErrorComponent } from './pages/error/error.component';
import { HomeComponent } from './pages/home/home.component';
import { CollectionsComponent } from './pages/collections/collections.component';
import { ItemComponent } from './pages/item/item.component';
import { itemResolver } from './pages/item/item.resolver';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  {
    path: 'collections',
    loadComponent: () => CollectionsComponent
  },
  { path: 'collections/:item', component: ItemComponent, resolve: {item: itemResolver} },
  { path: '**', loadComponent: () => ErrorComponent },
];
