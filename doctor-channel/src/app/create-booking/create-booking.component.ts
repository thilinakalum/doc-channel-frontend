import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
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
  private passingDate: string;

  constructor(private route: ActivatedRoute,
              private doctorChannelingService: DoctorChannelingService,
              private router: Router) {
    this.doctor = new Doctor();
    this.doctorSessionList = [];
  }

  ngOnInit(): void {
    this.passingDate = this.route.snapshot.params.date.toString();
    console.log('DATE : ' + this.passingDate);
    this.doctorChannelingService.findDoctorSessionByDoctorAnd(this.route.snapshot.params.doctor, this.passingDate)
      .subscribe((data: DoctorSession[]) => {
          console.log('DATA : ' + data);
          this.doctorSessionList = data;
          this.doctor = this.doctorSessionList[0].fkDoctor;
        }, (e) => {
          this.doctorSessionList = [];
        }
      );
  }

  confirmbooking(sessionDetails) {
    this.router.navigate(['confirm-booking', sessionDetails.id]);
  }
}
