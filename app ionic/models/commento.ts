import { Acquirente } from './acquirente';
import { Proposta } from './proposta';

export interface Commento{

    idcommento: number;
    tipo: number;
    val: number;
    descrizione: string;
    data: Date;
    acquirente: Acquirente;
    proposta: Proposta;


}