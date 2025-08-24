import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NmahComponent } from './nmah.component';

describe('NmahComponent', () => {
  let component: NmahComponent;
  let fixture: ComponentFixture<NmahComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NmahComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NmahComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
