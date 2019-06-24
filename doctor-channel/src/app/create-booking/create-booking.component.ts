import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {DoctorChannelingService} from '../service/doctor-channeling.service';
import {DoctorSession} from '../dto/doctor-session';
import {Doctor} from '../dto/doctor';

@Component({
  selector: 'app-create-booking',
  templateUrl: './create-booking.component.html',
  styleUrls: ['./create-booking.component.css']
})
export class CreateBookingComponent implements OnInit {

  private doctorSessionList: DoctorSession [] = [];
  private doctor: Doctor;

  constructor(private route: ActivatedRoute, private doctorChannelingService: DoctorChannelingService) {
    this.doctor = new Doctor();
    this.doctorSessionList = [];
    this.doctorChannelingService.findDoctorSessionByDoctorAnd(this.route.snapshot.params.doctor, this.route.snapshot.params.date)
      .subscribe((data: DoctorSession[]) => {
          this.doctorSessionList = data;
          this.doctor = this.doctorSessionList[0].fkDoctor;
        }, (e) => {
          this.doctorSessionList = [];
        }
      );

  }

  ngOnInit(): void {
  }


}
