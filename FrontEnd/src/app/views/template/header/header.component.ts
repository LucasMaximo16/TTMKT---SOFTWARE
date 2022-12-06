import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ApiService } from 'src/app/service/api.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private route: ActivatedRoute ,
    public pessoaService : ApiService,
    private router : Router) { }

  ngOnInit(): void {
  }

  Home(){
    this.router.navigate([''])
  }



}
