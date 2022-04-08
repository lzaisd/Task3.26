import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;


public class FrameMain extends JFrame{
    private JTextField textFieldInput;
    private JButton buttonLoadInputFromFile;
    private JButton buttonSolve1;
    private JButton buttonSolve2;
    private JTextField textFieldAnswer;
    private JPanel panelMain;
    private JButton buttonSolve3;

    private final JFileChooser fileChooserOpen;

    public FrameMain() {
        this.setTitle("FrameMain");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        fileChooserOpen = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);

        buttonLoadInputFromFile.addActionListener(actionEvent -> {
            try {
                if (fileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                    String[] arr = ArrayUtils.readLinesFromFile(fileChooserOpen.getSelectedFile().getPath());

                    for (String s : arr) {
                        textFieldInput.setText(s);
                    }
                }
            } catch (Exception e) {
                SwingUtils.showErrorMessageBox(e);
            }
        });

        buttonSolve1.addActionListener(e -> {
            try {
                String str = textFieldInput.getText();
                char[] strArr = str.toCharArray();

                if (Logic.checkIfStructureIsCorrectSimpleStack(strArr)) {
                    textFieldAnswer.setText("Правильная скобочная структура");
                } else {
                    textFieldAnswer.setText("Неправильная скобочная структура");
                }
            } catch (Exception ex) {
                SwingUtils.showErrorMessageBox(ex);
            }
        });

        buttonSolve2.addActionListener(e -> {
            try {
                String str = textFieldInput.getText();
                char[] strArr = str.toCharArray();

                if (Logic.checkIfStructureIsCorrectRecursion(strArr)) {
                    textFieldAnswer.setText("Правильная скобочная структура");
                } else {
                    textFieldAnswer.setText("Неправильная скобочная структура");
                }
            } catch (Exception ex) {
                SwingUtils.showErrorMessageBox(ex);
            }
        });

        buttonSolve3.addActionListener(e -> {
            try {
                String str = textFieldInput.getText();
                char[] strArr = str.toCharArray();

                if (Logic.checkIfStructureIsCorrectSimpleStack(strArr)) {
                    textFieldAnswer.setText("Правильная скобочная структура");
                } else {
                    textFieldAnswer.setText("Неправильная скобочная структура");
                }
            } catch (Exception ex) {
                SwingUtils.showErrorMessageBox(ex);
            }
        });
    }
}