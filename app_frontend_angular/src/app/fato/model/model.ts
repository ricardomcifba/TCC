export interface Page {
    content: Array<Fato>;
    totalPages: number;
    totalElements: number;
    last: boolean;
    size: number;
    number: number;
    sort?: any;
    numberOfElements: number;
    first: boolean;
};

export interface Fato {
    idFato: number;
    idOrganizacao: number;
    idEndereco: number;
    idServico: number;
    idTempo: number;
    total: number;
    perdaAgua: number;
    perdaFinanceira: number;
};