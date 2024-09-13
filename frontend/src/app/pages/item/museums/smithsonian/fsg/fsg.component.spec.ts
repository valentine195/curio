import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FsgComponent } from './fsg.component';

describe('FsgComponent', () => {
  let component: FsgComponent;
  let fixture: ComponentFixture<FsgComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FsgComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FsgComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
