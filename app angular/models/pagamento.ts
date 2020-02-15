import { Acquirente } from './acquirente';

export interface Pagamento{

    idpagamento: number;
    metodo: string;
    importo: number;
    datatransazione: Date;
    acquirente: Acquirente;

}