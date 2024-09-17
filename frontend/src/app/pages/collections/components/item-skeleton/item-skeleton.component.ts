import { Component } from '@angular/core';
import { NgxSkeletonLoaderModule } from 'ngx-skeleton-loader';

@Component({
  selector: 'app-item-skeleton',
  standalone: true,
  imports: [NgxSkeletonLoaderModule],
  templateUrl: './item-skeleton.component.html',
  styleUrl: './item-skeleton.component.scss',
})
export class ItemSkeletonComponent {}
