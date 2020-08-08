import {Injectable} from '@angular/core';
import {DoctorSession} from './doctor-session';
import {Doctor} from './doctor';
import {Customer} from './customer';

@Injectable()
export class Booking {
  id: number;
  fkDoctor: Doctor;
  fkSession: DoctorSession;
  fkCustomer: Customer;
  bookingNo: number;
}
