import { Page } from './../../../model/Paginacao';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Pessoa } from 'src/app/model/Pessoa';
import { ApiService } from 'src/app/service/api.service';
import { PageEvent } from '@angular/material/paginator';

@Component({
  selector: 'app-pessoa-lista',
  templateUrl: './pessoa-lista.component.html',
  styleUrls: ['./pessoa-lista.component.css']
})
export class PessoaListaComponent implements OnInit {

  pageEvent: PageEvent = new PageEvent;
  datasource: any = null;
  pageSizeOptions: number[] = [2 ,5, 10, 12, 15];
  pageIndex: number = 0;
  pageSize: number = 2;
  length: number = 0;

  pessoaLista: Pessoa[] = [];

  pessoa: Pessoa = {
    id : 0,
    nome : '',
    cpf : '',
    dataNascimento : ''
  }

  totalPages = 0;
  totalElements = 0;
  currentPage = 0;
  search : string = '';

  constructor(
    private route: ActivatedRoute ,
    public pessoaService : ApiService,
    private router : Router) { }

  ngOnInit(): void {
    this.listarPessoas();
  }

  listarPessoas(){
    this.pessoaService.getListaPessoas(this.search, this.totalPages, 2).subscribe(
      (res : any) => {
        this.pessoaLista = res.content;
        this.length =res.totalElements;
    });
  }
  editarPessoa(id: number) {
    this.router.navigate(['/pessoas/alterar', id])
  }

  novaPessoa():void {
    this.router.navigate(['/pessoas/novo'])
  }

  deletarPessoa(pessoa : Pessoa) :void{
    this.pessoaService.deletar(pessoa.id).subscribe(res => {
      this.listarPessoas()
    })
  }

  handlePageEvent(event:any){
    this.pessoaService.getListaPessoas('', event.pageIndex, event.pageSize).subscribe(
      (res : any) => {
        this.pessoaLista = res.content;
        this.length =res.totalElements;


    });

  }
}
