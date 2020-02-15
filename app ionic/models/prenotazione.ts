import { Acquirente } from './acquirente';
import { Proposta } from './proposta';


export interface Prenotazione{
    idprenotazione: number;
    datatransazione:Date;
    datacheckin:Date;
    datacheckout:Date;
    costotot:number;
    acquirente: Acquirente;
    proposta: Proposta;

}

