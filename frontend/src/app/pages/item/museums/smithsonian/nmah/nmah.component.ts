import {
  ChangeDetectionStrategy,
  Component,
  computed,
  input,
} from '@angular/core';
import { MatTabsModule } from '@angular/material/tabs';
import { NmahItem } from '../../../../../interfaces/museums/smithsonian/nmah';
import { SafeHtmlPipe } from '../../../../../pipes/safe-html.pipe';

@Component({
  selector: 'app-nmah',
  templateUrl: './nmah.component.html',
  imports: [MatTabsModule, SafeHtmlPipe],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class NmahComponent {
  item = input.required<NmahItem>();
  protected readonly description = computed(
    () =>
      this.item()
        .getFreetextProperty('notes')
        .find((n) => n.label === 'Description')?.content ?? '',
  );

  protected readonly physicalDescription = computed(() => {
    const desc = this.item().getFreetextProperty('physicalDescription');
    return desc.map((d) => [d.label, [d.content]]);
  });

  protected readonly maker = computed(
    () =>
      this.item()
        .getFreetextProperty('name')
        .find((n) => n.label === 'maker')?.content ?? '',
  );

  protected readonly place = computed(
    () => this.item().getFreetextProperty('place')[0]?.content ?? '',
  );

  protected readonly creditLine = computed(() => {
    const credits = this.item().getFreetextProperty('creditLine');
    return credits.map((c) => [c.label, [c.content]]);
  });

  protected readonly additionalNotes = computed(
    () =>
      this.item()
        .getFreetextProperty('notes')
        .filter(
          (n) => n.label !== 'Description' && n.content !== this.description(),
        ) ?? [],
  );
}
