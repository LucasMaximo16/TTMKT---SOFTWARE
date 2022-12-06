import { Contato } from "./Contato";

export interface ContatoPessoa {
  id : number;
  nome : string;
  cpf : string;
  dataNascimento : string;
  contatoDTOS : Contato []

}
