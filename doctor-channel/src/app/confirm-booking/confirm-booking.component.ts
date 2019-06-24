import { Component, OnInit } from '@angular/core';
import {DoctorChannelingService} from '../service/doctor-channeling.service';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-confirm-booking',
  templateUrl: './confirm-booking.component.html',
  styleUrls: ['./confirm-booking.component.css']
})
export class ConfirmBookingComponent implements OnInit {

  sessionDetails = {};

  constructor(private doctorChannelingService: DoctorChannelingService,
              private route: ActivatedRoute) { }

  ngOnInit() {
    this.doctorChannelingService.findSessionDetails(this.route.snapshot.params.id)
      .subscribe(res => {
        this.sessionDetails = res;
      });
  }

}
