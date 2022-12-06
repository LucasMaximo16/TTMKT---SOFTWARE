import { Contato } from "./Contato";

export interface PessoaCadastro {

  id : number;
  nome : string;
  cpf : string;
  dataNascimento : string;
  contatos: Contato[];
}
