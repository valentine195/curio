import { Component, OnInit, signal } from '@angular/core';
import { ItemsService } from '../../services/items.service';
import { Observable, tap } from 'rxjs';
import { ItemsResponseData } from '../../interfaces/items/items';
import { AsyncPipe } from '@angular/common';
import { ItemCardComponent } from './components/item-card/item-card.component';
import { MuseumsService } from '../../services/museums.service';
import { TagsService } from '../../services/tags.service';
import { PaginatorModule, PaginatorState } from 'primeng/paginator';
import { ItemSkeletonComponent } from './components/item-skeleton/item-skeleton.component';
import { MatPaginatorModule } from '@angular/material/paginator';
import { FiltersComponent } from './components/filters/filters.component';
import { LucideAngularModule } from 'lucide-angular';

@Component({
  selector: 'app-collections',
  imports: [
    ItemCardComponent,
    ItemSkeletonComponent,
    PaginatorModule,
    MatPaginatorModule,
    FiltersComponent,
    LucideAngularModule,
  ],
  templateUrl: './collections.component.html',
  styleUrl: './collections.component.scss',
})
export class CollectionsComponent {
  /* items$: Observable<ItemsResponseData>; */
  onPageChange($event: PaginatorState) {
    console.log('🚀 ~ file: collections.component.ts:20 ~ event:', $event);
  }
  items = signal<ItemsResponseData | null>(null);
  loaded = signal;
  constructor(public itemsService: ItemsService) {
    this.itemsService.items$
      .pipe(
        tap((v) => this.items.set(v)),
        tap((value) => console.log('tap', value)),
      )
      .subscribe();
    /* effect(() => {
      console.log(this.itemsService.items());
    }); */
  }
}
