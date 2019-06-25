import { Component, OnInit } from '@angular/core';
import {DoctorChannelingService} from '../service/doctor-channeling.service';
import {ActivatedRoute} from '@angular/router';
import {Booking} from '../dto/booking';
import {DoctorSession} from '../dto/doctor-session';

@Component({
  selector: 'app-confirm-booking',
  templateUrl: './confirm-booking.component.html',
  styleUrls: ['./confirm-booking.component.css']
})
export class ConfirmBookingComponent implements OnInit {

  booking: Booking;

  constructor(private doctorChannelingService: DoctorChannelingService,
              private route: ActivatedRoute) { }

  ngOnInit() {
    this.doctorChannelingService.findSessionDetails(this.route.snapshot.params.id)
      .subscribe((res: DoctorSession) => {
        this.booking.fkSession = res;
        this.booking.fkDoctor = res.fkDoctor;
      });
  }

}
