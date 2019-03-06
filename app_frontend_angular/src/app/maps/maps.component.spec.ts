import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import {NgZone} from '@angular/core';
import { inject} from '@angular/core/testing';

import {AgmMarker} from '@agm/core';
import {GoogleMapsAPIWrapper} from '@agm/core';
import {Marker} from '@google/markerclusterer';
import {ClusterManager} from '@google/markerclusterer';
import * as MarkerClusterer from '@google/markerclusterer';

import { MapsComponent } from './maps.component';

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


