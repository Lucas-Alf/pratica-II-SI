import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { LoaderService } from 'src/app/services/loader.service';
import axios from 'axios';
import { ConstantsService } from 'src/app/common/services/constants.service';
import { Incidencia } from '../incidencia';

@Component({
  selector: 'app-incidencia-modal',
  templateUrl: './incidencia-modal.component.html',
  styleUrls: ['./incidencia-modal.component.css']
})
export class IncidenciaModalComponent implements OnInit {
  codigoHabilitado: boolean;
  codigo: number;
  descricao: string;
  constructor(
    @Inject(MAT_DIALOG_DATA) public data,
    public dialogRef: MatDialogRef<IncidenciaModalComponent>,
    private snackBar: MatSnackBar,
    private loaderService: LoaderService,
    private constant: ConstantsService
  ) { }

  close(): void {
    this.dialogRef.close();
  }

  save(): void {
    const dados: Incidencia = { id: this.codigo, descricao: this.descricao };
    this.data.component.salvar(this.data.action, dados);
  }

  ngOnInit(): void {
    if (this.data.info) {
      this.codigo = this.data.info.id;
      this.descricao = this.data.info.descricao;
      this.codigoHabilitado = false;
    } else {
      this.codigoHabilitado = true;
    }
  }
}
