import {Component, OnInit} from '@angular/core';
import {DoctorChannelingService} from '../service/doctor-channeling.service';
import {ActivatedRoute} from '@angular/router';
import {Booking} from '../dto/booking';
import {DoctorSession} from '../dto/doctor-session';
import {Customer} from '../dto/customer';

@Component({
  selector: 'app-confirm-booking',
  templateUrl: './confirm-booking.component.html',
  styleUrls: ['./confirm-booking.component.css']
})
export class ConfirmBookingComponent implements OnInit {

  booking: Booking;
  customer: Customer;
  doctorSession: DoctorSession;

  constructor(private doctorChannelingService: DoctorChannelingService,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.customer = new Customer();
    this.doctorChannelingService.findSessionDetails(this.route.snapshot.params.id)
      .subscribe((res: DoctorSession) => {

        this.doctorSession = res;

        // this.booking.fkSession = res;
        // this.booking.fkDoctor = res.fkDoctor;
      });
  }

}
