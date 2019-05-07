import java.awt.Component;
import java.util.ArrayList;
import java.util.TreeSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class JFramePrincipal extends JFrame {

    private int indice;
    private boolean criarInicial;
    private ArrayList< Estado > estados;
    private Estado estadoSelecionado;

    public JFramePrincipal() {

        estados = new ArrayList< Estado >();
        criarInicial = true;
        initComponents();

    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        // Inicia as variáveis de instância com os
        // componentes da interface gráfica
        painelCriacaoEstados = new JPanel();
        btnAddEstado = new JButton();
        checkFinal = new JCheckBox();
        painelEdicaoEstados = new JPanel();
        labelNomeEstado = new JLabel();
        btnExcluirEstado = new JButton();
        fieldEstadoSelecionado = new JTextField();
        painelTransicoes = new JPanel();
        labelSimbolo = new JLabel();
        labelEstadoDestino = new JLabel();
        fieldSimbolo = new JTextField();
        comboEstados = new JComboBox();
        scrollListaTransicoes = new JScrollPane();
        listaTransicoes = new JList();
        btnAddTransicao = new JButton();
        btnRemoveTransicao = new JButton();
        checkFinalEdicao = new JCheckBox();
        painelVisualizacaoBorda = new JPanel();
        painelVisualizacao = new JPanelVisualizacao( estados );
        labeTeste = new JLabel();
        fieldTeste = new JTextField();
        btnTeste = new JButton();
        btnExibirModelo = new JButton();
        btnNovoAutomato = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simulador AFN - Equipe: Anne, Eli, Rayssa");

        painelCriacaoEstados.setBorder(javax.swing.BorderFactory.createTitledBorder("Criar estados"));

        btnAddEstado.setText("Novo");

        btnAddEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEstadoActionPerformed(evt);
            }
        });

        checkFinal.setText("Final");

        javax.swing.GroupLayout painelCriacaoEstadosLayout = new javax.swing.GroupLayout(painelCriacaoEstados);
        painelCriacaoEstados.setLayout(painelCriacaoEstadosLayout);
        painelCriacaoEstadosLayout.setHorizontalGroup(
                painelCriacaoEstadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelCriacaoEstadosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnAddEstado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkFinal)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelCriacaoEstadosLayout.setVerticalGroup(
                painelCriacaoEstadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelCriacaoEstadosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(painelCriacaoEstadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnAddEstado)
                                        .addComponent(checkFinal))
                                .addContainerGap(18, Short.MAX_VALUE))
        );

        painelEdicaoEstados.setBorder(javax.swing.BorderFactory.createTitledBorder("Edição de Estados"));

        labelNomeEstado.setText("Nome:");

        btnExcluirEstado.setText("Excluir");
        btnExcluirEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirEstadoActionPerformed(evt);
            }
        });

        fieldEstadoSelecionado.setEditable(false);

        painelTransicoes.setBorder(javax.swing.BorderFactory.createTitledBorder("Transições"));

        labelSimbolo.setText("Símbolo:");

        labelEstadoDestino.setText("Estado Destino:");

        scrollListaTransicoes.setViewportView(listaTransicoes);

        btnAddTransicao.setText("+");
        btnAddTransicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTransicaoActionPerformed(evt);
            }
        });

        btnRemoveTransicao.setText("-");
        btnRemoveTransicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveTransicaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelTransicoesLayout = new javax.swing.GroupLayout(painelTransicoes);
        painelTransicoes.setLayout(painelTransicoesLayout);
        painelTransicoesLayout.setHorizontalGroup(
                painelTransicoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelTransicoesLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(painelTransicoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(scrollListaTransicoes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                                        .addGroup(painelTransicoesLayout.createSequentialGroup()
                                                .addComponent(labelSimbolo)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(fieldSimbolo, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(labelEstadoDestino)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(comboEstados, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(painelTransicoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnRemoveTransicao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnAddTransicao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        painelTransicoesLayout.setVerticalGroup(
                painelTransicoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelTransicoesLayout.createSequentialGroup()
                                .addGroup(painelTransicoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelSimbolo)
                                        .addComponent(labelEstadoDestino)
                                        .addComponent(fieldSimbolo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(comboEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnAddTransicao))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(painelTransicoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(scrollListaTransicoes, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(painelTransicoesLayout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(btnRemoveTransicao)))
                                .addContainerGap(20, Short.MAX_VALUE))
        );

        checkFinalEdicao.setText("Final");
        checkFinalEdicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkFinalEdicaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelEdicaoEstadosLayout = new javax.swing.GroupLayout(painelEdicaoEstados);
        painelEdicaoEstados.setLayout(painelEdicaoEstadosLayout);
        painelEdicaoEstadosLayout.setHorizontalGroup(
                painelEdicaoEstadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelEdicaoEstadosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(painelEdicaoEstadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(painelEdicaoEstadosLayout.createSequentialGroup()
                                                .addComponent(labelNomeEstado)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(fieldEstadoSelecionado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(btnExcluirEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(checkFinalEdicao))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(painelTransicoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        painelEdicaoEstadosLayout.setVerticalGroup(
                painelEdicaoEstadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelEdicaoEstadosLayout.createSequentialGroup()
                                .addGroup(painelEdicaoEstadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(painelEdicaoEstadosLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(painelEdicaoEstadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(labelNomeEstado)
                                                        .addComponent(fieldEstadoSelecionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(3, 3, 3)
                                                .addComponent(checkFinalEdicao)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnExcluirEstado))
                                        .addComponent(painelTransicoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelVisualizacaoBorda.setBorder(javax.swing.BorderFactory.createTitledBorder("Visualização e Teste"));

        javax.swing.GroupLayout painelVisualizacaoLayout = new javax.swing.GroupLayout(painelVisualizacao);
        painelVisualizacao.setLayout(painelVisualizacaoLayout);
        painelVisualizacaoLayout.setHorizontalGroup(
                painelVisualizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 585, Short.MAX_VALUE)
        );
        painelVisualizacaoLayout.setVerticalGroup(
                painelVisualizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 266, Short.MAX_VALUE)
        );

        labeTeste.setText("String de teste:");

        btnTeste.setText("Testar");
        btnTeste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTesteActionPerformed(evt);
            }
        });

        btnExibirModelo.setText("Exibir Modelo");
        btnExibirModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExibirModeloActionPerformed(evt);
            }
        });

        btnNovoAutomato.setText("Novo Autômato");
        btnNovoAutomato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoAutomatoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelVisualizacaoBordaLayout = new javax.swing.GroupLayout(painelVisualizacaoBorda);
        painelVisualizacaoBorda.setLayout(painelVisualizacaoBordaLayout);
        painelVisualizacaoBordaLayout.setHorizontalGroup(
                painelVisualizacaoBordaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelVisualizacaoBordaLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(painelVisualizacaoBordaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(painelVisualizacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(painelVisualizacaoBordaLayout.createSequentialGroup()
                                                .addComponent(labeTeste)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(fieldTeste, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnTeste)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                                .addComponent(btnExibirModelo)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnNovoAutomato)))
                                .addContainerGap())
        );
        painelVisualizacaoBordaLayout.setVerticalGroup(
                painelVisualizacaoBordaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelVisualizacaoBordaLayout.createSequentialGroup()
                                .addComponent(painelVisualizacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(painelVisualizacaoBordaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labeTeste)
                                        .addComponent(fieldTeste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnTeste)
                                        .addComponent(btnNovoAutomato)
                                        .addComponent(btnExibirModelo))
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(painelVisualizacaoBorda, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(painelCriacaoEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(painelEdicaoEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(painelCriacaoEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(painelEdicaoEstados, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(painelVisualizacaoBorda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-650)/2, (screenSize.height-624)/2, 650, 624);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEstadoActionPerformed

        Estado e = null;

        if ( criarInicial ) {
            e = new Estado( "q" + indice, true, checkFinal.isSelected() );
            criarInicial = false;
        } else {
            e = new Estado( "q" + indice, false, checkFinal.isSelected() );
        }

        indice++;

        JPanelEstado p = new JPanelEstado( e );
        estados.add( e );

        painelVisualizacao.add( p );
        painelVisualizacao.repaint();
        atualizaComboEstados();

    }

    private void btnAddTransicaoActionPerformed(java.awt.event.ActionEvent evt) {

        if ( estadoSelecionado != null && !fieldSimbolo.getText().trim().equals( "" ) ) {

            // precisa verificar se a transição já existe
            boolean transicaoExiste = false;
            Transicao tExistente = null;

            for ( Transicao t : estadoSelecionado.getTransicoes() ) {
                if ( t.getEstadoDestino().equals( ( Estado ) comboEstados.getSelectedItem() ) ) {
                    transicaoExiste = true;
                    tExistente = t;
                    break;
                }
            }

            if ( !transicaoExiste ) {

                TreeSet set = new TreeSet< Character >();
                set.add( fieldSimbolo.getText().trim().charAt( 0 ) );

                estadoSelecionado.getTransicoes().add( new Transicao(
                        set, ( Estado ) comboEstados.getSelectedItem() ) );

            } else {

                tExistente.getSimbolos().add( fieldSimbolo.getText().trim().charAt( 0 ) );

            }


            atualizaListaTransicoes();

            fieldSimbolo.setText( "" );
            comboEstados.setSelectedIndex( 0 );
            painelVisualizacao.repaint();

        }

    }
    private void btnRemoveTransicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveTransicaoActionPerformed

        Object o = listaTransicoes.getSelectedValue();

        if ( estadoSelecionado != null && o != null )
            ( ( DefaultListModel ) listaTransicoes.getModel() ).removeElement( o );

        estadoSelecionado.getTransicoes().remove( o );
        painelVisualizacao.repaint();

    }

    private void btnTesteActionPerformed(java.awt.event.ActionEvent evt) {

        boolean umEstadoFinal = false;

        for ( Estado e : estados ) {
            if ( e.isFinal() ) {
                umEstadoFinal = true;
                break;
            }
        }

        if ( umEstadoFinal ) {

            // os, tem pelo menos um estado final

            // TODO: verificar estados sem transição e com transições apontando para nada

            // procura o estado inicial
            Estado estadoInicial = null;

            for ( Estado e : estados ) {
                if ( e.isInicial() ) {
                    estadoInicial = e;
                    break;
                }
            }

            Estado estadoAtual = estadoInicial;
            int simbolosReconhecidos = 0; // contador de símbolos reconhecidos

            // a partir do estado inicial, começa a testar a string
            for ( char s : fieldTeste.getText().trim().toCharArray() ) {

                //boolean achou = false;

                // percorre cada transição
                for ( Transicao t : estadoAtual.getTransicoes() ) {

                    // se um dos símbolos da transição for igual ao caracter atual
                    for ( Character c : t.getSimbolos() ) {
                        if ( c.equals( Character.valueOf( s ) ) ) {
                            simbolosReconhecidos++;
                            estadoAtual = t.getEstadoDestino();
                            break;
                        }
                    }

                }

            }

            if ( estadoAtual.isFinal() &&
                    simbolosReconhecidos == fieldTeste.getText().trim().length() ) {

                JOptionPane.showMessageDialog( this,
                        "String reconhecida!", "Informação",
                        JOptionPane.INFORMATION_MESSAGE );

            } else if ( estadoAtual.isFinal() &&
                    simbolosReconhecidos == 0 &&
                    fieldTeste.getText().trim().length() == 0 ) {

                JOptionPane.showMessageDialog( this,
                        "String reconhecida!", "Informação",
                        JOptionPane.INFORMATION_MESSAGE );

            } else {

                JOptionPane.showMessageDialog( this,
                        "String não reconhecida...", "Informação",
                        JOptionPane.INFORMATION_MESSAGE );

            }

        } else {

            JOptionPane.showMessageDialog( this,
                    "Pelo menos um estado deve ser final!", "Erro",
                    JOptionPane.ERROR_MESSAGE );

        }

    }

    private void checkFinalEdicaoActionPerformed(java.awt.event.ActionEvent evt) {

        if ( estadoSelecionado != null ) {

            estadoSelecionado.setFinal( checkFinalEdicao.isSelected() );
            atualizaComboEstados();
            painelVisualizacao.repaint();

        }

    }

    private void btnNovoAutomatoActionPerformed(java.awt.event.ActionEvent evt) {

        estadoSelecionado = null;
        estados = new ArrayList< Estado >();
        atualizaComboEstados();
        atualizaComponentesEstadoSelecionado();

        ( ( JPanelVisualizacao ) painelVisualizacao ).setEstadoSelecionado( null );
        ( ( JPanelVisualizacao ) painelVisualizacao ).setEstados( estados );
        painelVisualizacao.repaint();
        for ( Component c : painelVisualizacao.getComponents() ) {
            if ( c instanceof JPanelEstado ) {
                painelVisualizacao.remove( c );
            }
        }

        fieldTeste.setText( "" );

        indice = 0;

    }

    private void btnExcluirEstadoActionPerformed(java.awt.event.ActionEvent evt) {

        if ( estadoSelecionado != null ) {

            if ( JOptionPane.showConfirmDialog( null,
                    "Isso ainda não está funcionando direito.\n" +
                            "Deseja mesmo excluir?", "Confirmação",
                    JOptionPane.YES_NO_OPTION ) == JOptionPane.YES_OPTION ) {

                // remove as transições do estado
                for ( Estado e : estados ) {
                    for ( Transicao t : e.getTransicoes() ) {
                        if ( t.getEstadoDestino().equals( estadoSelecionado ) ) {
                            e.getTransicoes().remove( t );
                        }
                    }
                }

                // remove o estado
                if ( estadoSelecionado.isInicial() )
                    criarInicial = true;


                // remove da visualização
                ( ( JPanelVisualizacao ) painelVisualizacao ).setEstadoSelecionado( null );
                for ( Component c : painelVisualizacao.getComponents() ) {
                    if ( c instanceof JPanelEstado ) {
                        if ( ( ( JPanelEstado ) c ).getEstado().equals( estadoSelecionado ) ) {
                            painelVisualizacao.remove( c );
                        }
                    }
                }

                estados.remove( estadoSelecionado );
                selecionaEstado( null );
                atualizaComboEstados();
                painelVisualizacao.repaint();

            }

        }

    }//GEN-LAST:event_btnExcluirEstadoActionPerformed

    private void btnExibirModeloActionPerformed(java.awt.event.ActionEvent evt) {

        new JDialogModelo( this, true, estados ).setVisible( true );

    }//GEN-LAST:event_btnExibirModeloActionPerformed

    private void atualizaComboEstados() {

        DefaultComboBoxModel modelo = new DefaultComboBoxModel();

        for ( Estado e : estados )
            modelo.addElement( e );

        comboEstados.setModel( modelo );

    }

    public void selecionaEstado( Estado estado ) {
        estadoSelecionado = estado;
        atualizaComponentesEstadoSelecionado();
        ( ( JPanelVisualizacao ) painelVisualizacao ).setEstadoSelecionado( estadoSelecionado );
        painelVisualizacao.repaint();
    }

    private void atualizaComponentesEstadoSelecionado() {

        if ( estadoSelecionado != null ) {
            fieldEstadoSelecionado.setText( estadoSelecionado.getNome() );
            checkFinalEdicao.setSelected( estadoSelecionado.isFinal() );
            atualizaListaTransicoes();
        } else {
            fieldEstadoSelecionado.setText( "" );
            checkFinalEdicao.setSelected( false );
            listaTransicoes.setModel( new DefaultListModel() );
        }

    }

    private void atualizaListaTransicoes() {

        DefaultListModel modelo = new DefaultListModel();

        for ( Transicao t : estadoSelecionado.getTransicoes() )
            modelo.addElement( t );

        listaTransicoes.setModel( modelo );

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddEstado;
    private javax.swing.JButton btnAddTransicao;
    private javax.swing.JButton btnExcluirEstado;
    private javax.swing.JButton btnExibirModelo;
    private javax.swing.JButton btnNovoAutomato;
    private javax.swing.JButton btnRemoveTransicao;
    private javax.swing.JButton btnTeste;
    private javax.swing.JCheckBox checkFinal;
    private javax.swing.JCheckBox checkFinalEdicao;
    private javax.swing.JComboBox comboEstados;
    private javax.swing.JTextField fieldEstadoSelecionado;
    private javax.swing.JTextField fieldSimbolo;
    private javax.swing.JTextField fieldTeste;
    private javax.swing.JLabel labeTeste;
    private javax.swing.JLabel labelEstadoDestino;
    private javax.swing.JLabel labelNomeEstado;
    private javax.swing.JLabel labelSimbolo;
    private javax.swing.JList listaTransicoes;
    private javax.swing.JPanel painelCriacaoEstados;
    private javax.swing.JPanel painelEdicaoEstados;
    private javax.swing.JPanel painelTransicoes;
    private javax.swing.JPanel painelVisualizacao;
    private javax.swing.JPanel painelVisualizacaoBorda;
    private javax.swing.JScrollPane scrollListaTransicoes;
    // End of variables declaration//GEN-END:variables

}