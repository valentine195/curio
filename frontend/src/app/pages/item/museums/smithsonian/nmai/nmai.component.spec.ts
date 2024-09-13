import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NmaiComponent } from './nmai.component';

describe('NmaiComponent', () => {
  let component: NmaiComponent;
  let fixture: ComponentFixture<NmaiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NmaiComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NmaiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
