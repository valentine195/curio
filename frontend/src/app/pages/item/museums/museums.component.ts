import { Component, Input } from '@angular/core';
import { ResponseItem } from '../../../interfaces/museums/response-item';
import { NasmComponent } from './smithsonian/nasm/nasm.component';

@Component({
  selector: 'app-museums',
  standalone: true,
  imports: [NasmComponent],
  templateUrl: './museums.component.html',
  styleUrl: './museums.component.scss'
})
export class MuseumsComponent {
    @Input({required: true}) item!: ResponseItem;
}
