import { Component, Input } from '@angular/core';
import { ImageModule } from 'primeng/image';
import { Item } from '../../../../interfaces/items/item';

@Component({
  selector: 'app-item',
  standalone: true,
  imports: [ImageModule],
  templateUrl: './item.component.html',
  styleUrl: './item.component.scss',
})
export class ItemComponent {
  @Input({ required: true }) item!: Item;
}
