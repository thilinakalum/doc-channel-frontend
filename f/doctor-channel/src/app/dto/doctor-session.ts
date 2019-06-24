import {Doctor} from './doctor';

export class DoctorSession {
  id: number;
  date: Date;
  startTime: string;
  endTime: string;
  maxEpointments: number;
  availaility: number;
  fkDoctor: Doctor;
}
