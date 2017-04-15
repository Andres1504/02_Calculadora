
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Pantalla extends JFrame {

    private JButton btnAC;
    private JButton btnC;
    private JButton btnIgual;

    private Boton btnParentesisDer;
    private Boton btnParentesisIzq;
    private Boton btnMultiplicacion;
    private Boton btnDivision;
    private Boton btnSuma;
    private Boton btnResta;
    private Boton btnExponente;

    private Boton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    private JButton btn0;

    private JTextField edtPantalla;
    private JTextField edtExpresion;

    Lista<Arithmeticable> lista;
    Lista<Arithmeticable> resultado;

    public Pantalla() {
        super("Calculadora");
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setLocation(100, 100);
        super.setSize(250, 300);
        super.setLayout(new BorderLayout());

        lista = new Lista();
        resultado = new Lista();

        super.add(pnlPantalla(), BorderLayout.NORTH);
        super.add(pnlBotones(), BorderLayout.CENTER);

        super.setVisible(true);
    }

    private JPanel pnlBotones() {
        JPanel pnlBotones = new JPanel();
        //pnlBotones.setBackground(Color.BLUE);
        pnlBotones.setLayout(new GridLayout(5, 4));

        btnAC = new JButton("AC");
        btnAC.setBackground(Color.BLACK);
        btnAC.setForeground(Color.WHITE);
        btnAC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lista.empty();
                displayList();
            }
        });

        btnC = new JButton("CE");
        btnC.setBackground(Color.BLACK);
        btnC.setForeground(Color.WHITE);
        btnC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    lista.drop();
                } catch (ListaVaciaException ex) {
                } finally {
                    displayList();
                }
            }
        });

        btnIgual = new JButton("=");
        btnIgual.setBackground(Color.BLACK);
        btnIgual.setForeground(Color.WHITE);
        btnIgual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evaluar();
            }
        });

        btnExponente = new Boton(new Operation(MathSign.EXPONENTE), this);
        btnExponente.setBackground(Color.BLACK);
        btnExponente.setForeground(Color.WHITE);
        
        btnSuma = new Boton(new Operation(MathSign.SUMA), this);
        btnSuma.setBackground(Color.BLACK);
        btnSuma.setForeground(Color.WHITE);
        
        btnResta = new Boton(new Operation(MathSign.RESTA), this);
        btnResta.setBackground(Color.BLACK);
        btnResta.setForeground(Color.WHITE);
        
        btnMultiplicacion = new Boton(new Operation(MathSign.MULTIPLICACION), this);
        btnMultiplicacion.setBackground(Color.BLACK);
        btnMultiplicacion.setForeground(Color.WHITE);
        
        btnDivision = new Boton(new Operation(MathSign.DIVISION), this);
        btnDivision.setBackground(Color.BLACK);
        btnDivision.setForeground(Color.WHITE);
        
        btnParentesisDer = new Boton(new Operation(MathSign.PARENTESISDER), this);
        btnParentesisDer.setBackground(Color.BLACK);
        btnParentesisDer.setForeground(Color.WHITE);
        
        btnParentesisIzq = new Boton(new Operation(MathSign.PARENTESISIZQ), this);
        btnParentesisIzq.setBackground(Color.BLACK);
        btnParentesisIzq.setForeground(Color.WHITE);
        
        
        btn1 = new Boton(new Numero('A'), this);
        btn1.setBackground(Color.BLACK);
        btn1.setForeground(Color.WHITE);
        
        btn2 = new Boton(new Numero('B'), this);
        btn2.setBackground(Color.BLACK);
        btn2.setForeground(Color.WHITE);
        
        btn3 = new Boton(new Numero('C'), this);
        btn3.setBackground(Color.BLACK);
        btn3.setForeground(Color.WHITE);
        
        btn4 = new Boton(new Numero('D'), this);
        btn4.setBackground(Color.BLACK);
        btn4.setForeground(Color.WHITE);
        
        btn5 = new Boton(new Numero('E'), this);
        btn5.setBackground(Color.BLACK);
        btn5.setForeground(Color.WHITE);
        
        btn6 = new Boton(new Numero('F'), this);
        btn6.setBackground(Color.BLACK);
        btn6.setForeground(Color.WHITE);
        
        btn7 = new Boton(new Numero('G'), this);
        btn7.setBackground(Color.BLACK);
        btn7.setForeground(Color.WHITE);
        
        btn8 = new Boton(new Numero('H'), this);
        btn8.setBackground(Color.BLACK);
        btn8.setForeground(Color.WHITE);
        
        btn9 = new Boton(new Numero('I'), this);
        btn9.setBackground(Color.BLACK);
        btn9.setForeground(Color.WHITE);
        
        btn0 = new Boton(new Numero('J'), this);
        btn0.setBackground(Color.BLACK);
        btn0.setForeground(Color.WHITE);

        pnlBotones.add(btnAC);
        pnlBotones.add(btnC);
        pnlBotones.add(btnParentesisIzq);
        pnlBotones.add(btnParentesisDer);

        pnlBotones.add(btn1);
        pnlBotones.add(btn2);
        pnlBotones.add(btn3);
        pnlBotones.add(btnMultiplicacion);
        
        pnlBotones.add(btn7);
        pnlBotones.add(btn8);
        pnlBotones.add(btn9);
        pnlBotones.add(btnSuma);

        pnlBotones.add(btn4);
        pnlBotones.add(btn5);
        pnlBotones.add(btn6);
        pnlBotones.add(btnResta);

        pnlBotones.add(btn0);
        pnlBotones.add(btnDivision);
        pnlBotones.add(btnExponente);
        pnlBotones.add(btnIgual);

        return pnlBotones;
    }

    private JPanel pnlPantalla() {
        JPanel pnlPantalla = new JPanel();
        pnlPantalla.setLayout(new BorderLayout());

        edtPantalla = new JTextField();       
        edtPantalla.setFont(new Font("Arial", Font.BOLD, 24));
       

        edtExpresion = new JTextField();     
        edtExpresion.setFont(new Font("Arial", Font.PLAIN, 16));
      

        pnlPantalla.add(edtExpresion, BorderLayout.NORTH);
        pnlPantalla.add(edtPantalla, BorderLayout.CENTER);

        return pnlPantalla;
    }

    public void displayList() {
        edtExpresion.setText("");
        for (Iterator<Arithmeticable> iterator = lista.iterator(); iterator.hasNext();) {
            Arithmeticable next = (Arithmeticable) iterator.next();
            edtExpresion.setText(edtExpresion.getText() + next);
        }
        edtPantalla.setText("");
        for (Iterator<Arithmeticable> iterator = resultado.iterator(); iterator.hasNext();) {
            Arithmeticable next = iterator.next();
            edtPantalla.setText(edtPantalla.getText() + next);
        }
    }

    public Lista<Arithmeticable> getLista() {
        return lista;
    }

    public void setLista(Lista<Arithmeticable> lista) {
        this.lista = lista;
    }

    public void evaluar() {
        try {
            ShuntingYard shunting = new ShuntingYard();
            for (Iterator<Arithmeticable> iterator = lista.iterator(); iterator.hasNext();) {
                Arithmeticable next = iterator.next();
                shunting.addElement(next);
            }
            resultado = shunting.evaluate();
            displayList();
        } catch (ArithmeticExpresionException ex) {
            edtExpresion.setText("Error!");
        }
    }

}
