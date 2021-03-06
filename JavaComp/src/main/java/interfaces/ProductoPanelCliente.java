package interfaces;

import classes.Opinion;
import classes.Producto;
import classes.UtilProducto;
import classes.UtilRegistro;
import java.awt.Dimension;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EtchedBorder;

public class ProductoPanelCliente extends javax.swing.JPanel {

    private ArrayList<OpinionPanel> opinionesInstas = new ArrayList<OpinionPanel>();
    private Producto productoActual;

    /**
     * Creates new form ProductoPanelCliente
     */
    public ProductoPanelCliente() {
        initComponents();
    }

    public void setNombreProducto(String nombre) {
        jLabelNombreProducto.setText("Nombre: " + nombre);
    }

    public void setDescripcion(String txt) {
        jLabelDescripcion.setText("Descripción: " + txt);
    }

    public void setCategoria(String txt) {
        jLabelCategoria.setText("Categoría: " + txt);
    }

    public void setPrecio(double precio) {
        jLabelPrecio.setText("Precio: " + String.valueOf(precio));
    }

    public void setStock(int stock) {
        jLabelStock.setText("Stock: " + String.valueOf(stock));
    }

    public void setFechaDeEntrada(String fecha) {
        jLabelFechaDeEntrada.setText(fecha);

    }

    public void setFotoProducto(String URL) {
        //if(Files.exists(path)){
        System.out.println(getClass().getResource("/images/" + URL));
        jLabelFotoProducto.setIcon(new ImageIcon(getClass().getResource("/images/" + URL)));
        // }

    }

    public void setUnidadesAComprarMax() {
        SpinnerModel sm = new SpinnerNumberModel(1, 1, productoActual.getStock(), 1);
        jSpinnerUnidades.setModel(sm);
    }

    public int getUnidadesAComprar() {
        return (int) jSpinnerUnidades.getValue();
    }

    public void setBarraValue(double value) {
        int valueInt = ((int) (value + 0.5)) * 100;
        jProgressBarPuntuacion.setValue(valueInt);
    }

    public void setPuntuacion(double puntuacion) {
        jLabelTextoPuntuacionMediaValor.setText(String.valueOf(puntuacion));
        setBarraValue(puntuacion);
    }

    public void setProductoActual(Producto producto) {
        productoActual = producto;
    }

    public void mostrar() {

        setNombreProducto(productoActual.getTitulo());
        setDescripcion(productoActual.getDescripcion());
        setCategoria(productoActual.getCategoria());
        setPrecio(productoActual.getPrecio());
        setFotoProducto(productoActual.getFotoProducto());
        setStock(productoActual.getStock());
        setFechaDeEntrada(productoActual.getFechaDeEntrada().toString());
        setPuntuacion(productoActual.getOpinionMedia());
        setProductoActual(productoActual);
        mostrarOpiniones();
        setUnidadesAComprarMax();
    }

    public void mostrarOpiniones() {
        int ancho = 300;
        int alto = 600;
        for (int i = 0; i < opinionesInstas.size(); i++) {
            jPanelOpiniones.remove(opinionesInstas.get(i));
        }
        opinionesInstas.clear();

        if (productoActual.getOpiniones().size() >= 1) {

            for (int i = 0; i < productoActual.getOpiniones().size(); i++) {
                interfaces.OpinionPanel opinionPanel = new interfaces.OpinionPanel();
                opinionPanel.setBounds(10, (i * 120), 1200, 100);
                opinionPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
                alto += 200;
                jPanelOpiniones.add(opinionPanel);
                opinionPanel.setVisible(true);
                opinionPanel.MostrarOpinion(productoActual.getOpiniones().get(i));
                opinionesInstas.add(opinionPanel);

            }
        }

        Dimension dimension = new Dimension();
        dimension.height = alto;
        dimension.width = ancho;
        jPanelOpiniones.setPreferredSize(dimension);
        jPanelOpiniones.revalidate();
        jPanelOpiniones.repaint();
    }

    public void clearNuevaOpinion() {
        jTextFieldTextoOpinion.setText(null);
        jSpinnerPuntuacion.setValue(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNombreProducto = new javax.swing.JLabel();
        jLabelFotoProducto = new javax.swing.JLabel();
        jLabelDescripcion = new javax.swing.JLabel();
        jLabelPrecio = new javax.swing.JLabel();
        jLabelStock = new javax.swing.JLabel();
        jLabelCategoria = new javax.swing.JLabel();
        jLabelFechaDeEntrada = new javax.swing.JLabel();
        jLabelTextoPuntuacionMedia = new javax.swing.JLabel();
        jLabelOpiniones = new javax.swing.JLabel();
        jLabelTextoPuntuacionMediaValor = new javax.swing.JLabel();
        jProgressBarPuntuacion = new javax.swing.JProgressBar();
        jScrollPaneOpiniones = new javax.swing.JScrollPane();
        jPanelOpiniones = new javax.swing.JPanel();
        jSpinnerUnidades = new javax.swing.JSpinner();
        jLabelUnidades = new javax.swing.JLabel();
        jButtonAnadirCarrito = new javax.swing.JButton();
        jButtonAñadirOpinion = new javax.swing.JButton();
        jTextFieldTextoOpinion = new javax.swing.JTextField();
        jLabelNuevaOpinion = new javax.swing.JLabel();
        jLabelTextoOpinion = new javax.swing.JLabel();
        jLabelPuntuacion = new javax.swing.JLabel();
        jSpinnerPuntuacion = new javax.swing.JSpinner();

        jLabelNombreProducto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelNombreProducto.setText("Nombre:");

        jLabelFotoProducto.setBackground(new java.awt.Color(51, 51, 51));

        jLabelDescripcion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelDescripcion.setText("Descripción:");

        jLabelPrecio.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelPrecio.setText("Precio: ");

        jLabelStock.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelStock.setText("Stock: ");

        jLabelCategoria.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelCategoria.setText("Categoria");

        jLabelFechaDeEntrada.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelFechaDeEntrada.setText("FechaDeEntrada");

        jLabelTextoPuntuacionMedia.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelTextoPuntuacionMedia.setText("Puntuacion media:");

        jLabelOpiniones.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelOpiniones.setText("Opiniones:");

        jLabelTextoPuntuacionMediaValor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelTextoPuntuacionMediaValor.setText("4,5");

        jProgressBarPuntuacion.setBackground(new java.awt.Color(204, 204, 204));
        jProgressBarPuntuacion.setForeground(new java.awt.Color(255, 204, 0));
        jProgressBarPuntuacion.setMaximum(500);
        jProgressBarPuntuacion.setValue(200);

        javax.swing.GroupLayout jPanelOpinionesLayout = new javax.swing.GroupLayout(jPanelOpiniones);
        jPanelOpiniones.setLayout(jPanelOpinionesLayout);
        jPanelOpinionesLayout.setHorizontalGroup(
            jPanelOpinionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 467, Short.MAX_VALUE)
        );
        jPanelOpinionesLayout.setVerticalGroup(
            jPanelOpinionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );

        jScrollPaneOpiniones.setViewportView(jPanelOpiniones);

        jSpinnerUnidades.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jSpinnerUnidades.setModel(new javax.swing.SpinnerNumberModel(1, 1, 178, 1));
        jSpinnerUnidades.setToolTipText("Unidades a comprar");

        jLabelUnidades.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelUnidades.setText("Unidades a comprar:");

        jButtonAnadirCarrito.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonAnadirCarrito.setForeground(new java.awt.Color(102, 204, 255));
        jButtonAnadirCarrito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/AñadirCarritoBlancoMini.png"))); // NOI18N
        jButtonAnadirCarrito.setText("Añadir al carrito");
        jButtonAnadirCarrito.setToolTipText("Añadir al carrito");
        jButtonAnadirCarrito.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonAnadirCarrito.setIconTextGap(0);
        jButtonAnadirCarrito.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonAnadirCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnadirCarritoActionPerformed(evt);
            }
        });

        jButtonAñadirOpinion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonAñadirOpinion.setText("Añadir opinion");
        jButtonAñadirOpinion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAñadirOpinionActionPerformed(evt);
            }
        });

        jLabelNuevaOpinion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelNuevaOpinion.setText("NuevaOpinion");

        jLabelTextoOpinion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTextoOpinion.setText("TextoOpinion:");

        jLabelPuntuacion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelPuntuacion.setText("Puntuacion:");

        jSpinnerPuntuacion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jSpinnerPuntuacion.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelFotoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabelStock, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelPrecio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelCategoria, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelDescripcion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelNombreProducto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelFechaDeEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(111, 111, 111)
                            .addComponent(jLabelTextoPuntuacionMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabelTextoPuntuacionMediaValor, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jProgressBarPuntuacion, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 318, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabelUnidades)
                                    .addGap(123, 123, 123))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jSpinnerUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(166, 166, 166)))
                            .addComponent(jButtonAnadirCarrito)
                            .addGap(212, 212, 212))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabelOpiniones, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPaneOpiniones, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelNuevaOpinion)
                                    .addGap(135, 135, 135))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabelPuntuacion)
                                        .addComponent(jLabelTextoOpinion))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextFieldTextoOpinion, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jSpinnerPuntuacion, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonAñadirOpinion)
                        .addGap(190, 190, 190))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelOpiniones)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPaneOpiniones, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelNombreProducto)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelCategoria)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelPrecio)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelStock)
                                .addGap(24, 24, 24)
                                .addComponent(jLabelFechaDeEntrada))
                            .addComponent(jLabelFotoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jProgressBarPuntuacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelTextoPuntuacionMediaValor)
                                .addComponent(jLabelTextoPuntuacionMedia)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabelNuevaOpinion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTextoOpinion)
                            .addComponent(jTextFieldTextoOpinion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelPuntuacion)
                            .addComponent(jSpinnerPuntuacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(jButtonAñadirOpinion))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonAnadirCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabelUnidades)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpinnerUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAñadirOpinionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAñadirOpinionActionPerformed
        // TODO add your handling code here:
        String texto = jTextFieldTextoOpinion.getText();
        int puntuacion = (int) jSpinnerPuntuacion.getValue();
        LocalDate fecha = LocalDate.now();
        Opinion opinion = new Opinion(puntuacion, texto, fecha);
        if (UtilProducto.altaOpinion(opinion)) {
            JOptionPane.showMessageDialog(this, "La opinion se ha publicado correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            clearNuevaOpinion();
            UtilProducto.guardarDatos();
            mostrarOpiniones();
            setPuntuacion(productoActual.getOpinionMedia());
        } else {
            JOptionPane.showMessageDialog(this, "La opinion ya existia", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButtonAñadirOpinionActionPerformed

    private void jButtonAnadirCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnadirCarritoActionPerformed
        // TODO add your handling code here:
        int unidades = (int) jSpinnerUnidades.getValue();
        Producto productoModificado = new Producto(productoActual.getTitulo() + "x" + unidades, productoActual.getDescripcion(),
                productoActual.getCategoria(), productoActual.getPrecio(),
                productoActual.getFotoProducto(), productoActual.getStock(), productoActual.getFechaDeEntrada(), productoActual.getOpiniones());
        if (Login.objcli.addToCarrito(productoModificado)) {

            JOptionPane.showMessageDialog(this, "Se han añadido " + unidades + " unidades de " + productoActual.getTitulo() + " al carrito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            productoActual.setStock(productoActual.getStock() - unidades);
            System.out.println(productoActual.getStock());
            System.out.println(Login.objcli.getCarrito().toString());
            mostrar();
            UtilRegistro.guardarDatos();
            UtilProducto.guardarDatos();
        } else {
            JOptionPane.showMessageDialog(this, "Fallo al añadir al carrito", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        jSpinnerUnidades.setValue(1);

    }//GEN-LAST:event_jButtonAnadirCarritoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnadirCarrito;
    private javax.swing.JButton jButtonAñadirOpinion;
    private javax.swing.JLabel jLabelCategoria;
    private javax.swing.JLabel jLabelDescripcion;
    private javax.swing.JLabel jLabelFechaDeEntrada;
    private javax.swing.JLabel jLabelFotoProducto;
    private javax.swing.JLabel jLabelNombreProducto;
    private javax.swing.JLabel jLabelNuevaOpinion;
    private javax.swing.JLabel jLabelOpiniones;
    private javax.swing.JLabel jLabelPrecio;
    private javax.swing.JLabel jLabelPuntuacion;
    private javax.swing.JLabel jLabelStock;
    private javax.swing.JLabel jLabelTextoOpinion;
    private javax.swing.JLabel jLabelTextoPuntuacionMedia;
    private javax.swing.JLabel jLabelTextoPuntuacionMediaValor;
    private javax.swing.JLabel jLabelUnidades;
    private javax.swing.JPanel jPanelOpiniones;
    private javax.swing.JProgressBar jProgressBarPuntuacion;
    private javax.swing.JScrollPane jScrollPaneOpiniones;
    private javax.swing.JSpinner jSpinnerPuntuacion;
    private javax.swing.JSpinner jSpinnerUnidades;
    private javax.swing.JTextField jTextFieldTextoOpinion;
    // End of variables declaration//GEN-END:variables
}
