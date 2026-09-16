public class Main {
    public static void main(String[] args) {
        MaquinaDeLavar maquina = new MaquinaDeLavar();

        System.out.println("1. TESTANDO RESTRIÇÕES INICIAIS");
        maquina.iniciarLavagem();// Erro: máquina desligada
        maquina.pausarLavagem();// Erro: máquina desligada
        maquina.desligar();// Erro: já está desligada

        System.out.println("\n2. PREPARANDO PARA LAVAR");
        maquina.ligar();// Sucesso
        maquina.ligar();// Erro: já está ligada
        maquina.abrirTampa();// Sucesso
        maquina.iniciarLavagem();// Erro: tampa aberta
        maquina.fecharTampa();// Sucesso

        System.out.println("\n3. CICLO DE LAVAGEM E PAUSA");
        maquina.iniciarLavagem();// Sucesso
        maquina.abrirTampa();// Erro: lavando
        maquina.desligar();// Erro: lavando
        maquina.pausarLavagem();// Sucesso
        maquina.abrirTampa();// Sucesso (pausada permite abrir)
        maquina.retomarLavagem();// Erro: tampa aberta
        maquina.fecharTampa();// Sucesso
        maquina.retomarLavagem();// Sucesso

        System.out.println("\n4. FINALIZANDO LAVAGEM E CENTRIFUGANDO");
        maquina.iniciarCentrifugacao();// Erro: lavagem ainda não concluída
        maquina.concluirLavagem();// Simula fim do ciclo de lavagem
        maquina.iniciarCentrifugacao();// Sucesso
        maquina.desligar(); // Erro: centrifugando

        System.out.println("\n5. FINALIZAÇÃO DO CICLO");
        maquina.concluirCentrifugacao();// Simula fim do ciclo de centrifugação
        maquina.desligar(); // Sucesso
    }
}