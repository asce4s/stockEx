import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import { StompService } from 'ng2-stomp-service';
import 'd3';
import 'nvd3';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css','../../node_modules/nvd3/build/nv.d3.css'],
  encapsulation: ViewEncapsulation.None
})
export class AppComponent implements OnInit {

  private subscription : any;

  constructor(private stomp: StompService) {}

  options;
  data;
  ngOnInit() {
    this.connect();
    this.initChart()

  }

  private connect():void{
    const HOST='http://localhost:8080/ws';
    //configuration
    this.stomp.configure({
      host:HOST,
      debug:false,
      queue:{'init':false}
    });

    //start connection
    this.stomp.startConnect().then(() => {
      this.stomp.done('init');
      console.log('connected');

      //subscribe
      this.subscription = this.stomp.subscribe('/data/subscribe', (d) => {
        this.data= [d]
      });

      //send data
      // stomp.send('/app/send',JSON.stringify({"name":"asjkhfd"}));
      //unsubscribe
      // this.subscription.unsubscribe();

      //disconnect
      // stomp.disconnect().then(() => {
      //   console.log( 'Connection closed' )
      // })

    });
  }
  private initChart():void{
    this.options = {
      chart: {
        type: 'candlestickBarChart',
        height: 450,
        margin : {
          top: 20,
          right: 20,
          bottom: 50,
          left: 55
        },
        x: function(d){return new Date(d.date);},
        y: function(d){return d.close;},
        showValues: true,
        useInteractiveGuideline: true,
        useNiceScale: true,
        duration: 0,
        xAxis: {
          axisLabel: new Date().toDateString(),
          tickFormat: function(d) {
            return d3.time.format('%H:%M:%S')(new Date(d));
          },
          showMaxMin: false
        },
        yAxis: {
          axisLabel: 'Closing Price',
          axisLabelDistance: -10,

        },
        zoom: {
          enabled: true,
          scaleExtent: [1, 100],
          useFixedDomain: false,
          useNiceScale: false,
          horizontalOff: false,
          verticalOff: true,
          unzoomEventType: 'dblclick.zoom'
        }
      }
    }
  }





}
