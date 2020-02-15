import { Acquirente } from './acquirente';
import { Proposta } from './proposta';
import { Proponente } from './proponente';


export interface Notifica{
    idnotifica: number;
    descrizione: string;
    tipo: number;
    data: Date;
    proposta: Proposta;
    acquirente: Acquirente;
    proponente: Proponente;

}