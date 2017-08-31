import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from "@angular/core";
import { StompService } from 'ng2-stomp-service';
import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [StompService],
  bootstrap: [AppComponent]
})
export class AppModule { }
