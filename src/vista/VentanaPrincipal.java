package vista;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ControlProceso;
import modelo.Dispositivo;
import modelo.Proceso;

public class VentanaPrincipal extends javax.swing.JFrame {

    private ControlProceso controlProces;
    private DefaultTableModel modeloTabla;
    Dispositivo dispositivosDisponibles[]=new Dispositivo[3];
    //Dispositivo dispositivosDisponibles[]=new Dispositivo[10];
    private Proceso procesoEjecutado;
    
    public VentanaPrincipal() {
        initComponents();
        jList_nuevo.setModel(new DefaultListModel());
        jList_listo.setModel(new DefaultListModel());
        jList_impresoraBloq.setModel(new DefaultListModel());
        jList_monitorBloq.setModel(new DefaultListModel());
        jList_archivoBloq.setModel(new DefaultListModel());
        jList_terminado.setModel(new DefaultListModel());
        controlProces=new ControlProceso(this,jTable1,txtTamActual);        
        modeloTabla=new DefaultTableModel();
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Id");
        modeloTabla.addColumn("Tamanio");
        modeloTabla.addColumn("Estado");
        modeloTabla.addColumn("DispositivoEx");
        dispositivosDisponibles[0]=new Dispositivo("Impresora","1");
        dispositivosDisponibles[1]=new Dispositivo("Monitor","2");
        dispositivosDisponibles[2]=new Dispositivo("Archivo Externo","3");
        /*
        dispositivosDisponibles[0]=new Dispositivo("Impresora","1");
        dispositivosDisponibles[1]=new Dispositivo("Monitor","2");
        dispositivosDisponibles[2]=new Dispositivo("Archivo","3");
        dispositivosDisponibles[3]=new Dispositivo("Parlante","4");
        dispositivosDisponibles[4]=new Dispositivo("Microfono","5");
        dispositivosDisponibles[5]=new Dispositivo("Usb","6");
        dispositivosDisponibles[6]=new Dispositivo("Camara","7");
        dispositivosDisponibles[7]=new Dispositivo("Driver","8");
        dispositivosDisponibles[8]=new Dispositivo("Joystick","9");
        dispositivosDisponibles[9]=new Dispositivo("Diadema","10");
        */
        //Todos los dispositivos estaran disponibles
        dispositivosDisponibles[0].setDisponible(true);
        dispositivosDisponibles[1].setDisponible(true);
        dispositivosDisponibles[2].setDisponible(true);
        /*
        dispositivosDisponibles[0].setDisponible(true);
        dispositivosDisponibles[1].setDisponible(true);
        dispositivosDisponibles[2].setDisponible(true);
        dispositivosDisponibles[3].setDisponible(true);
        dispositivosDisponibles[4].setDisponible(true);
        dispositivosDisponibles[5].setDisponible(true);
        dispositivosDisponibles[6].setDisponible(true);
        dispositivosDisponibles[7].setDisponible(true);
        dispositivosDisponibles[8].setDisponible(true);
        dispositivosDisponibles[9].setDisponible(true);*/
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton_start = new javax.swing.JButton();
        jButton_stop = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField_nombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField_id = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jSpinner_tamanio = new javax.swing.JSpinner();
        jLabel14 = new javax.swing.JLabel();
        jCheckBox_requiereImpresora = new javax.swing.JCheckBox();
        jCheckBox_requiereMonitor = new javax.swing.JCheckBox();
        jCheckBox_requiereArchivo = new javax.swing.JCheckBox();
        jButton_crearProceso = new javax.swing.JButton();
        jCheckBox_requiereParlante = new javax.swing.JCheckBox();
        jCheckBox_requiereMicrofono = new javax.swing.JCheckBox();
        jCheckBox_requiereUsb = new javax.swing.JCheckBox();
        jCheckBox_requiereCamara = new javax.swing.JCheckBox();
        jCheckBox_RequiereDriver = new javax.swing.JCheckBox();
        jCheckBox_RequiereDiadema = new javax.swing.JCheckBox();
        jCheckBox_requiereJoystick = new javax.swing.JCheckBox();
        jCheckBox_requiereTodos = new javax.swing.JCheckBox();
        jPanel7 = new javax.swing.JPanel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jSpinner_eliminacionPorProceso = new javax.swing.JSpinner();
        botonMatarProceso = new javax.swing.JButton();
        listaRequerimientos = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtIdProceso = new javax.swing.JLabel();
        txtNombreProceso = new javax.swing.JLabel();
        txtEstadoProceso = new javax.swing.JLabel();
        txtTamanhoProceso = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtTamActual = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        listaRequiere = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        txtTiempoListo = new javax.swing.JLabel();
        txtTiempoBloqueado = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        txtTiempoEjecucion = new javax.swing.JLabel();
        txtTiempoTotal = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel_impresoraDIs = new javax.swing.JLabel();
        jLabel_monitorDis = new javax.swing.JLabel();
        jLabel_archivoDIs = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jComboBox_dispositivos = new javax.swing.JComboBox();
        jLabel29 = new javax.swing.JLabel();
        jLabel_infoNombreDIs = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel_inforIdDis = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel_infoContenedorDis = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtNombreContenedor = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel_UsbDis = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel_CamaraDis = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel_DriverDis = new javax.swing.JLabel();
        jLabel_ParlanteDis = new javax.swing.JLabel();
        jLabel_MicrofonoDis = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel_DiademaDis = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel_JoystickDis = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList_nuevo = new javax.swing.JList();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList_listo = new javax.swing.JList();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        panelOverload1 = new vista.PanelOverload();
        jLabel_Proceso = new javax.swing.JLabel();
        jProgressBar_proceso = new javax.swing.JProgressBar();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jList_terminado = new javax.swing.JList();
        jLabel12 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList_impresoraBloq = new javax.swing.JList();
        jScrollPane7 = new javax.swing.JScrollPane();
        jList_monitorBloq = new javax.swing.JList();
        jScrollPane8 = new javax.swing.JScrollPane();
        jList_archivoBloq = new javax.swing.JList();
        jLabel13 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        statusBar = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem_insertarProcesosAleatorios = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ProcessSimulator UDistrital");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Panel Control e Informacion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(102, 102, 255)));

        jButton_start.setText("INICIAR");
        jButton_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_startActionPerformed(evt);
            }
        });

        jButton_stop.setText("PARAR");
        jButton_stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_stopActionPerformed(evt);
            }
        });

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Creacion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(102, 102, 255)));

        jLabel1.setText("Nombre");

        jTextField_nombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField_nombreMouseClicked(evt);
            }
        });
        jTextField_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_nombreActionPerformed(evt);
            }
        });
        jTextField_nombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_nombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_nombreFocusLost(evt);
            }
        });

        jLabel2.setText("ID:");

        jTextField_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_idActionPerformed(evt);
            }
        });
        jTextField_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_idFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_idFocusLost(evt);
            }
        });

        jLabel3.setText("Tamanio");

        jSpinner_tamanio.setModel(new javax.swing.SpinnerNumberModel(100, 1, 1000, 1));
        jSpinner_tamanio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSpinner_tamanioMouseClicked(evt);
            }
        });

        jLabel14.setText("Requiere");

        jCheckBox_requiereImpresora.setText("Impresora");
        jCheckBox_requiereImpresora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox_requiereImpresoraMouseClicked(evt);
            }
        });
        jCheckBox_requiereImpresora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_requiereImpresoraActionPerformed(evt);
            }
        });

        jCheckBox_requiereMonitor.setText("Monitor");
        jCheckBox_requiereMonitor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox_requiereMonitorMouseClicked(evt);
            }
        });

        jCheckBox_requiereArchivo.setText("Archivo");
        jCheckBox_requiereArchivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox_requiereArchivoMouseClicked(evt);
            }
        });
        jCheckBox_requiereArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_requiereArchivoActionPerformed(evt);
            }
        });

        jButton_crearProceso.setText("Crear");
        jButton_crearProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_crearProcesoActionPerformed(evt);
            }
        });

        jCheckBox_requiereParlante.setText("Parlante");

        jCheckBox_requiereMicrofono.setText("Microfono");

        jCheckBox_requiereUsb.setText("Usb");

        jCheckBox_requiereCamara.setText("Camara");

        jCheckBox_RequiereDriver.setText("Driver");

        jCheckBox_RequiereDiadema.setText("Diadema");
        jCheckBox_RequiereDiadema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_RequiereDiademaActionPerformed(evt);
            }
        });

        jCheckBox_requiereJoystick.setText("Joystick");

        jCheckBox_requiereTodos.setText("Todos");
        jCheckBox_requiereTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_requiereTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_nombre)
                            .addComponent(jTextField_id)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSpinner_tamanio, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox_requiereMonitor)
                            .addComponent(jCheckBox_requiereImpresora)
                            .addComponent(jCheckBox_requiereArchivo)
                            .addComponent(jCheckBox_requiereJoystick))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox_requiereUsb)
                                    .addComponent(jCheckBox_requiereParlante)
                                    .addComponent(jCheckBox_requiereMicrofono))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox_requiereCamara)
                                    .addComponent(jCheckBox_RequiereDriver)
                                    .addComponent(jCheckBox_RequiereDiadema)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jCheckBox_requiereTodos)
                                .addGap(30, 30, 30)
                                .addComponent(jButton_crearProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 32, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jSpinner_tamanio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jCheckBox_requiereImpresora)
                    .addComponent(jCheckBox_requiereParlante)
                    .addComponent(jCheckBox_requiereCamara))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox_requiereMonitor)
                    .addComponent(jCheckBox_requiereMicrofono)
                    .addComponent(jCheckBox_RequiereDriver))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox_requiereArchivo)
                    .addComponent(jCheckBox_requiereUsb)
                    .addComponent(jCheckBox_RequiereDiadema))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox_requiereJoystick)
                            .addComponent(jCheckBox_requiereTodos)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jButton_crearProceso)))
                .addGap(23, 23, 23))
        );

        jTabbedPane1.addTab("Creacion", jPanel6);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Control Procesador", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(102, 102, 255)));

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(100, 10, 5000, 1));

        jLabel16.setText("Tiempo de Ejecucion(ms):");

        jLabel17.setText("Eliminacion por Ciclo:");

        jSpinner_eliminacionPorProceso.setModel(new javax.swing.SpinnerNumberModel(10, 10, 100, 1));

        botonMatarProceso.setText("MATAR PROCESO");
        botonMatarProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMatarProcesoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSpinner1)
                            .addComponent(jSpinner_eliminacionPorProceso)))
                    .addComponent(botonMatarProceso))
                .addContainerGap(181, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jSpinner_eliminacionPorProceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(botonMatarProceso)
                .addGap(40, 40, 40))
        );

        jTabbedPane1.addTab("Procesador", jPanel7);

        listaRequerimientos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaRequerimientosMouseClicked(evt);
            }
        });

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informarcion proceso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(102, 102, 255)));

        jLabel18.setText("Id proceso :");

        jLabel19.setText("Nombre : ");

        jLabel20.setText("Estado :");

        jLabel21.setText("Tamaño :");

        jLabel22.setText("Tam actual :");

        jLabel32.setText("Requiere :");

        jLabel34.setForeground(new java.awt.Color(0, 51, 204));
        jLabel34.setText("Tiempos");

        jLabel35.setText("Listo :");

        jLabel36.setText("Bloqueado :");

        jLabel37.setText("Ejecucion :");

        jLabel39.setText("Total :");

        txtTiempoBloqueado.setName("txtTiempoBloqueado"); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel21))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIdProceso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNombreProceso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtEstadoProceso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTamanhoProceso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel32))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTamActual, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(listaRequiere, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36)
                            .addComponent(jLabel35))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTiempoBloqueado, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                            .addComponent(txtTiempoListo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel37)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel39)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel38)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTiempoEjecucion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTiempoTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel34)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
                    .addComponent(txtIdProceso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtNombreProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtEstadoProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtTamanhoProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTamActual, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(listaRequiere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTiempoListo, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
                    .addComponent(jLabel41)
                    .addComponent(txtTiempoEjecucion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jLabel38)
                    .addComponent(jLabel39)
                    .addComponent(txtTiempoBloqueado, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42)
                    .addComponent(txtTiempoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        listaRequerimientos.addTab("Info-process", jPanel8);
        listaRequerimientos.addTab("", jTabbedPane2);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estado Dispositivos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(102, 102, 255)));

        jLabel23.setText("Impresora:");

        jLabel24.setText("Monitor:");

        jLabel25.setText("Archivo ext:");

        jLabel_impresoraDIs.setText("Disponible");

        jLabel_monitorDis.setText("Disponible");

        jLabel_archivoDIs.setText("Disponible");

        jLabel28.setText("Seleccione");

        jComboBox_dispositivos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Impresora", "Monitor", "Archivo Ext" }));
        jComboBox_dispositivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_dispositivosActionPerformed(evt);
            }
        });

        jLabel29.setText("Nombre:");

        jLabel_infoNombreDIs.setText("none");

        jLabel30.setText("Id:");

        jLabel_inforIdDis.setText("none");

        jLabel31.setText("Contenedor:");

        jLabel_infoContenedorDis.setText("none");

        jLabel33.setText("Nombre Cont :");

        jLabel40.setText("Parlante :");

        jLabel44.setText("Microfono :");

        jLabel45.setText("jLabel45");

        jLabel46.setText("Usb :");

        jLabel_UsbDis.setText("Disponible");

        jLabel48.setText("Camara:");

        jLabel_CamaraDis.setText("Disponible");

        jLabel50.setText("Driver :");

        jLabel_DriverDis.setText("Disponible");

        jLabel_ParlanteDis.setText("Disponible");

        jLabel_MicrofonoDis.setText("Disponible");

        jLabel43.setText("Diadema :");

        jLabel_DiademaDis.setText("Disponible");

        jLabel55.setText("Joystick :");

        jLabel_JoystickDis.setText("Disponible");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25)
                            .addComponent(jLabel40)
                            .addComponent(jLabel44))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel_MicrofonoDis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel_ParlanteDis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel_impresoraDIs, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                            .addComponent(jLabel_archivoDIs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel_monitorDis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel55))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_UsbDis, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel_JoystickDis, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel43)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel_DiademaDis, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel50)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel_DriverDis, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel48)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel_CamaraDis, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31)
                            .addComponent(jLabel33))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_infoContenedorDis, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_inforIdDis, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_infoNombreDIs, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox_dispositivos, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel_impresoraDIs)
                    .addComponent(jLabel46)
                    .addComponent(jLabel_UsbDis))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel_monitorDis)
                    .addComponent(jLabel48)
                    .addComponent(jLabel_CamaraDis))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel_archivoDIs)
                    .addComponent(jLabel50)
                    .addComponent(jLabel_DriverDis))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(jLabel_ParlanteDis)
                    .addComponent(jLabel43)
                    .addComponent(jLabel_DiademaDis))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_MicrofonoDis)
                    .addComponent(jLabel55)
                    .addComponent(jLabel_JoystickDis))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBox_dispositivos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel29)
                    .addComponent(jLabel_infoNombreDIs))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jLabel_inforIdDis))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel31)
                    .addComponent(jLabel_infoContenedorDis))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel33)
                    .addComponent(txtNombreContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        listaRequerimientos.addTab("info-disp", jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(listaRequerimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jButton_start, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jButton_stop, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listaRequerimientos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_start)
                    .addComponent(jButton_stop))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Vista ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(102, 102, 255)));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jScrollPane3.setViewportView(jList_nuevo);

        jLabel7.setText("NUEVO");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/flecha-derecha.png"))); // NOI18N
        jLabel4.setEnabled(false);

        jScrollPane4.setViewportView(jList_listo);

        jLabel10.setText("LISTO");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/flecha-derecha.png"))); // NOI18N
        jLabel5.setEnabled(false);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/flecha-izquierda.png"))); // NOI18N
        jLabel15.setEnabled(false);

        panelOverload1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 0)));

        jLabel_Proceso.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_Proceso.setText("-------------------------------");
        jLabel_Proceso.setOpaque(true);

        javax.swing.GroupLayout panelOverload1Layout = new javax.swing.GroupLayout(panelOverload1);
        panelOverload1.setLayout(panelOverload1Layout);
        panelOverload1Layout.setHorizontalGroup(
            panelOverload1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jProgressBar_proceso, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
            .addComponent(jLabel_Proceso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelOverload1Layout.setVerticalGroup(
            panelOverload1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOverload1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_Proceso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(jProgressBar_proceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel11.setText("EJECUCION");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/flecha-derecha.png"))); // NOI18N
        jLabel6.setEnabled(false);

        jScrollPane6.setViewportView(jList_terminado);

        jLabel12.setText("Terminado");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel7)
                        .addGap(168, 168, 168)
                        .addComponent(jLabel10)
                        .addGap(204, 204, 204)
                        .addComponent(jLabel11)
                        .addGap(175, 175, 175)
                        .addComponent(jLabel12))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel4)
                        .addGap(0, 0, 0)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelOverload1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel10))
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelOverload1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/flehcaChuecaReves.png"))); // NOI18N
        jLabel8.setEnabled(false);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/flehcaChueca.png"))); // NOI18N
        jLabel9.setEnabled(false);

        jScrollPane2.setViewportView(jList_impresoraBloq);

        jScrollPane7.setViewportView(jList_monitorBloq);

        jScrollPane8.setViewportView(jList_archivoBloq);

        jLabel13.setText("Impresora");

        jLabel26.setText("Monitor");

        jLabel27.setText("Archivo");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(137, 137, 137))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addComponent(jLabel13)
                .addGap(61, 61, 61)
                .addComponent(jLabel26)
                .addGap(95, 95, 95)
                .addComponent(jLabel27)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel8))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel9)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        statusBar.setText("Bienvenido , este programa fue desarrolado por esttudiantes de la UDistrital");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusBar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(statusBar, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenu1.setText("Archivo");

        jMenuItem_insertarProcesosAleatorios.setText("Insertar Proceso Aleatorios");
        jMenuItem_insertarProcesosAleatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_insertarProcesosAleatoriosActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem_insertarProcesosAleatorios);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(13, 13, 13))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_crearProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_crearProcesoActionPerformed
        String nombreproceso = this.jTextField_nombre.getText();
        String id = this.jTextField_id.getText();
        jLabel4.setEnabled(true);         
        if (nombreproceso.compareTo("")!=0 && id.compareTo("")!=0) {
            Dispositivo requerimientos[]={null,null,null};
            /*Dispositivo requerimientos[]={null,null,null,null,null,null,null,null,null,null};
            //if(this.jCheckBox_requiereTodos.isSelected()){
                requerimientos[0]=new Dispositivo("Impresora","1");
                requerimientos[1]=new Dispositivo("Monitor","2");
                requerimientos[2]=new Dispositivo("Archivo","3");
                requerimientos[3]=new Dispositivo("Parlante","4");
                requerimientos[4]=new Dispositivo("Microfono","5");
                requerimientos[5]=new Dispositivo("Usb","6");
                requerimientos[6]=new Dispositivo("Camara","7");
                requerimientos[7]=new Dispositivo("Driver","8");
                requerimientos[8]=new Dispositivo("Joystick","9");
                requerimientos[9]=new Dispositivo("Diadema","10");
             }else{ 
            
             if(this.jCheckBox_requiereImpresora.isSelected()) {
                requerimientos[0]=new Dispositivo("Impresora", "1");
             }
             if(this.jCheckBox_requiereMonitor.isSelected()) {
                requerimientos[1]=new Dispositivo("Monitor", "2");
             }
             if(this.jCheckBox_requiereArchivo.isSelected()) {
                requerimientos[2]=new Dispositivo("Archivo", "3");
             }
             if(this.jCheckBox_RequiereParlante.isSelected()) {
                requerimientos[3]=new Dispositivo("Parlante", "4");
             }
             if(this.jCheckBox_RequiereMicrofono.isSelected()) {
                requerimientos[4]=new Dispositivo("Microfono", "5");
             }
             if(this.jCheckBox_RequiereUsb.isSelected()) {
                requerimientos[5]=new Dispositivo("Usb", "6");
             }
             if(this.jCheckBox_requiereCamara.isSelected()) {
                requerimientos[6]=new Dispositivo("Camara", "7");
             }
             if(this.jCheckBox_RequiereDriver.isSelected()) {
                requerimientos[7]=new Dispositivo("Driver", "8");
             }
             if(this.jCheckBox_RequiereDiadema.isSelected()) {
                requerimientos[8]=new Dispositivo("Diadema", "9");
             }
             if(this.jCheckBox_RequiereJoystick.isSelected()) {
                requerimientos[9]=new Dispositivo("Joystick", "1");
             }
             }*/
            if(this.jCheckBox_requiereImpresora.isSelected()) {
                requerimientos[0]=new Dispositivo("Impresora", "1");
            }
            if(this.jCheckBox_requiereMonitor.isSelected()) {
                requerimientos[1]=new Dispositivo("Monitor", "2");
            }
            if(this.jCheckBox_requiereArchivo.isSelected()) {
                requerimientos[2]=new Dispositivo("Archivo", "3");
            }
            /*
            
            */
            
            Proceso proceso=new Proceso (nombreproceso, id, "LISTO",(Integer)this.jSpinner_tamanio.getValue(),requerimientos,0,0,0);
            
            if(controlProces.addProceso(proceso)){                
                addItem(jList_listo, id + " " + nombreproceso);
                deleteItem(jList_nuevo, id + " " + nombreproceso);
                addItemTable(proceso);
                
            }else{                                
                JOptionPane.showMessageDialog(this, "Proceso con ID ya existente",
                    "Error de ingreso", JOptionPane.ERROR_MESSAGE);
            }
            //Activamos los componententes para el ingreso de datos del nuevo proceso            
            //controlProces.cambiarEstado(proceso,"EJECUCION");
        } else {
            JOptionPane.showMessageDialog(this, "Error debe ingresar datos validos",
                    "Error de ingreso", JOptionPane.ERROR_MESSAGE);
        }
        statusBar.setText("se ha creado un nuevo proceso.");
    }//GEN-LAST:event_jButton_crearProcesoActionPerformed

    private void addItemTable(Proceso proceso){
        Object vec[]=new Object[5];
        vec[0]=proceso.getNombre();
        vec[1]=proceso.getId();
        vec[2]=proceso.getTamanio();
        vec[3]=proceso.getEstado();
        vec[4]=proceso.isRequiereDispositivo();
        modeloTabla.addRow(vec);
        jTable1.setModel(modeloTabla);
    }
    
    public void actualizarDispositivos(Dispositivo dis){
   
        System.out.println("Actualizando dispositivo" + dis.getId());

        if (dis.getId().compareTo("1") == 0) {
            if (dis.isDisponible()) {
                jLabel_impresoraDIs.setText("Disponible");
            } else {
                jLabel_impresoraDIs.setText("NO Disponible");
            }
        }

        if (dis.getId().compareTo("2") == 0) {
            if (dis.isDisponible()) {
                jLabel_monitorDis.setText("Disponible");
            } else {
                jLabel_monitorDis.setText("NO Disponible");
            }
        }

        if (dis.getId().compareTo("3") == 0) {
            if (dis.isDisponible()) {
                jLabel_archivoDIs.setText("Disponible");
            } else {
                jLabel_archivoDIs.setText("NO Disponible");
            }
        }
        
        /*
         if (dis.getId().compareTo("4") == 0) {
            if (dis.isDisponible()) {
                jLabel_ParlanteDis.setText("Disponible");
            } else {
                jLabel_ParlanteDis.setText("NO Disponible");
            }
        }
        * 
        * if (dis.getId().compareTo("5") == 0) {
            if (dis.isDisponible()) {
                jLabel_MicrofonoDis.setText("Disponible");
            } else {
                jLabel_MicrofonoDIs.setText("NO Disponible");
            }
        }
        * 
        * if (dis.getId().compareTo("6") == 0) {
            if (dis.isDisponible()) {
                jLabel_usbDIs.setText("Disponible");
            } else {
                jLabel_usbDIs.setText("NO Disponible");
            }
        }
        * 
        * if (dis.getId().compareTo("7") == 0) {
            if (dis.isDisponible()) {
                jLabel_camaraDIs.setText("Disponible");
            } else {
                jLabel_camaraDIs.setText("NO Disponible");
            }
        }
        * 
        * if (dis.getId().compareTo("3") == 0) {
            if (dis.isDisponible()) {
                jLabel_DriverDIs.setText("Disponible");
            } else {
                jLabel_DriverDIs.setText("NO Disponible");
            }
        }
        * 
        * if (dis.getId().compareTo("8") == 0) {
            if (dis.isDisponible()) {
                jLabel_DiademaDIs.setText("Disponible");
            } else {
                jLabel_DiademaDIs.setText("NO Disponible");
            }
        }
        * 
        * if (dis.getId().compareTo("9") == 0) {
            if (dis.isDisponible()) {
                jLabel_JoystickDIs.setText("Disponible");
            } else {
                jLabel_JoystickDIs.setText("NO Disponible");
            }
        }
        * 
        * 
         */
    }
    
    private void desactivarTodasLasFelchas(){
        jLabel4.setEnabled(false);
        jLabel5.setEnabled(false);
        jLabel6.setEnabled(false);
        jLabel8.setEnabled(false);
        jLabel9.setEnabled(false);
        jLabel15.setEnabled(false);        
    }
    
    public void listoToEjecucion(){
        desactivarTodasLasFelchas();
        jLabel5.setEnabled(true);
        if(jList_listo.getModel().getSize()>0){
            String info=(String) jList_listo.getModel().getElementAt(jList_listo.getModel().getSize()-1);    
            DefaultListModel modelo = (DefaultListModel) jList_listo.getModel();
            modelo.remove(modelo.size()-1);                
            jList_listo.setModel(modelo);
            jLabel_Proceso.setText(info);
        }
    }
    
    public void ejecucionToTerminado(){
        desactivarTodasLasFelchas();
        jLabel6.setEnabled(true);
        String info= jLabel_Proceso.getText();
        DefaultListModel modelo = (DefaultListModel) jList_terminado.getModel();
        modelo.add(0, info);
        jList_terminado.setModel(modelo);
        jLabel_Proceso.setText("-------------");
    }
    
    public void ejecucionToListo(){
        desactivarTodasLasFelchas();
        jLabel15.setEnabled(true);
        String info= jLabel_Proceso.getText();
        DefaultListModel modelo = (DefaultListModel) jList_listo.getModel();
        modelo.add(0, info);
        jList_listo.setModel(modelo);
        jLabel_Proceso.setText("-------------");
    }
    //***************************
     public void ejecucionToImpresoraBloqueado(){
        desactivarTodasLasFelchas();
        jLabel9.setEnabled(true);
        String info= jLabel_Proceso.getText();
        DefaultListModel modelo = (DefaultListModel) jList_impresoraBloq.getModel();
        modelo.add(0, info);
        jList_impresoraBloq.setModel(modelo);
        jLabel_Proceso.setText("-------------");
    }
     
     public void ejecucionToArchivoaBloqueado(){
        desactivarTodasLasFelchas();
        jLabel9.setEnabled(true);
        String info= jLabel_Proceso.getText();
        DefaultListModel modelo = (DefaultListModel) jList_archivoBloq.getModel();
        modelo.add(0, info);
        jList_archivoBloq.setModel(modelo);
        jLabel_Proceso.setText("-------------");
    }
     
     public void ejecucionToMonitorBloqueado(){
        desactivarTodasLasFelchas();
        jLabel9.setEnabled(true);
        String info= jLabel_Proceso.getText();
        DefaultListModel modelo = (DefaultListModel) jList_monitorBloq.getModel();
        modelo.add(0, info);
        jList_monitorBloq.setModel(modelo);
        jLabel_Proceso.setText("-------------");
    }
     
     //********************************
     
     public void impresoraBloqueadoToListo(){
        desactivarTodasLasFelchas();
        jLabel8.setEnabled(true);
        String info=(String) jList_impresoraBloq.getModel().getElementAt(jList_impresoraBloq.getModel().getSize()-1);    
        DefaultListModel modelo = (DefaultListModel) jList_impresoraBloq.getModel();
        modelo.remove(modelo.size()-1);                
        jList_impresoraBloq.setModel(modelo);
        modelo= (DefaultListModel) jList_listo.getModel();
        modelo.add(0, info);
        jList_listo.setModel(modelo);
    }
     
     public void monitorBloqueadoToListo(){
        desactivarTodasLasFelchas();
        jLabel8.setEnabled(true);
        String info=(String) jList_monitorBloq.getModel().getElementAt(jList_monitorBloq.getModel().getSize()-1);    
        DefaultListModel modelo = (DefaultListModel) jList_monitorBloq.getModel();
        modelo.remove(modelo.size()-1);                
        jList_monitorBloq.setModel(modelo);
        modelo= (DefaultListModel) jList_listo.getModel();
        modelo.add(0, info);
        jList_listo.setModel(modelo);
    }
     
     public void archivoBloqueadoToListo(){
        desactivarTodasLasFelchas();
        jLabel8.setEnabled(true);
        String info=(String) jList_archivoBloq.getModel().getElementAt(jList_archivoBloq.getModel().getSize()-1);    
        DefaultListModel modelo = (DefaultListModel) jList_archivoBloq.getModel();
        modelo.remove(modelo.size()-1);                
        jList_archivoBloq.setModel(modelo);
        modelo= (DefaultListModel) jList_listo.getModel();
        modelo.add(0, info);
        jList_listo.setModel(modelo);
    }
     
     //**********************************
     
     public void activarPorgresBar(int total,int actual){
         this.jProgressBar_proceso.setMaximum(total);
         this.jProgressBar_proceso.setValue(actual);
     }
     
     public int getValueTiempoProceso(){
         return (int) this.jSpinner1.getValue();
     }
    
    
    private void jTextField_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_nombreActionPerformed
       
    }//GEN-LAST:event_jTextField_nombreActionPerformed

    private void jTextField_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_idActionPerformed
        statusBar.setText("ingrese el id del proceso");
    }//GEN-LAST:event_jTextField_idActionPerformed

    private void jTextField_nombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_nombreFocusGained
   
    }//GEN-LAST:event_jTextField_nombreFocusGained

    private void jTextField_idFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_idFocusGained
       
    }//GEN-LAST:event_jTextField_idFocusGained

    private void jTextField_nombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_nombreFocusLost
        functionAddNuevo();
    }//GEN-LAST:event_jTextField_nombreFocusLost

    private void jTextField_idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_idFocusLost
       functionAddNuevo();
    }//GEN-LAST:event_jTextField_idFocusLost

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int filaSeleccionada= jTable1.getSelectedRow();
        actualizarInformacion(filaSeleccionada);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jCheckBox_requiereArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_requiereArchivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox_requiereArchivoActionPerformed

    
    
    private void jButton_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_startActionPerformed
        jLabel4.setEnabled(false);
        statusBar.setText("Se ha iniciado la ejecuacion de los procesos.");
        if(controlProces.isTerminado()) {
            controlProces.setDispositivosDisponibles(dispositivosDisponibles);
        }         
         (new Thread() {
             @Override
            public void run() {
              controlProces.ejecutar();
            }
           }).start();
    }//GEN-LAST:event_jButton_startActionPerformed

    public void desactivarPaneles(){
        jButton_start.setEnabled(false);     
        /*for (int i = 0; i < jPanel6.getComponentCount(); i++) {
            jPanel6.getComponent(i).setEnabled(false);
        }   */
    }
    
    public int getCantidadAQUitarJSpinner(){
        return (int)this.jSpinner_eliminacionPorProceso.getValue();
    }
    
    public void activarPaneles(){
        desactivarTodasLasFelchas();
        controlProces.setStop(true);  
        jButton_start.setEnabled(true);
       /* for (int i = 0; i < jPanel6.getComponentCount(); i++) {
            jPanel6.getComponent(i).setEnabled(true);
        }        
        for (int i = 0; i < jPanel4.getComponentCount(); i++) {
            jPanel4.getComponent(i).setEnabled(true);
        }*/
    }
    
    
    public void actualizarProcesosTabla(Proceso procesoEjecutado){
        this.procesoEjecutado=procesoEjecutado;
        int row = 0;
        String idProcesoEjecutado = procesoEjecutado.getId();
        String estadoActual = procesoEjecutado.getEstado();
        String tamanio = String.valueOf(procesoEjecutado.getTamanio_actual());
        while(row<jTable1.getRowCount()){
            if(idProcesoEjecutado.equals(jTable1.getValueAt(row,1))){
                jTable1.setValueAt(estadoActual, row,3);
                jTable1.setValueAt(tamanio, row, 2);
                break;
            }else{
                row++;
            }
        }
    }
    
    private void jButton_stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_stopActionPerformed
        activarPaneles();
        statusBar.setText("se ha detenido la ejecucion de los procesos");
    }//GEN-LAST:event_jButton_stopActionPerformed

    private void jMenuItem_insertarProcesosAleatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_insertarProcesosAleatoriosActionPerformed
        // TODO add your handling code here:
         Dispositivo requerimientos[]={null,null,null};

        
        int max=1000;
        int min=15;        
        for(int i=0;i<15;i++){
            int random1=(int)(Math.random()*(max-min))+min;
            
            if(random1%15==0){
                requerimientos[0]=new Dispositivo(("Impresora"), "1");
            }               
            if(random1%4==0){
                requerimientos[1]=new Dispositivo(("Monitor"), "2");
            }
            if(random1%9==0){
                requerimientos[2]=new Dispositivo(("Archivo"), "3");
            }
            //xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
            Proceso procesoAux=new Proceso("Chrome",String.valueOf(random1), "LISTO", random1 , requerimientos,0,0,0);
            if (!controlProces.addProceso(procesoAux)){
                i--;
            }else {
                addItem(jList_listo, procesoAux.getId()+ " " + procesoAux.getNombre());
                deleteItem(jList_nuevo, procesoAux.getId()+ " " + procesoAux.getNombre());
                addItemTable(procesoAux);
            }
        }
        jLabel4.setEnabled(true);
    }//GEN-LAST:event_jMenuItem_insertarProcesosAleatoriosActionPerformed

    private void botonMatarProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMatarProcesoActionPerformed
        // TODO add your handling code here:
        if ("".equals(txtIdProceso.getText()) || "".equals(txtNombreProceso.getText()) || "".equals(txtEstadoProceso.getText()) || "".equals(txtTamanhoProceso.getText())) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un proceso");
        } else {
            Proceso proceso = (Proceso)controlProces.obtenerProceso(txtIdProceso.getText());
            controlProces.eliminarProceso(proceso);
            statusBar.setText("se ha eliminado un proceso");
        }
    }//GEN-LAST:event_botonMatarProcesoActionPerformed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // TODO add your handling code here:
        
        if(evt.getKeyCode()==38){
            int filaSeleccionada= jTable1.getSelectedRow()-1;
            if(filaSeleccionada <= jTable1.getRowCount()) {
                filaSeleccionada+=1;
            }
            actualizarInformacion(filaSeleccionada);
        }
        
        if(evt.getKeyCode()==40){
             int filaSeleccionada= jTable1.getSelectedRow()+1;
            if(filaSeleccionada >= jTable1.getRowCount()) {
                filaSeleccionada-=1;
            }
            actualizarInformacion(filaSeleccionada);
        }
    }//GEN-LAST:event_jTable1KeyPressed

    private void jCheckBox_requiereImpresoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_requiereImpresoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox_requiereImpresoraActionPerformed

    private void jTextField_nombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_nombreMouseClicked
        // TODO add your handling code here:
        statusBar.setText("Ingrese el nombre del proceso");
    }//GEN-LAST:event_jTextField_nombreMouseClicked

    private void jSpinner_tamanioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSpinner_tamanioMouseClicked
        // TODO add your handling code here:
        statusBar.setText("Seleccione un tamanho para el proceso");
    }//GEN-LAST:event_jSpinner_tamanioMouseClicked

    private void jCheckBox_requiereImpresoraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox_requiereImpresoraMouseClicked
        // TODO add your handling code here:
        statusBar.setText("se ha selccionado un recurso");
    }//GEN-LAST:event_jCheckBox_requiereImpresoraMouseClicked

    private void jCheckBox_requiereMonitorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox_requiereMonitorMouseClicked
        // TODO add your handling code here:
        statusBar.setText("se ha selccionado un recurso");
    }//GEN-LAST:event_jCheckBox_requiereMonitorMouseClicked

    private void jCheckBox_requiereArchivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox_requiereArchivoMouseClicked
        // TODO add your handling code here:
        statusBar.setText("se ha selccionado un recurso");
    }//GEN-LAST:event_jCheckBox_requiereArchivoMouseClicked

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
        statusBar.setText("Creacion de procesos");
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void listaRequerimientosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaRequerimientosMouseClicked
        // TODO add your handling code here:
        statusBar.setText("Informacion de procesos");
    }//GEN-LAST:event_listaRequerimientosMouseClicked

    private void jComboBox_dispositivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_dispositivosActionPerformed
        Dispositivo dispositivos[]=controlProces.getDispositivosDisponibles();

        switch (jComboBox_dispositivos.getSelectedIndex()){
            case 0:
            jLabel_infoNombreDIs.setText(dispositivosDisponibles[0].getNombre());
            jLabel_inforIdDis.setText(dispositivosDisponibles[0].getId());
            if (dispositivos!=null) {
                jLabel_infoContenedorDis.setText(dispositivos[0].getIdProcesoContenedor());
                Proceso p = (Proceso) controlProces.obtenerProceso(jLabel_infoContenedorDis.getText());
                txtNombreContenedor.setText(p.getNombre());
            }
            break;
            case 1:
            jLabel_infoNombreDIs.setText(dispositivosDisponibles[1].getNombre());
            jLabel_inforIdDis.setText(dispositivosDisponibles[1].getId());
            if (dispositivos!=null) {
                jLabel_infoContenedorDis.setText(dispositivos[1].getIdProcesoContenedor());
                Proceso p = (Proceso) controlProces.obtenerProceso(jLabel_infoContenedorDis.getText());
                txtNombreContenedor.setText(p.getNombre());
            }
            break;
            case 2:
            jLabel_infoNombreDIs.setText(dispositivosDisponibles[2].getNombre());
            jLabel_inforIdDis.setText(dispositivosDisponibles[2].getId());
            if (dispositivos!=null) {
                jLabel_infoContenedorDis.setText(dispositivos[2].getIdProcesoContenedor());
                Proceso p = (Proceso) controlProces.obtenerProceso(jLabel_infoContenedorDis.getText());
                txtNombreContenedor.setText(p.getNombre());
            }
            break;

        }
    }//GEN-LAST:event_jComboBox_dispositivosActionPerformed

    private void jCheckBox_RequiereDiademaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_RequiereDiademaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox_RequiereDiademaActionPerformed

    private void jCheckBox_requiereTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_requiereTodosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox_requiereTodosActionPerformed

    private void functionAddNuevo(){
         if(jTextField_nombre.getText().compareTo("")!=0 && jTextField_id.getText().compareTo("")!=0){
             System.out.println("ADD a la lista nuevo: Valor de id_"+jTextField_id.getText()+"_valor de nombre:_"+jTextField_nombre.getText()+"_");
            if(controlProces.addNuevo(jTextField_id.getText())){                                
                this.statusBar.setText("Bien se anadio a NUEVO");
                this.addItem(jList_nuevo,jTextField_id.getText()+" "+jTextField_nombre.getText());                
            }else{
                this.statusBar.setText("Id existente en nuevo");            
            }
        }else{
            this.statusBar.setText("No se logro aniadir a NUEVO id o nombre vacio");
        }
    }
    

    private void actualizarInformacion(int filaSeleccionada){
        String id = String.valueOf(jTable1.getValueAt(filaSeleccionada, 1));
        Proceso procesoSeleccionado = (Proceso) controlProces.obtenerProceso(id);
        int totalTime=0;

        if (procesoSeleccionado.isRequiereDispositivo()) {
            Dispositivo arreglo[] = procesoSeleccionado.getRequerimientos();
            String requerimiento[] = new String[arreglo.length];

            for (int i = 0; i < arreglo.length - 1; i++) {
                requerimiento[i] = String.valueOf(arreglo[i].getNombre());
            }
            DefaultComboBoxModel modeloComboBOx = new DefaultComboBoxModel(requerimiento);
            listaRequiere.setModel(modeloComboBOx);
        }

        controlProces.setFila(filaSeleccionada);
        txtIdProceso.setText("" + jTable1.getValueAt(filaSeleccionada, 1));
        txtNombreProceso.setText("" + jTable1.getValueAt(filaSeleccionada, 0));
        txtEstadoProceso.setText("" + jTable1.getValueAt(filaSeleccionada, 3));
        txtTamanhoProceso.setText("" + controlProces.getTamanio(txtIdProceso.getText()));
        txtTamActual.setText("" + jTable1.getValueAt(filaSeleccionada, 2));
        txtTiempoListo.setText(String.valueOf(procesoSeleccionado.getTiempoListo()));
        txtTiempoBloqueado.setText(String.valueOf(procesoSeleccionado.getTiempoBloqueado()));
        txtTiempoEjecucion.setText(String.valueOf(procesoSeleccionado.getTiempoEjecucion()));
        totalTime=Integer.parseInt(txtTiempoListo.getText()) + Integer.parseInt(txtTiempoEjecucion.getText()) + Integer.parseInt(txtTiempoBloqueado.getText());
        txtTiempoTotal.setText(String.valueOf(totalTime));
    } 
    
    //Aniade un item a un jlistX
    private boolean addItem(JList lista, String item) {
        DefaultListModel modelo = (DefaultListModel) lista.getModel();
        //modelo.addElement(item);
        modelo.add(0, item);
        lista.setModel(modelo);
        return true;
    }
    
    private void deleteItem(JList lista, String item){
        DefaultListModel modelo = (DefaultListModel) lista.getModel();
        modelo.removeElement(item);
        lista.setModel(modelo);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }
    
    
    public void modificarBoton(String cosas){
        this.jButton_start.setText(cosas);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonMatarProceso;
    private javax.swing.JButton jButton_crearProceso;
    private javax.swing.JButton jButton_start;
    private javax.swing.JButton jButton_stop;
    private javax.swing.JCheckBox jCheckBox_RequiereDiadema;
    private javax.swing.JCheckBox jCheckBox_RequiereDriver;
    private javax.swing.JCheckBox jCheckBox_requiereArchivo;
    private javax.swing.JCheckBox jCheckBox_requiereCamara;
    private javax.swing.JCheckBox jCheckBox_requiereImpresora;
    private javax.swing.JCheckBox jCheckBox_requiereJoystick;
    private javax.swing.JCheckBox jCheckBox_requiereMicrofono;
    private javax.swing.JCheckBox jCheckBox_requiereMonitor;
    private javax.swing.JCheckBox jCheckBox_requiereParlante;
    private javax.swing.JCheckBox jCheckBox_requiereTodos;
    private javax.swing.JCheckBox jCheckBox_requiereUsb;
    private javax.swing.JComboBox jComboBox_dispositivos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_CamaraDis;
    private javax.swing.JLabel jLabel_DiademaDis;
    private javax.swing.JLabel jLabel_DriverDis;
    private javax.swing.JLabel jLabel_JoystickDis;
    private javax.swing.JLabel jLabel_MicrofonoDis;
    private javax.swing.JLabel jLabel_ParlanteDis;
    private javax.swing.JLabel jLabel_Proceso;
    private javax.swing.JLabel jLabel_UsbDis;
    private javax.swing.JLabel jLabel_archivoDIs;
    private javax.swing.JLabel jLabel_impresoraDIs;
    private javax.swing.JLabel jLabel_infoContenedorDis;
    private javax.swing.JLabel jLabel_infoNombreDIs;
    private javax.swing.JLabel jLabel_inforIdDis;
    private javax.swing.JLabel jLabel_monitorDis;
    private javax.swing.JList jList_archivoBloq;
    private javax.swing.JList jList_impresoraBloq;
    private javax.swing.JList jList_listo;
    private javax.swing.JList jList_monitorBloq;
    private javax.swing.JList jList_nuevo;
    private javax.swing.JList jList_terminado;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem_insertarProcesosAleatorios;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JProgressBar jProgressBar_proceso;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner_eliminacionPorProceso;
    private javax.swing.JSpinner jSpinner_tamanio;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField_id;
    private javax.swing.JTextField jTextField_nombre;
    private javax.swing.JTabbedPane listaRequerimientos;
    private javax.swing.JComboBox listaRequiere;
    private vista.PanelOverload panelOverload1;
    private javax.swing.JLabel statusBar;
    private javax.swing.JLabel txtEstadoProceso;
    private javax.swing.JLabel txtIdProceso;
    private javax.swing.JLabel txtNombreContenedor;
    private javax.swing.JLabel txtNombreProceso;
    private javax.swing.JLabel txtTamActual;
    private javax.swing.JLabel txtTamanhoProceso;
    private javax.swing.JLabel txtTiempoBloqueado;
    private javax.swing.JLabel txtTiempoEjecucion;
    private javax.swing.JLabel txtTiempoListo;
    private javax.swing.JLabel txtTiempoTotal;
    // End of variables declaration//GEN-END:variables
}
