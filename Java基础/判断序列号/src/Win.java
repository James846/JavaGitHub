import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Win extends JFrame {
    JTextField text[] = new JTextField[3];
    Police police;
    JButton b;
    Win() {
        setLayout(new FlowLayout());
        police = new Police();
        for (int i = 0; i < 3; i++) {
            text[i] = new JTextField(7);
            text[i].addKeyListener(police);
            text[i].addFocusListener(police);
            add(text[i]);
        }
        b = new JButton("确定");
        add(b);
        text[0].requestFocusInWindow();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String regex = "[0-9[a-zA-Z]]+";
                for (int i = 0; i < 3; i++) {
                    if (text[i].getText().matches(regex)) {
                       JOptionPane.showMessageDialog(text[i],"您输入了正确的序列号","消息对话框",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(text[i],"您输入了非法字符","消息对话框",JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
}
}


