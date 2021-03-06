import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.JPanel;

public class JPanelVisualizacao extends JPanel {

    private ArrayList< Estado > estados;
    private Estado estadoSelecionado;

    public JPanelVisualizacao( ArrayList< Estado > estados ) {
        initComponents();
        setBackground( Color.WHITE );
        this.estados = estados;
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        setLayout(null);
    }

    private void formMousePressed(java.awt.event.MouseEvent evt) {

        estadoSelecionado = null;
        JFramePrincipal f = ( JFramePrincipal ) getParent().getParent().getParent().getParent().getParent();
        f.selecionaEstado( estadoSelecionado );

        repaint();

    }

    @Override
    protected void paintComponent( Graphics g ) {
        super.paintComponent( g );

        Graphics2D g2d = ( Graphics2D ) g;
        g2d.setRenderingHint( RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON );

        g2d.setPaint( Color.BLACK );
        FontMetrics fm = g2d.getFontMetrics();

        g2d.draw( new Rectangle2D.Double( 0, 0, getWidth() - 1, getHeight() - 1 ) );

        // desenha seleção
        if ( estadoSelecionado != null ) {

            g2d.setPaint( new Color( 255, 204, 204 ) );
            g2d.fill( new Ellipse2D.Double(
                    estadoSelecionado.getXCentral() - 29, estadoSelecionado.getYCentral() - 29, 58, 58 ) );

        }

        g2d.setPaint( Color.BLACK );

        for ( Estado e : estados ) {

            for ( Transicao t : e.getTransicoes() ) {

                // se estado origem e destino são diferentes, traça a reta
                if ( !t.getEstadoDestino().equals( e ) ) {

                    // desenha a linha de ligação
                    g2d.draw( new Line2D.Double(
                            e.getXCentral(), e.getYCentral(),
                            t.getEstadoDestino().getXCentral(),
                            t.getEstadoDestino().getYCentral() ) );

                    // desenha os símbolos da ligação
                    String simbolos = t.geraStringSimbolos();
                    int meiaLargSimbolos = fm.stringWidth( simbolos ) / 2;
                    g2d.drawString( simbolos,
                            e.getXCentral() + ( ( t.getEstadoDestino().getXCentral() - e.getXCentral() ) / 2 ) - meiaLargSimbolos,
                            e.getYCentral() + ( ( t.getEstadoDestino().getYCentral() - e.getYCentral() ) / 2 ) - 5 );

                    // gera a hipotenusa
                    double h = Utils.gerarHipotenusa(
                            e.getXCentral(), e.getYCentral(),
                            t.getEstadoDestino().getXCentral(),
                            t.getEstadoDestino().getYCentral() );

                    // gera o grau relativo entre os estados
                    double gr = Utils.obtemGrauRelativoJava(
                            e.getXCentral(), e.getYCentral(),
                            t.getEstadoDestino().getXCentral(),
                            t.getEstadoDestino().getYCentral() );

                    // calcula o x e y do início da flecha
                    // sendo que h deve ser dubtraido do raio do estado que no caso
                    // é 25, pois a flecha deve ser desenhada na borda do estado
                    double x = ( h - 25 ) * Math.cos( Math.toRadians( gr ) );
                    double y = ( h - 25 ) * Math.sin( Math.toRadians( gr ) );

                    // desenha a flecha
                    // cria um novo Graphics a partir do original
                    Graphics2D g2df = ( Graphics2D ) g2d.create();

                    // faz a translação para a coordenada que deve ser a origem
                    g2df.translate( x + e.getXCentral(), y + e.getYCentral());

                    // rotaciona
                    g2df.rotate( Math.toRadians( gr ) );

                    // desenha a flecha
                    g2df.draw( new Line2D.Double( 0, 0, -5, -5 ) );
                    g2df.draw( new Line2D.Double( 0, 0, -5, 5 ) );

                    // libera o graphics, não sendo necessário voltar a translação
                    // nem a rotação
                    g2df.dispose();

                } else { // caso contrário, desenha arco

                    g2d.draw( new Ellipse2D.Double(
                            e.getXCentral(), e.getYCentral() - 40, 30, 30 ) );

                    g2d.draw( new Line2D.Double(
                            e.getXCentral() + 21, e.getYCentral() - 11,
                            e.getXCentral() + 30, e.getYCentral() - 11 ) );

                    g2d.draw( new Line2D.Double(
                            e.getXCentral() + 22, e.getYCentral() - 11,
                            e.getXCentral() + 21, e.getYCentral() - 20 ) );

                    g2d.drawString( t.geraStringSimbolos(),
                            e.getXCentral() + 15,
                            e.getYCentral() - 45 );

                }

            }

        }

    }

    public void setEstados( ArrayList<Estado> estados ) {
        this.estados = estados;
    }

    public void setEstadoSelecionado( Estado estadoSelecionado ) {
        this.estadoSelecionado = estadoSelecionado;
    }
}