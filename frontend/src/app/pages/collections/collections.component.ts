import { Component, effect, OnInit } from '@angular/core';
import { ItemsService } from '../../services/items.service';
import { Observable, tap } from 'rxjs';
import { ItemsResponseData } from '../../interfaces/items/item';
import { AsyncPipe } from '@angular/common';
import { ItemComponent } from './items/item/item.component';
import { MuseumsService } from '../../services/museums.service';
import { TagsService } from '../../services/tags.service';
import { PaginatorModule, PaginatorState } from 'primeng/paginator';

@Component({
  selector: 'app-collections',
  standalone: true,
  imports: [AsyncPipe, ItemComponent, PaginatorModule],
  templateUrl: './collections.component.html',
  styleUrl: './collections.component.scss',
})
export class CollectionsComponent implements OnInit {
  onPageChange($event: PaginatorState) {
    console.log('🚀 ~ file: collections.component.ts:20 ~ event:', $event);
  }
  items$!: Observable<ItemsResponseData>;
  museums$!: Observable<string[]>;
  tags$!: Observable<string[]>;
  constructor(
    public itemsService: ItemsService,
    public museumsService: MuseumsService,
    public tagsService: TagsService
  ) {
    effect(() => {
      console.log(this.itemsService.items());
    });
  }
  ngOnInit(): void {
    this.items$ = this.itemsService.items$;
    this.museums$ = this.museumsService.getItems();
    this.tags$ = this.tagsService.getItems();
  }
}
