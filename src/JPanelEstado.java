import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.JPanel;


public class JPanelEstado extends JPanel {

    private Estado estado;
    private int larguraFlecha;
    private boolean clicado; // flag para indicar se o estado está selecionado
    private boolean selecionado;

    public JPanelEstado( Estado estado ) {

        this.estado = estado;

        if ( estado.isInicial() )
            larguraFlecha = 20;
        else
            larguraFlecha = 0;

        setSize( new Dimension( 50 + larguraFlecha, 50 ) );
        setBackground( new Color( 0, 0, 0, 0 ) );
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE)
        );
    }

    private void formMouseDragged(java.awt.event.MouseEvent evt) {

        if ( getParent() != null ) {

            int x = ( int ) getParent().getMousePosition().getX() - getWidth() / 2;
            int y = ( int ) getParent().getMousePosition().getY() - getHeight() / 2;

            if ( getX() + getWidth() > getParent().getWidth() )
                x = getParent().getWidth() - getWidth() - 2;
            if ( getX() < 0 )
                x = 0;

            if ( getY() + getHeight() > getParent().getHeight() )
                y = getParent().getHeight() - getHeight() - 2;
            if ( getY() < 0 )
                y = 0;

            setLocation( x, y );

            // coordenadas para desenho das transições
            if ( estado.isInicial() ) {
                estado.setXCentral( x + ( larguraFlecha / 2 ) + ( getWidth() / 2 ) );
                estado.setYCentral( y + ( getHeight() / 2 ) );
            } else {
                estado.setXCentral( x + ( getWidth() / 2 ) );
                estado.setYCentral( y + ( getHeight() / 2 ) );
            }

            // repinta o container pai, fazendo com as transições sejam desenhadas
            getParent().repaint();

        }
    }

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed

        // obtém o frame principal
        JFramePrincipal f = ( JFramePrincipal ) getParent().getParent().getParent().getParent().getParent().getParent();
        f.selecionaEstado( estado );

        clicado = true;
        repaint();

    }

    private void formMouseReleased(java.awt.event.MouseEvent evt) {

        clicado = false;
        repaint();

    }

    @Override
    protected void paintComponent( Graphics g ) {
        super.paintComponent( g );

        Graphics2D g2d = ( Graphics2D ) g;
        g2d.setRenderingHint( RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON );

        if ( clicado )
            g2d.setPaint( new Color( 220, 245, 255 ) );
        else
            g2d.setPaint( Color.WHITE );

        g2d.fill( new Ellipse2D.Double(
                larguraFlecha, 0,
                this.getWidth() - larguraFlecha, getHeight() ) );

        if ( clicado )
            g2d.setPaint( new Color( 0, 102, 153 ) );
        else
            g2d.setPaint( Color.BLACK );

        g2d.draw( new Ellipse2D.Double(
                larguraFlecha, 0,
                this.getWidth() - ( larguraFlecha + 1 ), getHeight() - 1  ) );

        if ( estado.isInicial() ) {
            g2d.draw( new Line2D.Double(
                    0, getHeight() / 2,
                    larguraFlecha, getHeight() / 2  ) );
            g2d.draw( new Line2D.Double(
                    larguraFlecha - 5, ( getHeight() / 2 ) - 5,
                    larguraFlecha, getHeight() / 2  ) );
            g2d.draw( new Line2D.Double(
                    larguraFlecha - 5, ( getHeight() / 2 ) + 5,
                    larguraFlecha, getHeight() / 2  ) );
        }

        if ( estado.isFinal() ) {
            g2d.draw( new Ellipse2D.Double(
                    larguraFlecha + 5, 5,
                    this.getWidth() - ( larguraFlecha + 11 ), getHeight() - 11 ) );
        }

        FontMetrics fm = g2d.getFontMetrics();
        g2d.drawString( estado.getNome(),
                larguraFlecha + ( 50 / 2 ) - ( fm.stringWidth( estado.getNome() ) / 2 ),
                ( getHeight() / 2 ) + ( fm.getHeight() / 3 ) );

    }

    public Estado getEstado() {
        return estado;
    }
}
