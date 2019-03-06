import { async, ComponentFixture, TestBed } from '@angular/core/testing';
//import { TestBed } from '@angular/core/testing';

import { MapsComponent } from './maps.component';
import { VazamentoService } from './maps.service';

describe('VazamentoService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: VazamentoService = TestBed.get(VazamentoService);
    expect(service).toBeTruthy();
  });
});

describe('MapsComponent', () => {
  let component: MapsComponent;
  let fixture: ComponentFixture<MapsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MapsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MapsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
