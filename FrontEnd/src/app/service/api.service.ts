import { Page } from './../model/Paginacao';
import { ContatoPessoa } from './../model/ContatoPessoa';
import { PessoaCadastro } from './../model/PessoaCadastro';
import { Contato } from './../model/Contato';
import { Pessoa } from 'src/app/model/Pessoa';

import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http'


@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private url = 'http://localhost:8080/pessoas';
  private listaPessoas: Pessoa[];
  page : any
  size : any


private headers = new HttpHeaders()
  .set('content-type', 'application/json')
  .set('Access-Control-Allow-Origin', '*');

  constructor(private httpClient:HttpClient ) {
    this.listaPessoas = [];
  }

  getListaPessoas(filtro : string, page: any , size : any):Observable<any[]> {
    let param = new HttpParams().set('size', size).set('page', page);
      return this.httpClient.get<any[]>(this.url + "/?filtro=" + filtro, {params: param});
    }

  getListaContato(contatoDTOS : ContatoPessoa[]):Observable<any[]> {
      return this.httpClient.get<any[]>(this.url + "/" + contatoDTOS);
    }

  getListaPage(page : any , size : any): Observable<Page>{
    page = this.page
    size = this.size
    return this.httpClient.get<Page>(this.url + "?page="+ page + "&size=" + size);
  }

  cadastrarPessoa(obj : Pessoa):Observable<any>{
    return this.httpClient.post<any>(this.url,obj, {"headers" : this.headers});
  }

  getById(obj : Pessoa):Observable<any>{
    return this.httpClient.get<any>(this.url + "/" + obj.id,{"headers" : this.headers});
  }

   atualizar(obj : Partial<Pessoa>){
    return this.httpClient.put<Pessoa>(this.url + "/" + obj.id, obj,{"headers" : this.headers});
  }

  atualizarContato(c : Partial<Contato> ,  p : Partial<Pessoa>){
    return this.httpClient.put<Contato>(this.url + "/" + p.id + "/contato" + "/" + c.id, c ,{"headers" : this.headers} )
  }

  deletar(id : number) : Observable<any>{
    return this.httpClient.delete<any>(this.url + "/" + id);
  }


}
