import { Component, Input } from '@angular/core';
import { ImageModule } from 'primeng/image';
import { Item } from '../../../../interfaces/items/items';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-item-card',
  standalone: true,
  imports: [ImageModule, RouterLink],
  templateUrl: './item-card.component.html',
  styleUrl: './item-card.component.scss',
})
export class ItemCardComponent {
  @Input({ required: true }) item!: Item;
}
