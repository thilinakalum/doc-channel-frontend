import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-create-booking',
  templateUrl: './create-booking.component.html',
  styleUrls: ['./create-booking.component.css']
})
export class CreateBookingComponent implements OnInit {

  constructor(private httpService: HttpClient) { }

  ngOnInit() {
    let ob = this.httpService.get('http://123.231.92.110:8093/api/v1/gflock-online-order-manage-system/find-all-delivery-company');
    ob.subscribe(res => {
      console.log(res);
    });
  }

}
