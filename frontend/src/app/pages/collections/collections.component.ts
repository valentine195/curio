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

@Component({
  selector: 'app-collections',
  standalone: true,
  imports: [
    AsyncPipe,
    ItemCardComponent,
    ItemSkeletonComponent,
    PaginatorModule,
    MatPaginatorModule,
  ],
  templateUrl: './collections.component.html',
  styleUrl: './collections.component.scss',
})
export class CollectionsComponent implements OnInit {
  /* items$: Observable<ItemsResponseData>; */
  onPageChange($event: PaginatorState) {
    console.log('🚀 ~ file: collections.component.ts:20 ~ event:', $event);
  }
  items = signal<ItemsResponseData | null>(null);
  loaded = signal;
  museums$!: Observable<string[]>;
  tags$!: Observable<string[]>;
  constructor(
    public itemsService: ItemsService,
    public museumsService: MuseumsService,
    public tagsService: TagsService
  ) {
    this.itemsService.items$
      .pipe(
        tap((v) => this.items.set(v)),
        tap((value) => console.log('tap', value))
      )
      .subscribe();
    /* effect(() => {
      console.log(this.itemsService.items());
    }); */
  }
  ngOnInit(): void {
    /* this.items$ = this.itemsService.items$; */
    this.museums$ = this.museumsService.getItems();
    this.tags$ = this.tagsService.getItems();
  }
}
