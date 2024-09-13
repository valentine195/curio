import { Component, Input, OnInit } from '@angular/core';
import { NasmItem } from '../../../../../interfaces/museums/smithsonian/nasm';

@Component({
  selector: 'app-nasm',
  standalone: true,
  imports: [],
  templateUrl: './nasm.component.html',
  styleUrl: './nasm.component.scss',
})
export class NasmComponent implements OnInit {
  @Input({ required: true }) item!: NasmItem;
  ngOnInit() {
    console.log(this.item.description);
  }
}
