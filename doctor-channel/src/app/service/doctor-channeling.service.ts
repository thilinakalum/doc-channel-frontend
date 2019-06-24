import {Injectable} from '@angular/core';
import {AppSettings} from '../settings/app-settings';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DoctorChannelingService {

  constructor(private http: HttpClient) {
  }

  public findAllDoctors() {
    return this.http.get(AppSettings.API_ENDPOINT + '/api/doctor-channeling/find-all-doctors');
  }


  public findAllDoctorCategorys() {
    return this.http.get(AppSettings.API_ENDPOINT + '/api/doctor-channeling/find-all-doctor-categorys');
  }

  public findDoctorSessionByDoctorAnd(doctor: number, date: string) {
    let url = AppSettings.API_ENDPOINT + '/api/doctor-channeling/find-doctor-session-by-doctor-and-date';
    if (doctor) {
      url = url + '/' + doctor;
    }

    if (date) {
      url = url + '/' + date;
    }

    console.log(url);
    return this.http.get(url);
  }
}
