import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChndmComponent } from './chndm.component';

describe('ChndmComponent', () => {
  let component: ChndmComponent;
  let fixture: ComponentFixture<ChndmComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ChndmComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ChndmComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
