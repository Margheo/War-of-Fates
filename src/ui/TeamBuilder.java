package ui;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

// Diálogo bem simples: retorna duas listas de contagens [guerreiros, magos] para Team A e Team B
public class TeamBuilder extends JDialog {
    private final JSpinner gwA = new JSpinner(new SpinnerNumberModel(0, 0, 200, 1));
    private final JSpinner mgA = new JSpinner(new SpinnerNumberModel(0, 0, 200, 1));
    private final JSpinner gwB = new JSpinner(new SpinnerNumberModel(0, 0, 200, 1));
    private final JSpinner mgB = new JSpinner(new SpinnerNumberModel(0, 0, 200, 1));
    private boolean confirmed = false;

    public TeamBuilder(Window owner) {
        super(owner, "Configurar Times (Simples)", ModalityType.APPLICATION_MODAL);
        initUI();
        pack();
        setLocationRelativeTo(owner);
    }

    private void initUI() {
        JPanel p = new JPanel(new GridLayout(3, 3, 6, 6));
        p.add(new JLabel("Classe"));
        p.add(new JLabel("Team A"));
        p.add(new JLabel("Team B"));

        p.add(new JLabel("Guerreiros"));
        p.add(gwA);
        p.add(gwB);

        p.add(new JLabel("Magos"));
        p.add(mgA);
        p.add(mgB);

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton ok = new JButton("OK");
        JButton cancel = new JButton("Cancel");
        ok.addActionListener(e -> { confirmed = true; setVisible(false); });
        cancel.addActionListener(e -> { confirmed = false; setVisible(false); });
        buttons.add(ok); buttons.add(cancel);

        Container cc = getContentPane();
        cc.setLayout(new BorderLayout(8,8));
        cc.add(p, BorderLayout.CENTER);
        cc.add(buttons, BorderLayout.SOUTH);
    }

    public boolean isConfirmed() { return confirmed; }

    public List<Integer> getCountsForA() {
        List<Integer> out = new ArrayList<>();
        out.add((Integer) gwA.getValue());
        out.add((Integer) mgA.getValue());
        return out;
    }

    public List<Integer> getCountsForB() {
        List<Integer> out = new ArrayList<>();
        out.add((Integer) gwB.getValue());
        out.add((Integer) mgB.getValue());
        return out;
    }
}
