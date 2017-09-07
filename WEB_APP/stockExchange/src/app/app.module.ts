import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from "@angular/core";
import { StompService } from 'ng2-stomp-service';
import { AppComponent } from './app.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {NvD3Module} from "ng2-nvd3";
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    NvD3Module,
     FormsModule
    ],
  providers: [StompService],
  bootstrap: [AppComponent]
})
export class AppModule { }
