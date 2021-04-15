import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import * as model from './app.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {

  title = 'Client';
  forecast: model.Forecast;
  session: String;

  constructor(private readonly http: HttpClient) {
    this.http.get('forecast').subscribe(data => this.forecast = data as model.Forecast);
    this.http.get('session').subscribe(data => this.session = data as String);
  }

  get location(): String { return `${this.forecast.city.name}, ${this.forecast.city.country}`; }

  get forecastDaily(): model.ForecastItem[] { return this.forecast.list.filter((item, index) => index % 8 == 0); }

}
