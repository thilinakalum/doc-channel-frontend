import {Customer} from './customer';
import {DoctorSession} from './doctor-session';
import {Doctor} from './doctor';

export class Booking {
  id: number;
  fkDoctor: Doctor;
  fkSession: DoctorSession;
  fkCustomer: Customer;
  bookingNo: number;
}
