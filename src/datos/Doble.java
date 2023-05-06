
package datos;

import java.awt.Graphics;
import javax.swing.JComponent;

public class Doble extends JComponent {
    private final ListaDoble lista;
    
    public Doble(ListaDoble lista) {
        this.lista = lista;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        UsuarioNodo auxiliar = lista.inicio;
        int y = 0;
        
        while (auxiliar != null) {
            g.drawString((String) auxiliar.dato, 0, y);
            y += 20;
            auxiliar = auxiliar.sig;
        }
    }
}