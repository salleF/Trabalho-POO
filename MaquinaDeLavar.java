public class MaquinaDeLavar {
    private EstadoMaquina estado;
    private boolean tampaAberta;

    public MaquinaDeLavar() {
        this.estado = EstadoMaquina.DESLIGADA;
        this.tampaAberta = false;
    }

    public EstadoMaquina getEstado() {
        return estado;
    }

    public boolean isTampaAberta() {
        return tampaAberta;
    }

    public void ligar() {
        if (this.estado != EstadoMaquina.DESLIGADA) {
            System.out.println("[ERRO] A máquina já está ligada.");
            return;
        }
        this.estado = EstadoMaquina.LIGADA_PARADA;
        System.out.println("[SUCESSO] Máquina ligada.");
    }

    public void desligar() {
        if (this.estado == EstadoMaquina.DESLIGADA) {
            System.out.println("[ERRO] A máquina já está desligada.");
            return;
        }
        if (this.estado == EstadoMaquina.LAVANDO || this.estado == EstadoMaquina.CENTRIFUGANDO) {
            System.out.println("[ERRO] A máquina não pode ser desligada enquanto estiver lavando ou centrifugando.");
            return;
        }
        this.estado = EstadoMaquina.DESLIGADA;
        System.out.println("[SUCESSO] Máquina desligada.");
    }

    public void abrirTampa() {
        if (this.estado == EstadoMaquina.LAVANDO || this.estado == EstadoMaquina.CENTRIFUGANDO) {
            System.out.println("[ERRO] A tampa não pode ser aberta enquanto a máquina estiver lavando ou centrifugando.");
            return;
        }
        if (this.tampaAberta) {
            System.out.println("[AVISO] A tampa já está aberta.");
            return;
        }
        this.tampaAberta = true;
        System.out.println("[SUCESSO] Tampa aberta.");
    }

    public void fecharTampa() {
        if (!this.tampaAberta) {
            System.out.println("[AVISO] A tampa já está fechada.");
            return;
        }
        this.tampaAberta = false;
        System.out.println("[SUCESSO] Tampa fechada.");
    }

    public void iniciarLavagem() {
        if (this.estado == EstadoMaquina.DESLIGADA) {
            System.out.println("[ERRO] Uma máquina desligada não pode iniciar uma lavagem.");
            return;
        }
        if (this.tampaAberta) {
            System.out.println("[ERRO] A lavagem só pode ser iniciada com a tampa fechada.");
            return;
        }
        if (this.estado != EstadoMaquina.LIGADA_PARADA && 
            this.estado != EstadoMaquina.LAVAGEM_CONCLUIDA && 
            this.estado != EstadoMaquina.CENTRIFUGACAO_CONCLUIDA) {
            System.out.println("[ERRO] Não é possível iniciar lavagem no estado atual.");
            return;
        }
        this.estado = EstadoMaquina.LAVANDO;
        System.out.println("[SUCESSO] Lavagem iniciada...");
    }

    public void pausarLavagem() {
        if (this.estado == EstadoMaquina.DESLIGADA) {
            System.out.println("[ERRO] Uma máquina desligada não pode ser pausada.");
            return;
        }
        if (this.estado != EstadoMaquina.LAVANDO) {
            System.out.println("[ERRO] Apenas uma lavagem em andamento pode ser pausada.");
            return;
        }
        this.estado = EstadoMaquina.PAUSADA;
        System.out.println("[SUCESSO] Lavagem pausada.");
    }

    public void retomarLavagem() {
        if (this.estado != EstadoMaquina.PAUSADA) {
            System.out.println("[ERRO] Apenas uma lavagem pausada pode ser retomada.");
            return;
        }
        if (this.tampaAberta) {
            System.out.println("[ERRO] Feche a tampa para retomar a lavagem.");
            return;
        }
        this.estado = EstadoMaquina.LAVANDO;
        System.out.println("[SUCESSO] Lavagem retomada...");
    }

    public void concluirLavagem() {
        if (this.estado == EstadoMaquina.LAVANDO) {
            this.estado = EstadoMaquina.LAVAGEM_CONCLUIDA;
            System.out.println("[INFO] Etapa de lavagem concluída com sucesso.");
        }
    }

    public void iniciarCentrifugacao() {
        if (this.estado != EstadoMaquina.LAVAGEM_CONCLUIDA) {
            System.out.println("[ERRO] A centrifugação só pode ser iniciada depois que a lavagem estiver concluída.");
            return;
        }
        if (this.tampaAberta) {
            System.out.println("[ERRO] Feche a tampa para iniciar a centrifugação.");
            return;
        }
        this.estado = EstadoMaquina.CENTRIFUGANDO;
        System.out.println("[SUCESSO] Centrifugação iniciada...");
    }

    public void concluirCentrifugacao() {
        if (this.estado == EstadoMaquina.CENTRIFUGANDO) {
            this.estado = EstadoMaquina.CENTRIFUGACAO_CONCLUIDA;
            System.out.println("[INFO] Centrifugação concluída com sucesso.");
        }
    }
}