package com.eulen.flexinet.core.test.selenium.Locators;

public enum ModalTitle {
    ADVERTENCIA("Advertencia"),
    ATENCION("Atención"),
    ERROR("Error"),
    INFORMACION("Información"),
    EXITO("Éxito"),
    AVISO("Aviso"),
    CORRECTO("Correcto"),
    ESTADODELPEDIDO("Estado del Pedido");

    private final String codigo;

    ModalTitle(String codigo) {
        this.codigo = codigo;
    }

    public String getTitle() {
        return codigo;
    }
}
