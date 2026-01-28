package ui;

import characters.Personagem;
import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StatusDialog extends JDialog {

    public StatusDialog(Window owner, List<Personagem> timeA, List<Personagem> timeB) {
        super(owner, "Status dos Personagens", ModalityType.APPLICATION_MODAL);
        initUI(timeA, timeB);
        pack();
        setLocationRelativeTo(owner);
    }

    private void initUI(List<Personagem> timeA, List<Personagem> timeB) {
        String[] cols = new String[]{"Nome","Vida","Mana","Defesa","Crítico","Dano","ManaRegen"};

        DefaultTableModel modelA = new DefaultTableModel(cols, 0) {
            @Override public boolean isCellEditable(int row, int column) { return false; }
        };
        DefaultTableModel modelB = new DefaultTableModel(cols, 0) {
            @Override public boolean isCellEditable(int row, int column) { return false; }
        };

        if (timeA != null) for (Personagem p : timeA) {
            java.util.List<Integer> s = p.mostrarStatus();
            String vidaFmt = s.get(0) + "/" + s.get(1);
            String manaFmt = s.get(2) + "/" + s.get(3);
            modelA.addRow(new Object[]{p.getNome(), vidaFmt, manaFmt, s.get(4), s.get(5), s.get(6), s.get(7)});
        }
        if (timeB != null) for (Personagem p : timeB) {
            java.util.List<Integer> s = p.mostrarStatus();
            String vidaFmt = s.get(0) + "/" + s.get(1);
            String manaFmt = s.get(2) + "/" + s.get(3);
            modelB.addRow(new Object[]{p.getNome(), vidaFmt, manaFmt, s.get(4), s.get(5), s.get(6), s.get(7)});
        }

        JTable tableA = new JTable(modelA);
        JTable tableB = new JTable(modelB);
        tableA.setFillsViewportHeight(true);
        tableB.setFillsViewportHeight(true);

        JScrollPane spA = new JScrollPane(tableA);
        JScrollPane spB = new JScrollPane(tableB);

        JPanel main = new JPanel(new BorderLayout(8,8));
        JPanel center = new JPanel(new GridLayout(1,2,8,8));
        center.add(spA);
        center.add(spB);

        main.add(center, BorderLayout.CENTER);

        JButton close = new JButton("Fechar");
        close.addActionListener(e -> setVisible(false));
        JPanel footer = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        footer.add(close);
        main.add(footer, BorderLayout.SOUTH);

        setContentPane(main);
        setPreferredSize(new Dimension(900, 400));
    }
}
