import { ContatoPessoa } from './../../../model/ContatoPessoa';
import { PessoaCadastro } from './../../../model/PessoaCadastro';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { Contato } from 'src/app/model/Contato';
import { Pessoa } from 'src/app/model/Pessoa';
import { ApiService } from 'src/app/service/api.service';
import { MAT_DATE_FORMATS } from '@angular/material/core';
import { Page } from 'src/app/model/Paginacao';

export const MY_DATE_FORMATS = {
  parse: {
    dateInput: 'DD/MM/YYYY',
  },
  display: {
    dateInput: 'DD/MM/YYYY',
    monthYearLabel: 'MMMM YYYY',
    dateA11yLabel: 'LL',
    monthYearA11yLabel: 'MMMM YYYY'
  },
};

@Component({
  selector: 'app-pessoa-alterar',
  templateUrl: './pessoa-alterar.component.html',
  styleUrls: ['./pessoa-alterar.component.css'],
  providers: [
    { provide: MAT_DATE_FORMATS, useValue: MY_DATE_FORMATS }
  ]
})
export class PessoaAlterarComponent implements OnInit {

  page!: Page;
  pessoaLista: Pessoa[] = [];
  contatoDTOS: ContatoPessoa[] = [];

  pessoa : ContatoPessoa = {
    id: 0,
    nome: '',
    cpf: '',
    dataNascimento: '',
    contatoDTOS: []
  };

  contatosDTOS : Contato = {
    nome : '',
    telefone : '',
    email : ''
  }

  constructor(
    private route: ActivatedRoute ,
    private pessoaService : ApiService,
    public messageService: MessageService,
    private router: Router) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => this.pessoa.id = params['id'])
    this.pessoaService.getById(this.pessoa).subscribe(res => {
      this.pessoa = res;
    })
  }

  atualizarCadastro(){
    this.pessoaService.atualizar(this.pessoa).subscribe(res => {
    })
    this.router.navigate(['pessoas'])
  }

  atualizarContato(){
    this.pessoaService.atualizarContato(this.contatosDTOS, this.pessoa).subscribe(res => {
    })
  }

  editarPessoa(contato: any, index: number){
    this.contatosDTOS = contato;
    this.pessoa.contatoDTOS.indexOf(contato);
  }

  cancelar(): void {
    this.router.navigate(['pessoas'])
  }

  cadastrarPessoa(){
    this.pessoaService.cadastrarPessoa(this.pessoa).subscribe((pessoa : Pessoa[])=> {
      this.cancelar()
    },
     err => {

      if (err.error.status === 422) {
        this.messageService.add({ severity: 'warn', summary: 'Atenção', detail: err.error.message });
      } else {
        this.messageService.add({ severity: 'error', summary: 'Error', detail: err.error.message });
      }
    });
  }

  listarContato(){
    this.pessoaService.getListaContato(this.contatoDTOS).subscribe(
      (res : any) => {
        this.contatoDTOS = res.content;

    });
 }
}
