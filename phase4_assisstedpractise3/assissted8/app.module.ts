import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReversePipe } from './reverse.pipe';
import { YourComponent } from './your-component/your-component.component';

@NgModule({
  declarations: [
    ReversePipe,
    YourComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [YourComponent]
})
export class AppModule { }
