import { Component } from '@angular/core';
import { StompService } from 'ng2-stomp-service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  private subscription : any;

  constructor(stomp: StompService) {

    //configuration
    stomp.configure({
      host:'http://localhost:8080/ws',
      debug:true,
      queue:{'init':false}
    });

    //start connection
    stomp.startConnect().then(() => {
      stomp.done('init');
      console.log('connected');

      //subscribe
      this.subscription = stomp.subscribe('/data/subscribe', (d) => {
        console.log("afh");
        console.log(d);
      });

      //send data
      stomp.send('/app/send',{});
      //unsubscribe
     // this.subscription.unsubscribe();

      //disconnect
      // stomp.disconnect().then(() => {
      //   console.log( 'Connection closed' )
      // })

    });


  }

//response
  public response = (data) => {
    console.log("afh")
    console.log(data)
  }
}
