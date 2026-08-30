package com.ideao.dev.javadatabase.common.handler;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GlobalExceptionHandler implements Thread.UncaughtExceptionHandler {
    private static final String LOG_FILE = "appError.log";
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.err.println("\n[!] OCORREU EM ERRO INESPERADO NO SISTEMA [!]");
        System.err.println("Motivo: " + e.getMessage());
        System.err.println("Os detalhes técnicos foram salvos em: " + LOG_FILE);

        saveLogFile(t, e);
        System.exit(1);
    }

    private void saveLogFile(Thread t, Throwable e) {
        try (FileWriter fw = new FileWriter(LOG_FILE, true);
             PrintWriter pw = new PrintWriter(fw)) {

            String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

            pw.println("=========================================================================");
            pw.println("DATA/HORA: " + dateTime);
            pw.println("THREAD: " + t.getName());
            pw.println("EXCEÇÃO: " + e.getClass().getName());
            pw.println("MENSAGEM: " + e.getMessage());
            pw.println("-------------------------------------------------------------------------");
            e.printStackTrace(pw);
            pw.println("=========================================================================\n");

        } catch (IOException e1) {
            System.err.println("Erro crítico: Não foi possível gravar o arquivo de log no disco.");
            e1.printStackTrace();
        }
    }
}