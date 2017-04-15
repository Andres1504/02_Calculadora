

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;



public class Boton extends JButton implements ActionListener {
    
    private Arithmeticable valor;
    private Pantalla frame;
    
    public Boton(Arithmeticable valor, Pantalla fr){
        super(valor.toString());
        this.valor = valor;
        this.frame = fr;
        this.addActionListener(this);
    }
    
    public Arithmeticable getValor(){
        return valor;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.getLista().add(valor);
        frame.displayList();
    }
    
}
