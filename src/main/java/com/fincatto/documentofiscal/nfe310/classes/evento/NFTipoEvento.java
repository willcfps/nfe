package com.fincatto.documentofiscal.nfe310.classes.evento;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.fincatto.documentofiscal.DFBase;
import com.fincatto.documentofiscal.nfe310.validadores.BigDecimalParser;
import com.fincatto.documentofiscal.nfe310.validadores.StringValidador;

import java.math.BigDecimal;

@Root(strict = false)
public class NFTipoEvento extends DFBase {
    @Attribute(name = "versao", required = true)
    private String versao;

    @Element(name = "descEvento", required = true)
    private String descricaoEvento;

    // Carta correcao
    @Element(name = "xCorrecao", required = false)
    private String textoCorrecao;

    @Element(name = "xCondUso", required = false)
    private String condicaoUso;

    public void setVersao(final BigDecimal versao) {
        this.versao = BigDecimalParser.tamanho5Com2CasasDecimais(versao, "Versao");
    }

    public void setDescricaoEvento(final String descricaoEvento) {
        StringValidador.tamanho5a60(descricaoEvento, "Descricao do Evento");
        this.descricaoEvento = descricaoEvento;
    }

    public String getDescricaoEvento() {
        return this.descricaoEvento;
    }

    public String getVersao() {
        return this.versao;
    }

    public void setCondicaoUso(final String condicaoUso) {
        this.condicaoUso = condicaoUso;
    }

    public void setTextoCorrecao(final String textoCorrecao) {
        this.textoCorrecao = textoCorrecao;
    }

    public String getCondicaoUso() {
        return this.condicaoUso;
    }

    public String getTextoCorrecao() {
        return this.textoCorrecao;
    }
}