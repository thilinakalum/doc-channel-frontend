import {DoctorCategory} from './doctor-category';

export class Doctor extends DoctorCategory {
  id: number;
  name: string;
  description: string;
  qualification: string;
  fkDoctorCategory: DoctorCategory;
}
