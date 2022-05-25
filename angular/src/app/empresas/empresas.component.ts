import { Component, OnInit } from '@angular/core';

interface Company {
  id: number;
  name: string;
  cnpj: string;
  data_cadastro: string;
}

const COMPANIES: Company[] = [
  {
    id: 0,
    name: 'FepWeb',
    cnpj: '9999999999',
    data_cadastro: '25-05-2022'
  },
];

@Component({
  selector: 'app-empresas',
  templateUrl: './empresas.component.html',
  styleUrls: ['./empresas.component.css']
})

export class EmpresasComponent implements OnInit {
  URL_API = 'http://localhost:8080/empresas';
  empresas = {};
  companies = COMPANIES;

  constructor() { }

  ngOnInit(): void {
    fetch(this.URL_API)
      .then(res => res.json()).then(data => {
        console.log(data)
        data.results.map((empresa: { id: any; nome: any; cnpj: any; }) => {
          this.empresas = {
            id: empresa.id,
            nome: empresa.nome,
            cnpj: empresa.cnpj,
            data_cadastro: data.data_cadastro
          }
        })
      })
  }
}
