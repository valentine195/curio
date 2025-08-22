import {
  AfterViewInit,
  Component,
  computed,
  effect,
  ElementRef,
  input,
  OnDestroy,
  OnInit,
  ViewChild,
} from '@angular/core';
import { DataSet } from 'vis-data';
import * as vis from 'vis-timeline';

export interface TimelineData {
  content: string;
  start: Date;
  end?: Date;
}

@Component({
  selector: 'app-timeline',
  imports: [],
  templateUrl: './timeline.component.html',
  styleUrl: './timeline.component.scss',
})
export class TimelineComponent implements AfterViewInit, OnDestroy {
  @ViewChild('timelineContainer')
  timelineContainer!: ElementRef<HTMLDivElement>;

  items = input.required<TimelineData[]>();
  private data = computed(
    () =>
      new DataSet(
        this.items().map((i, idx) => {
          return {
            id: idx,
            type: i.start && i.end ? 'range' : 'box',
            ...i,
          };
        }),
      ),
  );
  private timeline!: vis.Timeline;

  constructor() {
    /*     effect(() => {
      this.timeline.setData({ items: this.data() });
    }); */
  }
  ngAfterViewInit(): void {
    const options: vis.TimelineOptions = {
      zoomable: false,
      moveable: false,
    };
    console.log(this.items());

    this.timeline = new vis.Timeline(
      this.timelineContainer.nativeElement,
      this.data(),
      options,
    );
  }
  ngOnDestroy(): void {
    this.timeline.destroy();
  }
}
