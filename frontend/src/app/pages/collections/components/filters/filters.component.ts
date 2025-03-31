import { Component, inject, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { MuseumsService } from '../../../../services/museums.service';
import { TagsService } from '../../../../services/tags.service';
import { AsyncPipe } from '@angular/common';

@Component({
  selector: 'app-filters',
  imports: [AsyncPipe],
  templateUrl: './filters.component.html',
  styleUrl: './filters.component.scss',
})
export class FiltersComponent implements OnInit {
  museums$!: Observable<string[]>;
  tags$!: Observable<string[]>;
  museumService = inject(MuseumsService);
  tagService = inject(TagsService);
  ngOnInit(): void {
    /* this.items$ = this.itemsService.items$; */
    this.museums$ = this.museumService.getItems();
    this.tags$ = this.tagService.getItems();
  }
}
