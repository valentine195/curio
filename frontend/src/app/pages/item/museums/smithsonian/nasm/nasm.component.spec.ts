import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NasmComponent } from './nasm.component';

describe('NasmComponent', () => {
  let component: NasmComponent;
  let fixture: ComponentFixture<NasmComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NasmComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NasmComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
