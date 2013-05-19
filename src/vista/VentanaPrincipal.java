package vista;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ControlProceso;
import modelo.Dispositivo;
import modelo.Memoria;
import modelo.Proceso;

public class VentanaPrincipal extends javax.swing.JFrame {

    private ControlProceso controlProces;
    private DefaultTableModel modeloTabla;
    Dispositivo dispositivosDisponibles[] = new Dispositivo[7];
    private int tamanioPaginas=100;
    private Memoria memoria;
    private VentanaMemoria venatanaMemoria;
    //Dispositivo dispositivosDisponibles[]=new Dispositivo[7];
    //private Proceso procesoEjecutado;

    public VentanaPrincipal() {
        initComponents();
        jList_nuevo.setModel(new DefaultListModel());
        jList_listo.setModel(new DefaultListModel());
        jList_bloqueados.setModel(new DefaultListModel());
        jList_terminado.setModel(new DefaultListModel());
        controlProces = new ControlProceso(this);
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Id");
        modeloTabla.addColumn("Tamanio");
        modeloTabla.addColumn("Estado");
        modeloTabla.addColumn("DispositivoEx");
        dispositivosDisponibles[0]=new Dispositivo("Impresora","0");
        dispositivosDisponibles[1]=new Dispositivo("Monitor","1");
        dispositivosDisponibles[2]=new Dispositivo("Archivo","2");
        dispositivosDisponibles[3]=new Dispositivo("Parlante","3");
        dispositivosDisponibles[4]=new Dispositivo("Microfono","4");
        dispositivosDisponibles[5]=new Dispositivo("Usb","5");
        dispositivosDisponibles[6]=new Dispositivo("Camara","6");
        memoria=new Memoria(10);        
        //Todos los dispositivos estaran disponibles
        for (int i=0;i<7;i++) {
            dispositivosDisponibles[i].setDisponible(true);
        }
        //procesoEjecutado = null;
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
        jComboBoxRequiere = new javax.swing.JComboBox();
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
        txtTimeListo = new javax.swing.JLabel();
        txtTimeBloqueados = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
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
        jLabel45 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel_imgImpresora = new javax.swing.JLabel();
        jLabel_imgmonitor = new javax.swing.JLabel();
        jLabel_imgParlante = new javax.swing.JLabel();
        jLabel_imgArchivo = new javax.swing.JLabel();
        jLabel_imgMicrofono = new javax.swing.JLabel();
        jLabel_imgCamara = new javax.swing.JLabel();
        jLabel_imgUSB = new javax.swing.JLabel();
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
        jScrollPane7 = new javax.swing.JScrollPane();
        jList_bloqueados = new javax.swing.JList();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        statusBar = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem_insertarProcesosAleatorios = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
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
        jCheckBox_requiereMonitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_requiereMonitorActionPerformed(evt);
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
        jCheckBox_requiereParlante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_requiereParlanteActionPerformed(evt);
            }
        });

        jCheckBox_requiereMicrofono.setText("Microfono");
        jCheckBox_requiereMicrofono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_requiereMicrofonoActionPerformed(evt);
            }
        });

        jCheckBox_requiereUsb.setText("Usb");
        jCheckBox_requiereUsb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_requiereUsbActionPerformed(evt);
            }
        });

        jCheckBox_requiereCamara.setText("Camara");
        jCheckBox_requiereCamara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_requiereCamaraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
                            .addComponent(jSpinner_tamanio, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField_nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                                .addComponent(jTextField_id))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox_requiereMonitor)
                            .addComponent(jCheckBox_requiereImpresora)
                            .addComponent(jCheckBox_requiereArchivo)
                            .addComponent(jCheckBox_requiereCamara))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox_requiereUsb)
                            .addComponent(jCheckBox_requiereParlante)
                            .addComponent(jCheckBox_requiereMicrofono)
                            .addComponent(jButton_crearProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(28, Short.MAX_VALUE))
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
                    .addComponent(jCheckBox_requiereParlante))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox_requiereMonitor)
                    .addComponent(jCheckBox_requiereMicrofono))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox_requiereArchivo)
                    .addComponent(jCheckBox_requiereUsb))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox_requiereCamara)
                    .addComponent(jButton_crearProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
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
                .addContainerGap(155, Short.MAX_VALUE))
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
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
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
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel32))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTamActual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jComboBoxRequiere, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 90, Short.MAX_VALUE))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel36)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTimeListo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTiempoBloqueado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTiempoListo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(txtTimeBloqueados, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(jLabel38))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel37)
                                    .addComponent(jLabel39))))
                        .addGap(83, 83, 83)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTiempoEjecucion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTiempoTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jLabel34)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxRequiere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel35)
                                .addGap(15, 15, 15)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel36)
                                    .addComponent(txtTimeListo, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTimeBloqueados, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel39)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel38)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTiempoBloqueado, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel42)
                            .addComponent(txtTiempoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTiempoListo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTiempoEjecucion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel41)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(61, 61, 61)))
                .addGap(8, 8, 8))
        );

        listaRequerimientos.addTab("Info-process", jPanel8);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estado Dispositivos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(102, 102, 255)));

        jLabel28.setText("Seleccione");

        jComboBox_dispositivos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Impresora", "Monitor", "Archivo", "Parlantes", "Microfono", "USB", "Camara" }));
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

        jLabel45.setText("jLabel45");

        jLabel_imgImpresora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/impresora.jpg"))); // NOI18N

        jLabel_imgmonitor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/monitor.jpg"))); // NOI18N

        jLabel_imgParlante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/parlante.jpg"))); // NOI18N

        jLabel_imgArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/archivo.jpg"))); // NOI18N

        jLabel_imgMicrofono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/microfono.jpg"))); // NOI18N

        jLabel_imgCamara.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/camara.jpg"))); // NOI18N

        jLabel_imgUSB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/usb.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_imgImpresora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_imgmonitor)
                .addGap(12, 12, 12)
                .addComponent(jLabel_imgArchivo)
                .addGap(12, 12, 12)
                .addComponent(jLabel_imgParlante)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jLabel_imgMicrofono)
                .addGap(18, 18, 18)
                .addComponent(jLabel_imgUSB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_imgCamara)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_imgUSB)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel_imgImpresora)
                                .addComponent(jLabel_imgCamara))
                            .addGap(102, 102, 102))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel_imgParlante)
                                .addComponent(jLabel_imgMicrofono)
                                .addComponent(jLabel_imgArchivo))
                            .addGap(101, 101, 101))
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(jLabel_imgmonitor)
                            .addContainerGap()))))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31)
                            .addComponent(jLabel33))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox_dispositivos, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel_infoNombreDIs, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel_inforIdDis, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel_infoContenedorDis, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNombreContenedor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jComboBox_dispositivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(jLabel_infoNombreDIs))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addComponent(jLabel_inforIdDis))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel_infoContenedorDis))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33)
                    .addComponent(txtNombreContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        listaRequerimientos.addTab("info-disp", jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(listaRequerimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jButton_start, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jButton_stop, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listaRequerimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_start)
                    .addComponent(jButton_stop))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Vista ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(102, 102, 255)));
        jPanel2.setAutoscrolls(true);
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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

        jPanel9.setAutoscrolls(true);

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

        panelOverload1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel_Proceso.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_Proceso.setText("-------------------------------");
        jLabel_Proceso.setOpaque(true);

        javax.swing.GroupLayout panelOverload1Layout = new javax.swing.GroupLayout(panelOverload1);
        panelOverload1.setLayout(panelOverload1Layout);
        panelOverload1Layout.setHorizontalGroup(
            panelOverload1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jProgressBar_proceso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel_Proceso, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
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

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/flehcaChuecaReves.png"))); // NOI18N
        jLabel8.setEnabled(false);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/flehcaChueca.png"))); // NOI18N
        jLabel9.setEnabled(false);

        jScrollPane7.setViewportView(jList_bloqueados);

        jLabel26.setText("Bloqueados");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addGap(396, 396, 396))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(437, 437, 437)
                        .addComponent(jLabel26)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel8))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel9))))
                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(103, 103, 103))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
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
                        .addGap(0, 126, Short.MAX_VALUE))
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(401, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(230, 230, 230))
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
                        .addGap(131, 131, 131))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        statusBar.setText("Bienvenido , este programa fue desarrolado por esttudiantes de la UDistrital");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusBar)
                .addContainerGap(730, Short.MAX_VALUE))
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

        jMenuItem1.setText("Ver memoria");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

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
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
                .addContainerGap())
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

    private void addItemTable(Proceso proceso) {
        Object vec[] = new Object[5];
        vec[0] = proceso.getNombre();
        vec[1] = proceso.getId();
        vec[2] = proceso.getTamanio();
        vec[3] = proceso.getEstado();
        vec[4] = proceso.isRequiereDispositivo();
        modeloTabla.addRow(vec);
        jTable1.setModel(modeloTabla);
    }

    public void actualizarDispositivos(Dispositivo dis) {

        System.out.println("Actualizando dispositivo" + dis.getId());

        if (dis.getId().compareTo("0") == 0) {
            if (dis.isDisponible()) {
                jLabel_imgImpresora.setEnabled(true);
            } else {
                jLabel_imgImpresora.setEnabled(false);
            }
        }

        if (dis.getId().compareTo("1") == 0) {
            if (dis.isDisponible()) {
                jLabel_imgmonitor.setEnabled(true);
            } else {
                 jLabel_imgmonitor.setEnabled(false);
            }
        }

        if (dis.getId().compareTo("2") == 0) {
            if (dis.isDisponible()) {
                jLabel_imgArchivo.setEnabled(true);
            } else {
                jLabel_imgArchivo.setEnabled(false);
            }
        }


        if (dis.getId().compareTo("3") == 0) {
            if (dis.isDisponible()) {
                jLabel_imgParlante.setEnabled(true);
            } else {
               jLabel_imgParlante.setEnabled(false);
            }
        }

        if (dis.getId().compareTo("4") == 0) {
            if (dis.isDisponible()) {
                 jLabel_imgMicrofono.setEnabled(true);
            } else {
                jLabel_imgMicrofono.setEnabled(false);
            }
        }

        if (dis.getId().compareTo("5") == 0) {
            if (dis.isDisponible()) {
                jLabel_imgUSB.setEnabled(true);
            } else {
                jLabel_imgUSB.setEnabled(false);
            }
        }

        if (dis.getId().compareTo("6") == 0) {
            if (dis.isDisponible()) {
                jLabel_imgCamara.setEnabled(true);
            } else {
               jLabel_imgCamara.setEnabled(false);
            }
        }

    }

    private void desactivarTodasLasFelchas() {
        jLabel4.setEnabled(false);
        jLabel5.setEnabled(false);
        jLabel6.setEnabled(false);
        jLabel8.setEnabled(false);
        jLabel9.setEnabled(false);
        jLabel15.setEnabled(false);
    }

    public void listoToEjecucion() {
        desactivarTodasLasFelchas();
        jLabel5.setEnabled(true);
        if (jList_listo.getModel().getSize() > 0) {
            String info = (String) jList_listo.getModel().getElementAt(jList_listo.getModel().getSize() - 1);
            DefaultListModel modelo = (DefaultListModel) jList_listo.getModel();
            modelo.remove(modelo.size() - 1);
            jList_listo.setModel(modelo);
            jLabel_Proceso.setText(info);
        }
    }

    public void ejecucionToTerminado() {
        desactivarTodasLasFelchas();
        jLabel6.setEnabled(true);
        String info = jLabel_Proceso.getText();
        DefaultListModel modelo = (DefaultListModel) jList_terminado.getModel();
        modelo.add(0, info);
        jList_terminado.setModel(modelo);
        jLabel_Proceso.setText("-------------");
    }

    public void ejecucionToListo() {
        desactivarTodasLasFelchas();
        jLabel15.setEnabled(true);
        String info = jLabel_Proceso.getText();
        DefaultListModel modelo = (DefaultListModel) jList_listo.getModel();
        modelo.add(0, info);
        jList_listo.setModel(modelo);
        jLabel_Proceso.setText("-------------");
    }
    //***************************

    public void ejecucionBloqueado() {
        desactivarTodasLasFelchas();
        jLabel9.setEnabled(true);
        String info = jLabel_Proceso.getText();
        DefaultListModel modelo = (DefaultListModel) jList_bloqueados.getModel();
        modelo.add(0, info);
        jList_bloqueados.setModel(modelo);
        jLabel_Proceso.setText("-------------");
    }

    //********************************
    public void bloqueadoToListo(String info) {
        desactivarTodasLasFelchas();
        jLabel8.setEnabled(true);
        DefaultListModel modelo = (DefaultListModel) jList_bloqueados.getModel();  
        int aEleiminar=modelo.indexOf(info);
        modelo.remove(aEleiminar);
        jList_bloqueados.setModel(modelo);
        modelo = (DefaultListModel) jList_listo.getModel();
        modelo.add(0, info);
        jList_listo.setModel(modelo);
        
    }

    

    public void activarPorgresBar(int total, int actual) {
        this.jProgressBar_proceso.setMaximum(total);
        this.jProgressBar_proceso.setValue(actual);
    }

    public Integer getValueTiempoProceso() {
        return (Integer) this.jSpinner1.getValue();
    }

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int filaSeleccionada = jTable1.getSelectedRow();
        actualizarInformacion(filaSeleccionada);
    }//GEN-LAST:event_jTable1MouseClicked

    public void desactivarPaneles() {
        jButton_start.setEnabled(false);
    }

    public Integer getCantidadAQUitarJSpinner() {
        return (Integer) this.jSpinner_eliminacionPorProceso.getValue();
    }

    public void activarPaneles() {
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

    public void actualizarProcesosTabla(Proceso procesoEjecutado) {
        int row = 0;
        String idProcesoEjecutado = procesoEjecutado.getId();
        String estadoActual = procesoEjecutado.getEstado();
        String tamanio = String.valueOf(procesoEjecutado.getTamanio_actual());
        while (row < jTable1.getRowCount()) {
            if (idProcesoEjecutado.equals(jTable1.getValueAt(row, 1))) {
                jTable1.setValueAt(estadoActual, row, 3);
                jTable1.setValueAt(tamanio, row, 2);
                break;
            } else {
                row++;
            }
        }
    }

    private void jMenuItem_insertarProcesosAleatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_insertarProcesosAleatoriosActionPerformed
        int max = 1000;
        int min = 15;
        memoria = controlProces.getMemoria();
        for (int i = 0; i < 15; i++) {
            int random1 =  (int) (Math.random() * (max - min)) + min;
            int randmonn=  (int)(Math.random()*(7))+1;
            int random3;
            Dispositivo requerimientos[]=new Dispositivo[randmonn];
            ArrayList creados=new ArrayList();           
            for (int j=0;j<randmonn;j++){
                
                random3=  (int) (Math.random() * (7));                
                System.out.println( random3);
                if(!creados.contains(random3) || creados.isEmpty()){
                    switch (random3){
                        case 0:
                            requerimientos[j] = new Dispositivo(("Impresora"), "0");
                            break;
                        case 1:
                            requerimientos[j] = new Dispositivo(("Monitor"), "1");
                            break;
                        case 2:
                            requerimientos[j] = new Dispositivo(("Archivo"), "2");
                            break;
                        case 3:
                            requerimientos[j] = new Dispositivo(("Parlantes"), "3");
                            break;
                        case 4:
                            requerimientos[j] = new Dispositivo(("Microfono"), "4");
                            break;
                        case 5:
                            requerimientos[j] = new Dispositivo(("USB"), "5");
                            break;
                        case 6:
                            requerimientos[j] = new Dispositivo(("Camara"), "6");
                            break;
                    }
                    creados.add(random3);
                }else{
                    j--;
                }
                
            }
            
            Proceso procesoAux = new Proceso("Chrome", String.valueOf(random1), "LISTO", 
                    random1, requerimientos,(int) Math.ceil((random1+0.0)/(tamanioPaginas+0.0)));
            
            if(memoria.hayMemoriaDisponible(procesoAux.getPaginasCount())){
                if (!controlProces.addProceso(procesoAux)) {
                    i--;
                } else {
                    memoria.solicitarEspacio(procesoAux.getTablaDePaginas(), procesoAux.getNombre()+" "+procesoAux.getId());
                    addItem(jList_listo, procesoAux.getId() + " " + procesoAux.getNombre());
                    deleteItem(jList_nuevo, procesoAux.getId() + " " + procesoAux.getNombre());
                    addItemTable(procesoAux);
                }
            }else{
                break;
            }
        }
        jLabel4.setEnabled(true);
    }//GEN-LAST:event_jMenuItem_insertarProcesosAleatoriosActionPerformed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // TODO add your handling code here:

        if (evt.getKeyCode() == 38) {
            int filaSeleccionada = jTable1.getSelectedRow() - 1;
            if (filaSeleccionada <= jTable1.getRowCount()) {
                filaSeleccionada += 1;
            }
            actualizarInformacion(filaSeleccionada);
        }

        if (evt.getKeyCode() == 40) {
            int filaSeleccionada = jTable1.getSelectedRow() + 1;
            if (filaSeleccionada >= jTable1.getRowCount()) {
                filaSeleccionada -= 1;
            }
            actualizarInformacion(filaSeleccionada);
        }
    }//GEN-LAST:event_jTable1KeyPressed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
        statusBar.setText("Creacion de procesos");
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void botonMatarProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMatarProcesoActionPerformed
        // TODO add your handling code here:
        if ("".equals(txtIdProceso.getText()) || "".equals(txtNombreProceso.getText()) || "".equals(txtEstadoProceso.getText()) || "".equals(txtTamanhoProceso.getText())) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un proceso");
        } else {
            Proceso proceso = (Proceso) controlProces.obtenerProceso(txtIdProceso.getText());
            Dispositivo liberar[] = proceso.getRequerimientos();
            if (liberar.length > 0) {                
                for (int i = 0; i < liberar.length; i++) {
                       dispositivosDisponibles[Integer.parseInt(liberar[i].getId())].setDisponible(true);
                       actualizarDispositivos(dispositivosDisponibles[Integer.parseInt(liberar[i].getId())]);
                 }                   
                
            }
            controlProces.eliminarProceso(proceso);
            statusBar.setText("se ha eliminado un proceso");
        }
    }//GEN-LAST:event_botonMatarProcesoActionPerformed

    private void jButton_crearProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_crearProcesoActionPerformed
        
        memoria = controlProces.getMemoria();
        
        String nombreproceso = this.jTextField_nombre.getText();
        String id = this.jTextField_id.getText();
        if (nombreproceso.compareTo("") != 0 && id.compareTo("") != 0) {
            Dispositivo arregloAEnviar[] = new Dispositivo[dispositivosRequeridos.size()];
            dispositivosRequeridos.toArray(arregloAEnviar);
            int tamanio=(Integer)this.jSpinner_tamanio.getValue();
            Proceso proceso = new Proceso(nombreproceso, id, "LISTO", tamanio,arregloAEnviar, 
                    (int) Math.ceil((tamanio+0.0)/(tamanioPaginas+0.0)));
            if(memoria.hayMemoriaDisponible(proceso.getPaginasCount())){
                if (controlProces.addProceso(proceso)) {    
                    memoria.solicitarEspacio(proceso.getTablaDePaginas(), nombreproceso+" "+id);
                    addItem(jList_listo, id + " " + nombreproceso);
                    deleteItem(jList_nuevo, id + " " + nombreproceso);
                    addItemTable(proceso);
                    jLabel4.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Proceso con ID ya existente",
                            "Error de ingreso", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(this, "No hay memoria disponible",
                            "Tope de memoria", JOptionPane.ERROR_MESSAGE);
            }
            //Activamos los componententes para el ingreso de datos del nuevo proceso
            //controlProces.cambiarEstado(proceso,"EJECUCION");
        } else {
            JOptionPane.showMessageDialog(this, "Error debe ingresar datos validos",
                    "Error de ingreso", JOptionPane.ERROR_MESSAGE);
        }
        statusBar.setText("se ha creado un nuevo proceso.");
    }//GEN-LAST:event_jButton_crearProcesoActionPerformed

    private void jCheckBox_requiereArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_requiereArchivoActionPerformed
         if(jCheckBox_requiereArchivo.isSelected()){
            dispositivosRequeridos.add(new Dispositivo("Archivo", "2"));
        }else{
            for (int i=0;i<dispositivosRequeridos.size();i++){
                 if (dispositivosRequeridos.get(i).getNombre().compareTo("Archivo")==0)
                     dispositivosRequeridos.remove(i);
              }
        } 
    }//GEN-LAST:event_jCheckBox_requiereArchivoActionPerformed

    private void jCheckBox_requiereArchivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox_requiereArchivoMouseClicked
        // TODO add your handling code here:
        statusBar.setText("se ha selccionado un recurso");
    }//GEN-LAST:event_jCheckBox_requiereArchivoMouseClicked

    private void jCheckBox_requiereMonitorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox_requiereMonitorMouseClicked
        // TODO add your handling code here:
        statusBar.setText("se ha selccionado un recurso");
    }//GEN-LAST:event_jCheckBox_requiereMonitorMouseClicked

    private void jCheckBox_requiereImpresoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_requiereImpresoraActionPerformed
        if(jCheckBox_requiereImpresora.isSelected()){
            dispositivosRequeridos.add(new Dispositivo("Impresora", "0"));
             System.out.println("Sel agrego Impresora");
        }else{
             for (int i=0;i<dispositivosRequeridos.size();i++){
                 if (dispositivosRequeridos.get(i).getNombre().compareTo("Impresora")==0)
                     dispositivosRequeridos.remove(i);
              }
        }            
    }//GEN-LAST:event_jCheckBox_requiereImpresoraActionPerformed

    private void jCheckBox_requiereImpresoraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox_requiereImpresoraMouseClicked
        // TODO add your handling code here:
        statusBar.setText("se ha selccionado un recurso");
    }//GEN-LAST:event_jCheckBox_requiereImpresoraMouseClicked

    private void jSpinner_tamanioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSpinner_tamanioMouseClicked
        // TODO add your handling code here:
        statusBar.setText("Seleccione un tamanho para el proceso");
    }//GEN-LAST:event_jSpinner_tamanioMouseClicked

    private void jTextField_idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_idFocusLost
        functionAddNuevo();
    }//GEN-LAST:event_jTextField_idFocusLost

    private void jTextField_idFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_idFocusGained
    }//GEN-LAST:event_jTextField_idFocusGained

    private void jTextField_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_idActionPerformed
        statusBar.setText("ingrese el id del proceso");
    }//GEN-LAST:event_jTextField_idActionPerformed

    private void jTextField_nombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_nombreFocusLost
        functionAddNuevo();
    }//GEN-LAST:event_jTextField_nombreFocusLost

    private void jTextField_nombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_nombreFocusGained
    }//GEN-LAST:event_jTextField_nombreFocusGained

    private void jTextField_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_nombreActionPerformed
    }//GEN-LAST:event_jTextField_nombreActionPerformed

    private void jTextField_nombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_nombreMouseClicked
        // TODO add your handling code here:
        statusBar.setText("Ingrese el nombre del proceso");
    }//GEN-LAST:event_jTextField_nombreMouseClicked

    private void jButton_stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_stopActionPerformed
        activarPaneles();
        statusBar.setText("se ha detenido la ejecucion de los procesos");
    }//GEN-LAST:event_jButton_stopActionPerformed

    private void jButton_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_startActionPerformed
        jLabel4.setEnabled(false);
        statusBar.setText("Se ha iniciado la ejecuacion de los procesos.");
        if (controlProces.isTerminado()) {
            controlProces.setDispositivosDisponibles(dispositivosDisponibles);
        }
        (new Thread() {
            @Override
            public void run() {
                try {
                    controlProces.ejecutar();
                } catch (InterruptedException ex) {
                    Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();

    }//GEN-LAST:event_jButton_startActionPerformed

    private void listaRequerimientosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaRequerimientosMouseClicked
        // TODO add your handling code here:
        statusBar.setText("Informacion de procesos");
    }//GEN-LAST:event_listaRequerimientosMouseClicked

    private void jComboBox_dispositivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_dispositivosActionPerformed
        Dispositivo dispositivos[] = controlProces.getDispositivosDisponibles();

        int i=jComboBox_dispositivos.getSelectedIndex();
        jLabel_infoNombreDIs.setText(dispositivosDisponibles[i].getNombre());
        jLabel_inforIdDis.setText(dispositivosDisponibles[i].getId());
        if (dispositivos != null) {
            jLabel_infoContenedorDis.setText(dispositivos[i].getIdProcesoContenedor());
            Proceso p = (Proceso) controlProces.obtenerProceso(dispositivos[i].getIdProcesoContenedor());
            if(p!=null)
                txtNombreContenedor.setText(p.getNombre());
            else
                txtNombreContenedor.setText("none");
        }
        
    }//GEN-LAST:event_jComboBox_dispositivosActionPerformed

    private void jCheckBox_requiereUsbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_requiereUsbActionPerformed
       if(jCheckBox_requiereUsb.isSelected()){
            dispositivosRequeridos.add(new Dispositivo("USB", "5"));
        }else{
            for (int i=0;i<dispositivosRequeridos.size();i++){
                 if (dispositivosRequeridos.get(i).getNombre().compareTo("USB")==0)
                     dispositivosRequeridos.remove(i);
              }
        } 
    }//GEN-LAST:event_jCheckBox_requiereUsbActionPerformed

    private void jCheckBox_requiereMonitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_requiereMonitorActionPerformed
        if(jCheckBox_requiereMonitor.isSelected()){
            dispositivosRequeridos.add(new Dispositivo("Monitor", "1"));
        }else{
            for (int i=0;i<dispositivosRequeridos.size();i++){
                 if (dispositivosRequeridos.get(i).getNombre().compareTo("Monitor")==0)
                     dispositivosRequeridos.remove(i);
              }
        } 
    }//GEN-LAST:event_jCheckBox_requiereMonitorActionPerformed

    private void jCheckBox_requiereParlanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_requiereParlanteActionPerformed
        if(jCheckBox_requiereParlante.isSelected()){
            dispositivosRequeridos.add(new Dispositivo("Parlante", "3"));
        }else{
            for (int i=0;i<dispositivosRequeridos.size();i++){
                 if (dispositivosRequeridos.get(i).getNombre().compareTo("Parlante")==0)
                     dispositivosRequeridos.remove(i);
              }
        } 
    }//GEN-LAST:event_jCheckBox_requiereParlanteActionPerformed

    private void jCheckBox_requiereMicrofonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_requiereMicrofonoActionPerformed
        if(jCheckBox_requiereMicrofono.isSelected()){
            dispositivosRequeridos.add(new Dispositivo("Microfono", "4"));
        }else{
            for (int i=0;i<dispositivosRequeridos.size();i++){
                 if (dispositivosRequeridos.get(i).getNombre().compareTo("Microfono")==0)
                     dispositivosRequeridos.remove(i);
              }
        } 
    }//GEN-LAST:event_jCheckBox_requiereMicrofonoActionPerformed

    private void jCheckBox_requiereCamaraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_requiereCamaraActionPerformed
        if(jCheckBox_requiereCamara.isSelected()){
            dispositivosRequeridos.add(new Dispositivo("Camara", "6"));
        }else{
            for (int i=0;i<dispositivosRequeridos.size();i++){
                 if (dispositivosRequeridos.get(i).getNombre().compareTo("Camara")==0)
                     dispositivosRequeridos.remove(i);
              }
        } 
    }//GEN-LAST:event_jCheckBox_requiereCamaraActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        memoria=controlProces.getMemoria();
        ArrayList<String> memoriaPrincipal=memoria.getMemoriaPrincipal();
        ArrayList<String> memoriaVirtual=memoria.getMemoriaVirtual();
        /*
        System.out.println("Memoria princiapl");
        for(int i=0;i<memoriaPrincipal.size();i++){
            System.out.println(memoriaPrincipal.get(i));
        }
        
        System.out.println("Memoria Virtual");
        for(int i=0;i<memoriaVirtual.size();i++){
            System.out.println(memoriaVirtual.get(i));
        }*/
        
        venatanaMemoria=new VentanaMemoria(memoriaPrincipal,memoriaVirtual);
        //venatanaMemoria.dibujarMemoria(memoriaPrincipal);
        venatanaMemoria.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /*Este metodo refresca la ventana de memoria, ya que se han subido y bajado procesos.*/
    public void actualizarVentanaMemoria(){
        memoria=controlProces.getMemoria();
        ArrayList<String> memoriaPrincipal=memoria.getMemoriaPrincipal();
        ArrayList<String> memoriaVirtual=memoria.getMemoriaVirtual();
        venatanaMemoria.setMemoriaPrincipal(memoriaPrincipal);
        venatanaMemoria.setMemoriaVirtual(memoriaVirtual);
        venatanaMemoria.dibujarMemoria();
    }
    
    private void functionAddNuevo() {
        if (jTextField_nombre.getText().compareTo("") != 0 && jTextField_id.getText().compareTo("") != 0) {
            System.out.println("ADD a la lista nuevo: Valor de id_" + jTextField_id.getText() + "_valor de nombre:_" + jTextField_nombre.getText() + "_");
            if (controlProces.addNuevo(jTextField_id.getText())) {
                this.statusBar.setText("Bien se anadio a NUEVO");
                this.addItem(jList_nuevo, jTextField_id.getText() + " " + jTextField_nombre.getText());
            } else {
                this.statusBar.setText("Id existente en nuevo");
            }
        } else {
            this.statusBar.setText("No se logro aniadir a NUEVO id o nombre vacio");
        }
    }

    public void actualizarInformacion(int filaSelected) {
        //(new Thread() {
        //@Override
        //public void run() {
        if (filaSelected != -1) {
            String id = String.valueOf(jTable1.getValueAt(filaSelected, 1));
            Proceso procesoSeleccionado =controlProces.obtenerProceso(id);
            int totalTime = 0;

            if (procesoSeleccionado.isRequiereDispositivo()) {
                Dispositivo dispositivos_requeridos[]= procesoSeleccionado.getRequerimientos();
                String dispositivosCadena[]=new String[dispositivos_requeridos.length];
                for (int i=0;i<dispositivos_requeridos.length;i++){
                    dispositivosCadena[i]=String.valueOf(dispositivos_requeridos[i].getNombre());
                    //System.out.println(dispositivos_requeridos[i].getNombre());
                }
                DefaultComboBoxModel modeloComboBOx = new DefaultComboBoxModel(dispositivosCadena);
                jComboBoxRequiere.setModel(modeloComboBOx);

                
            } else {
                String requiere[] = {"Ninguno"};
                DefaultComboBoxModel modeloComboBOx = new DefaultComboBoxModel(requiere);
                jComboBoxRequiere.setModel(modeloComboBOx);
            }

            
            txtTamActual.setText(String.valueOf(procesoSeleccionado.getTamanio_actual()));
            txtIdProceso.setText("" + jTable1.getValueAt(filaSelected, 1));
            txtNombreProceso.setText("" + jTable1.getValueAt(filaSelected, 0));
            txtEstadoProceso.setText("" + jTable1.getValueAt(filaSelected, 3));
            txtTamanhoProceso.setText("" + controlProces.getTamanio(txtIdProceso.getText()));
            txtTamActual.setText("" + jTable1.getValueAt(filaSelected, 2));
            txtTimeListo.setText(String.valueOf(procesoSeleccionado.getTiempoListo()));
            txtTimeBloqueados.setText(String.valueOf(procesoSeleccionado.getTiempoBloqueado()));
            txtTiempoEjecucion.setText(String.valueOf(procesoSeleccionado.getTiempoEjecucion()));
            totalTime = Integer.parseInt(txtTimeListo.getText()) + Integer.parseInt(txtTiempoEjecucion.getText()) /*+ Integer.parseInt(txtTiempoBloqueado.getText())*/;
            txtTiempoTotal.setText(String.valueOf(totalTime));
        }
    }
    
    
    public void actualizarInformacion(Proceso procesoSeleccionado) {
        int totalTime = 0;

        if (procesoSeleccionado.isRequiereDispositivo()) {
            Dispositivo dispositivos_requeridos[]= procesoSeleccionado.getRequerimientos();
            String dispositivosCadena[]=new String[dispositivos_requeridos.length];
            for (int i=0;i<dispositivos_requeridos.length;i++){
                dispositivosCadena[i]=String.valueOf(dispositivos_requeridos[i].getNombre());
                //System.out.println(dispositivos_requeridos[i].getNombre());
            }
            DefaultComboBoxModel modeloComboBOx = new DefaultComboBoxModel(dispositivosCadena);
            jComboBoxRequiere.setModel(modeloComboBOx);


        } else {
            String requiere[] = {"Ninguno"};
            DefaultComboBoxModel modeloComboBOx = new DefaultComboBoxModel(requiere);
            jComboBoxRequiere.setModel(modeloComboBOx);
        }

        int filaSelected=jTable1.getSelectedRow();
        if(filaSelected!=-1){
            txtTamActual.setText(String.valueOf(procesoSeleccionado.getTamanio_actual()));
            txtIdProceso.setText("" + jTable1.getValueAt(filaSelected, 1));
            txtNombreProceso.setText("" + jTable1.getValueAt(filaSelected, 0));
            txtEstadoProceso.setText("" + jTable1.getValueAt(filaSelected, 3));
            txtTamanhoProceso.setText("" + controlProces.getTamanio(txtIdProceso.getText()));
            txtTamActual.setText("" + jTable1.getValueAt(filaSelected, 2));
            txtTimeListo.setText(String.valueOf(procesoSeleccionado.getTiempoListo()));
            txtTimeBloqueados.setText(String.valueOf(procesoSeleccionado.getTiempoBloqueado()));
            txtTiempoEjecucion.setText(String.valueOf(procesoSeleccionado.getTiempoEjecucion()));
            totalTime = Integer.parseInt(txtTimeListo.getText()) + Integer.parseInt(txtTiempoEjecucion.getText()) /*+ Integer.parseInt(txtTiempoBloqueado.getText())*/;
            txtTiempoTotal.setText(String.valueOf(totalTime));
        }
      
    }

    public void actualziarPanelProceso() {
    }


    /*private void actualizarInformacion(int filaSeleccionada){
     String id = String.valueOf(jTable1.getValueAt(filaSeleccionada, 1));
     final Proceso procesoSeleccionado = (Proceso) controlProces.obtenerProceso(id);
     int totalTime=0;

     if (procesoSeleccionado.isRequiereDispositivo()) {
     (new Thread() {
     @Override
     public void run() {
             
     Dispositivo arreglo[] = procesoSeleccionado.getRequerimientos();
     String requerimiento[] = new String[arreglo.length];
     for (int i = 0; i < arreglo.length - 1; i++) {
     requerimiento[i] = String.valueOf(arreglo[i].getNombre());
     DefaultComboBoxModel modeloComboBOx = new DefaultComboBoxModel(requerimiento);
     listaRequiere.setModel(modeloComboBOx);
     }
                 
     }
     }).start();
            
     }else{
     String requiere[]={"Ninguno"};
     DefaultComboBoxModel modeloComboBOx = new DefaultComboBoxModel(requiere);
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
     } */
    //Aniade un item a un jlistX
    private boolean addItem(JList lista, String item) {
        DefaultListModel modelo = (DefaultListModel) lista.getModel();
        //modelo.addElement(item);
        modelo.add(0, item);
        lista.setModel(modelo);
        return true;
    }

    private void deleteItem(JList lista, String item) {
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

    public void modificarBoton(String cosas) {
        this.jButton_start.setText(cosas);
    }
    private  ArrayList<Dispositivo> dispositivosRequeridos=new ArrayList<Dispositivo>();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonMatarProceso;
    private javax.swing.JButton jButton_crearProceso;
    private javax.swing.JButton jButton_start;
    private javax.swing.JButton jButton_stop;
    private javax.swing.JCheckBox jCheckBox_requiereArchivo;
    private javax.swing.JCheckBox jCheckBox_requiereCamara;
    private javax.swing.JCheckBox jCheckBox_requiereImpresora;
    private javax.swing.JCheckBox jCheckBox_requiereMicrofono;
    private javax.swing.JCheckBox jCheckBox_requiereMonitor;
    private javax.swing.JCheckBox jCheckBox_requiereParlante;
    private javax.swing.JCheckBox jCheckBox_requiereUsb;
    private javax.swing.JComboBox jComboBoxRequiere;
    private javax.swing.JComboBox jComboBox_dispositivos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_Proceso;
    private javax.swing.JLabel jLabel_imgArchivo;
    private javax.swing.JLabel jLabel_imgCamara;
    private javax.swing.JLabel jLabel_imgImpresora;
    private javax.swing.JLabel jLabel_imgMicrofono;
    private javax.swing.JLabel jLabel_imgParlante;
    private javax.swing.JLabel jLabel_imgUSB;
    private javax.swing.JLabel jLabel_imgmonitor;
    private javax.swing.JLabel jLabel_infoContenedorDis;
    private javax.swing.JLabel jLabel_infoNombreDIs;
    private javax.swing.JLabel jLabel_inforIdDis;
    private javax.swing.JList jList_bloqueados;
    private javax.swing.JList jList_listo;
    private javax.swing.JList jList_nuevo;
    private javax.swing.JList jList_terminado;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem_insertarProcesosAleatorios;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner_eliminacionPorProceso;
    private javax.swing.JSpinner jSpinner_tamanio;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField_id;
    private javax.swing.JTextField jTextField_nombre;
    private javax.swing.JTabbedPane listaRequerimientos;
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
    private javax.swing.JLabel txtTimeBloqueados;
    private javax.swing.JLabel txtTimeListo;
    // End of variables declaration//GEN-END:variables
}
