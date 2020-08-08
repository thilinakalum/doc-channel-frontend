import { Component, OnInit, ViewChild } from '@angular/core';
import { NgxSmartModalService } from 'ngx-smart-modal';
import { SnotifyService } from 'ng-snotify';
import { AppSettings } from 'src/app/settings/app-settings';
import { User } from '../../security/model/model.user';
import { NgxSpinnerService } from "ngx-spinner";
import { CommonService } from './service/common.service';
import { Doctor } from './model/doctor';
import { DoctorCategory } from './model/doctor-category';

@Component({
  selector: 'app-m-product',
  templateUrl: './m-product.component.html',
  styleUrls: ['./m-product.component.css']
})
export class MProductComponent implements OnInit {

  public doctorList: Doctor[] = [];
  public doctorCategoryList: DoctorCategory[] = [];
  public doctor = new Doctor();

  constructor(
    private ngxSmartModalService: NgxSmartModalService,
    private snotifyService: SnotifyService,
    private ngxSpinnerService: NgxSpinnerService,
    private commonService: CommonService) { }

  ngOnInit() {
    this.findAll();
  }

  openMasterForm() {
    this.doctor = new Doctor();
    this.ngxSmartModalService.open('masterForm');
  }

  findAll() {
    this.ngxSpinnerService.show();
    this.commonService.findAllDoctors().subscribe((data) => {
      this.doctorList = data;

      this.commonService.findAllCategories().subscribe((data) => {
        this.doctorCategoryList = data;
        this.ngxSpinnerService.hide();
      }, (e) => {
        this.doctorList = [];
        this.ngxSpinnerService.hide();
      });

    }, (e) => {
      this.doctorList = [];
      this.ngxSpinnerService.hide();
    });
  }

  edit(rowNo, data) {
    this.doctor = data;
    this.ngxSmartModalService.open('masterForm');
  }

  delete(rowNo,data) {
    this.snotifyService.confirm('Confirm ?..', AppSettings.MESSAGE_WARNING, {
      timeout: 5000,
      showProgressBar: false,
      closeOnClick: false,
      pauseOnHover: false,
      buttons: [
        {
          text: 'Yes, Delete It..', action: (toast) => {
            this.ngxSpinnerService.show();
            this.commonService.delete(data.id).subscribe((data) => {
              this.snotifyService.success('Delete doctor success', AppSettings.MESSAGE_SUCCESS, {
                timeout: 2000,
                showProgressBar: false,
                closeOnClick: false,
                pauseOnHover: false
              });
              this.doctorList.splice(rowNo, 1);
              this.snotifyService.remove(toast.id);
              this.ngxSpinnerService.hide();
            }, (e) => {
              console.log(e)
              this.ngxSpinnerService.hide();
              this.snotifyService.error('Delete doctor error', AppSettings.MESSAGE_ERROR, {
                timeout: 2000,
                showProgressBar: false,
                closeOnClick: false,
                pauseOnHover: false
              });
            });
          }
        },
        {
          text: 'No', action: (toast) => {
            this.snotifyService.remove(toast.id);
          }, bold: true
        },
      ]
    });
  }
}
