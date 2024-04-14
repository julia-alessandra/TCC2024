package com.mycompany.tcc.dados;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

public class Configuracao {
    private int id;
    private boolean notificPublicacoes;
    private boolean notificMensagens;
    private boolean notificEventos;
    private boolean notificCurtidas;
    private boolean notificComentarios;
    private boolean tema;
    private String fonte;
    private String idioma;
    private int tarefasCompletadas;
    private int tempoPorTarefa;
    private int tempoNoApp;

    /**
     * @return the notificPublicacoes
     */
    public boolean isNotificPublicacoes() {
        return notificPublicacoes;
    }

    /**
     * @param notificPublicacoes the notificPublicacoes to set
     */
    public void setNotificPublicacoes(boolean notificPublicacoes) {
        this.notificPublicacoes = notificPublicacoes;
    }

    /**
     * @return the notificMensagens
     */
    public boolean isNotificMensagens() {
        return notificMensagens;
    }

    /**
     * @param notificMensagens the notificMensagens to set
     */
    public void setNotificMensagens(boolean notificMensagens) {
        this.notificMensagens = notificMensagens;
    }

    /**
     * @return the notificEventos
     */
    public boolean isNotificEventos() {
        return notificEventos;
    }

    /**
     * @param notificEventos the notificEventos to set
     */
    public void setNotificEventos(boolean notificEventos) {
        this.notificEventos = notificEventos;
    }

    /**
     * @return the notificCurtidas
     */
    public boolean isNotificCurtidas() {
        return notificCurtidas;
    }

    /**
     * @param notificCurtidas the notificCurtidas to set
     */
    public void setNotificCurtidas(boolean notificCurtidas) {
        this.notificCurtidas = notificCurtidas;
    }

    /**
     * @return the notificComentarios
     */
    public boolean isNotificComentarios() {
        return notificComentarios;
    }

    /**
     * @param notificComentarios the notificComentarios to set
     */
    public void setNotificComentarios(boolean notificComentarios) {
        this.notificComentarios = notificComentarios;
    }

    /**
     * @return the tema
     */
    public boolean isTema() {
        return tema;
    }

    /**
     * @param tema the tema to set
     */
    public void setTema(boolean tema) {
        this.tema = tema;
    }

    /**
     * @return the fonte
     */
    public String getFonte() {
        return fonte;
    }

    /**
     * @param fonte the fonte to set
     */
    public void setFonte(String fonte) {
        this.fonte = fonte;
    }

    /**
     * @return the idioma
     */
    public String getIdioma() {
        return idioma;
    }

    /**
     * @param idioma the idioma to set
     */
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    /**
     * @return the tarefasCompletadas
     */
    public int getTarefasCompletadas() {
        return tarefasCompletadas;
    }

    /**
     * @param tarefasCompletadas the tarefasCompletadas to set
     */
    public void setTarefasCompletadas(int tarefasCompletadas) {
        this.tarefasCompletadas = tarefasCompletadas;
    }

    /**
     * @return the tempoPorTarefa
     */
    public int getTempoPorTarefa() {
        return tempoPorTarefa;
    }

    /**
     * @param tempoPorTarefa the tempoPorTarefa to set
     */
    public void setTempoPorTarefa(int tempoPorTarefa) {
        this.tempoPorTarefa = tempoPorTarefa;
    }

    /**
     * @return the tempoNoApp
     */
    public int getTempoNoApp() {
        return tempoNoApp;
    }

    /**
     * @param tempoNoApp the tempoNoApp to set
     */
    public void setTempoNoApp(int tempoNoApp) {
        this.tempoNoApp = tempoNoApp;
    }
    
}