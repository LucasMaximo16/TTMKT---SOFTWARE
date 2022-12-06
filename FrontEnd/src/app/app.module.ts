import { ApiService } from './service/api.service';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule, HttpClient} from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import {MatMenuModule} from '@angular/material/menu';
import {MatDatepickerModule} from '@angular/material/datepicker'
import {MatNativeDateModule, MatRippleModule} from '@angular/material/core';
import { MomentDateModule } from '@angular/material-moment-adapter';
import { PessoaListaComponent } from './views/pessoa/pessoa-lista/pessoa-lista.component';
import { PessoaNovoComponent } from './views/pessoa/pessoa-novo/pessoa-novo.component';
import { PessoaAlterarComponent } from './views/pessoa/pessoa-alterar/pessoa-alterar.component';
import { FooterComponent } from './views/template/footer/footer.component';
import { HeaderComponent } from './views/template/header/header.component';
import { MessageService, ConfirmationService } from 'primeng/api';
import { ToastModule } from 'primeng/toast';
import { TableModule } from 'primeng/table';
import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { CalendarModule } from 'primeng/calendar';
import { InputMaskModule } from 'primeng/inputmask';
import { DropdownModule } from 'primeng/dropdown';
import { MessagesModule } from 'primeng/messages';
import { MessageModule } from 'primeng/message';
import { PanelModule } from 'primeng/panel';
import { MenuModule } from 'primeng/menu';
import { CardModule } from 'primeng/card';
import {ScrollPanelModule} from 'primeng/scrollpanel';
import {TabViewModule} from 'primeng/tabview';
import {FieldsetModule} from 'primeng/fieldset';
import {KeyFilterModule} from 'primeng/keyfilter';
import {DialogModule} from 'primeng/dialog';
import {ProgressSpinnerModule} from 'primeng/progressspinner';
import {ConfirmDialogModule} from 'primeng/confirmdialog';
import {OverlayPanelModule} from 'primeng/overlaypanel';
import {LightboxModule} from 'primeng/lightbox';
import {TooltipModule} from 'primeng/tooltip';
import {MultiSelectModule} from 'primeng/multiselect';
import {RadioButtonModule} from 'primeng/radiobutton';
import {BlockUIModule} from 'primeng/blockui';
import {CheckboxModule} from 'primeng/checkbox';
import {SelectButtonModule} from 'primeng/selectbutton';
import {PaginatorModule} from 'primeng/paginator';
import {AccordionModule} from 'primeng/accordion';
import {TriStateCheckboxModule} from 'primeng/tristatecheckbox';
import {InputSwitchModule} from 'primeng/inputswitch';
import {ListboxModule} from 'primeng/listbox';
import { AutoCompleteModule } from 'primeng/autocomplete';
import { NgxPaginationModule } from 'ngx-pagination';
import { SweetAlert2Module } from '@sweetalert2/ngx-sweetalert2';
import {MatPaginatorModule} from '@angular/material/paginator';
import { MatChipsModule } from '@angular/material/chips';
import { HomeComponent } from './views/home/home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    PessoaListaComponent,
    PessoaNovoComponent,
    PessoaAlterarComponent,
    FooterComponent,
    HeaderComponent,
    HomeComponent
  ],
  exports: [
    MatPaginatorModule,
    MatChipsModule,
    ToastModule,
    TableModule,
    InputTextModule,
    ButtonModule,
    CalendarModule,
    InputMaskModule,
    DropdownModule,
    MessagesModule,
    MessageModule,
    PanelModule,
    MenuModule,
    CardModule,
    ScrollPanelModule,
    TabViewModule,
    FieldsetModule,
    KeyFilterModule,
    DialogModule,
    ProgressSpinnerModule,
    ConfirmDialogModule,
    OverlayPanelModule,
    LightboxModule,
    TooltipModule,
    MultiSelectModule,
    RadioButtonModule,
    BlockUIModule,
    CheckboxModule,
    SelectButtonModule,
    PaginatorModule,
    AccordionModule,
    TriStateCheckboxModule,
    InputSwitchModule,
    ListboxModule,
    AutoCompleteModule,
  ],
  imports: [
    SweetAlert2Module,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatButtonModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatRippleModule,
    MomentDateModule,
    FormsModule,
    ReactiveFormsModule,
    ToastModule,
    CardModule,
    NgxPaginationModule,
    CalendarModule,
    PaginatorModule,
    MatPaginatorModule,
    MatChipsModule,
    MatToolbarModule,
    MatIconModule,
    MatMenuModule
  ],
  providers: [
    HttpClient,
    ApiService,
    MessageService,
    ConfirmationService

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
