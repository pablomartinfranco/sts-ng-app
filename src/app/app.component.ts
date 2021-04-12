import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'Client';
  data: any = { id: "", content: "" };
  weather: any = { main: { temp: "", humidity: "", pressure: "" } };
  constructor(private http: HttpClient) {
    http.get('resource').subscribe(data => this.data = data);
    http.get('weather').subscribe(data => this.weather = data);
  }
}
