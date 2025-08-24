import {
  ChangeDetectionStrategy,
  Component,
  computed,
  input,
} from '@angular/core';
import { MatTabsModule } from '@angular/material/tabs';
import { NmaiItem } from '../../../../../interfaces/museums/smithsonian/nmai';
import { SafeHtmlPipe } from '../../../../../pipes/safe-html.pipe';

@Component({
  selector: 'app-nmai',
  templateUrl: './nmai.component.html',
  styleUrl: './nmai.component.css',
  imports: [MatTabsModule, SafeHtmlPipe],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class NMAIComponent {
  item = input.required<NmaiItem>();
  protected readonly objectType = computed(() => {
    return this.item()
      .getFreetextProperty('objectType')
      .filter((l) => (l.label = 'Object Type'))
      .map((l) => l.content)
      .filter((c) => c != null);
  });
  protected readonly physicalDescription = computed(() => {
    const desc = this.item().getFreetextProperty('physicalDescription') ?? [];
    return desc.map((d) => [d.label, [d.content]]);
  });

  protected readonly place = computed(
    () => this.item().getFreetextProperty('place')?.[0]?.content ?? '',
  );

  protected readonly collectionHistory = computed(
    () =>
      this.item()
        .getFreetextProperty('notes')
        .find((n) => n.label === 'Collection History')?.content ?? '',
  );

  protected readonly additionalNotes = computed(() =>
    this.item()
      .getFreetextProperty('notes')
      .filter(
        (note) =>
          note.label !== 'Collection History' && note.label != 'Contact Us',
      ),
  );

  protected readonly culture = computed(
    () =>
      this.item()
        .getFreetextProperty('name')
        .find((n) => n.label === 'Culture/People')?.content ?? '',
  );

  protected readonly previousOwners = computed(
    () =>
      this.item()
        .getFreetextProperty('name')
        .filter((n) => n.label === 'Previous owner')
        .map((n) => n.content) ?? [],
  );
}
