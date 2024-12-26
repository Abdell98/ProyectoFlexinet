package com.eulen.flexinet.core.test.selenium.reader;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TestDatosGestionITs {

    @SerializedName("GESTION_DE_ITS")
    private GestionITs gestionITs;

    @NoArgsConstructor
    @Getter
    public static class GestionITs {
        private String nombre;
        private String primerApellido;
        private String segundoApellido;
        private String nif;
        private String traspasado;

        @SerializedName("TABLE")
        private Table table;

        @NoArgsConstructor
        @Getter
        public static class Table {
            @SerializedName("Fecha Inicio")
            private String fechaInicio;
            @SerializedName("Fecha Fin")
            private String fechaFin;
            @SerializedName("Tipo IT")
            private String tipoIT;
            @SerializedName("Descripción")
            private String descripcion;
        }

        @SerializedName("DIALOG_SELECCIONDECOLABORADORES")
        private DialogoSeleccionDeColaboradores dialogoSeleccionDeColaboradores;

        @NoArgsConstructor
        @Getter
        public static class DialogoSeleccionDeColaboradores {
            @SerializedName("TABLE_COLABORADORES")
            private Table table;
            @NoArgsConstructor
            @Getter
            public static class Table{
                private String qbe_nombreYApellidos;
                private String qbe_direccion;
                @SerializedName("Nombre y Apellidos")
                private String table_nombreYApellidos;
                @SerializedName("Dirección")
                private String table_direccion;
                @SerializedName("Detalle")
                private String table_detalle;
            }
        }

        @SerializedName("DIALOG_ALTAIT")
        private DialogoAniadirIT dialogoAniadirIT;

        @NoArgsConstructor
        @Getter
        public static class DialogoAniadirIT {
            private String fechaInicioIT;
            private String fechaFinIT;
            private String tipoIT;
            private String mesFiltro;
        }
    }
}
