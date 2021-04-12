import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import * as types from './app.types';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'Client';
  information: any = { id: "", title: "" };
  weather: any = { main: { temp: "", humidity: "", pressure: "" } };
  forecast: types.Forecast = null;
  constructor(private http: HttpClient) {
    http.get('information').subscribe(data => this.information = data);
    http.get('weather').subscribe(data => this.weather = data);
    http.get('forecast').subscribe(data => this.forecast = data as types.Forecast);
  }
}
