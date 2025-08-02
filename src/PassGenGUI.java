import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PassGenGUI extends JFrame implements ActionListener {

    private PassGen passGen;

    public PassGenGUI(){

        super("Password Generator");

        setSize(540,570);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        passGen = new PassGen();

        addComponents();
    }

    private void addComponents(){
        // title : Password Generator
        JLabel title = new JLabel("Password Generator");
        title.setFont(new Font("Dialog", Font.BOLD, 32));
        title.setHorizontalAlignment(SwingConstants.CENTER); // position
        title.setBounds(0,10,530, 40); //
        add(title);

        // result Password
        JTextArea pass = new JTextArea();
        pass.setEditable(false);
        pass.setFont(new Font("Dialog", Font.BOLD, 25));

        // allow scrolling if pass became long
        JScrollPane passPane = new JScrollPane(pass);
        passPane.setBounds(25,95,480,70);

        passPane.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // set border

        add(passPane);

        // Password length label
        JLabel passLen = new JLabel("Password Length : ");
        passLen.setFont(new Font("Dialog" , Font.PLAIN,30));
        passLen.setBounds(25,210,280, 35);
        add(passLen);

        // Password length input area
        JTextArea lenInput = new JTextArea();
        lenInput.setFont(new Font("Dialog",Font.PLAIN,30));
        lenInput.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        lenInput.setBounds(300, 210, 200, 35);
        add(lenInput);

        // create toggle buttons
        // uppercase
        JToggleButton upper = new JToggleButton("Uppercase");
        upper.setBounds(35,300,210, 50);
        upper.setFont(new Font("Dialog", Font.PLAIN , 25));
        add(upper);

        JToggleButton lower = new JToggleButton("Lowercase");
        lower.setBounds(270,300,210, 50);
        lower.setFont(new Font("Dialog", Font.PLAIN , 25));
        add(lower);

        JToggleButton num = new JToggleButton("Numbers");
        num.setBounds(35,370,210, 50);
        num.setFont(new Font("Dialog", Font.PLAIN , 25));
        add(num);

        JToggleButton symbol = new JToggleButton("Symbols");
        symbol.setBounds(270,370,210, 50);
        symbol.setFont(new Font("Dialog", Font.PLAIN , 25));
        add(symbol);

        // Generate button
        JButton gen = new JButton("Generate");
        gen.setBounds(150,450,210,50);
        gen.setHorizontalAlignment(SwingConstants.CENTER);
        gen.setFont(new Font("Dialog", Font.BOLD , 30));
        gen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (lenInput.getText().isEmpty()) return;

                boolean anyToggleSelected = upper.isSelected() || lower.isSelected() || num.isSelected() || symbol.isSelected();

                int length = Integer.parseInt(lenInput.getText());
                if (anyToggleSelected){
                    String password = passGen.generate(length, upper.isSelected(),lower.isSelected(), num.isSelected(),symbol.isSelected());

                    // display generated password
                    pass.setText(password);
                }

            }
        });
        add(gen);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
