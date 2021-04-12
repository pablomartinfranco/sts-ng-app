export interface Forecast {
    city:    City;
    cnt:     number;
    cod:     string;
    message: number;
    list:    List[];
}

export interface City {
    country:    string;
    coord:      Coord;
    sunrise:    number;
    timezone:   number;
    sunset:     number;
    name:       string;
    id:         number;
    population: number;
}

export interface Coord {
    lon: number;
    lat: number;
}

export interface List {
    dt:         number;
    pop:        number;
    visibility: number;
    dt_txt:     Date;
    weather:    Weather[];
    main:       Main;
    clouds:     Clouds;
    sys:        Sys;
    wind:       Wind;
}

export interface Clouds {
    all: number;
}

export interface Main {
    temp:       number;
    temp_min:   number;
    grnd_level: number;
    temp_kf:    number;
    humidity:   number;
    pressure:   number;
    sea_level:  number;
    feels_like: number;
    temp_max:   number;
}

export interface Sys {
    pod: string;
}

export interface Weather {
    icon:        string;
    description: string;
    main:        string;
    id:          number;
}

export interface Wind {
    deg:   number;
    speed: number;
}
