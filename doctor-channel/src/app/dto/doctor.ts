import {Injectable} from '@angular/core';
import {DoctorCategory} from './doctor-category';

@Injectable()
export class Doctor extends DoctorCategory {
  id: number;
  name: string;
  description: string;
  qualification: string;
  fkDoctorCategory: DoctorCategory;
}
