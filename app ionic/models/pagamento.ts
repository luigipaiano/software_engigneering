import { Acquirente } from './acquirente';
import { Prenotazione } from './prenotazione';

export interface Pagamento{

    idpagamento: number;
    metodo: string;
    importo: number;
    datatransazione: any;
    acquirente: Acquirente;
    prenotazione: Prenotazione;

}