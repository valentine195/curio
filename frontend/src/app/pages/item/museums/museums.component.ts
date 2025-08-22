import { Component, input, Input } from '@angular/core';
import { NasmComponent } from './smithsonian/nasm/nasm.component';
import { ChndmComponent } from './smithsonian/chndm/chndm.component';
import { NasmItem } from '../../../interfaces/museums/smithsonian/nasm';
import { ChndmItem } from '../../../interfaces/museums/smithsonian/chndm';
import { BaseItem } from '../../../interfaces/museums/base-item';
import { FsgItem } from '../../../interfaces/museums/smithsonian/fsg';
import { FsgComponent } from "./smithsonian/fsg/fsg.component";

@Component({
  selector: 'app-museums',
  imports: [NasmComponent, ChndmComponent, FsgComponent],
  templateUrl: './museums.component.html',
  styleUrl: './museums.component.scss',
})
export class MuseumsComponent {
  item = input.required<BaseItem>();

  isNasmItem(item: BaseItem): item is NasmItem {
    return item instanceof NasmItem;
  }
  isChndmItem(item: BaseItem): item is ChndmItem {
    return item instanceof ChndmItem;
  }
  isFsgItem(item: BaseItem): item is FsgItem {
    return item instanceof FsgItem;
  }
}
