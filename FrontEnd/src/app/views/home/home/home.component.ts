import { Pessoa } from './../../../model/Pessoa';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ApiService } from 'src/app/service/api.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private route: ActivatedRoute ,
    public pessoaService : ApiService,
    private router : Router) { }

  ngOnInit(): void {
  }


  Pessoa(){
    this.router.navigate(['/pessoas'])
  }

}
