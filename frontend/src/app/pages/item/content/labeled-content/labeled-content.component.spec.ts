import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LabeledContentComponent } from './labeled-content.component';

describe('LabeledContentComponent', () => {
  let component: LabeledContentComponent;
  let fixture: ComponentFixture<LabeledContentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LabeledContentComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LabeledContentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
