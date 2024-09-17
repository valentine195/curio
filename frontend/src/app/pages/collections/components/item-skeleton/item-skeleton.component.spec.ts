import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ItemSkeletonComponent } from './item-skeleton.component';

describe('ItemSkeletonComponent', () => {
  let component: ItemSkeletonComponent;
  let fixture: ComponentFixture<ItemSkeletonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ItemSkeletonComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ItemSkeletonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
