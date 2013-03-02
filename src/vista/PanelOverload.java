/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author camilortte
 */
public class PanelOverload extends JPanel {
      
    Image image;

    public PanelOverload() {
        try {
            image = (new ImageIcon(getClass().getResource("/vista/images/procesador-intel-core-i5-3470-ivy-bridge-32mhz-6mb-cache_MCO-O-3185304052_092012.jpg"))).getImage();
        } catch (Exception e) {/*handled in paintComponent()*/

        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) 
            g.drawImage(image, (this.getWidth()/2)-
                    (image.getWidth(this)/  2),
                    (this.getHeight() / 2  )- (image.getHeight(this) / 2
                    ),image.getWidth(this)
                    ,image.getHeight(this)
                    ,this
    

); //(image,location x, location y, size x, size y)
}
}
