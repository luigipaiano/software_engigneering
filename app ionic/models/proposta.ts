import { Beneservizio } from './beneservizio';
import { Proponente } from './proponente';


export interface Proposta{
    idproposta: number;
    nome: string;
    descrizione:string;
    datainiziodisp: Date;
    datafinedisp: Date;
    disponibilita: number;
    costounitario: number;
    posizione: string;
    stato: number;
    datacreamodpr: Date;
    beneservizio: Beneservizio;
    proponente: Proponente;
    
}

