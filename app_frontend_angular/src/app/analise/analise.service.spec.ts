import { async, ComponentFixture, TestBed } from '@angular/core/testing';
//import { TestBed } from '@angular/core/testing';

import { AnaliseComponent } from './analise.component';
import { AnaliseService } from './analise.service';

describe('AnaliseService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AnaliseService = TestBed.get(AnaliseService);
    expect(service).toBeTruthy();
  });
});

describe('AnaliseComponent', () => {
  let component: AnaliseComponent;
  let fixture: ComponentFixture<AnaliseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AnaliseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AnaliseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
