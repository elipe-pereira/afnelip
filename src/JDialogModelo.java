import java.util.ArrayList;
import java.util.TreeSet;
import javax.swing.table.DefaultTableModel;
import javax.swing.JDialog;


public class JDialogModelo extends JDialog {

    private ArrayList< Estado > estados;

    public JDialogModelo(java.awt.Frame parent, boolean modal, ArrayList< Estado > estados ) {
        super(parent, modal);
        this.estados = estados;
        initComponents();

        labelAutomato.setText( "M = (Q, \u03a3, \u03b4, q0, F)" );
        labelEstados.setText( "Q = \u00d8 " );
        labelAlfabeto.setText( "\u03a3 = \u00d8 " );
        labelEstadosFinais.setText( "F = \u00d8 " );
        labelDelta.setText( "\u03b4: " );

        processaEstados();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        labelAutomato = new javax.swing.JLabel();
        labelEstados = new javax.swing.JLabel();
        labelAlfabeto = new javax.swing.JLabel();
        labelEstadosFinais = new javax.swing.JLabel();
        labelDelta = new javax.swing.JLabel();
        scrollTabelaT = new javax.swing.JScrollPane();
        tabelaT = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modelo Formal");
        setModal(true);

        labelAutomato.setText("A:");

        labelEstados.setText("A:");

        labelAlfabeto.setText("A:");

        labelEstadosFinais.setText("A:");

        labelDelta.setText("A:");

        tabelaT.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {

                }
        ));
        scrollTabelaT.setViewportView(tabelaT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelAutomato, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(labelDelta)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(scrollTabelaT, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(labelEstados, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                                        .addComponent(labelAlfabeto, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                                        .addComponent(labelEstadosFinais, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelAutomato)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelEstados)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelAlfabeto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelEstadosFinais)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelDelta)
                                        .addComponent(scrollTabelaT, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
                                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-430)/2, (screenSize.height-342)/2, 430, 342);
    }

    private void processaEstados() {

        StringBuilder sbe = new StringBuilder();
        StringBuilder sba = new StringBuilder();
        StringBuilder sbf = new StringBuilder();

        TreeSet< Character > set = new TreeSet< Character >();

        for ( Estado e : estados ) {

            sbe.append( e.getNome() + ", " );

            if ( e.isFinal() ) {
                sbf.append( e.getNome() + ", " );
            }

            for ( Transicao t : e.getTransicoes() ) {
                for ( Character c : t.getSimbolos() ) {
                    set.add( c );
                }
            }

        }

        if ( sbe.toString().length() > 2 ) {
            labelEstados.setText( "Q = { " +
                    sbe.toString().substring( 0, sbe.toString().length() - 2 ) + " }" );
        }
        if ( sbf.toString().length() > 2 ) {
            labelEstadosFinais.setText( "F = { " +
                    sbf.toString().substring( 0, sbf.toString().length() - 2 ) + " }" );
        }

        for ( Character c : set ) {
            sba.append( c + ", " );
        }

        if ( sba.toString().length() > 2 ) {
            labelAlfabeto.setText( "\u03a3 = { " +
                    sba.toString().substring( 0, sba.toString().length() - 2 ) + " }" );
        }

        preencheTabela( set, estados );

    }

    private void preencheTabela( TreeSet< Character > set,
                                 ArrayList< Estado > estado ) {

        Object[] titulos = new Object[ set.size() + 1 ];
        titulos[0] = "";
        int i = 1;

        for ( Character c : set ) {
            titulos[i++] = c;
        }

        // cria as colunas da tabela
        DefaultTableModel modelo = new DefaultTableModel( titulos, 0  );

        i = 0;

        for ( Estado e : estados ) {

            modelo.addRow( new Object[ set.size() + 1 ] );
            modelo.setValueAt( e, i, 0 );

            int j = 1;

            for ( Character c : set ) {
                for ( Transicao t : e.getTransicoes() ) {
                    for ( Character ct : t.getSimbolos() ) {
                        if ( ct == Character.valueOf( c ) ) {
                            modelo.setValueAt( t.getEstadoDestino().getNome(), i, j );
                        }
                    }
                }
                j++;
            }

            i++;

        }

        tabelaT.setModel( modelo );

    }

    private javax.swing.JLabel labelAlfabeto;
    private javax.swing.JLabel labelAutomato;
    private javax.swing.JLabel labelDelta;
    private javax.swing.JLabel labelEstados;
    private javax.swing.JLabel labelEstadosFinais;
    private javax.swing.JScrollPane scrollTabelaT;
    private javax.swing.JTable tabelaT;

}