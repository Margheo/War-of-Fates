package ui;

import java.awt.*;
import javax.swing.*;

// Console em que os logs da batalha sao exibidos
public class ConsolePanel extends JPanel {
    
    private final JTextArea areaDeLog = new JTextArea();

    public ConsolePanel() {
        setLayout(new BorderLayout());
        areaDeLog.setEditable(false);
        areaDeLog.setLineWrap(true);
        JScrollPane barraRolagem = new JScrollPane(areaDeLog);
        add(barraRolagem, BorderLayout.CENTER);
        barraRolagem.setPreferredSize(new Dimension(260, 0));
    }

    public void append(String text) {
        SwingUtilities.invokeLater(() -> {
            final String entrada = (text == null) ? "" : text;
            String normalized = entrada.replace("\r\n", "\n").replace('\r', '\n');
            String[] linhas = normalized.split("\n", -1);
            boolean ultimaVazia = false;

            for (String linha : linhas) {
                if (linha.trim().isEmpty()) {
                    if (ultimaVazia) continue;
                    areaDeLog.append(System.lineSeparator());
                    ultimaVazia = true;
                } else {
                    // Highlight important tags
                    if (linha.startsWith("[ARENA]") || linha.startsWith("=== [ARENA]")) {
                        areaDeLog.append("--------------------------------------------------" + System.lineSeparator());
                        areaDeLog.append(linha + System.lineSeparator());
                        areaDeLog.append("--------------------------------------------------" + System.lineSeparator());
                    } else if (linha.startsWith("[ATAQUE]")) {
                        areaDeLog.append("* " + linha + System.lineSeparator());
                    } else {
                        areaDeLog.append(linha + System.lineSeparator());
                    }
                    ultimaVazia = false;
                }
            }
            areaDeLog.setCaretPosition(areaDeLog.getDocument().getLength());
        });
    }

    public void redirectSystemOut() {
        java.io.OutputStream os = new java.io.OutputStream() {
            private final StringBuilder buffer = new StringBuilder();

            @Override
            public void write(int b) {
                char c = (char) b;
                buffer.append(c);
                if (c == '\n') flush();
            }

            @Override
            public void flush() {
                final String texto = buffer.toString();
                buffer.setLength(0);
                append(texto);
            }
        };

        System.setOut(new java.io.PrintStream(os, true));
        System.setErr(new java.io.PrintStream(os, true));
    }
}
