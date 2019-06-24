import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {CreateBookingComponent} from './create-booking/create-booking.component';
import {HomeComponent} from './home/home.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'create-booking', component: CreateBookingComponent},
  {path: 'create-booking/:doctor', component: CreateBookingComponent},
  {path: 'create-booking/:doctor/:date', component: CreateBookingComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
