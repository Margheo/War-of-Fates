package ui;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeListener;

// Painel de menu com controles para iniciar/reiniciar a batalha e ajustar velocidade/modo
public class MenuPanel extends JPanel {
    private final JSlider speedSlider = new JSlider(1, 20, 1);
    private final JComboBox<String> modeCombo = new JComboBox<>(new String[]{"PVP","PVE","EVE"});

    private final JButton startBtn = new JButton("Start");
    private final JButton resetBtn = new JButton("Reset");
    private final JButton configBtn = new JButton("Config Teams");
    private final JButton statusBtn = new JButton("Status");

    public MenuPanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        
        add(new JLabel("Mode:"));
        add(modeCombo);
        modeCombo.setSelectedIndex(2); // default EVE

        speedSlider.setMajorTickSpacing(1);
        speedSlider.setPaintTicks(true);
        speedSlider.setPaintLabels(true);
        speedSlider.setPreferredSize(new Dimension(400, 48));
        add(new JLabel("Speed:"));
        add(speedSlider);

        add(configBtn);
        add(statusBtn);
        add(startBtn);
        add(resetBtn);
    }
    public int getSelectedMode() { return modeCombo.getSelectedIndex() + 1; }
    public int getSpeed() { return speedSlider.getValue(); }

    public void addStartListener(ActionListener l) { startBtn.addActionListener(l); }
    public void addResetListener(ActionListener l) { resetBtn.addActionListener(l); }
    public void addSpeedChangeListener(ChangeListener l) { speedSlider.addChangeListener(l); }
    public void addConfigListener(ActionListener l) { configBtn.addActionListener(l); }
    public void addStatusListener(ActionListener l) { statusBtn.addActionListener(l); }

    public void setControlsEnabled(boolean enabled) {
        modeCombo.setEnabled(enabled);
        startBtn.setEnabled(enabled);
        resetBtn.setEnabled(enabled);
    }
}
