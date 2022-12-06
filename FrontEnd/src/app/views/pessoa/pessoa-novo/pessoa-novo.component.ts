import { Component, OnInit } from '@angular/core';
import { MessageService } from 'primeng/api';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Contato } from 'src/app/model/Contato';
import { Pessoa } from 'src/app/model/Pessoa';
import { PessoaCadastro } from 'src/app/model/PessoaCadastro';
import { ApiService } from 'src/app/service/api.service';
import { MAT_DATE_FORMATS } from '@angular/material/core';

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
  selector: 'app-pessoa-novo',
  templateUrl: './pessoa-novo.component.html',
  styleUrls: ['./pessoa-novo.component.css'],
  providers: [
    { provide: MAT_DATE_FORMATS, useValue: MY_DATE_FORMATS }
  ]
})
export class PessoaNovoComponent implements OnInit {
  form!: FormGroup

  pessoaLista: Pessoa[] = [];
  contatoLista: Contato[] = [];
  pessoa : PessoaCadastro = {
    id: 0,
    nome: '',
    cpf: '',
    dataNascimento: '',
    contatos: []
  };

  contato : Contato = {
    nome : '',
    telefone : '',
    email : ''
  }

  constructor(
    private pessoaService : ApiService,
    public messageService: MessageService,
    private router: Router,
    private fb: FormBuilder
  ) {
      this.form = this.fb.group({
        pessoaNome: ['', [Validators.required]],
    })
  }

  ngOnInit(): void {
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
  adcionarContato(){
    this.pessoa.contatos.push(this.contato);
    this.limparContato();
  }

  editarPessoa(contato: any, index: number){
    this.contato = contato;
    this.pessoa.contatos.indexOf(contato);
  }

  limparContato() {
    this.contato = {
      nome : '',
      email : '' ,
      telefone : ''
    }
  }
}
